package com.techjava.fizzbuzz;

import java.util.stream.IntStream;

public class Main {

    static FizzBuzz fizzBuzz=new FizzBuzz();

    public static void main(String[] args) {

        IntStream.rangeClosed(1,100).boxed().forEach(val-> System.out.println(fizzBuzz.converter(val)));

    }

}
