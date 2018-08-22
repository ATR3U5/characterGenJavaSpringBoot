package framework;

import addendum.Abilities;

import java.util.ArrayList;
import java.util.HashMap;

public class Focus extends Attributes {

    //I use a hash map library to connect every focus to a number
    private HashMap<Integer, String> foci = new HashMap<>();
    private String chosenFocus;
    private String characterConnection;

    public Focus(){

        //hash map is filled with foci
        foci.put(1, "Bears a Halo of Fire");
        foci.put(2, "Carries a Quiver");
        foci.put(3, "Commands Mental Powers");
        foci.put(4, "Crafts Illusions");
        foci.put(5, "Explores Dark Places");
        foci.put(6, "Fuses Flesh and Steel");
        foci.put(7, "Masters Weaponry");
        foci.put(8, "Rides the Lightning");
        foci.put(9, "Talks to Machines");
        foci.put(10, "Wears a Sheen of Ice");
        foci.put(11, "Wields Two Weapons at Once");
        foci.put(12, "Works Miracles");


        //focus is selected per random, different random number than in class or descriptor
        int random = randomNumber(foci.size(), 1);
        chosenFocus = foci.get(random);

        Abilities focusAbilityReference = new Abilities(chosenFocus, "Focus");
        this.abilities.add(focusAbilityReference);

        this.skills.addAll(focusAbilityReference.addFocusSkills());

        characterConnection = focusAbilityReference.connectingCharacters();

        this.armor = focusAbilityReference.armor;
        this.intellect = focusAbilityReference.intellect;
        this.might = focusAbilityReference.might;
        this.speed = focusAbilityReference.speed;
        this.equipment.addAll(focusAbilityReference.equipment);
        //chosen focus saves attribute adjustments to its own class-attributes

    }


    //showing chosenFocus in generator class

    public String showChosen(){

        return chosenFocus;
    }

    public String showConnection(){

        return characterConnection;
    }

    public String causeOfFocus(){

        int random = randomNumber(100,1);

        if(random<=5){
            return "Your abilities are caused by a natural mutation.";
        }
        else if(random<=9){
            return "Your abilities are caused by an unexpected viral reconstruction of your body.";
        }
        else if(random<=15){
            return  "Your abilities are caused by a mutation due to ancestral exposure to chemicals, radiation or a virus";
        }
        else if(random<=21){
            return "Your abilities are caused by a mutation due to experimental science performed on your ancestors";
        }
        else if(random<=27){
            return "Your abilities are caused by an encounter with the Iron Wind, which caused a nanotech reconstruction of your body";
        }
        else if(random==28){
            return "Your abilities are caused by an abduction by extraterrestrials who experimented on you.";
        }
        else if(random == 29){
            return "Your abilities are caused by an abduction by rogue scientists who experimented on you.";
        }
        else if(random==30){
            return "Your abilities are caused by an abduction by a machine intelligence which experimented on you.";
        }
        else if(random==31){
            return "Your abilities are caused by an encounter with with an ultraterrestrial entity that mysteriously changed you.";
        }
        else if(random<=35){
            return "Your abilities are caused by an intentional or accidental fusion with mechanical devices in your fingertips.";
        }
        else if(random <= 39){
            return "Your abilities are caused by an intentional or accidental fusion with mechanical devices in your palms.";
        }
        else if(random <= 43){
            return "Your abilities are caused by an intentional or accidental fusion with mechanical devices in your head or eye.";
        }
        else if(random <= 47){
            return "Your abilities are caused by an intentional or accidental fusion with mechanical devices in your chest.";
        }
        else if(random <= 51){
            return "Your abilities are caused by an intentional or accidental immersion or treatment with ancient chemicals or radiation.";
        }
        else if(random <= 56){
            return "Your abilities are caused by ancient artifacts which are secreted on your person.";
        }
        else if(random <= 60){
            return "Your abilities are caused by a cloud of nanotech which follows and responds to you for unknown reasons.";
        }
        else if(random <= 64){
            return "Your abilities are caused by an implant or mutation that provides knowledge and power from the datasphere.";
        }
        else if(random <= 66){
            return "Your abilities are caused by drugs.";
        }
        else if(random == 67){
            return "Your abilities are caused by training with extraterrestrial entities in strange and mysterious devotions.";
        }
        else if(random <= 69){
            return "Your abilities are caused by training with a secret order that has mastered mysteries passed down from the ancients.";
        }
        else if(random == 70 ){
            return "Your abilities are caused by training with machine intelligence that shared inhuman knowledge.";
        }
        else if(random <= 80){
            return causeOfFocus();
        }
        else{
            return "Your abilities are caused by --UNKNOWN--. Ask GM to think for a reason. That reason will be kept hidden from you.";
        }

    }

    public ArrayList<Abilities> showFocusAbilities(){
        return this.abilities;
    }

    public String showFocusIntellect(){
        return "+" + this.intellect + " Intellect Point(s)";
    }
    public String showFocusSpeed(){
        return "+" + this.speed + " Speed Point(s)";
    }
    public String showFocusMight(){
        return "+" + this.might + " Might Point(s)";
    }
    public String showFocusArmor(){
        return "+" + this.armor + " Armor Point(s)";
    }

    public String showFocusSkills() {

        return showSkills();
    }

    public String showFocusEquipment(){
        return parseEquipment();
    }

    public String showFocusCyphers(){
        return parseCyphers();
    }

    public String showFocusOddities(){
        return parseOddities();
    }

}
