package org.ganymede.leginfo.ui;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.ganymede.leginfo.eo.BillVersion;

import com.webobjects.appserver.WOContext;

public class BillVersionPage extends GComponent {

    public BillVersionPage(WOContext context) {
        super(context);
    }

    public BillVersion version;

    public String contents() {
        StringBuilder str = new StringBuilder();

        FileReader fr = null;
        try {
            fr = new FileReader("/Users/ray/Projects/LegislatureSQL/leginfo.public.ca.gov/pub/"+version.file());
        } catch (java.io.FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        if (fr == null) return null;

        LineNumberReader rdr = new LineNumberReader(fr);
        String line = "";

        boolean appending = false;

        while (line != null) {
            try {
                line = rdr.readLine();
            } catch (java.io.IOException e) {
                line = null;
            }
            if (line != null) {
            	if (line.indexOf("<body") >= 0) {
            		int offset = line.indexOf(">", line.indexOf("<body")) + 1;
            		line = line.substring(offset);
            		appending = true;
            	}
            	if (appending)
            		str.append(line+"\n");
            }
        }

        try {
            rdr.close();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }

        return str.toString();
    }
}
