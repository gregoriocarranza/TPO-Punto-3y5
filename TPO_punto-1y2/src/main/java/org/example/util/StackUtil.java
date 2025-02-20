package org.example.util;

import org.example.model.*;

public class StackUtil {

    private StackUtil() {

    }

    public static Stack copy(Stack stack) {
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();

        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            aux2.add(stack.getTop());
            stack.remove();
        }

        while (!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }

        while (!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }

        return aux2;
    }

    public static void print(Stack stack) {
        Stack copy = copy(stack);
        while (!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    public static int middle(Stack stack) {
        Stack copy = copy(stack);
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();
        Stack aux3 = new StaticStack();

        boolean p = true;
        while (!copy.isEmpty()) {
            if (p) {
                aux.add(copy.getTop());
            } else {
                aux2.add(copy.getTop());
            }
            p = !p;
            aux3.add(copy.getTop());
        }

        while (!aux2.isEmpty()) {
            aux3.remove();
            aux2.remove();
        }

        return aux3.getTop();
    }

    /**

     *Precondiciones: Para su correcto funcionamiento, no debe estar vacio el stack
     *
     * @param stack el stack generico que sera invertido
     *
     * @param <T> El tipo de parametro, siendo este Object en general.
     * Complejidad Computacional: O(N(pow)2)
     */
    public static <T> void reverseGenericStack(StackGeneric<T> stack) {
        //Si la pila está vacía o tiene un solo elemento, no es necesario invertirla
        if (stack.isEmpty() || stack.getTop() == null) {
            return;
        }

        //Crear pilas auxiliares
        StackGeneric<T> tempStack1 = new DynamicStackGeneric<>();
        StackGeneric<T> tempStack2 = new DynamicStackGeneric<>();

        //Transferir elementos a la primera pila temporal
        while (!stack.isEmpty()) {
            T elemento = stack.getTop();
            tempStack1.add(elemento);
            stack.remove();
        }

        //transferir elementos a la segunda pila temporal
        while (!tempStack1.isEmpty()) {
            T elemento = tempStack1.getTop();
            tempStack2.add(elemento);
            tempStack1.remove();
        }

        // transferir elementos de vuelta a la pila original en orden invertido
        while (!tempStack2.isEmpty()) {
            T elemento = tempStack2.getTop();
            stack.add(elemento);
            tempStack2.remove();
        }
    }

}
