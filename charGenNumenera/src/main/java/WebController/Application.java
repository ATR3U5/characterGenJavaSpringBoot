package WebController;

import framework.CharacterClass;
import framework.CharacterSheet;
import framework.Descriptor;
import framework.Focus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static String descriptorFlag = "test";
    public static String characterFlag = "test";

    public static CharacterClass newClass = null;
    public static Descriptor newDescriptor = null;
    public static Focus newFocus = null;
    public static CharacterSheet newSheet = null;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        Application.newClass = new CharacterClass();
        Application.newDescriptor = new Descriptor();
        Application.newFocus = new Focus();

        System.out.println("You are a " + Application.newDescriptor.showChosen() + " " + Application.newClass.showChosen() + " who " + Application.newFocus.showChosen());
        Application.newSheet = new CharacterSheet(Application.newClass, Application.newDescriptor, Application.newFocus);

    }

}