package Servlet;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

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
	    response.getWriter().print("Publier un tweet");
	    //afficher la lists des tweet	   	    
	    try {
	    	
	    	HttpSession session = request.getSession();
	        String pseudo = (String) session.getAttribute( "pseudo" );
			Follower followers = ofy().load().type(Follower.class).id(pseudo).now();
			 
			
			ArrayList<Utilisateur> mesfollowers = followers.getFollowed();
			if(mesfollowers == null) {
				request.setAttribute("resultat", "pas de followers");
			} else {
				int i = 0;
				for (Utilisateur follower : mesfollowers) {
					java.util.List<Tweet> tweets = ofy().load().type(Tweet.class).filter("owner",follower.getId()).list();
					request.setAttribute("tweetdesfollowers"+i, tweets);
					++i;
	           }
	           request.setAttribute("resultat", "succes");
	           request.setAttribute("nbIter", i);
			}
	            
	        //java.util.List<Tweet> tweets = ofy().load().type(Tweet.class).limit(5).list();       
            //request.setAttribute("tweet", tweets);
    	    this.getServletContext().getRequestDispatcher( "/WEB-INF/NewTweet.jsp" ).forward(request, response);
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
	        
	        Utilisateur user = ofy().load().type(Utilisateur.class).id(pseudo).now();
	        long var = System.currentTimeMillis();
	        Tweet newTweet = new Tweet(message,pseudo);
			ofy().save().entity(newTweet).now();
			
			//récuperer tout les followers de user 
			Follower followers = ofy().load().type(Follower.class).id(pseudo).now();
			ArrayList<Utilisateur> mesfollowers = followers.getFollowed();
			long var1 = System.currentTimeMillis();
	            for (Utilisateur follower : mesfollowers) {
	            	follower.afficherMessage(newTweet);
	            }
	        var1 = System.currentTimeMillis() - var1;
	        System.out.println("var1= " + var1);
	        request.setAttribute("time", var1);
			//faire un foreach et appeler afficher message pour chacun
			this.getServletContext().getRequestDispatcher( "/WEB-INF/acceuilconnecte.jsp" ).forward( request, response );
	    }
}
