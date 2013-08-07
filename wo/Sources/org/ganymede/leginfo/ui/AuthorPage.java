package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.Bill;
import org.ganymede.leginfo.eo.Person;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class AuthorPage extends ERXComponent {

	public AuthorPage(WOContext context) {
        super(context);
    }

    public Author author;
    public Person person;
    public Bill bill;
}