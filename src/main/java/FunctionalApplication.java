import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FunctionalApplication {

    private static List<Pet> petList;
    public static void main(String[] args) {
        testStream();
    }

    private static void testStream() {
        getPetList();

        System.out.println("---------- FOREACH ----------");
        petList.stream().forEach(pet -> {
            System.out.println(pet.toString());
        });

        System.out.println("---------- FILTER MAP ----------");
        getPetList();
        List<String> nameList = petList.stream()
                .filter(pet -> pet.getAge() > 2)
                .map(Pet::getName).collect(Collectors.toList());
        nameList.stream().forEach(name -> System.out.println(name));
    }

    private static void getPetList() {
        petList = List.of(
                new Pet(1, "Frank", 15),
                new Pet(2, "Rex", 2),
                new Pet(3, "Boby", 2),
                new Pet(4, "Alpha", 3)
        );
    }
}
