package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillAction;
import org.ganymede.leginfo.eo.BillType;
import org.ganymede.leginfo.eo.BillVersion;
import org.ganymede.leginfo.eo.BillWould;
import org.ganymede.leginfo.eo.CodeSection;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class BillList extends GComponent {

    public BillList(WOContext context) {
        super(context);
    }

    public Bill bill;

    public NSArray<Bill> bills;

    public NSArray<Bill> bills() {
        return (bills == null) ? null : Bill.sortedByMeasure(bills);
    }

    public Author author;

    public BillVersion billVersion;

    public BillAction billAction;

    public BillWould would;

    public BillType billType;

    public CodeSection section;

    public boolean _optionsVisible;

    @Override
    protected boolean useDefaultComponentCSS() {
      return true;
    }

    public NSArray<BillAction> previousActions() {
        NSArray<BillAction> actions = bill.billActions();
        NSMutableArray<BillAction> sorted = EOSortOrdering.sortedArrayUsingKeyOrderArray(actions, BillAction.WHEN_ACT.descs()).mutableClone();
        sorted.remove(0);
        return sorted.immutableClone();
    }

    public WOActionResults toggleOptions() {
      _optionsVisible = !_optionsVisible;
      return null;
    }

}
