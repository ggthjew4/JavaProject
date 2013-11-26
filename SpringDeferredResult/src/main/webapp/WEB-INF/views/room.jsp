<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String user =(String)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
$(function () {
    (function getMessages() {
        $.ajax({
            dataType: "json",
            url: 'getMessages',
            cache: false,
            success: function (data) {
                var v = $('#text').val();
                v += '\r\n' + data.date + ' ' + data.user + '：' + data.content;
                $('#text').val(v);
            }
        }).always(function () {
            getMessages();
        });
    })();

    $('#form').submit(function (event) {
        event.preventDefault();
        var values = $(this).serialize();
        $.post('setMessage', values, function (data) {
            $('#form>[name=content]').val('');
        }, 'json');
    });

    $('#logout').click(function () {
        $.ajax({
            dataType: "json",
            url: 'logout',
            cache: false,
            success: function (data) {
                window.location.href = 'index';
            }
        });
    });
});
</script>
<title>Insert title here</title>
</head>
<body>
	歡迎光臨聊天室：<%=user %><br />
	<textarea id="text" rows="20" style="width: 500;"></textarea>
	<form id="form" method="post">
		<input type="text" name="content" /> <input value="發送" type="submit" />
		<input id="logout" value="離開" type="button" />
	</form>
</body>
</html>