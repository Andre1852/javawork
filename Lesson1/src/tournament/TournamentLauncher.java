package tournament;

import participant.*;

import java.util.ArrayList;
import java.util.List;

public class TournamentLauncher {
    public static void main(String[] args) {
        List<Animal> members = new ArrayList<>(5);
        members.add(0, new Cat(5, "BARSIK", Cat.TYPE_BRITISH));
        members.add(1, new Cat(4, "KISYA", Cat.TYPE_PERSIA));
        members.add(2, new Dog(6, "REX", Dog.TYPE_BULDOG));
        members.add(3, new Human(26, "PETER", Gender.MALE));

        for (Animal animal: members
             ) {
            System.out.println(animal.toString() +":" + animal.jump(3));
        }

        //members.forEach(animal -> {
         //   System.out.println(animal.toString() +":" + animal.jump(10));
        //});
    }
}
