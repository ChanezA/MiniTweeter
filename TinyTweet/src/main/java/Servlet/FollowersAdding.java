package Servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.googlecode.objectify.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

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
public class FollowersAdding extends HttpServlet {
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
		 response.setContentType("text/plain");
		 response.setCharacterEncoding("UTF-8");
	
		 
		 
		 		 
	    
	   
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/addafollower.jsp" ).forward( request, response );
	  }
	  
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	    	String resultat;
	    	
	    	String aajouter = request.getParameter("aajouter");
	    	  
	    	  HttpSession session = request.getSession();
		      String owner = (String) session.getAttribute( "pseudo" );
	    	  
	    	 //recuperer la personne dans le datastore 
	    	  Utilisateur utilisateur = (Utilisateur)ofy().load().type(Utilisateur.class).id(aajouter).now();
	    	  Utilisateur userowner = (Utilisateur)ofy().load().type(Utilisateur.class).id(owner).now();

	    	  if(utilisateur == null) {
	    		  //si elle n'existe pas renvoie un message precisant que ca n'existe pas 
	    		  resultat = "echec";
	    	  }else {
	    		  //je l'ajoute au gens que je suis
		    	  Followers mesfolloweds =(Followers) ofy().load().type(Followers.class).id(owner).now();
	    		  mesfolloweds.addFollower(utilisateur);
	    		 //je m'ajoute au gens qui le suivent
		    	  Followed sesfollowers = (Followed)ofy().load().type(Followed.class).id(aajouter).now();
		    	  sesfollowers.addFollowed(userowner);
	    		 
	    		 resultat = "Succes";
	    	  }
	     	 
	    	  request.setAttribute( "resultat", resultat );
	  	    this.getServletContext().getRequestDispatcher( "/WEB-INF/addafollower.jsp" ).forward( request, response );

		    }

	
	   
}
