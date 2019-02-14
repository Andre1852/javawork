package homework1;

import java.util.ArrayList;
import java.util.List;

public class Team {
    class TeamMember {
        String name;
        double distanceRun;
        double distanceSwim;
        double distanceJump;

        @Override
        public String toString() {
            return "TeamMember{" +
                    "name='" + name + '\'' +
                    ", distanceRun=" + distanceRun +
                    ", distanceSwim=" + distanceSwim +
                    ", distanceJump=" + distanceJump +
                    '}';
        }

        public String getName() {
            return name;
        }

        public double getDistanceRun() {
            return distanceRun;
        }

        public double getDistanceSwim() {
            return distanceSwim;
        }

        public double getDistanceJump() {
            return distanceJump;
        }

        public TeamMember(String name, double distanceRun, double distanceSwim, double distanceJump) {
            this.name = name;
            this.distanceRun = distanceRun;
            this.distanceSwim = distanceSwim;
            this.distanceJump = distanceJump;

        }
    }
    String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
        teamBuilding(teamName);
    }

    public void teamBuilding(String teamName){
        this.teamName = teamName;
        List<TeamMember> teamMembers = new ArrayList<>(3);
        teamMembers.add(0, new TeamMember("Олег", 5000, 1000, 7));
        teamMembers.add(1, new TeamMember("Иван", 6000, 900, 8));
        teamMembers.add(2, new TeamMember("Ирина", 4000, 1200, 6.5));

        System.out.println("Команда: " + teamName);
        System.out.println(teamMembers.get(0));
        System.out.println(teamMembers.get(1));
        System.out.println(teamMembers.get(2));

    }

    @Override
    public String toString() {
        return "Team{}";
    }
}
