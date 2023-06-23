import data.Data;
import data.OutOfRangeSampleSize;
import mining.KMeansMiner;
import static keyboardinput.Keyboard.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainTest {
	public static void main(String[] args) {
	
		Data data = new Data();
		System.out.println(data);

		char c;
		int numIter = 0;
		char scelta;

		do {

			System.out.print("Vuoi caricare il file dell'ultimo risultato o inizializzarlo? (c/i) ");
			scelta = readChar();

			switch(scelta) {

				case 'c':
					try {
							KMeansMiner kmeans = new KMeansMiner("data.txt");
							System.out.println(kmeans.getC().toString(data));
					} catch (FileNotFoundException fl) {
							System.out.println(fl);
					} catch (IOException io) {
							System.out.println(io);
					} catch (ClassNotFoundException io) {
							System.out.println(io);
					}
					break;
				
				case 'i':
					System.out.print("Inserisci il numero di cluster desiderati: ");
					int k = readInt();
					KMeansMiner kmeans = new KMeansMiner(k);
					try {
						numIter = kmeans.kmeans(data);
					} catch(OutOfRangeSampleSize e) {
						System.out.println(e.getMessage()); //cambiato perché eliminato il toString
					}
					if (numIter != 0) { //aggiunto controllo su numIter, se chiamata l'eccezione non stampa il numero di iterazioni né salva il file
						System.out.println("Numero di Iterazioni eseguite: " + numIter);
						System.out.println(kmeans.getC().toString(data));
						try {
							kmeans.salva("data.txt");
						} catch(FileNotFoundException f) {
							System.out.println(f);
						} catch(IOException io) {
							System.out.println(io);
						}
					}
					break;
				
				default:
					System.out.println("Carattere non valido");
					break;
				
			}

			do {

				System.out.println("Vuoi continuare? (y/n)");
				c = readChar();
				if (c != 'y' && c != 'n') {
					System.out.println("Carattere non valido");
				}

			} while(c != 'y' && c != 'n');

		} while(c == 'y');

	}
	
}
