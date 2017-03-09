$("#add-project-form").click(function(event){
    $.ajax({
        url : '/management/projectForm',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
})

function addProject(){
    $.ajax({
        url : '/management/addProject',
        data: {'projectName': document.getElementById('projectName').value,
            'description' : document.getElementById('description').value},
        type:'post',
        success : function(data) {
            $("#project-form").empty();
            $('#project-form').html(data);
        }
    });
}