package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillAuthoring;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

public class CatalogPage extends GComponent {

	static final String CATEGORY_AUTHORS = "authors";

	public CatalogPage(WOContext context) {
        super(context);
    }

	public String category;

	public String categoryObj;
	public NSArray<String> categoryObjs() {

		if (CATEGORY_AUTHORS.equals(category)) {
			return (NSArray<String>)Author.fetchAllAuthors(ec(), Author.NAME.ascs()).valueForKey(Author.NAME_KEY);
		}

		return NSArray.EmptyArray;
	}

	NSMutableDictionary<String,NSArray<Bill>> authorCache = new NSMutableDictionary<String,NSArray<Bill>>();

	public NSArray<Bill> bills() {

		//System.out.println("category is \""+category+"\"");

		if (CATEGORY_AUTHORS.equals(category)) {
			if (! authorCache.containsKey(categoryObj)) {
				NSArray<BillAuthoring> authorings = BillAuthoring.fetchBillAuthorings(ec(), BillAuthoring.SESSION_YRS.is((String)session().valueForKey("sessionYrs")).and(BillAuthoring.AUTHOR_TYPE.is("A").and(BillAuthoring.AUTHOR.dot(Author.NAME.is(categoryObj))), null), null);
				NSArray<BillVersion> versions = (NSArray<BillVersion>)authorings.valueForKey(BillAuthoring.BILL_VERSION.key());
				NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL.key());
				if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
				bills = EOSortOrdering.sortedArrayUsingKeyOrderArray(bills, Bill.MEASURE.ascs());
				authorCache.setObjectForKey(bills, categoryObj);
				System.out.println("CatalogPage:: bills for \""+category+"\" = \""+categoryObj+"\", bills # "+bills.size());
			}
			return authorCache.objectForKey(categoryObj);
			//return NSArray.EmptyArray;
		}

		return NSArray.EmptyArray;
	}
    public void setBills(Object value) { }
}