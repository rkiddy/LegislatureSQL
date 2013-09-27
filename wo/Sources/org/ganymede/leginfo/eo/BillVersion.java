package org.ganymede.leginfo.eo;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class BillVersion extends _BillVersion {

    @SuppressWarnings("unused")
    private static Logger log = Logger.getLogger(BillVersion.class);

    // To represent possible values of the "kind" column in bill_versions.
    //
    public static final String KIND_INTRODUCED = "introduced";
    public static final String KIND_ENROLLED = "enrolled";
    public static final String KIND_CHAPTERED = "chaptered";
    public static final String KIND_AMENDED = "amended_";

    public String contents() {

        StringBuilder str = new StringBuilder();

        FileReader fr = null;
        try {
            fr = new FileReader("/Users/ray/Projects/LegislatureSQL/"+this.file());
        } catch (java.io.FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        if (fr == null) return null;

        LineNumberReader rdr = new LineNumberReader(fr);
        String line = "";

        while (line != null) {
            try {
                line = rdr.readLine();
            } catch (java.io.IOException e) {
                line = null;
            }
            if (line != null) str.append(line+"\n");
        }

        try {
            rdr.close();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }

        return str.toString();
    }

    public String shortTitle() {
        String title = this.title();
        if (title.startsWith("Relating")) return title;
        int offset = title.indexOf("relating");
        if (offset < 0) return title;
        return title.substring(offset);
    }

    public String prettyName() {
        boolean ok = false;
        StringBuilder str = new StringBuilder();
        if (this.file().indexOf("_introduced") > 0) { str.append(" as introduced, "); ok = true; }
        if (this.file().indexOf("_amended") > 0) { str.append(" as amended, "); ok = true; }
        if (this.file().indexOf("_enrolled") > 0) { str.append(" as enrolled, "); ok = true; }
        if (this.file().indexOf("_chaptered") > 0) { str.append(" as chaptered, "); ok = true; }
        if (this.file().indexOf("_proposed") > 0) { str.append(" as proposed, "); ok = true; }
        str.append(this.fileDate());
           return (ok) ? str.toString() : this.file();
    }

    public boolean isLastVersion() { return this.bill().lastVersion().equals(this); }

    public NSArray<BillWould> woulds() { return EOSortOrdering.sortedArrayUsingKeyOrderArray(super.woulds(), BillWould.IDX.ascs()); }

    public NSArray<Author> authors() {
        EOQualifier qualifier = BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("A"));
        System.out.println("authors qualifier: "+qualifier);
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), qualifier, null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> authorsOff() {
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("A")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> pCoauthors() {
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("PC")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> pCoauthorsOff() {
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("PC")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> coauthors() {
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("C")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> coauthorsOff() {
        return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("C")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }
}
