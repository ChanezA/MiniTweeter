package entites;
import java.util.ArrayList;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class User {
	@Id Long id;
	private String firstname;
	private String lastname;
	private ArrayList<User> followers;
	private ArrayList<User> followed;
	private String pseudo;
	public User() {}//obligatoire pour objectify
	public User(String pseudo,String fname,String lname) {
		this.pseudo=pseudo;
		this.firstname=fname;
		this.lastname=lname;
		this.followers = new ArrayList<User>();
		this.followed = new ArrayList<User>();

	}
}
