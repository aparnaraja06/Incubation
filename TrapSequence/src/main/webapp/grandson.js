/**
 * 
 */


function generate() {
	var num = parseInt(document.getElementById("num").value);
	var box = document.getElementById("box");
	for (i = 1; i <= num; i++) {

		var input = document.createElement("input");
		input.setAttribute('class', 'father');
		box.appendChild(input);
		var inputt = box.appendChild(document.createElement("input"));
		inputt.setAttribute('class', 'son');
		box.appendChild(document.createElement('br'));

	}


}
function storeData() {

	var relation = new Map();
	var key = document.getElementsByClassName("father");
	var values = document.getElementsByClassName("son");
	var temp1, temp2;
	for (var i = 0; i < key.length; i++) {
		temp1 = key[i].value;
		temp2 = values[i].value;
		var store = [];
		if (relation.has(temp1)) {
			store = relation.get(temp1);
		}
		store.push(temp2);
		relation.set(temp1, store);
	}
	console.log(relation);
	return relation;

}
function getGrandson() {
	var map = storeData();
	console.log(map);
	var output=document.getElementById("grand");
	var name = document.getElementById("name").value;
	var count=0;
	var grandson;
	var sons;
	var names;
	var store = map.get(name);
	
	
	if(store)
	{
	for(var i=0;i < store.length;i++)
	{
		
		grandson+=map.get(store[i]);
	}
	if(grandson!=undefined || grandson!=null)
	{
	for(var j=0;j < grandson.length;j++)
	{
		count++;
	}
	}
	}

	if(count==0)
	{
		sons=name+" has no grandson ";
		output.innerHTML=sons;
	}
	else 
	{
		sons=name+" has "+count;

		if(count==1)
		{
			sons+=" grandson";
			names="His Name is "+grandson;
		}
		else
		{
		sons+=" grandsons";
		names="They are "+grandson;
		}
		output.innerHTML=sons+"<br>"+names;
	}

	
	console.log(name+" "+grandson);
	console.log(sons);
	return grandson;

}
