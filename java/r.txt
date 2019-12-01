import java.util.*;

public class Main {
    
    public static String reverse(String str,int left,int right) {
        char[] value = str.toCharArray();
        while (left < right) {
            char tmp = value[left];
            value[left] = value[right];
            value[right] = tmp;
            left++;
            right--;
        }
        return String.copyValueOf(value);
    }
    
    public static String func(String str,int k) {
        if(str == null || k <= 0) {
            return null;
        }
        str = reverse(str,0,k-1);//
        str = reverse(str,k,str.length()-1);
        str = reverse(str,0,str.length()-1);
        return str;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String str = scan.nextLine();
        String ret = func(str,k);
        System.out.println(ret);
    }
}
