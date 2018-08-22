package framework;

import addendum.Abilities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attributes {

    protected int intellect;
    protected int might;
    protected int speed;
    protected int armor;
    protected int effort = 1;
    protected int cypherMax;
    protected int archetype = 0; // 1 = Fighter, 2 = Mage, 3 = Rogue

    protected ArrayList<String> edge = new ArrayList<>();
    protected ArrayList<String> skills = new ArrayList<>();
    protected ArrayList<String> meritSkills = new ArrayList<>(); // some skills going into the skill-list aren't described by the key-word "trained". In order to deal with this, i have to handle them in a seperate list to avoid a blanket "trained" classification

    protected ArrayList<String> inabilities = new ArrayList<>();
    protected ArrayList<String> contacts = new ArrayList<>();
    protected ArrayList<Abilities> abilities = new ArrayList<>();
    protected ArrayList<String> equipment = new ArrayList<>();
    protected int money;
    protected int cypher;
    protected int oddity;


    //dummy implementation, showChosen gets overwritten
    protected String showChosen() {
        return null;
    }

    protected int randomNumber(int maxRange, int minRange) {

        int range = (maxRange - minRange) + 1;
        int random = (int) (Math.random() * range) + minRange;
        return random;
    }

    protected String showAttributes(){ return null; }

    protected String showMoney(){return null; }

    protected String showSkills(){String skills = null;

        if(this.skills.size()>0) {
            int x = 1;
            for (String s : this.skills) {

                if (x == 1) {
                    skills = "Trained: " + "{" + s + "} ";
                    x++;
                } else {
                    skills = skills + " " + "{" + s + "} ";

                }
            }
        }
        else{
            skills = "No skills";
        }

        return skills;
    }

    protected ArrayList<Abilities> showAbilities() {return null;}

    protected String showInabilities() {return null;}

    protected String parseEquipment(){
        String equipment = null;

        if(this.equipment.size()>0) {
            int x = 1;
            for (String s : this.equipment) {

                if (x == 1) {

                    equipment = "{" + s + "} ";
                    x++;
                } else {
                    equipment = equipment + "{" + s + "} ";
                }
            }
        }
        else {
            equipment = "No equipment";
        }
        return equipment;
    }

    protected String parseConnections(){
        String contacts = null;

        if(this.contacts.size()>0) {
            int x = 1;
            for (String s : this.contacts) {

                if (x == 1) {

                    contacts = "Contacts: {" + s + "} ";
                    x++;
                } else {
                    contacts = contacts + "{" + s + "} ";
                }
            }
        }
        else{
            contacts = "No contacts";
        }
        return contacts;
    }

    protected String parseOddities(){
        if(this.oddity>0){
        return "Oddity(s): " + this.oddity + " [ TBD by the GM ]";}
        else{return "No Oddities";}
    }

    protected String parseCyphers(){
        if(this.cypher>0){
        return "Cypher: " + this.cypher + " [ TBD by the GM ]";}
        else{return "No Cyphers";}
    }

}
