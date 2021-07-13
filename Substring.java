/*
Implement strStr().
Return the 1st occurrence of the given substring in the given String or return -1 if not found.
 */
public class Substring {
    public static int strStr(String haystack, String needle) {

        /*if(haystack=="" || needle=="") return 0;

        int j=0, index=-1;

        for(int i=0; i<haystack.length() ; i++){
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;

                if(j == needle.length())
                    break;

                if(index == -1)
                    index = i;
            }else{
                index = -1;
                j = 0;
            }
        }
        return index;*/

        // if haystack is null or if haystack's length is less than that of needle's
        if (haystack == null || needle.length() > haystack.length()) {
            return -1;
        }

        // if needle is null or is empty
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String haystack = "mississippi", needle = "issip";

        System.out.println("First occurrence of the Substring is at index:" + strStr(haystack, needle));
    }
}
