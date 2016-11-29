package pl.edu.agh.kis;

public interface Logs {
	public enum Statement{
		ERROR, INFO, WARNING;
	}
	public void setIgnoreStatement(Statement statement);
	public void displayStatement();
	public void writeStatementToFile();
	public void readStatementFromFile();
	
}
