package org.example.model;

public class StaticNAryTree implements NAryTree {

    private static final int MAX = 4;

    private final int N;

    private final Integer[] array;
    private final int indexRoot;

    // S = A^0 + A^1 + A^2 + ... + A^{N-1}
    // AS = A^1 + A^2 + A^3 + ... + A^N
    // AS - S = A^N - A^0
    // (A-1)S = A^N - A^0
    // S = (A^N-1)/(A-1)
    public StaticNAryTree(int root, int n) {
        this.N = n;
        this.array = new Integer[(int) (Math.pow(this.N, MAX) - 1) / (this.N - 1)];
        this.indexRoot = 0;
        this.array[indexRoot] = root;
    }

    private StaticNAryTree(int indexRoot, Integer[] array, int n) {
        this.N = n;
        this.array = array;
        this.indexRoot = indexRoot;
    }

    private static void removeAll(NAryTree tree, int n) {
        for (int i = 0; i < n; i++) {
            NAryTree aux = tree.get(i);
            if (aux == null) {
                continue;
            }
            removeAll(aux, n);
        }
    }

    @Override
    public int getRoot() {
        return this.array[this.indexRoot];
    }

    @Override
    public NAryTree get(int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }
        if (this.array[this.N * indexRoot + index + 1] == null) {
            return null;
        }
        return new StaticNAryTree(this.N * indexRoot + index + 1, array, this.N);
    }

    @Override
    public void add(int a, int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }
        if (this.array[this.N * indexRoot + index + 1] != null) {
            throw new RuntimeException("Ya existe un hijo en " + index);
        }
        this.array[this.N * indexRoot + index + 1] = a;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }
        NAryTree aux = this.get(index);
        for (int i = 0; i < this.N; i++) {
            NAryTree aux2 = aux.get(i);
            if (aux2 == null) {
                continue;
            }
            removeAll(aux2, this.N);
        }
        this.array[2 * indexRoot + 1] = null;
    }
}
