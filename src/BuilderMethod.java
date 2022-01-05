package buildermethod;
import java.util.*;
import java.io.*;
import task.Task;
public class BuilderMethod{
Task task2 = new Task();
public void checkNull(StringBuilder strBuilder)throws Exception{
if(strBuilder==null){
throw new Exception("StringBuilder is null");
}
}
public StringBuilder callStrBuild(){
StringBuilder strBuilder = new StringBuilder();
return strBuilder;
}
public StringBuilder callStrBuild(String inputStr)throws Exception{
task2.checkStr(inputStr);
StringBuilder strBuilder = new StringBuilder(inputStr);
return strBuilder;
}
public int strBuildLength(StringBuilder strBuilder){
checkNull(strBuilder);
return strBuilder.length();
}
public StringBuilder appendStr(StringBuilder strBuilder,String addStr)throws Exception{
checkNull(strBuilder);
task2.checkStr(addStr);
strBuilder.append(addStr);
return strBuilder;
}
public StringBuilder appendStr(StringBuilder strBuilder,String str_arr[],String symbol)throws Exception{
checkNull(strBuilder);
task2.checkStr(symbol);
for(String temp: str_arr){
task2.checkStr(temp);
strBuilder.append(symbol).append(temp);
}
return strBuilder;
}
public StringBuilder insertStr(StringBuilder strBuilder, String addString,String inputString)throws Exception{
checkNull(strBuilder);
task2.checkStr(addString);
task2.checkStr(inputString);
int index=strBuilder.indexOf(" ");
strBuilder.insert(index+1,addString);
int length=task2.strLength(addString);
index+=length;
strBuilder.insert(index+1," ");
return strBuilder;
}
public StringBuilder deleteStr(StringBuilder strBuilder, String inputString)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
int index = strBuilder.indexOf(" ");
strBuilder.delete(0,index);
return strBuilder;
}
public StringBuilder replaceStr(StringBuilder strBuilder, String inputString, char addStr)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
int length=strBuildLength(strBuilder);
for(int i=0;i<length;i++){
if(strBuilder.charAt(i)==' ')
{
strBuilder.setCharAt(i,addStr);
}
}
return strBuilder;
}
public StringBuilder reverseStr(StringBuilder strBuilder, String inputString)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
strBuilder.reverse();
return strBuilder;
}

public StringBuilder deleteIndex(StringBuilder strBuilder, int start, int stop,String inputString)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
task2.checkNum(inputString,start);
task2.checkNum(inputString,stop);
strBuilder.delete(start,stop);
return strBuilder;
}
public StringBuilder replaceIndex(StringBuilder strBuilder, int start, 
		int stop,String inputString,String replaceString)throws Exception
{
checkNull(strBuilder);
task2.checkStr(inputString);
task2.checkStr(replaceString);
task2.checkNum(inputString,start);
task2.checkNum(inputString,stop);
strBuilder.replace(start,stop,replaceString);
return strBuilder;
}
public int firstIndex(StringBuilder strBuilder,String inputString, String symbol)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
task2.checkStr(symbol);
int index = strBuilder.indexOf(symbol);
return index;
}
public int lastIndex(StringBuilder strBuilder, String inputString,String symbol)throws Exception{
checkNull(strBuilder);
task2.checkStr(inputString);
task2.checkStr(symbol);
int index = strBuilder.lastIndexOf(symbol);
return index;
}
}
