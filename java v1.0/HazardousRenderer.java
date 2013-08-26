import java.util.ArrayList;
import processing.core.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;

import javax.swing.*;
import javax.imageio.*;
import java.util.*;

@SuppressWarnings("unused")
public class HazardousRenderer extends PApplet{
	
	private ArrayList<Asteroid> m_asteroidsFull;
	private ArrayList<Asteroid> m_asteroidsVisible;	
	
	private int currentCenterX;
	private int currentCenterY;
	private double currentAU;
	
	public void setup() {
		
		m_asteroidsFull = new ArrayList<Asteroid>();
		m_asteroidsVisible = new ArrayList<Asteroid>();
		
		 // Set global position state
        currentCenterX = Constants.BOX_CENTER_X;
        currentCenterY = Constants.BOX_CENTER_Y;
        currentAU = Constants.AU;
        
		// Get the data
		Parser parser = new Parser(new File("data.csv"));
		
		try {
			parser.readFile();
		} catch (Exception e) {
			System.err.println("Something bad happened reading the file...");
		} //try-catch

		parser.parseLines();
		m_asteroidsFull = parser.getAsteroids();

		// Copy full list into visible list
		for (Asteroid ast : m_asteroidsFull) {
			m_asteroidsVisible.add(ast);
		} //for
		
		//size of window
        size(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
	    
        // black background
        background(0);
        
        // draw from ellipse centers
	    ellipseMode(RADIUS);
	    
	    ortho((float)Constants.BOX_X, (float)Constants.BOX_WIDTH,(float)Constants.BOX_Y, (float)Constants.BOX_HEIGHT);
	  }
	
	public void draw() {
		
	    //stroke(255);
	    
	    //createShape(RECT,mouseX,mouseY,100,50);
	    
	 // Redraw images based on updated filter / color / whatever
        drawSpaceBackground();

		drawAsteroidOverlay();
        drawPlanetOverlay();
	    
//	    if (mousePressed) {
//	      line(mouseX,mouseY,pmouseX,pmouseY);
//	    }
	}
	
	public void drawSpaceBackground() {
		rect(Constants.BOX_X, Constants.BOX_Y, Constants.BOX_WIDTH, Constants.BOX_HEIGHT);
		//g.fillRect(Constants.BOX_X, Constants.BOX_Y, Constants.BOX_WIDTH, Constants.BOX_HEIGHT);
	} //drawSpaceBackground

	public void drawAsteroidOverlay() {
		
		//g.setColor(Color.BLUE);
		
		stroke(0,0,255);
		noFill();
		
		for (Asteroid current : m_asteroidsVisible) {
			
			double semimajorAxis = current.getSemimajorAxis() * 2 * currentAU;
			double semiminorAxis = semimajorAxis * Math.sqrt(1 - Math.pow(current.getEccentricity(), 2));
			double perihelion = current.getPerihelionDistance() * 2 * currentAU;

			//System.out.println(semimajorAxis);
			//System.out.println(semiminorAxis);
			//System.out.println(perihelion);
			//System.out.println("");

			if (semimajorAxis != -1) {

				ellipse(currentCenterX - ((int)semimajorAxis/2), currentCenterY - ((int)semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);
				ellipse((int)(currentCenterX - (semimajorAxis/2)), currentCenterY - ((int)semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);

//				if (ddlColor.getSelectedIndex() == 0) {
//					g.setColor(Color.BLUE);
//
//				} else if (ddlColor.getSelectedIndex() == 1) {
//					if (current.getOrbitalClassification().equals("APO")) {			// Apollo (crosses Earth orbit, semimajor axis > 1AU)
//						g.setColor(Color.BLUE);
//					} else if (current.getOrbitalClassification().equals("AMO")) {	// Amor (outside Earth orbit, never crosses)
//						g.setColor(Color.GREEN);
//					} else if (current.getOrbitalClassification().equals("ATE")) {	// Aten (crosses Earth orbit, semimajor axis < 1AU)
//						g.setColor(Color.YELLOW);
//					} else if (current.getOrbitalClassification().equals("IEO")) {  // Inner Earth Orbit
//						g.setColor(Color.ORANGE);
//					} else {
//						// Shouldn't happen
//						g.setColor(Color.RED);
//					} //if-else
//
//				} //if

				//AffineTransform old = g.getTransform();
				
				pushMatrix();
				
				translate(currentCenterX, currentCenterY);
				rotate( (float)Math.toRadians(current.getLongitudeOfAscendingNode()) );

				ellipse((int)(-perihelion/2), (int)(-semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);
				
				popMatrix();
				
				//g.setTransform(old);

		 	} //if
		} //for
		
		stroke(0,0,0);
		//g.setColor(Color.BLACK);
	} //drawAsteroidOverlay
	
	public void drawPlanetOverlay() {
		
		// Draw sun
		//g.setColor(Color.YELLOW);

		double sunSize = Constants.SUN_SIZE * currentAU;
		if (sunSize < 10) {
			sunSize = 10;
		} //if
		
		// yellow
		fill(255,255,0);
		stroke(255,255,0);
		
		ellipse((int)(currentCenterX - (sunSize/2)), (int)(currentCenterY - (sunSize/2)), (int)sunSize, (int)sunSize);
		
		// black
		noFill();
		stroke(0,0,0);
		
		// Draw planet orbits
		stroke(190,190,190);
		//g.setColor(Color.LIGHT_GRAY);
		
		//AffineTransform old = g.getTransform();

		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.MERCURY_LONGITUDE_NODE));
		ellipse((int)(-Constants.MERCURY_PERIHELION*currentAU), (int)(-Constants.MERCURY_SEMIMINOR_AXIS*currentAU), (int)(Constants.MERCURY_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MERCURY_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();

		//g.setTransform(old);

		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.VENUS_LONGITUDE_NODE));
		ellipse((int)(-Constants.VENUS_PERIHELION*currentAU), (int)(-Constants.VENUS_SEMIMINOR_AXIS*currentAU), (int)(Constants.VENUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.VENUS_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();

		//g.setTransform(old);
		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.EARTH_LONGITUDE_NODE));
		ellipse((int)(-Constants.EARTH_PERIHELION*currentAU), (int)(-Constants.EARTH_SEMIMINOR_AXIS*currentAU), (int)(Constants.EARTH_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.EARTH_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);

		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.MARS_LONGITUDE_NODE));
		ellipse((int)(-Constants.MARS_PERIHELION*currentAU), (int)(-Constants.MARS_SEMIMINOR_AXIS*currentAU), (int)(Constants.MARS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MARS_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);
		
		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.JUPITER_LONGITUDE_NODE));
		ellipse((int)(-Constants.JUPITER_PERIHELION*currentAU), (int)(-Constants.JUPITER_SEMIMINOR_AXIS*currentAU), (int)(Constants.JUPITER_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.JUPITER_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);
		
		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.SATURN_LONGITUDE_NODE));
		ellipse((int)(-Constants.SATURN_PERIHELION*currentAU), (int)(-Constants.SATURN_SEMIMINOR_AXIS*currentAU), (int)(Constants.SATURN_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.SATURN_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);

		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.URANUS_LONGITUDE_NODE));
		ellipse((int)(-Constants.URANUS_PERIHELION*currentAU), (int)(-Constants.URANUS_SEMIMINOR_AXIS*currentAU), (int)(Constants.URANUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.URANUS_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);

		pushMatrix();
		translate(currentCenterX, currentCenterY);
		rotate((float)Math.toRadians(Constants.NEPTUNE_LONGITUDE_NODE));
		ellipse((int)(-Constants.NEPTUNE_PERIHELION*currentAU), (int)(-Constants.NEPTUNE_SEMIMINOR_AXIS*currentAU), (int)(Constants.NEPTUNE_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.NEPTUNE_SEMIMINOR_AXIS*2*currentAU));
		popMatrix();
		
		//g.setTransform(old);

/*
		g.drawOval((int)(currentCenterX - Constants.MERCURY_PERIHELION*currentAU), (int)(currentCenterY - (Constants.MERCURY_SEMIMINOR_AXIS*currentAU)), (int)(Constants.MERCURY_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MERCURY_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.VENUS_PERIHELION*currentAU), (int)(currentCenterY - (Constants.VENUS_SEMIMINOR_AXIS*currentAU)), (int)(Constants.VENUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.VENUS_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.EARTH_PERIHELION*currentAU), (int)(currentCenterY - (Constants.EARTH_SEMIMINOR_AXIS*currentAU)), (int)(Constants.EARTH_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.EARTH_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.MARS_PERIHELION*currentAU), (int)(currentCenterY - (Constants.MARS_SEMIMINOR_AXIS*currentAU)), (int)(Constants.MARS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MARS_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.JUPITER_PERIHELION*currentAU), (int)(currentCenterY - (Constants.JUPITER_SEMIMINOR_AXIS*currentAU)), (int)(Constants.JUPITER_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.JUPITER_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.SATURN_PERIHELION*currentAU), (int)(currentCenterY - (Constants.SATURN_SEMIMINOR_AXIS*currentAU)), (int)(Constants.SATURN_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.SATURN_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.URANUS_PERIHELION*currentAU), (int)(currentCenterY - (Constants.URANUS_SEMIMINOR_AXIS*currentAU)), (int)(Constants.URANUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.URANUS_SEMIMINOR_AXIS*2*currentAU));
		g.drawOval((int)(currentCenterX - Constants.NEPTUNE_PERIHELION*currentAU), (int)(currentCenterY - (Constants.NEPTUNE_SEMIMINOR_AXIS*currentAU)), (int)(Constants.NEPTUNE_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.NEPTUNE_SEMIMINOR_AXIS*2*currentAU));
*/
		stroke(0,0,0);
		//g.setColor(Color.BLACK);
	} //drawPlanetOverlay
	
	
}
