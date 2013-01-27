package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class BillVersionPage extends ERXComponent {
    public BillVersionPage(WOContext context) {
        super(context);
    }

    public BillVersion billVersion;
}