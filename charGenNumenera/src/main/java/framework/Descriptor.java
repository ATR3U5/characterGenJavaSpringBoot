package framework;

import WebController.Application;
import addendum.Abilities;

import java.util.ArrayList;
import java.util.HashMap;

public class Descriptor extends Attributes {


    //I use a hash map library to connect every descriptor
    private HashMap<Integer, String> descriptor = new HashMap<>();
    private String chosenDescriptor;

    public Descriptor() {

        //hash map is filled with foci
        descriptor.put(1, "Charming");
        descriptor.put(2, "Clever");
        descriptor.put(3, "Graceful");
        descriptor.put(4, "Intelligent");
        descriptor.put(5, "Learned");
        descriptor.put(6, "Mechamystical");
        descriptor.put(7, "Rugged");
        descriptor.put(8, "Stealthy");
        descriptor.put(9, "Strong");
        descriptor.put(10, "Strong-Willed");
        descriptor.put(11, "Swift");
        descriptor.put(12, "Tough");


        //descriptor is selected per random, different random number than in class or focus
        int random = randomNumber(descriptor.size(), 1);

        while (Application.characterFlag.equals("Hedge Magic") && (random == 6)) {
            random = randomNumber(descriptor.size(), 1);
        }

        while (Application.characterFlag.equals("Might Defense") && (random == 12)) {
            random = randomNumber(descriptor.size(), 1);
        }

        while (Application.characterFlag.equals("Speed Defense") && (random == 3)) {
            random = randomNumber(descriptor.size(), 1);
        }


        chosenDescriptor = descriptor.get(random);

        //chosen descriptor saves attribute adjustments to its own class-attributes
        switch (chosenDescriptor) {
            case "Charming":
                becomeCharming();
                break;
            case "Clever":
                becomeClever();
                break;
            case "Graceful":
                becomeGraceful();
                break;
            case "Intelligent":
                becomeIntelligent();
                break;
            case "Learned":
                becomeLearned();
                break;
            case "Mechamystical":
                becomeMechamystical();
                break;
            case "Rugged":
                becomeRugged();
                break;
            case "Stealthy":
                becomeStealthy();
                break;
            case "Strong":
                becomeStrong();
                break;
            case "Strong-Willed":
                becomeStrongWilled();
                break;
            case "Swift":
                becomeSwift();
                break;
            case "Tough":
                becomeTough();
                break;
            default:
                System.out.println("Error in Descriptor Switch");
        }
    }

    // one method for every descriptor

    private void becomeCharming() {

        this.intellect = 2;

        this.skills.add("Pleasant Social Interactions");
        this.skills.add("When using abilities that influence the minds of others");

        String[] randomContacts = {"Minor Noble", "Captain of Town Guard", "Aeon Priest", "Leader of large gang of thieves"};
        int randomContactNumber = randomNumber((randomContacts.length - 1), 0);
        this.contacts.add(randomContacts[randomContactNumber]);

        this.inabilities.add("Difficulty +1: Bad at studying, knowledge and understanding");
        this.inabilities.add("Difficulty +1: Resisting Mental Attacks due to bad Willpower");

        this.money = this.money + 10;
        Application.descriptorFlag = "test";
    }

    private void becomeClever() {

        this.intellect = 2;

        this.skills.add("Lies and Interactions with Trickery");
        this.skills.add("Defense against mental effects");
        this.skills.add("Identifying and Assessing Danger, Lies, Quality, Importance, Function or Power");

        this.inabilities.add("Difficulty +1: Bad at studying, knowledge and understanding");

        this.money = this.money + 10;
        Application.descriptorFlag = "test";

    }

    private void becomeGraceful() {

        this.speed = 2;

        this.skills.add("Balancing");
        this.skills.add("Careful Movement");
        this.skills.add("Physical Performance Arts");
        this.skills.add("Speed Defense");

        Application.descriptorFlag = "Graceful";

    }

    private void becomeIntelligent() {

        this.intellect = 2;

        this.skills.add("Any Area of Knowledge of your Choice");
        this.skills.add("Memorizing Facts that you have experienced");
        Application.descriptorFlag = "test";

    }

    private void becomeLearned() {

        this.intellect = 2;

        this.skills.add("Three Areas of Knowledge of your Choice");

        this.inabilities.add("Difficulty +1: Any Task involving charm, persuasion or social etiquette");

        this.equipment.add("2 books on topics of your choice.");
        Application.descriptorFlag = "test";

    }

    private void becomeMechamystical() {

        this.intellect = 2;

        this.skills.add("Numenera");

        this.inabilities.add("Difficulty +1: Any Task involving charm, persuasion or deception");

        Abilities mechaReference = new Abilities(chosenDescriptor, "Descriptor");
        this.abilities.add(mechaReference);

        Application.descriptorFlag = "Mechamystical";

        this.oddity = this.oddity + 1;
    }

    private void becomeRugged() {

        this.skills.add("Climbing");
        this.skills.add("Jumping");
        this.skills.add("Running");
        this.skills.add("Swimming");

        String[] randomSkillsAnimals = {"Training Animals", "Riding Animals", "Placating Animals"};
        int randomSkillNumber = randomNumber((randomSkillsAnimals.length - 1), 0);
        this.skills.add(randomSkillsAnimals[randomSkillNumber]);

        String[] randomSkillsPlants = {"Identifying Natural Plants", "Using Natural Plants"};
        randomSkillNumber = randomNumber((randomSkillsPlants.length - 1), 0);
        this.skills.add(randomSkillsPlants[randomSkillNumber]);

        this.inabilities.add("Difficulty +1: Any Task involving charm, persuasion or deception");

        this.equipment.add("Explorer's pack");
        Application.descriptorFlag = "test";

    }

    private void becomeStealthy() {

        this.speed = 2;

        this.skills.add("Stealth");
        this.skills.add("Lies and Interactions with trickery");
        this.skills.add("When using abilities that involve illusions or trickery");

        this.inabilities.add("Difficulty +1: Any Task involving fast movement while in plain sight"); //houseruled, original inability was stupid
        Application.descriptorFlag = "test";

    }

    private void becomeStrong() {

        this.might = 4;

        this.skills.add("Smashing");
        this.skills.add("Jumping");

        this.equipment.add("One medium or heavy weapon");
        Application.descriptorFlag = "test";

    }

    private void becomeStrongWilled() {

        this.intellect = 4;

        this.skills.add("Resisting Mental Effects");
        this.skills.add("Concentration and Focus");

        this.inabilities.add("Difficulty +1: Bad at studying, knowledge and understanding");
        Application.descriptorFlag = "test";

    }

    private void becomeSwift() {

        this.speed = 4;

        this.skills.add("Initiative");
        this.skills.add("Running");

        this.inabilities.add("Difficulty +1: Bad at Balance");
        Application.descriptorFlag = "test";

    }

    private void becomeTough() {

        this.armor = this.armor + 1;
        this.skills.add("Might Defense");

        Abilities toughReference = new Abilities(chosenDescriptor, "Descriptor");
        this.abilities.add(toughReference);

        Application.descriptorFlag = "Tough";

        this.equipment.add("One light weapon");

    }


    //showing chosenFocus in generator class

    public String showChosen() {

        return chosenDescriptor;
    }


    public String showAttributes() {

        String tempReturn = null;

        if (this.intellect > 0) {
            tempReturn = "+" + intellect + " " + " Intellect Point(s)";
        } else if (this.might > 0) {
            tempReturn = "+" + might + " " + " Might Point(s)";
        } else if (this.speed > 0) {
            tempReturn = "+" + speed + " " + " Speed Point(s)";
        } else if (this.armor > 0) {
            tempReturn = "+" + armor + " " + " Armor Point(s)";
        } else {
            tempReturn = "No bonus attributes";
        }

        return tempReturn;
    }

    public String showMoney() {

        String money = null;

        if (this.money > 0) {
            money = this.money + " Shins";
        } else {
            money = "No bonus money";
        }

        return money;
    }

    public String showDescSkills() {

        return showSkills();
    }

    public String showInabilities(){
        String inabilities = null;

        if(this.inabilities.size()==0){
            inabilities = "No inabilities";
        }
        else {
            int x = 1;
            for(String s : this.inabilities ){
                if (x==1){
                    inabilities = "{"+ s + "} ";
                    x++;
                }
                else{
                    inabilities = inabilities + "{"+ s + "} ";
                }

            }

        }

        return inabilities;
    }

    public ArrayList<Abilities> showDescAbilities(){
        return this.abilities;
    }

    public String showEquipment(){
        return parseEquipment();
    }

    public String showDescConnections(){
        return parseConnections();
    }

    public String showDescCyphers(){
        return parseCyphers();
    }

    public String showDescOddities(){
        return parseOddities();
    }

}

