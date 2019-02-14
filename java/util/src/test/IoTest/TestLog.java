package test.IoTest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestLog {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public static Connection getAccessConnectionByUserNameAndPwd() {
        Connection con = null;
        try {
            Class.forName("com.hxtt.sql.access.AccessDriver");
            con = DriverManager.getConnection("jdbc:Access:///F:/Download/太凤二标实验室 (1)/太凤二标实验室/太凤二标实验室万能机数据库/HengTest/TestSoft V7/DB/Data/钢筋机械连接/3.mdb", "", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }

    public static byte[] getDotsModel() {
        Connection conn = null;
        byte[] bytes = null;
        try {
            conn = getAccessConnectionByUserNameAndPwd();
            String sql = "select DataValue from Dots where InTestID = 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bytes = rs.getBytes("DataValue");
            }
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }

    public static List<IoTest> setUp(byte[] data) throws Exception {

        List<IoTest> ioTests = new ArrayList<>();
        //设置byte数组
        byte[] temp = new byte[56];
        for (int i = 0; i < data.length; i++) {
            temp[i % 56] = data[i];
            if (i == 0) {
                continue;
            }
            if (i % 56 == 0) {
                ioTests.add(getIoTest(temp));
                temp = new byte[56];
                continue;
            }

        }
        return ioTests;
    }


    public static IoTest getIoTest(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.position(0);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        IoTest ioTest = new IoTest();
        ioTest.setByteBuffer(buffer, 0);
        return ioTest;
    }

    public static double bytesToDouble(byte[] b) {
        return Double.longBitsToDouble(bytesToLong(b));
    }

    /**
     * 将一个8位字节数组转换为长整数。<br>
     * 注意，函数中不会对字节数组长度进行判断，请自行保证传入参数的正确性。
     *
     * @param b 字节数组
     * @return 长整数
     */
    public static long bytesToLong(byte[] b) {
        long l = 0;
        for (int i = 0; i < 8; i++) {
            l |= ((long) (b[i] & 0xff)) << (8 * i);
        }


        return l;
    }

    public static String getAdd(String log, String lat) {
        //lat 小  log  大
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + log + "&type=010";
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        System.out.println(res);
        return res;
    }

//    public static String xypase(String dms, String type) throws UnsupportedEncodingException {
//        if (dms == null || dms.equals("")) {
//            return "0.0";
//        }
//        double result = 0.0D;
//        String temp = "";
//        if (type.equals("E")) {
//            //经度
//            // String e1 = dms.substring(0, 3);
//            // 截取3位数字,经度共3位,最多180度
//            // 经度是一伦敦为点作南北两极的线为0度,所有往西和往东各180度 String e2 = dms.substring(3, dms.length());
//            // 需要运算的小数
//            // result = Double.parseDouble(e1);
//            // result += (Double.parseDouble(e2) / 60.0D);
//            // temp = String.valueOf(result);if (temp.length() > 9) {temp = e1 + temp.substring(temp.indexOf("."), 9);}} else if (type.equals("N")) {//纬度,纬度是以赤道为基准,相当于把地球分两半,两个半球面上的点和平面夹角0~90度String n1 = dms.substring(0, 2);//截取2位,纬度共2位,最多90度String n2 = dms.substring(2, dms.length());result = Double.parseDouble(n1);result += Double.parseDouble(n2) / 60.0D;temp = String.valueOf(result);if (temp.length() > 8) {temp = n1 + temp.substring(temp.indexOf("."), 8);}}return temp;}public static void main(String[] args) {String info="(ONE072457A3641.2220N11706.2569E000.000240309C0000400)"; info=info.substring(11,info.length()-13);//纬度String N = info.substring(0, info.indexOf("N"));//经度String E = info.substring(info.indexOf("N")+1,info.indexOf("E"));//请求gis,获取地理信息描述double x = Double.parseDouble(CoordConversion.xypase(E,"E"));double y = Double.parseDouble(CoordConversion.xypase(N,"N"));String result =LocationInfo.getLocationInfo("test", x, y); //System.out.println("径度:"+x+","+"纬度:"+y);System.out.println(result);}}
//        }


            public static void main (String[]args) throws Exception {
//                for (int i=0;i<1000000;i++){
//                    System.out.println( UUIDGenrateUtil.generateShortUuid());
//                }

                Long ss=Long.parseLong("17677406011");
                System.out.println(ss);



//                String add = getAdd("108.880768000000000000", "34.228316000000000000");
//                JSONObject jsonObject = JSONObject.fromObject(add);
//                JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));
//                JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0));
//                String allAdd = j_2.getString("admName");
//                String arr[] = allAdd.split(",");
//                System.out.println("省:" + arr[0] + "\n市:" + arr[1] + "\n区:" + arr[2]);
//            for (int i=0;i<1000;i++){
//            HttpClient client = HttpClients.createDefault();// 创建默认http连接
//            HttpPost post = new HttpPost("http://api.map.baidu.com/geocoder/v2/");// 创建一个post请求
//            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
//            paramList.add(new BasicNameValuePair("ak", "yEcfF7FICGiTqDn9alaP3N0o2NE2ssCw"));//传递的参数
//            paramList.add(new BasicNameValuePair("output","json"));
//            paramList.add(new BasicNameValuePair("coordtype","wgs84ll"));
//            paramList.add(new BasicNameValuePair("pois","0"));
//            paramList.add(new BasicNameValuePair("location", "34.228316000000000000"+","+"108.880768000000000000"));//传递的参数
//
//            // 把参转码后放入请求实体中
//            HttpEntity entitya = new UrlEncodedFormEntity(paramList, "utf-8");
//            post.setEntity(entitya);// 把请求实体放post请求中
//            HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应
//            HttpEntity entity = response.getEntity();// 从response中取到响实体
////            JsonUtil.httpEntityToJsonArray
//            String html = EntityUtils.toString(entity);// 把响应实体转成文本
////            JsonParser jp = new JsonParser();
////            JsonElement je = jp.parse(html);
//            JSONObject responseBody = new JSONObject(html);
//                System.out.println(html);
//
//            Gson gson = new Gson();
//
//                ResultModel baiduAddressModel = gson.fromJson(responseBody.toString(), (Type) ResultModel.class);
//                System.out.println(baiduAddressModel.toString());
            }
//
//            List<IoTest> ioTests=  setUp(getDotsModel());
//            StringBuilder sd=new StringBuilder();
//            for (int i = 0; i <ioTests.size() ; i++) {
//                sd.append(new BigDecimal(ioTests.get(i).time.get()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).append(":");
//                sd.append( new BigDecimal(ioTests.get(i).posi.get()).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).append(";");
//            }
//            System.out.println(sd.toString());
//            }
        }
