package com.wordalytica.wordset;

import java.util.Iterator;
import java.util.NavigableMap;

public class WordSetV2 implements WordSet {
    NavigableMap<Integer, WordSetV2> lengthToWordSet;
    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public WordSet longerThan(int minLength) {
        return null;
    }

    @Override
    public WordSet containing(String value) {
        return null;
    }

    @Override
    public WordSet endingWith(String value) {
        return null;
    }

    @Override
    public WordSet startingWith(String value) {
        return null;
    }

    @Override
    public WordSet notEndingWith(String value) {
        return null;
    }

    @Override
    public WordSet matching(String placeHolded) {
        return null;
    }
}
