import java.nio.file.Files;
import java.nio.file.Paths;

public class Day2Pt1 {
    public static void main(String[] args) throws Exception {
	var games = Files.lines(Paths.get(args[0]))
	    .map(l -> getPossibleGames(l))
	    .mapToInt(Integer::valueOf)
	    .sum();
	System.out.println("Output: " + games);	
    }

    private static String getPossibleGames(String rec) {
	var cubes = rec.substring(rec.indexOf(":") + 1).replaceAll(";", ",").split(", ");
	for(String cube: cubes){
	    var count = Integer.valueOf(cube.trim().substring(0, cube.trim().indexOf(" ")));
	    if(cube.endsWith("red") && count > 12 || 
		    cube.endsWith("green") && count > 13 ||
		    cube.endsWith("blue") && count > 14){
		return "0";
	    }
	}
	return rec.substring(5, rec.indexOf(":"));
    }
}
