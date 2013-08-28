// DO NOT EDIT.  Make changes to PersonContactGroup.java instead.
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
public abstract class _PersonContactGroup extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "PersonContactGroup";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.PersonContact> CONTACTS = new ERXKey<org.ganymede.leginfo.eo.PersonContact>("contacts");
  public static final ERXKey<org.ganymede.leginfo.eo.Person> PERSON = new ERXKey<org.ganymede.leginfo.eo.Person>("person");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String CONTACTS_KEY = CONTACTS.key();
  public static final String PERSON_KEY = PERSON.key();

  private static Logger LOG = Logger.getLogger(_PersonContactGroup.class);

  public PersonContactGroup localInstanceIn(EOEditingContext editingContext) {
    PersonContactGroup localInstance = (PersonContactGroup)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_PersonContactGroup.NAME_KEY);
  }

  public void setName(String value) {
    if (_PersonContactGroup.LOG.isDebugEnabled()) {
    	_PersonContactGroup.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _PersonContactGroup.NAME_KEY);
  }

  public org.ganymede.leginfo.eo.Person person() {
    return (org.ganymede.leginfo.eo.Person)storedValueForKey(_PersonContactGroup.PERSON_KEY);
  }
  
  public void setPerson(org.ganymede.leginfo.eo.Person value) {
    takeStoredValueForKey(value, _PersonContactGroup.PERSON_KEY);
  }

  public void setPersonRelationship(org.ganymede.leginfo.eo.Person value) {
    if (_PersonContactGroup.LOG.isDebugEnabled()) {
      _PersonContactGroup.LOG.debug("updating person from " + person() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPerson(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.Person oldValue = person();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _PersonContactGroup.PERSON_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _PersonContactGroup.PERSON_KEY);
    }
  }
  
  public NSArray<org.ganymede.leginfo.eo.PersonContact> contacts() {
    return (NSArray<org.ganymede.leginfo.eo.PersonContact>)storedValueForKey(_PersonContactGroup.CONTACTS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContact> contacts(EOQualifier qualifier) {
    return contacts(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContact> contacts(EOQualifier qualifier, boolean fetch) {
    return contacts(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContact> contacts(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.PersonContact> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.PersonContact.CONTACT_GROUP_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.PersonContact.fetchPersonContacts(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = contacts();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.PersonContact>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.PersonContact>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToContacts(org.ganymede.leginfo.eo.PersonContact object) {
    includeObjectIntoPropertyWithKey(object, _PersonContactGroup.CONTACTS_KEY);
  }

  public void removeFromContacts(org.ganymede.leginfo.eo.PersonContact object) {
    excludeObjectFromPropertyWithKey(object, _PersonContactGroup.CONTACTS_KEY);
  }

  public void addToContactsRelationship(org.ganymede.leginfo.eo.PersonContact object) {
    if (_PersonContactGroup.LOG.isDebugEnabled()) {
      _PersonContactGroup.LOG.debug("adding " + object + " to contacts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToContacts(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _PersonContactGroup.CONTACTS_KEY);
    }
  }

  public void removeFromContactsRelationship(org.ganymede.leginfo.eo.PersonContact object) {
    if (_PersonContactGroup.LOG.isDebugEnabled()) {
      _PersonContactGroup.LOG.debug("removing " + object + " from contacts relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromContacts(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _PersonContactGroup.CONTACTS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.PersonContact createContactsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.PersonContact.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _PersonContactGroup.CONTACTS_KEY);
    return (org.ganymede.leginfo.eo.PersonContact) eo;
  }

  public void deleteContactsRelationship(org.ganymede.leginfo.eo.PersonContact object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _PersonContactGroup.CONTACTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllContactsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.PersonContact> objects = contacts().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteContactsRelationship(objects.nextElement());
    }
  }


  public static PersonContactGroup createPersonContactGroup(EOEditingContext editingContext, String name
, org.ganymede.leginfo.eo.Person person) {
    PersonContactGroup eo = (PersonContactGroup) EOUtilities.createAndInsertInstance(editingContext, _PersonContactGroup.ENTITY_NAME);    
		eo.setName(name);
    eo.setPersonRelationship(person);
    return eo;
  }

  public static ERXFetchSpecification<PersonContactGroup> fetchSpec() {
    return new ERXFetchSpecification<PersonContactGroup>(_PersonContactGroup.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<PersonContactGroup> fetchAllPersonContactGroups(EOEditingContext editingContext) {
    return _PersonContactGroup.fetchAllPersonContactGroups(editingContext, null);
  }

  public static NSArray<PersonContactGroup> fetchAllPersonContactGroups(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _PersonContactGroup.fetchPersonContactGroups(editingContext, null, sortOrderings);
  }

  public static NSArray<PersonContactGroup> fetchPersonContactGroups(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<PersonContactGroup> fetchSpec = new ERXFetchSpecification<PersonContactGroup>(_PersonContactGroup.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<PersonContactGroup> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static PersonContactGroup fetchPersonContactGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonContactGroup.fetchPersonContactGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonContactGroup fetchPersonContactGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<PersonContactGroup> eoObjects = _PersonContactGroup.fetchPersonContactGroups(editingContext, qualifier, null);
    PersonContactGroup eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one PersonContactGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonContactGroup fetchRequiredPersonContactGroup(EOEditingContext editingContext, String keyName, Object value) {
    return _PersonContactGroup.fetchRequiredPersonContactGroup(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static PersonContactGroup fetchRequiredPersonContactGroup(EOEditingContext editingContext, EOQualifier qualifier) {
    PersonContactGroup eoObject = _PersonContactGroup.fetchPersonContactGroup(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no PersonContactGroup that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static PersonContactGroup localInstanceIn(EOEditingContext editingContext, PersonContactGroup eo) {
    PersonContactGroup localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
