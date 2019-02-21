import java.util.Objects;

//Малыгин Андрей, домашнее задание к 3 уроку Java2.

public class AddressBook {
    private String name;
    private String numer;

    public AddressBook(String name, String numer) {
        this.name = name;
        this.numer = numer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(numer, that.numer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numer);
    }
}
