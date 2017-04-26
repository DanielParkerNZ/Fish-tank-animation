package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Fish {
	
	double posX, posY;
	float c1, c2, c3;
	Circle body, rightIris, rightPupil, leftIris, leftPupil, mouth;
	Triangle topFin, rightFin, leftFin;
	
	public Fish(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();	
		
		body = new Circle(gld);
		body.draw(gld, 0.979, 0.744, 0.458, 0.949, 0.588, 0.149, 0, 0, 0.1, 0.3);
		
		rightIris = new Circle(gld);
		rightIris.draw(gld, 1, 1, 1, 1, 1, 1, 0.1, 0, 0.02, 0.08);
		
		rightPupil = new Circle(gld);
		rightPupil.draw(gld, 0, 0, 0, 0, 0, 0, 0.1, 0, 0.01, 0.04);
		
		leftIris = new Circle(gld);
		leftIris.draw(gld, 1, 1, 1, 1, 1, 1, -0.1, 0, 0.02, 0.08);
		
		leftPupil = new Circle(gld);
		leftPupil.draw(gld, 0, 0, 0, 0, 0, 0, -0.1, 0, 0.01, 0.04);
		
		mouth = new Circle(gld);
		mouth.draw(gld, 0, 0, 0, 0, 0, 0, 0, -0.15, 0.08, 0.01);
		
		topFin = new Triangle(gld);
		topFin.draw(gld, 0.929, 0.694, 0.408, 0, 0.3, 0.05, 0.35, -0.05, 0.35);
		
		rightFin = new Triangle(gld);
		rightFin.draw(gld, 0.929, 0.694, 0.40, 0.09, -0.1, 0.175, -0.14, 0.175, -0.06);

		leftFin = new Triangle(gld);
		rightFin.draw(gld, 0.929, 0.694, 0.40, -0.09, -0.1, -0.175, -0.14, -0.175, -0.06);

		gl.glFlush();
	}
	
}