package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Algorythm {
    public int solution(String inputtext, String inputword) {
        log.info("Algorythm class is executing");
        log.info("input data cleanup right before forwarding it to the algorythm");
        String randomChar = inputtext.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String word = inputword.replaceAll("[^a-zA-Z]", "").toLowerCase();
        log.info("Data has been cleaned");
        int count = 0;
        int[] randomCharCount = new int[26];
        int[] wordCount = new int[26];
        for (int i = 0; i < randomChar.length(); i++) {
            randomCharCount[randomChar.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
            log.info("the word count was"+ wordCount);
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] != 0) {
                if (randomCharCount[i] / wordCount[i] > 0) {
                    count = randomCharCount[i] / wordCount[i];
                } else {
                    return 0;
                }
            }
        }
        log.info("Algorythm class was executed successfully, the output was "+ count);
        return count;
    }
}