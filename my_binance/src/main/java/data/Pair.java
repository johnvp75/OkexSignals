package data;

public class Pair {
	private int Id;
	private String name;
	private int precision;
	private String instType;
	private String uly;
	private String instFamily;
	private String baseCcy;
	private String quoteCcy;
	private String settleCcy;
	private double ctVal;
	private int ctMult;
	private int ctValCcy;
	private char optType;
	private double stk;
	private long listTime;
	private long expTime;
	private int lever;
	private String tickSz;
	private int lotSz;
	private int minSz;
	private String ctType;
	private String alias;
	private String state;
	private int maxLmtSz;
	private int maxMktSz;
	private int maxTwapSz;
	private int maxIcebergSz;
	private int maxTriggerSz;
	private int maxStopSz;
	
	
	public Pair(String name) {
		this.name=name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the precision
	 */
	public int getPrecition() {
		return getTickSz().length()-2;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @return the instType
	 */
	public String getInstType() {
		return instType;
	}

	/**
	 * @return the uly
	 */
	public String getUly() {
		return uly;
	}

	/**
	 * @return the instFamily
	 */
	public String getInstFamily() {
		return instFamily;
	}

	/**
	 * @return the baseCcy
	 */
	public String getBaseCcy() {
		return baseCcy;
	}

	/**
	 * @return the quoteCcy
	 */
	public String getQuoteCcy() {
		return quoteCcy;
	}

	/**
	 * @return the settleCcy
	 */
	public String getSettleCcy() {
		return settleCcy;
	}

	/**
	 * @return the ctVal
	 */
	public double getCtVal() {
		return ctVal;
	}

	/**
	 * @return the ctMult
	 */
	public int getCtMult() {
		return ctMult;
	}

	/**
	 * @return the ctValCcy
	 */
	public int getCtValCcy() {
		return ctValCcy;
	}

	/**
	 * @return the optType
	 */
	public char getOptType() {
		return optType;
	}

	/**
	 * @return the stk
	 */
	public double getStk() {
		return stk;
	}

	/**
	 * @return the listTime
	 */
	public long getListTime() {
		return listTime;
	}

	/**
	 * @return the expTime
	 */
	public long getExpTime() {
		return expTime;
	}

	/**
	 * @return the lever
	 */
	public int getLever() {
		return lever;
	}

	/**
	 * @return the tickSz
	 */
	public String getTickSz() {
		return tickSz;
	}

	/**
	 * @return the lotSz
	 */
	public int getLotSz() {
		return lotSz;
	}

	/**
	 * @return the minSz
	 */
	public int getMinSz() {
		return minSz;
	}

	/**
	 * @return the ctType
	 */
	public String getCtType() {
		return ctType;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the maxLmtSz
	 */
	public int getMaxLmtSz() {
		return maxLmtSz;
	}

	/**
	 * @return the maxMktSz
	 */
	public int getMaxMktSz() {
		return maxMktSz;
	}

	/**
	 * @return the maxTwapSz
	 */
	public int getMaxTwapSz() {
		return maxTwapSz;
	}

	/**
	 * @return the maxIcebergSz
	 */
	public int getMaxIcebergSz() {
		return maxIcebergSz;
	}

	/**
	 * @return the maxTriggerSz
	 */
	public int getMaxTriggerSz() {
		return maxTriggerSz;
	}

	/**
	 * @return the maxStopSz
	 */
	public int getMaxStopSz() {
		return maxStopSz;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * @param instType the instType to set
	 */
	public void setInstType(String instType) {
		this.instType = instType;
	}

	/**
	 * @param uly the uly to set
	 */
	public void setUly(String uly) {
		this.uly = uly;
	}

	/**
	 * @param instFamily the instFamily to set
	 */
	public void setInstFamily(String instFamily) {
		this.instFamily = instFamily;
	}

	/**
	 * @param baseCcy the baseCcy to set
	 */
	public void setBaseCcy(String baseCcy) {
		this.baseCcy = baseCcy;
	}

	/**
	 * @param quoteCcy the quoteCcy to set
	 */
	public void setQuoteCcy(String quoteCcy) {
		this.quoteCcy = quoteCcy;
	}

	/**
	 * @param settleCcy the settleCcy to set
	 */
	public void setSettleCcy(String settleCcy) {
		this.settleCcy = settleCcy;
	}

	/**
	 * @param ctVal the ctVal to set
	 */
	public void setCtVal(double ctVal) {
		this.ctVal = ctVal;
	}

	/**
	 * @param ctMult the ctMult to set
	 */
	public void setCtMult(int ctMult) {
		this.ctMult = ctMult;
	}

	/**
	 * @param ctValCcy the ctValCcy to set
	 */
	public void setCtValCcy(int ctValCcy) {
		this.ctValCcy = ctValCcy;
	}

	/**
	 * @param optType the optType to set
	 */
	public void setOptType(char optType) {
		this.optType = optType;
	}

	/**
	 * @param stk the stk to set
	 */
	public void setStk(double stk) {
		this.stk = stk;
	}

	/**
	 * @param listTime the listTime to set
	 */
	public void setListTime(long listTime) {
		this.listTime = listTime;
	}

	/**
	 * @param expTime the expTime to set
	 */
	public void setExpTime(long expTime) {
		this.expTime = expTime;
	}

	/**
	 * @param lever the lever to set
	 */
	public void setLever(int lever) {
		this.lever = lever;
	}

	/**
	 * @param tickSz the tickSz to set
	 */
	public void setTickSz(String tickSz) {
		this.tickSz = tickSz;
	}

	/**
	 * @param lotSz the lotSz to set
	 */
	public void setLotSz(int lotSz) {
		this.lotSz = lotSz;
	}

	/**
	 * @param minSz the minSz to set
	 */
	public void setMinSz(int minSz) {
		this.minSz = minSz;
	}

	/**
	 * @param ctType the ctType to set
	 */
	public void setCtType(String ctType) {
		this.ctType = ctType;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param maxLmtSz the maxLmtSz to set
	 */
	public void setMaxLmtSz(int maxLmtSz) {
		this.maxLmtSz = maxLmtSz;
	}

	/**
	 * @param maxMktSz the maxMktSz to set
	 */
	public void setMaxMktSz(int maxMktSz) {
		this.maxMktSz = maxMktSz;
	}

	/**
	 * @param maxTwapSz the maxTwapSz to set
	 */
	public void setMaxTwapSz(int maxTwapSz) {
		this.maxTwapSz = maxTwapSz;
	}

	/**
	 * @param maxIcebergSz the maxIcebergSz to set
	 */
	public void setMaxIcebergSz(int maxIcebergSz) {
		this.maxIcebergSz = maxIcebergSz;
	}

	/**
	 * @param maxTriggerSz the maxTriggerSz to set
	 */
	public void setMaxTriggerSz(int maxTriggerSz) {
		this.maxTriggerSz = maxTriggerSz;
	}

	/**
	 * @param maxStopSz the maxStopSz to set
	 */
	public void setMaxStopSz(int maxStopSz) {
		this.maxStopSz = maxStopSz;
	}

	/**
	 * @param precition the precition to set
	 */
/*	public void setPrecition() {

		this.precision = getTickSz().length()-2;
	}
	
	*/
	@Override
	public String toString() {
		return getName();
	}

}

