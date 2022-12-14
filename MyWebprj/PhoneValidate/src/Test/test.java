package Test;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import java.io.IOException;


public class test {

    public static void main(String[] args) {
        // 短信应用SDK AppID
        int appid = 1400716010; // 1400开头

        // 短信应用SDK AppKey
        String appkey = "ccf4c3831691a78648421c56e255a472";

        // 需要发送短信的手机号码
        String[] phoneNumbers = {"19580774316"};

        // 短信模板ID，需要在短信应用中申请
        // NOTE: 这里的模板ID`7839`只是一个示例，
        // 真实的模板ID需要在短信控制台中申请
        int templateId = 1497306;

        // 签名
        // NOTE: 这里的签名"腾讯云"只是一个示例，
        // 真实的签名需要在短信控制台中申请，另外
        // 签名参数使用的是`签名内容`，而不是`签名ID`
        String smsSign = "数据小桥梁";

        // 指定模板ID单发短信
        try {
            String[] params = {"5678"};
            SmsSingleSender msender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result =  msender.sendWithParam("86", phoneNumbers[0], 
            		templateId, params, smsSign, "", ""); // 签名参数未提供或者为空时，会使用默认签名发送短信
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

       
    }
}
