package data_mining;
 
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JTextArea;

public class Algo_Eclat {
	public static  Map<ArrayList<String>, ArrayList<String>> tvtemp;
		public static void init_map(ArrayList<ArrayList<String>> dataset,int q){
			ArrayList<String> arraylist = new ArrayList<String>();
			ArrayList<String> cle = new ArrayList<String>();
			for (int i=0;i<dataset.get(0).size();i++) 
			arraylist.add("0");
			int k=1;
			int j=1;
			while(k<=(q)) {
				 
				
				String b="I"+j+""+k;
				cle.add(b);
				tvtemp.put(cle,arraylist);
			
				if(j%7==0) {k+=1;j=j-7;}
				j++;
				cle=new ArrayList<>();
			}
			
		}
		
		public static HashMap<ArrayList<String>, Integer> countSupport() {
			
			HashMap<ArrayList<String>, Integer> ts=new HashMap<>();
			int supp = 0;
			ArrayList<String> cle = new ArrayList<String>();
			for(Entry<ArrayList<String>, ArrayList<String>> item : tvtemp.entrySet()) {
				cle=new ArrayList<>();
				supp = 0;
				cle.addAll(item.getKey());
				for(int i = 0 ; i <tvtemp.get(cle).size() ; i++ ) {
					supp +=  Integer.parseInt(tvtemp.get(cle).get(i));
				}
				ts.put(cle,supp);
			}
			
			return ts;
		}
		
		public static HashMap<ArrayList<String>, Integer> suppSupportMinimal( HashMap<ArrayList<String>, Integer> ts , int min , int size){
			int suppMini = (int) Math.ceil((double)min*size/(double)100); 
			
			HashMap<ArrayList<String>, Integer> tsupp = new HashMap<>();
			ArrayList<String> tp=new ArrayList<>();
			for (Entry<ArrayList<String>, Integer> item : ts.entrySet()) {
				tp=new ArrayList<>();
				tp.addAll(item.getKey());
				
				if( item.getValue() >= suppMini ) {
					tsupp.put(tp,item.getValue());
				}
			}
			
			return tsupp;
		}
		
		public static Map<ArrayList<String>,ArrayList<String>> convertToMap(HashMap<ArrayList<String>, Integer> tsupp
){
			Map<ArrayList<String>,ArrayList<String>> newtv = new HashMap<>();
			
			for(Entry<ArrayList<String>, ArrayList<String>> item : tvtemp.entrySet()) {
				for(Entry<ArrayList<String>, Integer> item1 : tsupp.entrySet()) {
				
				
				if(item1.getKey().contains(item.getKey().get(0))) {
					newtv.put(item.getKey(), item.getValue());break;
				}
				
				
			}
			}
			
			
		return newtv;	
		}
		
		public static  	ArrayList<String> count_items(ArrayList<ArrayList<String>> dataset  ,String x) {
			ArrayList<String> a = new ArrayList<String>();
			
			for (int k=0;k<dataset.get(0).size();k++) a.add("0");
			
			for (int i=0;i<dataset.size();i++) {
								
				for (int j=0;j<dataset.get(i).size();j++) {
				
					if(x.equals(dataset.get(i).get(j))) 
						a.set(j,"1");				
					
				}
				
				}
			
			return a;
		}

		public static void table_v(ArrayList<ArrayList<String>> dataset ,int q) 
		{	 
		 	ArrayList<String> cle = new ArrayList<String>();
				init_map(dataset,q);//initialiser le map par listes ZEROS 
 			     for (Entry<ArrayList<String>, ArrayList<String>> entry : tvtemp.entrySet()) {
 			    	 	cle = new ArrayList<String>();
			            cle.addAll(entry.getKey());
            	tvtemp.replace(cle, count_items(dataset,cle.get(0)));
			            	 
						 
					}					
				 
			 
				} 
		
		public static ArrayList<String> intersection2(ArrayList<String> l1,ArrayList<String>l2){
			
			ArrayList<String> res=new ArrayList<>();
		  
			res.addAll(l2);
			res.addAll(l1);
			Set<String> set = new HashSet<>(res);
			
			return new ArrayList<>(set);
		 
			
	
		}

		public  static ArrayList<ArrayList<String>> genrer_combinaison(HashMap<ArrayList<String>, Integer> f) {
		Set<Set<String>> res=new HashSet<>();
		
		ArrayList<ArrayList<String>>  output=new ArrayList<> ();  
		ArrayList<String>  outtemp=new ArrayList<> ();
		long startTime = System.nanoTime();
		 for ( ArrayList<String> key1 : f.keySet()) {
	            for (ArrayList<String> key2 : f.keySet()) {
	            		
	            	if(!key1.equals(key2) ) {			
	            			 
	            			Set<String> set = new HashSet<String>(intersection2(key2, key1));
	            		
	            			res.add(set);
	            			
	            		}
	            			
	            	}
	            		
	                   
		  }
		 long stopTime = System.nanoTime();
			System.out.println("gen comb time ==>"+(stopTime - startTime));

			
		
		 for(Set<String> set : res) {
			 outtemp=new ArrayList<> ();  
			 for(String key : set) {
				 outtemp.add(key);
				 
		     }
			 output.add(outtemp);
		 }
		 return output;
	 }
		public static String list_to_String(ArrayList<String> list) {
			String mot="";
			
			  for(int k=0;k<list.size();k++) {
				  	mot+=list.get(k);
			  
			  }
			return mot;
		}
		
		public static ArrayList<String> intersection(ArrayList<String> l1,ArrayList<String>l2){
			
			ArrayList<String> res=new ArrayList<>();
			for(int i=0;i<l1.size();i++) {
				if(l1.get(i).equals(l2.get(i))) {
					res.add(l1.get(i));
				}else res.add("0");
			}
			
			
			return res;
		}
		
		public static Integer calcule_de_1(ArrayList<String> l1) {
			int res=0;
			for(int i=0;i<l1.size();i++) 
				if(l1.get(i).equals("1"))res+=1;
			
			return res;
		}
		
		public static ArrayList<String> intersection_array(ArrayList<ArrayList<String>> list){
			ArrayList<String> res=new ArrayList<>();
			for(int j=0;j<list.get(0).size();j++) {
				int i=1;
				boolean trouve=false;
				while(i<list.size()) {
					if(list.get(0).get(j).equals("1")) {
						if(list.get(0).get(j).equals(list.get(i).get(j))) {
							trouve=true;
							i++;
						}else {
							trouve=false;
							break;	
							}
					}else {
						break;
					}
				}
				if(trouve==true) res.add("1");
				else res.add("0");
			}
			return res;
		}
		
		public static HashMap<ArrayList<String>, Integer>  countsupportN(
				ArrayList<ArrayList<String>> combinaison ,Map <ArrayList<String>,ArrayList<String>> tv ){
			
			HashMap <ArrayList<String>,Integer> temp=new HashMap<> ();//recuperer les listes de tout les combinaison....
			ArrayList<ArrayList<String>> list=new ArrayList<>();
		    if(combinaison.size() != 0)   {   
			for(int i=0;i<combinaison.size();i++) {
				list=new ArrayList<>();
				  for(int j=0;j<combinaison.get(i).size();j++) {
					 	list.add(tv.get( Arrays.asList(combinaison.get(i).get(j))));
					}

					  temp.put(combinaison.get(i),calcule_de_1(intersection_array(list)));

			}
		    }
			
			
			return temp;
	 	}
		
		public static HashMap<ArrayList<String>, Integer> eclat (ArrayList<ArrayList<String>> dataset ,int min,int q,JTextArea t) {
			
			 HashMap<ArrayList<String>, Integer> countsupp=new HashMap<>();
			 HashMap<ArrayList<String>, Integer> supprimersupport1=new HashMap<>();
			 ArrayList<ArrayList<String>>  gc=new ArrayList<> ();  
			 HashMap<ArrayList<String>, Integer> ctn=new HashMap<>();
			 Map<ArrayList<String>,ArrayList<String>> tempm = new HashMap<>();
			 HashMap<ArrayList<String>, Integer> res=new HashMap<>();
			
			 t.setText("");//init etxt area
	
			 countsupp=countSupport();
			t.append("\n C1 :"+countsupp);
			
			supprimersupport1=suppSupportMinimal(countsupp,min,dataset.get(0).size());
			t.append("\n L1 :"+supprimersupport1);
			
			int i=1;
			res.putAll(supprimersupport1);
	
			while(true) {//tant que la taille de la combinaison generer != une seul list
				i=i+1;
				
				gc.addAll(genrer_combinaison(supprimersupport1));

 
				//initilaiser chaque fois combinaison generer
				ctn=new HashMap<>();//initlaiser chaque fois support minimum a ete calculer 
			 	
				tempm = convertToMap(supprimersupport1);
				

				ctn=countsupportN(gc,tempm);
				t.append("\n C"+i+" : " +ctn);
				
				//supprimer supp minimum a chaque fois quand calcule le support des combinaison
				supprimersupport1=suppSupportMinimal(ctn,min,dataset.get(0).size());

				
			    if(supprimersupport1.size()>0)
			 	t.append("\n L"+i+" : " +supprimersupport1);
			    
			    if(supprimersupport1.size() ==0) break;
				res.putAll(supprimersupport1);
				
				gc=new ArrayList<> ();
 
			}
		 
		t.append("\nRésultat final de l'algorithme :\n"+res+" , nombre d élèments ="+ res.size()+"\n");	
		return res; 	
		}
		
		
		     
        	
				 
			//}
			
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
	 public static 	HashMap<ArrayList<String>,ArrayList<String> > regle= new HashMap<>();//regle 	
 
	 public static  String[] combinations2(String[] arr, int len, int startPosition, 
			 String[] result,ArrayList<String> entrer,int indice){
		 ArrayList<String> temp=new ArrayList<>();
		    	if (len == 0){
		         //   System.out.println(Arrays.toString(result));
		            for(int i=0;i<result.length;i++) temp.add(result[i]);
		            	temp.add(""+indice);
		           regle.put(temp,remove_n_element(entrer,temp));
		            return result;
		        }       
		        for (int i = startPosition; i <= arr.length-len; i++){
		            result[result.length - len] = arr[i];
		            
		            combinations2(arr, len-1, i+1, result,entrer,indice);
		        }
				return result;
		    }  
		  
		public static void regle_association( HashMap<ArrayList<String>, Integer> entrer){
			regle= new HashMap<>();
			ArrayList<String> temp=new ArrayList<>();
			String[] arr;
			int indice=1;
			for (ArrayList<String> key2 : entrer.keySet()) {
        		if(key2.size()>=2) {//combinaison de taille superieur ou egale a 2
				temp=new ArrayList<>();
        		temp.addAll(key2);
        	 
        		arr=new String[temp.size()];
        		for(int i=0;i<temp.size();i++)
			        arr[i]=temp.get(i);
 			    
        		for(int j=1;j<temp.size();j++)  {
 			     combinations2(arr, j, 0, new String[j],key2,indice) ;
        		}
        		indice+=1;
        	
 			    
                  			 	    		}
			}
			 
		}
		
		public static boolean compare(ArrayList<String> entrer ,ArrayList<String> key ) {
			Set<String> s1=new HashSet<>(entrer);
			Set<String> s2=new HashSet<>(key);
			
			 if(s1.equals(s2)) return true;
			return false;
		}
		
		
		public static HashMap <String, Double> support;
		
		public static HashMap<String,Double>  confidance(HashMap<ArrayList<String>, Integer> entrer, int size) {
			//ArrayList <Double> res=new ArrayList<>();
			HashMap<String,Double> res=new HashMap<>();
			ArrayList <String> temp=new ArrayList<>();
			ArrayList <String> tempkey=new ArrayList<>();
			ArrayList <String> value=new ArrayList<>();
			support = new HashMap();
		//	System.out.println("entrer"+entrer+"la taille de regle"+regle.size());
			for (ArrayList<String> key : regle.keySet()) {
				//System.out.println("key"+key);
				tempkey=new ArrayList<>();
				tempkey.addAll(key);
				tempkey.remove(tempkey.size()-1);
				 
					temp=new ArrayList<>();
					value=new ArrayList<>();
					value.addAll(regle.get(key));
					
					temp.addAll(value);
					temp.addAll(tempkey);
					
					//pour  p(A  U  B)
					for (ArrayList<String> entrerkey : entrer.keySet()) {
						if(entrerkey.size()==temp.size()) {
							if(compare(entrerkey,temp)==true) {
								temp=new ArrayList<>();
								temp.addAll(entrerkey);
							                 break;    }
						}
					}
					//pour  p(A)
					for (ArrayList<String> entrerkey : entrer.keySet()) {
						if(entrerkey.size()==tempkey.size()) {
							if(compare(entrerkey,tempkey)==true) {
								tempkey=new ArrayList<>();
								tempkey.addAll(entrerkey);
							                 break;    }
						}
					}
					
					//System.out.println("value"+value);
					//p(A==>B) =p(A U B) /p(A)
					String r=tempkey.toString()+"==>"+value.toString();
					
				/*	System.out.println("key U value "+temp
					+"get valeur de key "+entrer.get(tempkey)
					+"get valeur key U value "+entrer.get(temp));
					*/res.put(r, ((double)entrer.get(temp)/(double)entrer.get(tempkey)));	
					
					support.put(r, ((double)entrer.get(temp)/size));
					
						}
			//System.out.println("resultat===>"+res);
			return res;
		}

		
		public static HashMap<String,Double> calcule_minimum_confidance(HashMap<String,Double> entrer,int minConf){
			//int suppMini = (int) Math.ceil((double)minConf*size/(double)100);
			HashMap<String,Double> res=new HashMap<>();
			///System.out.println("minconf double"+((double)minConf/(double)100));
			for (String entrerkey : entrer.keySet()) {
				if(entrer.get(entrerkey)>=((double)minConf/(double)100)) {
					res.put(entrerkey,entrer.get(entrerkey));
				}
			}
			//System.out.println("apres min conf==>"+res);	
			return res;
		}
		public static HashMap<String,Double>  lift(HashMap<ArrayList<String>, Integer> entrer,int size) {
			//ArrayList <Double> res=new ArrayList<>();
			HashMap<String,Double> res=new HashMap<>();
			ArrayList <String> temp=new ArrayList<>();
			ArrayList <String> tempkey=new ArrayList<>();
			ArrayList <String> value=new ArrayList<>();
			ArrayList <String> valuetemp=new ArrayList<>();
			//System.out.println("entrer"+entrer);
			for (ArrayList<String> key : regle.keySet()) {
			//	System.out.println("key"+key);
				tempkey=new ArrayList<>();
				tempkey.addAll(key);
				tempkey.remove(tempkey.size()-1);
				 
					temp=new ArrayList<>();
					value=new ArrayList<>();
					value.addAll(regle.get(key));
					valuetemp=new ArrayList<>();
					valuetemp.addAll(value);
					
					temp.addAll(value);
					temp.addAll(tempkey);
					
					//pour  p(A  U  B)
					for (ArrayList<String> entrerkey : entrer.keySet()) {
						if(entrerkey.size()==temp.size()) {
							if(compare(entrerkey,temp)==true) {
								temp=new ArrayList<>();
								temp.addAll(entrerkey);
							                 break;    }
						}
					}
					//pour  p(A)
					for (ArrayList<String> entrerkey : entrer.keySet()) {
						if(entrerkey.size()==tempkey.size()) {
							if(compare(entrerkey,tempkey)==true) {
								tempkey=new ArrayList<>();
								tempkey.addAll(entrerkey);
							                 break;    }
						}
					}
					for (ArrayList<String> entrerkey : entrer.keySet()) {
						if(entrerkey.size()==valuetemp.size()) {
							if(compare(entrerkey,valuetemp)==true) {
								valuetemp=new ArrayList<>();
								valuetemp.addAll(entrerkey);
							                 break;    }
						}
					}
					//System.out.println("value"+value);
					//p(A==>B) =p(A U B) /p(A)
					String r=tempkey.toString()+"==>"+valuetemp.toString();
					 
					
				/*	System.out.println("regle"+r+"key U value "+temp
					+"get valeur de key "+entrer.get(tempkey)
					+"get valeur key U value "+entrer.get(temp));
					*/res.put(r, (((double)entrer.get(temp)*size)/
							(
							(double)entrer.get(tempkey)*(double)entrer.get(valuetemp)))
							);	
					//System.out.println("apres insert res"+res.get(r));
				
						}
			//System.out.println("resultat lift ===>"+res);
			return res;
		}
	
		
		public static void main(String[] args) throws FileNotFoundException{
				ArrayList<String> fq = new ArrayList<>();
				ArrayList<String> fq1 = new ArrayList<>();
				ArrayList<String> fq2 = new ArrayList<>();
				HashMap<String, Integer> ts=new HashMap<String, Integer>();
		        ArrayList<ArrayList<String>> attribut = new ArrayList<ArrayList<String>>();
		        Map<String, ArrayList<String>> tv = new HashMap<String,ArrayList<String>>();
		        HashMap<String, String> combine=new HashMap<>();
			 HashMap<ArrayList<String>, Integer> countsupp=new HashMap<>();
			 HashMap<ArrayList<String>, Integer> supprimersupport1=new HashMap<>();
			 ArrayList<ArrayList<String>>  gc=new ArrayList<> ();  
			 HashMap<ArrayList<String>, Integer> ctn=new HashMap<>();
			 HashMap<ArrayList<String>,Integer>  resFinal = new HashMap<>();
			 HashMap<ArrayList<String>, Integer> res=new HashMap<>();
//			 
//			 	
//			 tv=table_v(dataset, q);
//			 System.out.println("\nla table verticale  :\n "+tv);
//			
//			 countsupp=countSupport(tv);
//			System.out.println("\nsupport calculer de 1 er :\n "+countsupp);
			    Algo_Eclat e=new Algo_Eclat();
//			
//			//	
//		
//			System.out.println("\nsupport supprimer 1 er etape:\n"+supprimersupport1);	
//		
//			 System.out.println("\n res copier"+res.keySet());
//			     IHM im2=new IHM();
//			    ArrayList<Double>
//		          A = new ArrayList<>(),
//		          P = new ArrayList<>(),
//		          C = new ArrayList<>(),
//		          LoK = new ArrayList<>(),
//		          WoK = new ArrayList<>(),
//		          AC = new ArrayList<>(),
//		          LoKG = new ArrayList<>();
//				  ArrayList<String> Class = new ArrayList<>();
//				
//				  BufferedReader br = new BufferedReader(new FileReader("seeds.txt"));
//			        String line;
//			        String[] temp;
//
//			        try {
//						while ((line = br.readLine()) != null) {
//						    temp = line.split("\t+");
//						    A.add(Double.valueOf(temp[0]));
//						    P.add(Double.valueOf(temp[1]));
//						    C.add(Double.valueOf(temp[2]));
//						    LoK.add(Double.valueOf(temp[3]));
//						    WoK.add(Double.valueOf(temp[4]));
//						    AC.add(Double.valueOf(temp[5]));
//						    LoKG.add(Double.valueOf(temp[6]));
//						    switch (temp[7]) {
//						        case "1":
//						            Class.add("Kama");
//						            break;
//						        case "2":
//						            Class.add("Rosa");
//						            break;
//						        case "3":
//						            Class.add("Canadian");
//						            break;
//						    }
//						}
//					} catch (NumberFormatException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//			        attribut.add(im2.DiscreteAmplitude(A, 1, 3, 0.001));
//			        attribut.add(im2.DiscreteAmplitude(P, 2, 3, 0.001)) ;
//			        attribut.add(im2.DiscreteAmplitude(C, 3, 3, 0.001));
//			        attribut.add(im2.DiscreteAmplitude(LoK, 4, 3, 0.001));
//			        attribut.add( im2.DiscreteAmplitude(WoK, 5, 3, 0.001));
//			        attribut.add(im2.DiscreteAmplitude(AC, 6, 3, 0.001));
//			        attribut.add( im2.DiscreteAmplitude(LoKG, 7, 3, 0.001));
//			        System.out.println(attribut);
//////			        
//			    res.putAll(e.eclat(attribut, 20, 3));
//			    e.regle_association(res );
//			   
//			   
////			  e.calcule_minimum_confidance(e.confidance(res), 90);
//			// e.lift(res,210);
//			  
//			    //fq2.remove(fq2.indexOf("I31"));
//			    //System.out.println( e.remove_1_element(fq2, "I31"));
//			    // System.out.println("comparer deux list " +e.compare(fq2, fq1));
//
////			    supprimersupport1= e.suppSupportMinimal(e.countSupport(e.table_v(attribut, 2)), 2,fq.size());
////				  //e.init_map(tv, attribut, 2);
////				  System.out.println("\n1)====>"+supprimersupport1);
////				 ///System.out.println(e.suppSupportMinimal(e.countSupport(e.table_v(attribut, 2)), 2,fq.size()));
////				  
////			  
////			  gc.addAll(e.genrer_combinaison(supprimersupport1));
////			  System.out.print(""+gc);
////			  System.out.print("\n========>"+e.countsupportN(gc,e.table_v(attribut, 2)));
////			
////			  supprimersupport1= e.suppSupportMinimal(e.countsupportN(gc,e.table_v(attribut, 2)), 2,fq.size());
////			  //e.init_map(tv, attribut, 2);
////			  System.out.println("\n2)====>"+supprimersupport1);
////			 // System.out.print(e.genrer_combinaison(supprimersupport1));
////			  gc=new ArrayList<>();
////			  gc.addAll(e.genrer_combinaison(supprimersupport1));
////			  System.out.println("====>genrer2"+gc);
////			  			
//			  // e.init_map(tv,attribut,2);
//		      //System.out.println(tv.keySet());
//		      	 // e.table_v(attribut, 2);
//			  //System.out.print("==>table V \n"+e.table_v(attribut, 2));
//				 // System.out.print("\n"+attribut);
//				 // ts = countSupport(e.table_v(attribut, 2));
//		    /*  System.out.println(tv.get("I32").get(0));
//				  if(tv.entrySet().equals("0")) {
//					  System.out.println("yes");
//				  }else System.out.println("no");
//				 // System.out.println(suppSupportMinimal(ts, 80,fq.size()));
//				  */  
//				//  System.out.println("table v\n"+e.table_v(attribut, 2));
//				  //System.out.println("support min\n"+e.suppSupportMinimal(e.countSupport(e.table_v(attribut, 2)), 80,fq.size()));
//				  //System.out.println("combinaison \n"+e.genrer_combinaison(e.suppSupportMinimal(e.countSupport(e.table_v(attribut, 2))
//						//  , 80,fq.size())));
//					
//				 // System.out.println("resultat\n"+e.countsupportN(e.genrer_combinaison(suppSupportMinimal(
//					//	  e.countSupport(e.table_v(attribut, 2))
//				//		  , 80,fq.size())),e.table_v(attribut, 2)));
//				  //System.out.println("*************************************\n");
//				 // e.eclat(attribut, 2, 5);
//				 // System.out.println(""+e.confiance( e.eclat(attribut, 2, 5)));
//			    //temp.add("D");temp.add("E");
//			   // temp.add("F");
//				//temp.add("I42");temp.add("I45");
//			        
			        fq.add("1");fq.add("1");fq.add("1");fq.add("1");
				 	attribut.add(fq);
				 	fq1.add("1");fq1.add("0");fq1.add("1");fq1.add("1");
				 	fq2.add("1");fq2.add("1");fq2.add("1");fq2.add("1");
				 	attribut.add(fq1);attribut.add(fq2);
				 	System.out.println("result intersection"+e.intersection_array(attribut));
//			  
			 
		 
			    
		}
		    
}
				
		
	
