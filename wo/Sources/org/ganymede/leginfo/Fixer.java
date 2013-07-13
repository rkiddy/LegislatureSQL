package org.ganymede.leginfo;

import org.ganymede.leginfo.eo.BillAction;
import org.ganymede.leginfo.eo.BillActionType;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.eof.ERXEC;

public class Fixer {

	static EOEditingContext ec = ERXEC.newEditingContext();

	public static void fixAll() {
		fixCommitteeAbbreviations();
	}

	private static NSDictionary<String,BillActionType> actionTypes = null;
	private static NSDictionary<String,BillActionType> actionTypes() {
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

	public static void fixCommitteeAbbreviations() {
		NSArray<BillAction> foundActions = null;
		foundActions = BillAction.fetchBillActions(ec, BillAction.BILL_ACTION_TYPE.isNull(), null);
		System.out.println("foundAction # "+foundActions.size());

		for (BillAction action : foundActions) {

			boolean done = false;

			for (String easyMatch : easyMatches) {
				if (! done && action.action().endsWith(easyMatch)) {
					action.setBillActionType(actionTypes().objectForKey(easyMatch));
					done = true;
				}
			}

			if (! done && action.action().contains("Chaptered by Secretary of State")) {
				action.setBillActionType(actionTypes().objectForKey("Chaptered by Secretary of State"));
				done = true;				
			}

			if (! done && action.action().contains("Enrolled and filed with the Secretary of State")) {
				action.setBillActionType(actionTypes().objectForKey("Enrolled and filed with the Secretary of State"));
				done = true;				
			}

			if (! done && action.action().matches("May be heard in committee *[A-Z][a-z]* *[0-9]*$") ) {
				action.setBillActionType(actionTypes().objectForKey("May be heard in committee"));
				done = true;				
			}
		}

		ec.saveChanges();
		System.out.println("saved");
	}
}
