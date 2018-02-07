package binaryTreeCopy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BinaryTreeCopy {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {

        MyTree root = new MyTree();
        root.value = getRandomNumberInRange(1,10);

        for (int i = 0; i < 5; i++) {

            int j = getRandomNumberInRange(1,10);

            System.out.println("Adding: " + j);

            addElement(root, j);
        }

        System.out.println("Added");

        printTree(root);

        System.out.println("printed");

        printRecursive(root);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");

        printRecursive(getCopy(root));

    }

    private static MyTree getCopy(MyTree root) {

        MyTree newRoot = new MyTree();
        newRoot.value = root.value;

        getCopy(root, newRoot);

        return newRoot;
    }


    private static void getCopy(MyTree curr, MyTree newCurr) {

        if(curr.left != null) {

            MyTree tmp = new MyTree();
            tmp.value = curr.left.value;

            newCurr.left = tmp;

            getCopy(curr.left, newCurr.left);
        }

        if(curr.right != null) {

            MyTree tmp = new MyTree();
            tmp.value = curr.right.value;

            newCurr.right = tmp;

            getCopy(curr.right, newCurr.right);
        }

    }

    private static void printRecursive(MyTree root) {


        if(root.left != null) {

            printRecursive(root.left);

        }

        System.out.println(root.value);

        if(root.right != null) {

            printRecursive(root.right);
        }
    }


    private static void addElement(MyTree root, int i) {

        if(i <= root.value) {

            // left

            if(root.left == null) {

                MyTree node = new MyTree();
                node.value = i;
                root.left = node;

            } else {

                addElement(root.left, i);
            }

        } else {

            // right

            if(root.right == null) {

                MyTree node = new MyTree();
                node.value = i;
                root.right = node;

            } else {

                addElement(root.right, i);
            }
        }

    }

    private static void printTree(MyTree root) {

        List<MyTree> current = new ArrayList<MyTree>();
        List<MyTree> next = new ArrayList<MyTree>();

        while(true) {

            if(current.isEmpty()) {

                current.add(root);
            }

            Iterator<MyTree> iterator = current.iterator();

            while(iterator.hasNext()) {

                MyTree myTree = iterator.next();

                if(myTree.value != 0)
                    System.out.print(myTree.value + " ");

                if(myTree.left != null) {

                    next.add(myTree.left);
                }

                if(myTree.right != null) {

                    next.add(myTree.right);
                }
            }

            System.out.println("");

            current.clear();
            current.addAll(next);

            next.clear();

            if(current.size() == 0) return;



        }


    }
}


class MyTree {

    int value;
    MyTree left;
    MyTree right;
}