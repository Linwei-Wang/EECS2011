/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section:  M  or  Z ?
 * Student Name:   ?
 * Student eecs account:  ?
 * Student ID number:  ? 
 **********************************************************/
package A1;

/**
 * PolygonTester should enable a thorough testing of the polygon hierarchy.
 * 
 * It should provide an easy to read input-output recording of the test cases.
 * 
 * The student should also submit these recorded test results in TestIO.txt file as part
 * of Assignment1.
 * 
 * @author Andy Mirzaian
 */
public class PolygonTester {

	// TODO: place additional test-helper methods here if you like
	public static void main(String[] args) throws NonSimplePolygonException {
		// TODO: place your tester code here
	       //ConvexPolygon a =  new ConvexPolygon();
	      ConvexPolygon a = ConvexPolygon.getNewPoly();
	  	       String s = a.toString();
	  	       System.out.println("Coordinates is: " + s);
	       System.out.println("The size is: " + a.getSize());
	       System.out.println("The second vertex is: " + a.getVertex(1));
	       System.out.println("Disjoint Edges between the first and second: " + a.disjointEdges(0, 2));
	       System.out.println("Is simple? " + a.isSimple());
	       System.out.println("The perimeter is: " + a.perimeter());
	       System.out.println("Is convex? " + ((a.isConvex())));
	       System.out.println("The area is: " + a.area());
	}

}