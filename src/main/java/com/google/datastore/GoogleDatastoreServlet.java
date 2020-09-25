package com.google.datastore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.SortDirection;

@WebServlet("/employee")
public class GoogleDatastoreServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
   
    PrintWriter out = response.getWriter();
    
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
    
    Entity employee = new Entity("Employee");
    employee.setProperty("EmployeeId", 102);
    employee.setProperty("Title", "HR Manager");
	employee.setProperty("Salary", 5000);
	employee.setProperty("Designation", "SMM");
	
	datastoreService.put(employee);
	
	Entity employee1 = new Entity("Employee");
	employee1.setProperty("EmployeeId", 99);
    employee1.setProperty("Title", "Area Manager");
	employee1.setProperty("Salary", 8000);
	//employee1.setProperty("Designation", "Operator");
	
	datastoreService.put(employee1);
	
	Entity employee2 = new Entity("Employee");
	employee2.setProperty("EmployeeId", 105);
    employee2.setProperty("Title", "Sales Officier");
	employee2.setProperty("Salary", 5000);
	//employee2.setProperty("Designation", "Database Management");
	
	datastoreService.put(employee2);
	
	Entity employee3 = new Entity("Employee");
	employee3.setProperty("EmployeeId", 100);
    employee3.setProperty("Title", "Executive");
	employee3.setProperty("Salary", 3000);
	//employee2.setProperty("Designation", "Database Management");
	
	datastoreService.put(employee3);
	
	Entity employee4 = new Entity("Employee");
	employee4.setProperty("EmployeeId", 110);
    employee4.setProperty("Title", "Sales Officier");
	employee4.setProperty("Salary", 6000);
	//employee2.setProperty("Designation", "Database Management");
	
	datastoreService.put(employee4);
	
	
	Query query = new Query("Employee");
	
	Filter propertyFilter = new Query.FilterPredicate("EmployeeId", Query.FilterOperator.GREATER_THAN_OR_EQUAL, 100);
	Filter propertyFilter1 = new Query.FilterPredicate("EmployeeId", Query.FilterOperator.LESS_THAN, 105);
	Filter filter = CompositeFilterOperator.and(propertyFilter, propertyFilter1);
	query.setFilter(filter);

	query.addSort("EmployeeId");
	
	//query.addSort("name", SortDirection.ASCENDING);
	//query.addSort("salary", SortDirection.DESCENDING);
	
	PreparedQuery preparedQuery = datastoreService.prepare(query);
	
	out.println("<p><strong> The Employee Information is: </strong> <br>");
	int i=1;
	for(Entity entity : preparedQuery.asIterable()) {
		
		out.println("<br>Employee : "+i+ " Information<br>");
		
		long employeeId = (long)entity.getProperty("EmployeeId");
		String name = (String)entity.getProperty("Title");
		long salary = (long)entity.getProperty("Salary");
		String designation = (String)entity.getProperty("Designation");
		
		out.println("Email Id: "+employeeId+" <br> Employee Name : "+name+" <br>Employee Salary: "+salary+" <br>Designation: "+designation);
		out.println("<br>");
		i=i+1;
	}
  }
}