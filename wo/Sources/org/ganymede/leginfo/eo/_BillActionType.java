// DO NOT EDIT.  Make changes to BillActionType.java instead.
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
public abstract class _BillActionType extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillActionType";

  // Attribute Keys
  public static final ERXKey<String> ACTION = new ERXKey<String>("action");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillAction> BILL_ACTIONS = new ERXKey<org.ganymede.leginfo.eo.BillAction>("billActions");

  // Attributes
  public static final String ACTION_KEY = ACTION.key();
  // Relationships
  public static final String BILL_ACTIONS_KEY = BILL_ACTIONS.key();

  private static Logger LOG = Logger.getLogger(_BillActionType.class);

  public BillActionType localInstanceIn(EOEditingContext editingContext) {
    BillActionType localInstance = (BillActionType)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String action() {
    return (String) storedValueForKey(_BillActionType.ACTION_KEY);
  }

  public void setAction(String value) {
    if (_BillActionType.LOG.isDebugEnabled()) {
    	_BillActionType.LOG.debug( "updating action from " + action() + " to " + value);
    }
    takeStoredValueForKey(value, _BillActionType.ACTION_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAction> billActions() {
    return (NSArray<org.ganymede.leginfo.eo.BillAction>)storedValueForKey(_BillActionType.BILL_ACTIONS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAction> billActions(EOQualifier qualifier) {
    return billActions(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAction> billActions(EOQualifier qualifier, boolean fetch) {
    return billActions(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAction> billActions(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.BillAction> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.BillAction.BILL_ACTION_TYPE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.BillAction.fetchBillActions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = billActions();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillAction>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillAction>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToBillActions(org.ganymede.leginfo.eo.BillAction object) {
    includeObjectIntoPropertyWithKey(object, _BillActionType.BILL_ACTIONS_KEY);
  }

  public void removeFromBillActions(org.ganymede.leginfo.eo.BillAction object) {
    excludeObjectFromPropertyWithKey(object, _BillActionType.BILL_ACTIONS_KEY);
  }

  public void addToBillActionsRelationship(org.ganymede.leginfo.eo.BillAction object) {
    if (_BillActionType.LOG.isDebugEnabled()) {
      _BillActionType.LOG.debug("adding " + object + " to billActions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToBillActions(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _BillActionType.BILL_ACTIONS_KEY);
    }
  }

  public void removeFromBillActionsRelationship(org.ganymede.leginfo.eo.BillAction object) {
    if (_BillActionType.LOG.isDebugEnabled()) {
      _BillActionType.LOG.debug("removing " + object + " from billActions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromBillActions(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _BillActionType.BILL_ACTIONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillAction createBillActionsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillAction.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BillActionType.BILL_ACTIONS_KEY);
    return (org.ganymede.leginfo.eo.BillAction) eo;
  }

  public void deleteBillActionsRelationship(org.ganymede.leginfo.eo.BillAction object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BillActionType.BILL_ACTIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBillActionsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillAction> objects = billActions().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBillActionsRelationship(objects.nextElement());
    }
  }


  public static BillActionType createBillActionType(EOEditingContext editingContext, String action
) {
    BillActionType eo = (BillActionType) EOUtilities.createAndInsertInstance(editingContext, _BillActionType.ENTITY_NAME);    
		eo.setAction(action);
    return eo;
  }

  public static ERXFetchSpecification<BillActionType> fetchSpec() {
    return new ERXFetchSpecification<BillActionType>(_BillActionType.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillActionType> fetchAllBillActionTypes(EOEditingContext editingContext) {
    return _BillActionType.fetchAllBillActionTypes(editingContext, null);
  }

  public static NSArray<BillActionType> fetchAllBillActionTypes(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillActionType.fetchBillActionTypes(editingContext, null, sortOrderings);
  }

  public static NSArray<BillActionType> fetchBillActionTypes(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillActionType> fetchSpec = new ERXFetchSpecification<BillActionType>(_BillActionType.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillActionType> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillActionType fetchBillActionType(EOEditingContext editingContext, String keyName, Object value) {
    return _BillActionType.fetchBillActionType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillActionType fetchBillActionType(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillActionType> eoObjects = _BillActionType.fetchBillActionTypes(editingContext, qualifier, null);
    BillActionType eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillActionType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillActionType fetchRequiredBillActionType(EOEditingContext editingContext, String keyName, Object value) {
    return _BillActionType.fetchRequiredBillActionType(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillActionType fetchRequiredBillActionType(EOEditingContext editingContext, EOQualifier qualifier) {
    BillActionType eoObject = _BillActionType.fetchBillActionType(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillActionType that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillActionType localInstanceIn(EOEditingContext editingContext, BillActionType eo) {
    BillActionType localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
