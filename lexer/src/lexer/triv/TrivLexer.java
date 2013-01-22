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
  		
  		if (isReserved()) {
  			addToken();
  		}
  		
  		else if (isBoolean()) {
  			addToken();
  		}
  		
  		else if (Character.isWhitespace(currentChar)) {
  			addToken();
  		}
  		
  		else if (isOperator()) {
  			addToken();
  			addCharToken();
      }
  		
  		else if (currentChar == '"') {
  			readString();
  		}
  		
  		else if (Character.isLetter(currentChar)) {
    		readIdentifier();
  		}
  		
  		else if (Character.isDigit(currentChar)) {
    		readInteger();
  		}   	
    }
    
    addToken();   
    return tokens;
    
	}

}
