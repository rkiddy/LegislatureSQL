package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.eo.Author;
import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class BillVersionAuthors extends ERXComponent {

	public BillVersionAuthors(WOContext context) {
        super(context);
    }

	public boolean brief = false;

	public int aNum() { return this.billVersion.authors().size(); }

	public String authorsLabel() {
		if (brief)
			return (aNum() == 1) ? "A" : (aNum() > 1) ? "As" : null;
		else
			return (aNum() == 1) ? "Author" : (aNum() > 1) ? "Authors" : null;
	}

	public int coNum() { return this.billVersion.coauthors().size(); }

	public String coauthorsLabel() {
		if (brief)
			return (coNum() == 1) ? "Co" : (coNum() > 1) ? "Cos" : null;
		else
			return (coNum() == 1) ? "Coauthor" : (coNum() > 1) ? "Coauthors" : null;
	}

	public int pCoNum() { return this.billVersion.pCoauthors().size(); }

	public String principalCoauthorsLabel() {
		if (brief)
			return (pCoNum() == 1) ? "PCo" : (pCoNum() > 1) ? "PCos" : null;
		else
			return (pCoNum() == 1) ? "Principal Coauthor" : (pCoNum() > 1) ? "Principal Coauthors" : null;
	}

	public Author author;

	public BillVersion billVersion;
}
