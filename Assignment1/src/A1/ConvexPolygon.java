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
	 public ConvexPolygon()
	 {
	      super.getNewPoly();
	 }
	// TODO: add your code here
	@Override
	public double area() throws NonSimplePolygonException {
		double result =0;
		if (isSimple()) {

			Point2D.Double a = new Point2D.Double(0, 0);

			for (int i = 0; i < n; i++) {
			
					result += SimplePolygon.delta(a, vertices[i], vertices[i + 1]);
				}

		}
			

		 else {
			throw new NonSimplePolygonException("NonSimple");
		}
		 result = 0.5 * Math.abs(result);
		return result;

	
		
	}
	

	public boolean isConvex() throws NonSimplePolygonException {
		if (super.area() < this.area())
		return false;
		else return true;
	}

}