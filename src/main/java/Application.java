import entities.Developer;
import services.DeveloperService;

public class Application {
    public static void main(String[] args) {
        Developer developer = new Developer();
        developer.setAge(28);
        developer.setCity("Ananmtd");
        developer.setName("Vovchik");
        developer.setSalary(500);

        DeveloperService developerService = new DeveloperService();
        developerService.add(developer);
    }
}
