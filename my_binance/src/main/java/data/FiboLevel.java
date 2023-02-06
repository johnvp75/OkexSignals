package data;

public class FiboLevel {
	
	private double level1;
	private double level0786;
	private double level0618;
	private double level05;
	private double level0382;
	private double level0236;
	private double level0;
	private double currentPrice;
	
	
	public FiboLevel(double minValue,double maxValue) {
		setLevel0(maxValue);
		setLevel1(minValue);
		setLevel0236(maxValue-(maxValue-minValue)*0.236);
		setLevel0382(maxValue-(maxValue-minValue)*0.382);
		setLevel05(maxValue-(maxValue-minValue)*0.5);
		setLevel0618(maxValue-(maxValue-minValue)*0.618);
		setLevel0786(maxValue-(maxValue-minValue)*0.786);
		
	}
	
	public FiboLevel addPrice(double price) {
		currentPrice=price;
		return this;
		
	}
	
	public String asStringShort(int precision) {
		String format="%,."+precision+"f";
		return "FiboLevel 0.5: "+String.format(format, getLevel05())+"; "+"FiboLevel 0.618: "+String.format(format, getLevel0618());
	}

	public String asStringWithParcent(int precision) {
		String format="%,."+precision+"f";
		return "FiboLevel 0.5: "+String.format(format, getLevel05())+"; "+String.format("%,.2f", (1-getLevel05()/currentPrice)*100)+"% ; "+"FiboLevel 0.618: "+String.format(format, getLevel0618())+"; "+String.format("%,.2f", (1-getLevel0618()/currentPrice)*100)+"%";
	}

	/**
	 * @return the level1
	 */
	public double getLevel1() {
		return level1;
	}
	/**
	 * @return the level0786
	 */
	public double getLevel0786() {
		return level0786;
	}
	/**
	 * @return the level0618
	 */
	public double getLevel0618() {
		return level0618;
	}
	/**
	 * @return the level05
	 */
	public double getLevel05() {
		return level05;
	}
	/**
	 * @return the level0382
	 */
	public double getLevel0382() {
		return level0382;
	}
	/**
	 * @return the level0236
	 */
	public double getLevel0236() {
		return level0236;
	}
	/**
	 * @return the level0
	 */
	public double getLevel0() {
		return level0;
	}
	/**
	 * @param level1 the level1 to set
	 */
	public void setLevel1(double level1) {
		this.level1 = level1;
	}
	/**
	 * @param level0786 the level0786 to set
	 */
	public void setLevel0786(double level0786) {
		this.level0786 = level0786;
	}
	/**
	 * @param level0618 the level0618 to set
	 */
	public void setLevel0618(double level0618) {
		this.level0618 = level0618;
	}
	/**
	 * @param level05 the level05 to set
	 */
	public void setLevel05(double level05) {
		this.level05 = level05;
	}
	/**
	 * @param level0382 the level0382 to set
	 */
	public void setLevel0382(double level0382) {
		this.level0382 = level0382;
	}
	/**
	 * @param level0236 the level0236 to set
	 */
	public void setLevel0236(double level0236) {
		this.level0236 = level0236;
	}
	/**
	 * @param level0 the level0 to set
	 */
	public void setLevel0(double level0) {
		this.level0 = level0;
	}
	
	
	

}

