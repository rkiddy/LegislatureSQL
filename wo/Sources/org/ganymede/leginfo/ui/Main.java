package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillType;
import org.ganymede.leginfo.eo.CodeSection;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSComparator.ComparisonException;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

import er.extensions.components.ERXComponent;

public class Main extends ERXComponent {

    public Main(WOContext context) {
        super(context);
    }

    public EOEditingContext ec() { return session().defaultEditingContext(); }

    public String date;

    private NSMutableDictionary<String,NSMutableArray<Bill>> histActions;

    private NSMutableDictionary<String,NSMutableArray<Bill>> histActions() {
        if (histActions == null) {
            NSArray<Bill> foundBills = Bill.fetchAllBills(ec());

            histActions = new NSMutableDictionary<String,NSMutableArray<Bill>>();

            for (Bill bill : foundBills) {
                String actionDate = bill.lastHistActDate();
                if (! histActions.containsKey(actionDate)) histActions.setObjectForKey(new NSMutableArray<Bill>(), actionDate);
                histActions.objectForKey(actionDate).add(bill);
            }
        }
        return histActions;
    }

    public int histActionDatesCount() { return histActions.objectForKey(date).size(); }

    public NSArray<String> lastHistActionDates() {

        NSArray<String> found = histActions().allKeys();
        try {
            return found.sortedArrayUsingComparator(NSComparator.DescendingStringComparator);
        } catch (ComparisonException e) {
            return found;
        }
    }

    private NSMutableDictionary<String,NSMutableArray<Bill>> statusActions;

    private NSMutableDictionary<String,NSMutableArray<Bill>> statusActions() {
        if (statusActions == null) {

            NSArray<Bill> foundBills = Bill.fetchAllBills(ec());

            statusActions = new NSMutableDictionary<String,NSMutableArray<Bill>>();

            for (Bill bill : foundBills) {
                String statusDate = bill.statusDate();
                if (! statusActions.containsKey(statusDate)) statusActions.setObjectForKey(new NSMutableArray<Bill>(), statusDate);
                statusActions.objectForKey(statusDate).add(bill);
            }
        }
        return statusActions;
    }

    public int statusDatesCount() { return statusActions.objectForKey(date).size(); }

    public NSArray<String> statusUpdateDates() {

        NSArray<String> found = statusActions().allKeys();
        try {
            return found.sortedArrayUsingComparator(NSComparator.DescendingStringComparator);
        } catch (ComparisonException e) {
            return found;
        }
    }

    public String relating;

    private NSMutableDictionary<String,NSMutableArray<Bill>> relatings;

    NSArray<String> deleteMe = new NSArray<String>(new String[] {
            " and declaring the urgency thereof, to take effect immediately",
            " and making an appropriation therefor",
            " making an appropriation therefor",
            " to take effect immediately",
            " to make an appropriation therefor",
            " and calling a special election to be consolidated with a statewide election",
            " as an act calling an election",
            " and declaring the urgency thereof",
            " to take efffect immediately",
            " bill related to the budget",
            " as an appropriation for the usual and current expenses of the state",
            " Budget Bill.",
            " budget bill.",
            " as an act calling an election",
            " and calling a special election to be consolidated with the next statewide general election",
            " tax levy.",
            " by providing the funds necessary therefor through an election for the issuance and sale of bonds of the State of California and for the handling and disposition of those funds",
            " as an act calling an election",
            " and calling a special election to be consolidated with the November 4, 2014, statewide general election"
    } );
    public NSMutableDictionary<String,NSMutableArray<Bill>> relatings() {
        if (relatings == null) {

            NSArray<Bill> foundBills = Bill.fetchAllBills(ec());

            relatings = new NSMutableDictionary<String,NSMutableArray<Bill>>();

            for (Bill bill : foundBills) {
                String relating = bill.shortTitle();
                if (relating.startsWith("Relating")) relating = relating.replaceFirst("Relating", "relating");
                for (String deletable : deleteMe) {
                    relating = relating.replaceFirst(deletable, "");
                }
                relating = relating.replaceFirst("[\\p{Punct} ]*$", ".");
                if (relating.indexOf("relating") >= 0) {
                    if (! relatings.containsKey(relating)) relatings.setObjectForKey(new NSMutableArray<Bill>(), relating);
                    relatings.objectForKey(relating).add(bill);
                }
            }
        }
        return relatings;
    }

    public int relatingsCount() { return relatings.objectForKey(relating).size(); }

    public WOActionResults showBillsFromRelating() {
        WOComponent nextPage = pageWithName(BillListPage.class);
        nextPage.takeValueForKey(relatings.objectForKey(relating), "bills");
        return nextPage;
    }

    public EOEnterpriseObject billType;

    public NSArray<BillType> billTypes() {
        return BillType.fetchAllBillTypes(session().defaultEditingContext());
    }

    public WOActionResults showBillsFromType() {
        WOComponent nextPage = pageWithName(BillListPage.class);
        nextPage.takeValueForKey(billType.valueForKey("bills"), "bills");
        return nextPage;
    }

    public CodeSection section;

    public NSArray<CodeSection> sections() {
        return CodeSection.fetchAllCodeSections(session().defaultEditingContext());
    }

    public WOActionResults showBillsFromSection() {
        WOComponent nextPage = pageWithName(BillListPage.class);
        nextPage.takeValueForKey(section.valueForKey("bills"), "bills");
        return nextPage;
    }

    public WOActionResults showBillsFromHistActionDate() {
        WOComponent nextPage = pageWithName(BillListPage.class);
        nextPage.takeValueForKey(histActions.objectForKey(date), "bills");
        return nextPage;
    }

    public WOActionResults showBillsFromStatusDate() {
        WOComponent nextPage = pageWithName(BillListPage.class);
        nextPage.takeValueForKey(statusActions.objectForKey(date), "bills");
        return nextPage;
    }
}
