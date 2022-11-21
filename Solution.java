import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        BufferedReader br = null;
        String line = null;
        HashMap<String, ArrayList<String>> ret = new HashMap<>();
        br = new BufferedReader(new FileReader("words-utf8.txt"));
        while ((line = br.readLine()) != null) {
            char[] chars = line.strip().toCharArray();
            if (chars.length <= 0)
                continue;
            Arrays.sort(chars);
            String sorted = new String(chars);
            ret.putIfAbsent(sorted, new ArrayList<>());
            ret.get(sorted).add(line);
        }
        for(Map.Entry<String, ArrayList<String>> entry : ret.entrySet()){
            ArrayList<String> v = entry.getValue();
            if (v.size() > 1)
                System.out.println(Arrays.toString(v.toArray()));
        }
        
    }
}