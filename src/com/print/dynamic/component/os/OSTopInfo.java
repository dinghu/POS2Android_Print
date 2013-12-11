package com.print.dynamic.component.os;

import com.print.activity.view.TopInfoView;
import com.print.dynamic.component.Component;
import com.print.dynamic.component.ViewException;
import com.print.dynamic.core.ViewPage;

public class OSTopInfo extends StructComponent {
	
	public OSTopInfo(ViewPage viewPage) {
		super(viewPage);
	}

	@Override
	public TopInfoView toOSComponent() throws ViewException {
		TopInfoView topInfo = new TopInfoView(this.getContext());
		topInfo.setTag(this.getId());
		return topInfo;
	}

	@Override
	protected Component construction(ViewPage viewPage) {
		return new OSTopInfo(viewPage);
	}
}
