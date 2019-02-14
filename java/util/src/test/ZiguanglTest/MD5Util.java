package test.ZiguanglTest;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dell on 2017-11-06.
 */
public class MD5Util {
    public static String getSignature(String secret, Map<String, String> params) {
        if (params == null) {
            return "";
            // 先将参数以其参数名的字典序升序进行排序
        }
        Map<String, String> treeMap = new TreeMap<>(params);
        StringBuilder basestring = new StringBuilder();
        basestring.append(secret);
        for (String name : treeMap.keySet()) {
            basestring.append(name).append(params.get(name));
        }
        basestring.append(secret);

        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(basestring.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getCause());
        } catch (GeneralSecurityException ex) {

        }
        StringBuilder sign = new StringBuilder();
        // 将MD5输出的二进制结果转换为小写的十六进制
        long start=System.currentTimeMillis(); //获取开始时间
        for(Byte by:bytes){
            String hex = Integer.toHexString(by & 0xFF);
            if (hex.length()==1){
                sign.append("0");
            }
            sign.append(hex);
        }
//                if (bytes != null) {
//            for (int i = 0; i < bytes.length; i++) {
//                String hex = Integer.toHexString(bytes[i] & 0xFF);
//                if (hex.length() == 1) {
//                    sign.append("0");
//                }
//                sign.append(hex);
//            }
//        }
        //要测试的程序或方法
        long end=System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： "+(end-start)+"ms");

//

        return sign.toString().toUpperCase();
    }

}
