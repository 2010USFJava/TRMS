window.onload=function(){
	console.log("window");
	getManager();
}

function getManager(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			let man = JSON.parse(xhttp.responseText);
			console.log(man);
		}
	}
	xhttp.open("GET","http://localhost:8080/ProjectOne/getmsession.json");
	
	xhttp.send();
}