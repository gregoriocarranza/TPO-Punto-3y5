package org.example.util;

import org.example.model.*;

public class BinaryTreeUtil {

    private BinaryTreeUtil() {

    }

    public static int totalNodes(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return 1 + totalNodes(binaryTree.getLeft()) + totalNodes(binaryTree.getRight());
    }

    public static int height(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static boolean isFull(BinaryTree binaryTree) {
        return totalNodes(binaryTree) == Math.pow(2, height(binaryTree)) - 1;
    }

    public static boolean isComplete(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return true;
        }

        if (binaryTree.getLeft() != null && binaryTree.getRight() == null ||
                binaryTree.getLeft() == null && binaryTree.getRight() != null) {
            return false;
        }

        return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
    }

    public static int totalLeaves(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        return (binaryTree.getLeft() == null && binaryTree.getRight() == null ? 1 : 0)
                + totalLeaves(binaryTree.getLeft()) + totalLeaves(binaryTree.getRight());
    }

    public static void printPreOrder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static void printPreOrderLeaves(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        if (binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            System.out.println(binaryTree.getRoot());
        }
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static Stack mapPreOrder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return null;
        }
        Stack result = new StaticStack();
        result.add(binaryTree.getRoot());
        fill(binaryTree.getLeft(), result);
        fill(binaryTree.getRight(), result);
        return result;
    }

    private static void fill(BinaryTree binaryTree, Stack stack) {
        if (binaryTree == null) {
            return;
        }
        stack.add(binaryTree.getRoot());
        fill(binaryTree.getLeft(), stack);
        fill(binaryTree.getRight(), stack);
    }

    public static boolean isSBT(BinaryTree binaryTree) {
        return isSBT(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSBT(BinaryTree binaryTree, int min, int max) {
        if (binaryTree == null) {
            return true;
        }

        if (binaryTree.getRoot() > max || binaryTree.getRoot() < min) {
            return false;
        }

        return isSBT(binaryTree.getLeft(),
                min,
                Math.min(max, binaryTree.getRoot())) &&

                isSBT(binaryTree.getRight(),
                        Math.max(min, binaryTree.getRoot()),
                        max);
    }

    public static void iterativePrintByLevel(BinaryTree binaryTree) {
        BinaryTreeQueue binaryTreeQueue = new StaticBinaryTreeQueue();
        binaryTreeQueue.add(binaryTree);

        while (!binaryTreeQueue.isEmpty()) {
            BinaryTree aux = binaryTreeQueue.getFirst();
            System.out.println(aux.getRoot());
            if (aux.getLeft() != null) {
                binaryTreeQueue.add(aux.getLeft());
            }
            if (aux.getRight() != null) {
                binaryTreeQueue.add(aux.getRight());
            }
            binaryTreeQueue.remove();
        }
    }

}
