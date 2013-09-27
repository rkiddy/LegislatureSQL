package org.ganymede.leginfo.ui;

import org.ganymede.leginfo.Session;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.components.ERXComponent;

public abstract class GComponent extends ERXComponent {

    public GComponent(WOContext context) { super(context); }

    public EOEditingContext ec() { return session().defaultEditingContext(); }

    public Session session() { return (Session)super.session(); }
}
