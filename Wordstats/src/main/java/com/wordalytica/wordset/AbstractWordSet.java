package com.wordalytica.wordset;

import com.wordalytica.wordset.predicate.Predicate;
import com.wordalytica.wordset.predicate.PredicateBuilder;

abstract class AbstractWordSet<T extends AbstractWordSet<T>> implements WordSet {
    private PredicateBuilder predicateBuilder;

    public AbstractWordSet() {
        this.predicateBuilder = new PredicateBuilder();
    }

    protected Predicate predicate() {
        return predicate(false);
    }

    protected Predicate predicate(boolean reset) {
        Predicate predicate = this.predicateBuilder.build();
        PredicateBuilder builder = this.predicateBuilder;
        if(reset) {
            builder = new PredicateBuilder();
        }
        this.predicateBuilder = builder;
        return predicate;
    }

    @Override
    public WordSet longerThan(int minLength) {
        this.predicateBuilder.longerThan(minLength);
        return this;
    }

    @Override
    public WordSet containing(String value) {
        this.predicateBuilder.containing(value);
        return this;
    }

    @Override
    public WordSet endingWith(String value) {
        this.predicateBuilder.endingWith(value);
        return this;
    }

    @Override
    public WordSet startingWith(String value) {
        this.predicateBuilder.startingWith(value);
        return this;
    }

    @Override
    public WordSet notEndingWith(String value) {
        this.predicateBuilder.notEndingWith(value);
        return this;
    }

    @Override
    public WordSet matching(String placeHolded) {
        this.predicateBuilder.matching(placeHolded);
        return this;
    }


}
