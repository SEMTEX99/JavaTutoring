public class Hello {
    public int solution(String inputtext, String inputword) {
        String randomChar = inputtext.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String word = inputword.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int count = 0;
        int[] randomCharCount = new int[26];
        int[] wordCount = new int[26];
        for (int i = 0; i < randomChar.length(); i++) {
            randomCharCount[randomChar.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word.length(); i++) {
            wordCount[word.charAt(i) - 'a']++;
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
        return count;
    }
}