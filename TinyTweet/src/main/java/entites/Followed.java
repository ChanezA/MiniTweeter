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
	 @Parent Key user;
	 private Hashtable<String,User> followed;
	 public Followed (){}
	 public Followed(Key parent) {
		this.followed = new Hashtable<String, User>();
		this.user=parent;
	 }
}
