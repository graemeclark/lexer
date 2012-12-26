package analyser.types;

public abstract class AbstractAnalyser
{
  
  
  
  final String[] reserved;
  final String[] tokens;
  
  public AbstractAnalyser(String source, String[] res)
  {
    
    reserved = res;
    tokens = source.trim().split(" ");
    for (int i = 0; i < tokens.length; i++)
      System.out.println(tokens[i]);
    
  }
  
  public abstract String whitespace(String source);
  
  public abstract void comment();
  
  public abstract void alphaNum();
  
  public abstract void number();
  
  public abstract void doubleQuote();
  
  public abstract void singleQuote();

}
