package com.print.dynamic.template.os.view;

import java.util.List;
import java.util.Vector;

import com.print.dynamic.component.Component;
import com.print.dynamic.component.ViewException;
import com.print.dynamic.model.ViewGroupBean;

import android.content.Context;
import android.view.View;

public interface IViewGroupTemplate {
	
	public View rewind(List<ViewGroupBean> components) throws ViewException;

}
