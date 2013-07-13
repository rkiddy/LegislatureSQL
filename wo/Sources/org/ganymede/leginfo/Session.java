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
}
