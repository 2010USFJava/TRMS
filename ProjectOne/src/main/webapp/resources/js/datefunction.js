/**
 * 
 */

//checks if form is being submitted a week or more prior to event 
function validateDate() {
	//Get the date value of next week.
	var today = document.getElementById('today').value;		//current date 
	var eventDate = document.getElementById('eventDate').value; //event date
	var date = new Date(eventDate);	//event date
	var nextWeek = new Date(date);
	nextWeek.setDate(nextWeek.getDate() - 7);//next week is 7 days before event date 

	console.log(today);
	console.log(date);
	console.log(eventDate);
	console.log(nextWeek);

	var dd = nextWeek.getDate();
	var mm = nextWeek.getMonth()+1;
	var y = nextWeek.getFullYear();

	var formattedDate = mm + '/' + dd + '/' + y;
	document.getElementById('date_7').innerHTML = formattedDate; //formmatted date is nextWeek
	console.log(formattedDate);
	//If eventDate is less (before) than the value of a week after current date, alert...
	if (new Date(today) >= nextWeek) {			//current date must be less than nextweek
		console.log("formatted date is less than event date?");
		alert("Request Date is within one week of Event Date. Too late to submit reimbursement");
		//return false;
	} else {
		console.log("in else");
		alert("form can be submitted");
		
	}

}


//checks if form is urgent or within two weeks of event date 
function isUrgent() {
	//Get the date value of next week.
		var today = document.getElementById('today').value;		//current date
	var eventDate = document.getElementById('eventDate').value; //event date
	var date = new Date(eventDate);
	var nextWeek = new Date(date);
	nextWeek.setDate(nextWeek.getDate() - 14); //nextWeek is 2 weeks before event 

	console.log(today);
	console.log(date);
	console.log(eventDate);
	console.log(nextWeek);

	var dd = nextWeek.getDate();
	var mm = nextWeek.getMonth();
	var y = nextWeek.getFullYear();

	var formattedDate = mm + '/' + dd + '/' + y;
	document.getElementById('date_7').innerHTML = formattedDate;
	console.log(formattedDate);
	//If eventDate is less  (earlier) than two weeks from today than mark urgent, alert...
	if (new Date(today) >= nextWeek) { //if current date is greater than 2 weeks before mark as urgent

		alert("Request Date is within two weeks of Event Date. Mark as urgent");
		
	} else {
		console.log("in else");
		alert("leave next field as default");
		
	}

}