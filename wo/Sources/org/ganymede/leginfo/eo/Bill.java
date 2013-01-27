package org.ganymede.leginfo.eo;

import org.apache.log4j.Logger;

public class Bill extends _Bill {

	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Bill.class);

	public String shortTitle() {
		String title = this.title();
		if (title.startsWith("Relating")) return title;
		int offset = title.indexOf("relating");
		if (offset < 0) return title;
		return title.substring(offset);
	}
}
