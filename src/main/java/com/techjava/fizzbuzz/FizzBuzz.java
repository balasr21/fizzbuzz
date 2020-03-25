package com.techjava.fizzbuzz;

/**
 * The class FizzBuzz.
 *
 */
public class FizzBuzz {

    /**
     * converter - This method converts value to fizzbuzz
     *
     * If the given value is a multiple of 3 ,"Fizz" will be returned
     * If the given value is a multiple of 5,"Buzz" will be returned
     * If the given value is a multiple of 3 & 5,"FizzBuzz" will be returned
     *
     * @param value
     * @return
     */
    public String converter(Integer value){

        boolean isFizz=(value%3==0);
        boolean isBuzz=(value%5==0);
        boolean isFizzBuzz=(value%15==0);

        if(isFizzBuzz){
            return "FizzBuzz";
        }else if(isFizz){
            return "Fizz";
        }else if(isBuzz){
            return "Buzz";
        }else{
            return String.valueOf(value);
        }
    }

}
