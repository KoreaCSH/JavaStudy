public class CharToString {

    public static void main(String[] args) {
        char[] chArr = {'A', 'B', 'C'};
        String string = new String(chArr);
        System.out.println(string);

        for(int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            System.out.println("string.charAt("+i+"): " + ch);
        }

        char[] tmp = string.toCharArray();
        System.out.println(tmp);

    }

}
