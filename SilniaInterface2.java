import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 
 * @author Alek Lisiecki
 * @version 1.3 i pewnie nie ostatnia :(
 */
/**
 * prosty (mam nadizeje minimalistyczny) interfejs liczacy dla silni
 */
interface SzklanaPulapka {
	// zakomentowalem zbedne metody
	/**
	 * ta metoda ma dokonac obliczen
	 */
	void przejdzPoKolejceLiczac();

	// void licz(Integer agrument);

	// void dodajDoKolejkiObliczen(Integer argument);

	// void dodajPare(Integer argument, BigInteger wynik);
	/**
	 * metoda sprawdza czy dla liczb argument silnia jest juz policzona
	 * 
	 * @param argument
	 *            argument szukany
	 * @return true jesli dla liczb argument jest juz policzona, a jak nie to
	 *         zwraca false
	 */
	boolean czyZawiera(Integer argument);

	/**
	 * czysci kolejke do obliczenjaby ktos sie rozmyslil i jednak nie chcial
	 * liczyc dla elementow w kolejce...
	 */
	void wyczyscKolejke();

	/**
	 * czysci juz policzone wyniki
	 */
	void wyczyscBuforek();

	/**
	 * wypisuje pary argument, wartosc gdzie wartosc jest rowna argument!
	 * (silnia)
	 */
	void wypiszBuforek();

	// void wypiszKolejke();
	/**
	 * @param sciezkaDostepu
	 *            to lokalizacja pliku w którym są argumenty do policzenia
	 *            oddzielone spacjami lub enterami
	 */
	void wczytajLiczbyZPliku(String sciezkaDostepu);

	// void dodajLinieLiczb(String linia);
}

/**
 * klasa Silnia jest implementacja interfejsu liczacego
 */
class Silnia implements SzklanaPulapka {
	/**
	 * buforek ma przechowywac pary argument, wartosc gdzie wartosc jest rowna
	 * argument! (silnia) kolejkaObliczen ma za zadanie przechowywac tymczasowo
	 * liczby do policzenia
	 */
	int maxSizeOfBuforek = 5;
	TreeMap<Integer, BigInteger> buforek = new TreeMap<Integer, BigInteger>();
	LinkedList<Integer> kolejkaObliczen = new LinkedList<Integer>();
	LinkedList<Integer> wiekElementow = new LinkedList<Integer>();


	/**
	 * funkcja pomocnicza dostaje string liczb typu int oddzielony spacjami i
	 * dodaje je kolejno do kolejkiObliczen
	 * 
	 * @param linia
	 *            string liczb typu int oddzielony spacjami
	 */
	public void dodajLinieLiczb(String linia) {
		String[] liczbyStr = linia.split(" +");
		Integer liczbaDodawnaInt;
		for (int i = 0; i < liczbyStr.length; i++) {
			liczbaDodawnaInt = new Integer(liczbyStr[i]);
			dodajDoKolejkiObliczen(liczbaDodawnaInt);
		}
	}
	public void usunNajstarszeElementy(){
		{
			int i = wiekElementow.removeLast();
		buforek.remove(i);
		System.out.println("usuwam: " + i);
		}
	}
	/**
	 * @see SzklanaPulapka#wczytajLiczbyZPliku(String sciezkaDostepu)
	 */
	public void wczytajLiczbyZPliku(String sciezkaDostepu) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(sciezkaDostepu));
			String linia = br.readLine();
			while (linia != null) {
				dodajLinieLiczb(linia);
				linia = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("moze dodaj ten plik");
		}
	}

	/**
	 * funkcja dodaje liczbe calkawita do kolejkiObliczen
	 * 
	 * @param argument
	 *            - wartosc dodawana
	 */
	public void dodajDoKolejkiObliczen(Integer argument) {
		kolejkaObliczen.add(argument);
		wiekElementow.addFirst(argument);
		System.out.println("dodaje: " + argument);
		if (wiekElementow.size() > maxSizeOfBuforek){
			usunNajstarszeElementy();
		}
	}

	/**
	 * @see SzklanaPulapka#czyZawiera
	 */
	public boolean czyZawiera(Integer argument) {
		if (buforek.containsKey(argument)) {
			return true;
		}
		return false;
	}

	/**
	 * @see SzklanaPulapka#wyczyscKolejke()
	 */
	public void wyczyscKolejke() {
		kolejkaObliczen.clear();
	}

	/**
	 * @see SzklanaPulapka#wyczyscBuforek()
	 */
	public void wyczyscBuforek() {
		buforek.clear();
	}

	/**
	 * @param argument
	 *            szukana liczba jako argument w buforku
	 * @return argument! (silnia)
	 */
	public BigInteger znajdzWartosc(Integer argument) {
		if (!buforek.containsKey(argument)) {
			throw new RuntimeException("potrzebujemy wiekszej łodzi");
		}
		BigInteger wynik = buforek.get(argument);
		return wynik;
	}

	/**
	 * @see SzklanaPulapka#przejdzPoKolejceLiczac()
	 */
	public void przejdzPoKolejceLiczac() {
		Collections.sort(kolejkaObliczen);
		ListIterator<Integer> listIterator = kolejkaObliczen.listIterator();
		while (listIterator.hasNext()) {
			licz(listIterator.next());
		}
	}

	/**
	 * liczy silnie dla pojedynczego argumentu i dodaje og do buforka
	 * 
	 * @param agrument
	 *            dla nigo liczy silnie
	 */
	public void licz(Integer agrument) {

		if (!buforek.containsKey(agrument)) {
			BigInteger wynik = new BigInteger("1");
			for (int i = 2; i <= agrument; i++) {
				wynik = wynik.multiply(new BigInteger("" + i));
			}
			dodajPare(agrument, wynik);
		}
	}

	/**
	 * @see SzklanaPulapka#wypiszBuforek()
	 */
	public void wypiszBuforek() {
		System.out.println(buforek);
	}

	/**
	 * wypoisuje kolejke obliczen
	 */
	public void wypiszKolejke() {
		System.out.println(kolejkaObliczen);
	}

	/**
	 * f dodaje pare do drzewa buforek
	 * 
	 * @param argument
	 *            klucz dodawny
	 * @param wynik
	 *            wartosc do klucza
	 */
	public void dodajPare(Integer argument, BigInteger wynik) {
		buforek.put(argument, wynik);
	}

}

public class SilniaInterface {
	public static void main(String[] args) {
		SzklanaPulapka[] szklanka = { new Silnia() };

		szklanka[0].wczytajLiczbyZPliku("C:\\Users\\Admin\\workspace\\SilniaInterface\\src\\przykladoweLiczby.txt");
		// tu wpisz sciezke do przykladowego pliku wersja dla windowsa
		// w tym pliku sa liczby typu int oddzielone spacjami i enterami
		szklanka[0].wypiszBuforek();
		szklanka[0].przejdzPoKolejceLiczac();
		szklanka[0].wypiszBuforek();
	}
}
