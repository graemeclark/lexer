package analyser.triv;

import analyser.types.AbstractAnalyser;

public class TrivAnalyser extends AbstractAnalyser
{

  public TrivAnalyser(String source)
  {
    
    super(source);
    
  }

	@Override
	protected void analyse(String source)
	{
		
  	int i = 0;
  	
    while (i < source.length()) {
    	
    	char c = source.charAt(i);
    	
    	if (!Character.isWhitespace(c)) {
    	
    		if (Character.isLetter(c)) {
    			
    			identifier = identifier + c;
    			i++;
    			
    		}
    		else break;
    		
    	}
    }
    System.out.println(identifier);
	}

}
