package com.wordalytica.wordset;

import com.wordalytica.wordset.core.WordSet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    public static void main(String [] args) {
        Main main = new Main();

        WordSet<?> AllWords = WordSetFactory.build(main, "words.all", 2);
        AllWords.endingWith("ing").iterator().forEachRemaining(System.out::println);
        System.out.println(AllWords.endingWith("ing").count());
    }
}
