package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Fins {

	public Fins(GLAutoDrawable gld) {
		
	}
	
	public void draw(GLAutoDrawable gld, double deg1, double deg2) {
		GL2 gl = gld.getGL().getGL2();
		gl.glBegin(GL2.GL_TRIANGLES);
		
			gl.glColor4f(0.4549f, 0.811764f, 0.92941f, 0.2f); 
			gl.glVertex2d(0.13+0.002*Math.sin(Math.toRadians(deg1)), -0.1+0.012*Math.cos(Math.toRadians(deg1)));
			gl.glVertex2d(0.175, -0.14);
			gl.glVertex2d(0.175, -0.06);
	
		gl.glEnd();
		gl.glBegin(GL2.GL_TRIANGLES);
		
			gl.glColor4f(0.4549f, 0.811764f, 0.92941f, 0.2f); 
			gl.glVertex2d(-0.13+0.002*Math.sin(Math.toRadians(deg2)), -0.1+0.012*Math.cos(Math.toRadians(deg2)));
			gl.glVertex2d(-0.175, -0.14);
			gl.glVertex2d(-0.175, -0.06);
	
		gl.glEnd();
		
	}
	
}
