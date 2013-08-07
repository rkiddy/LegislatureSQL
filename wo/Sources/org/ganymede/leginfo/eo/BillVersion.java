package org.ganymede.leginfo.eo;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.apache.log4j.Logger;

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
    	str.append(this.fileDate());
       	return (ok) ? str.toString() : this.file();
    }

    public boolean isLastVersion() { return this.bill().lastVersion().equals(this); }

    // Authors for a bill:
    //
    // select b1.bill_num, ba1.author_type, ba1.author_pk, a1.name from bills b1, bill_versions v1, bill_authorings ba1, authors a1 where b1.bill_num = 'ab_314' and b1.last_version_pk = v1.pk and v1.pk = ba1.bill_version_pk and ba1.author_pk = a1.pk;
    //
    // ThisBillWoulds for a bill:
    //
    // select 

    public NSArray<Author> authors() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("A")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> authorsOffHouse() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("A")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> principalCoauthors() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("PC")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> principalCoauthorsOffHouse() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("PC")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> coauthors() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.is(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("C")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }

    public NSArray<Author> coauthorsOffHouse() {
    	return (NSArray<Author>)BillAuthoring.fetchBillAuthorings(editingContext(), BillAuthoring.BILL_VERSION.is(this).and(BillAuthoring.AUTHOR_HOUSE.isNot(this.bill().house())).and(BillAuthoring.AUTHOR_TYPE.is("C")), null).valueForKey(BillAuthoring.AUTHOR_KEY);
    }
}
