import java.util.Arrays;
import java.util.Locale;

public class Caesar {
    private final int ALPHABET = 26;
    private final int ASCII_A_START = 65;
    private final int REPLACE_OFFSET = 3;

    public String encrypt(String message){
        char[] chars = message.toUpperCase(Locale.ROOT).toCharArray();
        for(int i=0;i<chars.length;i++){
            int c = chars[i];
            int replace_char = ((c+REPLACE_OFFSET)%ASCII_A_START%ALPHABET) + ASCII_A_START;
            chars[i] = intToChar(replace_char);
        }

        return new String(chars);
    }

    public String decrypt(String message){
        char[] chars = message.toUpperCase(Locale.ROOT).toCharArray();
        for(int i=0;i<chars.length;i++){
            int c = chars[i];
            int replace_char = ((c-REPLACE_OFFSET)%ASCII_A_START%ALPHABET) + ASCII_A_START;
            chars[i] = intToChar(replace_char);
        }

        return new String(chars);
    }


    private char intToChar(int i){
        return (char) i;
    }
}
