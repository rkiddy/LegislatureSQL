// DO NOT EDIT.  Make changes to CodeSection.java instead.
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
public abstract class _CodeSection extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "CodeSection";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillVersion> BILL_VERSIONS = new ERXKey<org.ganymede.leginfo.eo.BillVersion>("billVersions");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String BILL_VERSIONS_KEY = BILL_VERSIONS.key();

  private static Logger LOG = Logger.getLogger(_CodeSection.class);

  public CodeSection localInstanceIn(EOEditingContext editingContext) {
    CodeSection localInstance = (CodeSection)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_CodeSection.NAME_KEY);
  }

  public void setName(String value) {
    if (_CodeSection.LOG.isDebugEnabled()) {
    	_CodeSection.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _CodeSection.NAME_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> billVersions() {
    return (NSArray<org.ganymede.leginfo.eo.BillVersion>)storedValueForKey(_CodeSection.BILL_VERSIONS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> billVersions(EOQualifier qualifier) {
    return billVersions(qualifier, null);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> billVersions(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.ganymede.leginfo.eo.BillVersion> results;
      results = billVersions();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillVersion>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillVersion>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }
  
  public void addToBillVersions(org.ganymede.leginfo.eo.BillVersion object) {
    includeObjectIntoPropertyWithKey(object, _CodeSection.BILL_VERSIONS_KEY);
  }

  public void removeFromBillVersions(org.ganymede.leginfo.eo.BillVersion object) {
    excludeObjectFromPropertyWithKey(object, _CodeSection.BILL_VERSIONS_KEY);
  }

  public void addToBillVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    if (_CodeSection.LOG.isDebugEnabled()) {
      _CodeSection.LOG.debug("adding " + object + " to billVersions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToBillVersions(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _CodeSection.BILL_VERSIONS_KEY);
    }
  }

  public void removeFromBillVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    if (_CodeSection.LOG.isDebugEnabled()) {
      _CodeSection.LOG.debug("removing " + object + " from billVersions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromBillVersions(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _CodeSection.BILL_VERSIONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillVersion createBillVersionsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillVersion.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _CodeSection.BILL_VERSIONS_KEY);
    return (org.ganymede.leginfo.eo.BillVersion) eo;
  }

  public void deleteBillVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _CodeSection.BILL_VERSIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBillVersionsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillVersion> objects = billVersions().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBillVersionsRelationship(objects.nextElement());
    }
  }


  public static CodeSection createCodeSection(EOEditingContext editingContext, String name
) {
    CodeSection eo = (CodeSection) EOUtilities.createAndInsertInstance(editingContext, _CodeSection.ENTITY_NAME);    
		eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<CodeSection> fetchSpec() {
    return new ERXFetchSpecification<CodeSection>(_CodeSection.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<CodeSection> fetchAllCodeSections(EOEditingContext editingContext) {
    return _CodeSection.fetchAllCodeSections(editingContext, null);
  }

  public static NSArray<CodeSection> fetchAllCodeSections(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _CodeSection.fetchCodeSections(editingContext, null, sortOrderings);
  }

  public static NSArray<CodeSection> fetchCodeSections(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<CodeSection> fetchSpec = new ERXFetchSpecification<CodeSection>(_CodeSection.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<CodeSection> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static CodeSection fetchCodeSection(EOEditingContext editingContext, String keyName, Object value) {
    return _CodeSection.fetchCodeSection(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CodeSection fetchCodeSection(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<CodeSection> eoObjects = _CodeSection.fetchCodeSections(editingContext, qualifier, null);
    CodeSection eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one CodeSection that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CodeSection fetchRequiredCodeSection(EOEditingContext editingContext, String keyName, Object value) {
    return _CodeSection.fetchRequiredCodeSection(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static CodeSection fetchRequiredCodeSection(EOEditingContext editingContext, EOQualifier qualifier) {
    CodeSection eoObject = _CodeSection.fetchCodeSection(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no CodeSection that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static CodeSection localInstanceIn(EOEditingContext editingContext, CodeSection eo) {
    CodeSection localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
