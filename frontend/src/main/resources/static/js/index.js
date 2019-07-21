if (typeof frontend == 'undefined') frontend = {};

frontend.index = {

    BOARD_PAGE_URL: "/board",

    init: function () {
        console.log("Init frontend.index");
        frontend.index.loadBoardPage();
    },

    loadBoardPage: function () {
        console.log("Load board page.");
        $.ajax({
            url: '/board',
            type: 'GET',
            success: function(response) {
                $( "#main" ).html(response);
            },
            error: function (err) {
                alert("Error:" + JSON.stringify(err));
            }
        })
    },

    "":""
};