package main.java;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Test
public class BlockudokuTest {

    public void testCase0() throws IOException {
        genericMatrix(0);
    }

   

    private void genericMatrix(int n) throws IOException {
        ArrayList<ArrayList<Integer>> positions = readInputPositions(n);
        Blockudoku ms = new Blockudoku();
        List<String> expectedOutput = readOutput(n);
        for (int i = 0; i < expectedOutput.size(); ++i) { 
            ms.play(positions.get(i).get(0), positions.get(i).get(1));
            Assert.assertEquals(expectedOutput.get(i).equals("1"), ms.gameOver);
        }
    }

    private ArrayList<ArrayList<Integer>> readInputPositions(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        int count = 0;
        for (int i = 0; i < lines.size(); i += 2) {
            out.add(new ArrayList<Integer>());
            out.get(count).add(0, Integer.parseInt(lines.get(i)));
            out.get(count).add(1, Integer.parseInt(lines.get(i + 1)));
            count += 1;
        }
        return out;
    }


    private List<String> readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines;
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}
