package com.aaroncrutchfield.jokes;

import java.util.Random;

public class MyJokes {

    String[] jokes = {
            "I spilled spot remover on my dog, now he's gone...",
            "Are you the square root of -1? Because you can't be real.",
            "Why do developers have high insurance rates? \n Because they're always crashing."
    };

    public String getJoke() {
        int index = getRandomNumber(0, jokes.length-1);
        return jokes[index];
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        int num = random.nextInt((max - min) + 1) + min;
        return num;
    }
}
