package Entités;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
public class Tweet {
	@Id Long id;
	private String message;
	private User owner;
	private ArrayList<User>tague;
	private ArrayList<Htag>htags;
	public Tweet() {}// Obligatoire pour Objectify
	public Tweet(String mess, User owner) {
		this.message=mess;
		this.owner=owner;
		this.tague=new ArrayList<User>();
		this.htags=new ArrayList<Htag>();
	}
}
