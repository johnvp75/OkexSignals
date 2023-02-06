package my_binance;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.json.JSONArray;

import com.binance.connector.client.exceptions.BinanceConnectorException;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;

import data.Pair;

public class CheckForExtreameGrowup {
	private String interval;
	private ArrayList<String> tempListOfSymbols;
	
	public CheckForExtreameGrowup(String interval) {
		this.interval=interval;
	}
	
	public String check(ArrayList<Pair> stringOfSymbols,double percentOfGrowup) {

		SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY,PrivateConfig.SECRET_KEY);
        tempListOfSymbols=new ArrayList<String>();
        for (Pair pair : stringOfSymbols) {
			tempListOfSymbols.add(pair.getName());
		}
//        tempListOfSymbols=stringOfSymbols;
        Market market = client.createMarket();
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object> ();
        String otvet="";
        String result;
        JSONArray response;
    	String symbol; 
    	double openPrice;
    	double highPrice;
    	ArrayList<String> partOfSymbols=new ArrayList<String>();
    	
        
        for (int j=0;tempListOfSymbols.size()>0;j++) {
        	partOfSymbols.clear();
        	for (int k=0; k<100&&tempListOfSymbols.size()>0;k++) {
        		partOfSymbols.add(tempListOfSymbols.remove(0));
        	}
        	System.out.println(partOfSymbols.toString());
        	parameters = new LinkedHashMap<String,Object> ();
        	parameters.put("symbols",partOfSymbols);
        	parameters.put("windowSize",interval);
        	parameters.put("type", "MINI");
        
        	try {
        		result = market.ticker(parameters);
        	}catch (BinanceConnectorException ex) {
        		return null;
            }
        	response=new JSONArray(result);

        	for (int i=0;i<response.length();i++) {
        		symbol=response.getJSONObject(i).getString("symbol");
        		openPrice=response.getJSONObject(i).getDouble("openPrice");
        		highPrice=response.getJSONObject(i).getDouble("highPrice");
        		if (highPrice/openPrice*100-100>percentOfGrowup&&isBorrowed(symbol)) {
        			otvet=otvet+symbol+" growUp on "+(highPrice/openPrice*100-100)+"%"+"\n";
        		}
        	}
        }
        return otvet;
	}
	private boolean isBorrowed(String symbol) {
		LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object>();

        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        String asset =symbol.substring(0, symbol.length()-4);
        try {
        	parameters.put("asset", asset);
       
            client.createMargin().maxBorrow(parameters);
            return true;
        }catch(Exception ex) {
        	return false;
        }
	}	
}
