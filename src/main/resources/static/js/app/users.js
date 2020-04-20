var users = {
		init : function() {
			var _this = this;
			$('#btn-save').on('click', function () {
				_this.save();
			});
		},
		save : function() {
			var data = $("form[name=usersForm]").serializeObject() ;
			
			$.ajax({
				type : 'POST',
				url : '/api/v1/users',
				dataType : 'json',
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(data)
			}).done(function() {
				alert('사용자 정보가 등록되었습니다.');
				window.location.href = '/'
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		}
};

users.init();