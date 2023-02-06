package my_binance;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.binance.connector.client.exceptions.BinanceConnectorException;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;

import data.FiboLevel;
import data.Pair;

public class StartServiceForBinance {
	private final int EVER_MINUTE=1;
	private final int EVER_HOUR=2;
	private final int EVER_DAY=3;
	private final static String[] timeCheckForEnterPointBinance= {"9:57","10:57","11:57","12:57","13:57"};
	private static TelegrammChat chat=new TelegrammChat(PrivateConfig.Telegramm_Bot_Token, PrivateConfig.Telegarmm_Chat_ID, PrivateConfig.Telegramm_Admin_User_Name);
	private static GregorianCalendar lastStartCheckForExtreameGrowupBinance=new GregorianCalendar();
	private static GregorianCalendar lastStartCheckForEnterPointBinance=new GregorianCalendar();
	private static GregorianCalendar lastStartUpdatePairList=new GregorianCalendar();

	public static void main(String[] args) {
		final boolean stop=false;
		boolean[] checkStartCheckForEnterPointBinance=new boolean[timeCheckForEnterPointBinance.length];
		for (int i=0;i<checkStartCheckForEnterPointBinance.length;i++)
			checkStartCheckForEnterPointBinance[i]=false;
		ArrayList<Pair> allPairs=updatePairList();
		if (allPairs==null) {
    		System.out.println("Network error");
    		System.out.println("Application not started");
    		return;
		}
		do {
			if (new GregorianCalendar().getTimeInMillis()-lastStartUpdatePairList.getTimeInMillis()>86400000) {
				allPairs=updatePairList();
				if (allPairs==null) {
		    		System.out.println("Network error");
		    		continue;
				}
				lastStartUpdatePairList=new GregorianCalendar();
				for (int i=0;i<checkStartCheckForEnterPointBinance.length;i++)
					checkStartCheckForEnterPointBinance[i]=false;
			}
			for (int i=0;i<timeCheckForEnterPointBinance.length;i++) {
				String testTime=new GregorianCalendar().get(GregorianCalendar.HOUR_OF_DAY)+":"+new GregorianCalendar().get(GregorianCalendar.MINUTE);
				if (testTime.equals(timeCheckForEnterPointBinance[i])&&!checkStartCheckForEnterPointBinance[i]) {
					startCheckForEnterPointBinance(allPairs);
					checkStartCheckForEnterPointBinance[i]=true;
				}
			}
			if (new GregorianCalendar().getTimeInMillis()-lastStartCheckForExtreameGrowupBinance.getTimeInMillis()>60000) {
				lastStartCheckForExtreameGrowupBinance=new GregorianCalendar();
				startCheckForExtreameGrowupBinance(allPairs);
			}			
		} while(!stop);

	}

	
	
	private static void startCheckForExtreameGrowupBinance(ArrayList<Pair> fAllSymbols) {
		System.out.println("Started CheckForExtreameGrowupBinance at: "+new Date());
		CheckForExtreameGrowup checker=new CheckForExtreameGrowup("1h");
		String checkerResult=checker.check(fAllSymbols, 29);
		if (checkerResult==null) {
    		System.out.println("Network error");
    		return;
		}
		if (!checkerResult.isBlank()) {
    		System.out.println("Binance growup checker response: "+checkerResult);
    		chat.sendMessage("Binance growup checker response: "+checkerResult);
		}
		System.out.println("Ended CheckForExtreameGrowupBinance at: "+new Date());
	}
	

	// +
	private static void startCheckForEnterPointBinance(ArrayList<Pair> fAllSymbols) {
		System.out.println("Started CheckForEnterPointBinance at: "+new Date());
		CheckForEnterPoint checker=new CheckForEnterPoint();
        for (int i=0;i<fAllSymbols.size();i++) {
        	FiboLevel fiboForPosition=checker.check(fAllSymbols.get(i), "1h");
        	if (fiboForPosition==null) {
        		continue;
        	}
        	if (fiboForPosition!=null&&isBorrowed(fAllSymbols.get(i).getName())) { 
        		System.out.println(fAllSymbols.get(i).getName()+" is checked and can borrowd");
        		chat.sendMessage("Binance margin "+fAllSymbols.get(i).getName()+" is checked");
        		chat.sendMessage(fiboForPosition.asStringWithParcent(fAllSymbols.get(i).getPrecition()));
        		
        	}
        }
		
	}
	private static ArrayList<Pair> updatePairList(){
		System.out.println("Binance:Started updatePairList at: "+new Date());
    	SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY,PrivateConfig.SECRET_KEY);
        
        Market market = client.createMarket();
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object> ();

        //Get all symbols
        String result=null;
        try {
        	result = market.exchangeInfo(parameters);
        }catch (BinanceConnectorException ex) {
        	
        }
		if (result==null) {
    		System.out.println("Network error");
    		return null;

		}
        ArrayList<Pair> allSymbols=new ArrayList<Pair>();
        JSONArray symbols=new JSONObject(result).getJSONArray("symbols");
        for (int i=0;i<symbols.length();i++) {
        	JSONObject symbol=symbols.getJSONObject(i);
        	if (symbol.getString("quoteAsset").equals("BUSD")&&symbol.getBoolean("isMarginTradingAllowed")) {
        		Pair ticker=new Pair(symbol.getString("symbol"));
        		JSONArray filters=symbol.getJSONArray("filters");
        		for (int j = 0; j < filters.length(); j++) {
					if(filters.getJSONObject(j).getString("filterType").equals("PRICE_FILTER")) {
						ticker.setPrecition(filters.getJSONObject(j).getString("minPrice").indexOf("1")-1);
						break;
					}
				}
        		allSymbols.add(ticker);
        	}
        }
        System.out.println(allSymbols.toString());
        return allSymbols;
	}
	
	private static boolean isBorrowed(String symbol) {
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

