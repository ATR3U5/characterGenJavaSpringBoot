package WebController;


import addendum.Abilities;
import framework.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class CharGenController extends Attributes{

    private boolean descriptorLock = false;
    private boolean classLock = false;
    private boolean focusLock = false;

    private boolean descCollapse = false;
    private boolean classCollapse = false;
    private boolean focusCollapse = false;


    @RequestMapping("/descTab")
    public void assignDescCollapse(@RequestParam ("tab") Boolean descTab){
        if(descTab){
            descCollapse = true;
        }
        else{
            descCollapse = false;
        }
    }

    @RequestMapping("/classTab")
    public void assignClassCollapse(@RequestParam ("tab") Boolean classTab){
        if(classTab){
            classCollapse = true;
        }
        else{
            classCollapse = false;
        }
    }

    @RequestMapping("/focusTab")
    public void assignFocusCollapse(@RequestParam ("tab") Boolean focusTab){
        if(focusTab){
            focusCollapse = true;
        }
        else{
            focusCollapse = false;
        }
    }

    @RequestMapping("/classCollapse")
    public Boolean assignStartClassCollapse() {
        return this.classCollapse;
    }

    @RequestMapping("/focusCollapse")
    public Boolean assignStartFocusCollapse() {
        return this.focusCollapse;
    }

    @RequestMapping("/descCollapse")
    public Boolean assignStartDescCollapse() {
        return this.descCollapse;
    }


    @RequestMapping("/focusSetStart")
    public Boolean assignStartFocus() {
        return this.focusLock;
    }

    @RequestMapping("/classSetStart")
    public Boolean assignStartClass() {
        return this.classLock;
    }

    @RequestMapping("/descSetStart")
    public Boolean assignStartDescriptor() {
        return this.descriptorLock;
    }

    @RequestMapping("/focusButton")
    public void assignFocusLock(@RequestParam ("focus") Boolean focusButton){
        this.focusLock = focusButton;
    }

    @RequestMapping("/descButton")
    public void assignDescriptorLock(@RequestParam ("descriptor") Boolean descButton){
        this.descriptorLock = descButton;
    }

    @RequestMapping("/classButton")
    public void assignClassLock(@RequestParam ("character") Boolean classButton){
        this.classLock = classButton;
    }

    @Controller
    private class innerController {

        @GetMapping("/random")
        public String SecondRandom(Model model) {

            if (!descriptorLock) {
                Application.newDescriptor = new Descriptor();
            }

            if (!classLock) {
                Application.newClass = new CharacterClass();
            }

            if (!focusLock) {
                Application.newFocus = new Focus();
            }

            Application.newSheet = new CharacterSheet(Application.newClass, Application.newDescriptor, Application.newFocus);

            assignAttributes(model);

            return "characterPage";
        }
    }


    private void assignAttributes(Model pModel){


        pModel.addAttribute("characterClass", Application.newClass.showChosen());
        pModel.addAttribute("descriptor", Application.newDescriptor.showChosen());
        pModel.addAttribute("focus", Application.newFocus.showChosen());

        parseFocus(pModel);
        parseDescriptor(pModel);
        parseClass(pModel);
        parseTotalSheet(pModel);

    }

    private void parseClass(Model model){

        CharacterClass temp = Application.newClass;
        String classAbilities = null;

        model.addAttribute("classIntellect", temp.showclassIntellect());
        model.addAttribute("classMight", temp.showclassMight());
        model.addAttribute("classSpeed", temp.showclassSpeed());
        model.addAttribute("classArmor", temp.showclassArmor());

        model.addAttribute("classEdge", temp.showclassEdge());
        model.addAttribute("classEffort", temp.showclassEffort());
        model.addAttribute("classCypher", temp.showclassCypherMax());
        model.addAttribute("classMoney", temp.showclassMoney());

        model.addAttribute("classMerit", temp.showclassMeritSkills());
        model.addAttribute("classSkills", temp.showClassSkills());

        model.addAttribute("classAbilityType", temp.showAbilityType());
        model.addAttribute("classAbilityDesc", temp.showAbilityTypeDesc());

        model.addAttribute("classConnections", temp.showClassConnections());

        ArrayList<Abilities> classAbilityList = temp.showClassAbilities();

       if (classAbilityList.size()>0){
           int x = 1;
           for(Abilities a: classAbilityList){
               if (x==1){
                   classAbilities = a.parseAbility() + "\n";
                   x++;
               }
               else{

                   classAbilities = classAbilities + "\n" + a.parseAbility();
               }
           }
       }
       else{
           classAbilities = "No abilities";
       }

        model.addAttribute("classAbilities", classAbilities);
        model.addAttribute("classEquipment", temp.showClassEquipment());

        model.addAttribute("classOdd", temp.showClassOddities());
        model.addAttribute("classCyphers", temp.showClassCyphers());

    }

    private void parseFocus(Model model){
        Focus temp = Application.newFocus;
        String focusAbilities = null;

        model.addAttribute("focusIntellect", temp.showFocusIntellect());
        model.addAttribute("focusMight", temp.showFocusMight());
        model.addAttribute("focusSpeed", temp.showFocusSpeed());
        model.addAttribute("focusArmor", temp.showFocusArmor());

        model.addAttribute("focusSkills", temp.showFocusSkills());
        model.addAttribute("focusEquipment", temp.showFocusEquipment());

        model.addAttribute("focusOdd", temp.showFocusOddities());
        model.addAttribute("focusCyphers", temp.showFocusCyphers());

        model.addAttribute("focusCause", temp.causeOfFocus());
        model.addAttribute("focusInfo", temp.showConnection());


        ArrayList<Abilities> focusAbilitiyList = temp.showFocusAbilities();

        if(focusAbilitiyList.size()>0){
            int x = 1;
            for (Abilities a : focusAbilitiyList){
                if (x==1){
                    focusAbilities = a.parseAbility()+ "\n";;
                    x++;
                }
                else{
                    focusAbilities = focusAbilities +  "\n" + a.parseAbility();
                }
            }
        }
        else{
            focusAbilities = "No abilities";
        }
        model.addAttribute("focusAbilities", focusAbilities);


    }

    private void parseDescriptor(Model model){

        Descriptor temp = Application.newDescriptor;
        String abilities = null;

        model.addAttribute("descAttribute", temp.showAttributes());
        model.addAttribute("descMoney", temp.showMoney());
        model.addAttribute("descSkills", temp.showDescSkills());
        model.addAttribute("descInabilities", temp.showInabilities());
        model.addAttribute("descConnections", temp.showDescConnections());

        model.addAttribute("descOdd", temp.showDescOddities());
        model.addAttribute("descCyphers", temp.showDescCyphers());

        ArrayList<Abilities> abilityList = temp.showDescAbilities();

        if(abilityList.size()>0){
            int x = 1;
            for (Abilities a : abilityList){
                if (x==1){
                    abilities = a.parseAbility();
                    x++;
                }
                else{
                    abilities = abilities + a.parseAbility();;
                }

            }

        }
        else{

            abilities = "No abilities";
        }

        model.addAttribute("descAbilities", abilities);
        model.addAttribute("descEquipment", temp.showEquipment());
    }

    private void parseTotalSheet(Model model){

        CharacterSheet completeSheet = Application.newSheet;
        String totalAbilities = null;

        model.addAttribute("totalIntellect", completeSheet.showTotalInt());
        model.addAttribute("totalMight", completeSheet.showTotalMight());
        model.addAttribute("totalSpeed", completeSheet.showTotalSpeed());
        model.addAttribute("totalArmor", completeSheet.showTotalArmor());

        model.addAttribute("totalContacts", completeSheet.showTotalConnections());

        model.addAttribute("totalMeritSkills", completeSheet.showSkills("merit"));
        model.addAttribute("totalProdigySkills", completeSheet.showSkills("prodigy"));
        model.addAttribute("totalSpecialSkills", completeSheet.showSkills("special"));
        model.addAttribute("totalTrainedSkills", completeSheet.showSkills("trained"));

        ArrayList<Abilities> abilityList = completeSheet.showTotalAbilities();

        if(abilityList.size()>0){
            int x = 1;
            for (Abilities a : abilityList){
                if (x==1){
                    totalAbilities = a.parseAbility() + "\n";;
                    x++;
                }
                else{
                    totalAbilities = totalAbilities + "\n" + a.parseAbility();;
                }

            }

        }
        else{

            totalAbilities = "No abilities";
        }

        model.addAttribute("totalAbilities", totalAbilities);

        model.addAttribute("totalEquipment", completeSheet.showTotalEquipment());
        model.addAttribute("totalOddity", "Number of Oddities: " + completeSheet.showTotalOddities());
        model.addAttribute("totalCypher", "Number of current Cypher: " + completeSheet.showTotalCypher());
        model.addAttribute("totalMoney", "Money: " + completeSheet.showTotalMoney() + " Shins");


    }

}