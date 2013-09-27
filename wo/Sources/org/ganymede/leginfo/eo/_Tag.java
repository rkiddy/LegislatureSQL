// DO NOT EDIT.  Make changes to Tag.java instead.
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
public abstract class _Tag extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Tag";

  // Attribute Keys
  public static final ERXKey<String> SRC_ENTITY = new ERXKey<String>("srcEntity");
  public static final ERXKey<Integer> SRC_PK = new ERXKey<Integer>("srcPk");
  public static final ERXKey<String> TAG = new ERXKey<String>("tag");
  // Relationship Keys

  // Attributes
  public static final String SRC_ENTITY_KEY = SRC_ENTITY.key();
  public static final String SRC_PK_KEY = SRC_PK.key();
  public static final String TAG_KEY = TAG.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Tag.class);

  public Tag localInstanceIn(EOEditingContext editingContext) {
    Tag localInstance = (Tag)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String srcEntity() {
    return (String) storedValueForKey(_Tag.SRC_ENTITY_KEY);
  }

  public void setSrcEntity(String value) {
    if (_Tag.LOG.isDebugEnabled()) {
        _Tag.LOG.debug( "updating srcEntity from " + srcEntity() + " to " + value);
    }
    takeStoredValueForKey(value, _Tag.SRC_ENTITY_KEY);
  }

  public Integer srcPk() {
    return (Integer) storedValueForKey(_Tag.SRC_PK_KEY);
  }

  public void setSrcPk(Integer value) {
    if (_Tag.LOG.isDebugEnabled()) {
        _Tag.LOG.debug( "updating srcPk from " + srcPk() + " to " + value);
    }
    takeStoredValueForKey(value, _Tag.SRC_PK_KEY);
  }

  public String tag() {
    return (String) storedValueForKey(_Tag.TAG_KEY);
  }

  public void setTag(String value) {
    if (_Tag.LOG.isDebugEnabled()) {
        _Tag.LOG.debug( "updating tag from " + tag() + " to " + value);
    }
    takeStoredValueForKey(value, _Tag.TAG_KEY);
  }


  public static Tag createTag(EOEditingContext editingContext, String srcEntity
, Integer srcPk
, String tag
) {
    Tag eo = (Tag) EOUtilities.createAndInsertInstance(editingContext, _Tag.ENTITY_NAME);
        eo.setSrcEntity(srcEntity);
        eo.setSrcPk(srcPk);
        eo.setTag(tag);
    return eo;
  }

  public static ERXFetchSpecification<Tag> fetchSpec() {
    return new ERXFetchSpecification<Tag>(_Tag.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Tag> fetchAllTags(EOEditingContext editingContext) {
    return _Tag.fetchAllTags(editingContext, null);
  }

  public static NSArray<Tag> fetchAllTags(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Tag.fetchTags(editingContext, null, sortOrderings);
  }

  public static NSArray<Tag> fetchTags(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Tag> fetchSpec = new ERXFetchSpecification<Tag>(_Tag.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Tag> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Tag fetchTag(EOEditingContext editingContext, String keyName, Object value) {
    return _Tag.fetchTag(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Tag fetchTag(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Tag> eoObjects = _Tag.fetchTags(editingContext, qualifier, null);
    Tag eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Tag that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Tag fetchRequiredTag(EOEditingContext editingContext, String keyName, Object value) {
    return _Tag.fetchRequiredTag(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Tag fetchRequiredTag(EOEditingContext editingContext, EOQualifier qualifier) {
    Tag eoObject = _Tag.fetchTag(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Tag that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Tag localInstanceIn(EOEditingContext editingContext, Tag eo) {
    Tag localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
