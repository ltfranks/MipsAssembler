import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InteractiveMode extends lab3 {
    List<String> userInput = new ArrayList<>();

    public InteractiveMode() {

        while (true) {
            System.out.print("mips> ");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            String[] userArray = userInput.split(" ");

            if (userArray[0].equals("q")) {
                break;
            } else {
                emulator(userArray);
            }

        }
    }

    public InteractiveMode(String file) {
        try {
            Scanner assemblyFile = new Scanner(new File(file));
            while (assemblyFile.hasNextLine()) {
                userInput.add(assemblyFile.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        for (String command : userInput) {
            if (command.equals("q")) {
                break;
            } else {
                System.out.print("mips> ");
                emulator(command.split(" "));
            }
        }

    }

    public void emulator(String[] userArray) {
        if (userArray.length > 1) {
            int num1 = Integer.parseInt(userArray[1]);
            if (userArray[0].equals("s")) {
                // replace
                System.out.println(userArray[0] + num1);
            } else if (userArray[0].equals("m") && userArray.length == 3) {
                int num2 = Integer.parseInt(userArray[2]);
                // replace
                System.out.println(userArray[0] + num1 + num2);
            }
        } else {
            if (userArray[0].equals("h")) {
                System.out.println();
                System.out.print("""
                                                
                        h = show help
                        d = dump register state
                        s = single step through the program (i.e. execute 1 instruction and stop)
                        s num = step through num instructions of the program
                        r = run until the program ends
                        m num1 num2 = display data memory from location num1 to num2
                        c = clear all registers, memory, and the program counter to 0
                        q = exit the program""");
                System.out.println();
            } else if (userArray[0].equals("d")) {

//                Registers.replaceAll((k, v) -> 0);

                System.out.println("pc = " + Registers.get("pc"));
                System.out.println("$0 = " + Registers.get("$0") + "          $v0 = " + Registers.get("$v0")
                        + "         $v1 = " + Registers.get("$v1") + "         $v2 = " + Registers.get("$v2"));
                System.out.println("$a1 = " + Registers.get("$a1") + "         $a2 = " + Registers.get("$a2")
                        + "         $a3 = " + Registers.get("$a3") + "         $t0 = " + Registers.get("$t0"));
                System.out.println("$t1 = " + Registers.get("$t1") + "         $t2 = " + Registers.get("$t2")
                        + "         $t3 = " + Registers.get("$t3") + "         $t4 = " + Registers.get("$t4"));
                System.out.println("$t5 = " + Registers.get("$t5") + "         $t6 = " + Registers.get("$t6")
                        + "         $t7 = " + Registers.get("$t7") + "         $s0 = " + Registers.get("$s0"));
                System.out.println("$s1 = " + Registers.get("$s1") + "         $s2 = " + Registers.get("$s2")
                        + "         $s3 = " + Registers.get("$s3") + "         $s4 = " + Registers.get("$s4"));
                System.out.println("$s5 = " + Registers.get("$s5") + "         $s6 = " + Registers.get("$s6")
                        + "         $s7 = " + Registers.get("$s7") + "         $t8 = " + Registers.get("$t8"));
                System.out.println("$t9 = " + Registers.get("$t9") + "         $sp = " + Registers.get("$sp")
                        + "         $ra = " + Registers.get("$ra"));

                // replace
                System.out.println();
            } else if (userArray[0].equals("s")) {

                // replace
                System.out.println();
            } else if (userArray[0].equals("r")) {
                // replace
                System.out.println();
            } else if (userArray[0].equals("m")) {
                // replace
                System.out.println();
            } else if (userArray[0].equals("c")) {
                Registers.replaceAll((k, v) -> 0);
                // replace
                System.out.println("Simulator reset");
            }
        }
        System.out.println();
    }
}
