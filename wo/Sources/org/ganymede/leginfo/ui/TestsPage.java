package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillVersion;
import org.ganymede.leginfo.eo.BillWould;
import org.ganymede.leginfo.eo.GEO;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSDictionary;

public class TestsPage extends GComponent {

	private static final String BILL_VERSION_TEST = "BillVersionTest";
	private static final String THIS_BILL_WOULDS_TEST = "ThisBillWouldsTest";
	private static final String THIS_AUTHORS = "AuthorsTest";
	private static final String FIX_THIS_BILL_WOULDS = "FixThisBillWoulds";

	public TestsPage(WOContext context) {
		super(context);
	}

	public String message;

	private String testName = "None";

	public WOActionResults selectBillVersions() { testName = BILL_VERSION_TEST; return context().page(); }
	public WOActionResults selectThisBillWoulds() { testName = THIS_BILL_WOULDS_TEST; return context().page(); }
	public WOActionResults selectAuthors() { testName = THIS_AUTHORS; return context().page(); }
	public WOActionResults fixTBWs() { testName = FIX_THIS_BILL_WOULDS; return context().page(); }

	public boolean testBillVersions() { return testName.equals(BILL_VERSION_TEST); }
	public boolean testThisBillWoulds() { return testName.equals(THIS_BILL_WOULDS_TEST); }
	public boolean fixThisBillWoulds() { return testName.equals(FIX_THIS_BILL_WOULDS); }
	public boolean testAuthors() { return testName.equals(THIS_AUTHORS); }

	int billsLowerLimit = 0;
	int billsSize = 100;

	NSArray<Number> pks = null;

	public NSArray<Bill> bills = null;
	public NSArray<Bill> bills() {
		if (bills == null) {
			String sql = "select pk, bill_num from bills where pk > "+billsLowerLimit+" limit "+billsSize;
			NSArray<NSDictionary<String,String>> rows = EOUtilities.rawRowsForSQL(ec(), GEO.modelName, sql, new NSArray<String>(new String[] { "pk", "billNum" }));
			NSArray<String> billNums = (NSArray<String>)rows.valueForKey("billNum");
			pks = (NSArray<Number>)rows.valueForKey("pk");
			return Bill.fetchBills(ec(), Bill.BILL_NUM.in(billNums), null);
		}
		return bills;
	}

	public WOActionResults nextBills() {
		Number max;
		try {
			max = pks.sortedArrayUsingComparator(NSComparator.AscendingNumberComparator).lastObject();
		} catch (com.webobjects.foundation.NSComparator.ComparisonException e) {
			throw new IllegalArgumentException(e);
		}
		billsLowerLimit = max.intValue();
		bills = null;
		return context().page();
	}

	public Bill bill;
	public BillVersion version;

	public String fileName;
	public String tbw;
	public WOActionResults addTBW() {
		if (tbw == null || "".equals(tbw) || fileName == null || "".equals(fileName)) {
			message = "Please give me both a non-file file and a non-null sentence.";
			return context().page();					
		}

		BillVersion version = BillVersion.fetchRequiredBillVersion(ec(), BillVersion.FILE_KEY, fileName);

		if (version == null) {
			message = "Cannot find bill version with file = \""+fileName+"\"";
			return context().page();					
		}
		NSArray<BillWould> exitingTBWs = BillWould.fetchBillWoulds(ec(), BillWould.BILL_VERSION.is(version), BillWould.IDX.ascs());

		int highestIdx = exitingTBWs.lastObject().idx().intValue();

		BillWould nextTBW = BillWould.createBillWould(ec(), highestIdx + 1, tbw, version);

		ec().saveChanges();

		message = nextTBW.toLongString();
		tbw = null;
		return context().page();
	}
}
