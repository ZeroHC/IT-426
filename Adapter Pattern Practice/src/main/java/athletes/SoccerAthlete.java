package athletes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SoccerAthlete 
{
	//track the name and stats for a soccer athlete
	private String fullName;
	private Map<String, Object> stats = new HashMap<String, Object>();
	
	public SoccerAthlete(String fullName)
	{
		this.fullName = fullName;
	}
	
	public void addStatLine(String type, Object value)
	{
		stats.put(type, value);
	}
	
	public Map<String, Object> getStats()
	{
		return Collections.unmodifiableMap(stats);
	}
	
	public String getFullName()
	{
		return fullName;
	}
}
