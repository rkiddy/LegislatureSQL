package org.ganymede.leginfo.eo;

import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXGenericRecord;

public class GEO extends ERXGenericRecord {

	public Integer pk() { return Integer.valueOf(this.primaryKey()); }

    public NSArray<String> tags() {
    	NSArray<Tag> tags = Tag.fetchTags(this.editingContext(), Tag.SRC_ENTITY.is(this.entityName()).and(Tag.SRC_PK.is(this.pk())), Tag.TAG.ascs());
    	return (tags != null && tags.size() > 0) ? (NSArray<String>)tags.valueForKey(Tag.TAG_KEY) : null;
    }

    public NSArray<String> annotations() {
    	NSArray<Annotation> notes = Annotation.fetchAnnotations(this.editingContext(), Annotation.SRC_ENTITY.is(this.entityName()).and(Annotation.SRC_PK.is(this.pk())), null);
    	return (notes != null && notes.size() > 0) ? (NSArray<String>)notes.valueForKey(Annotation.NOTE_KEY) : null;
    }
}
