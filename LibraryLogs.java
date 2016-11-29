package pl.edu.agh.kis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class LibraryLogs implements Logs {

	private Statement[] ignoreStatement = new Statement[3];
	private List<ElementWithStat> listStatements = new ArrayList<ElementWithStat>();

	public void setIgnoreStatement(Statement[] statement) {
		ignoreStatement = statement;
	}

	private class ElementWithStat {
		Statement statement;
		String info;
		String dateBirthday;
		
		public ElementWithStat(Statement statement, String info) {
			this.statement = statement;
			this.info = info;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date date = new Date();
			dateBirthday = dateFormat.format(date);
		}

		public String toString() {
			return dateBirthday + " " + statement + ": " + info;
		}
		
		public Statement getStatement(){
			return statement;
		}
	}
	
	private ElementWithStat getInner(Statement statement, String info) {
		return new ElementWithStat(statement, info);
	}

	private void displayChoose(Statement choosen){
		for (ElementWithStat e : listStatements) {
			if (e.getStatement().equals(choosen)){
				System.out.println(e);
			}
		}
	}
	
	public void displayStatement() {
		displayChoose(Statement.ERROR);
		displayChoose(Statement.WARNING);
		displayChoose(Statement.INFO);
	}
	
	private boolean checkOutList(Statement statement) {
		for (Statement stat : ignoreStatement){
			if (stat.equals(statement)){
				System.out.println("Ten komunikat jest ignorowany");
				return false;
			}
		}
		return true;
	}

	public void addError(String info){
		addStatement(Statement.ERROR, info);
	}
	
	public void addWarning(String info){
		addStatement(Statement.WARNING, info);
	}
	
	public void addInfo(String info){
		addStatement(Statement.INFO, info);
	}
	
	private void addStatement(Statement statement, String info) {
		if (checkOutList(statement)) {
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
		 finally{
			 clear();
		 }
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

	public void clear(){
		listStatements.clear();	
		System.out.println("Wyczyszono bufor z informacji");
	}		
	
	public static void main(String[] args) {
		LibraryLogs library = new LibraryLogs();
		Statement[] ignoreStat = new Statement[2];
		ignoreStat[0] = Statement.INFO;
		ignoreStat[1] = Statement.WARNING;
		
		library.setIgnoreStatement(ignoreStat);
		library.addWarning("Wywalam error");
		try{
			//arg w milisekundach
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		library.addError("Wywalam error");
		library.addInfo( "NIE Wywalam info");
		library.writeStatementToFile();
		library.displayStatement();
		
	}

}
