package builder;
import java.util.*;
import java.io.*;
import buildermethod.BuilderMethod;
public class Builder{
public static void main(String[] args){
Scanner scanner = new Scanner(System.in);
BuilderMethod builder1  = new BuilderMethod();
int option=0;
try{
System.out.println("Enter the number between 1-10 : ");
option= scanner.nextInt();
}
catch(Exception e){
System.out.println("You have entered other than numbers");
}
scanner.nextLine();
String inputString="";
switch(option){
case 1:
{
try
{
StringBuilder strBuild = builder1.callStrBuild();
System.out.println("length of the string builder before adding string " + builder1.strBuildLength(strBuild));

System.out.println("Enter the space to add");
String space= scanner.nextLine();

System.out.println("Enter the string to add ");
String addStr =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr);

System.out.println("length of the string builder after adding a string " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " +strBuild.toString());
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 2:
{
try{
System.out.println("Enter the string you want to print ");
inputString = scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

System.out.println("Length of the stringbuilder with one string " +builder1.strBuildLength(strBuild));

System.out.println("Enter the Number of String to add ");
int number = scanner.nextInt();
scanner.nextLine();

String str_arr[]= new String[number];
System.out.println("Enter the strings ");
for(int i=0;i<number;i++){
str_arr[i]=scanner.nextLine();
}

System.out.println("Enter the symbol you want to join ");
String symbol=scanner.nextLine();
strBuild=builder1.appendStr(strBuild,str_arr,symbol);

System.out.println("the length of the string builder after adding a string " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(InputMismatchException ex){
System.out.println("You have entered string in the place of number");
break;
}
catch(Exception e){
e.printStackTrace();
System.out.println(e.getMessage());
break;
}
}
case 3:
{
try{
System.out.println("Enter the first string ");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

strBuild=builder1.appendStr(strBuild," ");

System.out.println("Enter the string to add ");
String addStr =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr);

System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));
System.out.println("Enter the string to insert ");
String joinStr=scanner.nextLine();
strBuild=builder1.insertStr(strBuild,joinStr,inputString);

System.out.println("the length of the string builder after adding a string " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 4:
{
try{
System.out.println("Enter the first string ");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

strBuild=builder1.appendStr(strBuild," ");

System.out.println("Enter the string to add ");
String addStr =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr);

System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));
strBuild=builder1.deleteStr(strBuild,inputString);
System.out.println("the length of the string builder after deleting a string " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 5:
{
try{
System.out.println("Enter the first strings ");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

strBuild=builder1.appendStr(strBuild," ");

System.out.println("Enter the string to add ");
String addStr1 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr1);

strBuild=builder1.appendStr(strBuild," ");

System.out.println("Enter the string to add ");
String addStr2 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr2);

System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));
System.out.println("Enter the symbol you want to insert ");
char addChar = scanner.next().charAt(0);
strBuild=builder1.replaceStr(strBuild,inputString,addChar);
System.out.println("the length of the string builder after replacing " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 6:
{
try{
System.out.println("Enter the first string");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

System.out.println("Enter the symbol to add");
String symbol= scanner.nextLine();

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr1 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr1);

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr2 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr2);
System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));
strBuild=builder1.reverseStr(strBuild,inputString);
System.out.println("the length of the string builder after replacing " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 7:
{
try{
System.out.println("Enter the string");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);
System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));

System.out.println("Enter the starting index to delete ");
int start=scanner.nextInt();

System.out.println("Enter the index to stop");
int end = scanner.nextInt();

strBuild=builder1.deleteIndex(strBuild,start,end,inputString);
System.out.println("the length of the string builder after replacing " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(InputMismatchException ex){
System.out.println("You have entered string in place of integer");
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 8:
{
try{
System.out.println("Enter the string");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);
System.out.println("Length of the string is " +builder1.strBuildLength(strBuild));

System.out.println("Enter the starting index to replace ");
int start=scanner.nextInt();

System.out.println("Enter the index to stop");
int end = scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the string to replace");
String replaceString=scanner.nextLine();

strBuild=builder1.replaceIndex(strBuild,start,end,inputString,replaceString);
System.out.println("the length of the string builder after replacing " +builder1.strBuildLength(strBuild));
System.out.println("The Final String is " + strBuild.toString());
break;
}
catch(InputMismatchException ex){
System.out.println("You have entered string in place of integer");
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 9:
{
try{
System.out.println("Enter the first string");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

System.out.println("Enter the symbol to add");
String symbol= scanner.nextLine();

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr1 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr1);

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr2 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr2);

int length = builder1.strBuildLength(strBuild);
System.out.println("Length of the string is " +length);
int first = builder1.firstIndex(strBuild,inputString,symbol);
System.out.println("The index is : " +first);
System.out.println(strBuild);

break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 10:
{
try{
System.out.println("Enter the first string");
inputString=scanner.nextLine();
StringBuilder strBuild = builder1.callStrBuild(inputString);

System.out.println("Enter the symbol to add");
String symbol= scanner.nextLine();

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr1 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr1);

strBuild=builder1.appendStr(strBuild,symbol);

System.out.println("Enter the string to add ");
String addStr2 =scanner.nextLine();
strBuild=builder1.appendStr(strBuild,addStr2);
int length = builder1.strBuildLength(strBuild);
System.out.println("Length of the string is " +length);
int last=builder1.lastIndex(strBuild,inputString,symbol);
System.out.println("The index is : " +last);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
default:
System.out.println("you have entered more than 10! please enter between 1-10");
scanner.close();
}
}
}

