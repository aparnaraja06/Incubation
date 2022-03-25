/**
 * 
 */
 function getBinary()
{
	var id=document.getElementById("num").value;
	var result=convertToBinary(id);
	var check=result+'';
	//var character=Array.from(check);
	console.log("Character array"+check);
	var count=0;
	for(var i=0;i < check.length;i++)
	{
		if(check.charAt(i)=='1')
		{
			//console.log("Inside block");
			count++;
		}
		}
	console.log(result);
	console.log(count);
	document.getElementById("generate").innerHTML=count;
	
}
function convertToBinary(num)
{
	var result=0,rem,i=1;
	while(num!=0)
	{
		rem=num%2;
		num=parseInt(num/2);
		result+=rem*i;
		i=i*10;
	}
	
	return result;
}