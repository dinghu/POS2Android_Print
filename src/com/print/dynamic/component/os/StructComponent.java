package com.print.dynamic.component.os;

import android.content.Context;
import android.view.View;

import com.print.dynamic.component.Component;
import com.print.dynamic.component.ITransView;
import com.print.dynamic.component.ViewException;
import com.print.dynamic.core.ViewContext;
import com.print.dynamic.core.ViewPage;

public abstract class StructComponent extends Component implements ITransView {
	public StructComponent(ViewPage viewPage) {
		this.viewPage = viewPage;
	}
	public Context getContext() {
		return ViewContext.getInstance().getContext();
	}
	@Override
	protected void copyParams(Component src, Component des) {
		super.copyParams(src, des);
	}
	@Override
	public final View toComponent() throws ViewException {
		return this.initOSParams(this.toOSComponent());
	}
	
	protected abstract View toOSComponent() throws ViewException;
}
