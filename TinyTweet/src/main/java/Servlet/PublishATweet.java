package Servlet;
import java.io.IOException;
import java.sql.Date;

import com.googlecode.objectify.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.util.DateTime;

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
	    this.getServletContext().getRequestDispatcher( "/WEB-INF/NewTweet.jsp" ).forward( request, response );
	  }
	  
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{

	    	 /* Récupération des champs du formulaire. */
	        String pseudo = request.getParameter("pseudo");
	        String message = request.getParameter("message");

	        try {
	            validationPseudo( pseudo );
	        } catch (Exception e) {
	            /* Gérer les erreurs de validation ici. */

	        }
	        Utilisateur utilisateur = ofy().load().type(Utilisateur.class).id("pseudo").now();
	        Tweet newTweet = new Tweet(message,utilisateur);
			 ofy().save().entity(newTweet).now();

	    }

	    private void validationPseudo( String email ) throws Exception{
	    	 if ( true) {
	    		 /*pseudo existe dans la base de donnee*/
	    	    } else {
	    	        throw new Exception( "Merci de saisir à nouveau." );
	    	    }
	    }
	  
}
