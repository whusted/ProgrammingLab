public class Flagpole {

  private double x_coordinate;
  private double y_coordinate;

  public Flagpole (double x_coordinate, double y_coordinate) {
    this.x_coordinate = x_coordinate;
    this.y_coordinate = y_coordinate;
  }

  public String getLocation() {

    return "(" + String.valueOf(this.x_coordinate) + "," + String.valueOf(this.y_coordinate) + ")";
  }

  public double getX_Coordinate() {
    return this.x_coordinate;
  }

  public double getY_Coordinate() {
    return this.y_coordinate;
  }

  public String toString() {
    return String.format("Flagpole at position (%g, %g)", x_coordinate, y_coordinate);
  }
}