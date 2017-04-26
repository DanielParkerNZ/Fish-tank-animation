package jogl_basics;

import java.util.ArrayList;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Wave {

	ArrayList<Point> wave = new ArrayList<Point>();
	ArrayList<Point> ghost = new ArrayList<Point>();
	Random ran = new Random();
	double dy = 0.0002;
	
	public Wave(GLAutoDrawable gld) {
		
	}
	
	public void draw(GLAutoDrawable gld) {
		GL2 gl = gld.getGL().getGL2();
		
		gl.glColor4d(0.4549, 0.811764, 0.92941, 0.2);
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2d(-1.0, -0.8);
			gl.glVertex2d(wave.get(0).x, wave.get(0).y);
			gl.glVertex2d(wave.get(1).x, wave.get(1).y);
			gl.glVertex2d(-0.75, -0.8);
			gl.glVertex2d(-0.75, -0.8);
			gl.glVertex2d(wave.get(1).x, wave.get(1).y);
			gl.glVertex2d(wave.get(2).x, wave.get(2).y);
			gl.glVertex2d(-0.5, -0.8);
			gl.glVertex2d(-0.5, -0.8);
			gl.glVertex2d(wave.get(2).x, wave.get(2).y);
			gl.glVertex2d(wave.get(3).x, wave.get(3).y);
			gl.glVertex2d(-0.25, -0.8);
			gl.glVertex2d(-0.25, -0.8);
			gl.glVertex2d(wave.get(3).x, wave.get(3).y);
			gl.glVertex2d(wave.get(4).x, wave.get(4).y);
			gl.glVertex2d(0.0, -0.8);
			gl.glVertex2d(0.0, -0.8);
			gl.glVertex2d(wave.get(4).x, wave.get(4).y);
			gl.glVertex2d(wave.get(5).x, wave.get(5).y);
			gl.glVertex2d(0.25, -0.8);
			gl.glVertex2d(0.25, -0.8);
			gl.glVertex2d(wave.get(5).x, wave.get(5).y);
			gl.glVertex2d(wave.get(6).x, wave.get(6).y);
			gl.glVertex2d(0.5, -0.8);
			gl.glVertex2d(0.5, -0.8);
			gl.glVertex2d(wave.get(6).x, wave.get(6).y);
			gl.glVertex2d(wave.get(7).x, wave.get(7).y);
			gl.glVertex2d(0.75, -0.8);
			gl.glVertex2d(0.75, -0.8);
			gl.glVertex2d(wave.get(7).x, wave.get(7).y);
			gl.glVertex2d(wave.get(8).x, wave.get(8).y);
			gl.glVertex2d(1.0, -0.8);
		gl.glEnd();
		
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
		gl.glColor4d(0.4549, 0.811764, 0.92941, 0.0);
		gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glVertex2d(ghost.get(0).x, ghost.get(0).y);
			gl.glVertex2d(ghost.get(1).x, ghost.get(1).y);
			gl.glVertex2d(ghost.get(2).x, ghost.get(2).y);
			gl.glVertex2d(ghost.get(3).x, ghost.get(3).y);
			gl.glVertex2d(ghost.get(4).x, ghost.get(4).y);
			gl.glVertex2d(ghost.get(5).x, ghost.get(5).y);
			gl.glVertex2d(ghost.get(6).x, ghost.get(6).y);
			gl.glVertex2d(ghost.get(7).x, ghost.get(7).y);
			gl.glVertex2d(ghost.get(8).x, ghost.get(8).y);
		gl.glEnd();
		gl.glDisable(GL2.GL_BLEND);
		
		for(int i=0; i<9; i++) {
			double x = wave.get(i).x;
			double y = wave.get(i).y;
			Point pt = new Point();
			if(y<=ghost.get(i).y) {
				y+=dy;
				if(y>=ghost.get(i).y) {
					Point pt1 = new Point();
					pt1.x = ghost.get(i).x;
					pt1.y = 0.75+ran.nextDouble()/20;
					ghost.set(i, pt1);
				}
			}
			if(y>=ghost.get(i).y) {
				y-=dy;
				if(y<=ghost.get(i).y) {
					Point pt1 = new Point();
					pt1.x = ghost.get(i).x;
					pt1.y = 0.75+ran.nextDouble()/20;
					ghost.set(i, pt1);
				}
			}
			pt.x = x;
			pt.y = y;
			wave.set(i, pt);
		}
		
	}
	
	public void create() {
		
		double x = -1.0;
		for(int i=0; i<9; i++) {
			Point pt = new Point();
			double yr = 0.75+ran.nextDouble()/20;
			pt.x = x;
			pt.y = yr;
			wave.add(pt);
			x+=0.25;
		}

		double x1 = -1.0;
		for(int i=0; i<9; i++) {
			Point pt = new Point();
			double yr = 0.75+ran.nextDouble()/20;
			pt.x = x1;
			pt.y = yr;
			ghost.add(pt);
			x1+=0.25;
		}

	}
	
}
