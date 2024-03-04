function productSave() {
    const header = $("meta[name='_csrf_header']").attr('content');
    const token = $("meta[name='_csrf']").attr('content');

    let productName = $('#productName').val();
    let productDescription = $('#productDescription').val();
    let productPrice = $('#productPrice').val();
    let productCategory = $('#productCategory').val();
    let productStock = $('#productStock').val();

    if (productName === "" || productDescription === "" || productPrice === "" || productCategory === "" || productStock === "") {
        alert("공백이 존재합니다.");
    } else {
        $.ajax({
            type: 'POST',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            contentType: "application/json; charset=utf-8",
            dataType: "text",
            url: '/admin/product/save',
            data: JSON.stringify({
                name: productName,
                description: productDescription,
                price: productPrice,
                category: productCategory,
                stock: productStock
            }),
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