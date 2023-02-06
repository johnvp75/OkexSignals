package my_binance;

public class BinanceMarginOrder {

			
	private int typeResponse;
	/**
	 * @return the typeResponse
	 */
	public int getTypeResponse() {
		return typeResponse;
	}
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @return the clientOrderId
	 */
	public String getClientOrderId() {
		return clientOrderId;
	}
	/**
	 * @return the transactTime
	 */
	public long getTransactTime() {
		return transactTime;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @return the origQty
	 */
	public double getOrigQty() {
		return origQty;
	}
	/**
	 * @return the executedQty
	 */
	public double getExecutedQty() {
		return executedQty;
	}
	/**
	 * @return the cummulativeQuoteQty
	 */
	public double getCummulativeQuoteQty() {
		return cummulativeQuoteQty;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the timeInForce
	 */
	public String getTimeInForce() {
		return timeInForce;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the side
	 */
	public String getSide() {
		return side;
	}
	/**
	 * @return the marginBuyBorrowAsset
	 */
	public String getMarginBuyBorrowAsset() {
		return marginBuyBorrowAsset;
	}
	/**
	 * @return the marginBuyBorrowAmount
	 */
	public int getMarginBuyBorrowAmount() {
		return marginBuyBorrowAmount;
	}
	/**
	 * @return the isIsolated
	 */
	public boolean isIsolated() {
		return isIsolated;
	}
	/**
	 * @return the fills
	 */
	public BinanceFillOrderRecord[] getFills() {
		return fills;
	}
	/**
	 * @param typeResponse the typeResponse to set
	 */
	public void setTypeResponse(int typeResponse) {
		this.typeResponse = typeResponse;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @param clientOrderId the clientOrderId to set
	 */
	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}
	/**
	 * @param transactTime the transactTime to set
	 */
	public void setTransactTime(long transactTime) {
		this.transactTime = transactTime;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @param origQty the origQty to set
	 */
	public void setOrigQty(double origQty) {
		this.origQty = origQty;
	}
	/**
	 * @param executedQty the executedQty to set
	 */
	public void setExecutedQty(double executedQty) {
		this.executedQty = executedQty;
	}
	/**
	 * @param cummulativeQuoteQty the cummulativeQuoteQty to set
	 */
	public void setCummulativeQuoteQty(double cummulativeQuoteQty) {
		this.cummulativeQuoteQty = cummulativeQuoteQty;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param side the side to set
	 */
	public void setSide(String side) {
		this.side = side;
	}
	/**
	 * @param marginBuyBorrowAsset the marginBuyBorrowAsset to set
	 */
	public void setMarginBuyBorrowAsset(String marginBuyBorrowAsset) {
		this.marginBuyBorrowAsset = marginBuyBorrowAsset;
	}
	/**
	 * @param marginBuyBorrowAmount the marginBuyBorrowAmount to set
	 */
	public void setMarginBuyBorrowAmount(int marginBuyBorrowAmount) {
		this.marginBuyBorrowAmount = marginBuyBorrowAmount;
	}
	/**
	 * @param isIsolated the isIsolated to set
	 */
	public void setIsolated(boolean isIsolated) {
		this.isIsolated = isIsolated;
	}
	/**
	 * @param fills the fills to set
	 */
	public void setFills(BinanceFillOrderRecord[] fills) {
		this.fills = fills;
	}
	private String orderId;
	private String clientOrderId;
	private long transactTime;
	private double price ;
	private double origQty;
	private double executedQty;
	private double cummulativeQuoteQty;
	private String status;
	private String timeInForce;
	private String type;
	private String side;
	private String marginBuyBorrowAsset;
	private int marginBuyBorrowAmount;
	private boolean isIsolated;
	private BinanceFillOrderRecord[] fills; 
	
}
