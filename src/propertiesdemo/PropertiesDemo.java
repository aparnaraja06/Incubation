import java.util.Properties;
import createfile.CreateFile;
package propertiesdemo;

public class PropertiesDemo {
public Properties createProperties() 
{
	Properties properties=new Properties();
	return properties;
}
public Properties setValues(Properties properties, String key,String value)
{
	return properties.setProperty(key, value);
}
public void loadAll(Properties properties,File propFile)
{
	properties.load(reader);
}
public void storeAll(Properties properties,File propFile)
{
	properties.store(propFile,"Writing properties to file");
}
public void display(Properties properties,Writer writer)
{
	properties.list(writer);
}

}
