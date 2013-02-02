package org.ganymede.leginfo.ui;

import java.io.FileReader;
import java.io.LineNumberReader;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;

public class BillVersionPage extends ERXComponent {

    public BillVersionPage(WOContext context) {
        super(context);
    }

    public String filename;

    public String contents() {
        StringBuilder str = new StringBuilder();

        FileReader fr = null;
        try {
            fr = new FileReader("/Users/ray/Projects/LegislatureSQL/leginfo.public.ca.gov/pub/"+filename);
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
}
