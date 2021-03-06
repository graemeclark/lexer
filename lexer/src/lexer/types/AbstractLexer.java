package lexer.types;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLexer
{

	protected Integer charIndex, charNumber, lineNumber;
	protected Character currentChar;
	protected String source, lexeme;
	protected String[] reserved;
	protected List<String> tokens;
  
  public AbstractLexer(String s)
  {
  	
  	charIndex       = 0;
  	charNumber      = 1;
  	lineNumber      = 1;
  	currentChar     = null;
  	source          = s;
  	lexeme          = "";
  	tokens          = new ArrayList<String>();
    
  }
  
  public abstract List<String> analyse(String source);
  
	protected boolean isOperator()
	{
		
		switch(currentChar) {		
		  case '=' : return true;
		  case '+' : return true;
		  case '*' : return true;
		  case '/' : return true;
		  case '-' : return true;
		  default  : return false;		
		}
		
	}
	
	protected boolean isBoolean()
	{
		
		return (lexeme.equals("true") || lexeme.equals("false"));
		
	}
	
	protected void readString()
	{
		
		addChar();
		
		while (charIndex < source.length()) {
			nextChar();
			if (currentChar == '"') {
				addChar();
				break;				
			}
			else addChar();			
		}
		
		addToken();		
		
	}
  
  protected void readIdentifier()
	{
  	
  	addChar();
		
  	while (charIndex < source.length()) {  		
  		nextChar();  		
  		if (Character.isLetter(currentChar) || Character.isDigit(currentChar)) { 			
  			addChar(); 			
  		}  		
  		else break;
  	}
  	
  	addToken();
		
	}
  
  protected void readInteger()
	{
  	
  	addChar();
  	
  	while (charIndex < source.length()) {  		
  		nextChar(); 		
  		if (Character.isDigit(currentChar)) {  			
  			addChar();  			
  		}  		
  		else if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar)) { 			
  			error("Can't start an identifier with an integer.");	
  		}  		
  		else break;  		
  	}
  	
  	addToken();
		
	}
  
	protected void addToken()
	{
		
		if (!lexeme.trim().equals("")) {
			tokens.add(lexeme.trim());
			lexeme = "";			
		}
		
	}
	
	protected void error(String msg)
	{
		
		msg = msg + "\n" + "on line " + lineNumber + " at character " + charNumber;
		System.out.println(msg);
		System.exit(0);
		
	}
	
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
  
  protected boolean isReserved()
  {
  	
  	boolean res = false;
  	
  	for (int i = 0; i < reserved.length; i++) {
  		if (lexeme.equals(reserved[i])) {
  			res = true;
  		  break;
  		}
  	}
  	
  	return res;
  	
  }

}
