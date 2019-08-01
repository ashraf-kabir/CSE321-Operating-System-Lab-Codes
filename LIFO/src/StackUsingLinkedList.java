import java.util.LinkedList;

public class StackUsingLinkedList {

    private LinkedList<Object> list = new LinkedList<Object>();

    private void push(Object item) {
        list.addFirst(item);
        System.out.println("Pushed: " + item);
    }

    private Object pop() {
        System.out.println("Popped: " + list.getFirst());
        return list.removeFirst();
    }

    public Object peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Testing the stack. The added objects should be returned in reverse order.
     */
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        System.out.println("STACK-PUSH:");
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        System.out.println();
        System.out.println("****LIFO****");
        System.out.println("STACK-POP");
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }
}
