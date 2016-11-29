package pl.edu.agh.kis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogs implements Logs {

	Statement ignoreStatement;
	List<ElementWithStat> listStatements = new ArrayList<ElementWithStat>();

	LibraryLogs(Statement statement) {
		ignoreStatement = statement;
	}

	class ElementWithStat {
		Statement statement;
		String info;

		public ElementWithStat(Statement statement, String info) {
			this.statement = statement;
			this.info = info;
		}

		public String toString() {
			return statement + ": " + info;
		}
	}

	ElementWithStat getInner(Statement statement, String info) {
		return new ElementWithStat(statement, info);
	}

	public void displayStatement() {
		for (ElementWithStat e : listStatements) {
			System.out.println(e);
		}
	}

	public boolean checkOutList(Statement statement, String info) {
		if (statement.equals(ignoreStatement)) {
			System.out.println("Ten komunikat jest ignorowany");
			return false;
		}
		return true;
	}

	public void addToList(Statement statement, String info) {
		if (checkOutList(statement, info)) {
			listStatements.add(getInner(statement, info));
		}
	}

	public void writeStatementToFile() {

		try {
			PrintWriter out = new PrintWriter("statement.txt");
			for (ElementWithStat e : listStatements) {
				out.println(e);
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// finally{
		// out.close();
		// }
	}

	public void readStatementFromFile() {
		FileReader fr = null;
		String line = "";

		try {
			fr = new FileReader("statement.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(fr);

		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
