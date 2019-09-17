package com.sortedcoder.java.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Streams {

    public void map() {
        List list = List.of("a","b","c","d","e");

        // Example 1
        list.stream().map(new Function<String,String>(){
            @Override
            public String apply(String i) {
                return i+"-mapped";
            }
        });

        // This is exactly the same as example 1, removing boilerplate code
        list.stream().map(i->{return i+"-mapped";});

        // This is exactly the same as example 1, removing more boilerplate code
        list.stream().map(i->i+"-mapped");

    }

    public void infiniteStreams() {
        Stream<Character> stringStream = Stream.generate(new Supplier<>() {
            // This char is just a byte storing the number 65, ASCII code for 'A'
            private char number='A';

            @Override
            public Character get() {
                number = number >= ('Z') ? 'A' : ++number;
                //generates A, B, C , D
                return Character.toChars(number)[0];
            }
        });
        stringStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Streams s = new Streams();
        s.infiniteStreams();
    }
}
