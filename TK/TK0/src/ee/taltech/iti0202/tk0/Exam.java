package ee.taltech.iti0202.tk0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Exam {


    /**
     * Return a list that contains the exact same numbers as the given list, but rearranged so that
     * all the even numbers come before all the odd numbers. Other than that, the numbers can be in
     * any order. You may modify and return the given list, or make a new list.
     * <p>
     * <p>
     * evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
     * evenOdd([3, 3, 2]) → [2, 3, 3]
     * evenOdd([2, 2, 2]) → [2, 2, 2]
     */
    public static List<Integer> evenOdd(List<Integer> nums) {
        List<Integer> evenOdd = new ArrayList<>();
        for (Integer num:nums) {
            if (num % 2 != 0) {
                System.out.println(num);
                evenOdd.add(num);
            } else {
                evenOdd.add(0, num);
            }
        }
        return evenOdd;
    }


    /**
     * Given 3 int values, a b c, return their sum. However, if one of the values is the same as another of the values,
     * it does not count towards the sum.
     * <p>
     * loneSum(1, 2, 3) → 6
     * loneSum(3, 2, 3) → 2
     * loneSum(3, 3, 3) → 0
     */
    public static int loneSum(int a, int b, int c) {
        int sum = 0;
        if (a != b && a != c) {
            sum += a;
        }
        if (b != c && b != a) {
            sum += b;
        }
        if (c != a && c != b) {
            sum += c;
        }
        return sum;
    }


    /**
     * A sandwich is two pieces of bread with something in between. Return the string that is between the first and
     * last appearance of "bread" in the given string, or return the empty string ""
     * if there are not two pieces of bread.
     * <p>
     * getSandwich("breadjambread") → "jam"
     * getSandwich("xxbreadjambreadyy") → "jam"
     * getSandwich("xxbreadyy") → ""
     */
    public static String getSandwich(String str) {
        int firstBread = str.indexOf("bread");
        int lastBread = str.lastIndexOf("bread");
        if (firstBread == -1 || firstBread == lastBread) {
            return "";
        }
        return str.substring(firstBread + 5, lastBread);
    }


    /**
     * Given a map of food keys and topping values, modify and return the map as follows: if the key
     * "ice cream" is present, set its value to "cherry". In all cases, set the key "bread"
     * to have the value "butter".
     * <p>
     * <p>
     * topping({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
     * topping({}) → {"bread": "butter"}
     * topping({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
     */
    public static Map<String, String> topping(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.replace("ice cream", "cherry");
        }
        map.put("bread", "butter");
        return map;
    }



    public static void main(String[]args) {
        Map<String, String> map = new HashMap<>();
        map.put("pancake", "syrup");
        System.out.println(topping(map));
    }
}
