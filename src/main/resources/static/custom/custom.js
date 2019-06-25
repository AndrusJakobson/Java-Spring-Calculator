$("body").on("click", ".calculatorButton", function(){
	var element = $(this);
	var number = getNumber();
	var bufferNumber = getBufferNumber();
	
	if(isValidCalculation(element, number, bufferNumber)){
		var jsonData = JSON.stringify({
			number1: number,
			number2: bufferNumber,
			operator: getBufferOperator()
		});
		setBufferOperator(element.text());
		getResults(jsonData);
		
	}else if(isOperator(element) && !isEmpty(number)){
		clearAll();
		setBufferNumber(number);
		setBufferOperator(element.text());
	}else{
		appendToNumber(element.text());
	}
});

function isValidCalculation(operator, number, number2){
	return !isEmpty(operator) && isOperator(operator) && !isEmpty(number) && !isEmpty(number2);
}

function getResults(data){
	$.ajax({
		type: "POST",
		contentType: "application/json; charset= utf-8",
		data: data,
		dataType: "json",
		url: "controller.htm",
		success: function(data){
			clearAll();
			appendToNumber(data.response);
		}, error: function(data){
			console.log("error: " + data.response);
		}
	});
}

function isEmpty(value){
	if(value){
		return false;
	}
	return true;
}

function isOperator(element){
	return element.hasClass("operator");
}

function setBufferOperator(element){
	$("#bufferOperator").text(element);
}

function getBufferOperator(){
	return $("#bufferOperator").text();
}

function getNumber(){
	return $("#calculatorNumberView").text();
}

function appendToNumber(element){
	$("#calculatorNumberView").append(element);
}

function getBufferNumber(){
	return $("#bufferNumber").text();
}

function setBufferNumber(value){
	$("#bufferNumber").text(value);
}

function clearAll(){
	$("#calculatorNumberView").text("");
	$("#bufferNumber").text("");
	$("#bufferOperator").text("");
}