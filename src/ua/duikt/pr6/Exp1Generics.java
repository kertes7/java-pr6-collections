package ua.duikt.pr6;

import java.util.List;

/** Дослід 1: generics проти Object; List<Integer> -> List<Number>; wildcard. */
public class Exp1Generics {

    // Узагальнений метод: працює зі списком БУДЬ-ЯКОГО типу
    static <T> void printAll(List<T> list) {
        for (T item : list) System.out.println("  " + item);
    }

    // Параметр List<Number> приймає ТІЛЬКИ List<Number> (інваріантність)
    static double totalStrict(List<Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    // Виправлено: List<? extends Number> приймає List<Integer>, List<Double>, List<Number> ...
    static double total(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    public static void main(String[] args) {
        Utf8.init();

        Box<Title> box = new Box<>();
        box.put(new Title(1, "Матриця", 1999));
        // box.put("abc");                          // помилка компіляції: incompatible types
        Title t = box.get();                        // приведення типу не потрібне
        System.out.println("Box<Title>: " + t);

        System.out.println("printAll(List<Title>):");
        printAll(List.of(new Title(2, "Шрек", 2001), new Title(3, "Аватар", 2009)));

        ObjectBox objBox = new ObjectBox();
        objBox.put("abc");                          // компілятор нічого не заперечує
        try {
            Title bad = (Title) objBox.get();       // помилка лише тут, під час виконання
            System.out.println(bad);
        } catch (ClassCastException e) {
            System.out.println("ObjectBox: помилка проявилась ЛИШЕ під час виконання:");
            e.printStackTrace();
        }

        List<Integer> ints = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.5, 2.5);
        // totalStrict(ints);                       // помилка компіляції: List<Integer> не є List<Number>
        System.out.println("total(List<Integer>) = " + total(ints));
        System.out.println("total(List<Double>)  = " + total(doubles));
    }
}
