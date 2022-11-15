package data_mining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class naive_baysien {
		
	public static  ArrayList<Float>  proba_class( ArrayList<String> c) {

		ArrayList<Float> tab_occ_class =new ArrayList<Float>(); 
		tab_occ_class.add( (float)Collections.frequency(c, "Rosa")/(float)c.size());
		tab_occ_class.add(  (float)Collections.frequency(c, "Kama")/(float)c.size());
		tab_occ_class.add( (float)Collections.frequency(c, "Canadian")/(float)c.size());
		return tab_occ_class;
	}

	public static ArrayList<ArrayList<String>> recuperer_selon_class(ArrayList<String> c,ArrayList<String> p,String extrait) {//extrait=I1,I2....I7
		ArrayList<String> rosa=new ArrayList<String> ();
		ArrayList<String> kama=new ArrayList<String> ();
		ArrayList<String> canadian=new ArrayList<String> ();
		ArrayList<ArrayList<String>> resultat_class=new ArrayList<ArrayList<String>> ();
		for (int i=0;i<p.size();i++) {
			if (c.get(i).equals("Kama")) {
				kama.add(p.get(i));
			}
			
			if (c.get(i).equals("Rosa")) {
				rosa.add(p.get(i));
			}
			if (c.get(i).equals("Canadian")) {
				canadian.add(p.get(i));
			}
		}
		ArrayList<Integer> kamatrie=new ArrayList<Integer>  ();
		ArrayList<Integer> rosatrie=new ArrayList<Integer>  ();
		ArrayList<Integer> canadiantrie=new ArrayList<Integer>  ();
		for(int ii=0;ii<kama.size();ii++) {		
		kamatrie.add(Integer.parseInt(kama.get(ii).substring(2,kama.get(ii).length())));
		}
		for(int ii=0;ii<rosa.size();ii++) {		
			
		rosatrie.add(Integer.parseInt(rosa.get(ii).substring(2,rosa.get(ii).length())));
		}
		for(int ii=0;ii<canadian.size();ii++) {		
			
		canadiantrie.add(Integer.parseInt(canadian.get(ii).substring(2,canadian.get(ii).length())));
		}
		Collections.sort(kamatrie);	Collections.sort(rosatrie);	Collections.sort(canadiantrie);//trier les listes en integer
		for(int t=0;t<kama.size();t++) {//reconstruire les lists triet
			kama.set(t, extrait+kamatrie.get(t));
	 	}
		for(int t=0;t<rosa.size();t++) {//reconstruire les lists triet
			rosa.set(t, extrait+rosatrie.get(t));
		}
		for(int t=0;t<canadian.size();t++) {//reconstruire les lists triet
			canadian.set(t, extrait+canadiantrie.get(t));
		}
		
		/*ajouter a la list de list */
		
		resultat_class.add(kama);
		resultat_class.add(rosa);
		resultat_class.add(canadian);
		
		return resultat_class;
	}

	
	
	public static ArrayList<ArrayList<Float>> proba_items_selon_class( ArrayList<ArrayList<String>> rsc,int k) {
		ArrayList<ArrayList<Float>> proba_resultat_class=new ArrayList<ArrayList<Float>> ();
		ArrayList<Float> res=new ArrayList<Float>();
		
		ArrayList<String> temp=new ArrayList<String>();
		for(int i=0;i<3;i++) {//parcourir la list de list de proba_items
		//	System.out.println("==>"+rsc.get(i));
				res=new ArrayList<Float>();
				for(int kk=0;kk<k;kk++) {//initilaiser le vecteur de sortie pour I1K.....
					res.add((float)0);
					
				}
				temp=new ArrayList<String>();
				for(int f=0;f<rsc.get(i).size();f++) {
					if(temp.contains(rsc.get(i).get(f))==false) {	
				
						//System.out.println("*********>"+rsc.get(i).get(f).substring(2,rsc.get(i).get(f).length()));
				 
						res.set(Integer.parseInt(rsc.get(i).get(f).substring(2,rsc.get(i).get(f).length()))-1,
				  (float)Collections.frequency(rsc.get(i), rsc.get(i).get(f))/(float)rsc.get(i).size());
				  //ajouter a temp si il est utiliser
				  
					 
				     temp.add(rsc.get(i).get(f));  } 
				}
			
				proba_resultat_class.add(res);
				
			
		}	
		
		
		
		return proba_resultat_class;
	}
	
	
	public static String calcule_final_proba(
	ArrayList<ArrayList<Float>> resa,
	ArrayList<ArrayList<Float>> resp,
	ArrayList<ArrayList<Float>> resc,
	ArrayList<ArrayList<Float>> reslok,
	ArrayList<ArrayList<Float>> reswok,
	ArrayList<ArrayList<Float>> resac,
	ArrayList<ArrayList<Float>> reslokg,
	ArrayList<String> entrer,ArrayList<Float> racine){
		
	//ArrayList<Float> res2 =new ArrayList<Float>();
	ArrayList<String> subentrer =new ArrayList<String>();
	
	for(int i=0; i<entrer.size();i++) {
		subentrer.add(entrer.get(i).substring(2,entrer.get(i).length()));
					
	}
	
	float pkama=racine.get(0)*resa.get(0).get(Integer.parseInt(subentrer.get(0))-1)*
			resp.get(0).get(Integer.parseInt(subentrer.get(1))-1)*resc.get(0).get(Integer.parseInt(subentrer.get(2))-1)*
			reslok.get(0).get(Integer.parseInt(subentrer.get(3))-1)*reswok.get(0).get(Integer.parseInt(subentrer.get(4))-1)*
			resac.get(0).get(Integer.parseInt(subentrer.get(5))-1)*reslokg.get(0).get(Integer.parseInt(subentrer.get(6))-1);
	
	float prosa=racine.get(1)*resa.get(1).get(Integer.parseInt(subentrer.get(0))-1)*
			resp.get(1).get(Integer.parseInt(subentrer.get(1))-1)*resc.get(1).get(Integer.parseInt(subentrer.get(2))-1)*
			reslok.get(1).get(Integer.parseInt(subentrer.get(3))-1)*reswok.get(1).get(Integer.parseInt(subentrer.get(4))-1)*
			resac.get(1).get(Integer.parseInt(subentrer.get(5))-1)*reslokg.get(1).get(Integer.parseInt(subentrer.get(6))-1);
	
	float pcanadian=racine.get(2)*resa.get(2).get(Integer.parseInt(subentrer.get(0))-1)*
			resp.get(2).get(Integer.parseInt(subentrer.get(1))-1)*resc.get(2).get(Integer.parseInt(subentrer.get(2))-1)*
			reslok.get(2).get(Integer.parseInt(subentrer.get(3))-1)*reswok.get(2).get(Integer.parseInt(subentrer.get(4))-1)*
			resac.get(2).get(Integer.parseInt(subentrer.get(5))-1)*reslokg.get(2).get(Integer.parseInt(subentrer.get(6))-1);
	//System.out.println("la probabilité sont : kama="+pkama+" | rosa ="+prosa+"| canadian="+pcanadian);
	

	if(pkama ==prosa && prosa==pcanadian ) return "aucun";
	else {
	
	if(pkama >prosa) {
		if(pkama>pcanadian) {
			return "Kama";
		}else {

			return "Canadian";
		
		}
	}else {
		if (prosa>pcanadian)
		return "Rosa";
		else 
			return "Canadian";
	}
	}
	
	
	}
	
	
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
	 ArrayList<Double>
          A = new ArrayList<>(),
          P = new ArrayList<>(),
          C = new ArrayList<>(),
          LoK = new ArrayList<>(),
          WoK = new ArrayList<>(),
          AC = new ArrayList<>(),
          LoKG = new ArrayList<>();
		  ArrayList<String> Class = new ArrayList<>();
		  ArrayList<String> c1 = new ArrayList<>();
		  ArrayList<String> c2 = new ArrayList<>();
		  ArrayList<String> c3 = new ArrayList<>();
		  ArrayList<String> c4= new ArrayList<>();
		  ArrayList<String> c5 = new ArrayList<>();
		  ArrayList<String> c6 = new ArrayList<>();
		  ArrayList<String> c7 = new ArrayList<>();
		
		  BufferedReader br = new BufferedReader(new FileReader("seeds.txt"));
	        String line;
	        String[] temp;

	        while ((line = br.readLine()) != null) {
	            temp = line.split("\t+");
	            A.add(Double.valueOf(temp[0]));
	            P.add(Double.valueOf(temp[1]));
	            C.add(Double.valueOf(temp[2]));
	            LoK.add(Double.valueOf(temp[3]));
	            WoK.add(Double.valueOf(temp[4]));
	            AC.add(Double.valueOf(temp[5]));
	            LoKG.add(Double.valueOf(temp[6]));
	            switch (temp[7]) {
	                case "1":
	                    Class.add("Kama");
	                    break;
	                case "2":
	                    Class.add("Rosa");
	                    break;
	                case "3":
	                    Class.add("Canadian");
	                    break;
	            }
	        }
	        IHM im2=new IHM();
			//IHM im=new IHM();
			System.out.println(Class);
			//System.out.println("resultat de discrete"+im2.Discrete_Amplitude(A, 1, 3, 0.001));
		// TODO Auto-generated method stub
		ArrayList<String> p=new ArrayList<String>();
		ArrayList<String> en=new ArrayList<String>();
		ArrayList<Float> res=new ArrayList<Float>();
		ArrayList<Float> proba=new ArrayList<Float>();
		ArrayList<String> r1=new ArrayList<String>();
		ArrayList<String> r2=new ArrayList<String>();
		r1.add("I12");r1.add("I12");r1.add("I15");r1.add("I11");r1.add("I14");r1.add("I13");r1.add("I12");
		r2.add("I11");r2.add("I12");r2.add("I11");r2.add("I13");r2.add("I13");r2.add("I12");r2.add("I11");r2.add("I12");r2.add("I12");
		p.add("Rosa");p.add("Rosa");p.add("Rosa");p.add("Kama");p.add("Kama");p.add("Kama");p.add("canadian");p.add("canadian");p.add("canadian");
		//System.out.println( (float)Collections.frequency(p, "Rosa")/(float)19);
		naive_baysien m=new naive_baysien();
		
		//ArrayList<ArrayList<Float>>  res2=new ArrayList<ArrayList<Float>>  ();
		
		//res2.addAll(m.proba_items_selon_class(recuperer_selon_class(Class, im2.DiscreteAmplitude(A, 1, 3, 0.001),"I1"),3));
		//for(int i=0;i<res2.size();i++) {
			//System.out.println(i+"===>>>>>"+res2.get(i));}
		System.out.println("\n A " +"\n P" 
				+"\n c" +"\n lok"+ "\n wok" 
				+"\n ac" +"\n lokg" );
		c1.addAll(im2.DiscreteAmplitude(A, 1, 5, 0.001));
		
		en.add(c1.get(0));
		System.out.println("\n en====>"+en+"c1==A==>"+c1);
		c1.remove(0);
		c2.addAll(im2.DiscreteAmplitude(P, 2, 5, 0.001));
		en.add(c2.get(0));
		c2.remove(0);
		c3.addAll(im2.DiscreteAmplitude(C, 3, 5, 0.001));
		en.add(c3.get(0));
		c3.remove(0);
		c4.addAll(im2.DiscreteAmplitude(LoK, 4,5, 0.001));
		en.add(c4.get(0));
		c4.remove(0);
		c5.addAll(im2.DiscreteAmplitude(WoK, 5, 5, 0.001));
		en.add(c5.get(0));
		c5.remove(0);
		c6.addAll(im2.DiscreteAmplitude(AC, 6, 5, 0.001));
		en.add(c6.get(0));
		c6.remove(0);
		c7.addAll(im2.DiscreteAmplitude(LoKG, 7,5, 0.001));
		en.add(c7.get(0));
		c7.remove(0);
		System.out.println("instance 1===>"+en);
		System.out.println("\n avant apprentissage class pour instance 1===>"+Class.get(0));
		Class.remove(0);
		res.addAll(m.proba_class(Class));
		for(int i=0;i<res.size();i++) {
			System.out.println(i+"===>"+res.get(i));
		}
		System.out.println("apres apprentissage class pour instance 1 ==> \n"+
		m.calcule_final_proba(
				m.proba_items_selon_class(recuperer_selon_class(Class,c1,"I1"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c2,"I2"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c3,"I3"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c4,"I4"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c5,"I5"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c6,"I6"),5),
				m.proba_items_selon_class(recuperer_selon_class(Class,c7,"I7"),5),
				en, res));
 
		
	}

}
