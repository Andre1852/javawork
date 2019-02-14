package homework1;

public class Course {
    private double runCourse;
    private double swimCourse;
    private double jumpCourse;

    public Course(double runCourse, double swimCourse, double jumpCourse) {
        this.runCourse = runCourse;
        this.swimCourse = swimCourse;
        this.jumpCourse = jumpCourse;
    }

    public boolean courseImpl(Member member){
        if (this.runCourse <= member.getDistanceRun() &&
        this.swimCourse <= member.getDistanceSwim() &&
        this.jumpCourse <= member.getDistanceJump()){
            return true;
        }
        return false;
    }
}
