import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InteractiveMode extends lab3 {
    List<String> userInput = new ArrayList<>();

    public InteractiveMode() {
        // user
        while (true) {
            System.out.print("mips> ");
            Scanner input = new Scanner(System.in);
            String userInput = input.nextLine();
            String[] userArray = userInput.split(" ");

            if (userArray[0].equals("q")) {
                break;
            }
            else {
                emulator(userArray);
            }

        }
    }

    public InteractiveMode(String file) {
        // script
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
            int spCounter = 0;
            if (userArray[0].equals("s")) {  // s with number

                System.out.println(cleanedFile);
                registers.replace("$a1",  // rd = r1 + #;
                        3);
//                System.out.println("yoyoyo: " + registers.get("$a1"));
                System.out.println("BRO HERE " +cleanedFile.get(LineCount).get(1));
//                registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 + #;
//                        (registers.get(cleanedFile.get(LineCount).get(2)) + Integer.parseInt(cleanedFile.get(LineCount).get(3))));


                for (int i = 0; i <= num1; i++){


                    if (cleanedFile.get(LineCount).get(0).equals("add")){ // add
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 + r2;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        + registers.get(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("addi")){
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 + #;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        + Integer.parseInt(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("sub")){ // sub
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 - r2;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        - registers.get(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("and")){ // and
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 & r2;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        & registers.get(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("or")){ // or
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 | r2;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        | registers.get(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("sll")){ // sll
                        registers.replace(cleanedFile.get(LineCount).get(1),  // rd = r1 << r2;
                                registers.get(cleanedFile.get(LineCount).get(2))
                                        << registers.get(cleanedFile.get(LineCount).get(3)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("slt")){ // set less than
                        if (registers.get(cleanedFile.get(LineCount).get(2)) < registers.get(cleanedFile.get(LineCount).get(3))){
                            registers.replace(cleanedFile.get(LineCount).get(1), 1);    // if rs < rt then rd = 1. else, rd = 0
                        } else {
                            registers.replace(cleanedFile.get(LineCount).get(1), 0);
                        }
                    } else if (cleanedFile.get(LineCount).get(0).equals("jr")){ // jr
                        registers.replace("pc", registers.get(cleanedFile.get(LineCount).get(1)));
                    } else if (cleanedFile.get(LineCount).get(0).equals("beq")){ // if rs = rt then, j -> label
                        if (registers.get(cleanedFile.get(LineCount).get(1)).equals(registers.get(cleanedFile.get(LineCount).get(2)))){
                            LineCount = LineCount - LabelLocation.get(cleanedFile.get(LineCount).get(3));  // lineCount = lineCount - LabelLocation
                        }
                    } else if (cleanedFile.get(LineCount).get(0).equals("bne")){ // rs != rt then, j -> label
                        if (!registers.get(cleanedFile.get(LineCount).get(1)).equals(registers.get(cleanedFile.get(LineCount).get(2)))){
                            LineCount = LineCount - LabelLocation.get(cleanedFile.get(LineCount).get(3));  // lineCount = lineCount - LabelLocation
                        }
                    } else if (cleanedFile.get(LineCount).get(0).equals("sw")){
                        if (!("$"+cleanedFile.get(LineCount).get(2).charAt(3)+cleanedFile.get(LineCount).get(2).charAt(4)).equals("$sp")){
                            registers.replace(cleanedFile.get(LineCount).get(1),  // rd = #($register)
                                    registers.get("$"+cleanedFile.get(LineCount).get(2).charAt(3)
                                            +cleanedFile.get(LineCount).get(2).charAt(4)));
                        } else {  // sp case
                            // sw $a0 4($sp)
                            // memory[4] = $a0
                            data[cleanedFile.get(LineCount).get(2).charAt(0)] =
                                    registers.get(cleanedFile.get(LineCount).get(1));
                        }
                    } else if (cleanedFile.get(LineCount).get(0).equals("lw")){
                        
                    }


                    // still need lw, j, jal
                    System.out.println("Instructions Executed: "+(LineCount+1));
                    LineCount++;
                }

//                System.out.println(userArray[0] + num1);
            } else if (userArray[0].equals("m") && userArray.length == 3) {
                System.out.println(userArray[0]);

                int num2 = Integer.parseInt(userArray[2]);
                // replace
                System.out.println(userArray[0] + num1 + num2);
            }
        } // single letter instructions ^^^
        else {
            if (userArray[0].equals("h")) {
                System.out.println(userArray[0]);
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
                System.out.println(userArray[0]);

//                registers.replaceAll((k, v) -> 0);

                System.out.println("pc = " + registers.get("pc"));
                System.out.println("$0 = " + registers.get("$0") + "          $v0 = " + registers.get("$v0")
                        + "         $v1 = " + registers.get("$v1") + "         $a0 = " + registers.get("$a0"));
                System.out.println("$a1 = " + registers.get("$a1") + "         $a2 = " + registers.get("$a2")
                        + "         $a3 = " + registers.get("$a3") + "         $t0 = " + registers.get("$t0"));
                System.out.println("$t1 = " + registers.get("$t1") + "         $t2 = " + registers.get("$t2")
                        + "         $t3 = " + registers.get("$t3") + "         $t4 = " + registers.get("$t4"));
                System.out.println("$t5 = " + registers.get("$t5") + "         $t6 = " + registers.get("$t6")
                        + "         $t7 = " + registers.get("$t7") + "         $s0 = " + registers.get("$s0"));
                System.out.println("$s1 = " + registers.get("$s1") + "         $s2 = " + registers.get("$s2")
                        + "         $s3 = " + registers.get("$s3") + "         $s4 = " + registers.get("$s4"));
                System.out.println("$s5 = " + registers.get("$s5") + "         $s6 = " + registers.get("$s6")
                        + "         $s7 = " + registers.get("$s7") + "         $t8 = " + registers.get("$t8"));
                System.out.println("$t9 = " + registers.get("$t9") + "         $sp = " + registers.get("$sp")
                        + "         $ra = " + registers.get("$ra"));

                // replace
            } else if (userArray[0].equals("s")) { // s
                System.out.println(userArray[0]);


                // replace
                System.out.println();
            } else if (userArray[0].equals("r")) {
                System.out.println(userArray[0]);

                // run until program ends
                System.out.println();
            } else if (userArray[0].equals("m")) {
                System.out.println(userArray[0]);

                // replace
                System.out.println();
            } else if (userArray[0].equals("c")) {
                System.out.println("c");

                registers.replaceAll((k, v) -> 0);
                // replace
                System.out.println("Simulator reset");
            }
        }
        System.out.println();
    }
}
