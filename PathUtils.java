import java.util.ArrayList;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 City Route Planner
// Course:   CS 300 Fall 2022
//
// Author:   Eason Xiao
// Email:    xiao227@wisc.edu
// Lecturer: Jeff Nyhoff
//

/**
 * A class that contains useful methods for paths
 */
public class PathUtils {
    
    /**
     * Finds the number of valid Paths between the given start and end Intersections. If it is not possible to get from the start to the end intersection by moving up or right, then 0 should be returned. 
     * For example, if start is Intersection(0, 0) and end is Intersection(2, 1), this method should return 3. If start is Intersection(1, 0) and end is Intersection(0, 0), this method should return 0. 
     * MUST be implemented recursively. If you wish, you can use a call to a private static helper method which is recursive.
     * @param start Intersection to start at
     * @param end Intersection to end at
     * @return the number of valid Paths which start and end at the given Intersections
     */
    public static int countPaths(Intersection start, Intersection end){
        if(end.getX()<start.getX() || end.getY()<start.getY()){
            return 0;
        }
        if(end.getX()==start.getX() || end.getY()==start.getY()){
            return 1;
        }
        return countPaths(start, end.goSouth())+countPaths(start, end.goWest());
    }

    /**
     * Recursive method that generates the Arraylist of all possible paths
     * @param start start coordinate
     * @param paths ArrayList of paths
     * @return
     */
    private ArrayList<Path> pathFinder(Intersection start, ArrayList<Path> paths){
        System.out.println(paths);
        PathUtils tool=new PathUtils();
        //base case
        int counter=0;
        for(int j=0; j<paths.size(); j++){
            if(paths.get(j).getHead().equals(start)){
                counter++;
            }
        }
        if(counter==paths.size()){
            return paths;
        }
        //pain
            int loop=paths.size();
            for(int i=0; i<loop; i++){
                if(!paths.get(i).getHead().equals(start)){
                if(paths.get(i).getHead().getY()==start.getY() ){
                    paths.get(i).addHead(paths.get(i).getHead().goWest());
                   
                }
                else if(paths.get(i).getHead().getX()==start.getX() ){
                    paths.get(i).addHead(paths.get(i).getHead().goSouth());
                   
                }
                else{
                    
                    Path clone=new Path();
                    clone=tool.clonePath(paths.get(i));
                    paths.add(tool.pathBuilderSouth(paths.get(i)));
                    paths.add(tool.pathBuilderWest(clone));
                    paths.remove(i);
                    
                }
            }
            }
            return tool.pathFinder(start, paths);
        
        
        
    }
   

   

   
    
    /**
     * Private helper method that adds a southward intersection to the front of the Path
     * @param path the path that we want to modify
     * @return modified path
     */
   private Path pathBuilderSouth(Path path){
    
        path.addHead(path.getHead().goSouth());
        return path;
   }

   /**
    * Private helper method that adds a westward intersection to the front of the Path
    * @param path the path that we want to modify
    * @return modified path
    */
   private Path pathBuilderWest(Path path){
    
    path.addHead(path.getHead().goWest());
    return path;

}

  

   
    /**
     * private helper method that creates a deep copy of a path
     * @param path the path that we want to clone
     * @return cloned path
     */
    private Path clonePath(Path path){
        Path clone=new Path();
        for(int i=0; i<path.length(); i++){
            int x=Integer.valueOf(path.toString().substring(1+7*i, 2+7*i));
            int y=Integer.valueOf(path.toString().substring(3+7*i, 4+7*i));
            clone.addTail(new Intersection(x, y));
        }
        return clone;
    }

    /**
     * Finds all valid Paths between the given start and end Intersections. If it is not possible to get from the start to the end intersection by moving up or right, then an empty ArrayList should be returned.
For example, if start is Intersection(0, 0) and end is Intersection(2, 1), this method should return an ArrayList consisting of the following Paths:
(0,0)->(1,0)->(2,0)->(2,1)
(0,0)->(1,0)->(1,1)->(2,1)
(0,0)->(0,1)->(1,1)->(2,1)
If start is Intersection(1, 0) and end is Intersection(0, 0), this method should return an empty ArrayList.
MUST be implemented recursively. If you wish, you can use a call to a private static helper method which is recursive.
     * @param start Intersection to start at
     * @param end Intersection to end at
     * @return an ArrayList containing all valid Paths which start and end at the given Intersections
     */
    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end){
        if(countPaths(start, end)==0){
            return new ArrayList<Path>();
        }
        PathUtils tool=new PathUtils();
        ArrayList<Path> paths=new ArrayList<Path>();
        Path last=new Path(); 
        last.addHead(end);
        paths.add(last);
        return tool.pathFinder(start, paths);
        
    }

    
}
