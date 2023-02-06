package indicators;

public class RSI {

	private int period;
	private double[] data;
	
	public RSI (int period) {
		this.period=period;
	}
	
	public double[] getRSI(double[] inputData, int outputLength) {
		this.data=inputData;
		double[] costUp=new double[data.length-1];
		double[] costDown=new double[data.length-1];
		for (int i=1;i<data.length;i++) {
			if (data[i]>data[i-1]) {
				costUp[i-1]=data[i]-data[i-1];
				costDown[i-1]=0.0;
			}else {
				costUp[i-1]=0.0;
				costDown[i-1]=data[i-1]-data[i];
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
			repeat[i]=RSIMass[RSIMass.length-1-i];
		}
		return repeat;
		
	}
}

