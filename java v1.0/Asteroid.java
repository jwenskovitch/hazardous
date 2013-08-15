import java.util.*;

class Asteroid {

	// Object Fields
	private String m_ID;
	private int    m_spkID;
	private String m_fullName;
	private String m_PDES;
	private String m_name;
	private double m_absoluteMagnitude;
	private double m_magnitudeSlopeParameter;
	private double m_diameter;
	private String m_extent;
	private double m_albedo;
	private double m_rotationPeriod;
	private double m_colorIndexBV;
	private double m_colorIndexUB;
	private String m_spectralTaxonomicTypeSMASSII;
	private String m_spectralTaxonomicTypeTholen;
	private double m_oneSigmaUncertaintyInAbsoluteMagnitude;
	private double m_oneSigmaUncertaintyInDiameter;

	// Object and Model Parameter Fields
	private String m_orbitSolutionID;
	private double m_epochOfOsculationJED;
	private int    m_epochOfOsculationMJD;
	private int    m_epochOfOsculationET;
	private String m_equinoxOfReferenceFrame;
	private double m_eccentricity;
	private double m_semimajorAxis;
	private double m_perihelionDistance;
	private double m_inclination;
	private double m_longitudeOfAscendingNode;
	private double m_argumentOfPerihelion;
	private double m_meanAnomaly;
	private double m_aphelionDistance;
	private double m_meanMotion;
	private double m_timeOfPerihelionPassageJED;
	private double m_timeOfPerihelionPassageET;
	private double m_orbitalPeriodDays;
	private double m_orbitalPeriodYears;
	private double m_earthMinimumOrbitIntersectionDistanceAU;
	private double m_earthMinimumOrbitIntersectionDistanceLD;
	private double m_jupiterTisserandInvariant;
	private double m_oneSigmaUncertaintyEccentricity;
	private double m_oneSigmaUncertaintySemimajorAxis;
	private double m_oneSigmaUncertaintyPerihelionDistanceAU;
	private double m_oneSigmaUncertaintyInclination;
	private double m_oneSigmaUncertaintyLongitudeOfAscendingNode;
	private double m_oneSigmaUncertaintyArgumentOfPerihelion;
	private double m_oneSigmaUncertaintyMeanAnomaly;
	private double m_oneSigmaUncertaintyAphelionDistance;
	private double m_oneSigmaUncertaintyMeanMotion;
	private double m_oneSigmaUncertaintyTimeOfPerihelionPassage;
	private double m_oneSigmaUncertaintyOrbitalPeriod;
	private String m_orbitalClassification;
	private String m_producer;
	private int    m_daysSpannedByDataArc;
	private String m_firstObservationInOrbitalFit;
	private String m_lastObservationInOrbitalFit;
	private int    m_numberObservationsInOrbitalFit;
	private int    m_numberDelayRadarObservationsInOrbitalFit;
	private int    m_numberDopplerRadarObservationsInOrbitalFit;
	private int    m_orbitConditionCode;
	private double m_normalizedRMSOfOrbitFit;

	////////////////////////////////////////////////////////////////////////////////////////
	//                                    CONSTRUCTORS                                    //
	////////////////////////////////////////////////////////////////////////////////////////

	public Asteroid() {
		this.setID(null);
		this.setSPKID(0);
		this.setFullName(null);
		this.setPDES(null);
		this.setName(null);
		this.setAbsoluteMagnitude(0);
		this.setMagnitudeSlopeParameter(0);
		this.setDiameter(0);
		this.setExtent(null);
		this.setAlbedo(0);
		this.setRotationPeriod(0);
		this.setColorIndexBV(0);
		this.setColorIndexUB(0);
		this.setSpectralTaxonomicTypeSMASSII(null);
		this.setSpectralTaxonomicTypeTholen(null);
		this.setUncertaintyAbsoluteMagnitude(0);
		this.setUncertaintyDiameter(0);

		this.setOrbitSolutionID(null);
		this.setEpochOfOsculationJED(0);
		this.setEpochOfOsculationMJD(0);
		this.setEpochOfOsculationET(0);
		this.setEquinoxOfReferenceFrame(null);
		this.setEccentricity(0);
		this.setSemimajorAxis(0);
		this.setPerihelionDistance(0);
		this.setInclination(0);
		this.setLongitudeOfAscendingNode(0);
		this.setArgumentOfPerihelion(0);
		this.setMeanAnomaly(0);
		this.setAphelionDistance(0);
		this.setMeanMotion(0);
		this.setTimeOfPerihelionPassageJED(0);
		this.setTimeOfPerihelionPassageET(0);
		this.setOrbitalPeriodDays(0);
		this.setOrbitalPeriodYears(0);
		this.setEarthMinimumOrbitIntersectionDistanceAU(0);
		this.setEarthMinimumOrbitIntersectionDistanceLD(0);
		this.setJupiterTisserandInvariant(0);
		this.setUncertaintyEccentricity(0);
		this.setUncertaintySemimajorAxis(0);
		this.setUncertaintyPerihelionDistanceAU(0);
		this.setUncertaintyInclination(0);
		this.setUncertaintyLongitudeOfAscendingNode(0);
		this.setUncertaintyArgumentOfPerihelion(0);
		this.setUncertaintyMeanAnomaly(0);
		this.setUncertaintyAphelionDistance(0);
		this.setUncertaintyMeanMotion(0);
		this.setUncertaintyTimeOfPerihelionPassage(0);
		this.setUncertaintyOrbitalPeriod(0);
		this.setOrbitalClassification(null);
		this.setProducer(null);
		this.setDaysSpannedByDataArc(0);
		this.setFirstObservationInOrbitalFit(null);
		this.setLastObservationInOrbitalFit(null);
		this.setNumberObservationsInOrbitalFit(0);
		this.setNumberDelayRadarObservationsInOrbitalFit(0);
		this.setNumberDopplerRadarObservationsInOrbitalFit(0);
		this.setOrbitConditionCode(0);
		this.setNormalizedRMSOfOrbitFit(0);

	} //Asteroid (constructor)

	public Asteroid(String id, int spkid, String fullname, String pdes, String name, double absmag, double magslope, double dia, String extent, double albedo,
			double rot,	double bv, double ub, String smassii, String tholen, double uncmag, double uncdia, String solid, double jed, int mjd, int et, String equinox,
			double ecc,	double semi, double peridist, double inc, double longi, double peri, double ano, double aph, double motion, double jedpass, double passage,
			double days, double years, double au, double ld, double jupiter, double uncecc, double uncsemi, double uncperi, double uncinc, double unclong,
			double uncarg, double uncano, double uncaph, double uncmotion, double unctime, double uncorb, String classi, String prod, int spanned, String first,
			String last, int obs, int delay, int doppler, int condition, double rms) {

		this.setID(id);
		this.setSPKID(spkid);
		this.setFullName(fullname);
		this.setPDES(pdes);
		this.setName(name);
		this.setAbsoluteMagnitude(absmag);
		this.setMagnitudeSlopeParameter(magslope);
		this.setDiameter(dia);
		this.setExtent(extent);
		this.setAlbedo(albedo);
		this.setRotationPeriod(rot);
		this.setColorIndexBV(bv);
		this.setColorIndexUB(ub);
		this.setSpectralTaxonomicTypeSMASSII(smassii);
		this.setSpectralTaxonomicTypeTholen(tholen);
		this.setUncertaintyAbsoluteMagnitude(uncmag);
		this.setUncertaintyDiameter(uncdia);

		this.setOrbitSolutionID(solid);
		this.setEpochOfOsculationJED(jed);
		this.setEpochOfOsculationMJD(mjd);
		this.setEpochOfOsculationET(et);
		this.setEquinoxOfReferenceFrame(equinox);
		this.setEccentricity(ecc);
		this.setSemimajorAxis(semi);
		this.setPerihelionDistance(peridist);
		this.setInclination(inc);
		this.setLongitudeOfAscendingNode(longi);
		this.setArgumentOfPerihelion(peri);
		this.setMeanAnomaly(ano);
		this.setAphelionDistance(aph);
		this.setMeanMotion(motion);
		this.setTimeOfPerihelionPassageJED(jedpass);
		this.setTimeOfPerihelionPassageET(passage);
		this.setOrbitalPeriodDays(days);
		this.setOrbitalPeriodYears(years);
		this.setEarthMinimumOrbitIntersectionDistanceAU(au);
		this.setEarthMinimumOrbitIntersectionDistanceLD(ld);
		this.setJupiterTisserandInvariant(jupiter);
		this.setUncertaintyEccentricity(uncecc);
		this.setUncertaintySemimajorAxis(uncsemi);
		this.setUncertaintyPerihelionDistanceAU(uncperi);
		this.setUncertaintyInclination(uncinc);
		this.setUncertaintyLongitudeOfAscendingNode(unclong);
		this.setUncertaintyArgumentOfPerihelion(uncarg);
		this.setUncertaintyMeanAnomaly(uncano);
		this.setUncertaintyAphelionDistance(uncaph);
		this.setUncertaintyMeanMotion(uncmotion);
		this.setUncertaintyTimeOfPerihelionPassage(unctime);
		this.setUncertaintyOrbitalPeriod(uncorb);
		this.setOrbitalClassification(classi);
		this.setProducer(prod);
		this.setDaysSpannedByDataArc(spanned);
		this.setFirstObservationInOrbitalFit(first);
		this.setLastObservationInOrbitalFit(last);
		this.setNumberObservationsInOrbitalFit(obs);
		this.setNumberDelayRadarObservationsInOrbitalFit(delay);
		this.setNumberDopplerRadarObservationsInOrbitalFit(doppler);
		this.setOrbitConditionCode(condition);
		this.setNormalizedRMSOfOrbitFit(rms);

	} //Asteroid (constructor)




	///////////////////////////////////////////////////////////////////////////////////////
	//                                SETTERS AND GETTERS                                //
	///////////////////////////////////////////////////////////////////////////////////////

	public void setID(String ID) {
		this.m_ID = ID;
	} //setID

	public String getID() {
		return this.m_ID;
	} //getID

	public void setSPKID(int spkID) {
		this.m_spkID = spkID;
	} //setSPKID

	public int getSPKID() {
		return this.m_spkID;
	} //getSPKID

	public void setFullName(String fullName) {
		this.m_fullName = fullName;
	} //setFullName

	public String getFullName() {
		return m_fullName;
	} //getFullName

	public void setPDES(String PDES) {
		this.m_PDES = PDES;
	} //setPDES

	public String getPDES() {
		return this.m_PDES;
	} //getPDES

	public void setName(String name) {
		this.m_name = name;
	} //setName

	public String getName() {
		return this.m_name;
	} //getName

	public void setAbsoluteMagnitude(double magnitude) {
		this.m_absoluteMagnitude = magnitude;
	} //setAbsoluteMagnitude

	public double getAbsoluteMagnitude() {
		return this.m_absoluteMagnitude;
	} //getAbsoluteMagnitude

	public void setMagnitudeSlopeParameter(double slope) {
		this.m_magnitudeSlopeParameter = slope;
	} //setMagnitudeSlopeParameter

	public double getMagntitudeSlopeParameter() {
		return this.m_magnitudeSlopeParameter;
	} //getMagnitudeSlopeParameter

	public void setDiameter(double diameter) {
		this.m_diameter = diameter;
	} //setDiameter

	public double getDiameter() {
		return this.m_diameter;
	} //getDiameter

	public void setExtent(String extent) {
		this.m_extent = extent;
	} //setExtent

	public String getExtent() {
		return this.m_extent;
	} //getExtent

	public void setAlbedo(double albedo) {
		this.m_albedo = albedo;
	} //setAlbedo

	public double getAlbedo() {
		return this.m_albedo;
	} //getAlbedo

	public void setRotationPeriod(double rotation) {
		this.m_rotationPeriod = rotation;
	} //setRotationPeriod

	public double getRotationPeriod() {
		return this.m_rotationPeriod;
	} //getRotationPeriod

	public void setColorIndexBV(double BV) {
		this.m_colorIndexBV = BV;
	} //setColorIndexBV

	public double getColorIndexBV() {
		return this.m_colorIndexBV;
	} //getColorIndexBV

	public void setColorIndexUB(double UB) {
		this.m_colorIndexUB = UB;
	} //setColorIndexUB

	public double getColorIndexUB() {
		return this.m_colorIndexUB;
	} //getColorIndexUB

	public void setSpectralTaxonomicTypeSMASSII(String SMASSII) {
		this.m_spectralTaxonomicTypeSMASSII = SMASSII;
	} //setSpectralTaxonomicTypeSMASSII

	public String getSpectralTaxonomicTypeSMASSII() {
		return this.m_spectralTaxonomicTypeSMASSII;
	} //getSpectralTaxonomicTypeSMASSII

	public void setSpectralTaxonomicTypeTholen(String tholen) {
		this.m_spectralTaxonomicTypeTholen = tholen;
	} //setSpectralTaxonomicTypeTholen

	public String getSpectralTaxonomicTypeTholen() {
		return this.m_spectralTaxonomicTypeTholen;
	} //getSpectralTaxonomicTypeTholen

	public void setUncertaintyAbsoluteMagnitude(double uncMag) {
		this.m_oneSigmaUncertaintyInAbsoluteMagnitude = uncMag;
	} //setUncertaintyAbsoluteMagnitude

	public double getUncertaintyAbsoluteMagnitude() {
		return this.m_oneSigmaUncertaintyInAbsoluteMagnitude;
	} //getUncertaintyAbsoluteMagnitude

	public void setUncertaintyDiameter(double uncDia) {
		this.m_oneSigmaUncertaintyInDiameter = uncDia;
	} //setUncertaintyDiameter

	public double getUncertaintyDiameter() {
		return this.m_oneSigmaUncertaintyInDiameter;
	} //getUncertaintyDiameter

	public void setOrbitSolutionID(String solID) {
		this.m_orbitSolutionID = solID;
	} //setOrbitSolutionID

	public String getOrbitSolutionID() {
		return this.m_orbitSolutionID;
	} //getOrbitSolutionID

	public void setEpochOfOsculationJED(double JED) {
		this.m_epochOfOsculationJED = JED;
	} //setEpochOfOsculationJED

	public double getEpochOfOsculationJED() {
		return this.m_epochOfOsculationJED;
	} //getEpochOfOsculationJED

	public void setEpochOfOsculationMJD(int MJD) {
		this.m_epochOfOsculationMJD = MJD;
	} //setEpochOfOsculationMJD

	public int getEpochOfOsculationMJD() {
		return this.m_epochOfOsculationMJD;
	} //getEpochOfOsculationMJD

	public void setEpochOfOsculationET(int ET) {
		this.m_epochOfOsculationET = ET;
	} //setEpochOfOsculationET

	public int getEpochOfOsculationET() {
		return this.m_epochOfOsculationET;
	} //getEpochOfOsculationET

	public void setEquinoxOfReferenceFrame(String frame) {
		this.m_equinoxOfReferenceFrame = frame;
	} //setEquinoxOfReferenceFrame

	public String getEquinoxOfReferenceFrame() {
		return this.m_equinoxOfReferenceFrame;
	} //getEquinoxOfReferenceFrame

	public void setEccentricity(double ecc) {
		this.m_eccentricity = ecc;
	} //setEccentricity

	public double getEccentricity() {
		return this.m_eccentricity;
	} //getEccentricity

	public void setSemimajorAxis(double axis) {
		this.m_semimajorAxis = axis;
	} //setSemimajorAxis

	public double getSemimajorAxis() {
		return this.m_semimajorAxis;
	} //getSemimajorAxis

	public void setPerihelionDistance(double peri) {
		this.m_perihelionDistance = peri;
	} //setPerihelionDistance

	public double getPerihelionDistance() {
		return this.m_perihelionDistance;
	} //getPerihelionDistance

	public void setInclination(double inc) {
		this.m_inclination = inc;
	} //setInclination

	public double getInclination() {
		return this.m_inclination;
	} //getInclination

	public void setLongitudeOfAscendingNode(double longi) {
		this.m_longitudeOfAscendingNode = longi;
	} //setLongitudeOfAscendingNode

	public double getLongitudeOfAscendingNode() {
		return this.m_longitudeOfAscendingNode;
	} //getLongitudeOfAscendingNode

	public void setArgumentOfPerihelion(double arg) {
		this.m_argumentOfPerihelion = arg;
	} //setArgumentOfPerihelion

	public double getArgumentOfPerihelion() {
		return this.m_argumentOfPerihelion;
	} //getArgumentOfPerihelion

	public void setMeanAnomaly(double anomaly) {
		this.m_meanAnomaly = anomaly;
	} //setMeanAnomaly

	public double getMeanAnomaly() {
		return this.m_meanAnomaly;
	} //getMeanAnomaly

	public void setAphelionDistance(double aph) {
		this.m_aphelionDistance = aph;
	} //setAphelionDistance

	public double getAphelionDistance() {
		return this.m_aphelionDistance;
	} //getAphelionDistance

	public void setMeanMotion(double motion) {
		this.m_meanMotion = motion;
	} //setMeanMotion

	public double getMeanMotion() {
		return this.m_meanMotion;
	} //getMeanMotion

	public void setTimeOfPerihelionPassageJED(double JED) {
		this.m_timeOfPerihelionPassageJED = JED;
	} //setTimeOfPerihelionPassageJED

	public double getTimeOfPerihelionPassageJED() {
		return this.m_timeOfPerihelionPassageJED;
	} //getTimeOfPerihelionPassageJED

	public void setTimeOfPerihelionPassageET(double ET) {
		this.m_timeOfPerihelionPassageET = ET;
	} //setTimeOfPerihelionPassageET

	public double getTimeOfPerihelionPassageET() {
		return this.m_timeOfPerihelionPassageET;
	} //getTimeOfPerihelionPassageET

	public void setOrbitalPeriodDays(double days) {
		this.m_orbitalPeriodDays = days;
	} //setOrbitalPeriodDays

	public double getOrbitalPeriodDays() {
		return this.m_orbitalPeriodDays;
	} //getOrbitalPeriodDays

	public void setOrbitalPeriodYears(double years) {
		this.m_orbitalPeriodYears = years;
	} //setOrbitalPeriodYears

	public double getOrbitalPeriodYears() {
		return this.m_orbitalPeriodYears;
	} //getOrbitalPeriodYears

	public void setEarthMinimumOrbitIntersectionDistanceAU(double AU) {
		this.m_earthMinimumOrbitIntersectionDistanceAU = AU;
	} //setEarthMinimumOrbitIntersectionDistanceAU

	public double getEarthMinimumOrbitIntersectionDistanceAU() {
		return this.m_earthMinimumOrbitIntersectionDistanceAU;
	} //getEarthMinimumOrbitIntersectionDistanceAU

	public void setEarthMinimumOrbitIntersectionDistanceLD(double LD) {
		this.m_earthMinimumOrbitIntersectionDistanceLD = LD;
	} //setEarthMinimumOrbitIntersectionDistanceLD

	public double getEarthMinimumOrbitIntersectionDistanceLD() {
		return this.m_earthMinimumOrbitIntersectionDistanceLD;
	} //getEarthMinimumOrbitIntersectionDistanceLD

	public void setJupiterTisserandInvariant(double jupiter) {
		this.m_jupiterTisserandInvariant = jupiter;
	} //setJupiterTisserandInvariant

	public double getJupiterTisserandInvariant() {
		return this.m_jupiterTisserandInvariant;
	} //getJupiterTisserandInvariant

	public void setUncertaintyEccentricity(double uncEcc) {
		this.m_oneSigmaUncertaintyEccentricity = uncEcc;
	} //setUncertaintyEccentricity

	public double getUncertaintyEccentricity() {
		return this.m_oneSigmaUncertaintyEccentricity;
	} //getUncertaintyEccentricity

	public void setUncertaintySemimajorAxis(double uncSemi) {
		this.m_oneSigmaUncertaintySemimajorAxis = uncSemi;
	} //setUncertaintySemimajorAxis

	public double getUncertaintySemimajorAxis() {
		return this.m_oneSigmaUncertaintySemimajorAxis;
	} //getUncertaintySemimajorAxis

	public void setUncertaintyPerihelionDistanceAU(double uncAU) {
		this.m_oneSigmaUncertaintyPerihelionDistanceAU = uncAU;
	} //setUncertaintyPerihelionDistanceAU

	public double getUncertaintyPerihelionDistanceAU() {
		return this.m_oneSigmaUncertaintyPerihelionDistanceAU;
	} //getUncertaintyPerihelionDistanceAU

	public void setUncertaintyInclination(double uncInc) {
		this.m_oneSigmaUncertaintyInclination = uncInc;
	} //setUncertaintyInclination

	public double getUncertaintyInclination() {
		return m_oneSigmaUncertaintyInclination;
	} //getUncertaintyInclination

	public void setUncertaintyLongitudeOfAscendingNode(double uncLong) {
		this.m_oneSigmaUncertaintyLongitudeOfAscendingNode = uncLong;
	} //setUncertaintyLongitudeOfAscendingNode

	public double getUncertaintyLongitudeOfAscendingNode() {
		return this.m_oneSigmaUncertaintyLongitudeOfAscendingNode;
	} //getUncertaintyLongitudeOfAscendingNode

	public void setUncertaintyArgumentOfPerihelion(double uncPeri) {
		this.m_oneSigmaUncertaintyArgumentOfPerihelion = uncPeri;
	} //setUncertaintyArgumentOfPerihelion

	public double getUncertaintyArgumentOfPerihelion() {
		return this.m_oneSigmaUncertaintyArgumentOfPerihelion;
	} //getUncertaintyArgumentOfPerihelion

	public void setUncertaintyMeanAnomaly(double uncAno) {
		this.m_oneSigmaUncertaintyMeanAnomaly = uncAno;
	} //setUncertaintyMeanAnomaly

	public double getUncertaintyMeanAnomaly() {
		return this.m_oneSigmaUncertaintyMeanAnomaly;
	} //getUncertaintyMeanAnomaly

	public void setUncertaintyAphelionDistance(double uncAph) {
		this.m_oneSigmaUncertaintyAphelionDistance = uncAph;
	} //setUncertaintyAphelionDistance

	public double getUncertaintyAphelionDistance() {
		return this.m_oneSigmaUncertaintyAphelionDistance;
	} //getUncertaintyAphelionDistance

	public void setUncertaintyMeanMotion(double uncMotion) {
		this.m_oneSigmaUncertaintyMeanMotion = uncMotion;
	} //setUncertaintyMeanMotion

	public double getUncertaintyMeanMotion() {
		return this.m_oneSigmaUncertaintyMeanMotion;
	} //getUncertaintyMeanMotion

	public void setUncertaintyTimeOfPerihelionPassage(double uncPassage) {
		this.m_oneSigmaUncertaintyTimeOfPerihelionPassage = uncPassage;
	} //setUncertaintyTimeOfPerihelionPassage

	public double getUncertaintyTimeOfPerihelionPassage() {
		return this.m_oneSigmaUncertaintyTimeOfPerihelionPassage;
	} //getUncertaintyTimeOfPerihelionPassage

	public void setUncertaintyOrbitalPeriod(double uncPer) {
		this.m_oneSigmaUncertaintyOrbitalPeriod = uncPer;
	} //setUncertaintyOrbitalPeriod

	public double getUncertaintyOrbitalPeriod() {
		return this.m_oneSigmaUncertaintyOrbitalPeriod;
	} //getUncertaintyOrbitalPeriod

	public void setOrbitalClassification(String classi) {
		this.m_orbitalClassification = classi;
	} //setOrbitalClassification

	public String getOrbitalClassification() {
		return this.m_orbitalClassification;
	} //getOrbitalClassification

	public void setProducer(String producer) {
		this.m_producer = producer;
	} //setProducer

	public String getProducer() {
		return this.m_producer;
	} //getProducer

	public void setDaysSpannedByDataArc(int days) {
		this.m_daysSpannedByDataArc = days;
	} //setDaysSpannedByDataArc

	public int getDaysSpannedByDataArc() {
		return this.m_daysSpannedByDataArc;
	} //getDaysSpannedByDataArc

	public void setFirstObservationInOrbitalFit(String first) {
		this.m_firstObservationInOrbitalFit = first;
	} //setFirstObservationInOrbitalFit

	public String getFirstObservationInOrbitalFit() {
		return this.m_firstObservationInOrbitalFit;
	} //getFirstObservationInOrbitalFit

	public void setLastObservationInOrbitalFit(String last) {
		this.m_lastObservationInOrbitalFit = last;
	} //setLastObservationInOrbitalFit

	public String getLastObservationInOrbitalFit() {
		return this.m_lastObservationInOrbitalFit;
	} //getLastObservationInOrbitalFit

	public void setNumberObservationsInOrbitalFit(int observations) {
		this.m_numberObservationsInOrbitalFit = observations;
	} //setNumberObservationsInOrbitalFit

	public int getNumberObservationsInOrbitalFit() {
		return this.m_numberObservationsInOrbitalFit;
	} //getNumberObservationsInOrbitalFit

	public void setNumberDelayRadarObservationsInOrbitalFit(int delay) {
		this.m_numberDelayRadarObservationsInOrbitalFit = delay;
	} //setNumberDelayRadarObservationsInOrbitalFit

	public int getNumberDelayRadarObservationsInOrbitalFit() {
		return this.m_numberDelayRadarObservationsInOrbitalFit;
	} //getNumberDelayRadarObservationsInOrbitalFit

	public void setNumberDopplerRadarObservationsInOrbitalFit(int doppler) {
		this.m_numberDopplerRadarObservationsInOrbitalFit = doppler;
	} //setNumberDopplerRadarObservationsInOrbitalFit

	public int getNumberDopplerRadarObservationsInOrbitalFit() {
		return this.m_numberDopplerRadarObservationsInOrbitalFit;
	} //getNumberDopplerRadarObservationsInOrbitalFit

	public void setOrbitConditionCode(int code) {
		this.m_orbitConditionCode = code;
	} //setOrbitConditionCode

	public int getOrbitConditionCode() {
		return m_orbitConditionCode;
	} //getOrbitConditionCode

	public void setNormalizedRMSOfOrbitFit(double RMS) {
		this.m_normalizedRMSOfOrbitFit = RMS;
	} //setNormalizedRMSOfOrbitFit

	public double getNormalizedRMSOfOrbitFit() {
		return m_normalizedRMSOfOrbitFit;
	} //getNormalizedRMSOfOrbitFit



	////////////////////////////////////////////////////////////////////////////////////////
	//                                  OTHER FUNCTIONS                                   //
	////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("OBJECT FIELDS\n\n");

		sb.append("ID: ");
		sb.append(m_ID);
		sb.append("\n");

		sb.append("SPK ID: ");
		sb.append(m_spkID);
		sb.append("\n");

		sb.append("Full name: ");
		sb.append(m_fullName);
		sb.append("\n");

		sb.append("PDES: ");
		sb.append(m_PDES);
		sb.append("\n");

		sb.append("Name: ");
		sb.append(m_name);
		sb.append("\n");

		sb.append("Absolute magnitude: ");
		sb.append(m_absoluteMagnitude);
		sb.append("\n");

		sb.append("One-sigma uncertainty of absolute magnitude: ");
		sb.append(m_oneSigmaUncertaintyInAbsoluteMagnitude);
		sb.append("\n");

		sb.append("Magnitude slope parameter: ");
		sb.append(m_magnitudeSlopeParameter);
		sb.append("\n");

		sb.append("Diameter: ");
		sb.append(m_diameter);
		sb.append("\n");

		sb.append("One-sigma uncertainty of diameter: ");
		sb.append(m_oneSigmaUncertaintyInDiameter);
		sb.append("\n");

		sb.append("Extent: ");
		sb.append(m_extent);
		sb.append("\n");

		sb.append("Albedo: ");
		sb.append(m_albedo);
		sb.append("\n");

		sb.append("Rotation period: ");
		sb.append(m_rotationPeriod);
		sb.append("\n");

		sb.append("Color index BV: ");
		sb.append(m_colorIndexBV);
		sb.append("\n");

		sb.append("Color index UB: ");
		sb.append(m_colorIndexUB);
		sb.append("\n");

		sb.append("Spectral taxonomic type (SMASSII): ");
		sb.append(m_spectralTaxonomicTypeSMASSII);
		sb.append("\n");

		sb.append("Spectral taxonomic type (Tholen): ");
		sb.append(m_spectralTaxonomicTypeTholen);
		sb.append("\n\n");

		sb.append("OBJECT AND MODEL PARAMETER FIELDS\n\n");

		sb.append("Orbit solution ID: ");
		sb.append(m_orbitSolutionID);
		sb.append("\n");

		sb.append("Epoch of osculation JED: ");
		sb.append(m_epochOfOsculationJED);
		sb.append("\n");

		sb.append("Epoch of osculation MJD: ");
		sb.append(m_epochOfOsculationMJD);
		sb.append("\n");

		sb.append("Epoch of osculation ET: ");
		sb.append(m_epochOfOsculationET);
		sb.append("\n");

		sb.append("Equinox of reference frame: ");
		sb.append(m_equinoxOfReferenceFrame);
		sb.append("\n");

		sb.append("Eccentricity: ");
		sb.append(m_eccentricity);
		sb.append("\n");

		sb.append("One-sigma uncertainty of eccentricity: ");
		sb.append(m_oneSigmaUncertaintyEccentricity);
		sb.append("\n");

		sb.append("Semi-major axis: ");
		sb.append(m_semimajorAxis);
		sb.append("\n");

		sb.append("One-sigma uncertainty of semimajor axis: ");
		sb.append(m_oneSigmaUncertaintySemimajorAxis);
		sb.append("\n");

		sb.append("Perihelion distance: ");
		sb.append(m_perihelionDistance);
		sb.append("\n");

		sb.append("One-sigma uncertainty of perihelion distance (AU): ");
		sb.append(m_oneSigmaUncertaintyPerihelionDistanceAU);
		sb.append("\n");

		sb.append("Inclination: ");
		sb.append(m_inclination);
		sb.append("\n");

		sb.append("One-sigma uncertainty of inclination: ");
		sb.append(m_oneSigmaUncertaintyInclination);
		sb.append("\n");

		sb.append("Longitude of ascending node: ");
		sb.append(m_longitudeOfAscendingNode);
		sb.append("\n");

		sb.append("One-sigma uncertainty of longitude of ascending node: ");
		sb.append(m_oneSigmaUncertaintyLongitudeOfAscendingNode);
		sb.append("\n");

		sb.append("Argument of Perihelion: ");
		sb.append(m_argumentOfPerihelion);
		sb.append("\n");

		sb.append("One-sigma uncertainty of argument of perihelion: ");
		sb.append(m_oneSigmaUncertaintyArgumentOfPerihelion);
		sb.append("\n");

		sb.append("Mean anomaly: ");
		sb.append(m_meanAnomaly);
		sb.append("\n");

		sb.append("One-sigma uncertainty of mean anomaly: ");
		sb.append(m_oneSigmaUncertaintyMeanAnomaly);
		sb.append("\n");

		sb.append("Aphelion distance: ");
		sb.append(m_aphelionDistance);
		sb.append("\n");

		sb.append("One-sigma uncertainty of aphelion distance: ");
		sb.append(m_oneSigmaUncertaintyAphelionDistance);
		sb.append("\n");

		sb.append("Mean motion: ");
		sb.append(m_meanMotion);
		sb.append("\n");

		sb.append("One-sigma uncertainty of mean motion: ");
		sb.append(m_oneSigmaUncertaintyMeanMotion);
		sb.append("\n");

		sb.append("Time of perihelion passage JED: ");
		sb.append(m_timeOfPerihelionPassageJED);
		sb.append("\n");

		sb.append("Time of perihelion passage ET: ");
		sb.append(m_timeOfPerihelionPassageET);
		sb.append("\n");

		sb.append("One-sigma uncertainty of time of perihelion passage: ");
		sb.append(m_oneSigmaUncertaintyTimeOfPerihelionPassage);
		sb.append("\n");

		sb.append("Orbital period (days): ");
		sb.append(m_orbitalPeriodDays);
		sb.append("\n");

		sb.append("Orbital period (years): ");
		sb.append(m_orbitalPeriodYears);
		sb.append("\n");

		sb.append("One-sigma uncertainty of orbital period: ");
		sb.append(m_oneSigmaUncertaintyOrbitalPeriod);
		sb.append("\n");

		sb.append("Earth minimum orbit intersection distance (AU): ");
		sb.append(m_earthMinimumOrbitIntersectionDistanceAU);
		sb.append("\n");

		sb.append("Earth minimum orbit intersection distance (LD): ");
		sb.append(m_earthMinimumOrbitIntersectionDistanceLD);
		sb.append("\n");

		sb.append("Jupiter tisserand invariant: ");
		sb.append(m_jupiterTisserandInvariant);
		sb.append("\n");

		sb.append("Orbital classification: ");
		sb.append(m_orbitalClassification);
		sb.append("\n");

		sb.append("Producer: ");
		sb.append(m_producer);
		sb.append("\n");

		sb.append("Days spanned by data arc: ");
		sb.append(m_daysSpannedByDataArc);
		sb.append("\n");

		sb.append("First observation in orbital fit: ");
		sb.append(m_firstObservationInOrbitalFit);
		sb.append("\n");

		sb.append("Last observation in orbital fit: ");
		sb.append(m_lastObservationInOrbitalFit);
		sb.append("\n");

		sb.append("Number of observations in orbital fit: ");
		sb.append(m_numberObservationsInOrbitalFit);
		sb.append("\n");

		sb.append("Number of delay radar observations in orbital fit: ");
		sb.append(m_numberDelayRadarObservationsInOrbitalFit);
		sb.append("\n");

		sb.append("Number of doppler radar observations in orbital fit: ");
		sb.append(m_numberDopplerRadarObservationsInOrbitalFit);
		sb.append("\n");

		sb.append("Orbit condition code: ");
		sb.append(m_orbitConditionCode);
		sb.append("\n");

		sb.append("Normalized RMS of orbit fit: ");
		sb.append(m_normalizedRMSOfOrbitFit);
		sb.append("\n");

		return sb.toString();
	} //toString

} //Asteroid (class)