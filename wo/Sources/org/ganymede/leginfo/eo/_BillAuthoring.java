// DO NOT EDIT.  Make changes to BillAuthoring.java instead.
package org.ganymede.leginfo.eo;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _BillAuthoring extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillAuthoring";

  // Attribute Keys
  public static final ERXKey<String> AUTHOR_HOUSE = new ERXKey<String>("authorHouse");
  public static final ERXKey<String> AUTHOR_TYPE = new ERXKey<String>("authorType");
  public static final ERXKey<String> SESSION_YRS = new ERXKey<String>("sessionYrs");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.Author> AUTHOR = new ERXKey<org.ganymede.leginfo.eo.Author>("author");
  public static final ERXKey<org.ganymede.leginfo.eo.BillVersion> BILL_VERSION = new ERXKey<org.ganymede.leginfo.eo.BillVersion>("billVersion");

  // Attributes
  public static final String AUTHOR_HOUSE_KEY = AUTHOR_HOUSE.key();
  public static final String AUTHOR_TYPE_KEY = AUTHOR_TYPE.key();
  public static final String SESSION_YRS_KEY = SESSION_YRS.key();
  // Relationships
  public static final String AUTHOR_KEY = AUTHOR.key();
  public static final String BILL_VERSION_KEY = BILL_VERSION.key();

  private static Logger LOG = Logger.getLogger(_BillAuthoring.class);

  public BillAuthoring localInstanceIn(EOEditingContext editingContext) {
    BillAuthoring localInstance = (BillAuthoring)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String authorHouse() {
    return (String) storedValueForKey(_BillAuthoring.AUTHOR_HOUSE_KEY);
  }

  public void setAuthorHouse(String value) {
    if (_BillAuthoring.LOG.isDebugEnabled()) {
        _BillAuthoring.LOG.debug( "updating authorHouse from " + authorHouse() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAuthoring.AUTHOR_HOUSE_KEY);
  }

  public String authorType() {
    return (String) storedValueForKey(_BillAuthoring.AUTHOR_TYPE_KEY);
  }

  public void setAuthorType(String value) {
    if (_BillAuthoring.LOG.isDebugEnabled()) {
        _BillAuthoring.LOG.debug( "updating authorType from " + authorType() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAuthoring.AUTHOR_TYPE_KEY);
  }

  public String sessionYrs() {
    return (String) storedValueForKey(_BillAuthoring.SESSION_YRS_KEY);
  }

  public void setSessionYrs(String value) {
    if (_BillAuthoring.LOG.isDebugEnabled()) {
        _BillAuthoring.LOG.debug( "updating sessionYrs from " + sessionYrs() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAuthoring.SESSION_YRS_KEY);
  }

  public org.ganymede.leginfo.eo.Author author() {
    return (org.ganymede.leginfo.eo.Author)storedValueForKey(_BillAuthoring.AUTHOR_KEY);
  }

  public void setAuthor(org.ganymede.leginfo.eo.Author value) {
    takeStoredValueForKey(value, _BillAuthoring.AUTHOR_KEY);
  }

  public void setAuthorRelationship(org.ganymede.leginfo.eo.Author value) {
    if (_BillAuthoring.LOG.isDebugEnabled()) {
      _BillAuthoring.LOG.debug("updating author from " + author() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        setAuthor(value);
    }
    else if (value == null) {
        org.ganymede.leginfo.eo.Author oldValue = author();
        if (oldValue != null) {
            removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillAuthoring.AUTHOR_KEY);
      }
    } else {
        addObjectToBothSidesOfRelationshipWithKey(value, _BillAuthoring.AUTHOR_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillVersion billVersion() {
    return (org.ganymede.leginfo.eo.BillVersion)storedValueForKey(_BillAuthoring.BILL_VERSION_KEY);
  }

  public void setBillVersion(org.ganymede.leginfo.eo.BillVersion value) {
    takeStoredValueForKey(value, _BillAuthoring.BILL_VERSION_KEY);
  }

  public void setBillVersionRelationship(org.ganymede.leginfo.eo.BillVersion value) {
    if (_BillAuthoring.LOG.isDebugEnabled()) {
      _BillAuthoring.LOG.debug("updating billVersion from " + billVersion() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        setBillVersion(value);
    }
    else if (value == null) {
        org.ganymede.leginfo.eo.BillVersion oldValue = billVersion();
        if (oldValue != null) {
            removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillAuthoring.BILL_VERSION_KEY);
      }
    } else {
        addObjectToBothSidesOfRelationshipWithKey(value, _BillAuthoring.BILL_VERSION_KEY);
    }
  }


  public static BillAuthoring createBillAuthoring(EOEditingContext editingContext, String authorHouse
, String authorType
, String sessionYrs
, org.ganymede.leginfo.eo.Author author, org.ganymede.leginfo.eo.BillVersion billVersion) {
    BillAuthoring eo = (BillAuthoring) EOUtilities.createAndInsertInstance(editingContext, _BillAuthoring.ENTITY_NAME);
        eo.setAuthorHouse(authorHouse);
        eo.setAuthorType(authorType);
        eo.setSessionYrs(sessionYrs);
    eo.setAuthorRelationship(author);
    eo.setBillVersionRelationship(billVersion);
    return eo;
  }

  public static ERXFetchSpecification<BillAuthoring> fetchSpec() {
    return new ERXFetchSpecification<BillAuthoring>(_BillAuthoring.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillAuthoring> fetchAllBillAuthorings(EOEditingContext editingContext) {
    return _BillAuthoring.fetchAllBillAuthorings(editingContext, null);
  }

  public static NSArray<BillAuthoring> fetchAllBillAuthorings(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillAuthoring.fetchBillAuthorings(editingContext, null, sortOrderings);
  }

  public static NSArray<BillAuthoring> fetchBillAuthorings(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillAuthoring> fetchSpec = new ERXFetchSpecification<BillAuthoring>(_BillAuthoring.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillAuthoring> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillAuthoring fetchBillAuthoring(EOEditingContext editingContext, String keyName, Object value) {
    return _BillAuthoring.fetchBillAuthoring(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillAuthoring fetchBillAuthoring(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillAuthoring> eoObjects = _BillAuthoring.fetchBillAuthorings(editingContext, qualifier, null);
    BillAuthoring eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillAuthoring that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillAuthoring fetchRequiredBillAuthoring(EOEditingContext editingContext, String keyName, Object value) {
    return _BillAuthoring.fetchRequiredBillAuthoring(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillAuthoring fetchRequiredBillAuthoring(EOEditingContext editingContext, EOQualifier qualifier) {
    BillAuthoring eoObject = _BillAuthoring.fetchBillAuthoring(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillAuthoring that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillAuthoring localInstanceIn(EOEditingContext editingContext, BillAuthoring eo) {
    BillAuthoring localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
