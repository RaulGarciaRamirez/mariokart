
public class Kart {
	
	private String driver;
	private int speed, acceleration, position;
	private double random = Math.random();
	private static final int MAX_POINTS = 18;
	private static final int MAX_RANDOM = 6;
	
	public Kart(String driver) {
		super();
		this.driver = driver;
		this.init();
	}
	
	private void init() {
		this.position = 0;
		this.speed = (int) (random * MAX_POINTS);
		this.acceleration = MAX_POINTS - speed;
	}
	
	public int move() {
		return speed + acceleration + (int) (random * MAX_RANDOM);
	}

	public String getDriver() {
		return driver;
	}

	public int getSpeed() {
		return speed;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public int getPosition() {
		return position;
	}

	public double getRandom() {
		return random;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setRandom(double random) {
		this.random = random;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Kart [driver=");
		builder.append(driver);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", acceleration=");
		builder.append(acceleration);
		builder.append("]");
		return builder.toString();
	}
}
