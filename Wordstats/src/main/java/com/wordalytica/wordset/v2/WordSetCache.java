package com.wordalytica.wordset.v2;

import com.wordalytica.wordset.core.WordSet;
import com.wordalytica.wordset.predicate.Predicate;

import java.util.HashMap;
import java.util.Map;

public class WordSetCache {
    private final WordSet wordSet;
    private final Map<String, WordSetCache> cache = new HashMap<String, WordSetCache>();
    public WordSetCache(WordSet wordSet) {
        this.wordSet = wordSet;
    }

    public void cache(Predicate predicate) {

    }

    public boolean isCached(Predicate predicate) {
        return false;
    }

    // Lower is a better cache to use
    public Integer cacheScore(Predicate predicate) {
        return Integer.MAX_VALUE;
    }
}
