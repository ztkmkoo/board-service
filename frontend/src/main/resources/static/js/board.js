if (typeof frontend == 'undefined') frontend = {};

frontend.board = {

    page: 1,
    size: 10,

    init: function () {
        console.log("Init frontend.board.");
        frontend.board.initVariable();
        frontend.board.loadBoardSummary();
    },

    initVariable: function() {
        console.log("Init frontend.board Variable.");
        frontend.board.page = 1;
        frontend.board.size = 10;
    },

    loadBoardSummary: function () {

        var url = '/board/page/' + frontend.board.page + '/size/' + frontend.board.size;
        console.log("Load board summary: " + url);

        $.ajax({
            url: url,
            type: 'GET',
            success: function(response) {
                if (response != null) {
                    frontend.board.updateBoardTable(response);
                }
            },
            error: function (err) {
                alert("Error:" + JSON.stringify(err));
            }
        })
    },

    updateBoardTable: function(response) {
        $( '#boardTable > tbody').empty();

        if (Array.isArray(response)) {
            for (var index in response) {
                var boardSummary = response[index];
                var rowHtml = frontend.board.getHtmlRowStringFromBoardSummary(boardSummary);
                console.log("Row html: " + rowHtml);

                $('#boardTable > tbody:last').append(rowHtml);
            }
        } else {
            console.log("Response is not an array.")
        }
    },

    getHtmlRowStringFromBoardSummary: function (boardSummary) {
        return '<tr>'
            + '<td>' + boardSummary['seq'] + '</td>'
            + '<td>' + boardSummary['tag'] + '</td>'
            + '<td>' + boardSummary['title'] + '</td>'
            + '<td>' + boardSummary['author'] + '</td>'
            + '<td>' + boardSummary['opened'] + '</td>'
            + '<td>' + boardSummary['modified'] + '</td>'
            + '</tr>';
    },

    "":""
};