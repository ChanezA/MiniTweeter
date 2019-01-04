package Servlet;
import java.io.IOException;
import java.sql.Date;

import com.googlecode.objectify.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.google.api.client.util.DateTime;
import com.google.api.services.discovery.Discovery.Apis.List;

import javax.servlet.http.*;
import com.googlecode.objectify.ObjectifyService;


import entites.*;
import static com.googlecode.objectify.ObjectifyService.ofy;
@SuppressWarnings("serial")
public class PublishATweet extends HttpServlet {

	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws ServletException, IOException {
		  //selectionner tout les ancien tweets 
	    response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().print("Hello App Engine!\r\n");
	    //afficher la lists des tweet	   	    
	    try {
            // Requête Objectify
            java.util.List<Tweet> tweets = ofy().load().type(Tweet.class).limit(5).list();       
            request.setAttribute("tweets", tweets);
    	    this.getServletContext().getRequestDispatcher( "/WEB-INF/NewTweet.jsp" ).forward( request, response );
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	    
	  }
	  
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

	    	 /* Récupération des champs du formulaire. */
	        String message = request.getParameter("message");
	        
	        HttpSession session = request.getSession();
	        String pseudo = (String) session.getAttribute( "pseudo" );
	        
	        //Utilisateur user = ofy().load().type(Utilisateur.class).filter("pseudo",pseudo);
	        Tweet newTweet = new Tweet(message,pseudo);
			ofy().save().entity(newTweet).now();
			this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilconnecte.jsp" ).forward( request, response );


	    }

	  
}
