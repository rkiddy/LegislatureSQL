package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class TestsPage extends GComponent {

	private static final String BILL_VERSION_TEST = "BillVersionTest";
	private static final String THIS_BILL_WOULDS_TEST = "ThisBillWouldsTest";
	private static final String THIS_AUTHORS = "AuthorsTest";

	public TestsPage(WOContext context) {
		super(context);
	}

	private String testName = "None";

	public WOActionResults selectBillVersions() { testName = BILL_VERSION_TEST; return context().page(); }
	public WOActionResults selectThisBillWoulds() { testName = THIS_BILL_WOULDS_TEST; return context().page(); }
	public WOActionResults selectAuthors() { testName = THIS_AUTHORS; return context().page(); }

	public boolean testBillVersions() { return testName.equals(BILL_VERSION_TEST); }
	public boolean testThisBillWoulds() { return testName.equals(THIS_BILL_WOULDS_TEST); }
	public boolean testAuthors() { return testName.equals(THIS_AUTHORS); }

	public NSArray<Bill> bills() { return Bill.fetchAllBills(ec()); }

	public Bill bill;
	public BillVersion version;
}
