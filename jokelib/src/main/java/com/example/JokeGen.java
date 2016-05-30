package com.example;

public class JokeGen {

    private int id;
    private String[] jokes;
    private static JokeGen jokeGen;

    public static JokeGen newInstance() {
        if (jokeGen == null) {
            jokeGen = new JokeGen();
        }
        return jokeGen;
    }

    private JokeGen() {
        init();
    }

    private void init() {
        jokes = new String[] {"joke1", "joke2", "joke3", "joke4", "joke5"};
    }

    public String getJoke() {
        if (id == jokes.length) {
            id = 0;
        }

        return jokes[id++];
    }
}
