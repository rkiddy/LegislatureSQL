package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.PersonContact;
import org.ganymede.leginfo.eo.PersonContactGroup;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

public class AuthorPage extends ERXComponent {

    public AuthorPage(WOContext context) {
        super(context);
    }

    public Author author;
    public PersonContact contact;
    public PersonContactGroup contactGroup;
    public Bill bill;

    public WOActionResults save() {
        session().defaultEditingContext().saveChanges();
        return context().page();
    }
    public WOActionResults cancel() {
        session().defaultEditingContext().revert();
        return context().page();
    }

    private static final NSArray<String> houses = new NSArray<String>(new String[] { "A", "S" } );
    public NSArray<String> houses() { return houses; }
    public String house;
}
