package maprunner;
import mapreader.MapReader;
import java.util.Map;
import customexception.CustomException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
public class MapRunner{
public static void main(String[] args)
{
Scanner scanner=new Scanner(System.in);
MapReader mapread=new MapReader();
int option=0;
try
{
System.out.println("Enter the number between 1-20");
option=scanner.nextInt();
scanner.nextLine();
}
catch(Exception e){
System.out.println("You have entered string in place of integer");
}
switch(option)
{
case 1:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap)
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
break;
}
case 2:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of Strings to add");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string");
String strKey=scanner.nextLine();
System.out.println("Enter the value string");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 3:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of Integer to add");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key integer");
int intKey=scanner.nextInt();
System.out.println("Enter the value integer");
int intValue=scanner.nextInt();
mapread.addObjects(newMap,intKey,intValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 4:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the string");
String strKey=scanner.nextLine();
System.out.println("Enter the integer");
int intValue=scanner.nextInt();
scanner.nextLine();
mapread.addObjects(newMap,strKey,intValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 5:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number= scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the string");
String strKey=scanner.nextLine();
MapReader objValue=new MapReader();
mapread.addObjects(newMap,strKey,objValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 6:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number= scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string");
String strKey=scanner.nextLine();
System.out.println("Enter the value string");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 7:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number= scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string");
String strKey=scanner.nextLine();
System.out.println("Enter the value string");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Created Map is "+newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);

}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 8:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to check");
String check=scanner.nextLine();

System.out.println("Available : "+mapread.checkKey(newMap,check));
int length=mapread.length(newMap);
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 9:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the value to check ");
String check=scanner.nextLine();

System.out.println("Available : " + mapread.checkValue(newMap,check));
int length=mapread.length(newMap);
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 10:
{
try
{
Map<Object,Object> newMap1=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number1=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number1;i++)
{
System.out.println("Enter the key string ");
String strKey1=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue1=scanner.nextLine();
mapread.addObjects(newMap1,strKey1,strValue1);
}

Map<Object,Object> newMap2=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number2=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number2;i++)
{
System.out.println("Enter the key string ");
String strKey2=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue2=scanner.nextLine();
mapread.addObjects(newMap2,strKey2,strValue2);
}

System.out.println("Map1 before changes "+ newMap1);
System.out.println("The length is "+mapread.length(newMap1));

System.out.println("Map2 before changes "+ newMap2);
System.out.println("The length is "+mapread.length(newMap2));

Map<Object,Object> finalMap=mapread.replaceMap(newMap1,newMap2);

System.out.println("Map after changes " +finalMap);
System.out.println("The length is "+mapread.length(finalMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 11:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to get value ");
String check=scanner.nextLine();
String key=mapread.getValue(newMap,check);
System.out.println("The value of existing key is "+key);

int length=mapread.length(newMap);
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 12:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to get value ");
String check=scanner.nextLine();
String value=mapread.getValue(newMap,check);
System.out.println("The value of non-existing key is "+value);

int length=mapread.length(newMap);
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 13:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to get value ");
String check=scanner.nextLine();

System.out.println("Enter the default value to show if the key is not available ");
String defaultStr=scanner.nextLine();

System.out.println("map before changes " +newMap);
String defaultString=mapread.defaultValue(newMap,check,defaultStr);
System.out.println("The value of existing key after change is "+defaultString);

System.out.println("Map after changes " +newMap);
int length=mapread.length(newMap);
System.out.println("The length is "+length);
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 14:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to remove");
String remove=scanner.nextLine();

System.out.println("map before changes "+newMap);
System.out.println("The length is "+mapread.length(newMap));

System.out.println("Map after changes "+mapread.removeKey(newMap,remove));
System.out.println("The length is "+mapread.length(newMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 15:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to remove ");
String key=scanner.nextLine();

System.out.println("Enter the value to remove ");
String remove=scanner.nextLine();

System.out.println("map before changes "+newMap);
System.out.println("The length is "+mapread.length(newMap));

System.out.println("Map after changes "+mapread.removeValueMatches(newMap,key,remove));
System.out.println("The length is "+mapread.length(newMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 16:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to exchange ");
String exchangeKey=scanner.nextLine();

System.out.println("Enter the value to exchange ");
String exchangeValue=scanner.nextLine();

System.out.println("map before changes "+newMap);
System.out.println("The length is "+mapread.length(newMap));

System.out.println("Map after changes " +mapread.replaceValueMatches(newMap,exchangeKey,exchangeValue));
System.out.println("The length is "+mapread.length(newMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 17:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Enter the key to exchange ");
String exchangeKey=scanner.nextLine();

System.out.println("Enter the old value to exchange ");
String oldValue=scanner.nextLine();

System.out.println("Enter the new value  ");
String newValue=scanner.nextLine();

System.out.println("map before changes "+newMap);
System.out.println("The length is "+mapread.length(newMap));

System.out.println("Map after changes " +mapread.changeValues(newMap,exchangeKey,oldValue,newValue));
System.out.println("The length is "+mapread.length(newMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 18:
{
try
{
Map<Object,Object> newMap1=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number1=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number1;i++)
{
System.out.println("Enter the key string ");
String strKey1=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue1=scanner.nextLine();
mapread.addObjects(newMap1,strKey1,strValue1);
}

Map<Object,Object> newMap2=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number2=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number2;i++)
{
System.out.println("Enter the key string ");
String strKey2=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue2=scanner.nextLine();
mapread.addObjects(newMap2,strKey2,strValue2);
}

System.out.println("Map1 before changes "+ newMap1);
System.out.println("The length is "+mapread.length(newMap1));

System.out.println("Map2 before changes "+ newMap2);
System.out.println("The length is "+mapread.length(newMap2));

Map<Object,Object> finalMap=mapread.replaceMap(newMap1,newMap2);

System.out.println("Map after changes " +finalMap);
System.out.println("The length is "+mapread.length(finalMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 19:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

for(Map.Entry<Object,Object> entry: newMap.entrySet())
{
System.out.println(" Keys : " + entry.getKey() + "  Values : " +entry.getValue());
}
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
case 20:
{
try
{
Map<Object,Object> newMap=mapread.createMap();

System.out.println("Enter the number of values to add ");
int number=scanner.nextInt();
scanner.nextLine();

for(int i=0;i<number;i++)
{
System.out.println("Enter the key string ");
String strKey=scanner.nextLine();
System.out.println("Enter the value string ");
String strValue=scanner.nextLine();
mapread.addObjects(newMap,strKey,strValue);
}

System.out.println("Map before changes " + newMap);
System.out.println("Length of the map is " +mapread.length(newMap));

mapread.removeAll(newMap);

System.out.println("Map after clearing all " +newMap);
System.out.println("Length of the map is " +mapread.length(newMap));
}
catch(CustomException e)
{
System.out.println(e.getMessage());
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of integer");
}
break;
}
default:
{
System.out.println("you have entered more than 20! please enter between 1-20");
}
}//switch
}//main
}//class



