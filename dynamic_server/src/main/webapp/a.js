$(document).ready(function(){

	$("#b1").click(function()
	{
	
	
		$.getJSON("./InitServlet?q=1", function(res){  
				$("#data").html("Name:"+res.name+"<br> Phone:"+res.phone+"<br> Address"+res.address);
			
			});
			
	});
	
	
	
	$("#b2").click(function()
	{
	
		$.getJSON("./InitServlet?q=2", function(res){  
				$("#data").html("Name:"+res.name+"<br> Phone:"+res.phone+"<br> Address"+res.address);
			
			});
			
	});
	
	

	
	
	$("#b3").click(function()
	{
	
		$.get("./InitServlet?q=3", function(res){ 
			var js=JSON.parse(res);
				for(var i=0;i<js.length;i++) 
					$("#data").append("Name:"+js[i].username+"<br> Phone:"+js[i].email+"<hr>");
			
			});
			
	});
	
	
	$("#b4").click(function()
	{
	
		$.get("./SecondServlet", function(res){ 
			
					$("#data").append(res);
			
			});
			
	});

	$("#frm1").submit(function(){
		
		event.preventDefault();
		$.post("./SecondServlet",$("#frm1").serialize(),function(res)
		{
			if (res=="ok")
			{
				$("#data").html("Your name inserted");
			}
			else
			{
				$("#data").html("Error insertion");
			}
			
				
		}
		);	
	});
	
	

});