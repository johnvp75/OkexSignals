/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_binance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 *
 * @author User
 */
public class TelegrammChat {
    private String botToken;
    private String chatId;
    private String adminUserName;

    public TelegrammChat(String botToken, String chatId, String adminUserName) {
        this.botToken = botToken;
        this.chatId = chatId;
        this.adminUserName = adminUserName;
    }

    private String getBotToken() {
        return botToken;
    }

    private String getChatId() {
        return chatId;
    }

    private String getAdminUserName() {
        return adminUserName;
    }

    
    
    private String request(String method, Map<String, String> arguments) {
 
        String postData = "";
        if (arguments == null) {  // If the user provided no arguments, just create an empty argument array.
            arguments = new HashMap<String,String>();
        }

        arguments.put("chat_id", getChatId()); 

        

        for (Map.Entry<String, String> stringStringEntry : arguments.entrySet()) {
            Map.Entry argument = (Map.Entry) stringStringEntry;

            if (postData.length() > 0) {
                postData += "&";
            }
            postData += argument.getKey() + "=" + argument.getValue();
        }

        // Now do the actual request

        OkHttpClient client = new OkHttpClient();
        try {

            Request request = new Request.Builder()
                    .url("https://api.telegram.org/bot"+getBotToken()+"/"+method+"?" + postData)
                    .get()
                    .build();
            
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            System.err.println("Request fail: " + e.toString());
            return null;  // An error occured...
        }
    }

    public void sendMessage(String message){
        HashMap attr=new HashMap(1,1);
        attr.put("text",message);
        request("sendMessage", attr);
    }
    
}
