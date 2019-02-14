package test.IoTest;

import java.util.UUID;

/**
 * @description: salkjd
 * @author: xuqiang
 * @createDate: 2019-01-12 12:00
 **/
public class UUIDGenrateUtil {
    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
            "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
            "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z" };

    public synchronized static String generateShortUuid(){
        StringBuffer shortBuffer=new StringBuffer();
        String uuid=UUID.randomUUID().toString().replace("-","");
        for(int i=0;i< 4;i++){
            String str=uuid.substring(i*4,i*4+4);
            int x=Integer.parseInt(str,16);
            shortBuffer.append(chars[x%0x3E]);
        }
        return shortBuffer.toString();
    }
}
