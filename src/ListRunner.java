package listrunner;
import java.util.Scanner;
import java.util.Collections;
import java.util.Vector;
import java.util.List;
import java.util.Iterator;
import java.util.InputMismatchException;
import listreader.ListReader;
public class ListRunner{
public static void main(String[] args){
Scanner scanner=new Scanner(System.in);
ListReader reader=new ListReader();
int option=0;
try
{
System.out.println("Enter the number between 1-19");
option=scanner.nextInt();
}
catch(Exception e)
{
System.out.println("You have entered other than numbers");
}
scanner.nextLine();
switch(option)
{
case 1:
{
try
{
List newList=reader.callList();

int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 2:
{
try
{
List newList=reader.callList();

System.out.println("enter the number of strings to add ");
int number=scanner.nextInt();
scanner.nextLine();

String[] str_arr=new String[number];
System.out.println("Enter the strings");
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("The List is " + newList);
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 3:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of integers to add");
int number=scanner.nextInt();
scanner.nextLine();

Integer[] int_arr=new Integer[number];
System.out.println("Enter the integers");
for(int i=0;i<number;i++)
{
int_arr[i]=scanner.nextInt();
}
reader.addElement(newList,int_arr);

System.out.println("The List is "+ newList);
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 4:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of objects to add");
int number=scanner.nextInt();
scanner.nextLine();

ListReader[] obj_arr=new ListReader[number];
for(int i=0;i<number;i++)
{
ListReader newObj = new ListReader();
obj_arr[i]=newObj;
}
reader.addElement(newList,obj_arr);

System.out.println("The List is "+ newList);
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 5:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of strings to add ");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("Enter number of integer to add");
int integers=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the integers ");
Integer[] int_arr=new Integer[integers];
for(int i=0;i<integers;i++)
{
int_arr[i]=scanner.nextInt();
}
reader.addElement(newList,int_arr);

System.out.println("Enter the number of objects to add");
int objects=scanner.nextInt();
scanner.nextLine();

ListReader[] obj_arr=new ListReader[objects];
for(int i=0;i<objects;i++)
{
ListReader newObj=new ListReader();
obj_arr[i]=newObj;
}
reader.addElement(newList,obj_arr);

System.out.println("The List is "+ newList);
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 6:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("Enter the string to find its index");
String inputString=scanner.nextLine();
int index = reader.getIndex(newList,inputString);

if(index== -1)
{
System.out.println("Character not available");
}

else
{
System.out.println("The index of the string is "+index);
}

System.out.println("The List is "+ newList);
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 7:
{
try
{
List newList= reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

for(Iterator iterateString=newList.iterator();iterateString.hasNext();)
{
System.out.println(iterateString.next());
}
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 8:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("Enter the index to get the string");
int position=scanner.nextInt();
scanner.nextLine();

System.out.println("The string is " +reader.returnObject(newList,position));
int length=reader.length(newList);
System.out.println("Length of the list is "+length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 9:
{
try
{
List newList = reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("Enter the string to find itsindex");
String firstStr=scanner.nextLine();
int first=reader.getIndex(newList,firstStr);
int last=reader.lastIndex(newList,firstStr);

if(first==-1)
{
System.out.println("Character not available");
}
else
{
System.out.println("The first index of the string is " + first);
System.out.println("The last index of the string is " + last);
break;
}
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 10:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
reader.addElement(newList,str_arr);

System.out.println("Enter the string to add in specific position");
String addString=scanner.nextLine();

System.out.println("Enter the index to add that string ");
int index= scanner.nextInt();
scanner.nextLine();

reader.setElement(newList,addString,index);

System.out.println("The list is " +newList);
int length=reader.length(newList);
System.out.println("The length is " +length);
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 11:
{
try
{
List newList1=reader.callList();

System.out.println("Enter the number of strings to add");
int number1=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr1=new String[number1];
for(int i=0;i<number1;i++)
{
str_arr1[i]=scanner.nextLine();
}
List getList=reader.addElement(newList1,str_arr1);

List newList2=reader.callList();
List secondList=reader.addElement(getList,newList2);

System.out.println("Enter the index to start ");
int start=scanner.nextInt();
System.out.println("Enter the index to stop");
int end=scanner.nextInt();
System.out.println("The list is" + reader.twoList(getList,secondList,start,end));
break;
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
break;
}
catch(Exception e)
{
System.out.println(e.getMessage());
break;
}
}
case 12:
{
try
{
List newList1=reader.callList();

System.out.println("Enter the number of strings to add");
int number1=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr1=new String[number1];
for(int i=0;i<number1;i++)
{
str_arr1[i]=scanner.nextLine();
}
reader.addElement(newList1,str_arr1);

List newList2=reader.callList();
System.out.println("Enter the number of strings to add");
int number2=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr2=new String[number2];
for(int i=0;i<number2;i++)
{
str_arr2[i]=scanner.nextLine();
}
reader.addElement(newList2,str_arr2);

List newList3=reader.callList();
List getList=reader.addElement(newList3,newList2);
List thirdList=reader.addElement(getList,newList1);

System.out.println("The third List is " + thirdList);
int length=reader.length(thirdList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
break;
}
case 13:
{
try
{
List newList1=reader.callList();

System.out.println("Enter the number of strings to add");
int number1=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr1=new String[number1];
for(int i=0;i<number1;i++)
{
str_arr1[i]=scanner.nextLine();
}
List firstList=reader.addElement(newList1,str_arr1);

List newList2=reader.callList();
System.out.println("Enter the number of strings to add");
int number2=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr2=new String[number2];
for(int i=0;i<number2;i++)
{
str_arr2[i]=scanner.nextLine();
}
List secondList=reader.addElement(newList2,str_arr2);

List beforeList=reader.addElement(secondList,firstList);

List newList3=reader.callList();
List getList=reader.addElement(newList3,beforeList);

System.out.println("The third List is " + getList);
int length=reader.length(getList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 14:
{
try
{
List newList = reader.callList();
System.out.println("Enter the number of decimals to add");
int number=scanner.nextInt();
scanner.nextLine();
System.out.println("Enter the decimals");
Double[] double_arr=new Double[number];
for(int i=0;i<number;i++)
{
double_arr[i]=scanner.nextDouble();
}
reader.addElement(newList,double_arr);
System.out.println("Enter the value to remove");
double removeValue=scanner.nextDouble();
List remove=reader.removeObj(newList,removeValue);
System.out.println("The list is " + remove);
int length=reader.length(remove);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 15:
{
try
{
List newList = reader.callList();
System.out.println("Enter the number of decimals to add");
int number=scanner.nextInt();
scanner.nextLine();
System.out.println("Enter the decimals");
Double[] double_arr=new Double[number];
for(int i=0;i<number;i++)
{
double_arr[i]=scanner.nextDouble();
}
reader.addElement(newList,double_arr);
System.out.println("Enter the index to remove");
int index=scanner.nextInt();
List indexList=reader.removeElement(newList,index);
System.out.println("The list is " + indexList);
int length=reader.length(indexList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 16:
{
try
{
List newList1=reader.callList();

System.out.println("Enter the number of strings to add");
int number1=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr1=new String[number1];
for(int i=0;i<number1;i++)
{
str_arr1[i]=scanner.nextLine();
}
List firstList=reader.addElement(newList1,str_arr1);

List newList2=reader.callList();
System.out.println("Enter the number of strings to add");
int number2=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr2=new String[number2];
for(int i=0;i<number2;i++)
{
str_arr2[i]=scanner.nextLine();
}
List secondList=reader.addElement(newList2,str_arr2);
reader.removeRepeatedElements(firstList,secondList);
System.out.println("The list is " + firstList);
int length=reader.length(firstList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 17:
{
try
{
List newList1=reader.callList();

System.out.println("Enter the number of strings to add");
int number1=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr1=new String[number1];
for(int i=0;i<number1;i++)
{
str_arr1[i]=scanner.nextLine();
}
List firstList=reader.addElement(newList1,str_arr1);

List newList2=reader.callList();
System.out.println("Enter the number of strings to add");
int number2=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr2=new String[number2];
for(int i=0;i<number2;i++)
{
str_arr2[i]=scanner.nextLine();
}
List secondList=reader.addElement(newList2,str_arr2);
reader.retainElements(firstList,secondList);
System.out.println("The list is " + firstList);
int length=reader.length(firstList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 18:
{
try
{
List newList = reader.callList();
System.out.println("Enter the number of long values to add");
int number=scanner.nextInt();
scanner.nextLine();
System.out.println("Enter the values");
Long[] long_arr=new Long[number];
for(int i=0;i<number;i++)
{
long_arr[i]=scanner.nextLong();
}
List updated=reader.addElement(newList,long_arr);
reader.removeRepeatedElements(updated);
System.out.println("The list is " + updated);
int length=reader.length(updated);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
case 19:
{
try
{
List newList=reader.callList();

System.out.println("Enter the number of strings to add");
int number=scanner.nextInt();
scanner.nextLine();

System.out.println("Enter the strings");
String[] str_arr=new String[number];
for(int i=0;i<number;i++)
{
str_arr[i]=scanner.nextLine();
}
List firstList=reader.addElement(newList,str_arr);
System.out.println("Enter the string to check ");
String string=scanner.nextLine();
System.out.println(reader.containElement(newList,string));
System.out.println("The list is " + newList);
int length=reader.length(newList);
System.out.println("The length is " +length);
}
catch(InputMismatchException ex)
{
System.out.println("You have entered string in place of number");

}
catch(Exception e)
{
System.out.println(e.getMessage());

}
break;
}
default:
System.out.println("You have entered more than 19! please enter between 1-19");
}//switch
}//main
}//class
