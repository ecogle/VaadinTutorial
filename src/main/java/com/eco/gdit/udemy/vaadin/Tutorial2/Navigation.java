package com.eco.gdit.udemy.vaadin.Tutorial2;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Navigation {
	
	public void myNavigation(UI ui){
		
		// Navigation: usually run on a single page
		
		VerticalLayout root = new VerticalLayout();
		Button but1 = new Button("First View");
		Button but2 = new Button("Second View");
		
		Panel viewContainer = new Panel();
		Navigator navigator = new Navigator(ui, viewContainer);
		
		navigator.addView("First", new FirstView());
		navigator.addView("Second", new SecondView());
		
		root.addComponent(new HorizontalLayout(but1,but2));		
		root.addComponent(viewContainer);
		
		navigator.navigateTo("First");
		
		but1.addClickListener(r->{
			navigator.navigateTo("First");
		});
		
		but2.addClickListener(t->{
			navigator.navigateTo("Second");
		});
		ui.setContent(root);
		
	}

}
