/**
 * 
 */
//this displays current date in Current Date input and inputs request date into database 
let today = new Date().toISOString().substr(0, 10);
document.querySelector("#today").value = today;

//var inputamount = document.getElementById('amount1').value;
//var eventType = document.getElementById('eventType');
//var changedamount = document.getElementById('amount');
//console.log(inputamount);
//console.log(eventType);


function changeAmount(){

    var e = document.getElementById("eventType").value;
    var eCost = document.getElementById("amount1").value;
    var reimburs;

     switch (e) {
       case "University Courses":
           reimburs = parseFloat((eCost * 0.80)).toFixed(2);
           document.getElementById("amount").value = reimburs;
            break;
       case "Seminars":
        reimburs = parseFloat((eCost * 0.60)).toFixed(2);
        document.getElementById("amount").value = reimburs;
           break;
       case "Certification Preparation":
        reimburs = parseFloat((eCost * 0.75)).toFixed(2);
        document.getElementById("amount").value = reimburs;
           break;
       case "Certification":
        reimburs = parseFloat((eCost)).toFixed(2);
        document.getElementById("amount").value = reimburs;
           break;
       case "Technical Training":
        reimburs = parseFloat((eCost * 0.90)).toFixed(2);
        document.getElementById("amount").value = reimburs;
           break;
       case "Other":
        reimburs = parseFloat((eCost * 0.30)).toFixed(2);
        document.getElementById("amount").value = reimburs;
           break;
       default:
        document.getElementById("amount").value = "choose an event type";
                break;
     }
   }


