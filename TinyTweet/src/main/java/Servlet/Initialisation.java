package Servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.util.DateTime;
import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

import javax.servlet.http.*;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.LoadType;

import entites.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class Initialisation extends HttpServlet {
	 static {
	       // ObjectifyService.register(Tweet.class);
		 //ObjectifyService.register(User.class);
	       
	    }

	 @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws ServletException, IOException {

	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    java.util.Date juDate= new java.util.Date() ;
	    DateTime dt = new DateTime(juDate);
	    Integer jourDuMois = dt.getTimeZoneShift();
	    request.setAttribute( "jour", jourDuMois );
	    response.getWriter().print("Hello App Engine!\r\n");
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/initialisation.jsp" ).forward( request, response );
	  }
	  
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

	        System.out.println("enfinnnndans le psot");

	    }
}