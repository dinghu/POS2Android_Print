package com.print.dynamic.component;

import com.print.dynamic.core.ViewPage;

public class Hidden extends Component {
	public Hidden(ViewPage viewPage) {
		this.viewPage = viewPage;
	}

	@Override
	protected Component construction(ViewPage viewPage) {
		return new Hidden(viewPage);
	}
}
