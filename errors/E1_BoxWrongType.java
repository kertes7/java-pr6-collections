class Title {
    final String name;
    Title(String name) { this.name = name; }
}

class Box<T> {
    private T item;
    void put(T item) { this.item = item; }
    T get() { return item; }
}

public class E1_BoxWrongType {
    public static void main(String[] args) {
        Box<Title> box = new Box<>();
        box.put("abc");                 // рядок замість Title
    }
}
