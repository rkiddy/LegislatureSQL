// DO NOT EDIT.  Make changes to BillWould.java instead.
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
public abstract class _BillWould extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillWould";

  // Attribute Keys
  public static final ERXKey<String> SENTENCE = new ERXKey<String>("sentence");
  public static final ERXKey<Integer> VERSION_PK = new ERXKey<Integer>("versionPk");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillVersion> BILL_VERSION = new ERXKey<org.ganymede.leginfo.eo.BillVersion>("billVersion");

  // Attributes
  public static final String SENTENCE_KEY = SENTENCE.key();
  public static final String VERSION_PK_KEY = VERSION_PK.key();
  // Relationships
  public static final String BILL_VERSION_KEY = BILL_VERSION.key();

  private static Logger LOG = Logger.getLogger(_BillWould.class);

  public BillWould localInstanceIn(EOEditingContext editingContext) {
    BillWould localInstance = (BillWould)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String sentence() {
    return (String) storedValueForKey(_BillWould.SENTENCE_KEY);
  }

  public void setSentence(String value) {
    if (_BillWould.LOG.isDebugEnabled()) {
    	_BillWould.LOG.debug( "updating sentence from " + sentence() + " to " + value);
    }
    takeStoredValueForKey(value, _BillWould.SENTENCE_KEY);
  }

  public Integer versionPk() {
    return (Integer) storedValueForKey(_BillWould.VERSION_PK_KEY);
  }

  public void setVersionPk(Integer value) {
    if (_BillWould.LOG.isDebugEnabled()) {
    	_BillWould.LOG.debug( "updating versionPk from " + versionPk() + " to " + value);
    }
    takeStoredValueForKey(value, _BillWould.VERSION_PK_KEY);
  }

  public org.ganymede.leginfo.eo.BillVersion billVersion() {
    return (org.ganymede.leginfo.eo.BillVersion)storedValueForKey(_BillWould.BILL_VERSION_KEY);
  }
  
  public void setBillVersion(org.ganymede.leginfo.eo.BillVersion value) {
    takeStoredValueForKey(value, _BillWould.BILL_VERSION_KEY);
  }

  public void setBillVersionRelationship(org.ganymede.leginfo.eo.BillVersion value) {
    if (_BillWould.LOG.isDebugEnabled()) {
      _BillWould.LOG.debug("updating billVersion from " + billVersion() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setBillVersion(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.BillVersion oldValue = billVersion();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillWould.BILL_VERSION_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _BillWould.BILL_VERSION_KEY);
    }
  }
  

  public static BillWould createBillWould(EOEditingContext editingContext, String sentence
, Integer versionPk
, org.ganymede.leginfo.eo.BillVersion billVersion) {
    BillWould eo = (BillWould) EOUtilities.createAndInsertInstance(editingContext, _BillWould.ENTITY_NAME);    
		eo.setSentence(sentence);
		eo.setVersionPk(versionPk);
    eo.setBillVersionRelationship(billVersion);
    return eo;
  }

  public static ERXFetchSpecification<BillWould> fetchSpec() {
    return new ERXFetchSpecification<BillWould>(_BillWould.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillWould> fetchAllBillWoulds(EOEditingContext editingContext) {
    return _BillWould.fetchAllBillWoulds(editingContext, null);
  }

  public static NSArray<BillWould> fetchAllBillWoulds(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillWould.fetchBillWoulds(editingContext, null, sortOrderings);
  }

  public static NSArray<BillWould> fetchBillWoulds(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillWould> fetchSpec = new ERXFetchSpecification<BillWould>(_BillWould.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillWould> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillWould fetchBillWould(EOEditingContext editingContext, String keyName, Object value) {
    return _BillWould.fetchBillWould(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillWould fetchBillWould(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillWould> eoObjects = _BillWould.fetchBillWoulds(editingContext, qualifier, null);
    BillWould eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillWould that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillWould fetchRequiredBillWould(EOEditingContext editingContext, String keyName, Object value) {
    return _BillWould.fetchRequiredBillWould(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillWould fetchRequiredBillWould(EOEditingContext editingContext, EOQualifier qualifier) {
    BillWould eoObject = _BillWould.fetchBillWould(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillWould that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillWould localInstanceIn(EOEditingContext editingContext, BillWould eo) {
    BillWould localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
