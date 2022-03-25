/**
 * 
 */

function getTrap() {
	var n1 = 3, n2 = 13, b = 5, a, count = 0, temp, result = "";
	for (a = n1; a <= n2; a++) {
		var isValid = false;


		if (a == b || (a % b == 0 || b % a == 0)) {
			count++;
			console.log("A is" + a);
			console.log("B is" + b);
			isValid = true;
		}
		else {
			var num = a;
			while (!isValid && num > 9) {
				temp = getSum(num);
				if (temp % b == 0 || b % temp == 0 || temp == b) {
					count++;
					isValid = true;
				}
				num = temp;
			}
		}
		if (!isValid) {
			if (b > 3) {
				b = b - 1;
			}
		}
		else if (isValid) {
			result += [a, b] + "<br>";
			b = b + 2;

		}

	}
	var output = document.getElementById("generate");

	output.innerHTML += count + "<br>" + result;
}

function getSum(value) {
	var sum = 0;
	while (value) {
		sum += value % 10;
		value = Math.floor(value / 10);
	}

	return sum;
}