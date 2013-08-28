package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.PersonContact;
import org.ganymede.leginfo.eo.PersonContactGroup;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class AuthorPage extends ERXComponent {

	public AuthorPage(WOContext context) {
        super(context);
    }

    public Author author;
    public PersonContact contact;
    public PersonContactGroup contactGroup;
    public Bill bill;
}