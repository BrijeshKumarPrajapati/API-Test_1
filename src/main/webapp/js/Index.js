
 function testFun() {
	
  var name = $('#name').val();
  var gender = $('#gender').val();
	var details = {
	name: name,
	gender:gender
	};

	$.ajax({
	type: 'POST',
	url: '/RestApiProject/pReg',
	contentType: 'application/json; charset=UTF-8',
	data: JSON.stringify(details),
	success: function(data) {
	console.log("Post successfully created!");
	window.alert("New Name Added Successfully...");
	document.location.href = "http://localhost:8008/RestApiProject/jsp/Index.jsp";
	}
	});
	}
	
	
	
	
	function testFun() {
	var name = $('#name').val();
    var gender = $('#gender').val();
	var details = {
	name: name,
	gender:gender
	};

	$.ajax({
	type: 'POST',
	url: 'http://localhost:8008/RestApiProject/api/users',
	contentType: 'application/json; charset=UTF-8',
	data: JSON.stringify(details),
	success: function(data,textStatus,xhr) {
	console.log("Post successfully created!");
	console.log(data);
	window.alert("New Name Added Successfully...");
	document.location.href = "http://localhost:8008/RestApiProject/jsp/Index.jsp";
	},
	error: function (xhr, textStatus, errorThrown) {
                    console.log('Error in Operation');
                },
             
	});
	}
	
	
	
	
	/*
	const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(bodyParser.json());

app.post('/RestApiProject/pReg', (req, res) => {
  const details = req.body;
  console.log("Details:", details);
  res.status(200).send("New Name Added Successfully...");
});

const port = 8008;
app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});*/
	