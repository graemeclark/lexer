package driver;

import analyser.triv.TrivAnalyser;

public class Main
{

  public static void main(String[] args)
  {
    
    String source = "let x = 3 in";
    
    TrivAnalyser t = new TrivAnalyser(source);
    
  }

}
