import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        //equalsAndHashCode();
        //testArrayList();
        //testSet();
        testMap();
    }

    private static void testMap() {
        Map<String, Record> recordMap = new HashMap<>();

        Record record = new Record("test", 1);

        recordMap.put("A", record);
        recordMap.put("B", record);

        System.out.println(recordMap.toString());
        System.out.println(recordMap.get("A"));
        System.out.println(recordMap.get("B"));
    }

    private static void testSet() {
        Set<Record> set = new HashSet<>();

        Record record = new Record("test", 1);
        Record record1 = new Record("test", 1);

        System.out.println(record.equals(record1));
        System.out.println(record.hashCode());
        System.out.println(record1.hashCode());

        set.add(record);
        set.add(record1);

        System.out.println(set.size());
        System.out.println(set.toString());
    }

    private static void testArrayList() {
        List<Record> arrayList = new ArrayList<>();

        Record record = new Record("test", 1);
        Record record1 = new Record("test", 1);

        System.out.println(record.equals(record1));
        System.out.println(record.hashCode());
        System.out.println(record1.hashCode());

        arrayList.add(record);
        arrayList.add(record1);

        System.out.println(arrayList.size());
        System.out.println(arrayList.toString());
    }

    private static void equalsAndHashCode() {
        Record record = new Record("test", 1);
        Record record1 = new Record("test", 1);

        System.out.println(record.equals(record1));
        System.out.println(record.hashCode());
        System.out.println(record1.hashCode());
    }
}
