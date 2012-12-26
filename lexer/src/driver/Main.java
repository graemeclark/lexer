package driver;

import analyser.triv.TrivAnalyser;

public class Main
{

  public static void main(String[] args)
  {
    
    String source = "let \n x = 3 in";
    
    String[] res = null;
    
    TrivAnalyser t = new TrivAnalyser(source, res);
    
  }

}
