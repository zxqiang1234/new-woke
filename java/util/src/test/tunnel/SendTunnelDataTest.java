package test.tunnel;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


public class SendTunnelDataTest {
    private static final String LOCAL_URL = "http://127.0.0.1:8080/";
    private static final String LIANGHUI_URL = "http://117.34.91.251:8805/imp/";


    @Test
    public void SendTunnelDataTest1() {
        String url = "http://192.168.0.129:8080/realTimeLocation/receiveRealTimeLocationRecord.do";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EmpId", "9139300");
        jsonObject.put("Addr", "5");
        jsonObject.put("SiteName", "洞内");
        jsonObject.put("InsideFlag", "1");
        jsonObject.put("TunnelName", "PTKZ2左线隧道");
        jsonObject.put("EnterTime", "2018-11-24 16:02:45");
        jsonObject.put("SiteType", "0");
        jsonObject.put("LeaveFlag", "1");

        HttpHelper.httpPost(url, jsonObject.toJSONString());

    }
    public static String GetHtmlSource(String url)
    {
        String strResult ="" ;
        try
        {

//            HttpWebRequest myReq = (HttpWebRequest)WebRequest.Create(url);
//            myReq.Method="GET";
//            myReq.ServicePoint.ConnectionLimit=100;
//            HttpWebResponse HttpWResp = (HttpWebResponse)myReq.GetResponse();
//            Stream myStream = HttpWResp.GetResponseStream () ;
//            StreamReader sr = new StreamReader(myStream , Encoding.Default);
//            StringBuilder strBuilder = new StringBuilder();
//            while (-1 != sr.Peek())
//            {
//                strBuilder.Append(sr.ReadLine()+"/n");
//            }
//            strResult = strBuilder.ToString();
        }
        catch(Exception e)
        {
            return "441";
        }
        return strResult ;
    }

    /**
     * site心跳消息接口
     */
    @Test
    public void SendSiteConnectionListenDataTest() {
        String url = LOCAL_URL + "site/siteConnectionListen.do";
//        String url = LIANGHUI_URL + "site/siteConnectionListen.do";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TunnelName", "LHSYD进口左线隧道");
        jsonObject.put("Addr", "5");
        jsonObject.put("SiteName", "IN5");
        jsonObject.put("InsideFlag", "1");
        jsonObject.put("Status", "1");
        jsonObject.put("SiteType", "0");
        jsonObject.put("TunnelId", null);

//        HttpHelper.httpPost(url, jsonObject.toJSONString());


    }
}
