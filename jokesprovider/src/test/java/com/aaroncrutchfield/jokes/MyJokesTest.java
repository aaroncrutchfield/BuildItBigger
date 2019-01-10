package com.aaroncrutchfield.jokes;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyJokesTest {

    String[] jokes = {
            "I spilled spot remover on my dog, now he's gone...",
            "Are you the square root of -1? Because you can't be real.",
            "Why do developers have high insurance rates? \n Because they're always crashing."
    };

    @Test
    public void testGetJoke() {
        String joke = new MyJokes().getJoke();

        assertTrue(
                joke.equals(jokes[0]) ||
                joke.equals(jokes[1]) ||
                joke.equals(jokes[2])
        );
    }

    @Test
    public void testGetRandomNumber() {
        int min = 0;
        int max = jokes.length - 1;

        MyJokes myJokes = new MyJokes();
        int num = myJokes.getRandomNumber(min, max);

        assertTrue(num >= min && num <= max);
    }
}