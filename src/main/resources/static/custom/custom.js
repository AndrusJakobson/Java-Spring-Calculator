var isNewNumber = true;

$("body").on("click", ".row h3", function(){
	const symbol = $(this).text();
	appendToMemory(symbol);
});

$("body").on("click", ".number", function(){
	const number = $(this).text();
	if(isNewNumber){
		setNumberView(number);
		isNewNumber = false;
	}else{
		getNumberView().append(number);
	}
	
});

$("body").on("click", ".operator", function(){
	const operator = $(this).text();
	postInput(getInputDataAsJson(operator));
});

function postInput(input){
	$.ajax({
		type: "POST",
		contentType: "application/json; charset= utf-8",
		data: input,
		dataType: "json",
		url: "calculate",
		success: function(data){
			isNewNumber = true;
			const result = data.response;
			setNumberView(result);
		}, error: function(data){
			console.log("error: " + data.response);
		}
	})
}

function setNumberView(number){
	getNumberView().text(number);
}

function getNumberView(){
	return $("#calculatorNumberView");
}

function getNumber(){
	return getNumberView().text();
}

function getInputDataAsJson(operator){
	return jsonData = JSON.stringify({
		number: getNumber(),
		operator: operator
	});
}

function getCalculationMemory(){
	return $("#calculationMemory");
}

function appendToMemory(appendable){
	getCalculationMemory().append(appendable);
}