package driver;

import analyser.triv.TrivAnalyser;

public class Main
{

  public static void main(String[] args)
  {
    
    String source = "let var = 3 in var + var";
    
    TrivAnalyser t = new TrivAnalyser(source);
    System.out.println(t.analyse(source));
    
  }

}
