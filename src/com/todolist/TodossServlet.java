package com.todolist;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
@SuppressWarnings("serial")
public class TodossServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String list = req.getParameter("name");
		//String email = req.getParameter("email");		
		System.out.print(list);
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		Entity ent = new Entity("todolist");
		ent.setProperty("list", list);
		//ent.setProperty("email", email);
		
		try {
			ds.put(ent);
		}
		catch (Exception error) {
			error.printStackTrace();
		}
		resp.setContentType("text/plain");
		resp.getWriter().println(list);
				
	}
}