package pl.edu.agh.kis;

public interface Logs {
	public enum Statement{
		ERROR, INFO, WARNING;
	}
	public void setIgnoreStatement(Statement statement);
	public void displayStatement();
	public void writeStatementToFile();
	public void readStatementFromFile();
	public void addStatement(Statement statement, String info);
	public void clear();
}
