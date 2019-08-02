$(document).ready(function() {
    $('#toSend').click(function() {
        $.ajax({
            url : 'Servlet',
            data : {
                inputNumber : $('#inputNumber').val()
            },
            success : function(responseText) {
                $('#textarea').text(responseText);
            }
        });
    });

    $('#history').click(function() {
        $.ajax({
            url : 'HistoryServlet',
            data : {
                clear : "no"
            },
            success : function(responseText) {
                $('#textareaHistory').text(responseText);
            }
        });
    });

    $('#clearHistory').click(function() {
        $.ajax({
            url : 'HistoryServlet',
            data : {
                clear : "yes"
            }
        });
        $('#textareaHistory').text('');
    });


});

function proverka(input) {
    input.value = input.value.replace(/[^\d]/g, '');

    if (input.value.length===4) {
        if (input.value[0] === input.value[1] || input.value[1] === input.value[2] || input.value[2] === input.value[3] ||
            input.value[1] === input.value[2] || input.value[1] === input.value[3] || input.value[2] === input.value[3]) {
            input.value = input.value.replace(/^[0-9]+$/, "");
        }
    }
}


