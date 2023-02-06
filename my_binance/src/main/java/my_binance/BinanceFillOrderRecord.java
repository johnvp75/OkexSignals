package my_binance;

public class BinanceFillOrderRecord {

	private double price;
	private double qty;
	private double commission;
	private String commissionAsset;
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @return the qty
	 */
	public double getQty() {
		return qty;
	}
	/**
	 * @return the commission
	 */
	public double getCommission() {
		return commission;
	}
	/**
	 * @return the commissionAsset
	 */
	public String getCommissionAsset() {
		return commissionAsset;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(double qty) {
		this.qty = qty;
	}
	/**
	 * @param commission the commission to set
	 */
	public void setCommission(double commission) {
		this.commission = commission;
	}
	/**
	 * @param commissionAsset the commissionAsset to set
	 */
	public void setCommissionAsset(String commissionAsset) {
		this.commissionAsset = commissionAsset;
	}
	
	
	
}
