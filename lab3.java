import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lab3 {

    HashMap<String, Integer> Registers = new HashMap<>();
    HashMap<String, Integer> LabelLocation = new HashMap<>();
    ArrayList<List<String>> cleanedFile = new ArrayList<>();
    int LineCount = 0;

    int[] data = new int[8192];
    public static void main(String[] args) throws IOException {
        new Registers();
        if (args.length == 1) {
            new InteractiveMode();
        }
        else {new ScanAssembly(args[0]);
            new InteractiveMode(args[1]);
        }
    }
}
