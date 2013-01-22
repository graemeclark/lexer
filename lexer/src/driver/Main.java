package driver;

import lexer.triv.TrivLexer;
import lexer.types.AbstractLexer;

public class Main
{

  public static void main(String[] args)
  {
    
    String source = "let var = \"hello\" in var + var";
    
    AbstractLexer t = new TrivLexer(source);
    System.out.println(t.analyse(source));
    
  }

}
