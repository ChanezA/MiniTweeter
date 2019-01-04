package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Followed {
	 @Id Long id;
	 String user;
	 private Hashtable<String,Utilisateur> followed;
	 private Followed (){}
	 public Followed(String parent) {
		this.followed = new Hashtable<String, Utilisateur>();
		this.user=parent;
	 }
	 public void addFollowed(String pseudo,Utilisateur user) {
		 this.followed.put(pseudo, user);
	 }
}
