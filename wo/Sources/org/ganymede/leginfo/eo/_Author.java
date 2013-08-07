// DO NOT EDIT.  Make changes to Author.java instead.
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
public abstract class _Author extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Author";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillAuthoring> AUTHORINGS = new ERXKey<org.ganymede.leginfo.eo.BillAuthoring>("authorings");
  public static final ERXKey<org.ganymede.leginfo.eo.Person> PERSONS = new ERXKey<org.ganymede.leginfo.eo.Person>("persons");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String AUTHORINGS_KEY = AUTHORINGS.key();
  public static final String PERSONS_KEY = PERSONS.key();

  private static Logger LOG = Logger.getLogger(_Author.class);

  public Author localInstanceIn(EOEditingContext editingContext) {
    Author localInstance = (Author)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Author.NAME_KEY);
  }

  public void setName(String value) {
    if (_Author.LOG.isDebugEnabled()) {
    	_Author.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Author.NAME_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.BillAuthoring> authorings() {
    return (NSArray<org.ganymede.leginfo.eo.BillAuthoring>)storedValueForKey(_Author.AUTHORINGS_KEY);
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.BillAuthoring.AUTHOR_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    includeObjectIntoPropertyWithKey(object, _Author.AUTHORINGS_KEY);
  }

  public void removeFromAuthorings(org.ganymede.leginfo.eo.BillAuthoring object) {
    excludeObjectFromPropertyWithKey(object, _Author.AUTHORINGS_KEY);
  }

  public void addToAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    if (_Author.LOG.isDebugEnabled()) {
      _Author.LOG.debug("adding " + object + " to authorings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToAuthorings(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Author.AUTHORINGS_KEY);
    }
  }

  public void removeFromAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    if (_Author.LOG.isDebugEnabled()) {
      _Author.LOG.debug("removing " + object + " from authorings relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromAuthorings(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Author.AUTHORINGS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.BillAuthoring createAuthoringsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.BillAuthoring.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Author.AUTHORINGS_KEY);
    return (org.ganymede.leginfo.eo.BillAuthoring) eo;
  }

  public void deleteAuthoringsRelationship(org.ganymede.leginfo.eo.BillAuthoring object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Author.AUTHORINGS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllAuthoringsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.BillAuthoring> objects = authorings().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAuthoringsRelationship(objects.nextElement());
    }
  }

  public NSArray<org.ganymede.leginfo.eo.Person> persons() {
    return (NSArray<org.ganymede.leginfo.eo.Person>)storedValueForKey(_Author.PERSONS_KEY);
  }

  public NSArray<org.ganymede.leginfo.eo.Person> persons(EOQualifier qualifier) {
    return persons(qualifier, null, false);
  }

  public NSArray<org.ganymede.leginfo.eo.Person> persons(EOQualifier qualifier, boolean fetch) {
    return persons(qualifier, null, fetch);
  }

  public NSArray<org.ganymede.leginfo.eo.Person> persons(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<org.ganymede.leginfo.eo.Person> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(org.ganymede.leginfo.eo.Person.AUTHOR_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = org.ganymede.leginfo.eo.Person.fetchPersons(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = persons();
      if (qualifier != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Person>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.ganymede.leginfo.eo.Person>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToPersons(org.ganymede.leginfo.eo.Person object) {
    includeObjectIntoPropertyWithKey(object, _Author.PERSONS_KEY);
  }

  public void removeFromPersons(org.ganymede.leginfo.eo.Person object) {
    excludeObjectFromPropertyWithKey(object, _Author.PERSONS_KEY);
  }

  public void addToPersonsRelationship(org.ganymede.leginfo.eo.Person object) {
    if (_Author.LOG.isDebugEnabled()) {
      _Author.LOG.debug("adding " + object + " to persons relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToPersons(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Author.PERSONS_KEY);
    }
  }

  public void removeFromPersonsRelationship(org.ganymede.leginfo.eo.Person object) {
    if (_Author.LOG.isDebugEnabled()) {
      _Author.LOG.debug("removing " + object + " from persons relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromPersons(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Author.PERSONS_KEY);
    }
  }

  public org.ganymede.leginfo.eo.Person createPersonsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( org.ganymede.leginfo.eo.Person.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Author.PERSONS_KEY);
    return (org.ganymede.leginfo.eo.Person) eo;
  }

  public void deletePersonsRelationship(org.ganymede.leginfo.eo.Person object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Author.PERSONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllPersonsRelationships() {
    Enumeration<org.ganymede.leginfo.eo.Person> objects = persons().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePersonsRelationship(objects.nextElement());
    }
  }


  public static Author createAuthor(EOEditingContext editingContext, String name
) {
    Author eo = (Author) EOUtilities.createAndInsertInstance(editingContext, _Author.ENTITY_NAME);    
		eo.setName(name);
    return eo;
  }

  public static ERXFetchSpecification<Author> fetchSpec() {
    return new ERXFetchSpecification<Author>(_Author.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Author> fetchAllAuthors(EOEditingContext editingContext) {
    return _Author.fetchAllAuthors(editingContext, null);
  }

  public static NSArray<Author> fetchAllAuthors(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Author.fetchAuthors(editingContext, null, sortOrderings);
  }

  public static NSArray<Author> fetchAuthors(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Author> fetchSpec = new ERXFetchSpecification<Author>(_Author.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Author> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Author fetchAuthor(EOEditingContext editingContext, String keyName, Object value) {
    return _Author.fetchAuthor(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Author fetchAuthor(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Author> eoObjects = _Author.fetchAuthors(editingContext, qualifier, null);
    Author eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Author that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Author fetchRequiredAuthor(EOEditingContext editingContext, String keyName, Object value) {
    return _Author.fetchRequiredAuthor(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Author fetchRequiredAuthor(EOEditingContext editingContext, EOQualifier qualifier) {
    Author eoObject = _Author.fetchAuthor(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Author that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Author localInstanceIn(EOEditingContext editingContext, Author eo) {
    Author localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
