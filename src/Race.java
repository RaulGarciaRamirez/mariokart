import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {

	private String name;
	private Circuit circuit;
	private List<Kart> karts;
	private List<Kart> finishedKarts;

	public Race(String name) {
		super();
		this.name = name;
		karts = new ArrayList<Kart>();
		finishedKarts = new ArrayList<Kart>();
	}

	public void run() {
		while (notAllFinished()) {
			Iterator<Kart> it = karts.iterator();
			if (it.hasNext()) {
				Kart temp = it.next();
				moveKart(temp);
				if (isFinished(temp)) {
					moveToFinished(temp);
				}
			}
		}
	}

	private boolean notAllFinished() {
		boolean resultado = false;

		for (Kart k : karts) {
			if (k != null) {
				resultado = true;
			}
		}

		return resultado;
	}

	private void moveKart(Kart kart) {
		int movedPositions = 0;
		movedPositions = kart.move() - circuit.difficulty();
		kart.setPosition(kart.getPosition() + movedPositions);
	}

	private boolean isFinished(Kart kart) {
		if (kart.getPosition() >= circuit.getDistance()) {
			return true;
		}
		return false;
	}

	private void moveToFinished(Kart kart) {
		finishedKarts.add(kart);
		karts.remove(karts.indexOf(kart));
	}

	public String showResult() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carrera ");
		sb.append(name);
		sb.append("\n");
		sb.append(circuit.toString());
		for (Kart k : finishedKarts) {
			sb.append("\n");
			sb.append(k.toString());
		}
		return sb.toString();
	}

	public void addKart(Kart kart) {
		karts.add(kart);
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Carrera ");
		sb.append(name);
		sb.append("\n");
		sb.append(circuit.toString());
		for (Kart k : karts) {
			sb.append("\n");
			sb.append(k.toString());
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public List<Kart> getKarts() {
		return karts;
	}

	public List<Kart> getFinishedKarts() {
		return finishedKarts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKarts(List<Kart> karts) {
		this.karts = karts;
	}

	public void setFinishedKarts(List<Kart> finishedKarts) {
		this.finishedKarts = finishedKarts;
	}
}
