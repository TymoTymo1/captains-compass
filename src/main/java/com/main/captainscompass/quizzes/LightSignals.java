package com.main.captainscompass.quizzes;

import com.main.captainscompass.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class LightSignals {
    public static final int NUMBER_OF_QUESTIONS = 18;

    private static String[] files = new String[NUMBER_OF_QUESTIONS];
    private static String[] answers = new String[NUMBER_OF_QUESTIONS];
    private static Random random = new Random();

    public static class QuizSet {
        String file;

        String[] possibleAnswers;

        public QuizSet(String file, String[] possibleAnswers) {
            this.file = file;
            this.possibleAnswers = possibleAnswers;
        }

        public String getFile() {
            return file;
        }

        public String[] getPossibleAnswers() {
            return possibleAnswers;
        }
    }

    public static void init(String directory) {

        String dataDir = "/data/";
        String imgDir = "/images/";

        InputStream inStream = App.class.getResourceAsStream(directory + dataDir + "data.dat");

        if (inStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split("-");
                    int number = Integer.parseInt(tokens[0]);
                    String answer = tokens[1];

                    answers[number-1] = answer;
                    files[number-1] = directory + imgDir + number + ".png";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Could not load quiz data");
        }
    }

    public static QuizSet getRandomQuizSet() {
        int randNumber = random.nextInt(NUMBER_OF_QUESTIONS);

        String file = files[randNumber];
        String[] possibleAnswers = new String[3];

        String correctAnswer = files[randNumber];
        possibleAnswers[0] = correctAnswer;

        int index = 1;
        do {
            int newRand = random.nextInt(NUMBER_OF_QUESTIONS);
            String ans = answers[newRand];
            if (!Arrays.asList(possibleAnswers).contains(ans)) {
                possibleAnswers[index] = ans;
                index++;
            }
        } while (index < 2);

        return new QuizSet(file, possibleAnswers);
    }
}
