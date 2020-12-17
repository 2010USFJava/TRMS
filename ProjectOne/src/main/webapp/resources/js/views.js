/**
 * 
 */

//window.addEventListener('load', getEmployeesTableOne, false);
//window.addEventListener('load', getEmployeesFormTableTwo, false);
//window.addEventListener('load', getCommunicationTableForm, false);

window.onload = function(){
	getManagers();
}

function getManagers(){	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let employee = JSON.parse(xhr.responseText); //context
			console.log("employee: " + JSON.parse(xhr.responseText));
			loadEmployees(employee);
		}
	}
	
	xhr.open("GET", "/ProjectOne/viewemployees.json", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	
	xhr.send();
}

function loadEmployees(employee){
	let tableLength = employee.length;
	let msg1 = '';
	console.log("emp_table.js : loadEmployeesTableOne(): " + employee.length);
	for(let i = 0; i < tableLength; i++){
		
		
		msg1 += '<tr><td>' + `${employee[i].firstName}` + '</td><td>' + `${employee[i].lastName}` + '</td><td>' + ` ${employee[i].username}` + '</td><td>' + ` ${employee[i].password}` + '</td><td>' + `${employee[i].empID}` + '</td><td>' + ` ${employee[i].balance}` + '</td><td>' + ` ${employee[i].email}` + '</td></tr>';
		console.log("emp_table.js : loadEmployeesTableOne() Table 1 : i : " + i);
	}
	document.getElementById("tableData").innerHTML = msg1;
	

}