package ua.duikt.pr6;

/** Стан 3: перевизначено і equals, і hashCode за ключем id (контракт виконано). */
public class TitleFull extends Title {

    public TitleFull(int id, String name, int year) {
        super(id, name, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleFull)) return false;
        return id == ((TitleFull) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
