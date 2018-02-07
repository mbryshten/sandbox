package recursivelyPrintLinkedListFromTheEnd;

public class CustomList {

    public static void main(String[] args) {

        MyList lastElement = null;

        MyList list = new MyList();

        list.setValue("0");

        lastElement = list;

        for (int i = 1; i < 10; i++) {

            MyList element = new MyList();

            element.setValue(String.valueOf(i));

            lastElement.setNextElement(element);

            lastElement = element;

        }

        System.out.println("");


        printList(list);
    }

    private static void printList(MyList head) {

        if(head.getNextElement() != null) {

            printList(head.getNextElement());
        }

        System.out.println(head.getValue());

    }
}

class MyList {

    private String value;

    private MyList nextElement;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MyList getNextElement() {
        return nextElement;
    }

    public void setNextElement(MyList nextElement) {
        this.nextElement = nextElement;
    }
}