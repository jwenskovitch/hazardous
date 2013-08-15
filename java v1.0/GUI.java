import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.util.*;

public class GUI extends JPanel {

	private ArrayList<Asteroid> m_asteroidsFull;
	private ArrayList<Asteroid> m_asteroidsVisible;

    // Form controls and images
    private JComboBox ddlEcc, ddlInc, ddlMag, ddlPer, ddlAph, ddlOrb, ddlEar, ddlColor;
    private JButton btnUp, btnDown, btnLeft, btnRight, btnVarDesc;
    private int mapImage = 0, var1image = 0, var2image = 0, var3image = 0, errorimage = 0, year = 1993;
    private BufferedImage imgMainMap, imgDetailsView, imgBlank;
    private BufferedImage imgSmallHeatMaps[][][];
    private ActionListener listener = new changeListener();
    private Boolean chernoff = false;


	// Mouse info
	private int mouseX, mouseY;
	private int mouseXNew, mouseYNew;
	private int mouseXChanged, mouseYChanged;
	private boolean mouseDown;
	private int currentCenterX;
	private int currentCenterY;
	private double currentAU;


    public GUI() throws Exception {

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


        // Create ActionListener instance
        ActionListener listener = new changeListener();

        // Upper panel with main map view and heatmaps
        JPanel pnlUpper = new JPanel();
        pnlUpper.setLayout(new GridLayout(1, 4));

        // DropDownList panel
        JPanel pnlDDLs = new JPanel();
        pnlDDLs.setLayout(new GridLayout(9, 2, 0, 2));
        ddlEcc = new JComboBox(Constants.eccOptions);
        ddlInc = new JComboBox(Constants.incOptions);
        ddlMag = new JComboBox(Constants.magOptions);
        ddlPer = new JComboBox(Constants.perOptions);
        ddlAph = new JComboBox(Constants.aphOptions);
        ddlOrb = new JComboBox(Constants.orbOptions);
        ddlEar = new JComboBox(Constants.earOptions);
        ddlColor = new JComboBox(Constants.colorOptions);

        ddlEcc.setSelectedIndex(0);
        ddlInc.setSelectedIndex(0);
        ddlMag.setSelectedIndex(0);
        ddlPer.setSelectedIndex(0);
        ddlAph.setSelectedIndex(0);
        ddlOrb.setSelectedIndex(0);
        ddlEar.setSelectedIndex(0);
        ddlColor.setSelectedIndex(0);

        ddlEcc.addActionListener(listener);
        ddlInc.addActionListener(listener);
        ddlMag.addActionListener(listener);
        ddlPer.addActionListener(listener);
        ddlAph.addActionListener(listener);
        ddlOrb.addActionListener(listener);
        ddlEar.addActionListener(listener);
		ddlColor.addActionListener(listener);

        ddlEcc.setPreferredSize(new Dimension(175, 35));
        ddlInc.setPreferredSize(new Dimension(175, 35));
        ddlMag.setPreferredSize(new Dimension(175, 35));
        ddlPer.setPreferredSize(new Dimension(175, 35));
        ddlAph.setPreferredSize(new Dimension(175, 35));
        ddlOrb.setPreferredSize(new Dimension(175, 35));
        ddlEar.setPreferredSize(new Dimension(175, 35));
        ddlColor.setPreferredSize(new Dimension(175, 35));

        JLabel lblEcc = new JLabel("Eccentricity: ");
        JLabel lblInc = new JLabel("Inclination: ");
        JLabel lblMag = new JLabel("Abs. Magnitude: ");
        JLabel lblPer = new JLabel("Perihelion: ");
        JLabel lblAph = new JLabel("Aphelion: ");
        JLabel lblOrb = new JLabel("Orbital Period: ");
        JLabel lblEar = new JLabel("Min. Dist. Earth: ");
        JLabel lblColor = new JLabel("Color by: ");

        lblEcc.setHorizontalTextPosition(JLabel.RIGHT);
        lblInc.setHorizontalTextPosition(JLabel.RIGHT);
        lblMag.setHorizontalTextPosition(JLabel.RIGHT);
        lblPer.setHorizontalTextPosition(JLabel.RIGHT);
        lblAph.setHorizontalTextPosition(JLabel.RIGHT);
        lblOrb.setHorizontalTextPosition(JLabel.RIGHT);
        lblEar.setHorizontalTextPosition(JLabel.RIGHT);
        lblColor.setHorizontalTextPosition(JLabel.RIGHT);

        pnlDDLs.add(lblEcc);
        pnlDDLs.add(ddlEcc);
        pnlDDLs.add(lblInc);
        pnlDDLs.add(ddlInc);
        pnlDDLs.add(lblMag);
        pnlDDLs.add(ddlMag);
        pnlDDLs.add(lblPer);
        pnlDDLs.add(ddlPer);
        pnlDDLs.add(lblAph);
        pnlDDLs.add(ddlAph);
        pnlDDLs.add(lblOrb);
        pnlDDLs.add(ddlOrb);
        pnlDDLs.add(lblEar);
        pnlDDLs.add(ddlEar);
        pnlDDLs.add(new JLabel("  "));
        pnlDDLs.add(new JLabel("  "));
        pnlDDLs.add(lblColor);
		pnlDDLs.add(ddlColor);


        JPanel pnlOuterDDLs = new JPanel();
        pnlOuterDDLs.setLayout(new BorderLayout());
        pnlOuterDDLs.add(pnlDDLs, BorderLayout.CENTER);
        pnlOuterDDLs.add(new JLabel("   "), BorderLayout.EAST);

        // Main controls panel
        JPanel pnlControls = new JPanel();
        //pnlControls.setLayout(new GridLayout(2, 1));
        pnlControls.setLayout(new GridLayout(3, 1));
        pnlControls.setPreferredSize(new Dimension(200, 550));
        JLabel lblTitle = new JLabel("QUERY TOOLS:");
        lblTitle.setHorizontalTextPosition(JLabel.CENTER);
        //pnlControls.add(lblTitle);
        //pnlControls.add(pnlDDLs);
        pnlControls.add(pnlOuterDDLs);
        pnlControls.add(new JLabel("  "));

        // Lower panel with detail view and controls panel
        JPanel pnlLower = new JPanel();
        pnlLower.setLayout(new BorderLayout());

        //pnlLower.add(detailview)
        pnlLower.add(pnlControls, BorderLayout.EAST);
        //pnlLower.add(pnlControls);
        //pnlControls.setLocation(700, 250);

        // Add controls to panel
		this.setLayout(new BorderLayout());
		this.add(pnlUpper, BorderLayout.CENTER);
        this.add(pnlLower, BorderLayout.SOUTH);
        //this.add(new JLabel("  "), BorderLayout.EAST);

		// Handle mouse events
		addMouseListener(
			new MouseAdapter() {
				// Get mouse (x,y) location
				public void mousePressed(MouseEvent e)	{
					mouseX = e.getX();
					mouseY = e.getY();
				} //mousePressed

				public void mouseReleased(MouseEvent e) {


					mouseDown = false;
					mouseXChanged = 0;
					mouseYChanged = 0;

				} //mouseReleased





			} //MouseAdapter
		);

		addMouseMotionListener(
	    	new MouseMotionAdapter() {
        		public void mouseDragged(MouseEvent e) {

					// If our drag is in the zone of the main window, we'll need to handle that here
        			if ((mouseX >= Constants.BOX_X) && (mouseX <= (Constants.BOX_X + Constants.BOX_WIDTH)) && (mouseY >= Constants.BOX_Y) && (mouseY <= (Constants.BOX_Y + Constants.BOX_WIDTH))) {
          				mouseXNew = e.getX();
          				mouseYNew = e.getY();
          				mouseXChanged = mouseXNew - mouseX;
          				mouseYChanged = mouseYNew - mouseY;
          				mouseDown = true;
          				repaint();
          				mouseX = mouseXNew;
          				mouseY = mouseYNew;
         			} //if-else

        		} //mouseDragged
       		} //MouseMotionAdapter
      	);


		addMouseWheelListener(
			new MouseWheelListener() {

            	@Override
            	public void mouseWheelMoved(MouseWheelEvent e) {
					if (e.getWheelRotation() < 0) {
						currentAU *= 1.1;
					} else {
						currentAU /= 1.1;
					} //if-else

					repaint();

					//System.out.println(currentAU);

            	} //mouseWheelMoved

        	} //MouseWheelListener
        );


    } //ProjGUI

    // ActionListener
    private class changeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // On a filter update, empty visible asteroids ArrayList, then iterate over the full ArrayList to add in what needs included
            // On other updates.... well, update the display as appropriate



			// If it's a filter update
			if ((e.getSource() == ddlEcc) || (e.getSource() == ddlInc) || (e.getSource() == ddlMag) || (e.getSource() == ddlPer) || (e.getSource() == ddlAph)
					|| (e.getSource() == ddlOrb) || (e.getSource() == ddlEar)) {

				// Clear visible asteroids ArrayList
				m_asteroidsVisible.clear();

				// Create an array of size equal to the number of asteroids, marking all asteroids visible
				boolean visible[] = new boolean[m_asteroidsFull.size()];
				for (int k = 0; k < m_asteroidsFull.size(); k++) {
					visible[k] = true;
				} //for

				// Start removing items based on filters

				// Eccentricity filter
				if (ddlEcc.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlEcc.getSelectedIndex() == 1) {
							if (current.getEccentricity() >= 0.1) {
								visible[i] = false;
							} //if
						} else if (ddlEcc.getSelectedIndex() == 2) {
							if ((current.getEccentricity() < 0.1) || (current.getEccentricity() >= 0.25)) {
								visible[i] = false;
							} //if
						} else if (ddlEcc.getSelectedIndex() == 3) {
							if ((current.getEccentricity() < 0.25) || (current.getEccentricity() >= 0.5)) {
								visible[i] = false;
							} //if
						} else if (ddlEcc.getSelectedIndex() == 4) {
							if (current.getEccentricity() < 0.5) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Inclination filter
				if (ddlInc.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlInc.getSelectedIndex() == 1) {
							if (current.getInclination() >= 10) {
								visible[i] = false;
							} //if
						} else if (ddlInc.getSelectedIndex() == 2) {
							if ((current.getInclination() < 10) || (current.getInclination() >= 30)) {
								visible[i] = false;
							} //if
						} else if (ddlInc.getSelectedIndex() == 3) {
							if ((current.getInclination() < 30) || (current.getInclination() >= 60)) {
								visible[i] = false;
							} //if
						} else if (ddlInc.getSelectedIndex() == 4) {
							if (current.getInclination() < 60) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Magnitude filter
				if (ddlMag.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlMag.getSelectedIndex() == 1) {
							if (current.getAbsoluteMagnitude() >= 16) {
								visible[i] = false;
							} //if
						} else if (ddlMag.getSelectedIndex() == 2) {
							if ((current.getAbsoluteMagnitude() < 16) || (current.getAbsoluteMagnitude() >= 18)) {
								visible[i] = false;
							} //if
						} else if (ddlMag.getSelectedIndex() == 3) {
							if ((current.getAbsoluteMagnitude() < 18) || (current.getAbsoluteMagnitude() >= 20)) {
								visible[i] = false;
							} //if
						} else if (ddlMag.getSelectedIndex() == 4) {
							if (current.getAbsoluteMagnitude() < 20) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Perihelion filter
				if (ddlPer.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlPer.getSelectedIndex() == 1) {
							if (current.getPerihelionDistance() >= 0.25) {
								visible[i] = false;
							} //if
						} else if (ddlPer.getSelectedIndex() == 2) {
							if ((current.getPerihelionDistance() < 0.25) || (current.getPerihelionDistance() >= 0.5)) {
								visible[i] = false;
							} //if
						} else if (ddlPer.getSelectedIndex() == 3) {
							if ((current.getPerihelionDistance() < 0.5) || (current.getPerihelionDistance() >= 0.75)) {
								visible[i] = false;
							} //if
						} else if (ddlPer.getSelectedIndex() == 4) {
							if ((current.getPerihelionDistance() < 0.75) || (current.getPerihelionDistance() >= 1)) {
								visible[i] = false;
							} //if
						} else if (ddlPer.getSelectedIndex() == 5) {
							if (current.getPerihelionDistance() < 1) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Aphelion filter
				if (ddlAph.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlAph.getSelectedIndex() == 1) {
							if (current.getAphelionDistance() >= 1) {
								visible[i] = false;
							} //if
						} else if (ddlAph.getSelectedIndex() == 2) {
							if ((current.getAphelionDistance() < 1) || (current.getAphelionDistance() >= 2.5)) {
								visible[i] = false;
							} //if
						} else if (ddlAph.getSelectedIndex() == 3) {
							if ((current.getAphelionDistance() < 2.5) || (current.getAphelionDistance() >= 5)) {
								visible[i] = false;
							} //if
						} else if (ddlAph.getSelectedIndex() == 4) {
							if (current.getAphelionDistance() < 5) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Orbital period filter
				if (ddlOrb.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlOrb.getSelectedIndex() == 1) {
							if (current.getOrbitalPeriodYears() >= 0.75) {
								visible[i] = false;
							} //if
						} else if (ddlOrb.getSelectedIndex() == 2) {
							if ((current.getOrbitalPeriodYears() < 0.75) || (current.getOrbitalPeriodYears() >= 1)) {
								visible[i] = false;
							} //if
						} else if (ddlOrb.getSelectedIndex() == 3) {
							if ((current.getOrbitalPeriodYears() < 1) || (current.getOrbitalPeriodYears() >= 2)) {
								visible[i] = false;
							} //if
						} else if (ddlOrb.getSelectedIndex() == 4) {
							if (current.getOrbitalPeriodYears() < 2) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if

				// Minimum Earth distance filter
				if (ddlEar.getSelectedIndex() != 0) {

					for (int i = 0; i < m_asteroidsFull.size(); i++) {
						Asteroid current = m_asteroidsFull.get(i);

						if (ddlEar.getSelectedIndex() == 1) {
							if (current.getEarthMinimumOrbitIntersectionDistanceAU() >= 0.01) {
								visible[i] = false;
							} //if
						} else if (ddlEar.getSelectedIndex() == 2) {
							if ((current.getEarthMinimumOrbitIntersectionDistanceAU() < 0.01) || (current.getEarthMinimumOrbitIntersectionDistanceAU() >= 0.025)) {
								visible[i] = false;
							} //if
						} else if (ddlEar.getSelectedIndex() == 3) {
							if ((current.getEarthMinimumOrbitIntersectionDistanceAU() < 0.025) || (current.getEarthMinimumOrbitIntersectionDistanceAU() >= 0.04)) {
								visible[i] = false;
							} //if
						} else if (ddlEar.getSelectedIndex() == 4) {
							if (current.getEarthMinimumOrbitIntersectionDistanceAU() < 0.04) {
								visible[i] = false;
							} //if
						} //if
					} //for

				} //if


				// Fill the visible asteroids ArrayList based on the boolean array
				for (int k = 0; k < m_asteroidsFull.size(); k++) {
					if (visible[k]) {
						m_asteroidsVisible.add(m_asteroidsFull.get(k));
					} //if
				} //for


			} //if


            repaint();

        } //actionPerformed

    } //changeListener

	public void paint(Graphics g) {
		super.paint(g);

		// Update position if the mouse moved
		currentCenterX = currentCenterX + mouseXChanged;
		currentCenterY = currentCenterY + mouseYChanged;


		Graphics2D g2d = (Graphics2D) g;

		// Set clipping bounds
		g2d.setClip(new Rectangle2D.Double(Constants.BOX_X, Constants.BOX_Y, Constants.BOX_WIDTH, Constants.BOX_HEIGHT));

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Redraw images based on updated filter / color / whatever
        drawSpaceBackground(g2d);




		drawAsteroidOverlay(g2d);
        drawPlanetOverlay(g2d);

        g2d.setColor(Color.BLACK);
    } //paint

	public void drawSpaceBackground(Graphics2D g) {
		g.fillRect(Constants.BOX_X, Constants.BOX_Y, Constants.BOX_WIDTH, Constants.BOX_HEIGHT);
	} //drawSpaceBackground

	public void drawAsteroidOverlay(Graphics2D g) {
		g.setColor(Color.BLUE);

		for (Asteroid current : m_asteroidsVisible) {
			double semimajorAxis = current.getSemimajorAxis() * 2 * currentAU;
			double semiminorAxis = semimajorAxis * Math.sqrt(1 - Math.pow(current.getEccentricity(), 2));
			double perihelion = current.getPerihelionDistance() * 2 * currentAU;

			//System.out.println(semimajorAxis);
			//System.out.println(semiminorAxis);
			//System.out.println(perihelion);
			//System.out.println("");

			if (semimajorAxis != -1) {

				//g.drawOval(currentCenterX - ((int)semimajorAxis/2), currentCenterY - ((int)semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);
				//g.drawOval((int)(currentCenterX - (semimajorAxis/2)), currentCenterY - ((int)semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);

				if (ddlColor.getSelectedIndex() == 0) {
					g.setColor(Color.BLUE);

				} else if (ddlColor.getSelectedIndex() == 1) {
					if (current.getOrbitalClassification().equals("APO")) {			// Apollo (crosses Earth orbit, semimajor axis > 1AU)
						g.setColor(Color.BLUE);
					} else if (current.getOrbitalClassification().equals("AMO")) {	// Amor (outside Earth orbit, never crosses)
						g.setColor(Color.GREEN);
					} else if (current.getOrbitalClassification().equals("ATE")) {	// Aten (crosses Earth orbit, semimajor axis < 1AU)
						g.setColor(Color.YELLOW);
					} else if (current.getOrbitalClassification().equals("IEO")) {  // Inner Earth Orbit
						g.setColor(Color.ORANGE);
					} else {
						// Shouldn't happen
						g.setColor(Color.RED);
					} //if-else

				} //if

				AffineTransform old = g.getTransform();

				g.translate(currentCenterX, currentCenterY);
				g.rotate(Math.toRadians(current.getLongitudeOfAscendingNode()));
				g.drawOval((int)(-perihelion/2), (int)(-semiminorAxis/2), (int)semimajorAxis, (int)semiminorAxis);

				g.setTransform(old);

		 	} //if
		} //for

		g.setColor(Color.BLACK);
	} //drawAsteroidOverlay

	public void drawPlanetOverlay(Graphics2D g) {
		// Draw sun
		g.setColor(Color.YELLOW);

		double sunSize = Constants.SUN_SIZE * currentAU;
		if (sunSize < 10) {
			sunSize = 10;
		} //if

		g.fillOval((int)(currentCenterX - (sunSize/2)), (int)(currentCenterY - (sunSize/2)), (int)sunSize, (int)sunSize);

		// Draw planet orbits
		g.setColor(Color.LIGHT_GRAY);

		AffineTransform old = g.getTransform();

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.MERCURY_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.MERCURY_PERIHELION*currentAU), (int)(-Constants.MERCURY_SEMIMINOR_AXIS*currentAU), (int)(Constants.MERCURY_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MERCURY_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.VENUS_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.VENUS_PERIHELION*currentAU), (int)(-Constants.VENUS_SEMIMINOR_AXIS*currentAU), (int)(Constants.VENUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.VENUS_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.EARTH_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.EARTH_PERIHELION*currentAU), (int)(-Constants.EARTH_SEMIMINOR_AXIS*currentAU), (int)(Constants.EARTH_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.EARTH_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.MARS_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.MARS_PERIHELION*currentAU), (int)(-Constants.MARS_SEMIMINOR_AXIS*currentAU), (int)(Constants.MARS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.MARS_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.JUPITER_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.JUPITER_PERIHELION*currentAU), (int)(-Constants.JUPITER_SEMIMINOR_AXIS*currentAU), (int)(Constants.JUPITER_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.JUPITER_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.SATURN_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.SATURN_PERIHELION*currentAU), (int)(-Constants.SATURN_SEMIMINOR_AXIS*currentAU), (int)(Constants.SATURN_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.SATURN_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.URANUS_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.URANUS_PERIHELION*currentAU), (int)(-Constants.URANUS_SEMIMINOR_AXIS*currentAU), (int)(Constants.URANUS_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.URANUS_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

		g.translate(currentCenterX, currentCenterY);
		g.rotate(Math.toRadians(Constants.NEPTUNE_LONGITUDE_NODE));
		g.drawOval((int)(-Constants.NEPTUNE_PERIHELION*currentAU), (int)(-Constants.NEPTUNE_SEMIMINOR_AXIS*currentAU), (int)(Constants.NEPTUNE_SEMIMAJOR_AXIS*2*currentAU), (int)(Constants.NEPTUNE_SEMIMINOR_AXIS*2*currentAU));
		g.setTransform(old);

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
		g.setColor(Color.BLACK);
	} //drawPlanetOverlay


} //ProjGUI