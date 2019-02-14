package test.OtherTest;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class OtherTest {


    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int lenght = nums.length;
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        lists.add(list);
                    }
                }

            }

        }

        return removeDuplicate(lists);

    }

    /**
     * list 去重
     *
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }


    public void rotate(int[][] matrix) {

    }


    public static void main(String[] args) throws IOException {







        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        // 2016年
        cal.set(Calendar.WEEK_OF_YEAR, 1);
        // 设置为2016年的第10周
        cal.set(Calendar.DAY_OF_WEEK, 2);
        // 1表示周日，2表示周一，7表示周六
        Date date = cal.getTime();
        BigDecimal b=new BigDecimal("2.005694");
        System.out.println(b.compareTo(new BigDecimal("2.00006")));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
//        DateTimeFormatter
//        List<String> l1 =
// new ArrayList<String>();// l1为内部存储String类型的列表
//        l1.add("1-1");
//        l1.add("1-2");
//        l1.add("1-3");
//        l1.add("1-4");
//        l1.add("1-5");
//        List<List<String>> l2 = new ArrayList<List<String>>();// l2为内部存储ArrayList类型的列表
//        List<String> l_t1 = new ArrayList<String>();
//        l_t1.add("l_t1_1");
//        List<String> l_t2 = new ArrayList<String>();
//        l_t2.add("l_t1_2");
//        List<String> l_t3 = new ArrayList<String>();
//        l_t3.add("l_t1_3");
//        l2.add(l_t1);
//        l2.add(l_t2);
//        l2.add(l_t3);
//
//        List<String> l3 = new ArrayList<String>();// 创建空l3列表
//        l3.addAll(l1);// l3列表内添加l1列表
//        l1.set(3, "test");// 修改l1列表内元素的引用
//        System.out.println("l1---" + l1);
//        System.out.println("l3---" + l3);// 二者互不影响
//
//        List<List<String>> l4 = new ArrayList<List<String>>();// 创建空l4列表
//        l4.addAll(l2);// l4列表内添加l2列表
//        l2.get(1).set(0, "update");
//        l2.get(1).add("add");// 对l2列表内的元素进行修改
//
//        List<String> l_t = new ArrayList<String>();
//        l_t.add("test");
//        l2.set(1, l_t);// 对l2列表内元素的引用进行修改
//        System.out.println("l2---" + l2);
//        System.out.println("l4---" + l4);// 如果修改l2列表内元素，互相影响，如果修改l2列表内元素的引用，互不影响。
//
//        User user=null;
//        List<User> userList=new ArrayList<>();
//        for(int i=0;i<4;i++){
//                user=new User();
//            user.setAge(i);
//            user.setName(i+"");
//            userList.add(user);
//        }
//        List<User> collect = userList.stream().filter(User  -> "2".equals(User.getName()) || "3".equals(User.getName())).collect(Collectors.toList());
//
//        collect.forEach(user1 -> {
//            if (user1.getName().equals("2")){
//                System.out.println(user1);
//            }else {
//                System.out.println("this id是3");
//                System.out.println(user1);
//            }
//        });
//        Integer warningLeave = 0;
//        Integer keepTime = 180;
//        BigDecimal bigDecimal = new BigDecimal("0.8");
//        boolean highWarningFlag = bigDecimal.compareTo(new BigDecimal(GroutingAlarmType.HIGH.getThreshold()).setScale(2, RoundingMode.FLOOR)) > 0 || keepTime.compareTo(GroutingAlarmType.HIGH.getWarningTime())<0;
//        boolean lowWarningFlag = bigDecimal.compareTo(new BigDecimal(GroutingAlarmType.LOW.getThreshold()).setScale(2, RoundingMode.FLOOR)) > 0 || keepTime.compareTo(GroutingAlarmType.LOW.getWarningTime())<0;
//

        //        boolean middleWarningFlag = bigDecimal.compareTo(new BigDecimal(GroutingAlarmType.MIDDLE.getThreshold()).setScale(2, RoundingMode.FLOOR)) > 0 || keepTime.compareTo(GroutingAlarmType.MIDDLE.getWarningTime())<0;
//        boolean lowWarningFlag = bigDecimal.compareTo(new BigDecimal(GroutingAlarmType.LOW.getThreshold()).setScale(2, RoundingMode.FLOOR)) > 0 || keepTime.compareTo(GroutingAlarmType.LOW.getWarningTime())<0;
//        if (highWarningFlag){
//            warningLeave = GroutingAlarmType.HIGH.getType();
//        }else if (middleWarningFlag){
//            warningLeave = GroutingAlarmType.MIDDLE.getType();
//        }else if (lowWarningFlag){
//            warningLeave = GroutingAlarmType.LOW.getType();
//        }

//        Map<String,String> testSize = new HashMap<String, String>();
//        FileInputStream is = null;
//        try {
//            is = new FileInputStream(new File("C:/Users/dell/Desktop/HengTestUniversalMachineService.dat"));
//            Properties prop = new Properties();
//            prop.load(new InputStreamReader(is, "GBK"));
//            testSize=new HashMap<String, String>((Map)prop);
//       Iterator<String> iter=testSize.keySet().iterator();
// while(iter.hasNext()){
//           String key=iter.next();
//     String balue=testSize.get(key);
//     System.out.println(6>= Integer.parseInt(balue)?1:2);
}

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


//        long l=new Date().getTime();
//
//        int i=0;
//        System.out.println(i++);
//        System.out.println(i);
//        System.out.println(++i);
//        System.out.println(i);
//        Integer ss=0;
//        String a="p";
////        System.out.println(a+=ss);
//        System.out.println(a+ss);


//        List<String> stringList=new ArrayList<>();
//        stringList.add("a");
//        stringList.add("b");
//        stringList.add("c");
//        stringList.add("d");
//        String string = stringList.toString();
//        String substring = string.substring(1, string.length() - 1);
//        String s1 = StringUtils.join(stringList, ",");
//        List<User> userList=Lists.newArrayList();
//        System.out.println( userList.size());
//        List<User> userLisst= Lists.newArrayList(
//                new User(2,"ss","a"),
//                new User(2,"ss1","a3"),
//                new User(2,"ss2","ae")
//        );
//        userList.add(new User(2,"ss","a"));
//        userList.add(new User(4,"ss","vv"));
//        userList.add(new User(2,"ff","rr"));
//        Stream<User> stream = userList.stream();
//        Function<User, String> getNames = User::getName;
//
//
//        Collector<Object, ?, List<Object>> objectListCollector = Collectors.toList();
//        List<String> tableNames= stream.map(getNames).collect(Collectors.toList());
//
//        String s1s = StringUtils.join(tableNames, ",");
//        string.substring()

//String json="{\"beamCode\":\"ZF2-2\",\"projectID\":0}";
//
//        Map map1 = JSON.parseObject(json);
//        if ("0".equals(((JSONObject) map1).getString("projectID"))){
//            System.out.println("sssss");
//        }

//        LocalDateTime localDateTime=LocalDateTime.now();
//
//        LocalDate today = LocalDate.now();
//        // 今天是几号
//        int dayofMonth = today.getDayOfMonth();
//        // 今天是周几（返回的是个枚举类型，需要再getValue()）
//        int dayofWeek = today.getDayOfWeek().getValue();
//        // 今年是哪一年
//        int dayofYear = today.getDayOfYear();
//        int  day=today.getDayOfMonth();
//
//        // 根据字符串取：
//        LocalDate endOfFeb = LocalDate.parse("2018-02-28");
//
////        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        String a="TT2";
//        boolean s = a.equals("s");
//        int i = Integer.parseInt(getMatcher(a).replaceAll(""));
//        JButton b1 = new JButton("button1");

//        Matcher m = (Matcher) i;
//        System.out.println( i);
//    }
//        int[] a ={1,2,3};
//        int[] b = new int[3];
//
//        System.arraycopy(a,0,b,0,3);
//        for (int i=0;i<b.length;i++){
//            System.out.println(b[i]);
//        }






//
//        private static Matcher getMatcher(String a) {
//        String regEx="[^0-9]";
//        Pattern p = Pattern.compile(regEx);
//        return p.matcher(a);
//    }

    }
//}