import java.util.*;
import java.io.*;

public class Parser {

	private File inputFile;
	private ArrayList<String> m_lines;
	private ArrayList<Asteroid> m_asteroids;

	public Parser() {
		inputFile = null;
		m_lines = new ArrayList<String>();
		m_asteroids = new ArrayList<Asteroid>();
	} //TIMParser (constructor)

	/**
	 * Initialize arrays and get the file extension
	 */
	public Parser(File file) {
		inputFile = file;
		m_lines = new ArrayList<String>();
		m_asteroids = new ArrayList<Asteroid>();
	} //TIMParser (constructor)

	/**
	 * Read from the file, storing each line
	 */
	public void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String line;
		while ((line = br.readLine()) != null) {
   			m_lines.add(line);
		} //while
		br.close();
	} //readFile

	/**
	 * Parse the collection of lines read from the file
	 */
	public void parseLines() {
		StringTokenizer st;
		Asteroid temp;

		for (String line : m_lines) {

			st = new StringTokenizer(line, ",");
			temp = new Asteroid();										// What are these fields?

			String id = st.nextToken();									// ID
			int spkID;													// SPK ID

			try {
				spkID = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				spkID = -1;
			} //try-catch

			String fullname = st.nextToken();							// Full name
			String pdes = st.nextToken();								// PDES
			String name = st.nextToken();								// Name
			double absmag;												// Absolute magnitude

			try {
				absmag = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				absmag = -1;
			} //try-catch

			double magslope;											// Magnitude slope parameter

			try {
				magslope = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				magslope = -1;
			} //try-catch

			double diameter;											// Diameter

			try {
				diameter = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				diameter = -1;
			} //try-catch

			String extent = st.nextToken();								// Extent
			double albedo;												// Albedo

			try {
				albedo = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				albedo = -1;
			} //try-catch

			double rotation;											// Rotation period

			try {
				rotation = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
			    rotation = -1;
			} //try-catch

			double bv;													// Color index BV

			try {
				bv = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				bv = -1;
			} //try-catch

			double ub;													// Color index UB

			try {
				ub = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				ub = -1;
			} //try-catch

			String smassii = st.nextToken();							// Spectral taxonomic type (SMASSII)
			String tholen = st.nextToken();								// Spectral taxonomic type (Tholen)
			double uncmag;												// Uncertainty - Magnitude

			try {
				uncmag = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncmag = -1;
			} //try-catch

			double uncdia;												// Uncertainty - Diameter

			try {
				uncdia = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncdia = -1;
			} //try-catch

			String solid = st.nextToken();								// Orbital solution ID
			double jed;													// Epoch of osculation JED

			try {
				jed = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				jed = -1;
			} //try-catch

			int mjd;													// Epoch of osculation MJD

			try {
				mjd = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				mjd = -1;
			} //try-catch

			int et;														// Epoch of osculation ET

			try {
				et = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				et = -1;
			} //try-catch

			String equinox = st.nextToken();							// Equinox of reference frame
			double ecc;													// Eccentricity

			try {
				ecc = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				ecc = -1;
			} //try-catch

			double semi;												// Semimajor axis

			try {
				semi = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				semi = -1;
			} //try-catch

			double peri;												// Perihelion distance

			try {
				peri = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				peri = -1;
			} //try-catch

			double inc;													// Inclination

			try {
				inc = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				inc = -1;
			} //try-catch

			double longi;										 		// Longitude of ascending node

			try {
				longi = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				longi = -1;
			} //try-catch

			double arg;											 		// Argument of perihelion

			try {
				arg = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				arg = -1;
			} //try-catch

			double ano;													// Mean anomaly

			try {
				ano = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				ano = -1;
			} //try-catch

			double aph;													// Aphelion distance

			try {
				aph = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				aph = -1;
			} //try-catch

			double mean;												// Mean motion

			try {
				mean = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				mean = -1;
			} //try-catch

			double passjed;												// Time of perihelion passage (JED)

			try {
				passjed = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				passjed = -1;
			} //try-catch

			double passage;												// Time of perihelion passage (ET)

			try {
				passage = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				passage = -1;
			} //try-catch

			double days;												// Orbital period (days)

			try {
				days = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				days = -1;
			} //try-catch

			double years;												// Orbital period (years)

			try {
				years = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				years = -1;
			} //try-catch

			double au;													// Earth minimuum orbit intersection distance (AU)

			try {
				au = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				au = -1;
			} //try-catch

			double ld;													// Earth minimum orbit intersection distance (LD)

			try {
				ld = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				ld = -1;
			} //try-catch

			double jupiter;												// Jupiter tisserand invariant

			try {
				jupiter = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				jupiter = -1;
			} //try-catch

			double uncecc;												// Uncertainty - Eccentricity

			try {
				uncecc = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncecc = -1;
			} //try-catch

			double uncsemi;												// Uncertainty - Semimajor axis

			try {
				uncsemi = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncsemi = -1;
			} //try-catch

			double uncperi;												// Uncertainty - Perihleion distance (AU)

			try {
				uncperi = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncperi = -1;
			} //try-catch

			double uncinc;												// Uncertainty - Inclination

			try {
				uncinc = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncinc = -1;
			} //try-catch

			double unclong;												// Uncertainty - Longitude of ascending node

			try {
				unclong = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				unclong = -1;
			} //try-catch

			double uncarg;												// Uncertainty - Argument of perihelion

			try {
				uncarg = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncarg = -1;
			} //try-catch

			double uncano;												// Uncertainty - Mean anomaly

			try {
				uncano = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncano = -1;
			} //try-catch

			double uncaph;												// Uncertainty - Aphelion distance

			try {
				uncaph = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncaph = -1;
			} //try-catch

			double uncmean;												// Uncertainty - Mean motion

			try {
				uncmean = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncmean = -1;
			} //try-catch

			double unctime;												// Uncertainty - Time of perihelion passage

			try {
				unctime = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				unctime = -1;
			} //try-catch

			double uncorb;												// Uncertainty - Orbital period

			try {
				uncorb = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				uncorb = -1;
			} //try-catch

			String classi = st.nextToken();								// Orbital classification
			String producer = st.nextToken();							// Producer
			int spanned;												// Days spanned by data arc

			try {
				spanned = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				spanned = -1;
			} //try-catch

			String first = st.nextToken();								// First observation in orbital fit
			String last = st.nextToken();								// Last observation in orbital fit
			int observations;											// Number of observations in orbital fit

			try {
				observations = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				observations = -1;
			} //try-catch

			int delay;													// Number of delay radar observations in orbital fit

			try {
				delay = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				delay = -1;
			} //try-catch

			int doppler;												// Number of doppler radar observations in orbital fit

			try {
				doppler = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				doppler = -1;
			} //try-catch

			int condition;												// Orbit condition code

			try {
				condition = Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				condition = -1;
			} //try-catch

			double rms;													// Normalized RMS of orbit fit

			try {
				rms = Double.parseDouble(st.nextToken());
			} catch (Exception e) {
				rms = -1;
			} //try-catch


			temp = new Asteroid(id, spkID, fullname, pdes, name, absmag, magslope, diameter, extent, albedo, rotation, bv, ub, smassii, tholen, uncmag, uncdia, solid,
					jed, mjd, et, equinox, ecc, semi, peri, inc, longi, arg, ano, aph, mean, passjed, passage, days, years, au, ld, jupiter, uncecc, uncsemi, uncperi,
					uncinc, unclong, uncarg, uncano, uncaph, uncmean, unctime, uncorb, classi, producer, spanned, first, last, observations, delay, doppler,
					condition, rms);

			m_asteroids.add(temp);

		} //for

	} //parseLines

	/**
	 * Writes the collection of asteroidss to the console
	 */
	public void printParsedOutput() {
		for (int i = 0; i < m_asteroids.size(); i++) {
			System.out.println(m_asteroids.get(i).toString());
		} //for
	} //printParsedOutput

	/**
	 * Returns the collection of asteroids
	 */
	public ArrayList<Asteroid> getAsteroids() {
		return m_asteroids;
	} //getTIMs

/*
	// Driver
	public static void main(String[] args) {

		// Instantiate a new parser
		Parser parser = new Parser(new File("data.csv"));

		// Read the file
		try {
			parser.readFile();
		} catch (Exception e) {
			System.err.println("Something bad happened reading the file...");
		} //try-catch

		// Parse the file
		parser.parseLines();

		// Display output
		parser.printParsedOutput();

	} //main
*/
} //Parser (class)