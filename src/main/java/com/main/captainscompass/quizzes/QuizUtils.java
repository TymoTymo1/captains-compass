package com.main.captainscompass.quizzes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizUtils {
    public static List<Integer> generateRandomSequence(int num) {
        List<Integer> numbers = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
