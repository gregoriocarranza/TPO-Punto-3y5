package model;


import model.nodes.DictionaryNode;

public class DynamicDictionary implements Dictionary {

    private DictionaryNode node;

    public DictionaryNode getHeadNode() {
        return this.node;
    }

    @Override
    public int get(int key) {
        if(this.node == null) {
            throw new RuntimeException("No se puede obtener un valor de una estructura vacía");
        }
        DictionaryNode aux = this.node;
        while(aux.getNext() != null) {
            if(aux.getKey() == key) {
                return aux.getValue();
            }
            aux = aux.getNext();
        }
        if(aux.getKey() == key) {
            return aux.getValue();
        }

        throw new RuntimeException("La clave no existe");
    }

    @Override
    public Set getKeys() {
        Set result = new StaticSet();

        DictionaryNode aux = this.node;
        while(aux != null) {
            result.add(aux.getKey());
            aux = aux.getNext();
        }

        return result;
    }

    @Override
    public void add(int key, int value) {
        if(this.node == null) {
            this.node = new DictionaryNode(key, value, null);
            return;
        }

        DictionaryNode aux = this.node;
        while(aux.getNext() != null) {
            if(aux.getKey() == key) {
                aux.setValue(aux.getValue() + value);
            }
            aux = aux.getNext();
        }
        if(aux.getKey() == key) {
            aux.setValue(aux.getValue() + value);
        }

        aux.setNext(new DictionaryNode(key, value, null));
    }

    @Override
    public void remove(int key) {
        if(this.node == null) {
            throw new RuntimeException("La clave no existe");
        }

        if(this.node.getNext() == null) {
            if(this.node.getKey() == key) {
                this.node = null;
                return;
            }
            throw new RuntimeException("La clave no existe");
        }

        if(this.node.getKey() == key) {
            this.node = this.node.getNext();
            return;
        }

        DictionaryNode backup = this.node;
        DictionaryNode current = this.node.getNext();
        while(current != null) {
            if(current.getKey() == key) {
                backup.setNext(current.getNext());
                return;
            }
            backup = current;
            current = current.getNext();
        }

        throw new RuntimeException("La clave no existe");
    }
}
