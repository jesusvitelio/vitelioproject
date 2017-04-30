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
			row += "<td><a href='/pc/editar/"+val.id+"' class='btn btn-primary'>Editar</a> <a href='/pc/eliminar/"+val.id+"' onclick='return confirm('¿Esta seguro de eliminar este registro?')' class='btn btn-danger'>Eliminar</a> </td>";
			row += "</tr>";
			tbody.append(row);



		});
	});
});