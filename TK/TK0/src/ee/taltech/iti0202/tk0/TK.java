package ee.taltech.iti0202.tk0;

import java.util.ArrayList;
import java.util.List;

public class TK {

    public List<Integer> evenOdd(List<Integer> nums){
        List<Integer> evenOdd = new ArrayList<>();
        for(Integer num:nums){
            if(num % 2 != 0){
                System.out.println(num);
                evenOdd.add(num);
            }
            else{
                evenOdd.add(0,num);
            }
        }
        return evenOdd;
    }

    public static void main(String[]args){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        TK tk = new TK();
        System.out.println(tk.evenOdd(numbers).toString());
    }
}
