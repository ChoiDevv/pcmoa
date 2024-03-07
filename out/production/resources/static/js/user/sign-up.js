function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function duplicateCheck() {
    const header = $("meta[name='_csrf_header']").attr('content');
    const token = $("meta[name='_csrf']").attr('content');

    let email_input = $('#email');
    let email_value = email_input.val();

    if (!isValidEmail(email_value)) {
        alert("올바른 이메일 형식이 아닙니다.");
        return;
    }

    $.ajax({
        type: 'GET',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        url: '/user/duplicate-check',
        data: { email: email_value },
        success: function (result) {
            if (result) {
                alert("중복된 이메일입니다. 다시 입력해주세요.");
                $('#email').val('');
            } else {
                alert("사용 가능한 이메일입니다.");
                email_input.prop('readonly', true);
            }
        },
        error: function () {
            alert('오류가 발생하였습니다.');
        }
    });
}

$(document).ready(function() {
    setTimeout(function() {
        $('#spinner').hide();
        $('.container').show();
    }, 2000);
});