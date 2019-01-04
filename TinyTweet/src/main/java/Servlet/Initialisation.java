package Servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

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
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import entites.*;

import static com.googlecode.objectify.ObjectifyService.ofy;

@SuppressWarnings("serial")
public class Initialisation extends HttpServlet {
	 static {
		 ObjectifyService.register(Htag.class);
	     ObjectifyService.register(Tweet.class);
		 ObjectifyService.register(Utilisateur.class);
		 ObjectifyService.register(Followers.class);
		 ObjectifyService.register(Followed.class);

		
	    }

	 @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws ServletException, IOException {
		 //User cha = new User("cha", "chanez","amri");
		// User ili = new User("ili", "ilias","amri");
		 //ofy().save().entity(cha).now();
		 //ofy().save().entity(ili).now();
		 //request.setAttribute("cha", cha);
		 
		 //Utilisateur utilisateurs =  (Utilisateur) ofy().load().type(Utilisateur.class).filter("googleUser",userService.getCurrentUser()).list();
		//utilisateurs == null
	
		 
		 
		 		 
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().print("Hello App Engine!\r\n");
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/initialisation.jsp" ).forward( request, response );
	  }
	  
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	    	  String pseudo = request.getParameter("pseudo");
	    	  String name = request.getParameter("name");
	    	  String firstname = request.getParameter("firstname");
	    	  
	    	 //recuperer la personne dans le datastore 
	    	  Utilisateur utilisateur = (Utilisateur)ofy().load().type(Utilisateur.class).id("pseudo").now();
	    	  if(utilisateur == null) {
	    		  //si elle n'xiste pas on cree une
	    		  Utilisateur nouvuser = new Utilisateur(pseudo,firstname,name);
	    		  ofy().save().entity(nouvuser).now();
	    		  Followers follow= new Followers(pseudo);
	    		  Followed followed= new Followed(pseudo);
	    		  
	    		  ofy().save().entity(followed).now();
	    		  ofy().save().entity(follow).now();
	    	  }else {
	    		 // elle existe on ne fait rien
	    		 
	    	  }
	    	  /* Création ou récupération de la session */

	    	  HttpSession session = request.getSession();
	    	  session.setAttribute( "pseudo", pseudo );
	  	    this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilconnecte.jsp" ).forward( request, response );

		    }

	
	   
	    
}