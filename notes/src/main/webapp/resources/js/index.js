function sendNote() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: '/add',
        data: JSON.stringify({
            title: $("#titleId").val(),
            text: $("#textId").val()
        }),
        complete: function () {
            location.href = 'http://' + location.hostname + ":" + location.port;
        }
    });
}
function searchNote() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: '/search',
        data: JSON.stringify({
            title: $("#titleId").val(),
            text: $("#textId").val()
        }),
        complete: function () {
            location.href = 'http://' + location.hostname + ":" + location.port;
        }
    });
}

function submitData(id, elementId) {
    document.getElementById(elementId).value = id;
    document.getElementById("form1").submit();
}