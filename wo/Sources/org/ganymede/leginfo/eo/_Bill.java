// DO NOT EDIT.  Make changes to Bill.java instead.
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
public abstract class _Bill extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Bill";

  // Attribute Keys
  public static final ERXKey<String> AUTHORS = new ERXKey<String>("authors");
  public static final ERXKey<String> BILL_NUM = new ERXKey<String>("billNum");
  public static final ERXKey<String> COMM_ACTION = new ERXKey<String>("commAction");
  public static final ERXKey<String> COMM_ACTION_DATE = new ERXKey<String>("commActionDate");
  public static final ERXKey<String> COMM_LOCATION = new ERXKey<String>("commLocation");
  public static final ERXKey<String> COMM_VOTE_SUMMARY = new ERXKey<String>("commVoteSummary");
  public static final ERXKey<String> FILE_DATE = new ERXKey<String>("fileDate");
  public static final ERXKey<String> FILE_LOCATION = new ERXKey<String>("fileLocation");
  public static final ERXKey<String> HEARING_DATE = new ERXKey<String>("hearingDate");
  public static final ERXKey<String> HISTORY_FILE = new ERXKey<String>("historyFile");
  public static final ERXKey<String> HOUSE_LOCATION = new ERXKey<String>("houseLocation");
  public static final ERXKey<String> ITEM = new ERXKey<String>("item");
  public static final ERXKey<String> LAST_AMENDED_DATE = new ERXKey<String>("lastAmendedDate");
  public static final ERXKey<String> LAST_HIST_ACT_DATE = new ERXKey<String>("lastHistActDate");
  public static final ERXKey<String> LAST_HIST_ACTION = new ERXKey<String>("lastHistAction");
  public static final ERXKey<String> MEASURE = new ERXKey<String>("measure");
  public static final ERXKey<String> SESSION_YRS = new ERXKey<String>("sessionYrs");
  public static final ERXKey<String> STATUS_DATE = new ERXKey<String>("statusDate");
  public static final ERXKey<String> STATUS_FILE = new ERXKey<String>("statusFile");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  public static final ERXKey<String> TOPIC = new ERXKey<String>("topic");
  public static final ERXKey<String> TYPE_OF_BILL = new ERXKey<String>("typeOfBill");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillType> BILL_TYPES = new ERXKey<org.ganymede.leginfo.eo.BillType>("billTypes");
  public static final ERXKey<org.ganymede.leginfo.eo.CodeSection> CODE_SECTIONS = new ERXKey<org.ganymede.leginfo.eo.CodeSection>("codeSections");
  public static final ERXKey<org.ganymede.leginfo.eo.BillVersion> VERSIONS = new ERXKey<org.ganymede.leginfo.eo.BillVersion>("versions");

  // Attributes
  public static final String AUTHORS_KEY = AUTHORS.key();
  public static final String BILL_NUM_KEY = BILL_NUM.key();
  public static final String COMM_ACTION_KEY = COMM_ACTION.key();
  public static final String COMM_ACTION_DATE_KEY = COMM_ACTION_DATE.key();
  public static final String COMM_LOCATION_KEY = COMM_LOCATION.key();
  public static final String COMM_VOTE_SUMMARY_KEY = COMM_VOTE_SUMMARY.key();
  public static final String FILE_DATE_KEY = FILE_DATE.key();
  public static final String FILE_LOCATION_KEY = FILE_LOCATION.key();
  public static final String HEARING_DATE_KEY = HEARING_DATE.key();
  public static final String HISTORY_FILE_KEY = HISTORY_FILE.key();
  public static final String HOUSE_LOCATION_KEY = HOUSE_LOCATION.key();
  public static final String ITEM_KEY = ITEM.key();
  public static final String LAST_AMENDED_DATE_KEY = LAST_AMENDED_DATE.key();
  public static final String LAST_HIST_ACT_DATE_KEY = LAST_HIST_ACT_DATE.key();
  public static final String LAST_HIST_ACTION_KEY = LAST_HIST_ACTION.key();
  public static final String MEASURE_KEY = MEASURE.key();
  public static final String SESSION_YRS_KEY = SESSION_YRS.key();
  public static final String STATUS_DATE_KEY = STATUS_DATE.key();
  public static final String STATUS_FILE_KEY = STATUS_FILE.key();
  public static final String TITLE_KEY = TITLE.key();
  public static final String TOPIC_KEY = TOPIC.key();
  public static final String TYPE_OF_BILL_KEY = TYPE_OF_BILL.key();
  // Relationships
  public static final String BILL_TYPES_KEY = BILL_TYPES.key();
  public static final String CODE_SECTIONS_KEY = CODE_SECTIONS.key();
  public static final String VERSIONS_KEY = VERSIONS.key();

  private static Logger LOG = Logger.getLogger(_Bill.class);

  public Bill localInstanceIn(EOEditingContext editingContext) {
    Bill localInstance = (Bill)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String authors() {
    return (String) storedValueForKey(_Bill.AUTHORS_KEY);
  }

  public void setAuthors(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating authors from " + authors() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.AUTHORS_KEY);
  }

  public String billNum() {
    return (String) storedValueForKey(_Bill.BILL_NUM_KEY);
  }

  public void setBillNum(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating billNum from " + billNum() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.BILL_NUM_KEY);
  }

  public String commAction() {
    return (String) storedValueForKey(_Bill.COMM_ACTION_KEY);
  }

  public void setCommAction(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating commAction from " + commAction() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.COMM_ACTION_KEY);
  }

  public String commActionDate() {
    return (String) storedValueForKey(_Bill.COMM_ACTION_DATE_KEY);
  }

  public void setCommActionDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating commActionDate from " + commActionDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.COMM_ACTION_DATE_KEY);
  }

  public String commLocation() {
    return (String) storedValueForKey(_Bill.COMM_LOCATION_KEY);
  }

  public void setCommLocation(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating commLocation from " + commLocation() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.COMM_LOCATION_KEY);
  }

  public String commVoteSummary() {
    return (String) storedValueForKey(_Bill.COMM_VOTE_SUMMARY_KEY);
  }

  public void setCommVoteSummary(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating commVoteSummary from " + commVoteSummary() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.COMM_VOTE_SUMMARY_KEY);
  }

  public String fileDate() {
    return (String) storedValueForKey(_Bill.FILE_DATE_KEY);
  }

  public void setFileDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating fileDate from " + fileDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.FILE_DATE_KEY);
  }

  public String fileLocation() {
    return (String) storedValueForKey(_Bill.FILE_LOCATION_KEY);
  }

  public void setFileLocation(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating fileLocation from " + fileLocation() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.FILE_LOCATION_KEY);
  }

  public String hearingDate() {
    return (String) storedValueForKey(_Bill.HEARING_DATE_KEY);
  }

  public void setHearingDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating hearingDate from " + hearingDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.HEARING_DATE_KEY);
  }

  public String historyFile() {
    return (String) storedValueForKey(_Bill.HISTORY_FILE_KEY);
  }

  public void setHistoryFile(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating historyFile from " + historyFile() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.HISTORY_FILE_KEY);
  }

  public String houseLocation() {
    return (String) storedValueForKey(_Bill.HOUSE_LOCATION_KEY);
  }

  public void setHouseLocation(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating houseLocation from " + houseLocation() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.HOUSE_LOCATION_KEY);
  }

  public String item() {
    return (String) storedValueForKey(_Bill.ITEM_KEY);
  }

  public void setItem(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating item from " + item() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.ITEM_KEY);
  }

  public String lastAmendedDate() {
    return (String) storedValueForKey(_Bill.LAST_AMENDED_DATE_KEY);
  }

  public void setLastAmendedDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating lastAmendedDate from " + lastAmendedDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.LAST_AMENDED_DATE_KEY);
  }

  public String lastHistActDate() {
    return (String) storedValueForKey(_Bill.LAST_HIST_ACT_DATE_KEY);
  }

  public void setLastHistActDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating lastHistActDate from " + lastHistActDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.LAST_HIST_ACT_DATE_KEY);
  }

  public String lastHistAction() {
    return (String) storedValueForKey(_Bill.LAST_HIST_ACTION_KEY);
  }

  public void setLastHistAction(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating lastHistAction from " + lastHistAction() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.LAST_HIST_ACTION_KEY);
  }

  public String measure() {
    return (String) storedValueForKey(_Bill.MEASURE_KEY);
  }

  public void setMeasure(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating measure from " + measure() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.MEASURE_KEY);
  }

  public String sessionYrs() {
    return (String) storedValueForKey(_Bill.SESSION_YRS_KEY);
  }

  public void setSessionYrs(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating sessionYrs from " + sessionYrs() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.SESSION_YRS_KEY);
  }

  public String statusDate() {
    return (String) storedValueForKey(_Bill.STATUS_DATE_KEY);
  }

  public void setStatusDate(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating statusDate from " + statusDate() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.STATUS_DATE_KEY);
  }

  public String statusFile() {
    return (String) storedValueForKey(_Bill.STATUS_FILE_KEY);
  }

  public void setStatusFile(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating statusFile from " + statusFile() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.STATUS_FILE_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_Bill.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.TITLE_KEY);
  }

  public String topic() {
    return (String) storedValueForKey(_Bill.TOPIC_KEY);
  }

  public void setTopic(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating topic from " + topic() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.TOPIC_KEY);
  }

  public String typeOfBill() {
    return (String) storedValueForKey(_Bill.TYPE_OF_BILL_KEY);
  }

  public void setTypeOfBill(String value) {
    if (_Bill.LOG.isDebugEnabled()) {
        _Bill.LOG.debug( "updating typeOfBill from " + typeOfBill() + " to " + value);
    }
    takeStoredValueForKey(value, _Bill.TYPE_OF_BILL_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillType> billTypes() {
    return (NSArray<org.ganymede.leginfo.eo.BillType>)storedValueForKey(_Bill.BILL_TYPES_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillType> billTypes(EOQualifier qualifier) {
    return billTypes(qualifier, null);
  }

  public NSArray<org.ganymede.leginfo.eo.BillType> billTypes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.ganymede.leginfo.eo.BillType> results;
      results = billTypes();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillType>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillType>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToBillTypes(org.ganymede.leginfo.eo.BillType object) {
    includeObjectIntoPropertyWithKey(object, _Bill.BILL_TYPES_KEY);
  }

  public void removeFromBillTypes(org.ganymede.leginfo.eo.BillType object) {
    excludeObjectFromPropertyWithKey(object, _Bill.BILL_TYPES_KEY);
  }

  public void addToBillTypesRelationship(org.ganymede.leginfo.eo.BillType object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("adding " + object + " to billTypes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToBillTypes(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _Bill.BILL_TYPES_KEY);
    }
  }

  public void removeFromBillTypesRelationship(org.ganymede.leginfo.eo.BillType object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("removing " + object + " from billTypes relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromBillTypes(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.BILL_TYPES_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillType createBillTypesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillType.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bill.BILL_TYPES_KEY);
    return (org.ganymede.leginfo.eo.BillType) eo;
  }

  public void deleteBillTypesRelationship(org.ganymede.leginfo.eo.BillType object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.BILL_TYPES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllBillTypesRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillType> objects = billTypes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteBillTypesRelationship(objects.nextElement());
    }
  }

  public NSArray<org.ganymede.leginfo.eo.CodeSection> codeSections() {
    return (NSArray<org.ganymede.leginfo.eo.CodeSection>)storedValueForKey(_Bill.CODE_SECTIONS_KEY);
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
    includeObjectIntoPropertyWithKey(object, _Bill.CODE_SECTIONS_KEY);
  }

  public void removeFromCodeSections(org.ganymede.leginfo.eo.CodeSection object) {
    excludeObjectFromPropertyWithKey(object, _Bill.CODE_SECTIONS_KEY);
  }

  public void addToCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("adding " + object + " to codeSections relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToCodeSections(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _Bill.CODE_SECTIONS_KEY);
    }
  }

  public void removeFromCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("removing " + object + " from codeSections relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromCodeSections(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.CODE_SECTIONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.CodeSection createCodeSectionsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.CodeSection.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bill.CODE_SECTIONS_KEY);
    return (org.ganymede.leginfo.eo.CodeSection) eo;
  }

  public void deleteCodeSectionsRelationship(org.ganymede.leginfo.eo.CodeSection object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.CODE_SECTIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllCodeSectionsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.CodeSection> objects = codeSections().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteCodeSectionsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> versions() {
    return (NSArray<org.ganymede.leginfo.eo.BillVersion>)storedValueForKey(_Bill.VERSIONS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> versions(EOQualifier qualifier) {
    return versions(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> versions(EOQualifier qualifier, boolean fetch) {
    return versions(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.BillVersion> versions(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.BillVersion> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.BillVersion.BILL_KEY, EOQualifier.QualifierOperatorEqual, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.BillVersion.fetchBillVersions(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = versions();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillVersion>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.BillVersion>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToVersions(org.ganymede.leginfo.eo.BillVersion object) {
    includeObjectIntoPropertyWithKey(object, _Bill.VERSIONS_KEY);
  }

  public void removeFromVersions(org.ganymede.leginfo.eo.BillVersion object) {
    excludeObjectFromPropertyWithKey(object, _Bill.VERSIONS_KEY);
  }

  public void addToVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("adding " + object + " to versions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        addToVersions(object);
    }
    else {
        addObjectToBothSidesOfRelationshipWithKey(object, _Bill.VERSIONS_KEY);
    }
  }

  public void removeFromVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    if (_Bill.LOG.isDebugEnabled()) {
      _Bill.LOG.debug("removing " + object + " from versions relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        removeFromVersions(object);
    }
    else {
        removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.VERSIONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillVersion createVersionsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillVersion.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Bill.VERSIONS_KEY);
    return (org.ganymede.leginfo.eo.BillVersion) eo;
  }

  public void deleteVersionsRelationship(org.ganymede.leginfo.eo.BillVersion object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Bill.VERSIONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllVersionsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillVersion> objects = versions().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteVersionsRelationship(objects.nextElement());
    }
  }


  public static Bill createBill(EOEditingContext editingContext, String historyFile
, String measure
, String statusDate
, String statusFile
, String title
, String topic
) {
    Bill eo = (Bill) EOUtilities.createAndInsertInstance(editingContext, _Bill.ENTITY_NAME);
        eo.setHistoryFile(historyFile);
        eo.setMeasure(measure);
        eo.setStatusDate(statusDate);
        eo.setStatusFile(statusFile);
        eo.setTitle(title);
        eo.setTopic(topic);
    return eo;
  }

  public static ERXFetchSpecification<Bill> fetchSpec() {
    return new ERXFetchSpecification<Bill>(_Bill.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Bill> fetchAllBills(EOEditingContext editingContext) {
    return _Bill.fetchAllBills(editingContext, null);
  }

  public static NSArray<Bill> fetchAllBills(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Bill.fetchBills(editingContext, null, sortOrderings);
  }

  public static NSArray<Bill> fetchBills(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Bill> fetchSpec = new ERXFetchSpecification<Bill>(_Bill.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Bill> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Bill fetchBill(EOEditingContext editingContext, String keyName, Object value) {
    return _Bill.fetchBill(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Bill fetchBill(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Bill> eoObjects = _Bill.fetchBills(editingContext, qualifier, null);
    Bill eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Bill that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bill fetchRequiredBill(EOEditingContext editingContext, String keyName, Object value) {
    return _Bill.fetchRequiredBill(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Bill fetchRequiredBill(EOEditingContext editingContext, EOQualifier qualifier) {
    Bill eoObject = _Bill.fetchBill(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Bill that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Bill localInstanceIn(EOEditingContext editingContext, Bill eo) {
    Bill localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
