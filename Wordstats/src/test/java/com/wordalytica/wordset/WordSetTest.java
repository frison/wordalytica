package com.wordalytica.wordset;

import com.wordalytica.wordset.core.WordSet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class WordSetTest {
    Function<List<String>, WordSet<?>> wordSetBuilder = (a) -> WordSetFactory.build(a, 2);
    @Test
    public void count() {
        WordSet<?> wordset = wordSetBuilder.apply(Arrays.asList("a", "b"));
        assertThat(wordset.count()).isEqualTo(2);
    }

    @Test
    public void longerThan() {
        WordSet<?> wordset = wordSetBuilder.apply(Arrays.asList("a", "b", "qq"));
        assertThat(wordset.longerThan(2).count()).isEqualTo(0);
        assertThat(wordset.longerThan(1).count()).isEqualTo(1);
    }

    @Test
    public void contains() {
        WordSet<?> wordset = wordSetBuilder.apply(Arrays.asList("a", "b", "bear", "apple"));
        assertThat(wordset.containing("a").count()).isEqualTo(3);
        assertThat(wordset.containing("b").count()).isEqualTo(2);
        assertThat(wordset.containing("p").count()).isEqualTo(1);
        assertThat(wordset.containing("z").count()).isEqualTo(0);
    }

    @Test
    public void startsWith() {
        WordSet<?> c = wordSetBuilder.apply(Arrays.asList("a", "b", "bear", "apple"));
        assertThat(c.startingWith("a").count()).isEqualTo(2);
        assertThat(c.startingWith("b").count()).isEqualTo(2);
    }

    @Test
    public void endsWith() {
        WordSet<?> c = wordSetBuilder.apply(Arrays.asList("sing", "king", "queen"));
        assertThat(c.endingWith("en").count()).isEqualTo(1);
        assertThat(c.endingWith("ing").count()).isEqualTo(2);
        assertThat(c.endingWith("sing").count()).isEqualTo(1);
    }

    @Test
    public void notEndingWith() {
        WordSet<?> c = wordSetBuilder.apply(Arrays.asList("sing", "king", "queen"));
        assertThat(c.notEndingWith("en").count()).isEqualTo(2);
        assertThat(c.notEndingWith("ing").count()).isEqualTo(1);
        assertThat(c.notEndingWith("sing").count()).isEqualTo(2);
    }

    @Test
    public void mergedPredicates() {
        WordSet<?> wordset = wordSetBuilder.apply(Arrays.asList("sing", "king", "queen"));
        assertThat(wordset.endingWith("een").startingWith("qu").count()).isEqualTo(1);
        assertThat(wordset.startingWith("k").endingWith("ing").count()).isEqualTo(1);
        assertThat(wordset.startingWith("z").endingWith("z").count()).isEqualTo(0);
    }
}