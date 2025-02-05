
public class ReverseWordInPlace {
    public static void main(String[] args) {

        char[] input = "i love programming very much".toCharArray();
        reverseWords(input);
        System.out.println(new String(input));
    }

    public static void reverseWords(char[] characters) {
        int wordStart = 0;

        for (int index = 0; index <= characters.length; index++) {
            if (index == characters.length || characters[index] == ' ') {
                reverseRange(characters, wordStart, index - 1);
                wordStart = index + 1;
            }
        }
    }

    private static void reverseRange(char[] characters, int left, int right) {
        while (left < right) {
            swapCharacters(characters, left++, right--);
        }
    }

    private static void swapCharacters(char[] characters, int firstIndex, int secondIndex) {
        characters[firstIndex] ^= characters[secondIndex];
        characters[secondIndex] ^= characters[firstIndex];
        characters[firstIndex] ^= characters[secondIndex];
    }
}
