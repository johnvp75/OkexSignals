package my_okx;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import data.Bar;
import data.CurrentBB;
import data.FiboLevel;
import data.Pair;
import indicators.FiboLevels;
import indicators.NewBB;
import indicators.NewRSI;

public class CheckForEnterPointOkex {

	   //private static final Logger logger = LoggerFactory.getLogger(GetExchangeInfo.class);

	   	   
	   public CheckForEnterPointOkex() {
		
	}


	public FiboLevel check(Pair symbol,String interval) {
//	        GetDataFromOkex market = new GetDataFromOkex();
	        Map<String,String> parameters = new HashMap<String,String> ();
	        parameters.put("instId",symbol.getName());
	        parameters.put("bar",interval);
	        parameters.put("limit", "300");
	        

	        
	        String result = GetDataFromOkex.getPublicMarketData("candles", parameters);
	        if (result==null)
	        	return null;
	        
//	        System.out.println(result);
	        JSONArray array1 = new JSONObject(result).getJSONArray("data");
	        if (array1.length()==0 || array1.length()<299) {
	        	System.out.println("Length of array is "+array1.length()+" for "+symbol.getName());
	        	System.out.println("Server result is: "+result);
	        	return null;
	        }
	        Bar[] bars=new Bar[300];
//	        double[] arrayClosePrice= new double[200];
//	        double[] arrayOpenPrice= new double[10];
	        for(int i=0; i<300; i++) {
//	        	bars[299-i]=new Bar(array1.getJSONArray(i).getDouble(1),array1.getJSONArray(i).getDouble(4),array1.getJSONArray(i).getDouble(3),array1.getJSONArray(i).getDouble(2));
	        	bars[299-i]=new Bar(array1.getJSONArray(i));
	        }
	        NewRSI rsi=new NewRSI(14);
	        double[] repeat=rsi.getRSI(bars, 200);
	        NewBB bb=new NewBB(20,2);
//	        double repeat=rsi.count(arrayClosePrice);
	        CurrentBB bbValue=bb.calculate(bars, 0);
//	        System.out.println(symbol+" RSI: "+repeat[1]);
//	        System.out.println(symbol+" BB: "+bbValue.getUp()+" ; "+bbValue.getCentral()+" ; "+bbValue.getDown());
//	        System.out.println(symbol+" RSI: "+repeat[repeat.length-1]+"; "+repeat[repeat.length-2]);
	        
	        if (bars[299].getOpenPrice()>bb.calculate(bars, 0).getUp()&&((repeat[repeat.length-1]<70&&repeat[repeat.length-2]>=70)||(repeat[repeat.length-1]<80&&repeat[repeat.length-2]>=80)||(repeat[repeat.length-1]<90&&repeat[repeat.length-2]>=90))) {
	        	return FiboLevels.calculate(repeat, bars).addPrice(bars[299].getClosePrice());
	        }else {
	        	return null;
	        }
	        
	   }
  

}
