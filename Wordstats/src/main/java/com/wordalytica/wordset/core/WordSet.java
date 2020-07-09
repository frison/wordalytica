package com.wordalytica.wordset.core;

import java.util.Iterator;

public interface WordSet {
    Iterator<String> iterator();

    int count();

    WordSet longerThan(int minLength);

    WordSet containing(String value);

    WordSet endingWith(String value);

    WordSet startingWith(String value);

    WordSet notEndingWith(String value);

    WordSet matching(String placeHolded);
}
