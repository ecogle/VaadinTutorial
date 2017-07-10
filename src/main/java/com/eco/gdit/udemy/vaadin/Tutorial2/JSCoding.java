package com.eco.gdit.udemy.vaadin.Tutorial2;

import com.vaadin.server.Page;
import com.vaadin.ui.UI;

public class JSCoding {
	
	public void execute(UI ui){
		
		Page.getCurrent().getJavaScript().execute("alert('Hello There')");
		
	}

}
