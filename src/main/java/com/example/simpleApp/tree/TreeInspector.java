package com.example.simpleApp.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeInspector {

    public static void main(String[] args) {
        Tree root = createTree();
        System.out.println("----------- RECURS --------------");
        System.out.println("Sum = " + sumRecursive(root));
        System.out.println("----------- STACK --------------");
        System.out.println("Sum = " + sumDeep(root));
        System.out.println("----------- QUEUE --------------");
        System.out.println("Sum = " + sumWide(root));

    }

    private static Tree createTree() {
        return
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6, null, null)), new Tree(9, null, null)),
                        new Tree(35,
                                new Tree(31, new Tree(28, null, null), null),
                                new Tree(40, new Tree(38, null, null), new Tree(52, null, null))));

    }

    public static int sumRecursive(Tree root) {
        int summ = root.getValue();
        System.out.println(summ);

        if (root.left != null) {
            summ += sumRecursive(root.left);
        }

        if (root.right != null) {
            summ += sumRecursive(root.right);
        }
        return summ;
    }

    public static int sumDeep(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();

            System.out.println(node.getValue());

            summ = summ + node.getValue();

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return summ;
    }

    public static int sumWide(Tree root) {
        Queue<Tree> stack = new LinkedList<>();
        stack.add(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.remove();

            System.out.println(node.getValue());

            summ = summ + node.getValue();

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return summ;
    }


}
