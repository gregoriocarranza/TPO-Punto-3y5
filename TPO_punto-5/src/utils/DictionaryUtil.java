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

    /**
     * Descifra un texto cifrado con el cifrado César sin conocer el desplazamiento.
     *
     * Complejidad: O(n), ya que recorre el texto una vez para contar la frecuencia de letras,
     * luego encuentra la letra más frecuente en O(n), y finalmente descifra en O(n).
     *
     * @param encryptedText Texto cifrado a descifrar.
     * @return Texto descifrado.
     */
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


    /**
     * Verifica si una expresión tiene paréntesis, corchetes y llaves balanceados,
     * ignorando los que están dentro de comillas simples o dobles.
     *
     * Complejidad: O(n), ya que recorre la expresión una vez y utiliza una pila
     * para manejar los paréntesis de manera eficiente.
     *
     * @param expression Expresión a evaluar.
     * @return `true` si está balanceada, `false` en caso contrario.
     */
    public static boolean isBalanced(String expression) {
        DynamicStack stack = new DynamicStack();
        boolean insideQuotes = false;
        char quoteChar = ' ';

        for (char c : expression.toCharArray()) {
            if (c == '"' || c == '\'') {
                if (insideQuotes && c == quoteChar) {
                    insideQuotes = false;
                } else if (!

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
