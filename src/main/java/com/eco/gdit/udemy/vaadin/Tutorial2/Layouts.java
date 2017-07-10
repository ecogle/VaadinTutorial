package com.eco.gdit.udemy.vaadin.Tutorial2;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Layouts {	
	
	public void myVerticalLayout(UI ui){
		
		VerticalLayout verticalLayout = new VerticalLayout();
		
		List<Label> myLabels = new ArrayList<>();
		myLabels.add(new Label("First line"));
		myLabels.add(new Label("Second line"));
		myLabels.add(new Label("Third line"));
		
		myLabels.stream().forEach(r-> {
			verticalLayout.addComponent(r);
			r.setWidthUndefined();
		});
		
		verticalLayout.setComponentAlignment(myLabels.get(0), Alignment.MIDDLE_LEFT);
		verticalLayout.setComponentAlignment(myLabels.get(1), Alignment.MIDDLE_CENTER);
		verticalLayout.setComponentAlignment(myLabels.get(2), Alignment.MIDDLE_RIGHT);
		
		ui.setContent(verticalLayout);
	}
	
	public void myHorizontalLayout(UI ui){
		
		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setWidth("100%");
		List<Button>myButtons = new ArrayList<>();
		myButtons.add(new Button("First"));
		myButtons.add(new Button("Second"));
		myButtons.add(new Button("Third"));
		
		myButtons.stream().forEach(i->{
			i.setWidth("95%");
			hLayout.addComponent(i);
		});
		
		
		
		hLayout.setExpandRatio(myButtons.get(0),1);
		hLayout.setExpandRatio(myButtons.get(1),0.75f);
		hLayout.setExpandRatio(myButtons.get(2),1);
		
		
		ui.setContent(hLayout);
	}
	
	/**
	 * 
	 * @param ui
	 */
	public void myAbsoluteLayout(UI ui){
		
		AbsoluteLayout layout = new AbsoluteLayout();
		Button button = new Button("This is a button");
		
		layout.setWidth("500px");
		layout.setHeight("300px");
		
		layout.addComponent(button,"left:50px;top:30px");
		
		
		
		ui.setContent(layout);
	}
	
	public void myFormLayout(UI ui){
		
		FormLayout layout = new FormLayout();
		TextField name = new TextField("Name: ");
		TextField address = new TextField("Address: ");
		
		name.setIcon(FontAwesome.USER);
		address.setIcon(FontAwesome.DIGG);
		
		layout.addComponent(name);
		layout.addComponent(address);
		
		ui.setContent(layout);
		
	}
	
	public void myGridLayout(UI ui){
		
		GridLayout layout = new GridLayout(2,3);
		TextField b1 = new TextField();
		Button b2 = new Button("Two");
		Button b3 = new Button("Three");		
		
		layout.addComponent(b1,0,0,1,0);
		layout.addComponent(b2,0,1);
		layout.addComponent(b3,1,1);
		ui.setContent(layout);		
		
	}
	public void myPanel(UI ui){
		
		VerticalLayout root = new VerticalLayout();
		
		root.setMargin(true);
		root.setHeight("100%");
		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		
		root.addComponent(panel);
		root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		FormLayout loginLayout = new FormLayout();
		loginLayout.addComponent(new TextField("Username: "));
		loginLayout.addComponent(new PasswordField("Password: "));
		
		Button loginButton = new Button("Login");
		Button signUpButton = new Button("Sign up");
		
		loginButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		
		
		signUpButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		loginLayout.addComponent(new HorizontalLayout(loginButton,signUpButton));
		loginLayout.setSizeUndefined();
		loginLayout.setMargin(true);
		
		panel.setContent(loginLayout);
		
		ui.setContent(root);
		
	}
	

}
