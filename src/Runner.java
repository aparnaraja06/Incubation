package runner;
import java.io.*;
import java.util.*;
import task.Task;
public class Runner{
public static void main(String[] args){
Task task1=new Task();
Scanner scanner = new Scanner(System.in);
int value=0;
try{
System.out.println("Enter the number between 1-20 to perform the function you want :");
value= scanner.nextInt();
}
catch(Exception e){
System.out.println("you have entered other than numbers");
}
scanner.nextLine();
String inputString="";
switch(value){
case 1:
{
//scanner.nextLine();
try{
if(args.length>0){
int length=task1.strLength(args[0]);
System.out.println("Length of the string is : "+length);
break;
}
else{
System.out.println("No arguments found");
break;
}
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 2:
{
try{
System.out.println("Enter the string to change character array");
inputString= scanner.nextLine();
char[] char_arr=task1.characterArray(inputString);
System.out.println(char_arr);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 3:
{
try{
System.out.println("Enter the string to find its position : ");
inputString= scanner.nextLine();
System.out.println("Enter the index you want to get ");
int index = scanner.nextInt();
scanner.nextLine();
char character=task1.getString(inputString,index-1);
System.out.println("The character at " + index +" is :" + character);
break;
}
catch(InputMismatchException ex){
System.out.println("You have entered string in integer value");
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
System.out.println("Enter the string to find number of occurences : ");
inputString= scanner.nextLine();
System.out.println("Letter to find num of occurence " );
char character = scanner.next().charAt(0);
int number=task1.occurence(inputString,character);
System.out.println("The character occurs at " + number + " times");
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
System.out.println("Enter the string to find greatest position: ");
inputString= scanner.nextLine();
System.out.println("Letter to get the greatest position: ");
char character = scanner.next().charAt(0);
int count = task1.position(inputString,character);
if(count == -1){
System.out.println("Character not available ");
break;
}
else{
System.out.println("The greatest position is: " + count);
break;
}
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 6:
{
try{
System.out.println("Enter the string to find last few characters : ");
inputString= scanner.nextLine();
System.out.println("Enter how many characters from last i have to print : ");
int number = scanner.nextInt();
String lastStr = task1.lastFew(inputString,number-1);
System.out.println("The last "+ number+ "Characters is "+ lastStr);
break;}
catch(InputMismatchException ex){
System.out.println("You have entered string in integer value");
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
System.out.println("Enter the string to find first few characters: ");
inputString= scanner.nextLine();
System.out.println("Enter how many characters from first i have to print : ");
int number = scanner.nextInt();
String firstStr = task1.firstFew(inputString,number-1);
System.out.println("The first "+ number + "Characters is "+ firstStr);
break;}
catch(InputMismatchException ex){
System.out.println("You have entered string in integer value");
break;
}
catch(Exception e){
System.out.println("Please Don't enter other than integer ");
break;
}
}
case 8:
{
try{
System.out.println("Enter the string to exchange : ");
inputString=scanner.nextLine();
System.out.println("Enter the string to replace with: ");
String exchangeString=scanner.nextLine();
System.out.println("how many character do you want to replace: ");
int number=scanner.nextInt();
String replace = task1.exchangeFew(inputString,exchangeString,number-1);
System.out.println("The exchanged string is " + replace);
break;
}
catch(InputMismatchException ex){
System.out.println("You have entered string in integer value");
break;
}
catch(Exception e){
System.out.println("Please Don't enter other than integer ");
break;
}
}
case 9:
{
try{
System.out.println("Enter the string to check : ");
inputString=scanner.nextLine();
System.out.println("Enter the string to start with : ");
String startString= scanner.nextLine();
boolean start = task1.startWith(inputString,startString);
System.out.println("Result :" + start);
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
System.out.println("Enter the string to check : ");
inputString=scanner.nextLine();
System.out.println("Enter the string to end with : ");
String endString= scanner.nextLine();
boolean end = task1.endWith(inputString,endString);
System.out.println("Result : " + end);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 11:
{
try{
System.out.println("Enter the string to upper: ");
inputString=scanner.nextLine();
String up = task1.upper(inputString);
System.out.println("In uppercase : " + up);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 12:
{
try{
System.out.println("Enter the string to lower: ");
inputString=scanner.nextLine();
String low = task1.lower(inputString);
System.out.println("In lowercase : " +low);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 13:
{
try{
System.out.println("Enter the string to Reverse: ");
inputString=scanner.nextLine();
String rev = task1.reverse(inputString);
System.out.println("Reverse string is : "+rev);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 14:
{
try{
System.out.println("Enter the string to print ");
inputString= scanner.nextLine(); 
System.out.println(inputString);
break;
}
catch(Exception e){
System.out.println("the given string is empty or null");
break;
}
}
case 15:
{
try{
System.out.println("Enter the string to print ");
inputString= scanner.nextLine(); 
String join = task1.multiConcat(inputString);
System.out.println("Without space : "+ join);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 16:
{
try{
System.out.println("Enter the string ");
inputString=scanner.nextLine();
String[] str_arr =task1.stringArray(inputString);
for(String str : str_arr){
System.out.println(str);
}
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 17:
{
try{
System.out.println("Enter the number of strings to print ");
int number= scanner.nextInt();
scanner.nextLine();
String str_arr[]=new String[number];
System.out.println("Enter the string ");
for(int i=0;i<number;i++){
 str_arr[i]= scanner.nextLine(); 
 }
System.out.println("Enter the symbol you want to join");
String symbol = scanner.nextLine();
String join = task1.merge(str_arr,symbol);
System.out.println("Result is : " + join);
break;
 }
 catch(InputMismatchException ex){
System.out.println("You have entered string in integer value");
break;
}
 catch(Exception e){
 System.out.println(e.getMessage());
 break;
}
}
case 18:
{
try{
System.out.println("Enter the 1st string: ");
inputString=scanner.nextLine();
System.out.println("Enter the 2nd string: ");
String equalString=scanner.nextLine();
boolean equal=task1.equalCase(inputString,equalString);
System.out.println("Result : " + equal);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 19:
{
try{
System.out.println("Enter the 1st string ");
inputString = scanner.nextLine();
System.out.println("Enter the 2nd string ");
String capsString= scanner.nextLine();
boolean caps = task1.caseInsensitive(inputString,capsString);
System.out.println("Result : " + caps);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
case 20:
{
try{
System.out.println("Enter the string to trim: ");
inputString=scanner.nextLine();
String remove = task1.removeSpace(inputString);
System.out.println("Result :"+ remove);
break;
}
catch(Exception e){
System.out.println(e.getMessage());
break;
}
}
default:
System.out.println("You have entered incorrrect number! please enter between 1-20");
scanner.close();
}
}
}




