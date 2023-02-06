package my_binance;

import java.util.LinkedHashMap;

import org.json.JSONArray;

import com.binance.connector.client.exceptions.BinanceConnectorException;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;

import data.Bar;
import data.FiboLevel;
import data.Pair;
import indicators.FiboLevels;
import indicators.NewBB;
import indicators.NewRSI;

public class CheckForEnterPoint {

	   //private static final Logger logger = LoggerFactory.getLogger(GetExchangeInfo.class);

	   	   
	   public CheckForEnterPoint() {
		
	}


	public FiboLevel check(Pair symbol,String interval) {
	    	SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY,PrivateConfig.SECRET_KEY);
	        
	        Market market = client.createMarket();
	        LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object> ();
	        parameters.put("symbol",symbol.getName());
	        parameters.put("interval",interval);
	        parameters.put("limit", 300);
	        
	        String result =null;
	        try {
	        	result = market.klines(parameters);
	        }catch (BinanceConnectorException ex) {
	        	return null;
	        }
//	        System.out.println(result);
	        JSONArray array1 = new JSONArray(result);
	        Bar[] bars=new Bar[300];
	        for(int i=0; i<300; i++) {
	        	bars[i]=new Bar(array1.getJSONArray(i).getDouble(1),array1.getJSONArray(i).getDouble(4),array1.getJSONArray(i).getDouble(3),array1.getJSONArray(i).getDouble(2));
//	        	bars[i].setClosePrice(array1.getJSONArray(i).getDouble(4));
//	        	bars[i].setOpenPrice(array1.getJSONArray(i).getDouble(1));
//	        	bars[i].setMaxPrice(array1.getJSONArray(i).getDouble(2));
//	        	bars[i].setMinPrice(array1.getJSONArray(i).getDouble(3));
	        }
	        NewRSI rsi=new NewRSI(14);
	        double[] repeat=rsi.getRSI(bars, 200);
	        NewBB bb=new NewBB(20,2);
//	        double repeat=rsi.count(arrayClosePrice);
//	        System.out.println(symbol+" RSI: "+repeat[repeat.length-1]+"; "+repeat[repeat.length-2]);
	        if (bars[299].getOpenPrice()>bb.calculate(bars, 0).getUp()&&((repeat[repeat.length-1]<70&&repeat[repeat.length-2]>=70)||(repeat[repeat.length-1]<80&&repeat[repeat.length-2]>=80)||(repeat[repeat.length-1]<90&&repeat[repeat.length-2]>=90))) {
	        	System.out.println(symbol.getName()+" is checked");
	        	FiboLevel fiboValue=FiboLevels.calculate(repeat, bars).addPrice(bars[299].getClosePrice());;
	        	System.out.println(fiboValue.asStringWithParcent(symbol.getPrecition()));
	        	
	        	return fiboValue;
	        }else {
	        	return null;
	        }
	        
	   }
  

}
