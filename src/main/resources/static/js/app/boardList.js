var main = {
    init : function () {
        var _this = this;
        $('#save').on('click', function () {
            _this.save();
        })
    },
    save : function () {
        var data = {
            title : $("#title").val(),
            author : $("#author").val(),
            password: $("#password").val(),
            content : $("#content").val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/board',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/lists';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();