package framework;

import WebController.Application;
import addendum.Abilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class CharacterClass extends Attributes {


    //I use a hash map library to connect every focus to a number
    private HashMap<Integer, String> classes = new HashMap<>();
    private String chosenClass;
    private String abilityType;

    public CharacterClass(){

        //hash map is filled
        classes.put(1, "Glaive");
        classes.put(2, "Jack");
        classes.put(3, "Seeker");
        classes.put(4, "Glint");
        classes.put(5, "Nano");

        //random class is selected
        int random = randomNumber(classes.size(), 1);
        chosenClass = classes.get(random);

        //attributes of this class are adjusted depending on the chosen class
        switch(chosenClass) {
            case "Glaive":
                becomeGlaive();
                break;
            case "Jack":
                becomeJack();
                break;
            case "Seeker":
                becomeSeeker();
                break;
            case "Glint":
                becomeGlint();
                break;
            case "Nano":
                becomeNano();
                break;
            default:
                System.out.println("Error in CharacterClass Switch");
        }

    }

    //a method for every class to select the corresponding attributes
    private void becomeGlaive(){

        abilityType = "Combat Moves";

        this.intellect = 7;
        this.might = 11;
        this.speed = 10;

        this.edge.add("Might");
        this.edge.add("Speed");

        String[] randomSkills = {"Balancing", "Climbing", "Jumping", "Swimming"};
        int randomSkillNumber = randomNumber((randomSkills.length-1), 0);
        this.skills.add(randomSkills[randomSkillNumber]);
        this.meritSkills.add("Knowledgeable: Any Weapon");
        this.meritSkills.add("Practiced: Armor");

        randomGlaiveAbilities();

        this.cypherMax = 2;

        this.equipment.add("Street Clothes");
        this.equipment.add("Two Weapons OR A Weapon and a Shield)");
        this.equipment.add("Light OR Medium Armor");
        this.equipment.add("Explorer's Pack");
        this.oddity = this.oddity + 1;
        this.money = this.money + 5;

    }

    private void becomeJack(){

        abilityType = "Tricks of the Trade";

        this.intellect = 10;
        this.might = 10;
        this.speed = 10;

        //dummy-implementation -> Archetype Choice will determine chosen Edge, possible random skills

        this.edge.add("Speed");

        //at the moment, any of the available skills will be chosen at random
        String[] randomSkills = {"Astronomy", "Balancing", "Biology", "Botany", "Carrying", "Climbing", "Deceiving", "Escaping", "Geography", "Geology", "Healing", "History", "Identifying", "Initiative", "Intimidation", "Jumping", "Leatherworking", "Lockpicking", "Metalworking", "Numenera", "Perception", "Persuasion", "Philosophy", "Pickpocketing", "Repairing", "Riding", "Smashing", "Sneaking", "Swimming", "Woodworking"};
        int randomSkillNumber = randomNumber((randomSkills.length-1), 0);
        this.skills.add(randomSkills[randomSkillNumber]);

        this.meritSkills.add("Practiced: Light Weapons");
        this.meritSkills.add("Practiced: Medium Weapons");

        this.abilities.add(new Abilities("Flex Skill", "TT"));
        randomJackAbilities();

        this.cypherMax = 2;

        this.equipment.add("Street Clothes");
        this.equipment.add("Two Weapons");
        this.equipment.add("Light Armor");
        this.equipment.add("Explorer's Pack");
        this.equipment.add("Pack of light tools");
        this.cypher = this.cypher + 2;
        this.oddity = this.oddity + 1;
        this.money = this.money + 8;

    }

    private void becomeNano(){

        abilityType = "Esoteries";

        this.intellect = 12;
        this.might = 7;
        this.speed = 9;

        this.edge.add("Intellect");

        this.skills.add("Numenera");
        this.meritSkills.add("Practiced: Light Weapons");

        randomNanoAbilities();

        this.cypherMax = 3;

        this.equipment.add("Street Clothes");
        this.equipment.add("One Weapon");
        this.equipment.add("Book about the Numenera");
        this.oddity = this.oddity + 1;
        this.cypher = this.cypher + 3;
        this.money = this.money + 4;

    }

    private void becomeGlint(){

        abilityType = "Pronouncements";

        this.intellect = 11;
        this.might = 8;
        this.speed = 9;

        this.edge.add("Intellect");
        ArrayList<String> interactions = new ArrayList<>();
        interactions.add("Deceiving");
        interactions.add("Persuasion");
        interactions.add("Public Speaking");
        interactions.add("Seeing through Deception");
        interactions.add("Intimidation");

        this.meritSkills.add("Practiced: Light Weapons");
        int randomSkillNumber = randomNumber((interactions.size()-1), 0);

        this.skills.add(interactions.get(randomSkillNumber));
        interactions.remove(randomSkillNumber);

        randomSkillNumber = randomNumber((interactions.size()-1), 0);
        this.skills.add(interactions.get(randomSkillNumber));

        //Similar dummy implementation to Jack implementation

        String[] randomSkills = {"Astronomy", "Balancing", "Biology", "Botany", "Carrying", "Climbing", "Deceiving", "Escaping", "Geography", "Geology", "Healing", "History", "Identifying", "Initiative", "Intimidation", "Jumping", "Leatherworking", "Lockpicking", "Metalworking", "Numenera", "Perception", "Persuasion", "Philosophy", "Pickpocketing", "Repairing", "Riding", "Smashing", "Sneaking", "Swimming", "Woodworking"};
        randomSkillNumber = randomNumber((randomSkills.length-1), 0);

        this.skills.add(randomSkills[randomSkillNumber]);

            int dummyNumber = randomNumber((randomSkills.length-1), 0);

            while(dummyNumber == randomSkillNumber)
            {
                dummyNumber = randomNumber((randomSkills.length-1), 0);
            }

        this.skills.add(randomSkills[dummyNumber]);

        randomGlintAbilities();

        this.cypherMax = 2;

        this.equipment.add("Stylish Clothes");
        this.equipment.add("One Light Weapon)");
        this.cypher = this.cypher + 2;
        this.oddity = this.oddity + 1;
        this.money = this.money + 9;

    }

    private void becomeSeeker(){

        abilityType = "Secrets";

        this.intellect = 9;
        this.might = 9;
        this.speed = 10;

        this.edge.add("Speed");

        //Similar dummy implementation to Jack
        String[] randomSkills = {"Astronomy", "Balancing", "Biology", "Botany", "Carrying", "Climbing", "Deceiving", "Escaping", "Geography", "Geology", "Healing", "History", "Identifying", "Initiative", "Intimidation", "Jumping", "Leatherworking", "Lockpicking", "Metalworking", "Numenera", "Perception", "Persuasion", "Philosophy", "Pickpocketing", "Repairing", "Riding", "Smashing", "Sneaking", "Swimming", "Woodworking"};
        int randomSkillNumber = randomNumber((randomSkills.length-1), 0);

        this.skills.add(randomSkills[randomSkillNumber]);

            int dummyNumber = randomNumber((randomSkills.length-1), 0);

            while(dummyNumber == randomSkillNumber)
            {
                dummyNumber = randomNumber((randomSkills.length-1), 0);
            }

        this.skills.add(randomSkills[dummyNumber]);

        this.skills.add("Numenera");
        this.skills.add("Numenera"); //adding it double to allow the system to tag it as "specialized"
        this.skills.add("Might Defense");
        this.meritSkills.add("Practiced: Light Weapons");
        this.meritSkills.add("Practiced: Medium Weapons");

        randomSeekerAbilities();

        this.cypherMax = 3;

        this.equipment.add("Street Clothes");
        this.equipment.add("Two Weapons OR A Weapon and a Shield");
        this.equipment.add("Light Armor");
        this.equipment.add("Explorer's Pack");
        this.cypher = this.cypher + 3;
        this.oddity = this.oddity + 1;
        this.money = this.money + 3;

    }



    //used in generator to show character class chosen by the random number
    public String showChosen(){

        return chosenClass;
    }

    public String showAbilityTypeDesc(){

        String abilityTypeDesc = null;

        switch(chosenClass) {
            case "Glaive":
                abilityTypeDesc = "You are able to perform fighting moves which other characters can barely follow. Your combat moves will be marked by [CM].";
                break;
            case "Jack":
                abilityTypeDesc = "You acquired a wide number of tricks to keep people on their toes around you; Some mundane, some related to the numenera. Your tricks will be marked by [TT].";
                break;
            case "Seeker":
                abilityTypeDesc = "You have found secrets on your adventures and some of you are forever ingrained into your very being. Your secrets will be marked by [SC].";
                break;
            case "Glint":
                abilityTypeDesc = "Your special abilities come from your voice. Creatures often need to be able to comprehend your words in order for your powers to work. Your pronouncements will be marked by [PM].";
                break;
            case "Nano":
                abilityTypeDesc = "You can tap into the numenera to reshape the world around you. Your esoteries will be marked by [EO].";
                break;
            default:
                abilityTypeDesc = "Error in showAbilityType Switch";

        }

        return abilityTypeDesc;
    }

    public String showAbilityType(){
        return abilityType;
    }

    private void randomGlaiveAbilities(){

        ArrayList<String> tempSkillList = new ArrayList<>();
        tempSkillList.add("Bash");
        tempSkillList.add("No Weapons");
        tempSkillList.add("Pierce");
        tempSkillList.add("Thrust");
        tempSkillList.add("Trained without Armor");


        int random_1 = randomNumber(tempSkillList.size()-1, 0);
        int random_2 = randomNumber(tempSkillList.size()-1, 0);

        while(random_1 == random_2){

            random_2 = randomNumber(tempSkillList.size()-1, 0);
        }

        addClassAbilities(tempSkillList.get(random_1), "CM");
        addClassAbilities(tempSkillList.get(random_2), "CM");

    }

    private void randomGlintAbilities(){

        ArrayList<String> tempSkillList = new ArrayList<>();
        tempSkillList.add("Coax");
        tempSkillList.add("Connection");
        tempSkillList.add("Contact");
        tempSkillList.add("Encouragement");
        tempSkillList.add("Fast Talk");
        tempSkillList.add("Friendship");
        tempSkillList.add("Influence");


        int random_1 = randomNumber(tempSkillList.size()-1, 0);
        int random_2 = randomNumber(tempSkillList.size()-1, 0);

        while(random_1 == random_2){

            random_2 = randomNumber(tempSkillList.size()-1, 0);
        }

        addClassAbilities(tempSkillList.get(random_1), "PM");
        addClassAbilities(tempSkillList.get(random_2), "PM");

    }

    private void randomNanoAbilities(){

        ArrayList<String> tempSkillList = new ArrayList<>();
        tempSkillList.add("Hedge Magic");
        tempSkillList.add("Onslaught");
        tempSkillList.add("Push");
        tempSkillList.add("Scan");
        tempSkillList.add("Ward");

        if (Application.descriptorFlag.equals("Mechamystical")){
            tempSkillList.remove("Hedge Magic");
        }

        int random_1 = randomNumber(tempSkillList.size()-1, 0);
        int random_2 = randomNumber(tempSkillList.size()-1, 0);

        while(random_1 == random_2){

            random_2 = randomNumber(tempSkillList.size()-1, 0);
        }

        addClassAbilities(tempSkillList.get(random_1), "EO");
        addClassAbilities(tempSkillList.get(random_2), "EO");

        if (tempSkillList.get(random_1).equals("Hedge Magic") || tempSkillList.get(random_2).equals("Hedge Magic")){

            Application.characterFlag = "Hedge Magic";

        }
        else{
            Application.characterFlag = "test";
        }
    }

    private void randomSeekerAbilities(){

        ArrayList<String> tempSkillList = new ArrayList<>();
        tempSkillList.add("Battle Numenera");
        tempSkillList.add("Danger Sense");
        tempSkillList.add("Decipher");
        tempSkillList.add("Knowledge");
        tempSkillList.add("Muscles of Iron");
        tempSkillList.add("Physical");
        tempSkillList.add("Practiced in Armor");
        tempSkillList.add("Trained without Armor");

        int random_1 = randomNumber(tempSkillList.size()-1, 0);
        int random_2 = randomNumber(tempSkillList.size()-1, 0);

        while(random_1 == random_2){

            random_2 = randomNumber(tempSkillList.size()-1, 0);
        }

        ArrayList<String> physicalSkills = new ArrayList<>();
        physicalSkills.add("Balancing");
        physicalSkills.add("Climbing");
        physicalSkills.add("Jumping");
        physicalSkills.add("Running");
        physicalSkills.add("Swimming");

        if (tempSkillList.get(random_1).equals("Physical")){

            int x = 0;
            while(x<physicalSkills.size()){

                String temp = this.skills.get(0);

                if (temp.equals(physicalSkills.get(x))){
                    physicalSkills.remove(x);
                }

                x++;
            }

            int random_3 = randomNumber(physicalSkills.size()-1, 0);
            int random_4 = randomNumber(physicalSkills.size()-1, 0);

            while (random_3 == random_4){

                random_4 = randomNumber(physicalSkills.size()-1, 0);
            }

            this.skills.add(physicalSkills.get(random_3));
            this.skills.add(physicalSkills.get(random_4));

            addClassAbilities(tempSkillList.get(random_2), "SC");

        }

        else if (tempSkillList.get(random_2).equals("Physical")){

            int x = 0;
            while(x<physicalSkills.size()){

                String temp = this.skills.get(0);

                if (temp.equals(physicalSkills.get(x))){
                    physicalSkills.remove(x);
                }

                x++;
            }

            int random_3 = randomNumber(physicalSkills.size()-1, 0);
            int random_4 = randomNumber(physicalSkills.size()-1, 0);

            while (random_3 == random_4){

                random_4 = randomNumber(physicalSkills.size()-1, 0);
            }

            this.skills.add(physicalSkills.get(random_3));
            this.skills.add(physicalSkills.get(random_4));

            addClassAbilities(tempSkillList.get(random_1), "SC");

        }

        else {

            addClassAbilities(tempSkillList.get(random_1), "SC");
            addClassAbilities(tempSkillList.get(random_2), "SC");

        }

    }

    private void randomJackAbilities(){

        ArrayList<String> tempSkillList = new ArrayList<>();
        tempSkillList.add("Bash");
        tempSkillList.add("Hedge Magic");
        tempSkillList.add("Pierce");
        tempSkillList.add("Practiced in Armor");
        tempSkillList.add("Might Defense");
        tempSkillList.add("Speed Defense");
        tempSkillList.add("Intellect Defense");
        tempSkillList.add("Thrust");
        tempSkillList.add("Trained without Armor");

        if (Application.descriptorFlag.equals("Mechamystical")){
            tempSkillList.remove("Hedge Magic");
        }
        else if (Application.descriptorFlag.equals("Tough")){

            tempSkillList.remove("Might Defense");

        }
        else if (Application.descriptorFlag.equals("Graceful")){

            tempSkillList.remove("Speed Defense");
        }

        int random_1 = randomNumber(tempSkillList.size()-1, 0);
        int random_2 = randomNumber(tempSkillList.size()-1, 0);

            while(random_1 == random_2){

                random_2 = randomNumber(tempSkillList.size()-1, 0);
            }

        addClassAbilities(tempSkillList.get(random_1), "TT");
        addClassAbilities(tempSkillList.get(random_2), "TT");

        String temp_1 = tempSkillList.get(random_1);
        String temp_2 = tempSkillList.get(random_2);

        if(temp_1.equals("Hedge Magic") || temp_2.equals("Hedge Magic")){

            Application.characterFlag = "Hedge Magic";

        }

        else if (temp_1.equals("Might Defense") || temp_2.equals("Might Defense")){

            Application.characterFlag = "Tough";

        }

        else if (temp_1.equals("Speed Defense") || temp_2.equals("Speed Defense")){

            Application.characterFlag = "Graceful";

        }
        else{
            Application.characterFlag = "test";
        }


    }

    private void addClassAbilities(String pAbility, String pAbbreviation){

        switch(pAbility){
            case "Bash":
                this.abilities.add(new Abilities("Bash", pAbbreviation));
                break;
            case "Battle Numenera":
                this.abilities.add(new Abilities("Battle Numenera", pAbbreviation));
                break;
            case "Coax":
                this.abilities.add(new Abilities("Coax", pAbbreviation));
                break;
            case "Connection":
                this.abilities.add(new Abilities("Connection", pAbbreviation));
                break;
            case "Contact":
                String[] randomContacts = {"Minor Noble", "Captain of Town Guard", "Aeon Priest", "Leader of large gang of thieves"};
                int randomContactNumber = randomNumber((randomContacts.length-1), 0);
                this.contacts.add(randomContacts[randomContactNumber]);
                break;
            case "Danger Sense":
                this.abilities.add(new Abilities("Danger Sense", pAbbreviation));
                break;
            case "Decipher":
                this.abilities.add(new Abilities("Decipher", pAbbreviation));
                break;
            case "Encouragement":
                this.abilities.add(new Abilities("Encouragement", pAbbreviation));
                break;
            case "Fast Talk":
                this.abilities.add(new Abilities("Fast Talk", pAbbreviation));
                break;
            case "Friendship":
                this.abilities.add(new Abilities("Friendship", pAbbreviation));
                break;
            case "Influence":
                this.abilities.add(new Abilities("Influence", pAbbreviation));
                break;
            case "Hedge Magic":
                this.abilities.add(new Abilities("Hedge Magic", pAbbreviation));
                break;
            case "Intellect Defense":
                this.skills.add("Intellect Defense");
                break;
            case "Knowledge":
                this.abilities.add(new Abilities("Knowledge", pAbbreviation));
                break;
            case "Might Defense":
                this.skills.add("Might Defense");
                break;
            case "Muscles of Iron":
                this.abilities.add(new Abilities("Muscles", pAbbreviation));
                break;
            case "No Weapons":
                this.abilities.add(new Abilities("NoWeapons", pAbbreviation));
                break;
            case "Onslaught":
                this.abilities.add(new Abilities("Onslaught", pAbbreviation));
                break;
            case "Pierce":
                this.abilities.add(new Abilities("Pierce", pAbbreviation));
                break;
            case "Practiced in Armor":
                this.meritSkills.add("Practiced: Armor");
                break;
            case "Push":
                this.abilities.add(new Abilities("Push", pAbbreviation));
                break;
            case "Scan":
                this.abilities.add(new Abilities("Scan", pAbbreviation));
                break;
            case "Speed Defense":
                this.skills.add("Speed Defense");
                break;
            case "Thrust":
                this.abilities.add(new Abilities("Thrust", pAbbreviation));
                break;
            case "Trained without Armor":
                this.abilities.add(new Abilities("NoArmor", pAbbreviation));
                break;
            case "Ward":
                this.armor = this.armor + 1;
                break;

            default:
                System.out.println("Error in ClassAbilitiesSwitch");

        }

    }

    public String showclassIntellect(){
        return "Intellect: " + this.intellect;
    }

    public String showclassMight(){
        return "Might: " + this.might;
    }

    public String showclassSpeed(){
        return "Speed: " + this.speed;
    }

    public String showclassArmor(){
        return "Natural Armor: " + this.armor;
    }
    public String showclassEdge(){

        String edge = "Edge in Attribute: " + "{ " + this.edge.get(0) + " }";

        if(this.edge.size()>1){
            edge = edge + " {" + this.edge.get(1) + " }";
        }
        return edge;
    }

    public String showclassEffort(){
        return "Effort: " + this.effort;
    }

    public String showclassCypherMax(){
        return "Cypher-Maximum: " + this.cypherMax;
    }

    public String showclassMoney(){
        return this.money + " Shins";
    }

    public String showclassMeritSkills(){

        String skills = "test";

        if(this.meritSkills.size()>0){
            int x = 1;
            for(String s: this.meritSkills){
                if(x==1){
                    skills = "{" + s + "}";
                    x++;
                }
                else{
                    skills  = skills + "{" + s + "}";
                }
            }
        }

        return skills;
    }

    public String showClassSkills() {
        return showSkills();
    }

    public ArrayList<Abilities> showClassAbilities(){
        return this.abilities;
    }

    public String showClassEquipment(){

        return parseEquipment();
    }

    public String showClassConnections(){

        return parseConnections();
    }

    public String showClassCyphers(){
        return parseCyphers();
    }

    public String showClassOddities(){
        return parseOddities();
    }

}
