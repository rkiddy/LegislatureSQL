package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Annotation;
import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.BillType;
import org.ganymede.leginfo.eo.BillVersion;
import org.ganymede.leginfo.eo.BillWould;
import org.ganymede.leginfo.eo.CodeSection;
import org.ganymede.leginfo.eo.Tag;

import com.webobjects.appserver.WOContext;

public class BillPage extends GComponent {

    public BillPage(WOContext context) {
        super(context);
    }

    public Bill bill;
    public Author author;
    public BillVersion billVersion;
    public BillType billType;
    public BillWould would;
    public CodeSection section;
    public Tag tag;
    public Annotation annotation;
}
