package com.wordalytica.wordset.v0;

import com.wordalytica.wordset.core.WordSet;

import java.util.Collections;
import java.util.Iterator;

// This class should serve as the lower bound for performance measure. We'll never beat
// the speed of this class.
public class WordSetNoop implements WordSet {
    @Override
    public Iterator<String> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public WordSet longerThan(int minLength) {
        return this;
    }

    @Override
    public WordSet containing(String value) {
        return this;
    }

    @Override
    public WordSet endingWith(String value) {
        return this;
    }

    @Override
    public WordSet startingWith(String value) {
        return this;
    }

    @Override
    public WordSet notEndingWith(String value) {
        return this;
    }

    @Override
    public WordSet matching(String placeHolded) {
        return this;
    }
}
