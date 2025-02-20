package utils;

import model.Dictionary;
import model.DynamicDictionary;
import model.DynamicStack;
import model.Set;
import model.nodes.DictionaryNode;

import java.util.HashMap;
import java.util.Map;

public class DictionaryUtil {

    public static void print(Dictionary dictionary) {
        Set keys = dictionary.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            int value = dictionary.get(key);
            System.out.println("key: " + (char) key + ", value: " + value);
            keys.remove(key);
        }
    }

    private static final String ALPHABET = "abcdefghijklmnñopqrstuvwxyz";

    public static String returnTextWithoutShift(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                c = Character.toLowerCase(c);
                int index = ALPHABET.indexOf(c);
                if (index != -1) {
                    char newChar = ALPHABET.charAt((index + shift) % ALPHABET.length());
                    encrypted.append(isUpperCase ? Character.toUpperCase(newChar) : newChar);
                } else {
                    encrypted.append(c);
                }
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static String decryptCesar(String encryptedText) {
        DynamicDictionary frequencyDict = new DynamicDictionary();
        for (char c : encryptedText.toCharArray()) {
            if (Character.isLetter(c)) {
                try {
                    frequencyDict.add(c, 1);
                } catch (RuntimeException e) {
                    frequencyDict.add(c, frequencyDict.get(c) + 1);
                }
            }
        }

        char mostFrequent = 'e';
        int maxFrequency = 0;
        DictionaryNode node = frequencyDict.getHeadNode();
        while (node != null) {
            if (node.getValue() > maxFrequency) {
                mostFrequent = (char) node.getKey();
                maxFrequency = node.getValue();
            }
            node = node.getNext();
        }

        int shift = (ALPHABET.indexOf(mostFrequent) - ALPHABET.indexOf('e') + ALPHABET.length()) % ALPHABET.length();
        return returnTextWithoutShift(encryptedText, ALPHABET.length() - shift);
    }

    public static boolean isBalanced(String expression) {
        DynamicStack stack = new DynamicStack();
        boolean insideQuotes = false;
        char quoteChar = ' ';

        for (char c : expression.toCharArray()) {
            if (c == '"' || c == '\'') {
                if (insideQuotes && c == quoteChar) {
                    insideQuotes = false;
                } else if (!insideQuotes) {
                    insideQuotes = true;
                    quoteChar = c;
                }
            }

            if (!insideQuotes) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.add(c);
                } else if (c == ')' || c == '}' || c == ']') {
                    if (stack.isEmpty()) return false;
                    char open = (char) stack.getTop();
                    stack.remove();
                    if ((c == ')' && open != '(') ||
                            (c == '}' && open != '{') ||
                            (c == ']' && open != '[')) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
