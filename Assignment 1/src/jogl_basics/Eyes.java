package jogl_basics;

import com.jogamp.opengl.GLAutoDrawable;

public class Eyes {

	Circle rightIris, rightPupil, leftIris, leftPupil;
	
	public Eyes(GLAutoDrawable gld) {
		
	}
	
	public void draw(GLAutoDrawable gld) {
		
		rightIris = new Circle(gld);
		rightIris.draw(gld, 1, 1, 1, 1, 1, 1, 0.1, 0, 0.02, 0.08);
		
		rightPupil = new Circle(gld);
		rightPupil.draw(gld, 0, 0, 0, 0, 0, 0, 0.1, 0, 0.01, 0.04);
		
		leftIris = new Circle(gld);
		leftIris.draw(gld, 1, 1, 1, 1, 1, 1, -0.1, 0, 0.02, 0.08);
		
		leftPupil = new Circle(gld);
		leftPupil.draw(gld, 0, 0, 0, 0, 0, 0, -0.1, 0, 0.01, 0.04);
		
	}
	
}
