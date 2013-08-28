// DO NOT EDIT.  Make changes to Person.java instead.
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
public abstract class _Person extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Person";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> WP_URL = new ERXKey<String>("wpUrl");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.Author> AUTHORS = new ERXKey<org.ganymede.leginfo.eo.Author>("authors");
  public static final ERXKey<org.ganymede.leginfo.eo.PersonContactGroup> CONTACT_GROUPS = new ERXKey<org.ganymede.leginfo.eo.PersonContactGroup>("contactGroups");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String WP_URL_KEY = WP_URL.key();
  // Relationships
  public static final String AUTHORS_KEY = AUTHORS.key();
  public static final String CONTACT_GROUPS_KEY = CONTACT_GROUPS.key();

  private static Logger LOG = Logger.getLogger(_Person.class);

  public Person localInstanceIn(EOEditingContext editingContext) {
    Person localInstance = (Person)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Person.NAME_KEY);
  }

  public void setName(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Person.NAME_KEY);
  }

  public String wpUrl() {
    return (String) storedValueForKey(_Person.WP_URL_KEY);
  }

  public void setWpUrl(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating wpUrl from " + wpUrl() + " to " + value);
    }
    takeStoredValueForKey(value, _Person.WP_URL_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.Author> authors() {
    return (NSArray<org.ganymede.leginfo.eo.Author>)storedValueForKey(_Person.AUTHORS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.Author> authors(EOQualifier qualifier) {
    return authors(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.Author> authors(EOQualifier qualifier, boolean fetch) {
    return authors(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.Author> authors(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.Author> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.Author.PERSON_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.Author.fetchAuthors(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = authors();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Author>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Author>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToAuthors(org.ganymede.leginfo.eo.Author object) {
    includeObjectIntoPropertyWithKey(object, _Person.AUTHORS_KEY);
  }

  public void removeFromAuthors(org.ganymede.leginfo.eo.Author object) {
    excludeObjectFromPropertyWithKey(object, _Person.AUTHORS_KEY);
  }

  public void addToAuthorsRelationship(org.ganymede.leginfo.eo.Author object) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("adding " + object + " to authors relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAuthors(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Person.AUTHORS_KEY);
    }
  }

  public void removeFromAuthorsRelationship(org.ganymede.leginfo.eo.Author object) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("removing " + object + " from authors relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAuthors(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Person.AUTHORS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.Author createAuthorsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.Author.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Person.AUTHORS_KEY);
    return (org.ganymede.leginfo.eo.Author) eo;
  }

  public void deleteAuthorsRelationship(org.ganymede.leginfo.eo.Author object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Person.AUTHORS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAuthorsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.Author> objects = authors().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAuthorsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContactGroup> contactGroups() {
    return (NSArray<org.ganymede.leginfo.eo.PersonContactGroup>)storedValueForKey(_Person.CONTACT_GROUPS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContactGroup> contactGroups(EOQualifier qualifier) {
    return contactGroups(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContactGroup> contactGroups(EOQualifier qualifier, boolean fetch) {
    return contactGroups(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.PersonContactGroup> contactGroups(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.PersonContactGroup> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.PersonContactGroup.PERSON_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.PersonContactGroup.fetchPersonContactGroups(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = contactGroups();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.PersonContactGroup>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.PersonContactGroup>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToContactGroups(org.ganymede.leginfo.eo.PersonContactGroup object) {
    includeObjectIntoPropertyWithKey(object, _Person.CONTACT_GROUPS_KEY);
  }

  public void removeFromContactGroups(org.ganymede.leginfo.eo.PersonContactGroup object) {
    excludeObjectFromPropertyWithKey(object, _Person.CONTACT_GROUPS_KEY);
  }

  public void addToContactGroupsRelationship(org.ganymede.leginfo.eo.PersonContactGroup object) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("adding " + object + " to contactGroups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToContactGroups(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Person.CONTACT_GROUPS_KEY);
    }
  }

  public void removeFromContactGroupsRelationship(org.ganymede.leginfo.eo.PersonContactGroup object) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("removing " + object + " from contactGroups relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromContactGroups(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Person.CONTACT_GROUPS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.PersonContactGroup createContactGroupsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.PersonContactGroup.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Person.CONTACT_GROUPS_KEY);
    return (org.ganymede.leginfo.eo.PersonContactGroup) eo;
  }

  public void deleteContactGroupsRelationship(org.ganymede.leginfo.eo.PersonContactGroup object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Person.CONTACT_GROUPS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllContactGroupsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.PersonContactGroup> objects = contactGroups().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteContactGroupsRelationship(objects.nextElement());
    }
  }


  public static Person createPerson(EOEditingContext editingContext, String name
, String wpUrl
) {
    Person eo = (Person) EOUtilities.createAndInsertInstance(editingContext, _Person.ENTITY_NAME);    
		eo.setName(name);
		eo.setWpUrl(wpUrl);
    return eo;
  }

  public static ERXFetchSpecification<Person> fetchSpec() {
    return new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext) {
    return _Person.fetchAllPersons(editingContext, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Person.fetchPersons(editingContext, null, sortOrderings);
  }

  public static NSArray<Person> fetchPersons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Person> fetchSpec = new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Person> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Person fetchPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Person> eoObjects = _Person.fetchPersons(editingContext, qualifier, null);
    Person eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchRequiredPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    Person eoObject = _Person.fetchPerson(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person localInstanceIn(EOEditingContext editingContext, Person eo) {
    Person localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
