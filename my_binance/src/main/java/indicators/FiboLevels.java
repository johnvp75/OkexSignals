package indicators;

import data.Bar;
import data.FiboLevel;

public final class FiboLevels {
	
//	private static int startBar;
//	private static Bar minBar;
//	private static Bar maxBar;
	
	public FiboLevels () {
		
	}
	
	public static FiboLevel calculate(double[] rsiValues,Bar[] values) {
		Bar maxBar=values[values.length-2];
		int lastBar=rsiValues.length-1;
		for(int i=rsiValues.length-3;i>=0;i--) {
			lastBar=i;
			if (rsiValues[i]>=70&maxBar.getMaxPrice()<values[values.length-rsiValues.length+i].getMaxPrice())
				maxBar=values[values.length-rsiValues.length+i];
			if (rsiValues[i]<70)
				break;
		}
		int firstBar=lastBar;
		for(int i=lastBar-1;i>=0;i--) {
			firstBar=i;
			if (rsiValues[i]>=70)
				break;
		}
		Bar minBar=values[values.length-rsiValues.length+lastBar];
		for (int i = lastBar-1; i >=firstBar ; i--) {
			if (minBar.getMinPrice()>values[values.length-rsiValues.length+i].getMinPrice())
				minBar=values[values.length-rsiValues.length+i];
		}
		
		
		return new FiboLevel(minBar.getMinPrice(), maxBar.getMaxPrice());
	}

}
