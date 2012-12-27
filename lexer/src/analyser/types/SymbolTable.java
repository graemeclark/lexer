package analyser.types;

import java.util.Map;
import java.util.HashMap;

public class SymbolTable
{
	
	Map<String, Object> table = new HashMap<String, Object>();
	
	
	public void put(String key, Object val)
	{
		
		table.put(key, val);
	
	}
	
	public Object get(String key)
	{
		
		return table.get(key);
		
	}

}
