package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class User {
	@Id Long id;
	private String firstname;
	private String lastname;
	private String pseudo;
	public User() {}//obligatoire pour objectify
	public User(String pseudo,String fname,String lname) {
		this.pseudo=pseudo;
		this.firstname=fname;
		this.lastname=lname;
	}
}
