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
 * A class that emulates the behavior of an intersection
 */
public class Intersection {
    private final int x;
    private final int y;

    /**
     * Initializes this intersection with the given coordinates
     * @param x Horizontal position of this Intersection
     * @param y Vertical position of this Intersection
     */
    public Intersection(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Returns the horizontal position of this Intersection
     * @return the horizontal position of this Intersection
     */
    public int getX(){
        return this.x;
    }

    /**
     * Returns the vertical position of this Intersection
     * @return the vertical position of this Intersection
     */
    public int getY(){
        return this.y;
    }

    /**
     * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
     * @return a coordinate-pair representation of this Intersection
     */
    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }

    /**
     * Returns true if the given Object is identical to this Intersection
     * @param o object to compare for equality
     * @return true if the given Object is an Intersection object which has the same x and y coordinates as this Intersection
     */
    public boolean equals(Object o){
        if(o instanceof Intersection){
            if(((Intersection) o).getX()==this.x && ((Intersection) o).getY()==this.y){
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a new Intersection instance which is one step directly above this Intersection. Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly above this Intersection
     */
    public Intersection goNorth(){
        return new Intersection(this.x, this.y+1);
    }

    /**
     * Creates a new Intersection instance which is one step directly below this Intersection. Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly below this Intersection
     */
    public Intersection goSouth(){
        return new Intersection(this.x, this.y-1);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the right of this Intersection object. Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly to the right of this Intersection
     */
    public Intersection goEast(){
        return new Intersection(this.x+1, this.y);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the left of this Intersection. Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly to the left of this Intersection
     */
    public Intersection goWest(){
        return new Intersection(this.x-1, this.y);
    }
    
}
