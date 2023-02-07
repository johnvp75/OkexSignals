package data;

import org.json.JSONArray;

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
//	@Column
	private long openTime;
	
	public Bar() {
		
	}
	
	public Bar(JSONArray bar) {
		setOpenTime(bar.getLong(0));
		setOpenPrice(bar.getDouble(1));
		setMaxPrice(bar.getDouble(2));
		setMinPrice(bar.getDouble(3));
		setClosePrice(bar.getDouble(4));
		setVolume(bar.getDouble(5));
		setVolumeBaseCurrency(bar.getDouble(6));
		setVolumeQuoteCurrency(bar.getDouble(7));
		
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

	/**
	 * @return the pair
	 */
	public Pair getPair() {
		return pair;
	}

	/**
	 * @return the volume
	 */
	public double getVolume() {
		return Volume;
	}

	/**
	 * @return the volumeBaseCurrency
	 */
	public double getVolumeBaseCurrency() {
		return VolumeBaseCurrency;
	}

	/**
	 * @return the volumeQuoteCurrency
	 */
	public double getVolumeQuoteCurrency() {
		return VolumeQuoteCurrency;
	}

	/**
	 * @return the openTime
	 */
	public long getOpenTime() {
		return openTime;
	}

	/**
	 * @param pair the pair to set
	 */
	public void setPair(Pair pair) {
		this.pair = pair;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		Volume = volume;
	}

	/**
	 * @param volumeBaseCurrency the volumeBaseCurrency to set
	 */
	public void setVolumeBaseCurrency(double volumeBaseCurrency) {
		VolumeBaseCurrency = volumeBaseCurrency;
	}

	/**
	 * @param volumeQuoteCurrency the volumeQuoteCurrency to set
	 */
	public void setVolumeQuoteCurrency(double volumeQuoteCurrency) {
		VolumeQuoteCurrency = volumeQuoteCurrency;
	}

	/**
	 * @param openTime the openTime to set
	 */
	public void setOpenTime(long openTime) {
		this.openTime = openTime;
	}

}
