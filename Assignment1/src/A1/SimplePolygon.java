/* EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section:  M  or  Z ?
 * Student Name:   ?
 * Student eecs account:  ?
 * Student ID number:  ?
 **********************************************************/
package A1;

import java.awt.geom.Point2D;
import java.util.Scanner;

/**
 * The class SimplePolygon implements the Polygon interface.
 *
 * It is intended to be further extended by ConvexPolygon.
 
 * @author Andy Mirzaian
 *////
public class SimplePolygon implements Polygon {

    /********* protected fields ************************/

    protected int n; // number of vertices of the polygon
    protected Point2D.Double[] vertices; // vertices[0..n-1] around the polygon boundary

    /********* protected constructors ******************/

    /**
     * constructor used in the static factory method getNewPoly()
     *
     * @param size
     *            number of edges (also vertices) of the polygon
     */
    protected SimplePolygon(int size) {
        n = size;
        // TODO: place the rest of your code here
        vertices = new Point2D.Double[n];
    }

    /** default no-parameter constructor */
    protected SimplePolygon() {
        // TODO: place your code here
        n = 3;
        vertices = new Point2D.Double[n];
        double x = 1.0;
        double y = 1.0;
        double x1 = 1.5;
        double y1 = 1.5;
        double x2 = 2.0;
        double y2 = 1.0;
        SimplePolygon p = new SimplePolygon(3);
        p.vertices[0] = new Point2D.Double(x, y);
        p.vertices[1] = new Point2D.Double(x1, y1);
        p.vertices[2] = new Point2D.Double(x2, y2);
    }

    /********* public getters & toString ***************/

    /**
     * static factory method constructs and returns an unverified simple-polygon, initialised
     * according to user provided input data. Runs in O(n) time.
     *
     * @return an unverified simple-polygon instance
     */
    public static SimplePolygon getNewPoly() {
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        String[] aa = b.split(" ");
        int size = Integer.parseInt(aa[0]);
        
         // TODO: replace this line with your code
        SimplePolygon p = new SimplePolygon(size);
        p.vertices = new Point2D.Double[size];
        // TODO: populate p.vertices[0..size-1] from input
        for (int i = 1; i <= size; i++) {
            p.vertices[i-1] = new Point2D.Double(Double.parseDouble(aa[2*(i-1)+1]), Double.parseDouble(aa[2*(i-1)+2]));
        }
        return p;
    }

    /**
     *
     * @return n, the number of edges (equivalently, vertices) of the polygon.
     */
    public int getSize() {
        return n;
    }

    /**
     *
     * @param i
     *            index of the vertex.
     * @return the i-th vertex of the polygon.
     * @throws IndexOutOfBoundsException
     *             if {@code i < 0 || i >= n }.
     */
    public Point2D.Double getVertex(int i) throws IndexOutOfBoundsException {
        try {
            return vertices[i];
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("IndexOutOfBoulllndsException catch");
        }
        return null; // TODO: replace this line with a try-catch code
    }

    /**
     * @return a String representation of the polygon in O(n) time.
     */
    @Override
    public String toString() {
        String a = "";
        for (int i = 0 ;i < n ; i++){
            a = vertices[i] + "," ;
        }
        return a; // TODO: replace this line with your code
    }

    /************** utilities *********************/

    /**
     *
     * @param a
     * @param b
     * @param c
     *            three input points.
     * @return twice the signed area of the oriented triangle (a,b,c). Runs in O(1) time.
     */
    public static double delta(Point2D.Double a, Point2D.Double b,
            Point2D.Double c) {
        double deltaa = 0;
        deltaa = a.getX()*(b.getY()-c.getY())-b.getX()*(a.getY()-c.getY())+c.getX()*(a.getY()-b.getY());
        System.out.println(a.getX());
        return deltaa; // TODO: replace this line with your code
    }

    /**
     * @param a
     * @param b
     *            end points of line-segment (a,b).
     * @param c
     * @param d
     *            end points of line-segment (c,d).
     * @return true if closed line-segments (a,b) and (c,d) are disjoint. Runs in O(1) time.
     */
    public static boolean disjointSegments(Point2D.Double a, Point2D.Double b,
            Point2D.Double c, Point2D.Double d) {
    	double max1,max2,max3,max4;
    	double min1,min2,min3,min4;
       if (a.x > b.x) {
    	   max1 = a.x;
    	   min1 = b.x;
       }
       else {
    	   max1 = b.x;
    	   min1 = a.x;
       }
       if (c.x > d.x) {
    	   max2 = c.x;
    	   min2 = d.x;
       }
       else {
    	   max2 = d.x;
    	   min2 = c.x;
       }
       if (a.y > b.y) {
    	   max3 = a.y;
    	   min3 = b.y;
       }
       else {
    	   max3 = b.y;
    	   min3 = a.y;
       }
       if (c.y > d.y) {
    	   max4 = c.y;
    	   min4 = d.y;
       }
       else {
    	   max4 = d.y;
    	   min4 = c.y;
       }
       if (max1 < min2) return true;
       if (max3 < min4) return true;
       if (delta(c,b,a)*delta(b,d,a) <0) return true;
       if (delta(a,d,c)*delta(d,b,c)<0) return true;
       
       	
                return false; // TODO: replace this line with your code
    }

    /**
     * @param i
     * @param j
     *            indices of two edges of the polygon.
     * @return true if the i-th and j-th edges of the polygon are disjoint. Runs in O(1) time.
     * @throws IndexOutOfBoundsException
     *             if i or j are outside the index range [0..n-1].
     */
    public boolean disjointEdges(int i, int j) throws IndexOutOfBoundsException {
        try {
            if (j - i > 1 && j - i < n-1 ) {
                return true;
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Catch Exception");
        }
        return false; // TODO: replace this line with a try-catch code
    }

    /**
     * This method verifies whether the claimed "simple-polygon" is indeed simple.
     *
     * @return true if the polygon is simple. Runs in O(n^2) time.
     */
    public boolean isSimple() {
        boolean result = true;
        for (int i = 0; i < this.getSize()-1;i++) {
            for ( int j = i+2;j < this.getSize()-1;j++) {
                if (this.disjointEdges(i, j) == false ) {
                    result = false;
                }
            }
        }
        return result; // TODO: replace this line with your code
    }

    /************ perimeter & area ***************/

    /**
     *
     * @return the sum of the edge lengths of the polygon. Runs in O(n) time.
     */
    public double perimeter() {
    	double distance = 0;
    	/*for (int i=0; i < n-1;i++) {
    		distance += vertices[i].distance(vertices[i+1]);
    	}*/
    	distance += vertices[0].distance(vertices[n-1]);
        return distance; // TODO: replace this line with your code
    }

    /**
     *
     * @return area of the polygon interior. Runs in O(n) time not counting the simplicity test.
     * @throws NonSimplePolygonException
     *             if the polygon is non-simple.
     */
    public double area() throws NonSimplePolygonException {
        if (isSimple()) {
        double result = 0;
        java.awt.geom.Point2D.Double a = vertices[0];
        vertices[0]=new Point2D.Double(0.0, 0.0);
        for (int i = 1;i<this.getSize()-1;i++) {
        result += SimplePolygon.delta(vertices[0], vertices[i], vertices[i+1]);
        }
        result += SimplePolygon.delta(vertices[0], vertices[n-1], a);
        result = 0.5*Math.abs(result);
        return result;
        }
        else {
            throw new NonSimplePolygonException("NonSimplepolygonException"); // TODO: replace this line with a try-catch code
        }
    }

}
        
