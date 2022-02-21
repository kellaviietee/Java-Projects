package ee.taltech.iti0202.tk0;

import java.util.ArrayList;
import java.util.List;

public class Test01EvenOdd {

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
    
}
