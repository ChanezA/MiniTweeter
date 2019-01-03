package entites;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.api.datastore.Key;
import com.googlecode.objectify.annotation.*;

@Entity
@Index

public class Followers {
	 @Id Long id;
	 @Parent Key user;
	 private Hashtable<String,Utilisateur> followers;
	 public Followers (){}
	 public Followers(Key parent) {
		this.followers = new Hashtable<String, Utilisateur>();
		this.user=parent;
	 }
}
