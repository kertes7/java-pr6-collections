package ua.duikt.pr6;

/** Тайтл стрімінгового сервісу (варіант 0): id, назва, рік. Ключ рівності — id. Equals/hashCode НЕ перевизначено. */
public class Title {

    protected int id;
    protected final String name;
    protected final int year;

    public Title(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return "Title{id=" + id + ", " + name + ", " + year + "}";
    }
}
