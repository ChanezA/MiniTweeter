package Entités;
import java.util.ArrayList;

import com.googlecode.objectify.annotation.*;

@Entity
public class Htag {
	@Id Long id;
	private ArrayList<Tweet>tweets;
	public Htag(){
		this.tweets=new ArrayList<Tweet>();
	}// Obligatoire pour Objectify
	
}
