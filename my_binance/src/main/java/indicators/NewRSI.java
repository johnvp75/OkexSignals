package indicators;

import data.Bar;

public class NewRSI {

	private int period;
	private Bar[] data;
	
	public NewRSI (int period) {
		this.period=period;
	}
	
	public double[] getRSI(Bar[] inputData, int outputLength) {
		this.data=inputData;
		double[] costUp=new double[data.length-1];
		double[] costDown=new double[data.length-1];
		for (int i=1;i<data.length;i++) {
//			System.out.println(i);
			if (data[i].getClosePrice()>data[i-1].getClosePrice()) {
				costUp[i-1]=data[i].getClosePrice()-data[i-1].getClosePrice();
				costDown[i-1]=0.0;
			}else {
				costUp[i-1]=0.0;
				costDown[i-1]=data[i-1].getClosePrice()-data[i].getClosePrice();
			}
		}
		double[] RSIMass=new double[data.length-period];
		double avarageUp=0.0;
		double avarageDown=0.0;
		for (int i=0;i<period;i++) {
			avarageUp=avarageUp+costUp[i]/period;
			avarageDown=avarageDown+costDown[i]/period;
		}
		for (int i=0;i<RSIMass.length;i++) {
			RSIMass[i]=100-(100/(1+avarageUp/avarageDown));
			if (i+1<RSIMass.length) {
				avarageUp=(avarageUp*(period-1)+costUp[period+i])/period;
				avarageDown=(avarageDown*(period-1)+costDown[period+i])/period;
			}
		}
		double[] repeat=new double[outputLength];
		for (int i=0;i<outputLength;i++) {
			repeat[i]=RSIMass[RSIMass.length-outputLength+i];
		}
		return repeat;
		
	}
}

