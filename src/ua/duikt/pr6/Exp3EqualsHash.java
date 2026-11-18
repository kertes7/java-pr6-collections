package ua.duikt.pr6;

import java.util.HashSet;
import java.util.Set;

/** Дослід 3: поведінка HashSet у трьох станах класу та зміна ключа вже доданого об'єкта. */
public class Exp3EqualsHash {

    static void check(String label, Title a, Title b, Title probe) {
        Set<Title> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.printf("%-34s size = %d, contains(третій) = %b%n", label, set.size(), set.contains(probe));
    }

    public static void main(String[] args) {
        Utf8.init();
        System.out.println("Два різні об'єкти з однаковим id=7 додано до HashSet; contains для третього об'єкта з id=7:");
        check("1) без equals і hashCode:",
                new Title(7, "Матриця", 1999), new Title(7, "Матриця", 1999), new Title(7, "Матриця", 1999));
        check("2) лише equals:",
                new TitleEqualsOnly(7, "Матриця", 1999), new TitleEqualsOnly(7, "Матриця", 1999), new TitleEqualsOnly(7, "Матриця", 1999));
        check("3) equals + hashCode:",
                new TitleFull(7, "Матриця", 1999), new TitleFull(7, "Матриця", 1999), new TitleFull(7, "Матриця", 1999));

        System.out.println();
        System.out.println("Зміна поля-ключа в об'єкта, що вже лежить у HashSet (клас із equals+hashCode):");
        Set<TitleFull> set = new HashSet<>();
        TitleFull t = new TitleFull(7, "Матриця", 1999);
        set.add(t);
        System.out.println("до зміни:  set.contains(t) = " + set.contains(t) + ", size = " + set.size());
        t.setId(999);                                           // ключ змінено ПІСЛЯ додавання
        System.out.println("після t.setId(999):");
        System.out.println("  set.contains(t)                  = " + set.contains(t));
        System.out.println("  set.contains(new TitleFull(7))   = " + set.contains(new TitleFull(7, "Матриця", 1999)));
        System.out.println("  size = " + set.size() + "; об'єкт у множині: " + set.iterator().next());
    }
}
