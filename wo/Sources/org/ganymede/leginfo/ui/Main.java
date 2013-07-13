package org.ganymede.leginfo.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.ganymede.leginfo.Session;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillVersion;
import org.ganymede.leginfo.util.Day;
import org.ganymede.leginfo.util.Month;
import org.ganymede.leginfo.util.Week;
import org.ganymede.leginfo.util.Year;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOAndQualifier;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableSet;

import er.ajax.AjaxUtils;
import er.extensions.qualifiers.ERXTrueQualifier;

public class Main extends GComponent {

    public Main(WOContext context) {
        super(context);
        _selectedMonth = Month.thisMonth();
    }

    public String message = null;

    public EOEditingContext ec() { return session().defaultEditingContext(); }

    public Session session() { return (Session)super.session(); }

    public String recentDate;

    private static final ThreadLocal<SimpleDateFormat> dateOnlyFormatter = new ThreadLocal<SimpleDateFormat>(){
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public NSArray<String> recentDates() {
    	Date now = new Date();
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(now);
    	NSMutableArray<String> dates = new NSMutableArray<String>();
    	dates.add(dateOnlyFormatter.get().format(now));

    	for (int idx = 0; idx < 13; idx++) {
    		cal.add(Calendar.DATE, -1);
    		dates.add(dateOnlyFormatter.get().format(cal.getTime()));
    	}

    	return dates.immutableClone();
    }

    private EOQualifier isMajorBillQualifier() {
    	if (session().includeExtraBills)
    		return BillVersion.BILL.dot(Bill.BILL_NUM).ilike("ab_*").or(BillVersion.BILL.dot(Bill.BILL_NUM).ilike("sb_*"));
    	else
    		return new ERXTrueQualifier();
    }

    public NSArray<Bill> recentlyIntroduced() {

    	EOQualifier recentlyIntroducedQualifier = null;

    	recentlyIntroducedQualifier = BillVersion.FILE_DATE.is(_repetitionDay.dateString()).and(BillVersion.KIND.is(BillVersion.KIND_INTRODUCED)).and(this.isMajorBillQualifier());

    	NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyIntroducedQualifier, null);
    	NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

    	return bills;
    }

    public NSArray<Bill> selectedIntroduced() {

    	EOQualifier recentlyIntroducedQualifier = null;

    	recentlyIntroducedQualifier = BillVersion.FILE_DATE.is(_selectedDay.dateString()).and(BillVersion.KIND.is(BillVersion.KIND_INTRODUCED)).and(this.isMajorBillQualifier());

    	NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyIntroducedQualifier, null);
    	NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

    	return bills;
    }

    public NSArray<Bill> recentlyAmended() {

    	System.out.print("looking for amended for repetitionDay: "+_repetitionDay.dateString());
    	EOQualifier recentlyAmendedQualifier = null;

    	recentlyAmendedQualifier = BillVersion.FILE_DATE.is(_repetitionDay.dateString()).and(BillVersion.KIND.startsWith(BillVersion.KIND_AMENDED)).and(this.isMajorBillQualifier());

    	NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyAmendedQualifier, null);
    	NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

    	System.out.println(" - found # "+bills.size());
    	return bills;
    }

    public NSArray<Bill> selectedAmended() {

    	System.out.print("looking for amended for selectedDay: "+_selectedDay.dateString());
    	EOQualifier recentlyAmendedQualifier = null;

    	recentlyAmendedQualifier = BillVersion.FILE_DATE.is(_selectedDay.dateString()).and(BillVersion.KIND.startsWith(BillVersion.KIND_AMENDED)).and(this.isMajorBillQualifier());

    	NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyAmendedQualifier, null);
    	NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

    	System.out.println(" - found # "+bills.size());
    	return bills;
    }

    public NSArray<Bill> recentlyLastActions() {
    	return Bill.fetchBills(ec(), Bill.LAST_HIST_ACT_DATE.is(_repetitionDay.dateString()).and(this.isMajorBillQualifier()), null);
    }

    public NSArray<Bill> selectedLastActions() {
    	return Bill.fetchBills(ec(), Bill.LAST_HIST_ACT_DATE.is(_selectedDay.dateString()).and(this.isMajorBillQualifier()), null);
    }

    public NSArray<Bill> recentlyScheduledHearings() {
    	return Bill.fetchBills(ec(), Bill.HEARING_DATE.is(_repetitionDay.dateString()).and(this.isMajorBillQualifier()), null);
    }

    public NSArray<Bill> selectedScheduledHearings() {
    	return Bill.fetchBills(ec(), Bill.HEARING_DATE.is(_selectedDay.dateString()).and(this.isMajorBillQualifier()), Bill.COMM_LOCATION.ascs());
    }

    public NSArray<String> selectedScheduledHearingCommittees() {
    	NSArray<Bill> found = this.selectedScheduledHearings();
    	NSMutableSet<String> comms = new NSMutableSet<String>();
    	comms.addAll((NSArray<String>)found.valueForKey(Bill.COMM_LOCATION_KEY));
    	return comms.allObjects();
    }

    public String selectedScheduledHearingCommittee;

    public NSArray<Bill> selectedScheduledHearingsForCommitteeBills() {
    	if (selectedScheduledHearingCommittee == null) return NSArray.EmptyArray;
    	return EOQualifier.filteredArrayWithQualifier(this.selectedScheduledHearings(), Bill.COMM_LOCATION.is(selectedScheduledHearingCommittee));
    }

    public Bill selectedScheduledHearingCommitteeBill;

    public Bill billHearing;

    public String searchTerm;

    public boolean inMeasure;
    public boolean inTopic;
    public boolean inTitle;
    public boolean inAuthors;

    public WOActionResults search() {

    	message = null;

    	EOQualifier sessionQualifier = Bill.SESSION_YRS.is(session().valueForKey("sessionYrs").toString());

    	NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();

    	if (inMeasure) qualifiers.add(Bill.BILL_NUM.is(searchTerm));
    	if (inTopic) qualifiers.add(Bill.TOPIC.likeInsensitive("*"+searchTerm+"*"));

    	EOQualifier qualifier = null;

    	if (qualifiers.size() == 0) qualifier = sessionQualifier;
    	if (qualifiers.size() == 1) qualifier = new EOAndQualifier(new NSArray<EOQualifier>(new EOQualifier[] { sessionQualifier, qualifiers.get(0) } ));
    	if (qualifiers.size() > 1) qualifier = new EOAndQualifier(new NSArray<EOQualifier>(new EOQualifier[] { sessionQualifier, new EOOrQualifier(qualifiers) } ));

    	System.out.println("qualifier: "+qualifier);

    	WOComponent nextPage = pageWithName(BillListPage.class);
    	NSArray rows = Bill.fetchBills(session().defaultEditingContext(), qualifier, null);
    	System.out.println("rows # "+rows.size());
    	nextPage.takeValueForKey(rows, "bills");

    	return nextPage;
    }

    public WOActionResults doIncludeExtraBills() { session().includeExtraBills = true; return context().page(); }
    public WOActionResults dontIncludeExtraBills() { session().includeExtraBills = false; return context().page(); }

    public String findableBillNum;
    public String findableAuthor;
    public String findableTopic;

    public WOActionResults find() {
    	message = null;
    	NSMutableSet<EOQualifier> qualifiers = new NSMutableSet<EOQualifier>();
    	if (findableBillNum != null) {
    		findableBillNum = findableBillNum.replaceAll("\\.", "");
    		findableBillNum = findableBillNum.replaceAll(" ", "_");
    		findableBillNum = findableBillNum.replaceAll("__", "_");    		
    		if (! findableBillNum.matches("^[A-Za-z0-9]*_[0-9][0-9]*")) {
    			message = "Bill number should be lile \"ab 23\" or \"SB 110\" or \"ab_11\". Cannot interpret given bill number.";
    			return context().page();
    		}
    		qualifiers.add(Bill.BILL_NUM.is(findableBillNum));
    	}
    	if (findableAuthor != null) {
    		qualifiers.add(Bill.AUTHORS.ilike("*"+findableAuthor+"*"));
    	}
    	if (findableTopic != null) {
    		qualifiers.add(Bill.TOPIC.ilike("*"+findableTopic+"*"));
    	}
    	if (qualifiers.size() > 0) {
    		EOQualifier qualifier = (qualifiers.size() == 1) ? qualifiers.anyObject() : new EOAndQualifier(qualifiers.allObjects());
        	WOComponent nextPage = pageWithName(BillListPage.class);
        	NSArray rows = Bill.fetchBills(session().defaultEditingContext(), qualifier, null);
        	System.out.println("rows # "+rows.size());
        	nextPage.takeValueForKey(rows, "bills");
        	return nextPage;
    	} else {
    		message = "Nothing to search for....";
    		return context().page();
    	}
    }
    
    public Year _selectedYear = null;
    public Month _selectedMonth = null;
    public Week _repetitionWeek = null;
    public Day _repetitionDay = null;
    public Day _selectedDay = null;

    public int lastMonth = -1;

    @Override
    protected boolean useDefaultComponentCSS() {
      return true;
    }

    @Override
    public void appendToResponse(WOResponse response, WOContext context) {
      super.appendToResponse(response, context);
      AjaxUtils.addScriptResourceInHead(context, response, "Ajax", "prototype.js");
    }
    
    @Override
    public boolean synchronizesVariablesWithBindings() {
      return false;
    }

    public String dayClass() {
  	StringBuilder dayClass = new StringBuilder();
      dayClass.append("day");
      if (_repetitionDay.weekend()) {
        dayClass.append(" weekend");
      }
      if (_repetitionDay.today()) {
        dayClass.append(" today");
      }
      return dayClass.toString();
    }

    public boolean sameAsLastMonth() {
    	if (_repetitionDay.month() == lastMonth)
    		return true;
    	else {
    		lastMonth = _repetitionDay.month();
    		return false;
    	}
    }

    public WOActionResults selectDay() {
      _selectedDay = _repetitionDay;
      System.out.println("_selectedYear: "+_selectedYear);
      System.out.println("_selectedMonth: "+_selectedMonth);
      System.out.println("_selectedDay: "+_selectedDay);
      return null;
    }

    public WOActionResults previousMonth() {
    	_selectedDay = null;
    	_selectedMonth = _selectedMonth.previousMonth();
    	return context().page();
    }

    public WOActionResults nextMonth() {
    	_selectedDay = null;
    	_selectedMonth = _selectedMonth.nextMonth();
    	return context().page();
    }
}
