/**********************************************************
 * EECS2011: Fundamentals of Data Structures,  Winter 2019
 * Assignment 1: Polygon Hierarchy
 * Section:  M  or  Z   ?
 * Student Name:   ?
 * Student eecs account:  ?
 * Student ID number:  ? 
 **********************************************************/
package A1;

import java.awt.geom.Point2D;

/**
 * The class ConvexPolygon extends SimplePolygon.
 * 
 * TODO:_______ Add more Javadoc comments here. ______ ???
 * 
 * @author Andy Mirzaian
 */
public class ConvexPolygon extends SimplePolygon {
	// TODO: add your code here
	
	public boolean isConvex() throws NonSimplePolygonException {
		double result2=0;
		double result = 0;
		if (isSimple()) {
	        
	        java.awt.geom.Point2D.Double a = vertices[0];
	        vertices[0]=new Point2D.Double(0.0, 0.0);
	        for (int i = 1;i<this.getSize()-1;i++) {
	        result += SimplePolygon.delta(vertices[0], vertices[i], vertices[i+1]);
	        }
	        result += SimplePolygon.delta(vertices[0], vertices[n-1], a);
	        result = 0.5*Math.abs(result);
	        }
	        else {
	            throw new NonSimplePolygonException("NonSimplepolygonException"); // TODO: replace this line with a try-catch code
	        }
		if (isSimple()) {
	        vertices[0]=new Point2D.Double(0.0, 0.0);
	        for (int i = 1;i<this.getSize()-1;i++) {
	        result2 += SimplePolygon.delta(vertices[0], vertices[i], vertices[i+1]);
	        }
	       
	     
	    }
		if (result < result2) return false;
		else return  true;
	    }
	

}