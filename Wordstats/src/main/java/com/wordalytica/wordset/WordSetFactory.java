package com.wordalytica.wordset;

import com.wordalytica.wordset.core.WordSet;
import com.wordalytica.wordset.v0.WordSetNoop;
import com.wordalytica.wordset.v1.WordSetV1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class WordSetFactory {
    private WordSetFactory() {
    }

    public static WordSet buildNoop() {
        return new WordSetNoop();
    }

    public static WordSet build(Object caller, String resource) {
        InputStream inputStream = caller.getClass().getClassLoader().getResourceAsStream(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Stream<String> words = reader.lines().map(s -> s.toLowerCase().trim());
        return build(words.iterator());
    }

    public static WordSet build(Iterator<String> words) {
        return new WordSetV1(words);
    }

    public static WordSet build(WordSet source) {
        return new WordSetV1(source.iterator());
    }

    public static WordSet build(List<String> words) {
        return build(words.iterator());
    }
}
