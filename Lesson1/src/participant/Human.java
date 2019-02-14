package participant;

public class Human extends Animal {
    private Gender gender;
    private final static double COEF_FOR_HUMAN = 1.0;
    private final static double DEFAULT_JUMP_VALUE = 9;

    public Human(int age, String name, Gender gender) {
        super(age, name);
        this.gender = gender;
    }

    @Override
    public boolean jump(double distance) {
        return distance <= gender.getCoef() * COEF_FOR_HUMAN * DEFAULT_JUMP_VALUE;

    }

    @Override
    public String toString() {
        return "Human{" +
                "gender=" + gender +
                "} " + super.toString();
    }
}
