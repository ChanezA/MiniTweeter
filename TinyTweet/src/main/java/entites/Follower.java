package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Follower {
	 @Id String user; 
	 private ArrayList<Utilisateur> followed;
	 private Follower (){}
	 public Follower(String parent) {
		this.followed = new ArrayList<Utilisateur>();
		this.user=parent;
	 }
	 public void addFollowed(Utilisateur user) {
		 this.followed.add(user);
	 }
	 
	 public ArrayList<Utilisateur> getFollowed(){
		 return followed;
	 }
}
