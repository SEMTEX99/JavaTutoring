public class Hello {
    public int solution(String inputtext) {
        String text = inputtext.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int count = 0;
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b') {
                b++;
            }
            if (text.charAt(i) == 'a') {
                a++;
            }
            if (text.charAt(i) == 'l') {
                l++;
            }
            if (text.charAt(i) == 'o') {
                o++;
            }
            if (text.charAt(i) == 'n') {
                n++;
            }
        }
        while (b >= 1 && a >= 1 && l >= 2 && o >= 2 && n >= 1) {
            count++;
            b--;
            a--;
            l = l - 2;
            o = o - 2;
            n--;
        }
        return count;
    }
}