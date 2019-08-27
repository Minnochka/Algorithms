public class Sqr {



    public static void main(String[] args){

        int a = 12;

        double b = 11.3535;

        System.out.println("0 ^ 0 = " + sqr(0, 0));

        System.out.println("0 ^ (-1) = " + sqr(0, -1));

        System.out.println(a + " ^ 0 = " + sqr(a, 0));

        System.out.println(a + " ^ 3 = " + sqr(a, 3));

        System.out.println(a + " ^ (-5) = " + sqr(a, -5));

        System.out.println(b + " ^ 10 = " + sqr(b, 10));

        System.out.println(b + " ^ (-2) = " + sqr(b, -2));

    }



    private static String sqr(double num, int level){

        String res;

        if(num == 0 && level < 0){

            res = "∞";

        }

        else if (level >= 0){

            res = "" + getSqr(1, num, level);

        }

        else{

            res = "" + (1 / getSqr(1, num, level*(-1)));

        }

        return res;

    }







    private static double getSqr(double res, double num, int level){

        if (level == 0.0){

            return res;

        }

        res*= num;

        //System.out.println(res + " - " + level);

        level--;

        res = getSqr(res, num, level);

        return res;

    }

}