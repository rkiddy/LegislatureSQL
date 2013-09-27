// DO NOT EDIT.  Make changes to Annotation.java instead.
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
public abstract class _Annotation extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Annotation";

  // Attribute Keys
  public static final ERXKey<String> NOTE = new ERXKey<String>("note");
  public static final ERXKey<String> SRC_ENTITY = new ERXKey<String>("srcEntity");
  public static final ERXKey<Integer> SRC_PK = new ERXKey<Integer>("srcPk");
  public static final ERXKey<java.util.Date> WHEN = new ERXKey<java.util.Date>("when");
  // Relationship Keys

  // Attributes
  public static final String NOTE_KEY = NOTE.key();
  public static final String SRC_ENTITY_KEY = SRC_ENTITY.key();
  public static final String SRC_PK_KEY = SRC_PK.key();
  public static final String WHEN_KEY = WHEN.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Annotation.class);

  public Annotation localInstanceIn(EOEditingContext editingContext) {
    Annotation localInstance = (Annotation)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String note() {
    return (String) storedValueForKey(_Annotation.NOTE_KEY);
  }

  public void setNote(String value) {
    if (_Annotation.LOG.isDebugEnabled()) {
        _Annotation.LOG.debug( "updating note from " + note() + " to " + value);
    }
    takeStoredValueForKey(value, _Annotation.NOTE_KEY);
  }

  public String srcEntity() {
    return (String) storedValueForKey(_Annotation.SRC_ENTITY_KEY);
  }

  public void setSrcEntity(String value) {
    if (_Annotation.LOG.isDebugEnabled()) {
        _Annotation.LOG.debug( "updating srcEntity from " + srcEntity() + " to " + value);
    }
    takeStoredValueForKey(value, _Annotation.SRC_ENTITY_KEY);
  }

  public Integer srcPk() {
    return (Integer) storedValueForKey(_Annotation.SRC_PK_KEY);
  }

  public void setSrcPk(Integer value) {
    if (_Annotation.LOG.isDebugEnabled()) {
        _Annotation.LOG.debug( "updating srcPk from " + srcPk() + " to " + value);
    }
    takeStoredValueForKey(value, _Annotation.SRC_PK_KEY);
  }

  public java.util.Date when() {
    return (java.util.Date) storedValueForKey(_Annotation.WHEN_KEY);
  }

  public void setWhen(java.util.Date value) {
    if (_Annotation.LOG.isDebugEnabled()) {
        _Annotation.LOG.debug( "updating when from " + when() + " to " + value);
    }
    takeStoredValueForKey(value, _Annotation.WHEN_KEY);
  }


  public static Annotation createAnnotation(EOEditingContext editingContext, String note
, String srcEntity
, Integer srcPk
, java.util.Date when
) {
    Annotation eo = (Annotation) EOUtilities.createAndInsertInstance(editingContext, _Annotation.ENTITY_NAME);
        eo.setNote(note);
        eo.setSrcEntity(srcEntity);
        eo.setSrcPk(srcPk);
        eo.setWhen(when);
    return eo;
  }

  public static ERXFetchSpecification<Annotation> fetchSpec() {
    return new ERXFetchSpecification<Annotation>(_Annotation.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Annotation> fetchAllAnnotations(EOEditingContext editingContext) {
    return _Annotation.fetchAllAnnotations(editingContext, null);
  }

  public static NSArray<Annotation> fetchAllAnnotations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Annotation.fetchAnnotations(editingContext, null, sortOrderings);
  }

  public static NSArray<Annotation> fetchAnnotations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Annotation> fetchSpec = new ERXFetchSpecification<Annotation>(_Annotation.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Annotation> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Annotation fetchAnnotation(EOEditingContext editingContext, String keyName, Object value) {
    return _Annotation.fetchAnnotation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Annotation fetchAnnotation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Annotation> eoObjects = _Annotation.fetchAnnotations(editingContext, qualifier, null);
    Annotation eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Annotation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Annotation fetchRequiredAnnotation(EOEditingContext editingContext, String keyName, Object value) {
    return _Annotation.fetchRequiredAnnotation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Annotation fetchRequiredAnnotation(EOEditingContext editingContext, EOQualifier qualifier) {
    Annotation eoObject = _Annotation.fetchAnnotation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Annotation that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Annotation localInstanceIn(EOEditingContext editingContext, Annotation eo) {
    Annotation localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
