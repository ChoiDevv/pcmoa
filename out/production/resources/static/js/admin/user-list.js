$(document).ready(function () {
    // 활성화된 사용자 전체 선택 체크박스
    $('#activate-select-all').click(function () {
        $('input[name="selectedUsers"]').prop('checked', $(this).prop('checked'));
    });

    // 개별 활성화된 사용자 체크박스가 클릭될 때 전체 선택 체크박스 상태 변경
    $('input[name="selectedUsers"]').click(function () {
        if ($('input[name="selectedUsers"]:checked').length === $('input[name="selectedUsers"]').length) {
            $('#activate-select-all').prop('checked', true);
        } else {
            $('#activate-select-all').prop('checked', false);
        }
    });

    // 비활성화된 사용자 전체 선택 체크박스
    $('#inactivate-select-all').click(function () {
        $('input[name="selectedInactivateUsers"]').prop('checked', $(this).prop('checked'));
    });

    // 개별 비활성화된 사용자 체크박스가 클릭될 때 전체 선택 체크박스 상태 변경
    $('input[name="selectedInactivateUsers"]').click(function () {
        if ($('input[name="selectedInactivateUsers"]:checked').length === $('input[name="selectedInactivateUsers"]').length) {
            $('#inactivate-select-all').prop('checked', true);
        } else {
            $('#inactivate-select-all').prop('checked', false);
        }
    });
});