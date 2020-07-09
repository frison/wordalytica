package com.wordalytica.wordset;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String [] args) {
        Main main = new Main();

        InputStream inputStream = main.getClass().getClassLoader().getResourceAsStream("words.all");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Stream<String> a = reader.lines().map(s -> s.toLowerCase().trim());
        WordSet AllWords = WordSetFactory.build(a.iterator());
        AllWords.endingWith("alcy").iterator().forEachRemaining(System.out::println);
        System.out.println(AllWords.endingWith("alcy").count());
    }
}
