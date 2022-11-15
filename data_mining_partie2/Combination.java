package data_mining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Combination {
	 String[] arr = {"A","B","C","D","E"};
	public  static ArrayList<String> entrer=new ArrayList<>();
	
	 
 public static 	HashMap<ArrayList<String>,ArrayList<String> > res= new HashMap<>();
public static ArrayList<String> remove_n_element(	ArrayList<String> entrer,ArrayList<String> t1){
		ArrayList<String> res= new ArrayList<>();
		
		for(int i=0;i<entrer.size();i++) {
			int j=0;
			while(j<t1.size()) {
				
			if(entrer.get(i).equals(t1.get(j))) {
				break;
			}else 
				j++;
			
			}
			if(j==t1.size()) {
				res.add(entrer.get(i));
			}
		}
			
		return res ;
		
	}

	   
 public static void main(String[] args){
        String[] arr = {"A","B","C","D","E"};
        
         
       for(int i=1;i<=4;i++)
        
       combinations2(arr, i, 0, new String[i]) ;
     
    }

    public static  String[] combinations2(String[] arr, int len, int startPosition, String[] result){
    
    	if (len == 0){
            System.out.println(Arrays.toString(result));
            //res.put( Arrays.asList(result),remove_n_element(entrer,Arrays.asList(result)) );
            return result;
        }       
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            
            combinations2(arr, len-1, i+1, result);
        }
		return result;
    }       
}