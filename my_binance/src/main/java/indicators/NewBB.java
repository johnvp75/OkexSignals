package indicators;

import data.Bar;
import data.CurrentBB;

public class NewBB {

	private int length;
	private int mult;

	
	public NewBB (int length,int mult) {
		this.length=length;
		this.mult=mult;
	}
	
	public CurrentBB calculate(Bar[] inputData, int shift) {
		double avarageValue=0.0;
		for (int i=inputData.length-1-shift;i>inputData.length-1-length-shift;i--) {
			avarageValue=avarageValue+inputData[i].getClosePrice()/length;
		}
		double stdev=0.0;
		for (int i=inputData.length-1-shift;i>inputData.length-1-length-shift;i--) {
			stdev=stdev+Math.pow(inputData[i].getClosePrice()-avarageValue,2)/length;
		}
		stdev=Math.sqrt(stdev);
		return new CurrentBB(avarageValue, avarageValue+stdev*mult, avarageValue-stdev*mult);
	}
	
}
