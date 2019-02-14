package homework1;

import java.util.ArrayList;
import java.util.List;

public class TourImpl {
    public static void main(String[] args) {

        Team team = new Team("Real");// не разобрался с доступом во вложенные классы

        //команда Real снимается с соревнований
        //выступают отдельные участники
        List<Member> members = new ArrayList<>(3);
        members.add(0, new Member("Пётр", 4000, 1100, 7));
        members.add(1, new Member("Лев", 5000, 1000, 8));
        members.add(2, new Member("Ольга", 3000, 1300, 6.5));

        System.out.println();
        System.out.println("Отдельные участники");
        System.out.println(members.get(0));
        System.out.println(members.get(1));
        System.out.println(members.get(2));
        System.out.println();

        System.out.println("----- Турнир начинается -----");
        System.out.println();

        Course course = new Course(3000, 1000, 7.5);

        for (Member member: members
             ) {
            System.out.println(member + "  :" + course.courseImpl(member));

        }



        }
}
