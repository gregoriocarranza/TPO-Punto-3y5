package utils;

import model.DynamicStack;

import java.util.Set;
import java.util.TreeSet;

public class StackUtils {

    /**
     * Ordena una pila eliminando duplicados y ordenando en forma ascendente.
     *
     * Complejidad: O(n^2), ya que el primer bucle recorre la pila y verifica duplicados en O(n),
     * y el segundo bucle inserta ordenadamente en O(n^2) en el peor caso.
     *
     * @param inputStack La pila de entrada a ordenar.
     * @return Una pila ordenada sin duplicados.
     */
    public static DynamicStack OrderStack(DynamicStack inputStack) {
        DynamicStack auxStack = new DynamicStack();
        DynamicStack sortedStack = new DynamicStack();

        while (!inputStack.isEmpty()) {
            int current = inputStack.getTop();
            inputStack.remove();

            if (!contains(auxStack, current)) {
                auxStack.add(current);
            }
        }

        while (!auxStack.isEmpty()) {
            int temp = auxStack.getTop();
            auxStack.remove();

            while (!sortedStack.isEmpty() && sortedStack.getTop() > temp) {
                auxStack.add(sortedStack.getTop());
                sortedStack.remove();
            }

            sortedStack.add(temp);
        }

        return sortedStack;
    }

    private static boolean contains(DynamicStack stack, int value) {
        DynamicStack tempStack = new DynamicStack();
        boolean found = false;

        while (!stack.isEmpty()) {
            int topValue = stack.getTop();
            stack.remove();
            tempStack.add(topValue);

            if (topValue == value) {
                found = true;
            }
        }

        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getTop());
            tempStack.remove();
        }

        return found;
    }
}