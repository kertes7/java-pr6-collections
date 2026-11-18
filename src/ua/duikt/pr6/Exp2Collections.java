package ua.duikt.pr6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** Дослід 2: час вставки в середину та contains у ArrayList / LinkedList / HashSet; видалення під час обходу. */
public class Exp2Collections {

    static final int N = 100_000;
    static final int OPS = 1_000;
    static final int RUNS = 5;

    static long ms(long t0) { return (System.nanoTime() - t0) / 1_000_000; }

    public static void main(String[] args) {
        Utf8.init();

        System.out.println("Заповнення колекцій " + N + " об'єктами TitleFull; " + OPS + " операцій; " + RUNS + " запусків");
        long[] insArray = new long[RUNS], insLinked = new long[RUNS];
        long[] conArray = new long[RUNS], conLinked = new long[RUNS], conSet = new long[RUNS];

        for (int run = 0; run < RUNS; run++) {
            List<Title> arrayList = new ArrayList<>();
            List<Title> linkedList = new LinkedList<>();
            Set<Title> hashSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                Title t = new TitleFull(i, "Тайтл " + i, 1950 + i % 75);
                arrayList.add(t); linkedList.add(t); hashSet.add(t);
            }

            long t0 = System.nanoTime();
            for (int i = 0; i < OPS; i++) arrayList.add(arrayList.size() / 2, new TitleFull(N + i, "Нове", 2000));
            insArray[run] = ms(t0);

            t0 = System.nanoTime();
            for (int i = 0; i < OPS; i++) linkedList.add(linkedList.size() / 2, new TitleFull(N + i, "Нове", 2000));
            insLinked[run] = ms(t0);

            Title probe = new TitleFull(N - 1, "?", 0);      // елемент біля кінця
            t0 = System.nanoTime();
            for (int i = 0; i < OPS; i++) arrayList.contains(probe);
            conArray[run] = ms(t0);
            t0 = System.nanoTime();
            for (int i = 0; i < OPS; i++) linkedList.contains(probe);
            conLinked[run] = ms(t0);
            t0 = System.nanoTime();
            for (int i = 0; i < OPS; i++) hashSet.contains(probe);
            conSet[run] = ms(t0);
        }
        print("Вставка x1000 у середину ArrayList", insArray);
        print("Вставка x1000 у середину LinkedList", insLinked);
        print("contains x1000: ArrayList", conArray);
        print("contains x1000: LinkedList", conLinked);
        print("contains x1000: HashSet", conSet);

        // ---- видалення за умовою ----
        System.out.println();
        List<Title> titles = new ArrayList<>();
        titles.add(new TitleFull(1, "Назад у майбутнє", 1985));
        titles.add(new TitleFull(2, "Матриця", 1999));
        titles.add(new TitleFull(3, "Шрек", 2001));
        titles.add(new TitleFull(4, "Аватар", 2009));
        titles.add(new TitleFull(5, "Коко", 2017));

        System.out.println("Видалення тайтлів до 2000 року прямо в for-each:");
        try {
            for (Title t : titles) {
                if (t.getYear() < 2000) titles.remove(t);
            }
        } catch (java.util.ConcurrentModificationException e) {
            e.printStackTrace();
        }
        System.out.println("Список після невдалого видалення: " + titles.size() + " елементів");

        System.out.println("Те саме видалення через Iterator:");
        for (Iterator<Title> it = titles.iterator(); it.hasNext(); ) {
            if (it.next().getYear() < 2000) it.remove();
        }
        System.out.println("Залишилось: " + titles);
    }

    static void print(String label, long[] v) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        for (long x : v) { sum += x; sb.append(x).append(' '); }
        System.out.printf("%-38s: %s| середнє %.1f мс%n", label, sb, (double) sum / v.length);
    }
}
