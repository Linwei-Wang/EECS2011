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
import java.util.Scanner;

/**
 * The class ConvexPolygon extends SimplePolygon.
 * 
 * TODO:_______ Add more Javadoc comments here. ______ ???
 * 
 * @author Andy Mirzaian
 */
public class ConvexPolygon extends SimplePolygon {
	protected ConvexPolygon(int size) {
		n = size;
		// TODO: place the rest of your code here
		vertices = new Point2D.Double[n];
	}
	public static ConvexPolygon getNewPoly() {

		Scanner a = new Scanner(System.in);
		String b = a.nextLine();
		String[] aa = b.split(" ");
		int size = Integer.parseInt(aa[0]);

		// TODO: replace this line with your code
		ConvexPolygon p = new ConvexPolygon(size);
		p.vertices = new Point2D.Double[size];
		// TODO: populate p.vertices[0..size-1] from input
		for (int i = 1; i <= size; i++) {
			p.vertices[i - 1] = new Point2D.Double(Double.parseDouble(aa[2 * (i - 1) + 1]),
					Double.parseDouble(aa[2 * (i - 1) + 2]));
		}
		// System.out.println(p.vertices[0]);
		return p;
	}
	// TODO: add your code here
	
	public boolean isConvex() throws NonSimplePolygonException {
		double result1 =0;
		double result2 = 0;
		boolean aa = true;
		if (isSimple()) {

			//Point2D.Double a = new Point2D.Double(0, 0);

			for (int i = 0; i < n-2; i++) {
			
					result1 = ConvexPolygon.delta(vertices[i], vertices[i+1], vertices[i + 2]);
					result2 = ConvexPolygon.delta(vertices[n-2], vertices[n-1], vertices[0]);
					if (result1 < 0) aa = false;
					if (result2 < 0) aa = false;
					//else aa = true;
				}
			
		}
			

		 else {
			throw new NonSimplePolygonException("NonSimple");
		}
	
		return aa;

	
		
	}
	

	/*public boolean isConvex() throws NonSimplePolygonException {
		if (super.area() < this.area1())
		return false;
		else return true;
	}*/

}