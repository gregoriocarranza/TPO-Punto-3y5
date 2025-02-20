package org.example;

import org.example.model.*;

public class App {

    public static void main(String[] args) {
        testStackInversion();
        StackGeneric<Object> stack = new DynamicStackGeneric<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add("Test");
        testSetCopy(stack);
    }

    private static void testStackInversion() {
        System.out.println("PRUEBA DE INVERSIÓN DE STACK");
        System.out.println("----------------------------");

        // Crear y llenar stack con números
        StackGeneric<Object> stack = new DynamicStackGeneric<>();
        SetGeneric<Object> set= new DynamicSetGeneric<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add("Test");
        set.add(stack);
        set.add("Test2");
       SetGeneric set2= org.example.util.SetUtil.copySetGeneric(set);

        // Mostrar stack original
        System.out.println("Stack original:");
        mostrarStack(stack);

        // Invertir stack
        org.example.util.StackUtil.reverseGenericStack(stack);

        // Mostrar stack invertido
        System.out.println("\nStack invertido:");
        mostrarStack(stack);

        // Probar con stack vacío
        System.out.println("\nPrueba con stack vacío:");
        StackGeneric<String> emptyStack = new DynamicStackGeneric<>();
        org.example.util.StackUtil.reverseGenericStack(emptyStack);
        mostrarStack(emptyStack);

        // Probar con stack de un solo elemento
        System.out.println("\nPrueba con stack de un elemento:");
        StackGeneric<String> singleStack = new DynamicStackGeneric<>();
        singleStack.add("único");
        org.example.util.StackUtil.reverseGenericStack(singleStack);
        mostrarStack(singleStack);

         }

    private static void testSetCopy(StackGeneric stack) {
        System.out.println("SET COPY TEST");
        System.out.println("------------");

        // Crear un conjunto original con algunos elementos
        SetGeneric<Object> originalSet = new DynamicSetGeneric<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);
        originalSet.add(2);  // Elemento duplicado (no se agregará)
        originalSet.add(4);
        originalSet.add(stack);

        // Mostrar el conjunto original
        System.out.println("Original set:");
        mostrarSet(originalSet);

        // Copiar el conjunto utilizando copySetGeneric
        SetGeneric<Object> copiedSet = org.example.util.SetUtil.copySetGeneric(originalSet);

        // Mostrar el conjunto copiado
        System.out.println("\nCopied set:");
        mostrarSet(copiedSet);

        // Verificar que el conjunto original sigue intacto después de la copia
        System.out.println("\nOriginal set after copy:");
        mostrarSet(originalSet);

        // Prueba con un conjunto vacío
        System.out.println("\nTest with empty set:");
        SetGeneric<Object> emptySet = new DynamicSetGeneric<>();
        SetGeneric<Object> copiedEmptySet = org.example.util.SetUtil.copySetGeneric(emptySet);

        // Mostrar el conjunto vacío copiado
        System.out.println("Copied empty set:");
        mostrarSet(copiedEmptySet);
    }

    /**
     * Método auxiliar para imprimir los elementos de un SetGeneric.
     */
    private static void mostrarSet(SetGeneric<Object> set) {
        if (set.isEmpty()) {
            System.out.println("Set vacío");
            return;
        }

        // Crear una pila temporal para almacenar y restaurar los elementos
        StackGeneric<Object> tempStack = new DynamicStackGeneric<>();
        StringBuilder sb = new StringBuilder();

        while (!set.isEmpty()) {
            Object elemento = set.getAnyElement();
            sb.append(elemento).append(", ");
            tempStack.add(elemento);
            set.remove(elemento);
        }

        // Restaurar el conjunto original
        while (!tempStack.isEmpty()) {
            set.add(tempStack.getTop());
            tempStack.remove();
        }

        // Mostrar resultado
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio
        }
        System.out.println(sb.toString());
    }

    private static <Object> void mostrarStack(StackGeneric<Object> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack vacío");
            return;
        }

        StackGeneric<Object> tempStack = new DynamicStackGeneric<>();
        StringBuilder sb = new StringBuilder();

        // Extraer elementos para mostrarlos
        while (!stack.isEmpty()) {
            Object elemento = stack.getTop();
            sb.append(elemento).append(" -> ");
            tempStack.add(elemento);
            stack.remove();
        }

        // Restaurar stack
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.getTop());
            tempStack.remove();
        }

        // Mostrar resultado
        if (sb.length() > 4) {
            sb.setLength(sb.length() - 4);
        }
        System.out.println(sb.toString());
    }


    }

