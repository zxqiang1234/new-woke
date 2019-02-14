package Search;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-21 16:33
 **/
public class Search {

    private static final String UNIT = "万仟佰拾亿仟佰拾万仟佰拾圆角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9999999999999.99D;

    class IndexType {
        public int key;
        // 分块中的最大值
        public int link;
        // 分块的起始位置
    }
    //cesgu

    public IndexType[] createIndex(int[] list, int n, int gap) {
                int i = 0, j = 0, max = 0;
                int num = n / gap;
                IndexType[] idxGroup = new IndexType[num];
                // 根据步长数分配索引数组大小

                while (i < num) {
                         j = 0;
                         idxGroup[i] = new IndexType();
                         idxGroup[i].link = gap * i;
                         // 确定当前索引组的第一个元素位置
                         max = list[gap * i];
                         // 每次假设当前组的第一个数为最大值
                         // 遍历这个分块，找到最大值
                         while (j < gap) {
                               if (max < list[gap * i + j]) {
                                         max = list[gap * i + j];
                                     }
                                 j++;
                             }
                             idxGroup[i].key = max;
                        i++;
                    }

                 return idxGroup;
             }

    public int blockSearch(IndexType[] idxGroup, int m, int[] list, int n, int key) {
        int mid = 0;
        int low = 0;
        int high = m - 1;
        int gap = n / m;
        // 分块大小等于线性表长度除以组数

        // 先在索引表中进行二分查找，找到的位置存放在 low 中
        while (low <= high) {
            mid = (low + high) / 2;
            if (idxGroup[mid].key >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // 在索引表中查找成功后，再在线性表的指定块中进行顺序查找
        if (low < m) {
            for (int i = idxGroup[low].link; i < idxGroup[low].link + gap; i++) {
                if (list[i] == key) {
                    return i;
                }

            }
        }

        return -1;
    }
    public void printAll(int[] list) {
                for (int value : list) {
                     System.out.print(value + " ");
                 }
                System.out.println();
            }

    // 打印索引表
     public void printIDX(IndexType[] list) {
                System.out.println("构造索引表如下：");
                for (IndexType elem : list) {
                         System.out.format("key = %d, link = %d\n", elem.key, elem.link);
                     }
                 System.out.println();
             }

    public int binarySearch(int[] list, int length, int key) {
        int low = 0, mid = 0, high = length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (list[mid] == key) {
                return mid;
                // 查找成功，直接返回位置
            } else if (list[mid] < key) {
                low = mid + 1;
                // 关键字大于中间位置的值，则在大值区间[mid+1, high]继续查找
            } else {
                high = mid - 1;
                // 关键字小于中间位置的值，则在小值区间[low, mid-1]继续查找
            }
        }
        return -1;
    }

    public static String change(double v) {
        if (v < 0 || v > MAX_VALUE) {
            return "参数非法!";
        }
        long l = Math.round(v * 100);
        if (l == 0) {
            return "零元整";
        }
        String strValue = l + "";
        // i用来控制数
        int i = 0;
        // j用来控制单位
        int j = UNIT.length() - strValue.length();
        String rs = "";
        boolean isZero = false;
        for (;i < strValue.length(); i++, j++) {
            char ch = strValue.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '万' || UNIT.charAt(j) == '元') {
                    rs = rs + UNIT.charAt(j);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs = rs + "零";
                    isZero = false;
                }
                rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
            }
        }
        if (!rs.endsWith("分")) {
            rs = rs + "整";
        }
        rs = rs.replaceAll("亿万", "亿");
        return rs;
    }


    public static void main(String[] args) {

       change(1234554454544.00);
        String[] source = { "aaa", "bbb", "aaa", "ccc", "bbb", "ddadd", "ccc", "aaa", "bbb", "ddd" };
        Set<String> strings=new TreeSet<>();
        for (int i = 0; i < source.length; i++) {
            strings.add(source[i]);
        }
        String[] strings1 =new String[strings.size()];
         strings.toArray(strings1);

        String test = "hello";



        List<Integer> nums = Lists.newArrayList(1, null, 3, 4, null, 6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println(count);


        int key = 85;


        int array[] = { 8, 14, 6, 9, 10, 22, 34, 18, 19, 31, 40, 38, 54, 66, 46, 71, 78, 68, 80, 85 };

        Search search=new Search();
        long startTime = System.currentTimeMillis();
        System.out.println(search.binarySearch(array,array.length,key));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");

                System.out.print("线性表: ");
                search.printAll(array);
        long startTimes = System.currentTimeMillis();
                IndexType[] idxGroup = search.createIndex(array, array.length, 5);
                search.printIDX(idxGroup);
        long endTimes = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTimes - startTimes)+"ms");
                int pos = search.blockSearch(idxGroup, idxGroup.length, array,
                        array.length, key);

                if (-1 == pos) {
                       System.out.format("查找key = %d失败", key);
                   } else {
                       System.out.format("查找key = %d成功，位置为%d", key, pos);
                   }
    }
}
