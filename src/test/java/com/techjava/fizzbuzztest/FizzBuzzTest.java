package com.techjava.fizzbuzztest;


import com.techjava.fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The Class FizzBuzzTester.
 */
public class FizzBuzzTest {

    FizzBuzz fizzBuzz=new FizzBuzz();

    static List<Integer> multipleOf3;
    static List<Integer> multipleOf5;
    static List<Integer> commonMultiple;
    static List<Integer> restAllNumbers;

    @BeforeAll
    static void setup(){


        multipleOf3=getMultiples(1,100,3);
        multipleOf5=getMultiples(1,100,5);
        restAllNumbers=getMultiples(1,100,1);

        commonMultiple=new ArrayList<>(multipleOf3);
        commonMultiple.retainAll(multipleOf5);


        multipleOf3.removeAll(commonMultiple);
        multipleOf5.removeAll(commonMultiple);
        restAllNumbers.removeAll(commonMultiple);
        restAllNumbers.removeAll(multipleOf5);
        restAllNumbers.removeAll(multipleOf3);

    }

    static List<Integer> getMultiples(int min,int max,int multiple){
        return IntStream.rangeClosed(min,max).filter(m->m%multiple==0).boxed().collect(Collectors.toList());
    }


    @DisplayName("Test sample input numbers")
    @Test
    public void isConverterValidForOtherSampleNumbers(){

        assertEquals("1",fizzBuzz.converter(1));
        assertEquals("-1",fizzBuzz.converter(-1));
        assertEquals("98",fizzBuzz.converter(98));
    }


    @DisplayName("Test converter method for all inputs from 1 to 100")
    @Nested
    class AllInputsTest{
    @DisplayName("Test rest of numbers which are not multiples of 3,5")
    @Test
    public void isConverterValidForAllRestNumbers(){
       for(Integer n:restAllNumbers){
           assertEquals(String.valueOf(n),fizzBuzz.converter(n));
       }
    }

    @DisplayName("Test multiples of 3 for fizz")
    @Test
    public void isConverterValidForFizzNumbers(){
        for(Integer n:multipleOf3){
            assertEquals("Fizz",fizzBuzz.converter(n));
        }
    }

    @DisplayName("Test multiples of 5 for buzz")
    @Test
    public void isConverterValidForBuzzNumbers(){
        for(Integer n:multipleOf5){
            assertEquals("Buzz",fizzBuzz.converter(n));
        }
    }

    @DisplayName("Test common multiples of 3 & 5 for fizzbuzz")
    @Test
    public void isConverterValidForFizzBuzzNumbers(){
        for(Integer n:commonMultiple){
            assertEquals("FizzBuzz",fizzBuzz.converter(n));
        }
    }
    }




}
