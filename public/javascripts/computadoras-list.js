$(function(){
	$.ajax({
		url: '/pc/lista',


	}).done(function(data){
		console.log("success", data);

		var tbody = $("#computadoras");

		$.each(data, function(index, val){
			var row = "<tr>";
			row += "<td>"+val.id+"</td>";
			row += "<td>"+val.marca+"</td>";
			row += "<td>"+val.modelo+"</td>";
			row += "<td>"+val.procesador+"</td>";
			row += "<td>"+val.memoria+"</td>";
			row += "<td>"+val.fecha+"</td>";
			row += "</tr>";
			tbody.append(row);



		});
	});
});