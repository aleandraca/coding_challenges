import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.util.Collections.max;

public class Day2Pt2 {
    public static void main(String[] args) throws Exception {
	var total = Files.lines(Paths.get(args[0]))
	    .map(l -> getCubesPowSet(l)).mapToInt(Integer::intValue)
	    .sum();
	System.out.println("Output: " + total); 
    }

    private static int getCubesPowSet(String rec) {
	var cubes = rec.substring(rec.indexOf(":") + 2).split(";\\s*|,\\s*");
	var reds = new ArrayList<Integer>();
	var greens = new ArrayList<Integer>();
	var blues =  new ArrayList<Integer>();
	for(var cube : cubes){
	    var data = cube.split(" ");
	    var count = Integer.valueOf(data[0]);
	    switch(data[1]){
		case "red" -> reds.add(count);
		case "green" -> greens.add(count);
		case "blue" -> blues.add(count);
	    }
        }
	return max(reds) * max(greens) * max(blues);
    }
}
