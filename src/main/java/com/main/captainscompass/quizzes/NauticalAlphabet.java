package com.main.captainscompass.quizzes;

import com.main.captainscompass.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NauticalAlphabet {
    private static final int NUMBER_OF_QUESTIONS = 38;

    private static final String[] answers = new String[NUMBER_OF_QUESTIONS];
    private static final String[] characters = new String[NUMBER_OF_QUESTIONS];

    public static class QuizSet {
        private final String character;
        private final String answer;

        public QuizSet(String character, String answer) {
            this.character = character;
            this.answer = answer;
        }

        public String getCharacter() {
            return character;
        }

        public String getAnswer() {
            return answer;
        }
    }

    public static void init(String directory) {
        InputStream inStream = App.class.getResourceAsStream(directory + "/data.dat");
        if (inStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
                String line;
                int index = 0;
                while ((line = reader.readLine()) != null) {
                    if (index < 26) {
                        characters[index] = String.valueOf((char)('A' + index));
                    } else if (index < 36) {
                        characters[index] = String.valueOf(index-26);
                    } else if (index == 36) {
                        characters[index] = ". (decimal separator)";
                    } else {
                        characters[index] = ". (period)";
                    }

                    answers[index] = line;
                    index++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Could not read nautical alphabet quiz data");
        }
    }

    public static QuizSet getRandomQuizSet() {
        int randNumber = (int)(Math.random() * NUMBER_OF_QUESTIONS);
        return new QuizSet(characters[randNumber], answers[randNumber]);
    }
}
