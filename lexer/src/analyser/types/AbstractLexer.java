package analyser.types;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLexer
{

	protected Integer charIndex;
	protected Character currentChar;
	protected String source, lexeme;
	protected String[] reserved;
	protected List<String> tokens;
  
  public AbstractLexer(String s)
  {
  	
  	charIndex       = 0;
  	currentChar     = null;
  	source          = s;
  	lexeme          = "";
  	tokens          = new ArrayList<String>();
    
  }
  
  protected abstract void addToken();
  
  public abstract List<String> analyse(String source);
  
  protected abstract boolean isOperator();
  
	
	protected void addCharToken()
	{
		
		tokens.add(Character.toString(currentChar));
		
	}
  
  public void setReservedWords(String[] res)
  {
  	
  	reserved = res;
  	
  }
  
  protected void nextChar()
  {
  	
  	currentChar = source.charAt(charIndex++);
  	
  }
  
  protected void addChar()
  {

 		lexeme = lexeme + currentChar;
  	
  }
  
  protected String lookup()
  {
  	
  	String word = "";
  	
  	for (int i = 0; i < reserved.length; i++) {
  		if (lexeme.equals(reserved[i])) {
  			word = "RESERVED";
  		  break;
  		}
  	}
  	
  	return word;
  	
  }

}
