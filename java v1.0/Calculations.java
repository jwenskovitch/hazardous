import java.awt.*;

class Calculations {

    public static Polygon createPolygon(int height, int width, double rotation) {
        int xMin = (int)((0-width)/2), xMax = (int)(width/2), yMin = (int)((0-height)/2), yMax = (int)(height/2);

        int[] xPoints = {xMin, xMin, xMax, xMax};
        int[] yPoints = {yMin, yMax, yMax, yMin};

        for (int i = 0; i < 4; i++) {
            double xtemp = (xPoints[i] * Math.cos(toRadians(rotation))) - (yPoints[i] * Math.sin(toRadians(rotation)));
            double ytemp = (xPoints[i] * Math.sin(toRadians(rotation))) + (yPoints[i] * Math.cos(toRadians(rotation)));
            xPoints[i] = (int)xtemp;
            yPoints[i] = (int)ytemp;
        } //for

        return new Polygon(xPoints, yPoints, 4);
    } //createPolygon

    public static double toRadians(double input) {
		return ((input * Math.PI) / 180);
	} //toRadians

	public static double calculatePositionOnVisScale(double minData, double rangeData, double minVis, double rangeVis, double dataVal) {
		double distanceUpScale = (dataVal - minData) / rangeData;
		double distanceUpMappedScale = distanceUpScale * rangeVis;
		double returnVal = distanceUpMappedScale + minVis;
		return returnVal;
	} //calculatePositionOnVisScale

	public static double distanceFromClick(int mouseX, int mouseY, int pointX, int pointY) {
		return Math.sqrt((Math.pow((pointX - mouseX), 2)) + (Math.pow((pointY - mouseY), 2)));
	} //distanceFromClick

    public static Color HSVtoRGB(double hue, double saturation, double value) {
        double c = value * saturation;
        double h = hue / 60;
        double x = c * (1 - Math.abs((h % 2) - 1));

        double r, g, b;

        if ((h >= 0) && (h < 1)) {
            r = c;
            g = x;
            b = 0;
        } else if ((h >= 1) && (h < 2)) {
            r = x;
            g = c;
            b = 0;
        } else if ((h >= 2) && (h < 3)) {
            r = 0;
            g = c;
            b = x;
        } else if ((h >= 3) && (h < 4)) {
            r = 0;
            g = x;
            b = c;
        } else if ((h >= 4) && (h < 5)) {
            r = x;
            g = 0;
            b = c;
        } else if ((h >= 5) && (h < 6)) {
            r = x;
            g = 0;
            b = c;
        } else {
            r = 0;
            g = 0;
            b = 0;
        } //if-else

        double m = value - c;
        r += m;
        g += m;
        b += m;

        return new Color((int)r, (int)g, (int)b);
    } //HSVtoRGB

} //Calculations