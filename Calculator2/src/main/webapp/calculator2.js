/**
 * 
 */
var number1 = '', operatorr = '', number2 = '';


function showValue(num) {
	//console.log("display called");
	var getlength;
	var textBoxx1 = document.getElementById("display1");
	//textBoxx1.value += num;

	var textBoxx2 = document.getElementById("display2");
	textBoxx2.value += num;

	var decimal = '';

	if (operatorr == "=") {
		//alert("Entered number block");
		textBoxx1.value = '';
		var temp = textBoxx2.value;
		number1 = temp;
		textBoxx1.value += number1;
	}

	if (textBoxx2.value.includes(',')) {
		textBoxx2.value = textBoxx2.value.replaceAll(',', '');
	}

	if (textBoxx2.value.includes('.')) {
		var index = textBoxx2.value.indexOf('.');
		decimal += '.' + textBoxx2.value.substring(index + 1);
		textBoxx2.value = textBoxx2.value.substring(0, index);
	}

	getlength = textBoxx2.value.length;

	if (getlength > 3) {
		var valuee = textBoxx2.value.toString();
		var last = valuee.substring(getlength - 3);
		var other = valuee.substring(0, getlength - 3);

		var mid = other;

		if (other != '') {
			last = "," + last;
			mid = last;

			if (other.length > 2) {
				var midlen = other.length;
				while (other.length > 2) {
					var midlen = other.length;
					var twoDigits = other.substring(midlen - 2);
					mid = ("," + twoDigits).concat(mid);
					other = other.substring(0, midlen - 2);
				}
				if (other.length === 1) {
					mid = other.concat(mid);

				}
				else if (other.length == 2) {
					var twoDigits = other.substring(other.length - 2);
					mid = String(twoDigits).concat(mid);
				}
			}
			else {
				mid = other + mid;
			}


		}

		console.log(mid);
		if (mid != undefined && mid.length < 5) {
			textBoxx2.value += mid + last;

		}
		else {
			textBoxx1.value += num;
			textBoxx2.value = mid;

		}


	}
	else {
		textBoxx1.value += num;

		//textBoxx2.value+=num;
	}

	if (decimal !== '') {
		textBoxx2.value += decimal;
	}



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

	var textBox2 = document.getElementById("display2");
	var textBox1 = document.getElementById("display1");
	if (textBox2.value != 0) {

	}
	if (operatorr == "=") {
		textBox1.value = '';
		textBox1.value += number1;
		operatorr = '';
	}


	//button.style.backgroundColor = 'DeepPink';
	if (textBox2.value == '' && opVal == '-') {
		change.style.backgroundColor = 'LightGray';
		textBox2.value += opVal;
		textBox1.value += opVal;
	}
	/*if (number1 != '' && operatorr != '' && number2 == '') {
		alert('second');
		number2 = Number(textBox.value);
		console.log("Number 2 inside operator" + number2);
	}
	else*/

	else if (operatorr == '' || operatorr != '' && textBox2.value == '' || operatorr != '' && textBox2.value != '') {
		//alert('calc');
		if (number1 == '' && textBox2.value != '') {
			var num1 = textBox2.value.replaceAll(",", '');

			console.log("Number 1 is " + num1);
			number1 = Number(num1);

			console.log("number 1 stored as " + number1);

		}

		if (number1 != '' && operatorr != '') {

			console.log("Inside checking method")
			if(opVal=="+" || opVal=="*" || opVal=="/")
			{
				operatorr = opVal;
			}
			else
			{
			var num2 = textBox2.value.replaceAll(",", '');
			//number2.replace(",",'');
			console.log("Number 2 is " + num2);
			number2 = Number(num2);

			//			document.getElementById("display").value = '';
			solve();

			var button2 = document.getElementById("=");
			button2.style.backgroundColor = 'LightGray';
			textBox1.value = '';
			textBox1.value += number1;
			textBox2.value += number1;
			console.log("now in number 1 " + number1);

		}
		}
		operatorr = opVal;
		textBox1.value += operatorr;
		console.log("value stored " + operatorr);

		textBox2.value = '';
		
	}






	console.log("Operator " + operatorr);

}

function clearBox() {

	var buttonn = document.getElementById(operatorr);
	buttonn.style.backgroundColor = 'LightGray';
	document.getElementById("display1").value = '';
	document.getElementById("display2").value = '';
}

function solve(symbol) {
	console.log("Equal to called");


	var button2 = document.getElementById("=");
	button2.style.backgroundColor = 'DeepPink';

	var button1 = document.getElementById(operatorr);
	button1.style.backgroundColor = 'LightGray';
	var output1 = document.getElementById("display1");
	var output2 = document.getElementById("display2");
	var finalValue;


	if (number2 == '') {
		var num2 = output2.value.replaceAll(",", '');
		number2 = Number(num2);

	}





	console.log("Number 2 " + number2);
	console.log("Operators are " + operatorr);
	console.log("number 1" + number1);
	switch (operatorr) {
		case '+':

			console.log(" final value " + (number1 + number2));
			finalValue = number1 + number2;
			number1 = finalValue;
			//output2.value = number1;

			break;

		case '-':

			console.log(" final value " + (number1 - number2));
			finalValue = number1 - number2;
			number1 = finalValue;
			//output2.value = number1;

			break;

		case '*':

			console.log(" final value " + (number1 * number2));
			finalValue = number1 * number2;
			number1 = finalValue;
			//output2.value = number1;

			break;

		case '/':

			console.log(" final value " + (number1 / number2));
			finalValue = number1 / number2;
			number1 = finalValue;
			//output2.value = number1;

			break;


	}
	console.log("Locale string" + number1.toLocaleString());
	var value = number1.toString();
	var decimal = '';
	if (value.includes('.')) {
		var index = value.indexOf('.');
		decimal += '.' + value.substring(index + 1);
		value = value.substring(0, index);
	}

	var getlength = value.length;
	if (getlength > 3) {

		var last = value.substring(getlength - 3);
		var other = value.substring(0, getlength - 3);
		var mid = other;
		if (other != '') {
			last = "," + last;
			mid = last;

			if (other.length > 2) {
				var midlen = other.length;
				while (other.length >= 2) {
					var midlen = other.length;
					var twoDigits = other.substring(midlen - 2);
					mid = (other.length > 2 ? ("," + twoDigits) : String(twoDigits)).concat(mid);
					other = other.slice(0, midlen - 2);
				}
				if (other.length === 1) {
					mid = other.concat(mid);
				}
			}
			else {
				mid = other + mid;
			}


		}

		console.log(mid);
		if (mid != undefined && mid.length < 5) {
			output2.value += mid + last + decimal;

		}
		else {

			output2.value = mid + decimal;

		}

	}
	else {
		output2.value = number1 + decimal;

	}

	number2 = '';
	operatorr = '';
	if (symbol == "=") {

		operatorr = symbol;
	}



}