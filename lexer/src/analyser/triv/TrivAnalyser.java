package analyser.triv;

import java.util.List;

import analyser.types.AbstractAnalyser;

public class TrivAnalyser extends AbstractAnalyser
{

  public TrivAnalyser(String source)
  {
    
    super(source);
    
    String[] res = {"let", "in"};
    super.setReservedWords(res);
    
  }
  
  @Override
	public List<String> analyse(String source)
	{
  	
    while (charIndex < source.length()) {
    	
  		nextChar();
  		
  		if (lookup().equals("RESERVED")) {
  			addToken();
  		}
  		
  		else if (Character.isWhitespace(currentChar)) {
  			addToken();
  		}
  		
  		else if (isOperator()) {
  			addToken();
  			addCharToken();
      }
  		
  		else {
    		addChar();
  		}
    	
    }
    
    addToken();   
    return tokens;
    
	}
	
  @Override
	protected void addToken()
	{
		
		if (!lexeme.trim().equals("")) {
			tokens.add(lexeme.trim());
			lexeme = "";			
		}
		
	}
	
  @Override
	protected boolean isOperator()
	{
		
		switch(currentChar) {
		
		  case '=' : return true;
		  case '+' : return true;
		  default  : return false;
		
		}
		
	}

}
