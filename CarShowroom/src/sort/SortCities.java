package sort;

import java.util.Comparator;
import java.util.Map;

public class SortCities implements Comparator<String>{
	
	Map<String,Integer> tempMap;
	
	public SortCities(Map<String,Integer> assignMap)
	{
		this.tempMap=assignMap;
	}

	@Override
	public int compare(String city1, String city2) {
		
		int cityCompare = tempMap.get(city2).compareTo(tempMap.get(city1));
		
		int valueCompare=city1.compareTo(city2);
		
		if(cityCompare==0)
		{
			return valueCompare;
		}
		
		return cityCompare;
		
	}
	

}
