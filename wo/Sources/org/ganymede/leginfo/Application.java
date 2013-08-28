package org.ganymede.leginfo;

import java.io.FileInputStream;

import com.webobjects.appserver.WOApplication;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eoaccess.EOModelGroup;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSNotification;
import com.webobjects.foundation.NSNotificationCenter;
import com.webobjects.foundation.NSSelector;

import er.extensions.appserver.ERXApplication;
import er.extensions.eof.ERXEC;

public class Application extends ERXApplication {

	public static void main(String[] argv) {
        ERXApplication.main(argv, Application.class);
    }

    public Application() {
        ERXApplication.log.info("Welcome to " + name() + " !");

        setPageRefreshOnBacktrackEnabled(false);

        NSNotificationCenter.defaultCenter().addObserver(this, new NSSelector("finishLaunch", new Class [] {NSNotification.class}), WOApplication.ApplicationDidFinishLaunchingNotification, null);
    }

    public void finishLaunch(NSNotification notification) {

        String dbName = null;
        String dbUserName = null;
        String dbPassword = null;

        try {
            System.getProperties().load(new FileInputStream(System.getProperty("user.home")+"/Library/wobuild.properties"));
            dbName = System.getProperty("wo.leginfo.db.name");
            dbUserName = System.getProperty("wo.leginfo.db.username");
            dbPassword = System.getProperty("wo.leginfo.db.password");
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        if (dbName != null && dbUserName != null && dbPassword != null) {
            EOModel legModel = EOModelGroup.defaultGroup().modelNamed("LegSQLModel");
            NSMutableDictionary dict = new NSMutableDictionary();
            dict.setObjectForKey("jdbc:mysql://localhost/"+dbName, "URL");
            dict.setObjectForKey(dbUserName, "username");
            dict.setObjectForKey(dbPassword, "password");
            legModel.setConnectionDictionary(dict);
        }

        if (System.getProperty("ProcessThisBillWoulds") != null) {
        	Fixer.processThisBillWoulds(ERXEC.newEditingContext());
        	System.exit(0);
        }

        if (System.getProperty("ProcessAuthors") != null) {
        	Fixer.processAuthors(ERXEC.newEditingContext());
        	System.exit(0);
        }

        if (System.getProperty("RunFixesAndQuit") != null) {
        	Fixer.fixAll();
        	System.exit(0);
        }
    }
}
