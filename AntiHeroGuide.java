import java.util.Scanner;

public class AntiHeroGuide 
{
    public static void main(String[] args) 
    {
        // Creation of all heroes:
        Hero[] heroes = HeroDatabase.createAllHeroes();
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO DOTA 2 ANTI HEROES GUIDE");
        System.out.println("How to use: Just follow the instructions in user inputs.\n");
        System.out.println("This will ask you for a hero that you want to counter with another possible hero given its role and main attribute.\n");
        System.out.print("List of Heroes: ");
        for(Hero heroNamess : heroes)
        {
            System.out.print(heroNamess.name + ", ");
        }

        while (true) 
        {
            boolean validHero = false;
            String heroNameInput = "";

            while (!validHero) 
            {
                System.out.print("\n\nEnter a Hero to be countered [or Type 'q' to quit] (A valid hero name, and also in a Title Case naming convention): ");
                heroNameInput = sc.nextLine();

                if (heroNameInput.equals("q")) 
                {
                    System.out.println("Goodbye!");
                    System.exit(0); 
                }

                // Check if the hero name matches any of the hero objects
                for (Hero hero : heroes) 
                {
                    if (hero.getName().equals(heroNameInput)) 
                    {
                        validHero = true;
                        break;
                    }
                }

                if (!validHero) 
                {
                    System.out.println("ERROR: Invalid hero name. Please enter a valid hero name.");
                }
            }

            String attributeInput = "";
            boolean validAttribute = false;
            while (!validAttribute) 
            {
                System.out.print("\nWhat specific hero main attribute do you want the counter hero to be (or 'q' to quit)? " +
                        "(Any letter cases: Strength, Agility, Intelligence, Universal): ");
                attributeInput = sc.nextLine().toUpperCase();

                if (attributeInput.equals("q")) 
                {
                    System.out.println("Goodbye!");
                    System.exit(0); // Exit the program if 'q' is entered
                }

                // Check if the attribute input matches any of the Attribute enum values
                try 
                {
                    Attribute.valueOf(attributeInput);
                    validAttribute = true;
                } catch (IllegalArgumentException e) 
                {
                    System.out.println("ERROR: Invalid attribute input. Please enter a valid attribute.");
                }
            }

            String roleInput = "";
            boolean validRole = false;
            while (!validRole) 
            {
                System.out.print("\nWhat role do you want the counter hero to be (or 'q' to quit)? " +
                        "(Any letter cases: SUPPORT, CARRY, NUKER, DISABLER, DURABLE, ESCAPE, PUSHER, INITIATOR): ");
                roleInput = sc.nextLine().toUpperCase();

                if (roleInput.equals("q")) 
                {
                    System.out.println("Goodbye!");
                    System.exit(0); // Exit the program if 'q' is entered
                }

                // Check if the user input matches any of the Role enum values
                try 
                {
                    Role.valueOf(roleInput);
                    validRole = true;
                } 
                catch (IllegalArgumentException e) 
                {
                    System.out.println("ERROR: Invalid role input. Please enter a valid role.");
                }
            }

            counterHero(heroNameInput, heroes, Role.valueOf(roleInput), Attribute.valueOf(attributeInput));
        }
    }

    public static void counterHero(String heroName, Hero[] heroes, Role role, Attribute attribute) 
    {
        boolean foundAntiHero = false;

        for (Hero hero : heroes) 
        {
            String[] goodAgainst = hero.getGoodAgainst();

            // Check if the hero has the specified attribute
            if (hero.getMainAttribute() != attribute) 
            {
                continue;
            }

            // Check if the hero has the specified role
            boolean hasRole = false;
            for (Role heroRole : hero.getRole()) 
            {
                if (role == heroRole) 
                {
                    hasRole = true;
                    break;
                }
            }

            if (!hasRole) 
            {
                continue;
            }

            for (String anti : goodAgainst) {
                if (anti.contains("[" + heroName + "]:")) {
                    // Split the anti string into two parts, separated by ":"
                    String[] parts = anti.split(":");
                    if (parts.length == 2) {
                        // Extract the hero's name (inside square brackets)
                        String antiHeroName = parts[0].substring(1, parts[0].length() - 1).trim();
                        
                        // Extract the description
                        String description = parts[1].trim();
                        
                        // Printing the description
                        System.out.println("\nThis hero is a counter to " + antiHeroName + ":" + "\nNAME: " + hero.getName() + "\nMAIN ATTRIBUTE: " + hero.getMainAttribute() + "\n" + hero.getRoleString() + "." + "\nREASON: " + description + "\n");
                        
                        foundAntiHero = true;
                        break;
                    }
                }
            }
            
        }

        if (!foundAntiHero) 
        {
            System.out.println("\nNo counter hero found for " + heroName + " based on the inputs.");
        }
    }

    public static void allPossibleAntiHeroes(String heroName, Hero[] heroes)
    {
        boolean foundAntiHero = false;
        for(Hero hero : heroes)
        {
            String[] goodAgainst = hero.getGoodAgainst();
            for (String anti : goodAgainst) 
            {
                if (anti.contains("[" + heroName + "]:")) 
                {
                // Split the anti string into two parts, separated by ":"
                String[] parts = anti.split(":");
                    if (parts.length == 2) 
                    {
                        // Extract the hero's name (inside square brackets)
                        String antiHeroName = parts[0].substring(1, parts[0].length() - 1).trim();
                            
                        // Extract the description
                        String description = parts[1].trim();
                            
                        // Printing the description
                        System.out.println("\nThis hero is a counter to " + antiHeroName + ":" + "\nNAME: " + hero.getName() + "\nMAIN ATTRIBUTE: " + hero.getMainAttribute() + "\n" + hero.getRoleString() + "." + "\nREASON: " + description + "\n");
                            
                        foundAntiHero = true;
                        break;
                    }
                }
            }
        }
    }
}
