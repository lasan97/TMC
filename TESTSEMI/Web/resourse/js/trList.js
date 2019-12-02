$(function(){
		
		$('.thumb-list').click(function(){
			var bno = $(this).find("input").val();
			location.href="<%=request.getContextPath()%>/trSelectOne.tr?bno=" + bno;
		});
		$('#trSearchType').change(function() {
			var result = document.getElementById('trSearchType').value;
			if(result=="제목"){
				$('#serachType').val("1");
				
			}else{
				$('#serachType').val("2");
				
				
			}
			/* $('#serachType').val(1); */
			
		});
	});