class Constants {

	// Screen size
	public static final int WINDOW_WIDTH = 1280;
	public static final int WINDOW_HEIGHT = 720;

	// Main view size
	public static final int BOX_X = 25;
	public static final int BOX_Y = 25;
	public static final int BOX_WIDTH = WINDOW_WIDTH - 250;
	public static final int BOX_HEIGHT = WINDOW_HEIGHT - 75;
	public static final int BOX_CENTER_X = (BOX_WIDTH / 2) + BOX_X;
    public static final int BOX_CENTER_Y = (BOX_HEIGHT / 2) + BOX_Y;

	// Global sizing
	public static final int AU = 250;

	// Planet overlay sizing
	public static final double SUN_SIZE = 0.00929;

	public static final double MERCURY_SEMIMAJOR_AXIS = 0.387098;
	public static final double VENUS_SEMIMAJOR_AXIS = 0.723327;
	public static final double EARTH_SEMIMAJOR_AXIS = 1.0000026;
	public static final double MARS_SEMIMAJOR_AXIS = 1.523679;
	public static final double JUPITER_SEMIMAJOR_AXIS = 5.204267;
	public static final double SATURN_SEMIMAJOR_AXIS = 9.5820172;
	public static final double URANUS_SEMIMAJOR_AXIS = 19.22941195;
	public static final double NEPTUNE_SEMIMAJOR_AXIS = 30.10366151;

	public static final double MERCURY_PERIHELION = 0.307499;
	public static final double VENUS_PERIHELION = 0.718440;
	public static final double EARTH_PERIHELION = 0.98329134;
	public static final double MARS_PERIHELION = 1.381497;
	public static final double JUPITER_PERIHELION = 4.950429;
	public static final double SATURN_PERIHELION = 9.04807635;
	public static final double URANUS_PERIHELION = 18.37551863;
	public static final double NEPTUNE_PERIHELION = 29.76607095;

	public static final double MERCURY_ECCENTRICITY = 0.205630;
	public static final double VENUS_ECCENTRICITY = 0.006756;
	public static final double EARTH_ECCENTRICITY = 0.01671123;
	public static final double MARS_ECCENTRICITY = 0.093315;
	public static final double JUPITER_ECCENTRICITY = 0.048775;
	public static final double SATURN_ECCENTRICITY = 0.055723219;
	public static final double URANUS_ECCENTRICITY = 0.044405586;
	public static final double NEPTUNE_ECCENTRICITY = 0.011214269;

	public static final double MERCURY_SEMIMINOR_AXIS = MERCURY_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(MERCURY_ECCENTRICITY, 2));
	public static final double VENUS_SEMIMINOR_AXIS = VENUS_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(VENUS_ECCENTRICITY, 2));
	public static final double EARTH_SEMIMINOR_AXIS = EARTH_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(EARTH_ECCENTRICITY, 2));
	public static final double MARS_SEMIMINOR_AXIS = MARS_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(MARS_ECCENTRICITY, 2));
	public static final double JUPITER_SEMIMINOR_AXIS = JUPITER_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(JUPITER_ECCENTRICITY, 2));
	public static final double SATURN_SEMIMINOR_AXIS = SATURN_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(SATURN_ECCENTRICITY, 2));
	public static final double URANUS_SEMIMINOR_AXIS = URANUS_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(URANUS_ECCENTRICITY, 2));
	public static final double NEPTUNE_SEMIMINOR_AXIS = NEPTUNE_SEMIMAJOR_AXIS * Math.sqrt(1 - Math.pow(NEPTUNE_ECCENTRICITY, 2));

	public static final double MERCURY_LONGITUDE_NODE = 48.331;
	public static final double VENUS_LONGITUDE_NODE = 76.678;
	public static final double EARTH_LONGITUDE_NODE = 348.73936;
	public static final double MARS_LONGITUDE_NODE = 49.562;
	public static final double JUPITER_LONGITUDE_NODE = 100.492;
	public static final double SATURN_LONGITUDE_NODE = 113.642811;
	public static final double URANUS_LONGITUDE_NODE = 73.989821;
	public static final double NEPTUNE_LONGITUDE_NODE = 131.794310;

    // DDL options
    public static final String eccOptions[] = {"No Filter", "e < 0.1", "0.1 <= e < 0.25", "0.25 <= e < 0.5", "0.5 <= e"};
    public static final String incOptions[] = {"No Filter", "i < 10", "10 <= i < 30", "30 <= i < 60", "60 <= i"};
    public static final String magOptions[] = {"No Filter", "H < 16", "16 <= H < 18", "18 <= H < 20", "20 <= H"};
    public static final String perOptions[] = {"No Filter", "q < 0.25", "0.25 <= q < 0.5", "0.5 <= q < 0.75", "0.75 <= q < 1", "1 <= q"};
    public static final String aphOptions[] = {"No Filter", "Q < 1", "1 <= Q < 2.5", "2.5 <= Q < 5", "5 <= Q"};
    public static final String orbOptions[] = {"No Filter", "T < 0.75", "0.75 <= T < 1", "1 <= T < 2", "2 <= T"};
    public static final String earOptions[] = {"No Filter", "d < 0.01", "0.01 <= d < 0.025", "0.025 <= d < 0.04", "0.04 <= d"};
    public static final String colorOptions[] = {"No Coloring", "Orbit Type"};

} //Constants