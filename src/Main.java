
public class Main {

	public static void main(String[] args) {
		Race r = new Race("Super cup");
		r.addKart(new Kart("Mario"));
		r.addKart(new Kart("Luigi"));
		r.addKart(new Kart("Bowser"));
		Circuit c = new Circuit("Mina de Wario", 100);
		r.setCircuit(c);
		System.out.println("**** Init Super Mario Kart ****");
		System.out.println(r.toString());
		r.run();
		System.out.println("**** Game Over ****");
		System.out.println(r.showResult());
	}

}
