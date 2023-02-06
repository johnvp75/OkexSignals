package my_binance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.FiboLevel;

public class TradeBinance {
	
	public final int RESPONSE_ACK=1;
	public final int RESPONSE_RESULT=2;
	public final int RESPONSE_FULL=3;

    private static final Logger logger = LoggerFactory.getLogger(GetAccount.class);
    public static void main(String[] args) {
    
    	FiboLevel testFibo=new FiboLevel(0.630, 0.751);
    	System.out.println("Fibo Test");
    	System.out.println("Level 0:"+testFibo.getLevel0());
    	System.out.println("Level 0.236:"+testFibo.getLevel0236());
    	System.out.println("Level 0.382:"+testFibo.getLevel0382());
    	System.out.println("Level 0.5:"+testFibo.getLevel05());
    	System.out.println("Level 0.618:"+testFibo.getLevel0618());
    	System.out.println("Level 0.786:"+testFibo.getLevel0786());
    	System.out.println("Level 1:"+testFibo.getLevel1());
 /*   	
        LinkedHashMap<String,Object> parameters = new LinkedHashMap<String,Object>();

        SpotClientImpl client = new SpotClientImpl(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        
        try {
        	parameters.put("asset", "1INCH");
       
            String result = client.createMargin().maxBorrow(parameters);
            logger.info(result);
        }
        catch (BinanceConnectorException e) {
            logger.error("fullErrMessage: {}", e.getMessage(), e);
        }
        catch (BinanceClientException e) {
            logger.error("fullErrMessage: {} \nerrMessage: {} \nerrCode: {} \nHTTPStatusCode: {}",
                    e.getMessage(), e.getErrMsg(), e.getErrorCode(), e.getHttpStatusCode(), e);
        }
*/
    }

}

