
class CompareString {


    public static void main(String[] args) {

    /* create strings */
    String str1 = "hello";

    String str2 = str1;

    String str3 = new String("hello");

    StringBuffer str4 = new StringBuffer("hello");

    StringBuilder str5 = new StringBuilder("hello");


    /* check equality */

    System.out.println(str1 == str2);

    System.out.println(str1 == str3);

    System.out.println(str2 == str3);

    System.out.println(str1.equals(str2));

    System.out.println(str1.equals(str3));

    System.out.println(str3.equals(str4));

    System.out.println(str3.equals(str5.toString()));

    }
}
