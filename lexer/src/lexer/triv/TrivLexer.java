package lexer.triv;

import java.util.List;

import lexer.types.AbstractLexer;


public class TrivLexer extends AbstractLexer
{

  public TrivLexer(String source)
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
  		
  		if (lookup()) {
  			addToken();
  		}
  		
  		else if (Character.isWhitespace(currentChar)) {
  			addToken();
  		}
  		
  		else if (isOperator()) {
  			addToken();
  			addCharToken();
      }
  		
  		else if (Character.isLetter(currentChar)) {
    		addChar();
    		readIdentifier();
    		addToken();
  		}
  		
  		else if (Character.isDigit(currentChar)) {
    		addChar();
    		readInteger();
    		addToken();
  		}   	
    }
    
    addToken();   
    return tokens;
    
	}

}
