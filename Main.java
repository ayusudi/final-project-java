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
  public static void main(String[] args) throws InterruptedException {
    System.out.println("\nWelcome to JavaGotchi");
    System.out.println("- - - - - - - - - - -\n");
    System.out.print("Input your name     : ");
    ownerName = input.nextLine();
    System.out.print("Input your pet name : ");
    petName = input.nextLine();
    clear();
    logs.add("Create pet (" + petName + ")");
    do {
      try {
        String errorMsg = "Choosen menu accept input 1 to 6.";
        onSetMaxMin();
        tryToEvolve();
        showStatus();
        showPet();
        menu = showAndChooseMenu();
        clear();
        switch (menu) {
          case 1: sleep(); break;
          case 2: bath(); break;
          case 3: eat(); break;
          case 4: play(); break;
          case 5: showLog(); break;
          case 6: exitMessage(); break;
          default: throw new Exception(errorMsg);
        }
      } catch (Exception e) {
        System.out.println("\nERROR");
        System.out.println(e);
        System.out.print("RELOADING ");
        for (int i = 0; i < 5; i++) {
          Thread.sleep(250);
          System.out.print(" . ");
        }
        System.out.println();
        clear();
      }
    } while (menu != 6);
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
    clear();
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
    logs.add("Sleep");
    System.out.print("\n> Enter to awake your pet ");
    input.nextLine();
    clear();
  }

  // MENU 2 BATH
  public static void bath() throws IOException {
    logs.add("Bath");
    cleanliness = 100;
    if (energy > 50 && energy <= 100)
      energy -= 5;
    if (mood > 50)
      mood -= 10;
    String content = new String(Files.readAllBytes(Paths.get("./ascii-art/bath.txt")));
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

  // MENU 4 PLAY
  public static void play() throws IOException {
    energy -= 10;
    mood = 100;
    logs.add("Play");
    String content = new String(Files.readAllBytes(Paths.get("./ascii-art/play.txt")));
    System.out.println(content);
    System.out.print("> Enter to finish play ");
    input.nextLine();
    clear();
    if (energy < 0) {
      energy = 0;
      System.out.println("\nINFO : Your pet (" + petName + ") is passed out due to over-play.. \n");
      logs.add("Pass Out");
      System.out.print("> Enter to close INFO ");
      input.nextLine();
    }
    clear();
  }

  // MENU 5 LOG
  public static void showLog() {
    System.out.println("Your Logs on JavaGothi");
    System.out.println("- - - - - - - - - - - -\n");
    for (int i = 0; i < logs.size(); i++) {
      System.out.println(i + 1 + ". " + logs.get(i));
    }
    System.out.println();
    System.out.print("\n> Enter to close logs ");
    input.nextLine();
    clear();
  }

  // MENU 6 EXIT
  public static void exitMessage() {
    clear();
    System.out.println("Exit from JavaGotchi");
    System.out.println("- - - - - - - - - - - ");
    showPetBye();
    System.out.println();
    System.out.println("To      : " + ownerName);
    System.out.println("From    : " + petName);
    System.out.println("Message : Thank you for your care, good bye..\n");
    input.close();
    System.exit(0);
  }

  // OTHERS
  public static void showStatus() {
    System.out.println();
    System.out.println('"' + petName + '"');
    System.out.print("Energy " + energy + " | ");
    String status = mood < 50 ? "Bad Mood" : "Good Mood";
    System.out.print(status + " " + mood + " | ");
    System.out.print("Cleanliness " + cleanliness);
    System.out.println();
  }

  public static void showPetBye() {
    System.out.println();
    switch (evaluation) {
      case 0: // BABY
        System.out.println(" _______");
        System.out.println("/ TT TT ⎤  HUAA ");
        System.out.println("|   O   |      HUAAA");
        System.out.println("⎣_______/");
        break;
      case 1: // KID
        System.out.println(" ________");
        System.out.println("/ TT  TT ⎤  HIKSS");
        System.out.println("|   m    |");
        System.out.println("⎣________/");
        break;
      case 2: // TEEN
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
      case 0: // BABY
        System.out.println(" _______");
        System.out.println("/ .   . ⎤");
        System.out.println("|   O   |");
        System.out.println("⎣_______/");
        break;
      case 1: // KID
        System.out.println(" ________");
        System.out.println("/ o   o  ⎤");
        System.out.println("|   m    |");
        System.out.println("⎣________/");
        break;
      case 2: // TEEN
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
    int count = 0;
    for (int i = 0; i < logs.size(); i++) {
      if (logs.get(i) == "Evolve") {
        count++;
      }
    }
    if (count == 0 && totalLog >= 5) {
      evaluation = 1; // BABY -> KID
      logs.add("Evolve");
      System.out.println("INFO : Congrats! " + petName + " is not a baby anymore!\n");
    } else if (count == 1 && totalLog >= 10) {
      evaluation = 2; // KID -> TEEN
      logs.add("Evolve");
      System.out.println("INFO : Happy birthday " + petName + "! your a teenager now.\n");
    }
  }

  public static void onSetMaxMin() {
    if (energy > 100)
      energy = 100;
    if (mood > 100)
      mood = 100;
    if (cleanliness > 100)
      cleanliness = 100;
    if (energy < 0)
      energy = 0;
    if (mood < 0)
      mood = 0;
    if (cleanliness < 0)
      cleanliness = 0;
  }

  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}