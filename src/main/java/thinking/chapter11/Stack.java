package thinking.chapter11;

import java.util.LinkedList;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-21 13:40
 */

public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();
    public void push(T v) { storage.addFirst(v);}
    public T peek() { return storage.getFirst();}
    public T pop() { return storage.removeFirst();}
    public boolean empty() { return storage.isEmpty();}
    public String toString() { return storage.toString();}
}
