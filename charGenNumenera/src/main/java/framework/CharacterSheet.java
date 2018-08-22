package framework;

import addendum.Abilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CharacterSheet extends Attributes {

    private ArrayList<String> meritSkillList = new ArrayList<>();
    private ArrayList<String> prodigySkillList = new ArrayList<>();
    private ArrayList<String> specializedSkillList = new ArrayList<>();
    private ArrayList<String> trainedSkillList = new ArrayList<>();


    public CharacterSheet(CharacterClass pClass, Descriptor pDescriptor, Focus pFocus) {

        this.intellect = pClass.intellect;
        this.speed = pClass.speed;
        this.might = pClass.might;
        this.armor = pClass.armor;

        //adds adjustments to attribute pools
        descriptorAdjustments(pDescriptor);
        focusAdjustments(pFocus);

        //adds and sorts skill lists
        mergingSkillLists(pClass.skills, pDescriptor.skills, pFocus.skills, pClass.meritSkills);  //this logic became quite complicated, so i put it into it's own method for better service in the future

        //adds ability lists together
        this.abilities.addAll(pFocus.abilities);
        this.abilities.addAll(pDescriptor.abilities);
        this.abilities.addAll(pClass.abilities);


        // shows player equipment
        // In case the Explorer's pack is found twice in the character, only one explorer's pack is displayed, the other is swapped with additional equipment depending on the case

        if ((pDescriptor.showChosen().equals("Rugged") | pFocus.showChosen().equals("Explores Dark Places")) && (pClass.showChosen().equals("Glaive") || pClass.showChosen().equals("Jack") || pClass.showChosen().equals("Seeker"))) {

            if (pDescriptor.showChosen().equals("Rugged") && pFocus.showChosen().equals("Explores Dark Places")) {
                this.equipment.add("30 meters of rope");
                this.equipment.add("4 days worth of extra-rations");
                this.equipment.add("2 minor glowglobes");
                this.equipment.add("One ranged weapon + 12 ammunition");
                this.equipment.addAll(pClass.equipment);
            } else if (pDescriptor.showChosen().equals("Rugged")) {
                this.equipment.add("15 meters of rope");
                this.equipment.add("2 days worth of extra-rations");
                this.equipment.add("One ranged weapon + 12 ammunition");
                this.equipment.addAll(pFocus.equipment);
                this.equipment.addAll(pClass.equipment);
            } else if (pFocus.showChosen().equals("Explores Dark Places")) {
                this.equipment.add("15 meters of rope");
                this.equipment.add("2 days worth of extra-rations");
                this.equipment.add("2 minor glowglobes");
                this.equipment.addAll(pDescriptor.equipment);
                this.equipment.addAll(pClass.equipment);
            }
        } else {

            this.equipment.addAll(pClass.equipment);
            this.equipment.addAll(pFocus.equipment);
            this.equipment.addAll(pDescriptor.equipment);

        }

        //pools money, number of cyphers and number of oddities

        this.money = this.money + pClass.money + pFocus.money + pDescriptor.money;
        this.cypher = this.cypher + pClass.cypher + pFocus.cypher + pDescriptor.cypher;
        this.oddity = this.oddity + pClass.oddity + pFocus.oddity + pDescriptor.oddity;
        Collections.sort(this.equipment);

        // contacts
        //if statement checks if there are any contacts present, otherwise this part is unnecessary

        this.contacts.addAll(pDescriptor.contacts);
        this.contacts.addAll(pClass.contacts);

        if (this.contacts.size() > 1) {

            //checks if contacts from different sources are the same, then replaces one of them with a different contact

            while (this.contacts.get(0).equals(this.contacts.get(1))) {
                this.contacts.remove(1);
                String[] randomContacts = {"Minor Noble", "Captain of Town Guard", "Aeon Priest", "Leader of large gang of thieves"};
                int randomContactNumber = randomNumber((randomContacts.length - 1), 0);
                this.contacts.add(randomContacts[randomContactNumber]);
            }

            Collections.sort(this.contacts);
        }

    }

    private void descriptorAdjustments(Descriptor pDescriptor) {

        this.intellect = this.intellect + (pDescriptor.intellect);
        this.speed = this.speed + (pDescriptor.speed);
        this.might = this.might + (pDescriptor.might);
        this.armor = this.armor + (pDescriptor.armor);

    }

    private void focusAdjustments(Focus pFocus) {

        this.intellect = this.intellect + (pFocus.intellect);
        this.speed = this.speed + (pFocus.speed);
        this.might = this.might + (pFocus.might);
        this.armor = this.armor + (pFocus.armor);

    }


    private void mergingSkillLists(ArrayList<String> classSkills, ArrayList<String> descriptorSkills, ArrayList<String> focusSkills, ArrayList<String> meritSkills) {

        ArrayList<String> upgradeSkills = new ArrayList<>(classSkills);
        upgradeSkills.addAll(descriptorSkills);
        upgradeSkills.addAll(focusSkills);
        Collections.sort(upgradeSkills);

        ArrayList<String> prodigyList = new ArrayList<>();
        ArrayList<String> specList = new ArrayList<>();

        int x = 0;

        while (x < upgradeSkills.size()) {  //this loop checks if there's double or triple skills involved and sorts into the correct lists for further treatment

            String temp = upgradeSkills.get(x);

            if ((x + 2) < upgradeSkills.size() && upgradeSkills.get(x + 1).equals(temp) && upgradeSkills.get(x + 2).equals(temp)) {
                prodigyList.add(temp);
                upgradeSkills.remove(x);
                upgradeSkills.remove(x);
                upgradeSkills.remove(x);
            } else if ((x + 1) < upgradeSkills.size() && upgradeSkills.get(x + 1).equals(temp)) {
                specList.add(temp);
                upgradeSkills.remove(x);
                upgradeSkills.remove(x);
            }

            x++;

        }

        ArrayList<String> tempList_trained = new ArrayList<>();
        ArrayList<String> tempList_specialized = new ArrayList<>();
        ArrayList<String> tempList_prodigy = new ArrayList<>();

        Iterator<String> tempItr = upgradeSkills.iterator();

        while (tempItr.hasNext()) {

            tempList_trained.add(tempItr.next());

        }

        tempItr = prodigyList.iterator();

        while (tempItr.hasNext()) {

            tempList_prodigy.add(tempItr.next());

        }

        tempItr = specList.iterator();

        while (tempItr.hasNext()) {

            tempList_specialized.add(tempItr.next());

        }

        Collections.sort(tempList_specialized);
        Collections.sort(meritSkills);
        Collections.sort(tempList_trained);
        Collections.sort(tempList_prodigy);

        specializedSkillList = tempList_specialized;
        meritSkillList = meritSkills;
        trainedSkillList = tempList_trained;
        prodigySkillList = tempList_prodigy;

    }

    public String showTotalInt() {
        return "Intellect: " + this.intellect;
    }

    public String showTotalMight() {
        return "Might: " + this.might;
    }

    public String showTotalSpeed() {
        return "Speed: " + this.speed;
    }

    public String showTotalArmor() {
        return "Natural Armor: " + this.armor;
    }

    public String showTotalConnections() {
        return parseConnections();
    }

    public String showSkills(String pString) {

        ArrayList<String> tempList = new ArrayList<>();
        String prefix = null;
        String suffix = null;
        String temp = null;

        switch (pString) {
            case "merit":
                tempList = meritSkillList;
                prefix = "Merits: ";
                suffix = "No Merits";
                break;
            case "trained":
                tempList = trainedSkillList;
                prefix = "Trained: ";
                suffix = "No Trained (+1) Skills";
                break;
            case "prodigy":
                tempList = prodigySkillList;
                prefix = "Prodigy: ";
                suffix = "No Prodigy (+3) Skills";
                break;
            case "special":
                tempList = specializedSkillList;
                prefix = "Specialzed: ";
                suffix = "No Specialized (+2) Skills";
                break;
            default:
                break;
        }

        if (tempList.size() > 0) {

            int x = 1;
            for (String s : tempList) {
                if (x == 1) {

                    temp = prefix + "{" + s + "}";
                    x++;
                } else {
                    temp = temp + " {" + s + "}";
                }
            }
        }
        else {
            temp = suffix;

        }
        return temp;
    }

    public ArrayList<Abilities> showTotalAbilities(){
        return this.abilities;
    }

    public int showTotalOddities(){
        return this.oddity;
    }

    public int showTotalCypher(){
        return this.cypher;
    }

    public String showTotalEquipment(){

        return parseEquipment();
    }

    public int showTotalMoney(){

        return this.money;
    }

}




