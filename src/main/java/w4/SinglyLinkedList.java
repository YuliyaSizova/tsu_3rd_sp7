/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w4;

/**
 * Односвязный список целых чисел
 */
public class LinkedList {

    
    private int size = 0;
    private Node head = null;

    /**
     * Добавляет число i в конец списка
     *
     * @param i
     */
    public void push_back(Integer i) {
        if (head == null) {
            head = new Node(i);
            size = 1;
        } else {
            Node newNode = new Node(i);
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }

    /**
     * Изымает последний добавленный элемент списка
     *
     * @return
     */
    public Integer pop_back() {
        if (head == null) {
            throw new RuntimeException("Лист пуст!");
        } else {
            Integer value = head.getValue();
            head = head.getNext();
            size--;
            return value;
        }
    }

    /**
     * Сортирует односвязный список.
     */
    public void sort() {
        LinkedList[] sortedList = new LinkedList[size];
        while (head != null) {
            LinkedList newList = new LinkedList();
            Node nodeToPop = head;
            pop_back();
            newList.addNode(nodeToPop);
            putList(newList, sortedList, 0);
        }
        // После того, как исходный список опустошён, делаем слияние всех
        // списков, которые остались в стеке, и забираем полный список из
        // конца стека
        for (int i = 1; i < sortedList.length; i++) {
            putList(sortedList[i - 1], sortedList, i);
        }
        head = sortedList[sortedList.length - 1].head;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {

            builder.append(currentNode.getValue()).append(", ");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

    /**
     * Кладёт отсортированный список выбранную позицию стрека списков. Если
     * место занято, производит слияние и кладёт полученный список в следующую
     * позицию (по такому же принципу).
     *
     * @param listToPut отсортированный список, который нужно поместить в стек
     * @param sortedLists стек списков
     * @param startPosition позиция, в которую нужно поместить список
     */
    private void putList(LinkedList listToPut, LinkedList[] sortedLists, int startPosition) {
        if (startPosition >= sortedLists.length || listToPut == null) {
            return;
        }
        if (sortedLists[startPosition] == null) {
            sortedLists[startPosition] = listToPut;
        } else {
            LinkedList newList = merge(sortedLists[startPosition], listToPut);
            sortedLists[startPosition] = null;
            putList(newList, sortedLists, startPosition + 1);
        }
    }

    public LinkedList merge(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node latestAddedNode = null;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            Node node1 = list1.head;
            Node node2 = list2.head;
            int val1 = node1.getValue();
            int val2 = node2.getValue();
            Node nodeToAdd;
            if (val1 > val2) {
                nodeToAdd = node1;
                list1.pop_back();
            } else {
                nodeToAdd = node2;
                list2.pop_back();
            }
            if (latestAddedNode == null) {
                mergedList.addNode(nodeToAdd);
            } else {
                latestAddedNode.setNext(nodeToAdd);
            }
            latestAddedNode = nodeToAdd;
        }
        // когда один из списков опустел, оставшиеся значения из другого
        // списка просто добавляются в конец
        LinkedList notEmptyList;
        if (!list1.isEmpty()) {
            notEmptyList = list1;
        } else {
            notEmptyList = list2;
        }
        while (!notEmptyList.isEmpty()) {
            Node nodeToAdd = notEmptyList.head;
            notEmptyList.pop_back();
            latestAddedNode.setNext(nodeToAdd);
            latestAddedNode = nodeToAdd;
        }
        return mergedList;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        System.out.println(toString());
    }

    public void addNode(Node node) {
        node.setNext(head);
        head = node;
    }

    static public class Node {

        private Integer value;
        private Node next = null;

        public Node(Integer value) {
            this.value = value;
        }

        public Node(Integer value, Node previous) {
            this(value);
            this.next = previous;
        }

        /**
         * @return the value
         */
        public Integer getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

}
