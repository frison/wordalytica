package com.wordalytica.wordset;

import java.util.Iterator;
import java.util.List;

public class WordSetFactory {
    private WordSetFactory() {
    }

    public static WordSet build(Iterator<String> words) {
        return new WordSetV1(words);
    }

    public static WordSetV1 build(WordSet source) {
        return new WordSetV1(source.iterator());
    }

    public static WordSet build(List<String> words) {
        return build(words.iterator());
    }
}
