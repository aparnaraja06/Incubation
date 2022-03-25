/**
 * 
 */
var number1 = '', operatorr = '', number2 = '';


function showValue(num) {
	console.log("display called");
	var textBoxx = document.getElementById("display");
	textBoxx.value += num;
	//number1=num;
	/*if(number1 != '' && operatorr!='' && textBoxx.value!='')
	{
		number2 += Number(num);
		console.log("Number 2 stored as"+num);
	}*/
	console.log(num);

}

function getOperator(event) {

	console.log("Operator called");
	var getId = event.id;
	var opVal = document.getElementById(getId).value;

	//alert(button);


	var change = document.getElementById(getId);
	if (operatorr == '') {
		change.style.backgroundColor = 'DeepPink';
	}
	if (operatorr != '') {
		var temp = document.getElementById(operatorr);
		temp.style.backgroundColor = 'LightGray';
		change.style.backgroundColor = 'DeepPink';

	}

	var textBox = document.getElementById("display")
	if (textBox.value != 0) {

	}

	//button.style.backgroundColor = 'DeepPink';
	if (textBox.value == '' && opVal == '-') {
		change.style.backgroundColor = 'LightGray';
		textBox.value += opVal;
	}
	/*if (number1 != '' && operatorr != '' && number2 == '') {
		alert('second');
		number2 = Number(textBox.value);
		console.log("Number 2 inside operator" + number2);
	}
	else*/
	else if (operatorr == '' || operatorr != '' && textBox.value == '' || operatorr != '' && textBox.value != '') {
		//alert('calc');
		if (number1 == '' && textBox.value != '') {
			number1 = Number(textBox.value);

			console.log("number 1 stored as " + number1);

		}
		 if (number1 != '' && operatorr != '') {
			if(opVal=="+" || opVal=="*" || opVal=="/")
			{
				operatorr = opVal;
			}
			else
			{

			console.log("Inside checking method")
			number2 = Number(textBox.value);

			//	document.getElementById("display").value = '';
			solve();
			var button2 = document.getElementById("=");
			button2.style.backgroundColor = 'LightGray';
			console.log("now in number 1 " + number1);

		}
		}
		operatorr = opVal;
		console.log("value stored " + operatorr);

		textBox.value = '';
	}



	console.log("Operator " + operatorr);

}

function clearBox() {

	var buttonn = document.getElementById(operatorr);
	buttonn.style.backgroundColor = 'LightGray';
	document.getElementById("display").value = '';

}

function solve() {
	console.log("Equal to called");

	var button2 = document.getElementById("=");
	button2.style.backgroundColor = 'DeepPink';

	var button1 = document.getElementById(operatorr);
	button1.style.backgroundColor = 'LightGray';
	var finalValue;

	if (number2 == '') {

		number2 = Number(document.getElementById("display").value);
	}




	var output = document.getElementById("display");
	console.log("Number 2 " + number2);
	console.log("Operators are " + operatorr);
	console.log("number 1" + number1);
	switch (operatorr) {
		case '+':

			console.log(" final value " + (number1 + number2));
			finalValue = number1 + number2;
			
			
			break;

		case '-':

			console.log(" final value " + (number1 - number2));
			finalValue = number1 - number2;
			
			
			break;

		case '*':

			console.log(" final value " + (number1 * number2));
			finalValue = number1 * number2;
			
			
			break;

		case '/':

			console.log(" final value " + (number1 / number2));
			finalValue = number1 / number2;
			
			
			break;


	}
	number1 = finalValue;
	console.log("number 1 befor nan" + number1);
	if(number1=="NaN")
	{
		alert("malformed");
		output.value="Malformed function";
	}
	else
	{
		output.value = number1;
	}
	
	
	number2 = '';
	operatorr = '';
}