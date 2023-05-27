import data.Data;
import data.OutOfRangeSampleSize;
import mining.KMeansMiner;
import static keyboardinput.Keyboard.*;

public class MainTest {
	public static void main(String[] args) {
	
		Data data = new Data();
		System.out.println(data);

		char c;
		int numIter = 0;
		do {
			System.out.print("Inserisci il numero di cluster desiderati: ");
			int k = readInt();
			KMeansMiner kmeans = new KMeansMiner(k);
			try {
				numIter = kmeans.kmeans(data);
			} catch(OutOfRangeSampleSize e) {
				System.out.println(e);
			}
			System.out.println("Numero di Iterazioni eseguite: " + numIter);
			System.out.println(kmeans.getC().toString(data));

			System.out.println("Vuoi continuare? (y/n)");
			c = readChar();
		} while(c == 'y');
	}
}
