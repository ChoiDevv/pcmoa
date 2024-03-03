$(document).ready(function() {
    let selectedForm = 'loginForm';
    $('#' + selectedForm).show();

    $('.toggleBtn').click(function() {
        $('.toggleBtn').removeClass('selected');
        $(this).addClass('selected');
        selectedForm = $(this).data('form');
        $('.form').hide();
        $('#' + selectedForm).show();
    });
});