package Revature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreditCard {

    public static boolean checkCard(String ccNumber){
        int length = ccNumber.length();
        int check = 0;
        List<Integer> nums = new ArrayList<>();

        if(length >= 14 && length <= 19){
            for(int i = 0; i < length; i++){
                nums.add(ccNumber.charAt(i) - '0');

            }
            check = nums.get(length - 1);
            nums.remove(length - 1);
            Collections.reverse(nums);


            for(int i = 0; i < length; i += 2){
                int sum = nums.get(i) * 2;
                if(sum < 10){
                    nums.set(i, sum);
                }else{
                    int sum2 = 0;
                    while(sum != 0){
                        sum2 = sum2 + sum % 10;
                        sum = sum / 10;
                    }
                    nums.set(i, sum2);
                }

            }
            int sumAll = 0;
            for(int i = 0; i < length - 1; i++){
                sumAll += nums.get(i);
            }
            System.out.println("Last Step = " + (10 - (sumAll % 10)));
            System.out.println("Checked Number = " + check);
            if((10 - (sumAll % 10)) ==  check){
                return true;
            }else{
                return false;
            }


        }else{
            return false;
        }
       
    }

    public static void main(String[] args) {
        String creditCardNumber = "1234567890123452";
        //checkCard(creditCardNumber);
        System.out.println(checkCard(creditCardNumber));
    }
}
