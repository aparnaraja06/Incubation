package task;
import java.io.*;
import java.util.*;
public class Task{
public void checkStr(String inputStr)throws Exception{
if(inputStr==null || inputStr.isEmpty()){
throw new Exception("The given string is null or empty");
}
}
public void checkNum(String inputStr,int num)throws Exception{
if(num<0){
throw new Exception("The given number is negative");
}
int length = strLength(inputStr);
if(length<num){
throw new Exception("The given number is greater than String length");
}
}
public int strLength(String args)throws Exception{
checkStr(args);
return args.length();
}
public char[] characterArray(String inputStr)throws Exception{
checkStr(inputStr);
char[] character= inputStr.toCharArray();
return character;
}
public char getString(String inputStr, int num)throws Exception{
checkStr(inputStr);
checkNum(inputStr,num);
return inputStr.charAt(num);
}
public int occurence(String inputStr, char character)throws Exception{
checkStr(inputStr);
int count = 0;
int length = strLength(inputStr);
for(int i=0;i<length;i++){
if(inputStr.charAt(i)==character){
count++;
}
}
return count;
}
public int position(String inputStr, char character)throws Exception{
checkStr(inputStr);
return inputStr.lastIndexOf(character);
}
public String lastFew(String inputStr, int num)throws Exception{
checkStr(inputStr);
checkNum(inputStr,num);
return inputStr.substring(num);
}
public String firstFew(String inputStr, int num)throws Exception{
checkStr(inputStr);
checkNum(inputStr,num);
return inputStr.substring(num);
}
public String exchangeFew(String inputStr, String exchangeStr, int num)throws Exception{
checkStr(inputStr);
checkStr(exchangeStr);
checkNum(inputStr,num);
return exchangeStr+inputStr.substring(num);
}
public boolean startWith(String inputStr, String startStr)throws Exception{
checkStr(inputStr);
checkStr(startStr);
return inputStr.startsWith(startStr);
}
public boolean endWith(String inputStr, String endStr)throws Exception{
checkStr(inputStr);
checkStr(endStr);
return inputStr.endsWith(endStr);
}
public String upper(String inputStr)throws Exception{
checkStr(inputStr);
return inputStr.toUpperCase();
}
public String lower(String inputStr)throws Exception{
checkStr(inputStr);
return inputStr.toLowerCase();
}
public String reverse(String inputStr)throws Exception{
checkStr(inputStr);
char character;
String temp="";
int length= strLength(inputStr);
for(int i=length-1;i>=0;i--){
temp+=Character.toString(inputStr.charAt(i));
}
return temp;
}
/*public String multiple(String inputStr)throws Exception{
check(inputStr);
return inputStr;
}*/
public String multiConcat(String inputStr)throws Exception{
checkStr(inputStr);
return inputStr.replaceAll("\\s","");
}
public String[] stringArray(String inputStr)throws Exception{
checkStr(inputStr);
String[] str_arr=inputStr.split("\\s");
return str_arr;
}
public String merge(String str_arr[],String inputStr)throws Exception{
checkStr(inputStr);
String finalString="";
for(String temp:str_arr){
checkStr(temp);
}
finalString=String.join(inputStr,str_arr);
return finalString;

}
public boolean equalCase(String inputStr, String equalStr)throws Exception{
checkStr(inputStr);
checkStr(equalStr);
return inputStr.equals(equalStr);
}
public boolean caseInsensitive(String inputStr,String capsStr)throws Exception{
checkStr(inputStr);
checkStr(capsStr);
return inputStr.equalsIgnoreCase(capsStr);
}
public String removeSpace(String inputStr)throws Exception{
checkStr(inputStr);
return inputStr.trim();
}
}






