package data;

public class Pair {
	private String name;
	private int precision;
	
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
		return precision;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param precition the precition to set
	 */
	public void setPrecition(int precicion) {
		this.precision = precicion;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
