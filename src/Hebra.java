
/*
 * public class Hebra extends Thread{ public void contador() { for (int i = 0; i
 * < 1000; i++) { System.out.println(this.getName() + "-> " + i); // Devuelve el
 * objeto de la clase } }
 * 
 * 
 * public static void main (String[] args) { int numeroHebras = 50; for (int i =
 * 0; i < numeroHebras; i++) { Hebra hebra = new Hebra(); hebra.setName("Hebra"
 * + i); hebra.contador(); } System.out.println("Creadas las hebras"); }
 * 
 * }
 */

public class Hebra extends Thread {
	
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.getName() + " -> " + i);
		}
	}
	public static void main(String[] args) {
		int numeroHebras =50;
		for (int i = 0; i < numeroHebras; i++) {
			Hebra hebra = new Hebra();
			hebra.setName("Hebra " + i);
			hebra.start();
			
		}	
		System.out.println("Creadas las hebras");
	}
	
}

