import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {
    public boolean check(String sentence) {
        return sentence.toLowerCase().chars().filter(Character::isLetter).distinct().count()==26;
    }

    public boolean check2(String sentence) {
        Set<Character> letters = new HashSet<>();

        for (Character ch: sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }
        return letters.size()==26;
    }
}
