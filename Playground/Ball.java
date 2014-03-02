public class Ball {

  private double x_coordinate;
  private double y_coordinate;
  private double horizontal_speed;
  private double vertical_speed;
  private double slice;

  // public constructor
  public Ball ( double x_coordinate, double y_coordinate, double horizontal_speed, double vertical_speed ) {
    this.x_coordinate = x_coordinate;
    this.y_coordinate = y_coordinate;
    this.horizontal_speed = horizontal_speed;
    this.vertical_speed = vertical_speed;
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
    return String.format("Ball at (%g, %g) going <%g, %g>", x_coordinate, y_coordinate, horizontal_speed, vertical_speed);
  }

  public void updatePositionX( double slice ) {
    this.x_coordinate = this.x_coordinate + (this.horizontal_speed * slice);
    
  }

  public void updatePositionY( double slice ) {
    this.y_coordinate = this.y_coordinate + (this.vertical_speed * slice);
  }
  
}