package my_okx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import data.Pair;

public class CheckForExtreameGrowupOkex {
	private int interval;
	private ArrayList<String> tempListOfSymbols;
	
	public CheckForExtreameGrowupOkex(int interval) {
		this.interval=interval;
	}
	
	public String check(ArrayList<Pair> stringOfSymbols,double percentOfGrowup) {
        String otvet="";
        String result;
        JSONArray response;
    	double openPrice;
    	double highPrice;
		for (int i=0;i<stringOfSymbols.size();i++) {
	        Map<String,String> parameters = new HashMap<String,String> ();
	        parameters.put("instId",stringOfSymbols.get(i).getName());
	        parameters.put("bar","5m");
	        parameters.put("limit", Integer.toString(interval/5));
	        result = GetDataFromOkex.getPublicMarketData("candles", parameters);
	        if (result==null)
	        	return null;
	        JSONArray candels=new JSONObject(result).getJSONArray("data");
	        openPrice=candels.getJSONArray(interval/5-1).getDouble(1);
	        highPrice=0.0;
	        for (int j=0;j<candels.length();j++) {
	        	if (candels.getJSONArray(j).getDouble(2)>highPrice)
	        		highPrice=candels.getJSONArray(j).getDouble(2);
	        }
    		if (highPrice/openPrice*100-100>percentOfGrowup) {
    			String format="%,."+stringOfSymbols.get(i).getPrecision()+"f";
    			otvet=otvet+stringOfSymbols.get(i).getName()+" growUp on "+String.format("%,.2f",highPrice/openPrice*100-100)+"%"+"\n Goal price is "+String.format(format,openPrice*1.3);
    		}

		}
        
        return otvet;
        

	}
}
