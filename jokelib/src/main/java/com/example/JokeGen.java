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
        jokes = new String[] {
                "What's the best thing about Switzerland?\nI don't know, but the flag is a big plus",
                "I invented a new word!\nPlagiarism!",
                "Helvetica and Times New Roman walk into a bar...\n\"Get out of here!\" shouts the bartender. \"We don't serve your type.",
                "Knock! Knock!\nWho's there?\nControl Freak.\nCon...\nOkay, now you say, \"Control Freak who?\"",
                "Hear about the new restaurant called Karma?\nThere’s no menu: You get what you deserve."
        };
    }

    public String getJoke() {
        if (id == jokes.length) {
            id = 0;
        }

        return jokes[id++];
    }
}
