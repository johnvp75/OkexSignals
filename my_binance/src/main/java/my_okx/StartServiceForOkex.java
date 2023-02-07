package my_okx;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import data.FiboLevel;
import data.Pair;

public class StartServiceForOkex {
	private final int EVER_MINUTE=1;
	private final int EVER_HOUR=2;
	private final int EVER_DAY=3;
	private final static String[] timeCheckForEnterPointOkex= {"9:55","10:55","11:55","12:55","13:55"};
	private static TelegrammChat chat=new TelegrammChat(PrivateConfig.Telegramm_Bot_Token, PrivateConfig.Telegarmm_Chat_ID, PrivateConfig.Telegramm_Admin_User_Name);
	private static GregorianCalendar lastStartCheckForExtreameGrowupOkex=new GregorianCalendar();
	private static GregorianCalendar lastStartCheckForEnterPointOkex=new GregorianCalendar();
	private static GregorianCalendar lastStartUpdatePairList=new GregorianCalendar();

	public static void main(String[] args) {
		final boolean stop=false;
		boolean[] checkStartCheckForEnterPointOkex=new boolean[timeCheckForEnterPointOkex.length];
		for (int i=0;i<checkStartCheckForEnterPointOkex.length;i++)
			checkStartCheckForEnterPointOkex[i]=false;
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
				for (int i=0;i<checkStartCheckForEnterPointOkex.length;i++)
					checkStartCheckForEnterPointOkex[i]=false;
			}
			for (int i=0;i<timeCheckForEnterPointOkex.length;i++) {
				String testTime=new GregorianCalendar().get(GregorianCalendar.HOUR_OF_DAY)+":"+new GregorianCalendar().get(GregorianCalendar.MINUTE);
				if (testTime.equals(timeCheckForEnterPointOkex[i])&&!checkStartCheckForEnterPointOkex[i]) {
					startCheckForEnterPointOkex(allPairs);
					checkStartCheckForEnterPointOkex[i]=true;
				}
			}
			if (new GregorianCalendar().getTimeInMillis()-lastStartCheckForExtreameGrowupOkex.getTimeInMillis()>60000) {
				lastStartCheckForExtreameGrowupOkex=new GregorianCalendar();
				startCheckForExtreameGrowupOkex(allPairs);
			}			
		} while(!stop);

	}

	
	
	private static void startCheckForExtreameGrowupOkex(ArrayList<Pair> fAllSymbols) {
		System.out.println("Started CheckForExtreameGrowupOkex at: "+new Date());
		CheckForExtreameGrowupOkex checker=new CheckForExtreameGrowupOkex(60);
		String checkerResult=checker.check(fAllSymbols, 25);
		if (checkerResult==null) {
    		System.out.println("Network error");
    		return;
		}
		if (!checkerResult.isBlank()) {
    		System.out.println("OKX growup checker response: "+checkerResult);
    		chat.sendMessage("OKX growup checker response: "+checkerResult);
		}
		System.out.println("Ended CheckForExtreameGrowupOkex at: "+new Date());
	}
	
	private static void startCheckForEnterPointOkex(ArrayList<Pair> fAllSymbols) {
		System.out.println("Started CheckForEnterPointOkex at: "+new Date());
        CheckForEnterPointOkex checker=new CheckForEnterPointOkex();
        for (int i=0;i<fAllSymbols.size();i++) {
        	FiboLevel fiboValueForPosition=checker.check(fAllSymbols.get(i), "1H");
        	if (fiboValueForPosition==null) {
        		continue;
        	}
        	if (fiboValueForPosition!=null) { 
        		System.out.println(fAllSymbols.get(i).getName()+" is checked");
        		chat.sendMessage("OKX margin "+fAllSymbols.get(i).getName()+" is checked");
        		chat.sendMessage(fiboValueForPosition.asStringWithParcent(fAllSymbols.get(i).getPrecision()));
        	}
        }
		
	}
	private static ArrayList<Pair> updatePairList(){
		System.out.println("OKX:Started updatePairList at: "+new Date());
		Map<String, String> parameters=new HashMap<String, String>();
        parameters.put("instType", "SWAP");
		String result = GetDataFromOkex.getPublicData("instruments", parameters);
		if (result==null) {
    		System.out.println("Network error");
    		return null;

		}
        ArrayList<Pair> allSymbols=new ArrayList<Pair>();
        JSONArray symbols=new JSONObject(result).getJSONArray("data");
        for (int i=0;i<symbols.length();i++) {
        	JSONObject symbol=symbols.getJSONObject(i);
        	if (symbol.getString("instId").indexOf("-USDT-")!=-1) {
        		Pair ticket=new Pair(symbol);
//        		Pair ticket=new Pair(symbol.getString("instId"));
//        		ticket.setTickSz(symbol.getString("tickSz"));
//        		ticket.setPrecition();
        		allSymbols.add(ticket);
        	}
        }
        System.out.println(allSymbols.toString());
        return allSymbols;
	}
}
