package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

public class BillListPage extends ERXComponent {

	public BillListPage(WOContext context) {
		super(context);
	}

	public Bill bill;

	public BillVersion billVersion;

	public NSArray<Bill> bills;
}