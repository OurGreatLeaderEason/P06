//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 City Route Planner
// Course:   CS 300 Fall 2022
//
// Author:   Eason Xiao
// Email:    xiao227@wisc.edu
// Lecturer: Jeff Nyhoff
//
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tester class for PathUtiltester
 */
public class PathUtilsTester {
    
    /**
     * Tests the case of countPaths() when there are no valid Paths. For example, when the start position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be no valid Paths, so countPaths() should return 0.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsNoPath(){
        if(PathUtils.countPaths(new Intersection(1, 1), new Intersection(0, 1))!=0){
            System.out.println("countPaths() did not return 0 when given invalid path!");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there is a single valid Path. For example, when the start position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a single Path, so countPaths() should return 1.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsOnePath(){
        if(PathUtils.countPaths(new Intersection(1, 1), new Intersection(1, 2))!=1){
            System.out.println("Expected paths: 1\nYour value: "+PathUtils.countPaths(new Intersection(1, 1), new Intersection(1, 2)));
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there are multiple possible paths. For example, when the start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there should be three possible Paths, so countPaths() should return 3.
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsRecursive(){
        if(PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 2))!=1){
            System.out.println("Expected paths: 1\nYour value: "+PathUtils.countPaths(new Intersection(0, 0), new Intersection(1, 2)));
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are no valid Paths. For example, when the start position is Intersection(1, 1) and the ending position is Intersection(0, 1), there should be no valid Paths, so findAllPaths() should return an empty ArrayList.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath(){
        ArrayList<Path> empty=new ArrayList<Path>();
        if(!PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(0, 1)).equals(empty)){
            System.out.println("findAllPaths() did not return an empty arraylist when path is invalid!");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there is a single valid Path. For example, when the start position is Intersection(1, 1) and the ending position is Intersection(1, 2), there should be a single Path. For each of your cases, ensure that there is only a single path, and that the Path exactly matches what you expect to see.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath(){
        ArrayList<Path> paths=new ArrayList<Path>();
        Path path=new Path();
        path.addHead(new Intersection(1, 2));
        path.addHead(new Intersection(1, 1));
        paths.add(path);
        if(!PathUtils.findAllPaths(new Intersection(1, 1), new Intersection(1, 2)).equals(paths)){
            System.out.println("findAllPaths() did not return the expected arraylist when path is invalid!");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are multiple possible paths. For example, when the start position is Intersection(0, 0) and the ending position is Intersection(1, 2), there should be three possible Paths. For each of your cases, ensure that there is both the correct number of Paths, and that the returned Paths exactly match what you expect to see.
Remember: The order the Paths appear in the output of findAllPaths() will not necessarily match your own implementation.
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsRecursive(){
        ArrayList<Path> paths=new ArrayList<Path>();
        Path path1=new Path();
        path1.addHead(new Intersection(1, 1));
        path1.addHead(new Intersection(1, 0));
        path1.addHead(new Intersection(0, 0));
        Path path2=new Path();
        path2.addHead(new Intersection(1, 1));
        path2.addHead(new Intersection(0, 1));
        path2.addHead(new Intersection(0, 0));
        paths.add(path1);
        paths.add(path2);
        if(!PathUtils.findAllPaths(new Intersection(0, 0), new Intersection(1, 1)).equals(paths)){
            System.out.println("findAllPaths() did not return the expected arraylist!");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        try (Scanner keyboard = new Scanner(System.in)) {
        int startX, startY, endX, endY;
        String input = "Y";
        while (input.equalsIgnoreCase("Y")) {
        System.out.print("Enter starting X coordinate: ");
        startX = keyboard.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        startY = keyboard.nextInt();
        System.out.print("Enter ending X coordinate: ");
        endX = keyboard.nextInt();
        System.out.print("Enter ending Y coordinate: ");
        endY = keyboard.nextInt();
        Intersection start = new Intersection(startX, startY);
        Intersection end = new Intersection(endX, endY);
        System.out.println("Number of paths from start to end: "
        + PathUtils.countPaths(start, end));
        System.out.println("List of possible paths:");
        for (Path p : PathUtils.findAllPaths(start, end)) {
        System.out.println(p);
        }
        do {
        System.out.print("Try another route? (Y/N): ");
        input = keyboard.next();
        } while (!input.equalsIgnoreCase("Y")
        && !input.equalsIgnoreCase("N"));
        }
        }
        }
}
