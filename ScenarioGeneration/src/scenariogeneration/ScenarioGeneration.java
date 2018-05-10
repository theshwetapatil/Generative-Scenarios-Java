// ScnearioGeneration.java : Defines the entry point for the java application.
// Generative System: Scenario Generation
// Used in Games: Interactive Narrative
// Author: Shweta Patil
// Copyright: Shweta Patil © 2018

package scenariogeneration;
import java.util.Random;

/**
 *
 * @author Shweta
 */
public class ScenarioGeneration {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
       String places[] = {"classroom", "coridore", "staff room", "campus ground", 
       "parking lot", "library", "lab", "gate", "front desk", "canteen"};
       String activities[] = {"exam", "lecture", "practical", "presentation", 
       "lunch break", "study session"};
       String characters[] = {"you", "classmate", "friend", "teacher"," principal", 
       "department head", "non-teaching staff", "receptionist", "gatekeeper", 
       "canteen staff", "librarian", "lab assistant", "teaching assistant", "ousider"};
       String adjectives[] = {"strict", "caring", "rude", "short-tempered", "calm", 
       "well desciplined", "experienced", "genuine", "honest", "idealistic", "helpful", 
       "insightful", "intellectual", "well orgranised", "observant", "open-minded", 
       "practical", "rational", "logical", "resilient", "reliable", "receptive", 
       "approachable", "responsible", "sincere", "sensitive", "strong", "understanding"};
       String tasks[] = {"pass the exam", "complete the assignment", "buy food", 
       "take exam", "give presentation", "get book", "pass", "get full score", 
       "get passing score", "finish it", "get away with it"};
       String conditions[] = {"by cheating", "by not showing up", "by stealing"};
       String choices[] = {"face the situation", "run away from the situation",
       "cheat", "don't cheat", "steal", "don't steal", "attend class", "bunk class"};
       
       String madlibs[] = new String[10];
       
       //Initialize databases
       String place = "[place]";
       String activity = "[activity]";
       String character = "[character]";
       String adjective = "[adjective]";
       String task = "[task]";
       String condition = "[condition]";
       String choice1 = "[choice1]";
       String choice2 = "[choice2]";
       
       //Initialize madlibs
       madlibs[0] = "You are in " + place + ". There is "+activity + " going on.\nYour "
       +character + " is "+adjective + ".\nThe only way you can " + task + " is "
       +condition + "\nWhat will you do?\n1." + choice1+"\n2." + choice2;
       
       //Generate random databases
        Random rand = new Random();  
        int i = rand.nextInt(madlibs.length-1);

        System.out.println("Scenario "+i);
        System.out.println(madlibs[i]);
        
        //Generate random numbers for entities
        String entity1;
        String entity2;
                
        int placenumber;
        int activitynumber;
        int characternumber;
        int adjectivenumber;
        int tasknumber;
        int conditionnumber;
        int choice1number;
        
        //Check whether the entities are related 
        boolean isRelated = false;
        //Check relation between places and activities
        do
        {
            placenumber = rand.nextInt(places.length-1);
            activitynumber = rand.nextInt(activities.length-1);
            entity1 = places[placenumber];
            entity2 = activities[activitynumber];
            place = entity1;
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                activity = entity2;
            }
        }
        while(isRelated == false);
        
        isRelated = false;
        
        //Check relation between places and characters
        do
        {
            characternumber = rand.nextInt(characters.length-1);
            entity2 = characters[characternumber];
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                character = entity2;
            }
        }
        while(isRelated == false);
        
        isRelated = false;
        
        //Check relation between characters and adjectives
        do
        {
            adjectivenumber = rand.nextInt(adjectives.length-1);
            entity1 = characters[characternumber];
            entity2 = adjectives[adjectivenumber];
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                adjective = entity2;
            }
        }
        while(isRelated == false);
        
        isRelated = false;
        
        //Check relation between activities and tasks
        do
        {
            tasknumber = rand.nextInt(tasks.length-1);
            entity1 = activities[activitynumber];
            entity2 = tasks[tasknumber];
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                task = entity2;
            }

        }
        while(isRelated == false);
         
        isRelated = false;
        //Check relation between activities and conditions
        do
        {
            conditionnumber = rand.nextInt(conditions.length-1);
            entity1 = activities[activitynumber];
            entity2 = conditions[conditionnumber];
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                condition = entity2;
            }

        }
        while(isRelated == false);
        
        isRelated = false;
        
        //Check relation between activities and choices
        do
        {
            choice1number = rand.nextInt(choices.length-1);
            entity1 = activities[activitynumber];
            entity2 = choices[choice1number];
            isRelated = checkRelation(entity1,entity2);
            
            if(isRelated)
            {
                choice1 = entity2;
            }
        }
        while(isRelated == false);
        
        //Assign choices 
        choice2 = getChoice(choice1);
        //Evaluate madlibs
        madlibs[0] = "You are in " + place + ". There is " + activity + " going on.\nYour "
        + character + " is " + adjective + ".\nThe only way you can " + task + " is "
        + condition + "\nWhat will you do?\n1." + choice1 + "\n2." + choice2;
        
        System.out.println("Scenario " + i);
        System.out.println(madlibs[i]);
    }
    
    static boolean checkRelation(String entity1, String entity2)
    {
        //Check relation between places and activities
        if(entity1 == "classroom" || entity1 == "lab" || entity1 == "coridore")
            if(entity2 == "exam" || entity2 == "lecture" || entity2 == "practicle" ||
            entity2 == "presentation")
                return true;
        
        //Check relation between places and characters
        if(entity1 == "classroom" || entity1 == "lab" || entity1 == "coridore")
            if(entity2 == "classmate" || entity2 == "teacher" || entity2 == "friend" ||
            entity2 == "teaching assistant")
                return true;
        //Check relation between characters and adjectives
        if(entity1 == "classmate" || entity1 == "teacher" || entity1 == "friend" ||
           entity1 == "teaching assistant")
            if(entity2 == "strict" || entity2 == "caring" || entity2 == "rude"
            || entity2 == "short-tempered" || entity2 == "well desciplined"
            || entity2 == "experienced" || entity2 == "idealistic"
            || entity2 == "helpful" || entity2 == "well orgranised"
            || entity2 == "observant" || entity2 == "open-minded"
            || entity2 == "receptive" || entity2 == "approachable"
            || entity2 == "responsible" || entity2 == "sincere"
            || entity2 == "understanding")
                return true;
        //Check relation between activities and tasks
         if(entity1 == "exam" || entity1 == "lecture" || entity1 == "practicle" ||
            entity1 == "presentation")
             if(entity2 == "pass the exam" || entity2 == "complete the assignment" 
                || entity2 == "take exam" || entity2 == "give presentation" 
                || entity2 == "pass" || entity2 == "get full score" 
                || entity2 == "get passing score" || entity2 == "finish it"
                || entity2 == "get away with it")
                return true;
        //Check relation between activities and condtions
         if(entity1 == "exam" || entity1 == "lecture" || entity1 == "practicle" || 
            entity1 == "presentation")
             if(entity2 == "by cheating" || entity2 == "by not showing up"
                || entity2 == "by stealing")
                return true;
        //Check relation between activities and choices
        if(entity1 == "exam" || entity1 == "lecture" || entity1 == "practicle" ||
           entity1 == "presentation")
            if(entity2 == "face the situation" || entity2 == "run away from the situation"
               || entity2 == "cheat" || entity2 == "don't cheat" || entity2 == "steal"
               || entity2 == "don't steal" || entity2 == "attend class" || entity2 == "bunk class")
                return true;
        return false;
    }
    
    static String getChoice(String choice)
    {
        if(choice == "face the situation")
            return "run away from the situation";
        if(choice == "run away from the situation")
            return "face the situation";
        if(choice == "cheat")
            return "don't cheat";
        if(choice == "don't cheat")
            return "cheat";
        if(choice == "steal")
            return "don't steal";
        if(choice == "don't steal")
            return "steal";
        if(choice == "attend class")
            return "bunk class";
        if(choice == "bunk class")
            return "attend class";
        
        return "";
    }
}
