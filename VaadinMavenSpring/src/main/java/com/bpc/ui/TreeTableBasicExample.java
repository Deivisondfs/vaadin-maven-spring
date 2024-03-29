package com.bpc.ui;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/15/11
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Calendar;
import java.util.Date;

import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;

public class TreeTableBasicExample extends VerticalLayout {

    protected static final String NAME_PROPERTY = "Name";
    protected static final String HOURS_PROPERTY = "Hours done";
    protected static final String MODIFIED_PROPERTY = "Last Modified";

    protected final TreeTable treetable;


    public TreeTableBasicExample() {
        setWidth("100%");

        // Calendar
        Calendar cal = Calendar.getInstance();
        cal.set(2011, 10, 30, 14, 40, 26);

        // Create the treetable
        treetable = new TreeTable();
        treetable.setWidth("100%");

        addComponent(treetable);

        // Add Table columns
        treetable.addContainerProperty(NAME_PROPERTY, String.class, "");
        treetable.addContainerProperty(HOURS_PROPERTY, Integer.class, 0);
        treetable.addContainerProperty(MODIFIED_PROPERTY, Date.class,
                cal.getTime());

        // Populate table
        Object allProjects = treetable.addItem(new Object[] { "All Projects",
                18, cal.getTime() }, null);
        Object year2010 = treetable.addItem(
                new Object[] { "Year 2010", 18, cal.getTime() }, null);
        Object customerProject1 = treetable.addItem(new Object[] {
                "Customer Project 1", 13, cal.getTime() }, null);
        Object customerProject1Implementation = treetable.addItem(new Object[] {
                "Implementation", 5, cal.getTime() }, null);
        Object customerProject1Planning = treetable.addItem(new Object[] {
                "Planning", 2, cal.getTime() }, null);
        Object customerProject1Prototype = treetable.addItem(new Object[] {
                "Prototype", 5, cal.getTime() }, null);
        Object customerProject2 = treetable.addItem(new Object[] {
                "Customer Project 2", 5, cal.getTime() }, null);
        Object customerProject2Planning = treetable.addItem(new Object[] {
                "Planning", 5, cal.getTime() }, null);

        // Set hierarchy
        treetable.setParent(year2010, allProjects);
        treetable.setParent(customerProject1, year2010);
        treetable.setParent(customerProject1Implementation, customerProject1);
        treetable.setParent(customerProject1Planning, customerProject1);
        treetable.setParent(customerProject1Prototype, customerProject1);
        treetable.setParent(customerProject2, year2010);
        treetable.setParent(customerProject2Planning, customerProject2);

        // Disallow children from leaves
        treetable.setChildrenAllowed(customerProject1Implementation, false);
        treetable.setChildrenAllowed(customerProject1Planning, false);
        treetable.setChildrenAllowed(customerProject1Prototype, false);
        treetable.setChildrenAllowed(customerProject2Planning, false);

        // Expand all
        treetable.setCollapsed(allProjects, false);
        treetable.setCollapsed(year2010, false);
        treetable.setCollapsed(customerProject1, false);
        treetable.setCollapsed(customerProject2, false);

    }
}