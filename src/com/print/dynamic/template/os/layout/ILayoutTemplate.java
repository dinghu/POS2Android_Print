package com.print.dynamic.template.os.layout;

import java.util.Vector;

import com.print.dynamic.component.Component;
import com.print.dynamic.component.ViewException;

import android.view.View;

public interface ILayoutTemplate {
	
	public View rewind(Vector<Component> components) throws ViewException;

}
