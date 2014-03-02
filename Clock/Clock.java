public class Clock {
	
  private double seconds;
  private double slice;
	
  // public constructor
	public Clock ( double seconds, double slice ) {

    this.seconds = seconds;
    this.slice = slice;
    }

    public void tick() {

      this.seconds = this.seconds + this.slice;
    }

    public int hours() {

      return (int)Math.floor(this.seconds / 3600);
    }

    public int getSeconds() {

      return (int)Math.floor(this.seconds);
    }

    public String toString() {

      int hours = (int)Math.floor(this.seconds / 3600);
      int remainder = (int)Math.floor(this.seconds % 3600);
      int minutes = (int)Math.floor(remainder / 60);
      double seconds = Math.floor(remainder % 60);

    return String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
    }
}