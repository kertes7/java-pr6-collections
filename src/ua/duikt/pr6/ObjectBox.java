package ua.duikt.pr6;

/** Те саме на Object: помилка типу проявляється лише під час ВИКОНАННЯ (ClassCastException). */
public class ObjectBox {

    private Object item;

    public void put(Object item) { this.item = item; }

    public Object get() { return item; }
}
