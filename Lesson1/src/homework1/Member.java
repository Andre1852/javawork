package homework1;

public class Member {
    private String name;
    private double distanceRun;
    private double distanceSwim;
    private double distanceJump;

    public Member(String name, double distanceRun, double distanceSwim, double distanceJump) {
        this.name = name;
        this.distanceRun = distanceRun;
        this.distanceSwim = distanceSwim;
        this.distanceJump = distanceJump;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistanceRun() {
        return distanceRun;
    }

    public void setDistanceRun(double distanceRun) {
        this.distanceRun = distanceRun;
    }

    public double getDistanceSwim() {
        return distanceSwim;
    }

    public void setDistanceSwim(double distanceSwim) {
        this.distanceSwim = distanceSwim;
    }

    public double getDistanceJump() {
        return distanceJump;
    }

    public void setDistanceJump(double distanceJump) {
        this.distanceJump = distanceJump;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", distanceRun=" + distanceRun +
                ", distanceSwim=" + distanceSwim +
                ", distanceJump=" + distanceJump +
                '}';
    }
}
