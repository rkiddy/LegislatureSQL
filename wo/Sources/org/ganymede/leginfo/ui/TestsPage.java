package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;

public class TestsPage extends ERXComponent {

	private static final String BILL_VERSION_TEST = "BillVersionTest";
	private static final String THIS_BILL_WOULDS_TEST = "ThisBillWouldsTest";

	private static NSMutableDictionary<String,NSArray<String>> needs;
	static {
		needs = new NSMutableDictionary<String,NSArray<String>>();
		needs.setObjectForKey(new NSArray<String>(new String[] { BILL_VERSION_TEST } ), "bills");
	}

	private EOEditingContext ec;
	private EOEditingContext ec() {
		if (ec == null)
			ec = ERXEC.newEditingContext();
		return ec;
	}

	public TestsPage(WOContext context) {
		super(context);
	}

	private String testName = "None";

	public WOActionResults selectBillVersions() { testName = BILL_VERSION_TEST; return context().page(); }
	public WOActionResults selectThisBillWoulds() { testName = THIS_BILL_WOULDS_TEST; return context().page(); }

	public boolean testBillVersions() { return testName.equals(BILL_VERSION_TEST); }
	public boolean testThisBillWoulds() { return testName.equals(THIS_BILL_WOULDS_TEST); }

	public NSArray<Bill> bills() { return (needs.objectForKey("bills").contains(BILL_VERSION_TEST)) ? Bill.fetchAllBills(ec()) : NSArray.EmptyArray; }

	public Bill bill;
	public BillVersion version;
}
