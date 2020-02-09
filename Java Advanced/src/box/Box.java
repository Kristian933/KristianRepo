package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        zeroOrNegativeCheck(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        zeroOrNegativeCheck(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        zeroOrNegativeCheck(height, "Height");
        this.height = height;
    }

    private void zeroOrNegativeCheck(double dimension, String parameter) {
        if (dimension <= 0) {
            throw new IllegalArgumentException
                    (parameter + " cannot be zero or negative.");
        }
    }


    public double calculateSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.width + calculateSurfaceArea();
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }


}
