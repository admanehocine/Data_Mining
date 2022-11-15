package data_mining;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class knn {
	
	
	/*dataset[0]=A
	 *dataset[1]=p
	 *dataset[2]=c
	 *dataset[3]=lok
	 *dataset[4]=wok
	 *dataset[5]=ac
	 *dataset[6]=lokg
	 *dataset[7]=class
	 ** */ 
	 

	public static ArrayList<String> double_to_string (ArrayList<Double> list){
		ArrayList<String> res=new ArrayList<String> ();
		
		for(int i=0;i<list.size();i++) {
			res.add(String.valueOf(list.get(i)));
		}
			
		
		return res;
		
	}
	
	public static ArrayList<Double> int_to_double(ArrayList<Integer> list){
		ArrayList<Double> res=new ArrayList<Double> ();
		
		for(int i=0;i<list.size();i++) {
			res.add((double)list.get(i));
		}
		
		return res;
	}
	
	
	public static int remplacer_valeur(ArrayList<String> list,Double x){
		int j=0;
		
		for(j=0;j<list.size();j++) {
			
		
			if(!list.get(j).equals("%")) {
			
				if(list.get(j).equals(String.valueOf(x))) {
					list.set(j, "%");
					break;
				}
			}
		}
			
	
		return j;
		
	}
	
	public  static  ArrayList<ArrayList <Double>> trier_par_insertion(ArrayList<Double> list){
		ArrayList<Double> list2=new ArrayList<Double> ();
		ArrayList<String> temp=new ArrayList<String> ();
		ArrayList<Double> listtrie=new ArrayList<Double> ();
		ArrayList<Double> indicetrie=new ArrayList<Double> ();
		ArrayList<ArrayList <Double>> res=new ArrayList<ArrayList <Double>>();
		
		for(int j=0;j<list.size();j++) 	// retronsformer la list en type String		
		temp.add(String.valueOf(list.get(j)));
	
		
		int j=0;		
		list2.addAll(list);
		while(j<list.size()) {
		
			Double k=Collections.min(list2);
			listtrie.add(k);//inserer la valeur minimum
			indicetrie.add((double)remplacer_valeur(temp,k));//inserer a la list des indice le minimum et remplacer le minimum par %
			list2.remove(Collections.min(list2));//supprimier le minimum de la list2
			j++;
		}
 		res.add(listtrie);
		
		res.add(indicetrie);
		
		return res;
	}
	
	

	public static ArrayList<ArrayList<Integer>> transformer_dataset_fromdescritisation_toINT (ArrayList<ArrayList<String>> dataset)
	{
		 ArrayList<Integer> tempres= new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
		ArrayList<String> liststring=new ArrayList<String> ();
		for(int i=0;i<(dataset.size()-1);i++) {
			liststring=new ArrayList<String> ();//initlialiser a chaque fois la list pour suivre le traitement
			tempres= new ArrayList<Integer>();
			liststring.addAll(dataset.get(i));//transformer list double to string 
			for(int j=0;j<liststring.size();j++)//parcourir la list string 
				tempres.add(Integer.parseInt((liststring.get(j).substring(2,liststring.get(j).length()))));//ajouter a la list integer
		 
		res.add(tempres);//ajouter la list intger a la list de list.
		}

		return res;
	}
	
	
	public  static  ArrayList<Integer> calcule_hamming(ArrayList<ArrayList<String>> re,ArrayList<String> valeur_taper){
		ArrayList<Integer> res= new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> dataset= new ArrayList<ArrayList<Integer>>();
		dataset.addAll(transformer_dataset_fromdescritisation_toINT(re));
		 
		int sumfinal;
		//parcourir ligne par ligne
			 
			 for(int j=0;j<dataset.get(0).size();j++) {
				    sumfinal=0;	
				 	sumfinal+=Math.abs(dataset.get(0).get(j)-Integer.parseInt(valeur_taper.get(0)))
				 	+Math.abs(dataset.get(1).get(j)-Integer.parseInt(valeur_taper.get(1)))
				 	+Math.abs(dataset.get(2).get(j)-Integer.parseInt(valeur_taper.get(2)))
				 	+Math.abs(dataset.get(3).get(j)-Integer.parseInt(valeur_taper.get(3)))
				 	+Math.abs(dataset.get(4).get(j)-Integer.parseInt(valeur_taper.get(4)))
				 	+Math.abs(dataset.get(5).get(j)-Integer.parseInt(valeur_taper.get(5)))
				 	+Math.abs(dataset.get(6).get(j)-Integer.parseInt(valeur_taper.get(6)));
				res.add(sumfinal);
				
			}
			 
			 
		
		
	
		
		return res;
		
	}
	
	
	public  static  ArrayList<Double> calcule_Manhattan(ArrayList<ArrayList<Double>> dataset,ArrayList<String> valeur_taper){
		ArrayList<Double> res= new ArrayList<Double>();
		double sumfinal;
		//parcourir ligne par ligne
			 
			 for(int j=0;j<dataset.get(0).size();j++) {
				    sumfinal=(double)0;	
				 	sumfinal+=Math.abs(dataset.get(0).get(j)-Double.parseDouble(valeur_taper.get(0)))
				 	+Math.abs(dataset.get(1).get(j)-Double.parseDouble(valeur_taper.get(1)))
				 	+Math.abs(dataset.get(2).get(j)-Double.parseDouble(valeur_taper.get(2)))
				 	+Math.abs(dataset.get(3).get(j)-Double.parseDouble(valeur_taper.get(3)))
				 	+Math.abs(dataset.get(4).get(j)-Double.parseDouble(valeur_taper.get(4)))
				 	+Math.abs(dataset.get(5).get(j)-Double.parseDouble(valeur_taper.get(5)))
				 	+Math.abs(dataset.get(6).get(j)-Double.parseDouble(valeur_taper.get(6)));
				res.add(sumfinal);
				
			}
			return res;
		
	}

	public  static  ArrayList<Double> calcule_euclidienne(ArrayList<ArrayList<Double>> dataset,ArrayList<String> valeur_taper){
		ArrayList<Double> res= new ArrayList<Double>();
		double sumfinal;
		//parcourir ligne par ligne
		DecimalFormat f = new DecimalFormat("#.0000"); 
			 for(int j=0;j<dataset.get(0).size();j++) {
				    sumfinal=(double)0;	
				 	sumfinal+=Math.pow(dataset.get(0).get(j)-Double.parseDouble(valeur_taper.get(0)),2)
				 	+Math.pow(dataset.get(1).get(j)-Double.parseDouble(valeur_taper.get(1)),2)
				 	+Math.pow(dataset.get(2).get(j)-Double.parseDouble(valeur_taper.get(2)),2)
				 	+Math.pow(dataset.get(3).get(j)-Double.parseDouble(valeur_taper.get(3)),2)
				 	+Math.pow(dataset.get(4).get(j)-Double.parseDouble(valeur_taper.get(4)),2)
				 	+Math.pow(dataset.get(5).get(j)-Double.parseDouble(valeur_taper.get(5)),2)
				 	+Math.pow(dataset.get(6).get(j)-Double.parseDouble(valeur_taper.get(6)),2);
				 	
					String d=f.format(Math.sqrt(sumfinal));
				 	String d2=d.substring(0,d.indexOf(","));
				 d=d2+"."+d.substring(d.indexOf(",")+1,d.length());
				 			
					res.add(Double.parseDouble(d));
				
			}
			return res;
		
	}
	
	public static String resultat_knn( ArrayList<Double> calcule, ArrayList<String> class_dataset ,int k) {
		ArrayList<String> temp=new ArrayList<String>();
		int nbkama=0,nbcanadian=0,nbrosa=0;
		 for(int j=0;j<k;j++) {
			 	 temp.add(class_dataset.get(j));
					String d=String.valueOf(calcule.get(j));
				 	String d2=d.substring(0,d.indexOf("."));
				 //d=d2+"."+d.substring(d.indexOf(",")+1,d.length());
			 	 if(class_dataset.get(Integer.parseInt(d2)).equals("Canadian")) nbcanadian+=1;
			 	 if(class_dataset.get(Integer.parseInt(d2)).equals("Rosa")) nbrosa+=1;
			 	 if(class_dataset.get(Integer.parseInt(d2)).equals("Kama")) nbkama+=1;
		 }
		 System.out.println("\n nbkama"+nbkama+"nbrosa"+nbrosa+"nbcandian"+nbcanadian+"\n");
		double rand;
		if((nbkama ==nbrosa && nbrosa>nbcanadian))//||() ) {
		{	rand=(double)(Math.random() *( 2 - 1 ));
		if(rand>=0.5) return "Kama";
		else return "Rosa";}
		if(nbkama ==nbcanadian && nbrosa<nbcanadian)
		{	rand=(double)(Math.random() *( 2 - 1 ));
		if(rand>=0.5) return "Kama";
		else return "Canadian";	}
		if(nbrosa ==nbcanadian && nbkama<nbcanadian)
		{	rand=(double)(Math.random() *( 2 - 1 ));
		if(rand>=0.5) return "Rosa";
		else return "Canadian";	}
		
		
	
			if (nbcanadian==nbrosa && nbrosa>nbkama) return "Rosa";	
			
			else {
			
			if(nbkama >nbrosa) {
				if(nbkama>nbcanadian) {
					return "Kama";
				}else {

					return "Canadian";
				
				}
			}else {
				if (nbrosa>nbcanadian)
				return "Rosa";
				else 
					return "Canadian";
			}
			}
		}
				
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Double> c1=new ArrayList<Double>();
		ArrayList <Double> c2=new ArrayList<Double>();
		ArrayList <Double> c3=new ArrayList<Double>();
		ArrayList <Double> c4=new ArrayList<Double>();
		ArrayList <Double> c5=new ArrayList<Double>();
		ArrayList <Double> c6=new ArrayList<Double>();
		ArrayList <Double> c7=new ArrayList<Double>();
		ArrayList <ArrayList <Double>> cres=new ArrayList<ArrayList <Double>>();
		ArrayList<String> r1=new ArrayList<String>();
		ArrayList<String> r2=new ArrayList<String>();
		ArrayList<String> p=new ArrayList<String>();
		ArrayList<String> temp=new ArrayList<String> ();
		temp.add("14");temp.add("10");
		temp.add("1");temp.add("10");
		temp.add("1");temp.add("1");
		temp.add("3");
		knn b=new knn();
		c1.add(11.1);c1.add(21.1);c1.add(11.1);c1.add(11.3);
		c2.add(11.1);c2.add(21.1);c2.add(11.1);c2.add(11.3);
		c3.add(11.1);c3.add(21.1);c3.add(11.1);c3.add(11.3);
		c4.add(11.1);c4.add(21.1);c4.add(11.1);c4.add(11.3);
		c5.add(11.1);c5.add(21.1);c5.add(11.1);c5.add(11.3);
		c6.add(11.1);c6.add(21.1);c6.add(11.1);c6.add(11.3);
		c7.add(11.1);c7.add(21.1);c7.add(11.1);c7.add(11.3);
		cres.add(c1);cres.add(c2);cres.add(c3);cres.add(c4);
		cres.add(c5);cres.add(c6);cres.add(c7);
		r2.add("I11");r2.add("I12");r2.add("I11");r2.add("I13");r2.add("I13");r2.add("I12");r2.add("I11");r2.add("I15");r2.add("I15");
		p.add("Rosa");p.add("Rosa");p.add("Rosa");p.add("Rosa");p.add("Kama");p.add("Kama");p.add("canadian");p.add("canadian");p.add("canadian");
		ArrayList<ArrayList<String>>  res2=new ArrayList<ArrayList<String>>  ();
		res2.add(r2);
		res2.add(r2);
		res2.add(r2);
		res2.add(r2);
		res2.add(r2);
		res2.add(r2);
		res2.add(r2);
		res2.add(p);
		//System.out.println(b.transformer_dataset_fromdescritisation_toINT(res2).get(3));
		//b.calcule_euclidienne(cres,temp);
		
		
		
		/*for(int j=0;j<c.size();j++) 	// retronsformer la list en type String		
			temp.add(String.valueOf(c.get(j)));
		System.out.println(temp);	
		int i=0;
		i=b.remplacer_valeur(temp,(double)11.1);
		// i=b.remplacer_valeur(temp,(double)11.1);
		
		System.out.println(temp+"===========>"+i);
		*/		//System.out.println(c);
		//i=b.remplacer_valeur(temp,(double)11.1);
		System.out.println("calcule Manhattan"+b.calcule_Manhattan(cres,temp));				
		System.out.println("list trier de Manhattan"+b.trier_par_insertion(b.calcule_Manhattan(cres,temp)));
		
		System.out.println("\n"+b.resultat_knn(b.trier_par_insertion(b.calcule_Manhattan(cres,temp)).get(1),p, 3));

		 System.out.println("calcule hamming\n"+b.calcule_hamming(res2, temp));				
		System.out.println("list trier de hamming\n"+
		b.trier_par_insertion(
				b.int_to_double(b.calcule_hamming(res2, temp))).get(0)
				);

		System.out.println("list trier indice de hamming\n"+
				b.trier_par_insertion(
						b.int_to_double(b.calcule_hamming(res2, temp))).get(1)
					);
		System.out.println("****************************************************\n"
				+b.resultat_knn(b.trier_par_insertion(
				b.int_to_double(b.calcule_hamming(res2, temp))).get(1),p, 5));
		System.out.println(p);
		System.out.println("calcule euclidienne"+b.calcule_euclidienne(cres,temp));
		System.out.println("list trier de euclidienne"+b.trier_par_insertion(b.calcule_euclidienne(cres,temp)));
		
		System.out.println("\n"+b.resultat_knn(b.trier_par_insertion(b.calcule_euclidienne(cres,temp)).get(1),p, 3));
	}

}
