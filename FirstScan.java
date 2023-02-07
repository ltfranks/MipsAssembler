import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FirstScan extends lab3 {
    Scanner file;

    public FirstScan(String file) {
        try {
            this.file = new Scanner(new File(file));
            while (this.file.hasNextLine()) {
                String line = this.file.nextLine();
                // removes all spaces in file read. And it also gets rid of all comments "#.."
                line = line.trim().replaceAll("\\s", "").replaceAll("#.*$", "");
                if (line.isBlank() || line.isEmpty()) {
                    continue;
                }
//                System.out.println(line);
                if (line.contains(":")) {
                    String[] parts = line.split(":");
                    LabelLocation.put(parts[0], LineCount);
                }
                ++LineCount;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
//        System.out.println(super.LineCounter);
        System.out.println(LabelLocation);
    }
}
