package org.example.util;
import org.example.model.DynamicQueueOfStacks;
import org.example.model.Stack;
import org.example.model.Queue;
import org.example.model.QueueOfStacks;
import org.example.model.DynamicQueue;
import org.example.model.DynamicStack;

public class QueueOfStacksUtil {
    /**
     * Precondiciones: La cola no debe estar vacia,
     * Debe contener exactamente n pilas (n siendo la dimension de la matriz
     * representada.
     * Cada pila debe contener exactamente n elementos.
     * Postcondiciones: Se devuelve un numero entero representando la suma de
     * la diagonal principal simulada con la cola.
     * La estructura cola no es modificada.
     * @param queueOfStacks Cola de pilas a la que se le calculara la Traza
     * Complejidad Computacional: O(N(pow)2)
     */
    public static int calculateTrace(QueueOfStacks queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("La cola de pilas está vacía");
        }

        QueueOfStacks tempQueue = new DynamicQueueOfStacks();
        int traza = 0;
        int index = 0;

        while (!queueOfStacks.isEmpty()) {
            Stack currentStack = queueOfStacks.getFirstStack();
            Queue tempQueueElement = new DynamicQueue();

            // Pasar elementos de la pila a una cola temporal
            while (!currentStack.isEmpty()) {
                tempQueueElement.add(currentStack.getTop());
                currentStack.remove();
            }

            // Calcular la traza (sumar el elemento en la diagonal)
            for (int i = 0; i <= index && !tempQueueElement.isEmpty(); i++) {
                int value = tempQueueElement.getFirst();
                if (i == index) {
                    traza += value;
                }
                tempQueueElement.remove();
            }

            // Restaurar la pila original y agregarla a una cola temporal
            Stack restoredStack = new DynamicStack();
            while (!tempQueueElement.isEmpty()) {
                restoredStack.add(tempQueueElement.getFirst());
                tempQueueElement.remove();
            }

            tempQueue.addStack(restoredStack);
            queueOfStacks.removeStack();
            index++;
        }

        // Restaurar la estructura original
        while (!tempQueue.isEmpty()) {
            queueOfStacks.addStack(tempQueue.getFirstStack());
            tempQueue.removeStack();
        }

        return traza;
    }

    /**
     *Precondiciones: queue no debe ser null.
     * queue debe contener exactamente n pilas.
     * Cada pila en queue debe contener n elementos.
     * Postcondiciones: Se devuelve una nueva instancia de QueueOfstacks representando la transpuesta de la matriz
     * La estructura original no se modifica.
     * @param queueOfStacks Instancia de QueueOfStacks con  n pilas de n elementos cada una.
     * Complejidad Computacional: O(N(pow)2)
     */
    public static QueueOfStacks obtenerTranspuesta(QueueOfStacks queueOfStacks) {
        if (queueOfStacks.isEmpty()) {
            throw new RuntimeException("La cola de pilas está vacía");
        }

        DynamicQueueOfStacks tempQueue = new DynamicQueueOfStacks();
        DynamicQueueOfStacks transpuesta = new DynamicQueueOfStacks();

        // Guardamos las pilas en una estructura temporal
        while (!queueOfStacks.isEmpty()) {
            tempQueue.addStack(queueOfStacks.getFirstStack());
            queueOfStacks.removeStack();
        }

        int columnas = 0;
        while (!tempQueue.isEmpty()) {
            Stack currentStack = tempQueue.getFirstStack();
            Stack restoredStack = new DynamicStack();
            Queue columnQueue = new DynamicQueue();

            while (!currentStack.isEmpty()) {
                columnQueue.add(currentStack.getTop());
                restoredStack.add(currentStack.getTop());
                currentStack.remove();
            }

            tempQueue.removeStack();
            queueOfStacks.addStack(restoredStack);

            Stack transpuestaStack = new DynamicStack();
            while (!columnQueue.isEmpty()) {
                transpuestaStack.add(columnQueue.getFirst());
                columnQueue.remove();
            }

            transpuesta.addStack(transpuestaStack);
            columnas++;
        }

        return transpuesta;
    }

    /**
     * Precondiciones: n debe ser mayor a 0.
     * Postcondiciones: Se devuelve una instancia de QueueOfStacks siendo la matriz caracol
     * La matriz generada sigue el patron en espiral hasta llenarla.
     * @param n Numero entero positivo, representando la dimension de la matriz
     * Complejidad Computacional: O(N(pow)2)
     */
    public static QueueOfStacks generateSpiralMatrix(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor que 0.");
        }

        QueueOfStacks matrizCaracol = new DynamicQueueOfStacks();
        Stack[] filas = new DynamicStack[n];

        for (int i = 0; i < n; i++) {
            filas[i] = new DynamicStack();
        }

        int valor = 1;
        int inicioFila = 0, finFila = n - 1;
        int inicioColumna = 0, finColumna = n - 1;

        while (inicioFila <= finFila && inicioColumna <= finColumna) {
            // Llenar la fila superior
            for (int i = inicioColumna; i <= finColumna; i++) {
                filas[inicioFila].add(valor++);
            }
            inicioFila++;

            // Llenar la columna derecha
            for (int i = inicioFila; i <= finFila; i++) {
                filas[i].add(valor++);
            }
            finColumna--;

            // Llenar la fila inferior
            if (inicioFila <= finFila) {
                for (int i = finColumna; i >= inicioColumna; i--) {
                    filas[finFila].add(valor++);
                }
                finFila--;
            }

            // Llenar la columna izquierda
            if (inicioColumna <= finColumna) {
                for (int i = finFila; i >= inicioFila; i--) {
                    filas[i].add(valor++);
                }
                inicioColumna++;
            }
        }

        // Agregar las pilas a la cola de pilas
        for (int i = 0; i < n; i++) {
            matrizCaracol.addStack(filas[i]);
        }

        return matrizCaracol;
    }
}
