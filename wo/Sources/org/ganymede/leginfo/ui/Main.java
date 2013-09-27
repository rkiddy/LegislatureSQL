package org.ganymede.leginfo.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillAction;
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
import com.webobjects.eocontrol.EOOrQualifier;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableSet;

import er.ajax.AjaxUtils;

public class Main extends GComponent {

    public Main(WOContext context) {
        super(context);
        _selectedMonth = Month.thisMonth();
    }

    public String message = null;

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

    public NSArray<Bill> recentlyIntroduced() {

        EOQualifier recentlyIntroducedQualifier = null;

        recentlyIntroducedQualifier = BillVersion.FILE_DATE.is(_repetitionDay.dateString()).and(BillVersion.KIND.is(BillVersion.KIND_INTRODUCED));

        NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyIntroducedQualifier, null);
        NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);

        return bills;
    }

    public NSArray<Bill> selectedIntroduced() {

        EOQualifier recentlyIntroducedQualifier = null;

        recentlyIntroducedQualifier = BillVersion.FILE_DATE.is(_selectedDay.dateString()).and(BillVersion.KIND.is(BillVersion.KIND_INTRODUCED));

        NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyIntroducedQualifier, null);
        NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);

        return bills;
    }

    public NSArray<Bill> recentlyAmended() {

        EOQualifier recentlyAmendedQualifier = null;

        recentlyAmendedQualifier = BillVersion.FILE_DATE.is(_repetitionDay.dateString()).and(BillVersion.KIND.startsWith(BillVersion.KIND_AMENDED));

        NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyAmendedQualifier, null);
        NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);

        return bills;
    }

    public NSArray<Bill> selectedAmended() {

        EOQualifier recentlyAmendedQualifier = null;

        recentlyAmendedQualifier = BillVersion.FILE_DATE.is(_selectedDay.dateString()).and(BillVersion.KIND.startsWith(BillVersion.KIND_AMENDED));

        NSArray<BillVersion> versions = BillVersion.fetchBillVersions(ec(), recentlyAmendedQualifier, null);
        NSArray<Bill> bills = (NSArray<Bill>)versions.valueForKey(BillVersion.BILL_KEY);

        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);

        return bills;
    }

    public NSArray<Bill> recentlyLastActions() {
        NSArray<Bill> bills = Bill.fetchBills(ec(), Bill.LAST_HIST_ACT_DATE.is(_repetitionDay.dateString()), null);
        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
        return bills;
    }

    public NSArray<Bill> selectedLastActions() {
        NSArray<Bill> bills =  Bill.fetchBills(ec(), Bill.LAST_HIST_ACT_DATE.is(_selectedDay.dateString()), null);
        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
        return bills;
    }

    public NSArray<Bill> recentlyScheduledHearings() {
        NSArray<Bill> bills =  Bill.fetchBills(ec(), Bill.HEARING_DATE.is(_repetitionDay.dateString()), null);
        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
        return bills;
    }

    public NSArray<Bill> selectedScheduledHearings() {
        NSArray<Bill> bills =  Bill.fetchBills(ec(), Bill.HEARING_DATE.is(_selectedDay.dateString()), Bill.COMM_LOCATION.ascs());
        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
        return bills;
    }

    public NSArray<String> selectedScheduledHearingCommittees() {
        NSArray<Bill> bills = this.selectedScheduledHearings();
        if (! session().includeExtraBills) bills = EOQualifier.filteredArrayWithQualifier(bills, Bill.majorBillQualifier);
        NSMutableSet<String> comms = new NSMutableSet<String>();
        comms.addAll((NSArray<String>)bills.valueForKey(Bill.COMM_LOCATION_KEY));
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

    public WOActionResults doIncludeExtraBills() { session().includeExtraBills = true; return context().page(); }
    public WOActionResults dontIncludeExtraBills() { session().includeExtraBills = false; return context().page(); }

    public String findableBillNum;
    public String findableAuthor;
    public String findableTopic;
    public String findableAction;
    public String operator = "or";

    public WOActionResults find() {

        message = null;

        NSMutableSet<EOQualifier> qualifiers = new NSMutableSet<EOQualifier>();
        if (findableBillNum != null) {

            System.out.println("findableBillNum: at start: \""+findableBillNum+"\"");

            if (findableBillNum.matches("^[0-9][0-9]*$")) {

                System.out.println("findableBillNum: matching 09");
                qualifiers.add(Bill.BILL_NUM.like("*_"+findableBillNum));
            }

            if (findableBillNum.matches("[A-Za-z].*[0-9]")) {

                System.out.println("findableBillNum: matching AZ_09");
                findableBillNum = findableBillNum.toLowerCase();
                findableBillNum = findableBillNum.replaceAll(" ", "*_");
                System.out.println("findableBillNum: checkable = \""+findableBillNum+"\"");

                qualifiers.add(Bill.BILL_NUM.ilike("*"+findableBillNum));
            }
        }
        if (findableAuthor != null) {
            qualifiers.add(Bill.AUTHORS.ilike("*"+findableAuthor+"*"));
        }
        if (findableTopic != null) {
            qualifiers.add(Bill.TOPIC.ilike("*"+findableTopic+"*"));
        }
        if (findableAction != null) {
            qualifiers.add(Bill.BILL_ACTIONS.dot(BillAction.ACTION.ilike("*"+findableAction+"*")));
        }

        if (qualifiers.size() > 0) {

            EOQualifier qualifier = (qualifiers.size() == 1) ? qualifiers.anyObject() : ((operator.equals("or")) ? new EOOrQualifier(qualifiers.allObjects()) : new EOAndQualifier(qualifiers.allObjects()));

            if ( ! session().includeExtraBills) qualifier = new EOAndQualifier(new NSArray<EOQualifier>( new EOQualifier[] { qualifier, Bill.majorBillQualifier} ));

            NSArray rows = Bill.fetchBills(session().defaultEditingContext(), qualifier, null);

            if (rows.size() == 0) {

                message = "Your search returned 0 results. Sorry.";
                return context().page();

            } else {

                WOComponent nextPage = pageWithName(BillListPage.class);

                if (session().debug)
                    nextPage.takeValueForKey("qualifier: "+qualifier, "message");

                nextPage.takeValueForKey(rows, "bills");

                return nextPage;
            }
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
