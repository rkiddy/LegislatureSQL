package org.ganymede.leginfo.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

public class Bill extends _Bill {

    @SuppressWarnings("unused")
    private static Logger log = Logger.getLogger(Bill.class);

    public static EOQualifier majorBillQualifier = BILL_NUM.ilike("ab_*").or(BILL_NUM.ilike("sb_*"));

    public static NSArray<Bill> sortedByMeasure(NSArray<Bill> bills) {

    	NSMutableDictionary<String,Bill> sortable = new NSMutableDictionary<String,Bill>();

    	for (Bill bill : bills) {

    		NSArray<String> parts = NSArray.componentsSeparatedByString(bill.billNum(), "_");
    		String head = parts.get(0);
    		String number = parts.get(1);

    		while (number.length() < 8) number = "0"+number;

    		sortable.setObjectForKey(bill, head+"_"+number);
    	}

    	NSMutableArray<Bill> sorted = new NSMutableArray<Bill>();

    	try {
			for (String billNum : sortable.allKeys().sortedArrayUsingComparator(NSComparator.AscendingStringComparator)) {
				sorted.add(sortable.objectForKey(billNum));
			}
		} catch (com.webobjects.foundation.NSComparator.ComparisonException e) { }

		return sorted.immutableClone();
    }

    public String prefixlessHouse() {
    	String num = this.billNum();
    	if (num.indexOf("x") > 0) {
    		num = num.substring(0, num.indexOf("x"));
    	} else {
    		num = num.substring(0, num.indexOf("_"));
    	}
    	return num;
    }

    public String house() { return (this.billNum().startsWith("a") || this.billNum().startsWith("h")) ? "A" : "S"; }
}
