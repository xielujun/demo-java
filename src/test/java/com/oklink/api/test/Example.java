package com.oklink.api.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oklink.api.OKLink;
import com.oklink.api.OKLinkBuilder;
import com.oklink.api.util.SignTool;

public class Example {
	
	
	private static final String KEY = "728da0e3-e0b8-4644-8eae-497c105bf2b8";  //apikey
	private static final String SECRET = "45D045DF950631776C0CB3F5CDA1A662";//secretkey

	public static void main(String[] args) throws Exception {
		OKLink oklink = OKLinkBuilder.getInstance().setHost("http://local.oklink.com")
                .build(KEY, SECRET);
		  String result = null;
		 // #common api
		
		 //result = oklink.getTicker("EXRATE");
		 //result = oklink.getCountryList();
		 
		 //#setting api
		 //result = oklink.setDeliveryStatus(1);
		  
		 //#remitance api 
		 //result = oklink.getBankInfo(89);
	     //result = oklink.createRemit(89,1,2,0,1000,"zhangsan1","86,15001137489","lisi1","86,15001137489","78@127@Ordinary@11122222333",true) ;  //269
		 //result = oklink.getRemitInfo(845,1);
		 //result = oklink.getRemitList(2, 1, 10, 5);
		
		 //#pay
         //result = oklink.getPayInfo(845);
         //JSONObject json = JSON.parseObject(result);
         //JSONObject payInfo = json.getJSONObject("pay_info");
         //String privateKeyWIF = SignTool.decodePrivateKeyWIF(payInfo.getString("aes256key"), "123!e", payInfo.getString("salt"));
         //String hex = SignTool.verifyAndSignTransaction(payInfo.getString("pay_hex"),SignTool.COIN_TOKEN, privateKeyWIF,"", true);
         //result = oklink.toPay(845, hex);
		
		 //#accept
		 //result = oklink.accept(845);
		  
		 //result = oklink.getRejectInfo(863);
		 //JSONObject json = JSON.parseObject(result);
         //JSONObject payInfo = json.getJSONObject("reject_info");
         //String privateKeyWIF = SignTool.decodePrivateKeyWIF(payInfo.getString("aes256key"), "a1!", payInfo.getString("salt"));
         //String hex = SignTool.verifyAndSignTransaction(payInfo.getString("reject_hex"),SignTool.COIN_TOKEN, privateKeyWIF,payInfo.getString("redeem_script"), true);
         //result = oklink.reject(863, hex,"this is no good");
		 
		 
		 //#receive
         //result = oklink.getReciveInfo(845);
         //JSONObject json = JSON.parseObject(result);
         //JSONObject payInfo = json.getJSONObject("receive_info");
         //String privateKeyWIF = SignTool.decodePrivateKeyWIF(payInfo.getString("aes256key"), "a1!", payInfo.getString("salt"));
         //String redeem_script = payInfo.getString("redeem_script");
         //String hex = SignTool.verifyAndSignTransaction(payInfo.getString("receive_hex"),SignTool.COIN_TOKEN, privateKeyWIF,
         //  redeem_script, true);
         //result = oklink.appealReceive(845, 651287, hex);
		
		 //#user account api
		 //result = oklink.getUserInfo();
		 System.out.println(result);
		
	}
	
}
