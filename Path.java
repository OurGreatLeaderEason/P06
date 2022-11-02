import java.util.ArrayList;
import java.util.NoSuchElementException;

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
 * A class that emulates the behavior of a path
 */
public class Path {
    private ArrayList<Intersection> intersections;

    /**
     * Initializes this Path to start as empty
     */
    public Path(){
        this.intersections=new ArrayList<Intersection>();
    }

    /**
     * Returns the number of Intersections in this Path
     * @return the number of Intersections in this Path
     */
    public int length(){
        return this.intersections.size();
    }

    /**
     * Returns the first Intersection in this Path, if it is not empty. Otherwise, throws a NoSuchElementException.
     * @return the first Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this Path is empty
     */
    public Intersection getHead() throws NoSuchElementException{
        if(this.intersections.size()==0){
            throw new NoSuchElementException("Path is empty!");
        }
        return this.intersections.get(0);
    }

    /**
     * Returns the last Intersection in this Path, if it is not empty. Otherwise, throws a NoSuchElementException.
     * @return the last Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this Path is empty
     */
    public Intersection getTail() throws NoSuchElementException{
        if(this.intersections.size()==0){
            throw new NoSuchElementException("Path is empty!");
        }
        return this.intersections.get(this.intersections.size()-1);
    }

    /**
     * Adds the given Intersection to the end of this Path if it is a valid addition. A Intersection is a valid addition if the current Path is empty, or the Intersection to add is one step directly east, or one step directly north of the current tail Intersection in this Path. Should throw an IllegalArgumentException if the given Intersection is not a valid addition.
     * @param toAdd Intersection to add to the end of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addTail(Intersection toAdd) throws IllegalArgumentException{
        if(this.length()!=0 && toAdd.equals(this.getTail().goEast())==false && toAdd.equals(this.getTail().goNorth())==false ){
            throw new IllegalArgumentException("Cannot move to this intersection!");
        }
        this.intersections.add(toAdd);
    }

    /**
     * Adds the given Intersection to the front of this Path if it is a valid addition. A Intersection is a valid addition if the current Path is empty, or the Intersection to add is one step directly west, or one step directly south of the current head Intersection in this Path. Should throw an * IllegalArgumentException if the given Intersection is not a valid addition.
     * @param toAdd Intersection to add to the beginning of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addHead(Intersection toAdd) throws IllegalArgumentException{
        if(this.length()!=0 && toAdd.equals(this.getHead().goWest())==false && toAdd.equals(this.getHead().goSouth())==false ){
            throw new IllegalArgumentException("Cannot add this Intersection!");
        }
        this.intersections.add(0, toAdd);
    }

    /**
     * Returns a String representing the coordinates taken in this Path. An empty Path should return the String "Empty", while a non-empty Path should return the coordinates of the Intersections it visits separated by a "->". For example:(0,0)->(1,0)->(1,1)->(1,2)
     * @return a String representing the coordinates followed by this Path
     */
    @Override
    public String toString(){
        String returnVal=this.intersections.get(0).toString();
        for(int i=1; i<this.intersections.size(); i++){
            returnVal+="->"+this.intersections.get(i).toString();
        }
        return returnVal;
    }

    public static void main(String[] args){
        Path path=new Path();
        path.addTail(new Intersection(0, 0));
        path.addTail(new Intersection(1, 0));
        path.addTail(new Intersection(2, 0));
        path.addTail(new Intersection(3, 0));
        Path clone=new Path();
      /* 
        for(int i=0; i<path.length(); i++){
            int x=Integer.valueOf(path.toString().substring(1+7*i, 2+7*i));
            int y=Integer.valueOf(path.toString().substring(3+7*i, 4+7*i));
            clone.addTail(new Intersection(x, y));
        }
        */
        
        
        System.out.println(path);
        //System.out.println(clone);
        
    }
}
