/**
 * 
 */
var number1 = '', tempArr = [];


function showValue(num) {
	console.log("display called");
	var textBoxx = document.getElementById("display");
	textBoxx.value += num;
	number1 += num;
	console.log(num);
    document.getElementById("=").style.backgroundColor = "LightGrey";

}

function getOperator(event) {
	if (number1 !== '') {
		tempArr.push(number1);
	}
	number1 = '';
	var getId = event.id;
	var opVal = document.getElementById(getId).value;
   document.getElementById("=").style.backgroundColor = "LightGrey";
	var textBox = document.getElementById("display");
	if (textBox.value == '' && tempArr.length == 0 && opVal != '-' && opVal != "√" && opVal != "(") {
		textBox.value = "Malformed function";
	}
	else {
		if (textBox.value == '' && opVal == '-' || tempArr.slice(-1).includes("(") && opVal =='-') {
			textBox.value += opVal;
			number1 += opVal;
		}
		else {

			textBox.value += opVal;
			//number1 += opVal;
			
			if (((tempArr.slice(-1)).includes("+") || (tempArr.slice(-1)).includes("*") || (tempArr.slice(-1)).includes("/") || (tempArr.slice(-1)).includes("%") || (tempArr.slice(-1)).includes("x2") || (tempArr.slice(-1)).includes("x3") || (tempArr.slice(-1)).includes("-")) && (opVal != "-" && opVal != "(")) {
				tempArr.pop();
				tempArr.push(opVal);
			}
			else {
				if (!((tempArr.slice(-1)).includes("+") || (tempArr.slice(-1)).includes("*") || (tempArr.slice(-1)).includes("/") || (tempArr.slice(-1)).includes("-")) && (opVal == "-")) {
					tempArr.push(opVal);
				}

				else if (opVal == "-") {
					number1 += opVal;
				}
				else {
					tempArr.push(opVal);
				}

			}


		}

	}

}

function clearBox() {

    
	document.getElementById("display").value = '';
	document.getElementById("=").style.backgroundColor = "LightGrey";

}

function solve() {
	//inputs.push(number1);
	var output = [];
	if (number1 !== '') {
		tempArr.push(number1);
	}
	number1 = '';
	console.log("whole calc " + tempArr);
	var button2 = document.getElementById("=");
	button2.style.backgroundColor = 'DeepPink';
	output = paranthesisExec(tempArr);
	var result = output.join("");

	document.getElementById("display").value = result;
	
}

function paranthesisExec(tempArr) {

	console.log('welcome:' + tempArr);
	if (!(tempArr.includes('+') || tempArr.includes('-') || tempArr.includes('*') || tempArr.includes('/') || tempArr.includes('x2') || tempArr.includes('x3')
		|| tempArr.includes('√') || tempArr.includes('mod'))) {
		return tempArr;
	}

	if (tempArr.includes("(") && tempArr.includes(")")) {
		var open = tempArr.lastIndexOf("(");
		console.log("Open contains" + open);
		var index = tempArr.indexOf(")", open)
		console.log("to index " + index);
		console.log("temp arr  " + tempArr);

		var store = [];

		for (var i = open + 1; i < index; i++) {
			store.push(tempArr[i]);
		}

		console.log("Store contains " + store);

		var end = index - open;
		var res = checkPrecedence(store);
		tempArr.splice(open, end + 1, res);

		//			validate(close);

	}
	else {
		if (tempArr.includes("(") || tempArr.includes(")")) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			tempArr = checkPrecedence(tempArr);
		}

	}
	return paranthesisExec(tempArr);
}

function errorCheck(check) {
	if (check == undefined) {
		return 0;
	}
}

function checkPrecedence(number) {
	var opRes = '', operand1, operand2, fix;
	var ind = '';

	if (number.includes("x2")) {
		ind = number.indexOf('x2');
		operand1 = number[ind - 1];
		operand2 = operand1;
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "*");
			number.splice(ind - 1, 3, opRes);
		}

		//alert(number);
	}
	else if (number.includes("x3")) {
		ind = number.indexOf('x3');
		operand1 = number[ind - 1];
		operand2 = operand1 * operand1;
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {

			opRes = validate(operand1, operand2, "*");
			number.splice(ind - 1, 3, opRes);
		}

		//alert(number);
	}
	else if (number.includes("√")) {
		ind = number.indexOf('√');
		operand1 = number[ind + 1];
		fix = errorCheck(operand1);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, 0, "√");
			number.splice(ind, 2, opRes);
		}
	}
	else if (number.includes("mod")) {
		ind = number.indexOf('mod');
		operand1 = number[ind - 1];
		operand2 = number[ind + 1];
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "%");
			number.splice(ind - 1, 3, opRes);
		}
	}

	else if (number.includes("/")) {
		ind = number.indexOf('/');
		operand1 = number[ind - 1];
		operand2 = number[ind + 1];
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "/");
			number.splice(ind - 1, 3, opRes);
		}
		//alert(number);
	}

	else if (number.includes("*")) {
		ind = number.indexOf('*');
		operand1 = number[ind - 1];
		operand2 = number[ind + 1];
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "*");
			//alert(number);
			number.splice(ind - 1, 3, opRes);
		}

	}

	else if (number.includes("+")) {
		ind = number.indexOf('+');
		operand1 = number[ind - 1];
		operand2 = number[ind + 1];
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "+");
			//alert(number);
			number.splice(ind - 1, 3, opRes);
		}
		//alert(ind + ' ' + number);

	}

	else if (number.includes("-")) {
		ind = number.indexOf('-');
		operand1 = number[ind - 1];
		operand2 = number[ind + 1];
		fix = errorCheck(operand1);
		fix = errorCheck(operand2);
		if (fix == 0) {
			document.getElementById("display").value = "Malformed function";
		}
		else {
			opRes = validate(operand1, operand2, "-");
			//alert(number);
			number.splice(ind - 1, 3, opRes);
		}

	}

	else {
		console.log("op:" + number);
		return number;
	}
	console.log("index" + ind);
	if (ind !== '') {
	}
	console.log("operated:" + number)
	return checkPrecedence(number);
}

function validate(numberr1, numberr2, operatorr) {
	var finalValue;


	numberr1 = Number(numberr1);
	numberr2 = Number(numberr2);
	switch (operatorr) {
		case '+':
			{
				console.log(" final value " + (numberr1 + numberr2));
				finalValue = numberr1 + numberr2;

				break;
			}

		case '-':

			console.log(" final value " + (numberr1 - numberr2));
			finalValue = numberr1 - numberr2;

			break;

		case '*':

			console.log(" final value " + (numberr1 * numberr2));
			finalValue = numberr1 * numberr2;

			break;

		case '/':

			console.log(" final value " + (numberr1 / numberr2));
			finalValue = numberr1 / numberr2;
			break;

		case "√":
			{
				finalValue = Math.sqrt(numberr1);
				break;
			}
		case "%":
			{
				finalValue = numberr1 % numberr2;
				break;
			}

	}
	return finalValue;
}


