import entities.Developer;
import services.DeveloperRepository;

public class Application {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setAge(28);
        developer.setCity("Ananmtd");
        developer.setName("Vovchik");
        developer.setSalary(500);

        DeveloperRepository developerdeveloperRepository = new DeveloperRepository();
        developerdeveloperRepository.add(developer);
    }
}
