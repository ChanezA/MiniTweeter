package Servlet;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.util.DateTime;

import javax.servlet.http.*;
import com.googlecode.objectify.ObjectifyService;

import Entités.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

/*@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)*/
@SuppressWarnings("serial")
public class HelloAppEngine extends HttpServlet {

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
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp" ).forward( request, response );
	  }
}
