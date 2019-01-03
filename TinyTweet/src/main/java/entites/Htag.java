package entites;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.*;

@Entity
@Index
public class Htag {
	@Id Long id;
	String sentence;//private ArrayList<Tweet>tweets;
	private Htag(){}// Obligatoire pour Objectify
	public Htag(String message){this.sentence=message;}
	
}
