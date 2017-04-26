package jogl_basics;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class TimeMask {

	public TimeMask(GLAutoDrawable gld) {
		
	}
	
	public void draw(GLAutoDrawable gld, double alpha) {
		GL2 gl = gld.getGL().getGL2();
		gl.glColor4d(0,0,0,alpha);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glBegin(GL2.GL_POLYGON);
			
			gl.glVertex2d(-1, -1); 
			gl.glVertex2d(-1, +1);  
			gl.glVertex2d(+1, +1);  
			gl.glVertex2d(+1, -1); 
			
		gl.glEnd();
		
		gl.glDisable(GL2.GL_BLEND);
		
	}
	
}
