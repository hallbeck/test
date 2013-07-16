package play;

/**
 * User: KHALLBEC
 * Date: 7/15/13
 * Time: 3:26 PM
 */
public class Main {
    public static void main(String[] args) {
        byte by = 0;
        short shrt = 1;
        int i = 10;
        long lg = 31;


        boolean boole = false;
        boole = true;

        boolean toBe = true;
        boole = toBe ||! toBe;
        if (boole) {
            //System.out.println(toBe);
        }
        String bool = String.valueOf(toBe);
        double d = 2;
        float flt = (float)d;
        char r = 'H';
        //H3110 w0r1d 2.0 true
        String output = (""+r + lg + i +" w"+by+ "r"+shrt+ "d "+flt +" "+ bool);

        System.out.println(output);

        int a = 4;
        int b = 5;
        boolean result;
        result = a < b; // true
        System.out.println(result);
        result = a > b; // false
        System.out.println(result);
        result = a <= 4 ;// a smaller or equal to 4 - true
        System.out.println(result);
        result = b >= 6 ;// b bigger or equal to 6 - false
        System.out.println(result);
        result = a == b ;// a equal to b - false
        System.out.println(result);
        result = a != b ;// a is not equal to b - true
        System.out.println(result);
        result = a > b || a > b ;// Logical or - true
        System.out.println(result);
        result = 3 < a && a < 6 ;// Logical and - true
        System.out.println(result);
        result = !result ;// Logical not - false
        System.out.println(result);
    }
}
