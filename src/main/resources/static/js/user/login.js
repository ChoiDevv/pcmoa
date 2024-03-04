$(document).ready(function() {
    setTimeout(function() {
        $('#spinner').hide();
        $('.container').show();
    }, 2000);

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