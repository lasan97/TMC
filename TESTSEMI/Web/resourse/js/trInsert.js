	var imgNamesArr = new Array();

		var imgNum = 0;
		var imgCount = 1;

		$(function() {
			$('#rsInsertImg').click(function() {
				$("#trImgFile").click();
			});
		});

		function trInputChange(value) {
			console.log(value);
			var imgname = "";
			var form = $('#ajaxform')[0];
			var formData = new FormData(form);

			/* formData.append("file",$('#trImgFile'+num)[0].files[0]); */
			$.ajax({
						url : "/tmc/rstest1.do",
						type : "POST",
						processData : false,
						contentType : false,
						data : formData,
						success : function(data) {
							console.log(data.imgName);

							$('#content')
									.append(
											"<img src='resourse/trainingImg/"+data.imgName+"' name="+data.imgName+" id='trContentImg'>")
							imgNamesArr[imgNum] = data.imgName;
							imgNum++;

							/* console.log($('#trContentImg')[0].attr(src)); */
						},
						error : function(data) {

						}

					});
			imgCount++;
		

		};

		$('#content').mouseleave(function() {
			/* console.log(document.getElementById('content').innerHTML); */

		});
		$('#mainImgView').click(function() {
			$('#trMainImg').click();
		});
		function trMainImgChange(value) {
			if (value.files && value.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					$('#mainImgView').attr('src', e.target.result);

				}
				reader.readAsDataURL(value.files[0]);

			}
		};
		function insertButton() {
			var deletImgArr = new Array();
			var imgArray = $('#content img');

			$('#imgNames').val(imgNamesArr);

			$('#trContentInput').val(
					document.getElementById('content').innerHTML);

			for (var i = 0; i < imgArray.length; i++) {
				deletImgArr[i] = imgArray.eq(i).attr('name');
			}
			$('#deletImg').val(deletImgArr);

			/* $('#insertForm').submit();  */
		};