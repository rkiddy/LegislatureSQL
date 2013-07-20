package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class BillListPage extends GComponent {

    public BillListPage(WOContext context) {
        super(context);
    }

    public String type;

    public boolean isTypeIntro() { return "intro".equals(type); }
    public boolean isTypeAmend() { return "amend".equals(type); }
    public boolean isTypeLastAct() { return "lastact".equals(type); }

    public String date;

    public String pageTitle;
    public String pageTitle() {
    	return (pageTitle != null) ? pageTitle : "Bills";
    }

    public NSArray<Bill> bills;
    public NSArray<Bill> bills() {
    	return (bills == null) ? null : Bill.sortedByMeasure(bills);
    }
}
