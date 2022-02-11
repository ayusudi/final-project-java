import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static Scanner input = new Scanner(System.in);
  static String ownerName;
  static String petName;
  static int evaluation = 0;
  static int energy = 0;
  static int mood = 0;
  static int cleanliness = 0;
  static ArrayList<String> logs = new ArrayList<>();
  static int menu = 0;

  public static void main(String[] args) {
    try {
      System.out.println("Welcome to JavaGotchi");
      System.out.print("Input your name     : ");
      ownerName = input.nextLine();
      System.out.print("Input your pet name : ");
      petName = input.nextLine();
      clear();
      showStatus();
      showPet();
      do {
        tryToEvolve();
        menu = showAndChooseMenu();
        clear();
        switch (menu) {
          case 1:
            sleep();
            break;
          case 2:
            shower();
            break;
          case 3:
            eat();
            break;
          case 4:
            activity();
            break;
          case 5:
            showPet();
            break;
          case 6:
            exitMessage();
            break;
          default:
            break;
        }
      } while (menu != 6);
    } catch (Exception e) {
      System.out.println("ERROR");
      System.out.println(e);
    } 
  }
  
  // MENU
  public static int showAndChooseMenu() throws InterruptedException {
    int choosen = 0;
    System.out.println("Menu Game Javatchi");
    System.out.println("[1] Sleep");
    System.out.println("[2] Shower");
    System.out.println("[3] Eat");
    if (evaluation < 2) {
      System.out.println("[4] Play");
    } else {
      System.out.println("[4] Work");
      System.out.println("Your pet is an adult (he/she are available to go work)");
    }
    System.out.println("[5] Admire");
    System.out.println("[6] Exit");
    System.out.print("> ");
    choosen = Integer.parseInt(input.nextLine());
    System.out.print("LOADING ");
    for (int i = 0; i < 5; i++) {
      Thread.sleep(500);
      System.out.print(" . ");
    }
    System.out.println();
    return choosen;
  }

  // MENU 1 SLEEP
  public static void sleep() throws InterruptedException {
    System.out.print("Input duration of sleep : ");
    int duration = Integer.parseInt(input.nextLine());
    System.out.println("\nINFO : you're not allowed awake your pet while he/she sleeping under the set duration.\n");
    System.out.print("> Enter to close INFO ");
    input.nextLine();
    int count = 0;
    if (duration > 5)
      energy = 100;
    else if (duration > 2)
      energy += 25;
    else
      energy += 10;
    do {
      switch (evaluation) {
        case 0:
          // Kid
          break;
        case 1:
          // Teen
          break;
        case 2:
          // Adult
          break;
      }
      count++;
      Thread.sleep(1000);
      if (count == 1) {
        System.out.println(petName + " has been sleep for a hour");
      } else {
        System.out.println(petName + " has been sleep for " + count + " hour");
      }
    } while (count < duration);
    System.out.print("> Enter to awake your pet ");
  }

  // MENU 2 SHOWER
  public static void shower() {
    logs.add("Shower");
    cleanliness = 100;
    if (energy > 50 && energy <= 100)
      energy -= 5;
    if (mood > 50)
      mood -= 10;
    switch (evaluation) {
      case 0:
        // Kid
        break;
      case 1:
        // Teen
        break;
      case 2:
        // Adult
        break;
    }
    System.out.print("> Enter to finish shower ");
    input.nextLine();
  }

  // MENU 3 EAT
  public static void eat() {
    logs.add("Eat");
    energy = 100;
    if (mood < 50)
      mood = 50;
    switch (evaluation) {
      case 0:
        // Kid
        break;
      case 1:
        // Teen
        break;
      case 2:
        // Adult
        break;
    }
    System.out.print("> Enter to finish eating ");
    input.nextLine();
    if (cleanliness > 50) {
      cleanliness = 20;
      System.out.println("\nINFO : Ooops, " + petName + " just poop recently.. \n");
      logs.add("Poop");
      System.out.print("> Enter to close INFO ");
      input.nextLine();
    }
    ;

  }

  // MENU 4 PLAY / WORK
  public static void activity() {
    String action = "";
    if (evaluation == 2) {
      action = "Work";
      energy -= 20;
      if (mood > 50)
        mood -= 10;
      else
        mood = 10;
      System.out.println(); // Adult
      System.out.print("> Enter to finish work and go home ");
    } else {
      action = "Play";
      energy -= 10;
      mood = 100;
      switch (evaluation) {
        case 0:
          // Kid
          break;
        case 1:
          // Teen
          break;
      }
      logs.add(action);
      System.out.print("> Enter to finish play ");
    }
    if (energy < 0) {
      energy = 0;
      System.out
          .println("\nINFO : Your pet (" + petName + ") is passed out due to over-" + action.toLowerCase() + ".. \n");
      logs.add("Pass Out");
      System.out.print("> Enter to close INFO ");
      input.nextLine();
    }
  }

  // MENU 5 
  public static void showLog(){

  }

  // MENU 6 EXIT
  public static void exitMessage() {
    System.out.println("\nTo   : " + ownerName);
    System.out.println("From : " + petName);
    System.out.println("Thank you for your care, good bye..");
    showPet();
  }

  // OTHERS
  public static void information() {

  }
  public static void showStatus() {

  }
  public static void showPet() {
    switch (evaluation) {
      case 0: // KID
        System.out.println("\n _______");
        System.out.println("/ .   . ⎤");
        System.out.println("|   O   |");
        System.out.println("⎣_______/\n");
        break;
      case 1: // Teen
        
        break;
      case 2:
        // Adult
        break;
    }
  }
  public static void tryToEvolve(){
    int totalLog = logs.size();
    if (totalLog < 5) {
      evaluation = 0;
    } else if (totalLog < 10) {
      evaluation = 1;
    } else {
      evaluation = 2;
    }
  }
  public static void clear(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}