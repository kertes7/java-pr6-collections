package ua.duikt.pr6;

/** Узагальнений контейнер: тип перевіряється під час КОМПІЛЯЦІЇ. */
public class Box<T> {

    private T item;

    public void put(T item) { this.item = item; }

    public T get() { return item; }
}
