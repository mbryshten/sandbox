package recursivelyPrintLinkedListFromTheEnd;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PrintLinkedList {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < 10; i++) {

            list.add(i);
        }

        Iterator it = list.iterator();

        while(it.hasNext()) {

            System.out.println(it.next());
        }

        printList(list);

    }

    private static void printList(List<Integer> list) {

        if(list.size() > 1) {

            printList(list.subList(1, list.size()));
        }

        System.out.println(list.get(0));

    }
}
