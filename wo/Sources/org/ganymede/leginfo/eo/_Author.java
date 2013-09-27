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
  public static final ERXKey<Integer> DISTRICT = new ERXKey<Integer>("district");
  public static final ERXKey<String> END = new ERXKey<String>("end");
  public static final ERXKey<String> HOUSE = new ERXKey<String>("house");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> START = new ERXKey<String>("start");
  // Relationship Keys
  public static final ERXKey<org.ganymede.leginfo.eo.BillAuthoring> AUTHORINGS = new ERXKey<org.ganymede.leginfo.eo.BillAuthoring>("authorings");
  public static final ERXKey<org.ganymede.leginfo.eo.Person> PERSON = new ERXKey<org.ganymede.leginfo.eo.Person>("person");

  // Attributes
  public static final String DISTRICT_KEY = DISTRICT.key();
  public static final String END_KEY = END.key();
  public static final String HOUSE_KEY = HOUSE.key();
  public static final String NAME_KEY = NAME.key();
  public static final String START_KEY = START.key();
  // Relationships
  public static final String AUTHORINGS_KEY = AUTHORINGS.key();
  public static final String PERSON_KEY = PERSON.key();

  private static Logger LOG = Logger.getLogger(_Author.class);

  public Author localInstanceIn(EOEditingContext editingContext) {
    Author localInstance = (Author)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer district() {
    return (Integer) storedValueForKey(_Author.DISTRICT_KEY);
  }

  public void setDistrict(Integer value) {
    if (_Author.LOG.isDebugEnabled()) {
    	_Author.LOG.debug( "updating district from " + district() + " to " + value);
    }
    takeStoredValueForKey(value, _Author.DISTRICT_KEY);
  }

  public String end() {
    return (String) storedValueForKey(_Author.END_KEY);
  }

  public void setEnd(String value) {
    if (_Author.LOG.isDebugEnabled()) {
    	_Author.LOG.debug( "updating end from " + end() + " to " + value);
    }
    takeStoredValueForKey(value, _Author.END_KEY);
  }

  public String house() {
    return (String) storedValueForKey(_Author.HOUSE_KEY);
  }

  public void setHouse(String value) {
    if (_Author.LOG.isDebugEnabled()) {
    	_Author.LOG.debug( "updating house from " + house() + " to " + value);
    }
    takeStoredValueForKey(value, _Author.HOUSE_KEY);
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

  public String start() {
    return (String) storedValueForKey(_Author.START_KEY);
  }

  public void setStart(String value) {
    if (_Author.LOG.isDebugEnabled()) {
    	_Author.LOG.debug( "updating start from " + start() + " to " + value);
    }
    takeStoredValueForKey(value, _Author.START_KEY);
  }

  public org.ganymede.leginfo.eo.Person person() {
    return (org.ganymede.leginfo.eo.Person)storedValueForKey(_Author.PERSON_KEY);
  }
  
  public void setPerson(org.ganymede.leginfo.eo.Person value) {
    takeStoredValueForKey(value, _Author.PERSON_KEY);
  }

  public void setPersonRelationship(org.ganymede.leginfo.eo.Person value) {
    if (_Author.LOG.isDebugEnabled()) {
      _Author.LOG.debug("updating person from " + person() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPerson(value);
    }
    else if (value == null) {
    	org.ganymede.leginfo.eo.Person oldValue = person();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Author.PERSON_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _Author.PERSON_KEY);
    }
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
