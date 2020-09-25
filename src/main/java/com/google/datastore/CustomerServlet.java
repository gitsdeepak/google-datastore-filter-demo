package com.google.datastore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.datastore.model.Customer;
import com.google.datastore.service.CustomerService;

@WebServlet(name = "GoogleDatastoreServlet", urlPatterns = { "/customer" })
public class CustomerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Customer customer = new Customer("A001", "Ramit", "892052879", "New Delhi");
		
		CustomerService.ofy().save().entities(customer);
		
		out.println(" Customer Information is Saved Successfully !!");
		
		
		
		

	}
}