package data_mining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class regle_confiance {
	
	public static ArrayList<String> intersection2(ArrayList<String> l1,ArrayList<String>l2){
		
		ArrayList<String> res=new ArrayList<>();
	  
		res.addAll(l2);
		res.addAll(l1);
		Set<String> set = new HashSet<>(res);
		
		return new ArrayList<>(set);
	 
		

	}
	public  static 	Set<Set<String>>genrer_combinaison(HashMap<ArrayList<String>, Integer> f) {
		Set<Set<String>> res=new HashSet<>();
 for ( ArrayList<String> key1 : f.keySet()) {
	            for (ArrayList<String> key2 : f.keySet()) {
	            		
	            	if(!key1.equals(key2) ) {			
              			Set<String> set = new HashSet<String>(intersection2(key2, key1)); 			
                     			res.add(set);
	                      	}
	            	           	}            		           
		  }
		  
		 return res;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<ArrayList<String>, Integer> f=new HashMap<>();
	ArrayList<String> l=new ArrayList<>();
	ArrayList<String> l2=new ArrayList<>();
	ArrayList<String> l3=new ArrayList<>();
	l.add("I11");l.add("I13");l.add("I24");
	 
	l2.add("I33");l3.add("I21");
 
	f.put(l,1);
	f.put(l2,1);
	f.put(l3,1);
	regle_confiance rc=new regle_confiance();
	System.out.println("\n res "+	rc.genrer_combinaison(f));
	}

}
