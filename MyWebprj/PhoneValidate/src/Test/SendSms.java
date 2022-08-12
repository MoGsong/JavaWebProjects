package Test;

//import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

public class SendSms {

	public static String TX_Utils(String phoneNumber,String code) {

		String reStr = ""; //定义返回值
		// 短信应用SDK AppID   // 1400开头
		int appid = 1400;
		// 短信应用SDK AppKey
		String appkey = "";
		// 短信模板ID，需要在短信应用中申请
		int templateId = 1489819;
		// 签名，使用的是`签名内容`，而不是`签名ID`
		String smsSign = "";
		try {
			//参数，一定要对应短信模板中的参数顺序和个数，
			String[] params = {code};
			//创建ssender对象
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			//发送
			SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumber,templateId, params, smsSign, "", "");
			// 签名参数未提供或者为空时，会使用默认签名发送短信
			System.out.println(result.toString());
			if(result.result==0){
				reStr = "success";
			}else{
				reStr = "error";
			}
		} catch (Exception e) {
			// HTTP响应码错误
			e.printStackTrace();
		}
		return reStr;
	}
}

