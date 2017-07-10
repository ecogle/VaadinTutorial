package com.eco.gdit.udemy.vaadin.Tutorial2;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class DataBinding {
	
	private TextField name;
	private TextField age;
	
	public void myDataBinding(UI ui){
		
		VerticalLayout root = new VerticalLayout();
		Person person = new Person();
		root.setMargin(true);
		
		root.setHeight("100%");
		
		BeanFieldGroup<Person> fieldGroup = new BeanFieldGroup<>(Person.class);
		
		name = new TextField("Name");
		age = new TextField("Age");
		
		fieldGroup.bind(name, "name");
		fieldGroup.bind(age, "age");
		fieldGroup.setItemDataSource(person);
		
		Button button = new Button("Save");
		button.addClickListener(t->{
			try {
				fieldGroup.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println(person);
		});
		
		root.addComponents(name,age,button);
		
		ui.setContent(root);
	}

}
