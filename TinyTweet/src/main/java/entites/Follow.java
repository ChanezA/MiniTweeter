package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Follow {
	 @Id String user;
	 private ArrayList<Utilisateur> followers;
	 public Follow (){}
	 public Follow(String parent) {
		this.followers = new ArrayList<Utilisateur>();
		this.user=parent;
	 }
	 public void addFollower(Utilisateur user) {
		 this.followers.add(user);
	 }
	 
	 public ArrayList<Utilisateur> getfollowers(){
		 return followers;
	 }
	 
	 public String getUser() {
		 return user;
	 }
}
