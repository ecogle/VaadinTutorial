package com.eco.gdit.udemy.vaadin.Tutorial2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.annotation.WebServlet;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.Grid.SelectionMode;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HorizontalLayout horizontalLayout = new HorizontalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	
        @SuppressWarnings("unused")
		Layouts layouts = new Layouts();
        @SuppressWarnings("unused")
		DataBinding dataBinding = new DataBinding();
        @SuppressWarnings("unused")
		Validators validators = new Validators();
        @SuppressWarnings("unused")
		Navigation navigation = new Navigation();
        @SuppressWarnings("unused")
		JSCoding jsCoding = new JSCoding();
        
        //layouts.myVerticalLayout(this);        
        //layouts.myHorizontalLayout(this);
        //layouts.myAbsoluteLayout(this);        
        //layouts.myFormLayout(this);
        //layouts.myGridLayout(this);
        //layouts.myPanel(this);
        
        //dataBinding.myDataBinding(this);
        
        //validators.myValidator(this);
        
        //navigation.myNavigation(this);
        
        //myGrid();
        
        //myGridBinding();
        
        //myGridSelectionsSS();
        
        //jsCoding.execute(this);
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
    
    @SuppressWarnings("unused")
	private void myButtons(){
    	//BUTTONS    	
    	
    	
    	Button button = new Button("Press Me");
    	button.addClickListener(e->{
    		//horizontalLayout.addComponent(new Label("Save button clicked..."));
    		Notification.show("Button has been clicked");
    	});
    	horizontalLayout.addComponent(button);
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
    private void myCheckBoxes(){
    	//CHECKBOXES
    	
    	CheckBox checkBox = new CheckBox("Has degree?");
    	horizontalLayout.addComponent(checkBox);
    	checkBox.addValueChangeListener(e->{
    		System.out.println(checkBox.getValue());
    	});
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myOptionGroupSS(){
    	//OPTIONGROUP - SINGLE SELECT
    	
    	OptionGroup optionGroup = new OptionGroup("Universities");    	
    	Label label = new Label("");
    	
    	Student s1 = new Student("Joe", 22);
    	Student s2 = new Student("Emily", 32);
    	optionGroup.addItems(s1,s2);
    	horizontalLayout.addComponent(optionGroup);
    	horizontalLayout.addComponent(label);
    	optionGroup.addValueChangeListener(event ->{
    		Student student = (Student)event.getProperty().getValue();
    		label.setValue(student.getName());
    	});
    	    	
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myOptionGroupMS(){
    	//OPTIONGROUP - MULTISELECT
    	
    	OptionGroup optionGroup = new OptionGroup("Universities");
    	Label label = new Label("");
    	List<Student> students = new ArrayList<>();
    	students.add(new Student("Bill", 65));
    	students.add(new Student("Tammy", 61));
    	students.add(new Student("Clayton", 42));
    	students.add(new Student("Tommy", 23));
    	optionGroup.addItems(students);
    	optionGroup.setMultiSelect(true);
    	
    	optionGroup.addValueChangeListener(e ->{
    		
    		@SuppressWarnings("unchecked")
			Set<Student> myStudents = (Set<Student>) e.getProperty().getValue();
    		
    		String sBuilder = new String();
    		for(Student s : myStudents){
    			sBuilder += s.getName() + " ";
    			
    		}
    		label.setValue(sBuilder.toString());
    		
    	});
    	
    	horizontalLayout.addComponent(optionGroup);
    	horizontalLayout.addComponent(label);
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myComboBox(){
    	//ComboBox
    	
    	ComboBox cBox = new ComboBox("Names");
    	
    	cBox.addValueChangeListener(event -> {
    		cBox.setWidth(event.getProperty().getValue().toString().length()*15 + "");
    	});
    	cBox.setWidth("300px");
    	cBox.setFilteringMode(FilteringMode.CONTAINS);
    	cBox.addItem("Adam Smith");
    	cBox.addItem("Albert Camus");
    	cBox.addItem("John Stamos");
    	cBox.addItem("Bill Rush");
    	cBox.addItem("Bruce Cunningham");
    	cBox.addItem("Carl Litzgow");
    	
    	
    	horizontalLayout.addComponent(cBox);
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myGrid(){
		// GRID
    	
    	
    	Grid grid = new Grid();
    	
    	grid.addColumn("Name",String.class);
    	grid.addColumn("Age", Integer.class);
    	
    	grid.addRow("Joe Smith",22);
    	grid.addRow("Adam Lopez",32);
    	grid.addRow("Uncle Bill", 43);
    	
    	grid.setHeightMode(HeightMode.ROW);
    	grid.setHeightByRows(3);
    	
    	horizontalLayout.addComponent(grid);
    	
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myGridBinding(){
    	Grid grid; 
    	List<Student> myStudents = new ArrayList<>();
    	
    	myStudents.add(new Student("Chad", 54));
    	myStudents.add(new Student("Bill", 43));
    	myStudents.add(new Student("Bob", 31));
    	myStudents.add(new Student("Sherry", 35));
    	
    	BeanItemContainer<Student> container = new BeanItemContainer<>(Student.class,myStudents);
    	grid = new Grid(container);
    	
    	grid.setColumnOrder("name","age");
    	grid.setHeightMode(HeightMode.ROW);
    	grid.setHeightByRows(container.size());
    	
    	horizontalLayout.addComponent(grid);
    	this.setContent(horizontalLayout);
    }
    
    @SuppressWarnings("unused")
	private void myGridSelectionsSS(){
    	//Single Selection
    	Grid grid; 
    	List<Student> myStudents = new ArrayList<>();
    	
    	myStudents.add(new Student("Chad", 54));
    	myStudents.add(new Student("Bill", 43));
    	myStudents.add(new Student("Bob", 31));
    	myStudents.add(new Student("Sherry", 35));
    	
    	//BIND students to grid using a BeanItemContainer
    	BeanItemContainer<Student> container = new BeanItemContainer<Student>(Student.class,myStudents);
    	
    	//instantiate the grid with the container
    	grid = new Grid(container);
    	
    	Button button = new Button("Remove",e->{
    		Grid.SingleSelectionModel selectionModel = (Grid.SingleSelectionModel) grid.getSelectionModel();
    		Student selectedStudent = (Student)selectionModel.getSelectedRow(); 
    		grid.getContainerDataSource().removeItem(selectedStudent);
    		grid.getSelectionModel().reset();
    		grid.setHeightByRows(container.size());
    	});
    	
    	grid.setSelectionMode(SelectionMode.SINGLE); // Single Selection model
    	grid.setColumnOrder("name","age"); //sets order of the columns
    	grid.setHeightMode(HeightMode.ROW);
    	grid.setHeightByRows(container.size());
    	
    	horizontalLayout.addComponent(grid);
    	horizontalLayout.addComponent(button);
    	
    	this.setContent(horizontalLayout);    	    	
    }
    
    @SuppressWarnings("unused")
	private void myGridSelectionsMS(){
    	//Multiple Selection
    	Grid grid; 
    	List<Student> myStudents = new ArrayList<>();
    	
    	myStudents.add(new Student("Chad", 54));
    	myStudents.add(new Student("Bill", 43));
    	myStudents.add(new Student("Bob", 31));
    	myStudents.add(new Student("Sherry", 35));
    	
    	//BIND students to grid using a BeanItemContainer
    	BeanItemContainer<Student> container = new BeanItemContainer<>(Student.class,myStudents);
    	
    	//instantiate the grid with the container
    	grid = new Grid(container);
    	
    	Button button = new Button("Remove",e->{
    		Grid.MultiSelectionModel selectionModel = (Grid.MultiSelectionModel) grid.getSelectionModel();
    		
    		selectionModel.getSelectedRows().stream().forEach(o->{
    			grid.getContainerDataSource().removeItem(o);
    		});
    		
    		grid.getSelectionModel().reset();
    		grid.setHeightByRows(container.size());
    	});
    	
    	grid.setSelectionMode(SelectionMode.MULTI); // Single Selection model
    	grid.setColumnOrder("name","age"); //sets order of the columns
    	grid.setHeightMode(HeightMode.ROW);
    	grid.setHeightByRows(container.size());
    	
    	horizontalLayout.addComponent(grid);
    	horizontalLayout.addComponent(button);
    	
    	this.setContent(horizontalLayout);    	    	
    }
    
    @SuppressWarnings("unused")
	private void myTree() {
    	Tree menu = new Tree();
    	Label label = new Label("");
    	
    	menu.addItem("Hungary");
    		menu.addItem("Budapest");
    		menu.setChildrenAllowed("Budapest", false);
    		menu.setParent("Budapest","Hungary");
    		
    	menu.addItem("Germany");
    		menu.addItem("Berlin");
    			menu.setParent("Berlin","Germany");
    			menu.setChildrenAllowed("Berlin", false);
    		menu.addItem("Frankfurt");
    			menu.setParent("Frankfurt","Germany");
    			menu.setChildrenAllowed("Frankfurt", false);
    		menu.addItem("Kuln");
    			menu.setParent("Kuln","Germany");
    			menu.setChildrenAllowed("Kuln", false);
    		
		menu.expandItem("Hungary");
		menu.expandItem("Germany");
		
		menu.addValueChangeListener(e->{
			label.setValue(e.getProperty().getValue().toString());
		});
    	
    	horizontalLayout.addComponent(menu);
    	horizontalLayout.addComponent(label);
    	this.setContent(horizontalLayout);
		
	}
    
    @SuppressWarnings("unused")
	private void myTabSheet(){
    	horizontalLayout.setWidth("100%");
    	TabSheet tabSheet = new TabSheet();
    	
    	tabSheet.setWidth("75%");
    	
    	HorizontalLayout tabLayout = new HorizontalLayout();
    	
    	tabLayout.addComponent(new Label("This is just the layout"));
    	
    	HorizontalLayout tabLayout2 = new HorizontalLayout();
    	tabLayout2.addComponent(new Label("This is just the layout too"));
    	
    	tabSheet.addTab(tabLayout,"Tab 1");
    	tabSheet.addTab(tabLayout2,"Tab 2");
    	horizontalLayout.addComponent(tabSheet);
    	horizontalLayout.setComponentAlignment(tabSheet, Alignment.TOP_CENTER);
    	this.setContent(horizontalLayout);    	
    }
}
