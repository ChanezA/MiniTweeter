package entites;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
@Cache
@Index
public class Tweet {
	@Id Long id;
	private String message;
	private User owner;
	private Htag htags;
	
	private Tweet() {}// Obligatoire pour Objectify
	public Tweet(String mess,User owner) {
		this.message=mess;
		this.owner=owner;
	}
	
	public Tweet(String mess, User owner,Htag htag) {
		this.message=mess;
		this.owner=owner;
		this.htags=htag;
	}
	
	public void setHtag(Htag htag) {
		this.htags=htag;
	}
	
	
}
