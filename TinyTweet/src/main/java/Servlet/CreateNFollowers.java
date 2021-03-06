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
	public class CreateNFollowers extends HttpServlet {
		 static {
			 ObjectifyService.register(Htag.class);
		     ObjectifyService.register(Tweet.class);
			 ObjectifyService.register(Utilisateur.class);
			 ObjectifyService.register(Follow.class);
			 ObjectifyService.register(Follower.class);

			
		    }

		 @Override
		  public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws ServletException, IOException {
			 		 
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    this.getServletContext().getRequestDispatcher( "/WEB-INF/CreateNFollower.jsp" ).forward( request, response );
		  }
		  
		    @SuppressWarnings("unused")
			public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		    	  String pseudo = request.getParameter("pseudo");
		    	  String name = request.getParameter("name");
		    	  String firstname = request.getParameter("firstname");
		    	  String nb_follower = request.getParameter("nb_follow");
		    	  int nb_followers = Integer.parseInt(nb_follower);
		    	
		    	  
		    	 //recuperer la personne dans le datastore 
		    	  Utilisateur utilisateur = (Utilisateur)ofy().load().type(Utilisateur.class).id(pseudo).now();
		    	  if(utilisateur == null) {
		    		  
		    		  //si elle n'xiste pas on cree une
		    		  Utilisateur nouvuser = new Utilisateur(pseudo,firstname,name);
		    		  ofy().save().entity(nouvuser).now();
		    		  Follower followed = new Follower(pseudo);
		    		  Follow avide = new Follow(pseudo);
		    		  avide.addFollower(nouvuser);
		    		  followed.addFollowed(nouvuser);
		    		  ofy().save().entity(avide).now();
		    		  ofy().save().entity(followed).now();
		    		  for (int i=0; i<nb_followers; i++) {
		    			 Utilisateur dummy = new Utilisateur(pseudo+"_"+i, firstname+"_"+i, name+"_"+i);
		    			 ofy().save().entity(dummy).now();
		    			 
		    			 Follow follow= new Follow(dummy.getId());
		    			 follow.addFollower(nouvuser);
		    			 follow.addFollower(dummy);
		    			 ofy().save().entity(follow).now();
		    			 
		    			 Follower followeduser= new Follower(dummy.getId());
		    			 followeduser.addFollowed(dummy);
		    			 ofy().save().entity(followeduser).now();
		    			 
		    			 followed.addFollowed(dummy);
		    			 ofy().save().entity(followed).now();
		    			 
		    		  }
		    	  }else {
		    		 // elle existe on ne fait rien
		    		  System.out.println("user already exist, nice");
		    		 
		    	  }
		    	  /* Création ou récupération de la session */

		    	  HttpSession session = request.getSession();
		    	  session.setAttribute( "pseudo", pseudo );
		    	  request.setAttribute("time", 0);
		  	    this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilconnecte.jsp" ).forward( request, response );

			    }		    
	}
