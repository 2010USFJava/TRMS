 /**
 * 
 */


window.onload = function(){
	getReimbursements();
}

function getReimbursements(){	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log("inside onreadystate");
		if(xhr.readyState == 4 && xhr.status == 200){
			let reimbursement = JSON.parse(xhr.responseText); //context
			loadReimbursements(reimbursement);
		}
	}
	
	xhr.open("GET", "/ProjectOne/viewreimbursements.json", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	
	xhr.send();
}

function loadReimbursements(reimbursement){
	let tableLength = reimbursement.length;
	let msg1 = '';
	console.log("emp_table.js : loadEmployeesTableOne(): " + reimbursement.length);
	for(let i = 0; i < tableLength; i++){
		
		
		msg1 += '<tr><td>' + `${reimbursement[i].formID}` + '</td><td>' + ` ${reimbursement[i].empID}` + '</td><td>' + ` ${reimbursement[i].eventDate}` + '</td><td>' + ` ${reimbursement[i].requestDate}` + '</td><td>' + `${reimbursement[i].location}` + '</td><td>' + ` ${reimbursement[i].amount}` + '</td><td>' + ` ${reimbursement[i].description}` + '</td><td>' + ` ${reimbursement[i].eventType}` + '</td><td>' + ` ${reimbursement[i].gradeType}`+ '</td><td>' + ` ${reimbursement[i].status}`+ '</td><td>' + ` ${reimbursement[i].statusdepthead}`+ '</td><td>' + ` ${reimbursement[i].statusbenco}`+ '</td><td>' + ` ${reimbursement[i].gradeValue}`+ '</td><td>' + ` ${reimbursement[i].passingGrade}` + '</td><td>' + `${reimbursement[i].urgent}` + '</td></tr>';
		console.log("emp_table.js : loadEmployeesTableOne() Table 1 : i : " + i);
	}
	document.getElementById("tableData").innerHTML = msg1;
	
}
	
