package driver;

import analyser.triv.TrivLexer;
import analyser.types.AbstractLexer;

public class Main
{

  public static void main(String[] args)
  {
    
    String source = "let var = 3 in var + var";
    
    AbstractLexer t = new TrivLexer(source);
    System.out.println(t.analyse(source));
    
  }

}
