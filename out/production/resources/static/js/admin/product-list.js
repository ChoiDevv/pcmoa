function productSave() {
    const header = $("meta[name='_csrf_header']").attr('content');
    const token = $("meta[name='_csrf']").attr('content');

    let productName = $('#productName').val();
    // 이미지 파일
    let productImage = $('#productImage');
    let files = productImage.prop('files');
    let productDescription = $('#productDescription').val();
    let productPrice = $('#productPrice').val();
    let productCategory = $('#productCategory').val();
    let productStock = $('#productStock').val();

    if (productName === "" || productDescription === "" || productPrice === "" || productCategory === "" || productStock === "") {
        alert("공백이 존재합니다.");
    } else {
        let formData = new FormData();
        formData.append("name", productName);
        formData.append("description", productDescription);
        formData.append("price", productPrice);
        formData.append("category", productCategory);
        formData.append("stock", productStock);

        for (let i = 0; i < files.length; i++) {
            formData.append("images", files[i]);
        }

        $.ajax({
            type: 'POST',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            processData: false,
            contentType: false,
            url: '/admin/product/save',
            data: formData,
            success: function (result) {
                console.log(result);
                alert("상품 등록이 완료되었습니다.");
                window.location.href = '/admin/product-list';
            },
            error: function (xhr, status, error) {
                alert('등록에 문제가 발생하였습니다. 다시 한 번 확인해주세요.');
            }
        });
    }
}

function getBase64(file, callback) {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        callback(reader.result.split(',')[1]);
    };
    reader.onerror = function (error) {
        console.error('파일을 읽는데 문제가 생겼습니다.', error);
    };
}