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
  public static final ERXKey<String> AUTHORS_STR = new ERXKey<String>("authorsStr");
  public static final ERXKey<String> AUTHS_PARSED = new ERXKey<String>("authsParsed");
  public static final ERXKey<String> COAUTHORS_STR = new ERXKey<String>("coauthorsStr");
  public static final ERXKey<String> FILE = new ERXKey<String>("file");
  public static final ERXKey<String> FILE_DATE = new ERXKey<String>("fileDate");
  public static final ERXKey<String> KIND = new ERXKey<String>("kind");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillAuthoring> AUTHORINGS = new ERXKey<org.ganymede.leginfo.eo.BillAuthoring>("authorings");
  public static final ERXKey<org.ganymede.leginfo.eo.Bill> BILL = new ERXKey<org.ganymede.leginfo.eo.Bill>("bill");
  public static final ERXKey<org.ganymede.leginfo.eo.CodeSection> CODE_SECTIONS = new ERXKey<org.ganymede.leginfo.eo.CodeSection>("codeSections");
  public static final ERXKey<org.ganymede.leginfo.eo.BillWould> WOULDS = new ERXKey<org.ganymede.leginfo.eo.BillWould>("woulds");

  // Attributes
  public static final String AUTHORS_STR_KEY = AUTHORS_STR.key();
  public static final String AUTHS_PARSED_KEY = AUTHS_PARSED.key();
  public static final String COAUTHORS_STR_KEY = COAUTHORS_STR.key();
  public static final String FILE_KEY = FILE.key();
  public static final String FILE_DATE_KEY = FILE_DATE.key();
  public static final String KIND_KEY = KIND.key();
  public static final String TITLE_KEY = TITLE.key();
  // Relationships
  public static final String AUTHORINGS_KEY = AUTHORINGS.key();
  public static final String BILL_KEY = BILL.key();
  public static final String CODE_SECTIONS_KEY = CODE_SECTIONS.key();
  public static final String WOULDS_KEY = WOULDS.key();

  private static Logger LOG = Logger.getLogger(_BillVersion.class);

  public BillVersion localInstanceIn(EOEditingContext editingContext) {
    BillVersion localInstance = (BillVersion)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String authorsStr() {
    return (String) storedValueForKey(_BillVersion.AUTHORS_STR_KEY);
  }

  public void setAuthorsStr(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating authorsStr from " + authorsStr() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.AUTHORS_STR_KEY);
  }

  public String authsParsed() {
    return (String) storedValueForKey(_BillVersion.AUTHS_PARSED_KEY);
  }

  public void setAuthsParsed(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating authsParsed from " + authsParsed() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.AUTHS_PARSED_KEY);
  }

  public String coauthorsStr() {
    return (String) storedValueForKey(_BillVersion.COAUTHORS_STR_KEY);
  }

  public void setCoauthorsStr(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating coauthorsStr from " + coauthorsStr() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.COAUTHORS_STR_KEY);
  }

  public String file() {
    return (String) storedValueForKey(_BillVersion.FILE_KEY);
  }

  public void setFile(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating file from " + file() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.FILE_KEY);
  }

  public String fileDate() {
    return (String) storedValueForKey(_BillVersion.FILE_DATE_KEY);
  }

  public void setFileDate(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating fileDate from " + fileDate() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.FILE_DATE_KEY);
  }

  public String kind() {
    return (String) storedValueForKey(_BillVersion.KIND_KEY);
  }

  public void setKind(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating kind from " + kind() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.KIND_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_BillVersion.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_BillVersion.LOG.isDebugEnabled()) {
        _BillVersion.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _BillVersion.TITLE_KEY);
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

  public NSArray<org.ganymede.leginfo.eo.BillAuthoring> authorings() {
    return (NSArray<org.ganymede.leginfo.eo.BillAuthoring>)storedValueForKey(_BillVersion.AUTHORINGS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAuthoring> authorings(EOQualifier qualifier) {
    return authorings(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAuthoring> authorings(EOQualifier qualifier, boolean fetch) {
    return authorings(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAuthoring> authorings(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.BillAuthoring> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.BillAuthoring.BILL_VERSION_KEY, EOQualifier.QualifierOperatorEqual, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.BillAuthoring.fetchBillAuthorings(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = authorings();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillAuthoring>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillAuthoring>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToAuthorings(org.ganymede.leginfo.eo.BillAuthoring object) {
    includeObjectIntoPropertyWithKey(object, _BillVersion.AUTHORINGS_KEY);
  }

  public void removeFromAuthorings(org.ganymede.leginfo.eo.BillAuthoring object) {
    excludeObjectFromPropertyWithKey(object, _BillVersion.AUTHORINGS_KEY);
  }

  public void addToAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("adding " + object + " to authorings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToAuthorings(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _BillVersion.AUTHORINGS_KEY);
    }
  }

  public void removeFromAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("removing " + object + " from authorings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromAuthorings(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.AUTHORINGS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillAuthoring createAuthoringsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillAuthoring.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BillVersion.AUTHORINGS_KEY);
    return (org.ganymede.leginfo.eo.BillAuthoring) eo;
  }

  public void deleteAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.AUTHORINGS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAuthoringsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillAuthoring> objects = authorings().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAuthoringsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.ganymede.leginfo.eo.CodeSection> codeSections() {
    return (NSArray<org.ganymede.leginfo.eo.CodeSection>)storedValueForKey(_BillVersion.CODE_SECTIONS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.CodeSection> codeSections(EOQualifier qualifier) {
    return codeSections(qualifier, null);
  }

  public NSArray<org.ganymede.leginfo.eo.CodeSection> codeSections(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.ganymede.leginfo.eo.CodeSection> results;
      results = codeSections();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.CodeSection>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.CodeSection>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToCodeSections(org.ganymede.leginfo.eo.CodeSection object) {
    includeObjectIntoPropertyWithKey(object, _BillVersion.CODE_SECTIONS_KEY);
  }

  public void removeFromCodeSections(org.ganymede.leginfo.eo.CodeSection object) {
    excludeObjectFromPropertyWithKey(object, _BillVersion.CODE_SECTIONS_KEY);
  }

  public void addToCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("adding " + object + " to codeSections relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToCodeSections(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _BillVersion.CODE_SECTIONS_KEY);
    }
  }

  public void removeFromCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    if (_BillVersion.LOG.isDebugEnabled()) {
      _BillVersion.LOG.debug("removing " + object + " from codeSections relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromCodeSections(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.CODE_SECTIONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.CodeSection createCodeSectionsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.CodeSection.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _BillVersion.CODE_SECTIONS_KEY);
    return (org.ganymede.leginfo.eo.CodeSection) eo;
  }

  public void deleteCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _BillVersion.CODE_SECTIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCodeSectionsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.CodeSection> objects = codeSections().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCodeSectionsRelationship(objects.nextElement());
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


  public static BillVersion createBillVersion(EOEditingContext editingContext, String file
, String fileDate
, String kind
, String title
, org.ganymede.leginfo.eo.Bill bill) {
    BillVersion eo = (BillVersion) EOUtilities.createAndInsertInstance(editingContext, _BillVersion.ENTITY_NAME);
        eo.setFile(file);
        eo.setFileDate(fileDate);
        eo.setKind(kind);
        eo.setTitle(title);
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
