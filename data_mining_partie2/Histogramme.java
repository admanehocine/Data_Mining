package data_mining;



import java.text.DecimalFormat;
import java.util.ArrayList;

public class Histogramme {
	private int nbInstances,nbInterval;
	private double amplitudeInt,max,min;
	private ArrayList<Instance> ListeIntervalles ;
	final double UNITE = 0.1;
	private boolean HistReady = false;
	
	public Histogramme(int nbInstances, double max, double min) {
		super();
		this.nbInstances = nbInstances;
		this.max = max;
		this.min = min;
		
	}

	
	public void CalculNbInterval () {
		
		nbInterval = (int) Math.floor(1 + (10/3)*Math.log10(nbInstances));
		
	}
	
	public int getNbInterval() {
		return nbInterval;
	}


	public void setNbInterval(int nbInterval) {
		this.nbInterval = nbInterval;
	}


	public void CalculAmpInterval () {
		double AmplitudeG;
		//DecimalFormat df = new DecimalFormat ("0.0#") ;
		
		AmplitudeG = max - min + UNITE;
		AmplitudeG /= nbInterval;
		amplitudeInt = Math.round(AmplitudeG*100);
		amplitudeInt /= 100;
		
	}
	 
	public void GenererIntervalles (){
		//DecimalFormat df = new DecimalFormat ("#.##") ;
		
		ArrayList<Instance> temp = new ArrayList<Instance>(nbInterval);
		double ind = min;
		Instance in ;
		 
		
		for(int i = 0 ; i < nbInterval ; i++) {
			in = new Instance(ind, ind +  amplitudeInt, 0);
			temp.add(in);
			
			ind += amplitudeInt;
			ind *= 100;
			ind = Math.round(ind);
			ind /= 100;
			System.out.println(ind);
		}
		HistReady = true ;
		ListeIntervalles = temp;
			
	}
	
	public void CalculFrequencesIntervalles ( ArrayList<Double> Liste) throws Exception{
		
		if(HistReady) {
			
		    for(int i = 0 ; i < Liste.size() ; i++) {
		    	
		    	for(int j = 0; j < ListeIntervalles.size(); j++) {
		    		
		    		if(Liste.get(i) >= ListeIntervalles.get(j).getMin() && Liste.get(i) < ListeIntervalles.get(j).getMax()) {
		    			
		    			ListeIntervalles.set(j, new Instance(ListeIntervalles.get(j).getMin(), ListeIntervalles.get(j).getMax(), ListeIntervalles.get(j).getFreq() + 1));
		    		
		    		}
		    	}
		    }
		    
		} else {
			throw new Exception();
		}
		
	}


	public double getMax() {
		return max;
	}


	public void setMax(double max) {
		this.max = max;
	}


	public double getMin() {
		return min;
	}


	public void setMin(double min) {
		this.min = min;
	}


	public ArrayList<Instance> getListeIntervalles() {
		return ListeIntervalles;
	}


	public void setListeIntervalles(ArrayList<Instance> listeIntervalles) {
		ListeIntervalles = listeIntervalles;
	}
	
	
	

}
