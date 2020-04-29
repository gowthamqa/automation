package interview;

public class ReverseWordsInAString {

    public static void main(String[] args) {
        //System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWordsFastest("a good   example"));
    }

    public static String reverseWords(String s) {
        String result = "";
        String[] temp = s.split(" ");
        for (int i = temp.length-1;i >= 0;i--){
            if (!temp[i].isEmpty()){
                if(i == temp.length-1){
                    result = result + temp[i];
                }else {
                    result = result +" "+ temp[i];
                }
            }
        }
        return result;
    }
    public static String reverseWordsFastest(String s) {
        if(s != null && !s.isEmpty()) {
            StringBuilder res = new StringBuilder();
            String[] strsplit = s.split(" ");
            for (int i = strsplit.length -1 ; i >=0; i--) {
                if(!strsplit[i].isEmpty() && !strsplit[i].equals(" ")) {
                    res.append(i != strsplit.length -1 ? " " : "");
                    res.append(strsplit[i]);
                }
            }
            return res.toString();
        }
        return "";
    }
}
