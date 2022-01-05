package mapreader;
import java.util.Map;
import java.util.HashMap;
import customexception.CustomException;
public class MapReader
{
public void checkMap(Map<Object,Object> map)throws CustomException
{
if(map==null)
{
throw new  CustomException("Map cannot be null");
}
}
public Map<Object,Object> createMap()
{
Map<Object,Object> map=new HashMap<>();
return map;
}
public int length(Map<Object,Object> map)throws CustomException
{
checkMap(map);
return map.size();
}
public Map<Object,Object> addObjects(Map<Object,Object> map, Object objectKey,Object objectValue)throws CustomException
{
checkMap(map);
map.put(objectKey,objectValue);
return map;
}
public boolean checkKey(Map<Object,Object> map,Object key)throws CustomException
{
checkMap(map);
return map.containsKey(key);
}
public boolean checkValue(Map<Object,Object> map,Object value)throws CustomException
{
checkMap(map);
return map.containsValue(value);
}
public Map<Object,Object> changeValues(Map<Object,Object> map, Object objectKey, Object oldValue, Object newValue)throws CustomException
{
checkMap(map);
map.replace(objectKey,oldValue,newValue);
return map;
}
public Object getValue(Map<Object,Object> map, Object inputKey)throws CustomException
{
checkMap(map);
return map.get(inputKey);
}
public Object defaultValue(Map<Object,Object> map, Object objectKey, Object fixValue)throws CustomException
{
checkMap(map);
return map.getOrDefault(objectKey,fixValue);
}
public Map<Object,Object> removeKey(Map<Object,Object> map, Object keyRemove)throws CustomException
{
checkMap(map);
map.remove(keyRemove);
return map;
}
public boolean removeValueMatches(Map<Object,Object> map, Object key,Object value)throws CustomException
{
checkMap(map);
return map.remove(key,value);
}
public Map<Object,Object> replaceValueMatches(Map<Object,Object> map, Object key,Object value)throws CustomException
{
checkMap(map);
map.replace(key,value);
return map;
}
public Map<Object,Object> replaceMap(Map<Object,Object> map1, Map<Object,Object> map2)throws CustomException
{
checkMap(map1);
checkMap(map2);
map1.putAll(map2);
return map1;
}
public void removeAll(Map<Object,Object> map)throws CustomException
{
checkMap(map);
map.clear();
}
}


