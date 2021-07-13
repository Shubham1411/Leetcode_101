/*
Given two binary strings a and b, return their sum as a binary string.
 */
import java.util.*;
public class AddBinary {
    public static String addBinary(String a, String b) {

       /* //String result = "";
        char [] ch1 = a.toCharArray();
        char [] ch2 = b.toCharArray();
        char carry = '0';
        char temp = '0';

        int l1 = ch1.length-1;
        int l2 = ch2.length-1;

        //List<Character> intermediate = new ArrayList<>();
        char [] intermediate = new char[l1+l2];
        int k = 0;

        while(l1>=0 && l2>=0){
            if(ch1[l1]=='0' && ch1[l2]=='0'){
                temp = '0';
                if(carry == '1')
                    temp = '1';

                intermediate[k++] = temp;
                temp = '0';
                carry = '0';
                l1--;
                l2--;
            }

            if((ch1[l1]=='1' && ch1[l2]=='0')||(ch1[l1]=='0' && ch1[l2]=='1')){
                temp = '1';
                if(carry == '1'){
                    temp = '0';
                    carry = '1';
                }
                intermediate[k++] = temp;
                temp = '0';
                l1--;
                l2--;
            }

            if(ch1[l1]=='1' && ch2[l2]=='1'){
                temp = '0';
                if(carry == '1'){
                    temp = '1';
                }
                intermediate[k++] = temp;
                temp = '0';
                carry = '1';
                l1--;
                l2--;
            }
        }

        String result = new String(intermediate);

        return result;*/

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1, j = b.length() -1, carry = 0;

        while (i >= 0 || j >= 0) {
            //if there is a carry from the last addition, add it to carry
            int sum = carry;

            //we subtract '0' to get the int value of the char from the ascii
            //ASCII of '0' is 48
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        //leftover carry, add it
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String a = "11111";
        String b = "1";

        System.out.println("After binary Addition:"+ addBinary(a,b));

    }
}
