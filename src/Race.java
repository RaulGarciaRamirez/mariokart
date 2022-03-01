import java.util.List;

public class Race {

	private String name;
	private Circuit circuit;
	private List<Kart> karts;
	private List<Kart> finishedKarts;

	public Race(String name) {
		super();
		this.name = name;
	}

	public void run() {
		while (notAllFinished()) {
			for (Kart k : karts) {
				if (k != null) {
					moveKart(k);
				}
				if (isFinished(k)) {
					moveToFinished(k);
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
		sb.append(circuit.toString());
		for (Kart k : finishedKarts) {
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
		sb.append(circuit.toString());
		for (Kart k : karts) {
			sb.append(k.toString());
		}
		return sb.toString();
	}
}
