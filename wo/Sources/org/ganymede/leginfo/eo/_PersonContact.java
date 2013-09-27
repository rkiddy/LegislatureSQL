// DO NOT EDIT.  Make changes to PersonContact.java instead.
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
public abstract class _PersonContact extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "PersonContact";

  // Attribute Keys
  public static final ERXKey<String> CONTACT_INFO = new ERXKey<String>("contactInfo");
  public static final ERXKey<String> CONTACT_TYPE = new ERXKey<String>("contactType");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.PersonContactGroup> CONTACT_GROUP = new ERXKey<org.ganymede.leginfo.eo.PersonContactGroup>("contactGroup");
  public static final ERXKey<org.ganymede.leginfo.eo.Person> PERSON = new ERXKey<org.ganymede.leginfo.eo.Person>("person");

  // Attributes
  public static final String CONTACT_INFO_KEY = CONTACT_INFO.key();
  public static final String CONTACT_TYPE_KEY = CONTACT_TYPE.key();
  // Relationships
  public static final String CONTACT_GROUP_KEY = CONTACT_GROUP.key();
  public static final String PERSON_KEY = PERSON.key();

  private static Logger LOG = Logger.getLogger(_PersonContact.class);

  public PersonContact localInstanceIn(EOEditingContext editingContext) {
    PersonContact localInstance = (PersonContact)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String contactInfo() {
    return (String) storedValueForKey(_PersonContact.CONTACT_INFO_KEY);
  }

  public void setContactInfo(String value) {
    if (_PersonContact.LOG.isDebugEnabled()) {
        _PersonContact.LOG.debug( "updating contactInfo from " + contactInfo() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonContact.CONTACT_INFO_KEY);
  }

  public String contactType() {
    return (String) storedValueForKey(_PersonContact.CONTACT_TYPE_KEY);
  }

  public void setContactType(String value) {
    if (_PersonContact.LOG.isDebugEnabled()) {
        _PersonContact.LOG.debug( "updating contactType from " + contactType() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonContact.CONTACT_TYPE_KEY);
  }

  public org.ganymede.leginfo.eo.PersonContactGroup contactGroup() {
    return (org.ganymede.leginfo.eo.PersonContactGroup)storedValueForKey(_PersonContact.CONTACT_GROUP_KEY);
  }

  public void setContactGroup(org.ganymede.leginfo.eo.PersonContactGroup value) {
    takeStoredValueForKey(value, _PersonContact.CONTACT_GROUP_KEY);
  }

  public void setContactGroupRelationship(org.ganymede.leginfo.eo.PersonContactGroup value) {
    if (_PersonContact.LOG.isDebugEnabled()) {
      _PersonContact.LOG.debug("updating contactGroup from " + contactGroup() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        setContactGroup(value);
    }
    else if (value == null) {
        org.ganymede.leginfo.eo.PersonContactGroup oldValue = contactGroup();
        if (oldValue != null) {
            removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _PersonContact.CONTACT_GROUP_KEY);
      }
    } else {
        addObjectToBothSidesOfRelationshipWithKey(value, _PersonContact.CONTACT_GROUP_KEY);
    }
  }

  public org.ganymede.leginfo.eo.Person person() {
    return (org.ganymede.leginfo.eo.Person)storedValueForKey(_PersonContact.PERSON_KEY);
  }

  public void setPerson(org.ganymede.leginfo.eo.Person value) {
    takeStoredValueForKey(value, _PersonContact.PERSON_KEY);
  }

  public void setPersonRelationship(org.ganymede.leginfo.eo.Person value) {
    if (_PersonContact.LOG.isDebugEnabled()) {
      _PersonContact.LOG.debug("updating person from " + person() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
        setPerson(value);
    }
    else if (value == null) {
        org.ganymede.leginfo.eo.Person oldValue = person();
        if (oldValue != null) {
            removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _PersonContact.PERSON_KEY);
      }
    } else {
        addObjectToBothSidesOfRelationshipWithKey(value, _PersonContact.PERSON_KEY);
    }
  }


  public static PersonContact createPersonContact(EOEditingContext editingContext, String contactInfo
, String contactType
, org.ganymede.leginfo.eo.PersonContactGroup contactGroup) {
    PersonContact eo = (PersonContact) EOUtilities.createAndInsertInstance(editingContext, _PersonContact.ENTITY_NAME);
        eo.setContactInfo(contactInfo);
        eo.setContactType(contactType);
    eo.setContactGroupRelationship(contactGroup);
    return eo;
  }

  public static ERXFetchSpecification<PersonContact> fetchSpec() {
    return new ERXFetchSpecification<PersonContact>(_PersonContact.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<PersonContact> fetchAllPersonContacts(EOEditingContext editingContext) {
    return _PersonContact.fetchAllPersonContacts(editingContext, null);
  }

  public static NSArray<PersonContact> fetchAllPersonContacts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _PersonContact.fetchPersonContacts(editingContext, null, sortOrderings);
  }

  public static NSArray<PersonContact> fetchPersonContacts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<PersonContact> fetchSpec = new ERXFetchSpecification<PersonContact>(_PersonContact.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<PersonContact> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static PersonContact fetchPersonContact(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonContact.fetchPersonContact(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonContact fetchPersonContact(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<PersonContact> eoObjects = _PersonContact.fetchPersonContacts(editingContext, qualifier, null);
    PersonContact eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one PersonContact that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonContact fetchRequiredPersonContact(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonContact.fetchRequiredPersonContact(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonContact fetchRequiredPersonContact(EOEditingContext editingContext, EOQualifier qualifier) {
    PersonContact eoObject = _PersonContact.fetchPersonContact(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no PersonContact that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonContact localInstanceIn(EOEditingContext editingContext, PersonContact eo) {
    PersonContact localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
