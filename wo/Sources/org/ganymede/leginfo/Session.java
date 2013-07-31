package org.ganymede.leginfo;

import er.extensions.appserver.ERXSession;

public class Session extends ERXSession {
    private static final long serialVersionUID = 1L;

    public Session() {
    }

    public String sessionYrs = "13-14";

    public boolean displayMeasure = true;
    public boolean displayTopic = true;
    public boolean displayTitle = false;

    public boolean includeExtraBills = false;

    public boolean alwaysShowTopic = false;
    public boolean alwaysShowAuthors = false;
    public boolean alwaysShowLastActions = false;
    public boolean alwaysShowVersions = false;
    public boolean alwaysShowBillTypes = false;
    public boolean alwaysShowSections = false;
    public boolean alwaysShowThisBillWoulds = false;

    public boolean hideEverything() {
    	return ! alwaysShowTopic && ! alwaysShowAuthors && ! alwaysShowLastActions && ! alwaysShowVersions &&
    			! alwaysShowBillTypes && ! alwaysShowSections && ! alwaysShowThisBillWoulds;
    }
    public boolean showEverything() {
    	return alwaysShowTopic && alwaysShowAuthors && alwaysShowLastActions && alwaysShowVersions &&
    			alwaysShowBillTypes && alwaysShowSections && alwaysShowThisBillWoulds;
    }
}
