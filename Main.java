import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            bath();
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
    System.out.println("[2] Bath");
    System.out.println("[3] Eat");
    System.out.println("[4] Play");
    System.out.println("[5] Logs");
    System.out.println("[6] Exit");
    System.out.print("> ");
    choosen = Integer.parseInt(input.nextLine());
    System.out.print("LOADING ");
    for (int i = 0; i < 5; i++) {
      Thread.sleep(250);
      System.out.print(" . ");
    }
    System.out.println();
    return choosen;
  }

  // MENU 1 SLEEP
  public static void sleep() throws InterruptedException {
    System.out.print("Input duration of sleep : ");
    int duration = Integer.parseInt(input.nextLine());
    System.out.println("  ____");
    System.out.println(" ( ._.)");
    System.out.println(" _| ⊃/(_____");
    System.out.println("/  └-(_____/");
    System.out.println("￣￣￣￣￣￣");
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
    System.out.println("      Z z z . .");
    System.out.println("  __/ヽ-､__");
    System.out.println("/⌈_/_____/");
    System.out.println("￣￣￣￣￣");
    do {
      Thread.sleep(1000);
      clear();
      count++;
      System.out.println("      Z z z . .");
      System.out.println("  __/ヽ-､__");
      System.out.println("/⌈_/_____/");
      System.out.println("￣￣￣￣￣");
      System.out.println(petName + " has been sleep for " + count + " hour/s");
    } while (count < duration);
    System.out.print("\n> Enter to awake your pet ");
    input.nextLine();
    clear();
  }

  // MENU 2 Bath
  public static void bath() throws IOException {
    logs.add("Bath");
    cleanliness = 100;
    if (energy > 50 && energy <= 100)
      energy -= 5;
    if (mood > 50)
      mood -= 10;
    String content = new String(Files.readAllBytes(Paths.get("text.txt")));
    System.out.println(content);
    System.out.print("> Enter to finish bath ");
    input.nextLine();
    clear();
  }

  // MENU 3 EAT
  public static void eat() {
    logs.add("Eat");
    energy = 100;
    if (mood < 50)
      mood = 50;
    switch (evaluation) {
      case 0:
        System.out.println(" _______");
        System.out.println("/ .   . ⎤");
        System.out.println("|  🍼C  |");
        System.out.println("⎣_______/");
        break;
      case 1:
        System.out.println(" ________");
        System.out.println("/ o   o  ⎤ NYAM NYAM CAKE");
        System.out.println("| -🍰-   |");
        System.out.println("⎣________/");
        break;
      case 2:
        System.out.println(" _______");
        System.out.println("/        ⎤");
        System.out.println("| >   <  | HAMBURGER~");
        System.out.println("|  E🍔Ǝ  |");
        System.out.println("⎣________/");
        break;
    }
    System.out.print("\n> Enter to finish eating ");
    input.nextLine();
    if (cleanliness > 50) {
      cleanliness = 20;
      System.out.println("\nINFO : Ooops, " + petName + " just poop recently.. \n");
      logs.add("Poop");
      System.out.print("> Enter to close INFO ");
      input.nextLine();
    }
    clear();
  }

  // MENU 4 PLAY / WORK
  public static void activity() {
    energy -= 10;
    mood = 100;
    logs.add("Play");
    System.out.print("> Enter to finish play ");
    if (energy < 0) {
      energy = 0;
      System.out.println("\nINFO : Your pet (" + petName + ") is passed out due to over-play.. \n");
      logs.add("Pass Out");
      System.out.print("> Enter to close INFO ");
      input.nextLine();
    }
    clear();
  }

  // MENU 5
  public static void showLog() {

  }

  // MENU 6 EXIT
  public static void exitMessage() {
    showPetBye();
    System.out.println("\nTo   : " + ownerName);
    System.out.println("From : " + petName);
    System.out.println("Thank you for your care, good bye..\n");
  }

  // OTHERS
  public static void information() {

  }

  public static void showStatus() {

  }

  public static void showPetBye() {
    System.out.println();
    switch (evaluation) {
      case 0: // KID
        System.out.println(" _______");
        System.out.println("/ TT TT ⎤  HUAA ");
        System.out.println("|   O   |      HUAAA");
        System.out.println("⎣_______/");
        break;
      case 1: // TEEN
        System.out.println(" ________");
        System.out.println("/ TT  TT ⎤  HIKSS");
        System.out.println("|   m    |");
        System.out.println("⎣________/");
        break;
      case 2: // ADULT
        System.out.println(" ________");
        System.out.println("/        ⎤");
        System.out.println("| TT  TT |  BYE");
        System.out.println("|   _    |");
        System.out.println("⎣________/");
        break;
    }
    System.out.println();
  }

  public static void showPet() {
    System.out.println();
    switch (evaluation) {
      case 0: // KID
        System.out.println(" _______");
        System.out.println("/ .   . ⎤");
        System.out.println("|   O   |");
        System.out.println("⎣_______/");
        break;
      case 1: // TEEN
        System.out.println(" ________");
        System.out.println("/ o   o  ⎤");
        System.out.println("|   m    |");
        System.out.println("⎣________/");
        break;
      case 2: // ADULT
        System.out.println(" ________");
        System.out.println("/        ⎤");
        System.out.println("| 0   0  |");
        System.out.println("|   _    |");
        System.out.println("⎣________/");
        break;
    }
    System.out.println();
  }

  public static void tryToEvolve() {
    int totalLog = logs.size();
    if (totalLog < 5) {
      evaluation = 0;
    } else if (totalLog < 10) {
      evaluation = 1;
    } else {
      evaluation = 2;
    }
  }

  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

}