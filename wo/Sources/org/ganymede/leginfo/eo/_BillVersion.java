// DO NOT EDIT.  Make changes to BillVersion.java instead.
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
public abstract class _BillVersion extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "BillVersion";

  // Attribute Keys
  public static final ERXKey<String> VERSION_DATE = new ERXKey<String>("versionDate");
  public static final ERXKey<String> VERSION_FILE = new ERXKey<String>("versionFile");
  public static final ERXKey<String> VERSION_TYPE = new ERXKey<String>("versionType");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.Bill> BILL = new ERXKey<org.ganymede.leginfo.eo.Bill>("bill");
  public static final ERXKey<org.ganymede.leginfo.eo.BillWould> WOULDS = new ERXKey<org.ganymede.leginfo.eo.BillWould>("woulds");

  // Attributes
  public static final String VERSION_DATE_KEY = VERSION_DATE.key();
  public static final String VERSION_FILE_KEY = VERSION_FILE.key();
  public static final String VERSION_TYPE_KEY = VERSION_TYPE.key();
  // Relationships
  public static final String BILL_KEY = BILL.key();
  public static final String WOULDS_KEY = WOULDS.key();

  private static Logger LOG = Logger.getLogger(_BillVersion.class);

  public BillVersion localInstanceIn(EOEditingContext editingContext) {
    BillVersion localInstance = (BillVersion)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String versionDate() {
    return (String) storedValueForKey(_BillVersion.VERSION_DATE_KEY);
  }

  public void setVersionDate(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
    	_BillVersion.LOG.debug( "updating versionDate from " + versionDate() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.VERSION_DATE_KEY);
  }

  public String versionFile() {
    return (String) storedValueForKey(_BillVersion.VERSION_FILE_KEY);
  }

  public void setVersionFile(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
    	_BillVersion.LOG.debug( "updating versionFile from " + versionFile() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.VERSION_FILE_KEY);
  }

  public String versionType() {
    return (String) storedValueForKey(_BillVersion.VERSION_TYPE_KEY);
  }

  public void setVersionType(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
    	_BillVersion.LOG.debug( "updating versionType from " + versionType() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.VERSION_TYPE_KEY);
  }

  public org.ganymede.leginfo.eo.Bill bill() {
    return (org.ganymede.leginfo.eo.Bill)storedValueForKey(_BillVersion.BILL_KEY);
  }
  
  public void setBill(org.ganymede.leginfo.eo.Bill value) {
    takeStoredValueForKey(value, _BillVersion.BILL_KEY);
  }

  public void setBillRelationship(org.ganymede.leginfo.eo.Bill value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("updating bill from " + bill() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setBill(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.Bill oldValue = bill();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _BillVersion.BILL_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _BillVersion.BILL_KEY);
    }
  }
  
  public NSArray<org.ganymede.leginfo.eo.BillWould> woulds() {
    return (NSArray<org.ganymede.leginfo.eo.BillWould>)storedValueForKey(_BillVersion.WOULDS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillWould> woulds(EOQualifier qualifier) {
    return woulds(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.BillWould> woulds(EOQualifier qualifier, boolean fetch) {
    return woulds(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.BillWould> woulds(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.BillWould> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.BillWould.BILL_VERSION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.BillWould.fetchBillWoulds(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = woulds();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillWould>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillWould>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToWoulds(org.ganymede.leginfo.eo.BillWould object) {
    includeObjectIntoPropertyWithKey(object, _BillVersion.WOULDS_KEY);
  }

  public void removeFromWoulds(org.ganymede.leginfo.eo.BillWould object) {
    excludeObjectFromPropertyWithKey(object, _BillVersion.WOULDS_KEY);
  }

  public void addToWouldsRelationship(org.ganymede.leginfo.eo.BillWould object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("adding " + object + " to woulds relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToWoulds(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _BillVersion.WOULDS_KEY);
    }
  }

  public void removeFromWouldsRelationship(org.ganymede.leginfo.eo.BillWould object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("removing " + object + " from woulds relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromWoulds(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.WOULDS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillWould createWouldsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillWould.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BillVersion.WOULDS_KEY);
    return (org.ganymede.leginfo.eo.BillWould) eo;
  }

  public void deleteWouldsRelationship(org.ganymede.leginfo.eo.BillWould object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.WOULDS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllWouldsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillWould> objects = woulds().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteWouldsRelationship(objects.nextElement());
    }
  }


  public static BillVersion createBillVersion(EOEditingContext editingContext, String versionDate
, String versionFile
, String versionType
, org.ganymede.leginfo.eo.Bill bill) {
    BillVersion eo = (BillVersion) EOUtilities.createAndInsertInstance(editingContext, _BillVersion.ENTITY_NAME);    
		eo.setVersionDate(versionDate);
		eo.setVersionFile(versionFile);
		eo.setVersionType(versionType);
    eo.setBillRelationship(bill);
    return eo;
  }

  public static ERXFetchSpecification<BillVersion> fetchSpec() {
    return new ERXFetchSpecification<BillVersion>(_BillVersion.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<BillVersion> fetchAllBillVersions(EOEditingContext editingContext) {
    return _BillVersion.fetchAllBillVersions(editingContext, null);
  }

  public static NSArray<BillVersion> fetchAllBillVersions(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BillVersion.fetchBillVersions(editingContext, null, sortOrderings);
  }

  public static NSArray<BillVersion> fetchBillVersions(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<BillVersion> fetchSpec = new ERXFetchSpecification<BillVersion>(_BillVersion.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BillVersion> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static BillVersion fetchBillVersion(EOEditingContext editingContext, String keyName, Object value) {
    return _BillVersion.fetchBillVersion(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillVersion fetchBillVersion(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BillVersion> eoObjects = _BillVersion.fetchBillVersions(editingContext, qualifier, null);
    BillVersion eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one BillVersion that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillVersion fetchRequiredBillVersion(EOEditingContext editingContext, String keyName, Object value) {
    return _BillVersion.fetchRequiredBillVersion(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BillVersion fetchRequiredBillVersion(EOEditingContext editingContext, EOQualifier qualifier) {
    BillVersion eoObject = _BillVersion.fetchBillVersion(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BillVersion that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BillVersion localInstanceIn(EOEditingContext editingContext, BillVersion eo) {
    BillVersion localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
