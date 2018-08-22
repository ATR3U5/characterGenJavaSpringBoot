package addendum;

import framework.Attributes;

import java.util.ArrayList;

public class Abilities extends Attributes {

    private String attributeCost = null;
    private String description;
    private String abilityName;
    private String focusAlteration = null;
    private String alteration;
    private String connection;
    private String classAbbreviation;
    private ArrayList<String> focusSkills = new ArrayList<>();


    public Abilities(String chosenModule, String skillOrigin) {

        if(skillOrigin.equals("Focus")) {
            switch (chosenModule) {
                case "Bears a Halo of Fire":
                    useFire();
                    connection = "One other Player Character is immune to your fire.";
                    break;
                case "Carries a Quiver":
                    useQuiver();
                    connection = "Another player is a true friend and gave you an excellent bow to use. SECRET: Pick another player: Whenever you accidentally miss and hit another target, hit the chosen player.";
                    break;
                case "Commands Mental Powers":
                    usesMentalPowers();
                    connection = "You have a telepathic connection to one other character while in short range. The picked character is unharmed by your psychic bursts.";
                    break;
                case "Crafts Illusions":
                    usesIllusions();
                    connection = "Another player is unaffected by your illusions and trickery. You may or may not know about this fact.";
                    break;
                case "Explores Dark Places":
                    usesDarkness();
                    connection = "Another player is your Partner on adventures. You both gain +1 on any rolls involving tasks you both do together.";
                    break;
                case "Fuses Flesh and Steel":
                    usesFleshAndSteel();
                    connection = "Another player knows a safe-word which, when spoken, will shut you down for 10 minutes.";
                    break;
                case "Masters Weaponry":
                    usesWeaponry();
                    connection = "Another player shows promise in the ways of your weapon. You might want to train her or him.";
                    break;
                case "Rides the Lightning":
                    usesLightning();
                    connection = "One player is a friend of yours who can be taken with you when using your lightning abilities to move around.";
                    break;
                case "Talks to Machines":
                    usesMachines();
                    connection = "Another player seems to have a terrible relationship with machines. If that player is close to a machine you're communicating with, the machines level is reduced by one for all purposes.";
                    break;
                case "Wears a Sheen of Ice":
                    usesIce();
                    connection = "One other player is also affected by your ice armor when she stands next to you while you use the ability";
                    break;
                case "Wields Two Weapons at Once":
                    usesTwoWeapons();
                    connection = "One other player is your partner in training. When you fight back to back with each other, you both gain +1 to Speed Defense tasks.";
                    break;
                case "Works Miracles":
                    usesMiracles();
                    connection = "Another player suspects you are a messiah or supernatural being. You may or may not be aware of this suspicion.";
                    break;
                default:
                    System.out.println("Error in Focus Part of Ability Switch");

            }

        }

        else if (skillOrigin.equals("Descriptor")){

            switch (chosenModule){
                case "Mechamystical":
                    usesMechamystical();
                    break;
                case "Tough":
                    usesTough();
                    break;
                default:
                    System.out.println("Error in Descriptor Part of Ability Switch");

            }
        }

        else if (skillOrigin.equals("TT") || skillOrigin.equals("PM") || skillOrigin.equals("EO") || skillOrigin.equals("CM") ||skillOrigin.equals("SC")){

            this.classAbbreviation = skillOrigin;

            switch(chosenModule){

                case "Bash":
                    usesBash();
                    break;
                case "Battle Numenera":
                    useBattleNumenera();
                    break;
                case "Coax":
                    usesCoax();
                    break;
                case "Connection":
                    usesConnection();
                    break;
                case "Danger Sense":
                    useDangerSense();
                    break;
                case "Decipher":
                    useDecipher();
                    break;
                case "Encouragement":
                    usesEncouragement();
                    break;
                case "Fast Talk":
                    usesFastTalk();
                    break;
                case "Friendship":
                    usesFriendship();
                    break;
                case "Flex Skill":
                    usesFlexSkill();
                    break;
                case "Hedge Magic":
                    usesHedgeMagic();
                    break;
                case "Influence":
                    usesInfluence();
                    break;
                case "Knowledge":
                    usesKnowledge();
                    break;
                case "Muscles":
                    usesMuscles();
                    break;
                case "NoArmor":
                    usesNoArmor();
                    break;
                case "NoWeapons":
                    usesNoWeapons();
                    break;
                case "Onslaught":
                    usesOnslaught();
                    break;
                case "Pierce":
                    usesPierce();
                    break;
                case "Push":
                    usesPush();
                    break;
                case "Scan":
                    usesScan();
                    break;
                case "Thrust":
                    usesThrust();
                    break;
                default:
                    System.out.println("Not yet implemented");
            }

        }
    }



    private void useFire(){

        abilityName = "Shroud of Flame";
        attributeCost = "1 Intellect point";
        description = "At your command, your entire body becomes shrouded in flames that last up to ten minutes. The fire doesn't burn you, but it automatically inflicts 2 points of damage to anyone who tires to touch you or strike you with a melee attack. Flames from another source can still hurt you. While the shroud is active, you gain +2 points of Armor that protect only against damage from fire from another source. Enabler.";

        focusAlteration = "Fire Esoteries";
        alteration = "If you perform esoteries, those that would normally use force or other energy instead use fire. For example, force blasts from Onslaught are blasts of flame. These alterations change nothing except the type of damage and the fact that it might start fires. E.g. Barrier produces a wall of flames. The alteration changes the barrier so that it is not solid but instead inflicts 1 point of damage to anything that touches it and 4 points of damage to anyone who passes through.";

        this.equipment.add("An artifact which sprays inanimate objects to make them fire-resistant. All your starting gear has already been treated unless you don't want it to be.");

    }

    private void useQuiver(){

        abilityName = "Archer";
        description = "Your aim with a bow is exceptional. You can spend points from either your Speed or your Intellect Pool to apply levels of Effort to increase your bow damage. Each level of Effort adds 3 points of damage to a successful attack. Enabler.";
        this.focusSkills.add("Making Arrows");

        this.equipment.add("A well-made bow + 24 arrows");

    }

    private void usesMentalPowers(){

        focusAlteration = "Mental Esoteries";
        alteration = "If you have the \"Mind Control\" esotery or the \"Mind Reading\" Esotery, you're automatically trained in it. If you have both esoteries, you are trained in both.";

        abilityName ="Telepathic";
        attributeCost = "1+ Intellect points";
        description = "You can speak telepathically with others in short range. Communication is two-way, but the other party must be willing and able to communicate. You don't have to see the target, but you must know that it is within range. You can have more than one contact at once, but each contact must be established individually. Each contact lasts up to 10 minutes. If you apply a level of Effort to increase the duration rather than affect the difficulty, the contact lasts for 28 hours. Action to establish contact.";

        this.equipment.add("A crystal or jewel that, when worn against your forehead or temple, adds 1 point to your Intellect pool. If you're ever without the artifact, subtract 5 points from your Intellect pool. The points are restored if you regain the item.");
    }

    private void usesIllusions(){

        focusAlteration = "Psychedelic Esoteries";
        alteration = "If you perform esoteries, they take on flamboyant visual and auditory qualities of your choosing. This alteration changes nothing other than the appearance of the effects. For example, your Stasis esotery might look like a tentacled beast that holds a victim in place or your Teleportation esotery might seem like a hole in space opens up and swallows you.";

        abilityName = "Minor Illusion";
        attributeCost = "1 Intellect point";
        description = "You create a single image of a creature or object within immediate range. The image must fit within a 3-meter cube. The image can move, but it can't leave the area defined by the cube. The illusion includes sound but not smell. It lasts for 10 minutes, but if you want to change the original illusion significantly - such as making a creature appear to be wounded - you must concentrate on it again (but it doesn't cost additional points). If you move beyond immediate range of the cube, the illusion vanishes. Action to create, action to modify.";

        this.equipment.add("An oddity which appears to be a piece of clear glass in a synth frame. You can make random moving images appear on the glass by manipulating a hidden switch on the frame. The images are usually strange and sometimes incomprehensible.");
    }

    private void usesDarkness(){

        abilityName = "Dark Esoteries";
        description = "If you perform esoteries, they make almost no sound, and whatever visual displays they produce are dark and shadowy. These alterations change nothing other than the appearance of the effects. A flash esotery is a silent burst of shadows, a Barrier is a mass of shadowy wisps, and so on.";

        this.focusSkills.add("Searching");
        this.focusSkills.add("Climbing");
        this.focusSkills.add("Balancing");
        this.focusSkills.add("Jumping");

        this.equipment.add("Explorer's pack");

    }

    private void usesFleshAndSteel(){

        this.armor = this.armor + 1;
        this.might = this.might + 3;
        this.speed = this.speed + 3;

        abilityName = "Special Healing";
        description = "Traditional healing skills, medicines and techniques work only half as well for you. Each time you start at full health, the first 5 points of damage you take can never be healed in these ways or recovered normally. Instead, you must use repairing skills and abilities to restore those points. E.g. if you start with a Might Pool of 10 and take 8 points damage, you can use recovery rolls to restore 3 points, but the remaining 5 points must be restored using repairs.";

        this.equipment.add("A bag of equipment, tools and parts to repair yourself with.");
    }

    private void usesWeaponry(){

        focusAlteration = "Weapon Esoteries";
        alteration = "If you perform esoteries, your attacks always look like your chosen weapon. E.g. a force blast appears to be a large weapon made of force. These alterations change nothing other than the appearance of the effects. As another example, a Barrier becomes a wall of swirling blades of energy. This alteration changes the esotery such that it is not a solid barrier but rather inflicts 1 point of damage to anyone who touches it and 4 points of damage to anyone who passes through it.";

        abilityName = "Weapon Master";
        description = "You gain a +1 bonus to damage with your chosen weapon. Enabler.";

        this.equipment.add("A high-quality weapon of your choosing.");

    }

    private void usesLightning(){

        focusAlteration = "Electrical Esoteries";
        alteration = "If you perform esotieres, those that would normally use a force or other energy instead use electricity. For example, a force blast is a blast of lighting. This alteration changes nothing other than the type of damage and the fact that it might start fires.";

        abilityName = "Shock";
        attributeCost = "1 Intellect point";
        description = "Your hands crackle with electricity. The next time you touch a creature, you inflict 3 points of damage. Alternatively, if you wield a weapon, for ten minutes it crackles with electricity and inflicts 1 additional point of damage per attack. Action for touch, enabler for weapon.";

        this.equipment.add("A bag of miscellaneous batteries and power cells. Whenever you find a new devices that operates on batteries or cells (GM discretion), there is a 75% chance that the bag contains one that will power it if it depletes.");

    }

    private void usesMachines(){

        abilityName = "Distant Activation";
        attributeCost = "1 Intellect point";
        description = "You can activate or deactivate any machine you can see within short range, even if normally you would have to touch or manually operate the device. To use this ability, you must understand the function of the machine, it must be your size or smaller, and it can't be connected to another intelligence (or be intelligent itself). Action.";

        this.focusSkills.add("All Tasks involving electrical machines");

        this.equipment.add("A bag of small tools, specialized for repairing automatons.");

    }

    private void usesIce(){

        focusAlteration = "Ice Esoteries";
        alteration = "If you perform esoteries, those that would normally use force or other energy instead use cold and ice. For example, a force blast is a ray of frost. This alteration changes nothing other than the type of damage. As another example, a Barrier is a wall of ice. This alteration changes nothing except the wall's appearance and the fact that it takes 2 additional points of damage from fire";

        abilityName = "Ice Armor";
        attributeCost = "1 Intellect point";
        description = "When you wish it, your body is covered in a sheen of ice for then minutes that gives you +1 to Armor. While the sheen is active, you feel no discomfort from normal cold temperatures and have an additional +2 to Armor versus cold damage specifically. Enabler.";

        this.equipment.add("A bladed weapon made of stronglass that looks like ice.");
    }

    private void usesTwoWeapons(){

        abilityName = "Dual Light Wield";
        description = "You can use two light weapons at the same time, making two separate attacks on your turn as a single action. You remain limited by the amount of Effort you can apply on one action, but because you make separate attacks, your opponent's armor applies to both. Anything that modifies your attack or damage applies to both attacks, unless it's specifically tied to one of the weapons. Enabler.";

        this.equipment.add("One light melee weapon");
    }

    private void usesMiracles(){

        abilityName = "Healing Touch";
        attributeCost = "1 Intellect point";
        description = "With a touch, you restore 1d6 points to one stat Pool of any creature. This ability is a difficulty 2 Intellect task. Each time you attempt to heal the same creature, the ask difficulty increases by one step. The difficulty returns to 2 after that creature rests for 10 hours. Action.";

    }

    private void usesMechamystical(){

        focusAlteration = "Sense Supernatural";
        alteration = "You can sense wether the numenera is active in situations where its presence is not obvious. You must study an object or location closely for a minute to get a feel for wether the touch of the ancients is at work.";

        abilityName = "[EO] Hedge Magic";
        attributeCost = "1 Intellect point";
        description = "Using a free hand, you can perform small tricks: Temporarily change the color or basic appearance of small objects, cause small objects to float through the air, clean a small area, mend a broken object, prepare (not create) food, and so on. You can't use hedge magic to harm another creature or object. Counts as an esotery. Action.";
        this.oddity = this.oddity + 1;
    }

    private void usesTough(){

       abilityName = "Healthy";
       description = "Add 1 to the points you regain when you make a recovery roll.";

    }

    private void usesFlexSkill(){

        abilityName = "Flex Skill";
        description = "At the beginning of each day, choose one task (other than attacks or defense) on which you will concentrate. For the rest of the day, you're trained in that tak. You can't use this ability with a skill you're already trained in to become specialized.";
    }


    private void usesBash(){

        abilityName = "["+classAbbreviation+"]" + " Bash";
        attributeCost = "1 Might point";
        description = "A pummeling melee attack. You make an attack and inflict 1 additional point of damage using almost any weapon except the lightest (such as a whip or a small knife). Action.";

    }

    private void usesPierce(){

        abilityName = "["+classAbbreviation+"]" + " Pierce";
        attributeCost = "1 Speed point";
        description = "A well-aimed, penetrating ranged attack. You make an attack and inflict 1 additional point of damage if your weapon has a sharp point. Action.";

    }

    private void usesThrust(){

        abilityName = "["+classAbbreviation+"]" + " Thrust";
        attributeCost = "1 Might point";
        description = "A powerful melee stab. You make an attack and inflict 1 additional point of damage if your weapon has a sharp edge or point. Action.";


    }

    private void usesNoArmor(){

        abilityName = "["+classAbbreviation+"]" + " Trained without Armor";
        description = "You are trained in Speed Defense actions when not wearing armor. Enabler.";

    }

    private void usesHedgeMagic(){

        abilityName = "["+classAbbreviation+"]" + " Hedge Magic";
        attributeCost = "1 Intellect point";
        description = "Using a free hand, you can perform small tricks: Temporarily change the color or basic appearance of small objects, cause small objects to float through the air, clean a small area, mend a broken object, prepare (not create) food, and so on. You can't use hedge magic to harm another creature or object. Counts as an esotery. Action.";

    }

    private void usesNoWeapons(){

        abilityName = "["+classAbbreviation+"]" + " No Need for Weapons";
        description = "When you make an unarmed attack (such as a punch or kick), it counts as a medium weapon instead of a light weapon. Enabler.";
    }

    private void usesPush(){

        abilityName = "["+classAbbreviation+"]" + " Push";
        attributeCost = "2 Intellect points";
        description = "You push a creature or object an immediate distance in any direction you wish. You must be able to see the target, which must be your size or smaller, must not be affixed to anything, and must be within short range. To push is quick, and the force is too crude to be manipulated. For example, you can't use this esotery to pull a lever or even close a door. Action.";
    }

    private void usesOnslaught(){

        abilityName = "["+classAbbreviation+"]" + " Onslaught";
        attributeCost = "1 Intellect point";
        description = "You attack a foe using energies that assail either his physical form or his mind. In either case, you must be able to see your target. If the attack is physical, you emit a short-range ray of force that inflicts 4 points of damage. If the attack is mental, you focus your mental energy to blast the thought processes of another creature within short range. This mindslice inflicts 2 points of Intellect damage (and ignores armor). Some creatures without minds (such as robots) might be immune to mindslice. Action.";
    }

    private void usesScan(){

        abilityName = "["+classAbbreviation+"]" + " Scan";
        attributeCost = "2 Intellect points";
        description = "You scan an area equal in size to a 3-meter cube, including all objects within that area. The area must be within short range. Scanning an object reveals its level. You also learn whatever facts the GM feels are pertinent about the area. For example, you might learn that the wooden box contains a device of metal and synth, or that a glass cylinder is full of poisonous gas. You might also learn that a creature is a mammal with a small brain. The esotery does NOT tell you what the information means (as in, it won't tell you what a device does, but you might be able to detuct this from your surroundings. It also won't tell you that a mammal with a small brain is more prone to fall for tricks and illusions. Action.";
    }

    private void usesCoax(){

        abilityName = "["+classAbbreviation+"]" + " Coax Information";
        attributeCost = "1 Intellect point";
        description = "If you have a conversation with someone (lasting at least a minute), you can get that person to give you some information you desire during the course of the conversation. If this information is extremely secret or vital, the difficulty may be higher than simply their level. Likewise, for non-vital information the difficulty might be lower. Best of all, if you are successful, the person either doesn't realize the information slipped out, or they are not alarmed that they gave it to you. Enabler.";
    }

    private void usesConnection(){

        abilityName = "["+classAbbreviation+"]" + " Connection with an Organization";
        description = "You have a general connection with an important organization, such as the Order of Truth, the Angulan Knights, the aristocracy of the region, a merchant guild, etc. The difficulty of all tasks related to interacting with members of that group is decreased by one step. Further, you can use this connection to get help, lower prices, or whatever is appropriate. Work out the details with your GM. Enabler.";
    }


    private void usesInfluence(){
        abilityName = "["+classAbbreviation+"]" + " Influence";
        description = "You can, at a later date (in the course of play), leverage influence over an individual or even a group. Using this influence, the difficulty of tasks related to interacting with this individual or group is decreased by three steps. However, once you declare whom you have influence with, you cannot change it unless you select this ability again. Further, depending on the circumstances that you and the GM work out, the influence may be temporary. For example, you might have incriminating evidence over the mayor of a city. If that evidence disappears, so does your influence. Enabler.";


    }

    private void usesFriendship(){

        abilityName = "["+classAbbreviation+"]" + " Friendship";
        attributeCost = "1 Intellect point";
        description = "You convince a sentient creature to regard you positively, as they would a potential friend. You gain an asset in all future interactions with the creature until you give them a reason to no longer regard you well, at which point the effect ends (and may result in more difficulty for future interactions). The affected creature are not compelled or controlled in any way. A target affected by this is simply more likely to perceive you as a friend if you give them a reason to believe this to be so. This isn't enough to keep a hostile foe from attacking, but it can help in a subsequent interaction task to do that.";

    }

    private void usesEncouragement(){

        abilityName = "["+classAbbreviation+"]" + " Encouragement";
        attributeCost = "1 Intellect point";
        description = "While you maintain this ability through ongoing inspiring oration, your allies within short range modify the difficulty of one of the following task types of your choice by one step +1: Defense Tasks, Attack Tasks, or tasks related to any skill you are trained or specialized in. Action.";
    }

    private void usesFastTalk(){

        abilityName = "["+classAbbreviation+"]" + " Fast Talk";
        attributeCost = "1 Intellect point";
        description = "When speaking with an intelligent creature who can understand you and isn't hostile, you convince that creature to take one reasonable action in the next round. A reasonable action should not put the creature or its allies in obvious danger or be wildly out of character, but it might be more than could be accomplished with a simple persuasion task. Action.";

    }

    private void useBattleNumenera(){

        abilityName = "["+classAbbreviation+"]" + " Battle Numenera";
        description = "When battling an automaton or any other sort of entirely mechanical foe, the difficulty of all Speed defense rolls and attack rolls is decreased by one step. Enabler.";

    }

    private void useDangerSense(){

        abilityName = "["+classAbbreviation+"]" + " Danger Sense";
        attributeCost = "1 Speed point";
        description = "The difficulty of your initiative roll is reduced by one step. Enabler.";

    }

    private void useDecipher() {

        abilityName = "["+classAbbreviation+"]" + " Decipher";
        attributeCost = "1 Intellect point";
        description = "If you spend one minute examining a piece of writing or code in a language you do not understand, you can make an Intellect roll of difficulty 3 (or higher, based on the complecity of the language or code). On a success, you get the gist of what the writing says. Action to initiate.";
    }

    private void usesKnowledge(){

        abilityName = "["+classAbbreviation+"]" + " User of Knowledge";
        description = "You are trained in two knowledge-skills in which you are not already trained. Choose two areas such as history, geography, paleontology, archaeology, etc. Enabler.";

    }

    private void usesMuscles(){

        abilityName = "["+classAbbreviation+"]" + " Muscles of Iron";
        attributeCost = "2 Might points";
        description = "For the next ten minutes, all Might-based actions other than attack rolls that you attempt have their difficulty reduced by one step. Enabler.";

    }


    public void showAbility(){


        if(focusAlteration != null) {
            System.out.println();
            System.out.println(focusAlteration);
            System.out.println(alteration);
        }


        System.out.println();
        System.out.print(abilityName);
        if(attributeCost != null)
            {System.out.println(" ( " + attributeCost + " ) ");}
        else{
            System.out.println();
        }

        System.out.println(description);
    }

    public String connectingCharacters(){

        return connection;

    }

    public ArrayList<String> addFocusSkills(){

        return focusSkills;
    }

    public String parseAbility(){

        String temp;

        if(focusAlteration != null) {

            temp = focusAlteration + ": " + "{" + alteration + "}" + "\n \n" + abilityName;
        }
        else{
            temp = abilityName;
        }

        if(attributeCost != null)
        {
            temp = temp + " (" + attributeCost + ") ";
        }

        temp = temp + ": {" + description + "}";


        return temp;
    }


}
