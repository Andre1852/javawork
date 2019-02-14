package participant;

public class Cat extends Animal{
    private String type;

    public final static String TYPE_PERSIA = "PERSIA TYPE";
    public final static String TYPE_BRITISH = "BRITISH TYPE";
    private final static double COEF_OF_JUMP_PERSIA = 0.6;
    private final static double COEF_OF_JUMP_BRITISH = 0.5;
    private final static double COEF_FOR_CAT = 0.8;
    private final static double DEFAULT_JUMP_VALUE = 5;

    public Cat(int age, String name, String type) {
        super(age, name);
        this.type = type;
    }

    @Override
    public boolean jump(double distance) {
        if (type.equalsIgnoreCase(TYPE_PERSIA)){
            return distance <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_PERSIA * COEF_FOR_CAT;
        } else if (type.equalsIgnoreCase(TYPE_BRITISH)){
            return distance <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_BRITISH * COEF_FOR_CAT;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
