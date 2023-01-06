/*
    Q4. Write a program in Java to create class Triangle with the data members base, height, area
    and color. The members base, height, area are of type double and color is of type string.
    Write getter and setter methods for base, height and color, and write method to
    compute_area (). Create two object of class Triangle, compute their area, and compare their
    area and color. If area and color both are same for the objects then display "Matching
    Triangles" otherwise display "Non matching Triangles".
*/
package testing;
import java.util.Scanner;

/**
 *
 * @author amritpal
 */

class Triangle{
    private int base, height;
    private String color;
    
    Triangle(){
	base = 0;
	height = 0;
	color = "";
    }
    
    Triangle(int b, int h, String c){
	base = b;
	height = h;
	color = c;
    }
    
    void setter(int b, int h, String c){
	base = b;
	height = h;
	color = c;
    }
    
    int getBase(){
	return base;
    }
    
    int getHeight(){
	return height;
    }
    
    String getColor(){
	return color;
    }
    
    int area(){
	return (base*height)/2;
    }
    
    boolean isColorSame(Triangle obj){
	return this.getColor().equalsIgnoreCase(obj.getColor());
    }
}

public class TrianglesCheck {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Triangle t1 = new Triangle(12, 6, "red");
        Triangle t2 = new Triangle();
	int comm = 1;
	while(comm != 0){
	    int b,h;
	    String c;
	    System.out.println("Enter base and Height for 2nd Triangle: ");
	    b= reader.nextInt();
	    h= reader.nextInt();
	    System.out.println("Enter Colour for 2nd Triangle: ");
	    c = reader.next();
	    t2.setter(b, h, c);

	    if(t1.area() == t2.area()){
		if(t1.isColorSame(t2)){
		    System.out.println("Yes, Both Triangles are Matching.");	
		} else{
		    System.out.println("Both Triangles Area is same but not Colour");		
		}
	    } else{
		if(t1.isColorSame(t2)){
		    System.out.println("Both Triangles Colour is same but not Area");
		}
		System.out.println("No, Both Triangles are't matching");
	    }
	    System.out.print("Enter command: ");
	    comm = reader.nextInt();
	}
	
        reader.close();
    }
}
