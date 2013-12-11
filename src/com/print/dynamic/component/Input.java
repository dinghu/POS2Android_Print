package com.print.dynamic.component;

import com.print.dynamic.component.os.StructComponent;
import com.print.dynamic.core.ViewPage;

public abstract class Input extends StructComponent {
	
	public Input(ViewPage viewPage) {
		super(viewPage);
	}
	
	// 加载用户输入
	public abstract void loadInputValue();
	
	// 验证输入的合法性
	public abstract boolean validator();

}
