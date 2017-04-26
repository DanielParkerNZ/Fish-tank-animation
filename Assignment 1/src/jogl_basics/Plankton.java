package jogl_basics;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Plankton {
		
	Random ran = new Random();
	ArrayList<Point> points = new ArrayList<Point>();
	
	public Plankton(GLAutoDrawable gld) {
	}
	
	public void draw(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glPointSize(4); 
		gl.glBegin(GL2.GL_POINTS);
		
		for(int i=0; i<points.size(); i++) {
			gl.glColor3d(1,1,1);
			Point pt = points.get(i);
			gl.glVertex2d(pt.x, pt.y);
		}
		
		gl.glEnd();
		
	}
	
	public void create() {
		
		for(int i=0; i<100; i++) {
			double x = ran.nextDouble()*2-1;
			double y = ran.nextDouble()*2-1;
			Point pt = new Point();
		    pt.x = x;
		    if(y >= 0.75) {
		    	y -= 0.25;
		    }
		    if(y <= 0.2) {
		    	y += 0.2;
		    }
		    pt.y = y;
		    points.add(pt);
		}
	}
	
}
