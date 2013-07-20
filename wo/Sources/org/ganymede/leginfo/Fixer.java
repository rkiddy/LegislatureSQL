package org.ganymede.leginfo;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillAction;
import org.ganymede.leginfo.eo.BillActionType;
import org.ganymede.leginfo.eo.BillAuthoring;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;

public class Fixer {

	static EOEditingContext anEC = ERXEC.newEditingContext();

	public static void fixAll() {
		fixCommitteeAbbreviations(anEC);
		processAuthors(anEC);
	}

	private static NSDictionary<String,BillActionType> actionTypes = null;
	private static NSDictionary<String,BillActionType> actionTypes(EOEditingContext ec) {
		if (actionTypes == null) {
			NSMutableDictionary<String,BillActionType> types = new NSMutableDictionary<String,BillActionType>();
			for (BillActionType aType : BillActionType.fetchAllBillActionTypes(ec)) {
				types.setObjectForKey(aType, aType.action());
			}
			actionTypes = types.immutableClone();
		}
		return actionTypes;
	}

	private static NSArray<String> easyMatches = new NSArray<String>(new String[] {
			"Hearing canceled at the request of author.",
			"Adopted and to Assembly.",
			"Adopted.",
			"Approved by the Governor.",
			"Assembly Rule 69 suspended.",
			"Be placed on second reading file pursuant to Senate Rule 28.8.",
			"Do pass.",
			"Enrolled measure version corrected.",
			"From printer.",
			"Hearing canceled at the request of author.",
			"Held at Desk.",
			"Held in committee and under submission.",
			"Held under submission.",
			"Ordered to Engrossing and Enrolling.",
			"Ordered to engrossing and enrolling.",
			"Ordered to second reading.",
			"Ordered to special consent calendar.",
			"Ordered to the Assembly.",
			"Ordered to the Senate.",
			"Ordered to third reading.",
			"Read second time and amended.",
			"Reconsideration granted.",
			"To print."
	} );

	public static void fixCommitteeAbbreviations(EOEditingContext ec) {

		NSArray<BillAction> foundActions = null;
		foundActions = BillAction.fetchBillActions(ec, BillAction.BILL_ACTION_TYPE.isNull(), null);
		System.out.println("foundAction # "+foundActions.size());

		for (BillAction action : foundActions) {

			boolean done = false;

			for (String easyMatch : easyMatches) {
				if (! done && action.action().endsWith(easyMatch)) {
					action.setBillActionType(actionTypes(ec).objectForKey(easyMatch));
					done = true;
				}
			}

			if (! done && action.action().contains("Chaptered by Secretary of State")) {
				action.setBillActionType(actionTypes(ec).objectForKey("Chaptered by Secretary of State"));
				done = true;				
			}

			if (! done && action.action().contains("Enrolled and filed with the Secretary of State")) {
				action.setBillActionType(actionTypes(ec).objectForKey("Enrolled and filed with the Secretary of State"));
				done = true;				
			}

			if (! done && action.action().matches("May be heard in committee *[A-Z][a-z]* *[0-9]*$") ) {
				action.setBillActionType(actionTypes(ec).objectForKey("May be heard in committee"));
				done = true;				
			}
		}

		ec.saveChanges();
		System.out.println("saved");
	}

	private static NSMutableDictionary<String,String> prefixes = new NSMutableDictionary<String,String>();
	static {
		prefixes.setObjectForKey("A", "ab");
		prefixes.setObjectForKey("A", "aca");
		prefixes.setObjectForKey("A", "acr");
		prefixes.setObjectForKey("A", "ajr");
		prefixes.setObjectForKey("A", "hr");
		prefixes.setObjectForKey("S", "sb");
		prefixes.setObjectForKey("S", "sca");
		prefixes.setObjectForKey("S", "scr");
		prefixes.setObjectForKey("S", "sjr");
		prefixes.setObjectForKey("S", "sr");
	}

	public static void processAuthors(EOEditingContext ec) {

		int edited = 0;
		NSArray<Bill> bills = Bill.fetchAllBills(ec);

		NSMutableDictionary<String,Author> authors = new NSMutableDictionary<String,Author>();

		int saves = 0;

		for (Bill aBill : bills) {
			for (BillVersion aVersion : aBill.versions()) {

				//BillVersion aVersion = BillVersion.fetchBillVersion(ec(), BillVersion.FILE.is("13-14/bill/sen/sb_0801-0850/sb_822_bill_20130612_amended_asm_v97.html"));

				if (aVersion.authorings().size() == 0) {

					String authorsNext = aVersion.authorsNext();

					// remove all <strike>text</strike>
					boolean finished = false;
					while (! finished) {
						int strikeStart = authorsNext.indexOf("<strike>");
						int strikeEnd = authorsNext.indexOf("</strike>");
						if (strikeStart < 0 && strikeEnd < 0) {
							finished = true;
						} else {

							// sample here <strike>and here</strike> is the rest.
							//           1         2         3         4         5
							// 012345678901234567890123456789012345678901234567890

							String partOne = authorsNext.substring(0, strikeStart);
							String partTwo = authorsNext.substring(strikeEnd+"</strike>".length());
							authorsNext = partOne + partTwo;
						}
					}

					authorsNext = authorsNext.replaceAll("<em>", "").replaceAll("</em>", "");

					authorsNext = authorsNext.replaceAll(",\\s\\s*", ",").replaceAll("\\s*\\s,", ",");

					authorsNext = authorsNext.replaceAll("^\\s*", "").replaceAll("\\s*$", "");

					authorsNext = authorsNext.replaceAll("\\)", "").replaceAll("\\(,", "");

					authorsNext = authorsNext.replaceAll(",and\\s*", ",");
					authorsNext = authorsNext.replaceAll("\\s\\s*and\\s\\s*", ",");

					authorsNext = authorsNext.replaceAll(",,*", ",");
		
					authorsNext = authorsNext.replaceFirst("^INTRODUCED BY\\s", "");

					while (authorsNext.matches("\\s\\s")) { authorsNext = authorsNext.replaceAll("\\s\\s", " "); }

					if (authorsNext.indexOf("Committee") >= 0) {

						int paren = authorsNext.indexOf('(');
						if (paren >= 0)
							authorsNext = authorsNext.substring(0, paren);

					} else {

						authorsNext = authorsNext.replaceAll("\\(", "");
						authorsNext = authorsNext.replaceAll("\\)", "");

						authorsNext = authorsNext.replaceAll("Assembly\\s*Members ", ",ASM,");
						authorsNext = authorsNext.replaceAll("Assembly\\s*Member ", ",ASM,");
						authorsNext = authorsNext.replaceAll("Senators\\s*:*", ",SEN,");
						authorsNext = authorsNext.replaceAll("Senator\\s*:*", ",SEN,");

						authorsNext = authorsNext.replaceAll("Principal\\s*coauthors\\s*:", ",PCO,");
						authorsNext = authorsNext.replaceAll("Principal\\s*coauthor\\s*:", ",PCO,");
						authorsNext = authorsNext.replaceAll("Coauthors\\s*:", ",CO,");
						authorsNext = authorsNext.replaceAll("Coauthor\\s*:", ",CO,");
					}

					aVersion.setAuthorsNext(authorsNext);
					edited++;

					ec.saveChanges();

					NSArray<String> parts = NSArray.componentsSeparatedByString(authorsNext, ",");

					String activeHouse = prefixes.objectForKey(aBill.prefixlessHouse());
					String activeRole = "A";

					if (authorsNext.indexOf("Committee") >= 0) {
						
						if (! authors.containsKey(authorsNext))
							authors.setObjectForKey(Author.createAuthor(ec, authorsNext), authorsNext);

						Author author = authors.objectForKey(authorsNext);

						BillAuthoring.createBillAuthoring(ec, activeHouse, activeRole, "13-14", author, aVersion);

					} else {

						for (int idx = 0; idx < parts.size(); idx++) {

							if (parts.get(idx).equals("ASM")) { activeHouse = "A"; continue; }
							if (parts.get(idx).equals("SEN")) { activeHouse = "A"; continue; }

							if (parts.get(idx).equals("CO")) { activeRole = "C"; continue; }
							if (parts.get(idx).equals("PCO")) { activeRole = "PC"; continue; }

							String authorName = parts.get(idx);

							authorName = authorName.replaceAll("\\s*$", "");
							authorName = authorName.replaceAll("^\\s*", "");

							authorName = authorName.replaceAll("^and\\s", "");

							Author author = null;

							if (! authors.containsKey(authorName))
								authors.setObjectForKey(Author.createAuthor(ec, authorName), authorName);

							author = authors.objectForKey(authorName);

							BillAuthoring.createBillAuthoring(ec, activeHouse, activeRole, "13-14", author, aVersion);
						}
					}
				}
				ec.saveChanges();
				saves++;

				System.out.print((saves % 100) == 0 ? ".\n" : ".");
			}
		}

		System.out.println("");

		System.out.println("Processed authorings # "+edited);
	}
}
