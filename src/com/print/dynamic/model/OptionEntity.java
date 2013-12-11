package com.print.dynamic.model;

import com.print.dynamic.component.ViewException;
import com.print.dynamic.core.ViewPage;
import com.print.dynamic.parse.ParseView;

public class OptionEntity {
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue(ViewPage viewPage) throws ViewException {
		if (ParseView.isComponentTarget(this.value)) {
			return (String) viewPage.getRegexValue(this.value);
		}
		
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
