package analyser.triv;

import analyser.types.AbstractAnalyser;

public class TrivAnalyser extends AbstractAnalyser
{

  public TrivAnalyser(String source, String[] res)
  {
    
    super(source, res);
    
  }

  public String whitespace(String source)
  {
    
    return source.trim();
    
  }

  public void comment()
  {
    
  }

  public void alphaNum()
  {
    
  }

  public void number()
  {
    
  }

  public void doubleQuote()
  {
    
  }

  public void singleQuote()
  {
    
  }

}
