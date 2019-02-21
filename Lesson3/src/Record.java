import java.util.Objects;

public class Record {
    private String value;
    private int id;

    public Record(String value, int id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                Objects.equals(value, record.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, id);
    }
}
