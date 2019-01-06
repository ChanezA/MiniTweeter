package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.server.spi.auth.common.User;
import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.users.UserService;
import com.googlecode.objectify.annotation.*;

@Entity
@Cache
@Index
public class Utilisateur {
	@Id String id;
	private String firstname;
	private String lastname;

	private Utilisateur() {}//obligatoire pour objectify
	public Utilisateur(String pseudo,String fname,String lname) {
		this.id=pseudo;
		this.firstname=fname;
		this.lastname=lname;
	}
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public String afficherMessage(Tweet tweet) {
		System.out.println(tweet.getMessage());
		return tweet.getMessage();
	}
	
}
