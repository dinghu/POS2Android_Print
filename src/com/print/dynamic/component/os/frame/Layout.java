package com.print.dynamic.component.os.frame;

import java.util.Vector;

import android.view.View;

import com.print.dynamic.component.Component;
import com.print.dynamic.component.ViewException;
import com.print.dynamic.core.ViewContext;
import com.print.dynamic.core.ViewPage;

public class Layout extends FrameComponent {
	public Layout(ViewPage viewPage) {
		super(viewPage);
	}
	public Layout(ViewPage viewPage, String templateId, String id) {
		super(viewPage);
		this.setTemplate(templateId);
		this.setId(id);
	}
	
	@Override
	public View toOSFrame(Vector<Component> components) throws ViewException {
		View ret = ViewContext.getInstance().layoutRewind(this.getTemplate(), components);
		return ret;
	}

	@Override
	protected Component construction(ViewPage viewPage) {
		return new Layout(viewPage);
	}

}
