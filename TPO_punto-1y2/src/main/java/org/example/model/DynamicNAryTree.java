package org.example.model;

public class DynamicNAryTree implements NAryTree {

    private final int N;
    private final int root;
    private final int index;
    private DynamicNAryTree next;
    private DynamicNAryTree first;

    public DynamicNAryTree(int root, int n) {
        this.root = root;
        this.N = n;
        this.index = 0;
        this.next = null;
    }

    private DynamicNAryTree(int root, int n, int index) {
        this.root = root;
        this.N = n;
        this.index = index;
        this.next = null;
    }

    @Override
    public int getRoot() {
        return this.root;
    }

    @Override
    public NAryTree get(int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }

        if (this.first == null) {
            return null;
        }

        DynamicNAryTree candidate = this.first;

        while (candidate.next != null) {
            if (candidate.index == index) {
                return candidate;
            }
            candidate = candidate.next;
        }
        if (candidate.index == index) {
            return candidate;
        }
        return null;
    }

    @Override
    public void add(int a, int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }

        if (this.first == null) {
            this.first = new DynamicNAryTree(a, this.N, index);
            return;
        }

        DynamicNAryTree candidate = this.first;

        while (candidate.next != null) {
            if (candidate.index == index) {
                throw new RuntimeException("Ya existe un hijo en el Índice " + index);
            }
            candidate = candidate.next;
        }
        if (candidate.index == index) {
            throw new RuntimeException("Ya existe un hijo en el Índice " + index);
        }
        candidate.next = new DynamicNAryTree(a, this.N, index);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.N) {
            throw new RuntimeException("Índice fuera de rango");
        }

        if (this.first == null) {
            return;
        }

        if (this.first.next == null) {
            if (this.first.index == index) {
                this.first = null;
            }
            return;
        }

        if (this.first.index == index) {
            this.first = this.first.next;
            return;
        }

        DynamicNAryTree backup = this.first;
        DynamicNAryTree current = this.first.next;
        while (current.next != null) {
            if (current.index == index) {
                backup.next = current.next;
            }
            backup = current;
            current = current.next;
        }

        if (current.index == index) {
            backup.next = null;
        }
    }
}
