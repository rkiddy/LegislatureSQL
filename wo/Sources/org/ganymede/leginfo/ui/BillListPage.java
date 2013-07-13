package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillType;
import org.ganymede.leginfo.eo.BillVersion;
import org.ganymede.leginfo.eo.BillWould;
import org.ganymede.leginfo.eo.CodeSection;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class BillListPage extends GComponent {

    public BillListPage(WOContext context) {
        super(context);
    }

    public String pageTitle;
    public String pageTitle() {
    	return (pageTitle != null) ? pageTitle : "Bills";
    }

    public Bill bill;

    public NSArray<Bill> bills;
    public NSArray<Bill> bills() {
    	return (bills == null) ? null : Bill.sortedByMeasure(bills);
    }

    public BillVersion billVersion;

    public BillWould would;

    public BillType billType;

    public CodeSection section;

    public boolean _optionsVisible;


    @Override
    protected boolean useDefaultComponentCSS() {
      return true;
    }
    
    public WOActionResults toggleOptions() {
      _optionsVisible = !_optionsVisible;
      return null;
    }
}
