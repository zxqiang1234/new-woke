package orderTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-21 11:04
 **/
public class TestApple {
    public static void main(String[] args) throws ParseException {

List<Apple> appleLists=new ArrayList<>();
Apple apple1=null;
                for(int i=0;i<1000000;i++){
                    apple1=  new Apple(i,"ss",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-10-11 23:25:21"));
                    appleLists.add(apple1);
                }
        long startTimesss = System.currentTimeMillis();
        long count = appleLists.stream().filter(num -> 10 == num.getWeight()).count();
        long endTimesss = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTimesss - startTimesss)+"ms");
        long startTimes = System.currentTimeMillis();
        List<Apple> collect1 = appleLists.stream().filter(num -> 10 == num.getWeight()).collect(Collectors.toList());
        long endTimes = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTimes - startTimes)+"ms");
        long startTimese = System.currentTimeMillis();
        List<Apple> appleList=new ArrayList<>(16);
        for (Apple apple: appleList){
            if (10==apple.getWeight()){
                appleList.add(apple);
            }
        }
        long endTimese = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTimese - startTimese)+"ms");


//        System.out.println(count);
//        Collections.sort(appleLists,Comparator.comparing(Apple::getWeight).thenComparing(Apple::getBirthDay).reversed());
//        for (Apple apple:appleLists){
//            System.out.println(apple);
//        }


    }
}
