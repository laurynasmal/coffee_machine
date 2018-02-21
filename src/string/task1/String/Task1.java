package string.task1.String;

import java.util.Scanner;

public class Task1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args){
//        System.out.println(";"+DeleteSpaceInString(" test ")+";");
//
//        System.out.println(CheckIfStartsEndsABC("drfegabc"));
//        System.out.println(CheckIfThereText("text"));
        System.out.println(ABCToDEF("abcrtf"));
    }


    public static void PrintStringLength(String a){
        System.out.println("Teksto ilgis yra"+a.length());
    }

    public static void PrintLetterIndex(String a){
        System.out.println("A raides pirmas indeksas"+a.indexOf("a"));
    }

    public static void PrintLetrerIndexLast(String a){
        //int i = a.length();
        StringBuilder temp = new StringBuilder(a.length());
        temp.append(a);
        temp.reverse();
        System.out.println("");
        String b=temp.toString();
        System.out.println("A raides pirmas indeksas"+b.indexOf("a"));
    }

    public static String DeleteSpaceInString(String a){
        //int i = a.length();
        StringBuilder temp = new StringBuilder(a.length());
        temp.append(a);
        if (a.substring(0, 1).equals(" ")){
            temp=temp.deleteCharAt(0);
        }
        if (a.substring(a.length()-1,a.length() ).equals(" ")){
            temp=temp.deleteCharAt(temp.length()-1);
        }
        return temp.toString();
    }

    public static String ChangeLetterBigToSmall(String a){
        System.out.println("Jei norit paversti didesnem raidem parasykit - taip, jei mazesnem - ne");
        String x = scanner.next();
        if (x.equals("taip")){
            return a.toUpperCase();
        }
        if (x.equals("ne")){
            return a.toLowerCase();
        } else {
            return "netinkamai pasirinkta";
        }
    }
    public static boolean CheckIfStartsEndsABC(String a){
        return (a.substring (0,3).equals("abc"))||(a.substring (a.length()-3,a.length()).equals("abc"));
    }

    public static boolean CheckIfThereText(String a){
        String temp="text";
        return (a==temp);
    }

    public static String ABCToDEF(String a){
        String temp = a;
        String front,mid;
        StringBuilder temp1 = new StringBuilder(a.length());
        for (int i=0;i<a.length()-3;i++){
            if(temp.substring(i,i+3).equals("abc")){
                temp1.append(temp);
                temp1.replace(i,i+3, "def");
                temp=temp1.toString();
            }
        }
        return temp;
    }

}
