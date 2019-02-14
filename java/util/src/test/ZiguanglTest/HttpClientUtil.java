package test.ZiguanglTest;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by dell on 2017-11-06.
 */
public class HttpClientUtil {
    public static HttpClientResponseResult requestGet(String url){
        HttpClientResponseResult responseResult = new HttpClientResponseResult();
        //生成 HttpClinet对象并设置参数
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //生成 HttpGet对象并设置参数
        HttpGet httpGet = new HttpGet(url);
        //设置 httpGet请求超时为 5 秒
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000).setConnectTimeout(5000).build();
        httpGet.setConfig(requestConfig);

        // 定义返回对象
        String jsonStr = "";
        //执行 HTTP GET 请求
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            //获取响应编码
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            responseResult.setStatusCode(statusCode);
            //解析响应内容
            HttpEntity httpEntity = httpResponse.getEntity();
            jsonStr = EntityUtils.toString(httpEntity,"UTF-8");
            responseResult.setResponseContent(jsonStr);
        } catch (IOException e) {    //发生网络异常

        } finally {    //释放连接
            httpGet.releaseConnection();
            try {
                httpClient.close();
            } catch (IOException e) {

            }
        }
        return responseResult;
    }


    public static HttpClientResponseResult requestPost(String url, Map<String,String>
            paramMap){
        if(paramMap==null){
            return null;
        }
        HttpClientResponseResult responseResult = new HttpClientResponseResult();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String jsonStr = "";
        HttpEntity entity = null;
        try {
            entity = new StringEntity(new Gson().toJson(paramMap), ContentType.APPLICATION_JSON);
            //new UrlEncodedFormEntity(params, "UTF-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse httpResponse = null;
            httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            responseResult.setStatusCode(statusCode);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                jsonStr = EntityUtils.toString(httpEntity,"UTF-8");
                responseResult.setResponseContent(jsonStr);
            }
        } catch (IOException e) {
           // log.error("HttpClient requestPost Execute Error:",e);
        }finally{
            httpPost.releaseConnection();
            try {
                httpClient.close();
            } catch (IOException e) {
                //log.error("HttpClient requestPost Close httpClient Error:",e);
            }
        }
        return responseResult;
    }

}
