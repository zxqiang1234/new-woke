package test.OtherTest;

import org.apache.poi.hssf.record.OldFormulaRecord;

import java.util.*;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = strReplace(l1.val+"");
        String s2 = strReplace(l2.val+"");
        String s3= new String(String.valueOf(Integer.parseInt(s1)+Integer.parseInt(s2)));
        String s = strReplace(s3);

        return new ListNode(Integer.parseInt(s));
    }
    public int lengthOfLongestSubstring(String s) {
        char[] ss =s.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<>();

        for (int i=0;i<ss.length;i++){
            hashMap.put(ss[i],i);
        }
        Object[] objects = hashMap.keySet().toArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<objects.length;i++){
            stringBuilder.append(objects[i]);
        }



        int max = 0;
        int count = 1;
        int start = 0;
        ;
        for(int i=1; i<stringBuilder.toString().length(); i++){
            char pre = stringBuilder.toString().charAt(i-1);
            char now = stringBuilder.toString().charAt(i);
            if(now-pre>=0){
                count++;
            }else{
                if(max<count){
                    max = count;
                    start = i-count;
                }
                count = 1;
            }
        }
//这里还需要比较一次，因为如果从某个字符到最后一个都是增序，会导致不会进入else更新max
        max = max>count?max:count;
        StringBuilder stringBuilders=new StringBuilder();
        for(int i=start; i<start+max; i++){
            stringBuilders.append(stringBuilder.toString().charAt(i));
        }
        return hashMap.size();

    }


    private String strReplace(String val1) {
        String ss1=null;
        char [] array = val1.toCharArray();
        for(int i = 0;i<val1.length()/2;i++){
            array[i] = val1.charAt(val1.length()-1-i);
            array[val1.length()-1-i] = val1.charAt(i);
        }
        ss1 =new String(array);
        return ss1;
    }

    public void rotate(int[][] matrix) {
         int[][] temp={{7,4,1},{8,5,2},{9,6,3}};
     List<Integer> list=new ArrayList<>();
//     list=temp[1]
    }


}
