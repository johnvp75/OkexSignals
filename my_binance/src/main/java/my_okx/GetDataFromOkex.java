package my_okx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetDataFromOkex {
	
	final private static String OKX_API_URL=PrivateConfig.BASE_URL_OKX;
	private static int countRequest=0;
	private static GregorianCalendar checkTime=new GregorianCalendar();

	public static String getPublicMarketData(String func,Map<String,String> arguments) {
		return getData(func, arguments, "market");
		
	}
	
	public static String getPublicData(String func,Map<String,String> arguments) {
		return getData(func, arguments, "public");
		
	}
	
	
	private static String getData(String func,Map<String,String> arguments,String section) {
		String postData = "";
		
        for (Map.Entry<String, String> stringStringEntry : arguments.entrySet()) {
            Map.Entry argument = (Map.Entry) stringStringEntry;

            if (postData.length() > 0) {
                postData += "&";
            }else {
            	postData = "?";
            }
            postData += argument.getKey() + "=" + argument.getValue();
        }
        String ret="";
		try {
			countRequest++;
			if (countRequest-countRequest/10*10==0&&(new GregorianCalendar()).getTimeInMillis()-checkTime.getTimeInMillis()<1000) {
				TimeUnit.MILLISECONDS.sleep(1000-(new GregorianCalendar()).getTimeInMillis()-checkTime.getTimeInMillis());
				checkTime=new GregorianCalendar();
			}
			URL market = new URL(OKX_API_URL+section+"/"+func+postData);
			URLConnection yc = market.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) 
				ret=ret+inputLine;
			in.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}

        return ret;
		
	}
}
