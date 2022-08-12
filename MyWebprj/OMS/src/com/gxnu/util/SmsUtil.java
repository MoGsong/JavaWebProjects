package com.gxnu.util;

import java.io.IOException;

import org.json.JSONException;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

/**
 * 使用腾讯云API发送短信
 */
public class SmsUtil {
	//短信应用SDK AppID
    private final int appid = 1400716010; // 1400开头
    // 短信应用SDK AppKey
    private final String appkey = "ccf4c3831691a78648421c56e255a472";
    // 真实的模板ID需要在短信控制台中申请
    public int[] templateId = new int[] {1497041,1497023,1497042,1497306,1497294};
    
    // 真实的签名需要在短信控制台中申请，另外
    // 签名参数使用的是`签名内容`，而不是`签名ID`
    String smsSign = "数据小桥梁";
    /**
     * @param phoneNumber 单一的电话号码
     * @param ValiCode    验证码
     * @param templateId  模板id数组中的一个，有5个模板注册，登录，改密，预约提醒，取药，分别对应数组索引号为0,1,2,3,4
     * @return 返回成功或失败
     */
    public String Sendms(String phoneNumber, int templateId, String message) {
    	 String reStr = ""; //定义返回值
    	 try {
             String[] params = {message};
             SmsSingleSender msender = new SmsSingleSender(appid, appkey);
             SmsSingleSenderResult result =  msender.sendWithParam("86", phoneNumber, 
             		templateId, params, smsSign, "", ""); // 签名参数未提供或者为空时，会使用默认签名发送短信
             //判断发送短信是否成功
             if(result.result==0){
 				reStr = "success";
 			}else{
 				reStr = "error";
 			}
             //详细结果
             System.out.print(result);
         } catch (HTTPException e) {
             // HTTP响应码错误
             e.printStackTrace();
         } catch (JSONException e) {
             // json解析错误
             e.printStackTrace();
         } catch (IOException e) {
             // 网络IO错误
             e.printStackTrace();
         }
    	//发送短信是否成功的结果
    	return reStr;	
    }
	
}
