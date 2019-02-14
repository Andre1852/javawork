package participant;

public class Dog extends Animal{
    private String type;

    public final static String TYPE_BULDOG = "BULDOG TYPE";
    public final static String TYPE_DOG = "DOG TYPE";
    private final static double COEF_OF_JUMP_BULDOG = 0.4;
    private final static double COEF_OF_JUMP_DOG = 0.8;
    private final static double COEF_FOR_DOG = 1.2;
    private final static double DEFAULT_JUMP_VALUE = 8;

    public Dog(int age, String name, String type) {
        super(age, name);
        this.type = type;
    }

    @Override
    public boolean jump(double distance) {
        if (type.equalsIgnoreCase(TYPE_BULDOG)){
            return distance <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_BULDOG * COEF_FOR_DOG;
        } else if (type.equalsIgnoreCase(TYPE_DOG)){
            return distance <= DEFAULT_JUMP_VALUE * COEF_OF_JUMP_DOG * COEF_FOR_DOG;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
