package data;

//@Entity
//@Table (name = "Bars")
public class Bar {
//	@Id
//	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "Pair_id")
	private Pair pair;
//	@Column
	private double openPrice;
//	@Column
	private double closePrice;
//	@Column
	private double minPrice;
//	@Column
	private double maxPrice;
//	@Column
	private double Volume;
//	@Column
	private double VolumeBaseCurrency;
//	@Column
	private double VolumeQuoteCurrency;
	
	public Bar() {
		
	}
	
	
	
	
	
	public Bar(double openPrice, double closePrice, double minPrice, double maxPrice) {
		super();
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
	// first-Open bar last close bar
	public Bar(Bar[] barArray) {
		super();
		this.openPrice =barArray[0].getOpenPrice();
		this.closePrice =barArray[0].getClosePrice();
		this.minPrice =barArray[0].getMinPrice();
		this.maxPrice =barArray[0].getMaxPrice();
		for (int i = 1; i < barArray.length; i++) {
			if (this.maxPrice<barArray[i].getMaxPrice())
				this.maxPrice=barArray[i].getMaxPrice();
			if (this.minPrice<barArray[i].getMinPrice())
				this.minPrice=barArray[i].getMinPrice();
			this.closePrice=barArray[i].getClosePrice();

		}
	}
	/**
	 * @return the openPrice
	 */
	public double getOpenPrice() {
		return openPrice;
	}
	/**
	 * @return the clisePrice
	 */
	public double getClosePrice() {
		return closePrice;
	}
	/**
	 * @return the minPrice
	 */
	public double getMinPrice() {
		return minPrice;
	}
	/**
	 * @return the maxPrice
	 */
	public double getMaxPrice() {
		return maxPrice;
	}
	/**
	 * @param openPrice the openPrice to set
	 */
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	/**
	 * @param clisePrice the clisePrice to set
	 */
	public void setClosePrice(double clisePrice) {
		this.closePrice = clisePrice;
	}
	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
