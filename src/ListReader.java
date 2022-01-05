package listreader;
import java.util.List;
import java.util.Vector;
import java.util.Collections;
public class ListReader{
public void checkIndex(List list, int... index)throws Exception
{
int length=length(list);
for(int temp : index)
{
if(length<temp || temp<0)
{
throw new Exception(" Index value should be greater than zero less than length");
}
}
}
public void checkList(List... list)throws Exception
{
for(List newList: list)
{
if(newList==null)
{
throw new Exception("list cannot be null");
}
}
}
public void checkObj(Object[] object)throws Exception
{
if(object==null || object.length<=0)
{
throw new Exception("Given Object cannot be null or empty ");
}
}
public List callList()
{
List list1 = new Vector();
return list1;
}
public List addElement(List list1, List list2)throws Exception
{
checkList(list1,list2);
list2.addAll(list1);
return list2;
}
/*public list addElement(list list, String[] str_arr)
{
Collections.addAll(list,str_arr);
return list;
}
public list addElement(list list, Integer[] int_arr)
{
Collections.addAll(list,int_arr);
return list;
}
public list addElement(list list, Float[] float_arr)
{
Collections.addAll(list,float_arr);
return list;
}*/
public List addElement(List list,Object[] object )throws Exception
{
checkList(list);
checkObj(object);
Collections.addAll(list,object);
return list;
}
public int length(List list)throws Exception
{
checkList(list);
return list.size();
}
public int getIndex(List list,Object givenObject)throws Exception
{
checkList(list);
return list.indexOf(givenObject);
}
public Object returnObject(List list,int index)throws Exception
{
checkList(list);
checkIndex(list,index);
Object position=list.get(index);
return position;
}
public int lastIndex(List list, Object givenObject)throws Exception
{
checkList(list);
return list.lastIndexOf(givenObject);
}
public List setElement(List list, Object givenObject, int position)throws Exception
{
checkList(list);
checkIndex(list,position);
list.set(position,givenObject);
return list;
}
public List twoList(List list1, List list2, int start, int end)throws Exception
{
checkList(list1,list2);
checkIndex(list1,start,end);
checkIndex(list2,start,end);
list2=list1.subList(start,end);
return list2;
}
public List removeObj(List list, Object object)throws Exception
{
checkList(list);
list.remove(object);
return list;
}
public List removeElement(List list, int index)throws Exception
{
checkList(list);
checkIndex(list,index);
list.remove(index);
return list;
}
public boolean removeRepeatedElements(List list1, List list2)throws Exception
{
checkList(list1,list2);
return list1.removeAll(list2);

}
public boolean removeRepeatedElements(List list)throws Exception
{
checkList(list);
return list.removeAll(list);

}
public List retainElements(List list1, List list2)throws Exception
{
checkList(list1,list2);
list1.retainAll(list2);
return list1;
}
public boolean containElement(List list, Object givenObject)throws Exception
{
checkList(list);
return list.contains(givenObject);
}
}

