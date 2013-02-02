// DO NOT EDIT.  Make changes to BillType.java instead.
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
public abstract class _BillType extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillType";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.Bill> BILLS = new ERXKey<org.ganymede.leginfo.eo.Bill>("bills");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String BILLS_KEY = BILLS.key();

  private static Logger LOG = Logger.getLogger(_BillType.class);

  public BillType localInstanceIn(EOEditingContext editingContext) {
    BillType localInstance = (BillType)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_BillType.NAME_KEY);
  }

  public void setName(String value) {
    if (_BillType.LOG.isDebugEnabled()) {
        _BillType.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _BillType.NAME_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.Bill> bills() {
    return (NSArray<org.ganymede.leginfo.eo.Bill>)storedValueForKey(_BillType.BILLS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.Bill> bills(EOQualifier qualifier) {
    return bills(qualifier, null);
  }

  public NSArray<org.ganymede.leginfo.eo.Bill> bills(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.ganymede.leginfo.eo.Bill> results;
      results = bills();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Bill>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Bill>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToBills(org.ganymede.leginfo.eo.Bill object) {
    includeObjectIntoPropertyWithKey(object, _BillType.BILLS_KEY);
  }

  public void removeFromBills(org.ganymede.leginfo.eo.Bill object) {
    excludeObjectFromPropertyWithKey(object, _BillType.BILLS_KEY);
  }

  public void addToBillsRelationship(org.ganymede.leginfo.eo.Bill object) {
    if (_BillType.LOG.isDebugEnabled()) {
      _BillType.LOG.debug("adding " + object + " to bills relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToBills(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _BillType.BILLS_KEY);
    }
  }

  public void removeFromBillsRelationship(org.ganymede.leginfo.eo.Bill object) {
    if (_BillType.LOG.isDebugEnabled()) {
      _BillType.LOG.debug("removing " + object + " from bills relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromBills(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _BillType.BILLS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.Bill createBillsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.Bill.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BillType.BILLS_KEY);
    return (org.ganymede.leginfo.eo.Bill) eo;
  }

  public void deleteBillsRelationship(org.ganymede.leginfo.eo.Bill object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BillType.BILLS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBillsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.Bill> objects = bills().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBillsRelationship(objects.nextElement());
    }
  }


  public static BillType createBillType(EOEditingContext editingContext, String name
) {
    BillType eo = (BillType) EOUtilities.createAndInsertInstance(editingContext, _BillType.ENTITY_NAME);
        eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<BillType> fetchSpec() {
    return new ERXFetchSpecification<BillType>(_BillType.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillType> fetchAllBillTypes(EOEditingContext editingContext) {
    return _BillType.fetchAllBillTypes(editingContext, null);
  }

  public static NSArray<BillType> fetchAllBillTypes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillType.fetchBillTypes(editingContext, null, sortOrderings);
  }

  public static NSArray<BillType> fetchBillTypes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillType> fetchSpec = new ERXFetchSpecification<BillType>(_BillType.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillType> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillType fetchBillType(EOEditingContext editingContext, String keyName, Object value) {
    return _BillType.fetchBillType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillType fetchBillType(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillType> eoObjects = _BillType.fetchBillTypes(editingContext, qualifier, null);
    BillType eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillType fetchRequiredBillType(EOEditingContext editingContext, String keyName, Object value) {
    return _BillType.fetchRequiredBillType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillType fetchRequiredBillType(EOEditingContext editingContext, EOQualifier qualifier) {
    BillType eoObject = _BillType.fetchBillType(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillType localInstanceIn(EOEditingContext editingContext, BillType eo) {
    BillType localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
