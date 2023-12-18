
// acceptation echange
$('.ajouter_question').click(function (e) {
    e.preventDefault();
    $.ajax({
        type: "post",
        url: $(this).attr('href'),
        processData: false,
        contentType: false,
        success: function (response) {

        },
        error: function (response) {
            console.log(response)

        }
    });
    $(this).parent().slideUp(500, function () {
        $(this).remove();
    });

});
