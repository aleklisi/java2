package pl.edu.agh.kis;

public interface Logs {
	public enum Statement{
		ERROR, INFO, WARNING;
	}
	public boolean checkOutList(Statement statement, String info);
	public void displayStatement();
	public void writeStatementToFile();
	public void readStatementFromFile();
	
}
