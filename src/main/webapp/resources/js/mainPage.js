$("#profile-link").click(function(event){
    $.ajax({
        url : '/user/profile',
        success : function(data) {
            $('#page-wrapper').empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#profile-link-bar").click(function(event){
    $.ajax({
        url : '/user/profile',
        success : function(data) {
            $('#page-wrapper').empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#projects-link").click(function(event){
    $.ajax({
        url : '/user/projects',
        success : function(data) {
            $('#page-wrapper').empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#projects-link-bar").click(function(event){
    $.ajax({
        url : '/user/projects',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#mainpage-link").click(function(event){
    $.ajax({
        url : '/user/main',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#co-workers-link").click(function(event){
    $.ajax({
        url : '/user/workers',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

