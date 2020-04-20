var index = {
		init : function() {
			var _this = this;
			$('#btn-save').on('click', function () {
				_this.save();
			});
		},
		save : function() {
			var data = {
					parking_lot_no : $('parking_lot_no').val(),
					parking_lot_nm : $('parking_lot_nm').val() 
			};
			
			var data = $("form[name=parkingLotsForm]").serializeObject() ;
			
			$.ajax({
				type : 'POST',
				url : '/api/v1/parking-lots',
				dataType : 'json',
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(data)
			}).done(function() {
				alert('주차장 정보가 등록되었습니다.');
				window.location.href = '/'
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		}
};

index.init();