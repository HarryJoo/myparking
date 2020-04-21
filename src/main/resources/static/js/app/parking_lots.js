var parking_lots = {
		init : function() {
			var _this = this;
			
			$('#parking-lots-btn-save').on('click', function () {
				_this.save();
			});
			
			$('#parking-lots-btn-update').on('click', function () {
				_this.update();
			});
			
			$('#parking-lots-btn-delete').on('click', function () {
				_this.delete();
			});
		},
		
		// 주차장 정보 등록
		save : function() {
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
		},
		
		// 주차장 정보 수정
		update : function() {
			var data = $("form[name=parkingLotsForm]").serializeObject() ;
			
			var id = $('#id').val();
			
			$.ajax({
				type : 'PUT',
				url : '/api/v1/parking-lots/' + id,
				dataType : 'json',
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(data)
			}).done(function() {
				alert('주차장 정보가 수정되었습니다.');
				window.location.href = '/'
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		},
		
		
		// 주차장 정보 삭제
		delete : function() {
			var id = $('#id').val();
			
			$.ajax({
				type : 'DELETE',
				url : '/api/v1/parking-lots/' + id,
				dataType : 'json',
				contentType : 'application/json; charset=utf-8',
			}).done(function() {
				alert('주차장 정보가 삭제되었습니다.');
				window.location.href = '/'
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		}
};

parking_lots.init();