package analyser.types;


public abstract class AbstractAnalyser
{

	protected SymbolTable table;
	protected String[] reserved;
	protected String identifier = "";
  
  public AbstractAnalyser(String s)
  {
  	
  	table = new SymbolTable();
  	identifier = "";
  	
    analyse(s);
    
  }
  
  public void setReservedWords(String[] res)
  {
  	
  	reserved = res;
  	
  }
  
  protected abstract void analyse(String source);

}
