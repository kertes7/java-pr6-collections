package ua.duikt.pr6;

/** Стан 2: перевизначено ЛИШЕ equals (порушення контракту: рівні об'єкти мають різні hashCode). */
public class TitleEqualsOnly extends Title {

    public TitleEqualsOnly(int id, String name, int year) {
        super(id, name, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleEqualsOnly)) return false;
        return id == ((TitleEqualsOnly) o).id;
    }
}
