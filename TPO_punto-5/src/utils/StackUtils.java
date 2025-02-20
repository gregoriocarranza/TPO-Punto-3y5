package utils;

import model.DynamicStack;

import java.util.Set;
import java.util.TreeSet;

public class StackUtils {

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