package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;

public class BillVersionAuthors extends ERXComponent {

	public BillVersionAuthors(WOContext context) {
        super(context);
    }

	public Author author;

	public BillVersion billVersion;

	public void setBillVersion(Object value) {
		billVersion = (BillVersion)value;
	}

	NSArray<Author> authorsSameHouse = null;
	NSArray<Author> authorsOffHouse = null;

	NSArray<Author> principalCoauthorsSameHouse = null;
	NSArray<Author> principalCoauthorsOffHouse = null;

	NSArray<Author> coauthorsSameHouse = null;
	NSArray<Author> coauthorsOffHouse = null;

}
