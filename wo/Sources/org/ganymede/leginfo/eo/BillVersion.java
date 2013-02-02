package org.ganymede.leginfo.eo;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.apache.log4j.Logger;

public class BillVersion extends _BillVersion {

    @SuppressWarnings("unused")
    private static Logger log = Logger.getLogger(BillVersion.class);

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
}
