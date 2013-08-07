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
  public static final ERXKey<org.ganymede.leginfo.eo.Author> AUTHOR = new ERXKey<org.ganymede.leginfo.eo.Author>("author");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  public static final String WP_URL_KEY = WP_URL.key();
  // Relationships
  public static final String AUTHOR_KEY = AUTHOR.key();

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

  public org.ganymede.leginfo.eo.Author author() {
    return (org.ganymede.leginfo.eo.Author)storedValueForKey(_Person.AUTHOR_KEY);
  }
  
  public void setAuthor(org.ganymede.leginfo.eo.Author value) {
    takeStoredValueForKey(value, _Person.AUTHOR_KEY);
  }

  public void setAuthorRelationship(org.ganymede.leginfo.eo.Author value) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("updating author from " + author() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setAuthor(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.Author oldValue = author();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Person.AUTHOR_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Person.AUTHOR_KEY);
    }
  }
  

  public static Person createPerson(EOEditingContext editingContext, String name
, String wpUrl
, org.ganymede.leginfo.eo.Author author) {
    Person eo = (Person) EOUtilities.createAndInsertInstance(editingContext, _Person.ENTITY_NAME);    
		eo.setName(name);
		eo.setWpUrl(wpUrl);
    eo.setAuthorRelationship(author);
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
