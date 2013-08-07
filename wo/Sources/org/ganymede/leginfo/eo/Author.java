package org.ganymede.leginfo.eo;

import org.apache.log4j.Logger;

import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class Author extends _Author {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Author.class);

	public NSArray<BillVersion> billVersionsOfType(String authoringType) {

		NSMutableArray<BillAuthoring> authorings = new NSMutableArray<BillAuthoring>(this.authorings());

		EOQualifier.filterArrayWithQualifier(authorings, BillAuthoring.AUTHOR_TYPE.is(authoringType));
		
		NSArray<BillVersion> versions = (NSArray<BillVersion>)authorings.valueForKey(BillAuthoring.BILL_VERSION_KEY);
		
		NSMutableArray<BillVersion> latestVersions = new NSMutableArray<BillVersion>();
		for (BillVersion aVersion : versions) {
			if (aVersion.isLastVersion())
				latestVersions.add(aVersion);
		}

		return latestVersions.immutableClone();
	}

	public NSArray<BillVersion> billVersionsAuthored() { return billVersionsOfType("A"); }
	public NSArray<BillVersion> billVersionsPrincipalCoauthored() { return billVersionsOfType("PC"); }
	public NSArray<BillVersion> billVersionsCoauthored() { return billVersionsOfType("C"); }
}
