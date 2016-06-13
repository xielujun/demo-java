package com.oklink.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MultipartBuilder;

public class OKLinkImpl implements OKLink {
	
	private HttpUtil httpUtil;
	
	public OKLinkImpl(OKLinkBuilder builder) {
		this.httpUtil = new HttpUtil(builder.apiKey, builder.apiSecret, builder.host);
	}
	
	public String getTicker(String symbol) throws Exception {
		// TODO Auto-generated method stub
		String url ="/api/v1/ticker.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("symbol",symbol);  
		return httpUtil.doPOST(url,params) ;
	}
	
	@Override
	public String getNationList() throws Exception {
		// TODO Auto-generated method stub
		String nationsUrl = "/api/v1/nations.do";
		return httpUtil.doPOST(nationsUrl, null);
	}
	@Override
	public String setRevenue(int type, int min, int max, int percent_fee) throws Exception {
		// TODO Auto-generated method stub
		String url ="/api/v1/revenue.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("type",type+"");
		params.put("min", min+"");
		params.put("max", max+"");
		params.put("percent_fee", percent_fee+"");
		return httpUtil.doPOST(url,params) ;
	}

	
	public String setBusinessStatus(int status) throws Exception {
		// TODO Auto-generated method stub
		String url ="/api/v1/business_status.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("status",status+"");
		return httpUtil.doPOST(url,params) ;
	}

	@Override
	public String setLimitAmount(int amount) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/limit_amount.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("amount",amount+""); 
		return httpUtil.doPOST(url, params);
	}
	
	@Override
	public String setPayMode(int pay_mode) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/payout_method.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("pay_mode",pay_mode+""); 
		return httpUtil.doPOST(url, params);
	}
	
	@Override
	public String setTransferNetWork(double outbound_rate, int targetCurrent, int plat,int isOpen) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/transfer_network.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("outbound_rate",outbound_rate+"");
		params.put("is_open", isOpen+"");
		params.put("target_currency", targetCurrent+"");
		params.put("plat", plat+"");
		return httpUtil.doPOST(url, params);
	}
	
	@Override
	public String createRemit(int nationId,int transferNetwork,int payMode,double receiveAmount,double sendAmount,String receiveName,String receivePhone,String sendName,String senderPhone,String payBankInfo) throws Exception {
		// TODO Auto-generated method stub
		String Url = "/api/v1/create_remit.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("nation_id",nationId+"");  
		params.put("transfer_network", transferNetwork+"");//1:OKD 2:BTC
		params.put("pay_mode",payMode+""); //1:Cash 2:Bank transfer
		if(sendAmount!=0d){
		   params.put("send_amount",sendAmount+"");
		}else if(receiveAmount!=0d){
		  params.put("receive_amount",receiveAmount+"");
		}
		params.put("sender_name",sendName);
		params.put("sender_phone",senderPhone);
		params.put("receiver_name",receiveName);
		params.put("receiver_phone",receivePhone);
		params.put("pay_bank",payBankInfo);
		return httpUtil.doPOST(Url, params);		
	}

	
	
	
	private static boolean isEmpty(String str) {
		if(str == null) 
			return true; 
		String tempStr = str.trim(); 
		if(tempStr.length() == 0)
			return true; 
		if(tempStr.equals("null"))
			return true;
		return false; 
	}


	@Override
	public String getPayInfo(long remitId) throws Exception {
		// TODO Auto-generated method stub
		String Url = "/api/v1/get_payinfo.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+"");  
		return httpUtil.doPOST(Url, params);
		
	}


	public String toPay(long remitId, String hex) throws Exception {
		// TODO Auto-generated method stub
		String Url = "/api/v1/pay.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+""); 
		params.put("pay_hex", hex);
		return httpUtil.doPOST(Url, params);
	}

	@Override
	public String setReceiveBtcAddress(String address) throws Exception {
		// TODO Auto-generated method stub
		String Url = "/api/v1/receive_address.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("address",address);
		return httpUtil.doPOST(Url, params);
	}

	@Override
	public String getRemitInfo(long remitId) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/remit_info.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+"");
		return httpUtil.doPOST(url, params);
	}

	@Override
	public String getRemitList(int type,int pageNo,int pageSize,int status) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/remit_list.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("status",status+"");
		params.put("type", type+"");
		params.put("current_page", pageNo+"");
		params.put("page_size",pageSize+"");
		return httpUtil.doPOST(url, params);
	}

	public String accept(long remitId) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/accept.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+"");
		return httpUtil.doPOST(url, params);
	}

	@Override
	public String getReciveInfo(long remitId) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/receive_info.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+"");
		return httpUtil.doPOST(url, params);
	}


	public String appealReceive(long remitId, int pickupCode, String receiveHex) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/appeal_receive.do";
		Map<String, String> params = new HashMap<String, String>();
		params.put("remit_id",remitId+"");
		params.put("pickup_code", pickupCode+"");
		params.put("receive_hex",receiveHex );
		return httpUtil.doPOST(url, params);
	}


	public String getUserInfo() throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/user_info.do";
		return httpUtil.doPOST(url, null);
	}

	
	public String uploadImg(long remitId, String imgPath) throws Exception {
		// TODO Auto-generated method stub
		String url = "/api/v1/upload_timg.do";
		
		MultipartEntityBuilder mub = MultipartEntityBuilder.create();
		mub.addBinaryBody("img",new File(imgPath));
		mub.addTextBody("remit_id", remitId+"");
		
		return httpUtil.doPOST(url, mub.build());
	}

	


}