package entites;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Htag {
	@Id Long id;
	private ArrayList<Tweet>tweets;
	public Htag(){
		this.tweets=new ArrayList<Tweet>();
	}// Obligatoire pour Objectify
	
}
