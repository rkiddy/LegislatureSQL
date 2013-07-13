// DO NOT EDIT.  Make changes to BillAction.java instead.
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
public abstract class _BillAction extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillAction";

  // Attribute Keys
  public static final ERXKey<String> ACTION = new ERXKey<String>("action");
  public static final ERXKey<Integer> ACTION_NUM = new ERXKey<Integer>("actionNum");
  public static final ERXKey<String> WHEN_ACT = new ERXKey<String>("whenAct");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.Bill> BILL = new ERXKey<org.ganymede.leginfo.eo.Bill>("bill");
  public static final ERXKey<org.ganymede.leginfo.eo.BillActionType> BILL_ACTION_TYPE = new ERXKey<org.ganymede.leginfo.eo.BillActionType>("billActionType");

  // Attributes
  public static final String ACTION_KEY = ACTION.key();
  public static final String ACTION_NUM_KEY = ACTION_NUM.key();
  public static final String WHEN_ACT_KEY = WHEN_ACT.key();
  // Relationships
  public static final String BILL_KEY = BILL.key();
  public static final String BILL_ACTION_TYPE_KEY = BILL_ACTION_TYPE.key();

  private static Logger LOG = Logger.getLogger(_BillAction.class);

  public BillAction localInstanceIn(EOEditingContext editingContext) {
    BillAction localInstance = (BillAction)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String action() {
    return (String) storedValueForKey(_BillAction.ACTION_KEY);
  }

  public void setAction(String value) {
    if (_BillAction.LOG.isDebugEnabled()) {
    	_BillAction.LOG.debug( "updating action from " + action() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAction.ACTION_KEY);
  }

  public Integer actionNum() {
    return (Integer) storedValueForKey(_BillAction.ACTION_NUM_KEY);
  }

  public void setActionNum(Integer value) {
    if (_BillAction.LOG.isDebugEnabled()) {
    	_BillAction.LOG.debug( "updating actionNum from " + actionNum() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAction.ACTION_NUM_KEY);
  }

  public String whenAct() {
    return (String) storedValueForKey(_BillAction.WHEN_ACT_KEY);
  }

  public void setWhenAct(String value) {
    if (_BillAction.LOG.isDebugEnabled()) {
    	_BillAction.LOG.debug( "updating whenAct from " + whenAct() + " to " + value);
    }
    takeStoredValueForKey(value, _BillAction.WHEN_ACT_KEY);
  }

  public org.ganymede.leginfo.eo.Bill bill() {
    return (org.ganymede.leginfo.eo.Bill)storedValueForKey(_BillAction.BILL_KEY);
  }
  
  public void setBill(org.ganymede.leginfo.eo.Bill value) {
    takeStoredValueForKey(value, _BillAction.BILL_KEY);
  }

  public void setBillRelationship(org.ganymede.leginfo.eo.Bill value) {
    if (_BillAction.LOG.isDebugEnabled()) {
      _BillAction.LOG.debug("updating bill from " + bill() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setBill(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.Bill oldValue = bill();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillAction.BILL_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _BillAction.BILL_KEY);
    }
  }
  
  public org.ganymede.leginfo.eo.BillActionType billActionType() {
    return (org.ganymede.leginfo.eo.BillActionType)storedValueForKey(_BillAction.BILL_ACTION_TYPE_KEY);
  }
  
  public void setBillActionType(org.ganymede.leginfo.eo.BillActionType value) {
    takeStoredValueForKey(value, _BillAction.BILL_ACTION_TYPE_KEY);
  }

  public void setBillActionTypeRelationship(org.ganymede.leginfo.eo.BillActionType value) {
    if (_BillAction.LOG.isDebugEnabled()) {
      _BillAction.LOG.debug("updating billActionType from " + billActionType() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setBillActionType(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.BillActionType oldValue = billActionType();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillAction.BILL_ACTION_TYPE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _BillAction.BILL_ACTION_TYPE_KEY);
    }
  }
  

  public static BillAction createBillAction(EOEditingContext editingContext, String action
, Integer actionNum
, String whenAct
, org.ganymede.leginfo.eo.Bill bill) {
    BillAction eo = (BillAction) EOUtilities.createAndInsertInstance(editingContext, _BillAction.ENTITY_NAME);    
		eo.setAction(action);
		eo.setActionNum(actionNum);
		eo.setWhenAct(whenAct);
    eo.setBillRelationship(bill);
    return eo;
  }

  public static ERXFetchSpecification<BillAction> fetchSpec() {
    return new ERXFetchSpecification<BillAction>(_BillAction.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillAction> fetchAllBillActions(EOEditingContext editingContext) {
    return _BillAction.fetchAllBillActions(editingContext, null);
  }

  public static NSArray<BillAction> fetchAllBillActions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillAction.fetchBillActions(editingContext, null, sortOrderings);
  }

  public static NSArray<BillAction> fetchBillActions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillAction> fetchSpec = new ERXFetchSpecification<BillAction>(_BillAction.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillAction> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillAction fetchBillAction(EOEditingContext editingContext, String keyName, Object value) {
    return _BillAction.fetchBillAction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillAction fetchBillAction(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillAction> eoObjects = _BillAction.fetchBillActions(editingContext, qualifier, null);
    BillAction eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillAction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillAction fetchRequiredBillAction(EOEditingContext editingContext, String keyName, Object value) {
    return _BillAction.fetchRequiredBillAction(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillAction fetchRequiredBillAction(EOEditingContext editingContext, EOQualifier qualifier) {
    BillAction eoObject = _BillAction.fetchBillAction(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillAction that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillAction localInstanceIn(EOEditingContext editingContext, BillAction eo) {
    BillAction localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
