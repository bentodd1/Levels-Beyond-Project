//Creates the dateQuery by calling calculateLastSevenDays then adds the query to the end of the 
//request url.  The function then calls makeApiCallAndFill with the url.
function fillTable(){
	var dateQuery,url;
	dateQuery = calculateDaysAgo(7);
	gUrl= "Https://api.github.com/repos/angular/angular/issues?since="+dateQuery;
	makeApiCallAndFill(gUrl);
}

//Returns in ISO format the date previous to today by the amount of days
function calculateDaysAgo(days){
	var date,last,dateQuery;
	date = new Date();
	last = new Date(date.getTime() - (days * 24 * 60 * 60 * 1000));
	daysIso= last.toISOString();
	return daysIso;
}

//Makes the api call and send the response to mapResponseToTable.
function makeApiCallAndFill(gUrl){	
	alert(gUrl);
	$.get(gUrl, function(data, status){
		mapResponseToTable(data);
	});
}

//Parse through the JSon response.  For each JSon object create a new row and add it to the table.  
//Extract the text of each JSon object and assign it to the correct cell.
function mapResponseToTable(jsonResponse){
	var table,responseObject,row,eTitle,eUser,user,eAsignee,assignee,eBody;
	table =document.getElementById("tbl");
	for (var i = 0; i < jsonResponse.length; i++) {

		responseObject = jsonResponse[i];
		row = table.insertRow(i+1);

		eTitle = row.insertCell(0);
		eTitle.innerHTML = responseObject.title;

		eUser = row.insertCell(1);
		user = responseObject.user;
		if(user != null){
			eUser.innerHTML = user.login;
		}

		eAssignee = row.insertCell(2);
		assignee = responseObject.assignee;
		if(assignee != null){
			eAssignee.innerHTML =assignee.login;
		}

		var eBody = row.insertCell(3);
		eBody.innerHTML = responseObject.body;

	}
}
