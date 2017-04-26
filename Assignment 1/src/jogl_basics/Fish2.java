package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Fish2 {
	
	Circle body, eye;
	Triangle topFin, rearFin;

	public Fish2(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld, double dx, double dy) {
		GL2 gl = gld.getGL().getGL2();
		
		rearFin = new Triangle(gld);
		rearFin.draw(gld, 0.078, 0.96, 0.502, 1.5+dx, 0.1, 1.6+dx, 0.2, 1.6+dx, 0.0);
		
		topFin = new Triangle(gld);
		topFin.draw(gld, 0.078, 0.96, 0.502, 1.4+dx, 0.18, 1.4+dx, 0.25, 1.3+dx, 0.18);
		
		body = new Circle(gld);
		body.draw(gld, 0.078, 0.96, 0.502, 0.078, 0.96, 0.502, 1.35+dx, 0.1, 0.2, 0.1);
		
		eye = new Circle(gld);
		eye.draw(gld, 0, 0, 0, 0, 0, 0, 1.25+dx, 0.15, 0.02, 0.02);
		
		gl.glBegin(GL2.GL_LINES);
			gl.glVertex2d(1.15+dx, 0.1);
			gl.glVertex2d(1.225+dx, 0.1);
		gl.glEnd();
		
		gl.glBegin(GL2.GL_LINES);
			gl.glVertex2d(1.4+dx, 0.1);
			gl.glVertex2d(1.425+dx, 0.04+dy);
			gl.glVertex2d(1.425+dx, 0.04+dy);
			gl.glVertex2d(1.3+dx, 0.1);
		gl.glEnd();
		
	}
	
}
