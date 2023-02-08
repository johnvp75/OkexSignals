package data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;
@Entity
@Table(name = "Pairs")
public class Pair {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String name;
	
    @OneToMany(mappedBy = "pair", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bar> bars;	
	
//	private int precision;
	
	@Column
	private String instType;
	
	@Column
	private String uly;
	
	@Column
	private String instFamily;
	
	@Column
	private String baseCcy;
	
	@Column
	private String quoteCcy;
	
	@Column
	private String settleCcy;
	
	@Column
	private double ctVal;
	
	@Column
	private int ctMult;
	
	@Column
	private String ctValCcy;
	
	@Column
	private String optType;
	
	@Column
	private String stk;
	
	@Column
	private long listTime;
	
	@Column
	private long expTime;
	
	@Column
	private int lever;
	
	@Column
	private String tickSz;
	
	@Column
	private int lotSz;
	
	@Column
	private int minSz;
	
	@Column
	private String ctType;
	
	@Column
	private String alias;
	
	@Column
	private String state;
	
	@Column
	private long maxLmtSz;
	
	@Column
	private int maxMktSz;
	
	@Column
	private long maxTwapSz;
	
	@Column
	private long maxIcebergSz;
	
	@Column
	private long maxTriggerSz;
	
	@Column
	private int maxStopSz;
	
	public Pair() {
		
	}
	
	public Pair(String name) {
		this.name=name;
	}

	public Pair(JSONObject pair) {
		
		setInstType(pair.getString("instType"));
		setName(pair.getString("instId"));
		setUly(pair.getString("uly"));
		setInstFamily(pair.getString("instFamily"));
		setBaseCcy(pair.getString("baseCcy"));
		setQuoteCcy(pair.getString("quoteCcy"));
		setSettleCcy(pair.getString("settleCcy"));
		setCtVal(pair.getDouble("ctVal"));
		setCtMult(pair.getInt("ctMult"));
		setCtValCcy(pair.getString("ctValCcy"));
		setOptType(pair.getString("optType"));
		setStk(pair.getString("stk"));
		setListTime(pair.getLong("listTime"));
//		if(pair.getString("expTime").isEmpty())
//			pair.;
		setExpTime(pair.optLong("expTime"));
		setLever(pair.getInt("lever"));
		setTickSz(pair.getString("tickSz"));
		setLotSz(pair.getInt("lotSz"));
		setMinSz(pair.getInt("minSz"));
		setCtType(pair.getString("ctType"));
		setAlias(pair.getString("alias"));
		setState(pair.getString("state"));
		setMaxLmtSz(pair.getLong("maxLmtSz"));
		setMaxMktSz(pair.getInt("maxMktSz"));
		setMaxTwapSz(pair.getLong("maxTwapSz"));
		setMaxIcebergSz(pair.getLong("maxIcebergSz"));
		setMaxTriggerSz(pair.getLong("maxTriggerSz"));
		setMaxStopSz(pair.getInt("maxStopSz"));
		
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
	public int getPrecision() {
		return getTickSz().length()-2;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	public String getCtValCcy() {
		return ctValCcy;
	}

	/**
	 * @return the optType
	 */
	public String getOptType() {
		return optType;
	}

	/**
	 * @return the stk
	 */
	public String getStk() {
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
	public long getMaxLmtSz() {
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
	public long getMaxTwapSz() {
		return maxTwapSz;
	}

	/**
	 * @return the maxIcebergSz
	 */
	public long getMaxIcebergSz() {
		return maxIcebergSz;
	}

	/**
	 * @return the maxTriggerSz
	 */
	public long getMaxTriggerSz() {
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
	public void setCtValCcy(String ctValCcy) {
		this.ctValCcy = ctValCcy;
	}

	/**
	 * @param optType the optType to set
	 */
	public void setOptType(String optType) {
		this.optType = optType;
	}

	/**
	 * @param stk the stk to set
	 */
	public void setStk(String stk) {
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
	public void setMaxLmtSz(long maxLmtSz) {
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
	public void setMaxTwapSz(long maxTwapSz) {
		this.maxTwapSz = maxTwapSz;
	}

	/**
	 * @param maxIcebergSz the maxIcebergSz to set
	 */
	public void setMaxIcebergSz(long maxIcebergSz) {
		this.maxIcebergSz = maxIcebergSz;
	}

	/**
	 * @param maxTriggerSz the maxTriggerSz to set
	 */
	public void setMaxTriggerSz(long maxTriggerSz) {
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

