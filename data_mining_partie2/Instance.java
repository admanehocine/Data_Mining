package data_mining;



public class Instance {
	private Double min ,max;
	private int freq;
	
	public Instance(Double min, Double max, int freq) {
		super();
		this.min = min;
		this.max = max;
		this.freq = freq;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	
	

}
