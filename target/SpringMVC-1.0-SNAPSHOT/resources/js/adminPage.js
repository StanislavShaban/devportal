$("#add-user-form").click(function(event){
    $.ajax({
        url : '/admin/userForm',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#delete-user").click(function(event){
    $.ajax({
        url : '/user/workers',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

$("#edit-user").click(function(event){
    $.ajax({
        url : '/user/workers',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
});

function deleteUser(username){
    $.ajax({
        url:'/admin/deleteUser',
        data: {'username':username},
        type:'get',
        success:function(data){
            $('#delete-result').html(data);
            $('div#'+username+'').remove();
        }
    });
};

function editUser(username){
    $.ajax({
        url:'/admin/editForm',
        data: {'username':username},
        type:'get',
        success:function(data){
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
};

function saveChanges(){
    $.ajax({
        url:'/admin/editUser',
        data: {'firstName': document.getElementById('firstName').value,
            'lastName' : document.getElementById('lastName').value,
            'email' : document.getElementById('email').value,
            'userName' : document.getElementById('userName').value,
            'password' : document.getElementById('password').value,
            'birthday' : document.getElementById('birthDate').value,
            'country' : document.getElementById('country').value,},
        type:'get',
        success : function(data) {
            $("#edit-form").empty();
            $('#edit-form').html(data);
        }
    });
};



function projectDescription(project_id){
    $.ajax({
        url: '/user/projects/description',
        data: {'id':project_id},
        type: 'get',
        success : function(data) {
            $("#page-wrapper").empty();
            $('#page-wrapper').html(data);
        }
    });
};

function addUser(){
    $.ajax({
        url : '/admin/insertUser',
        data: {'firstName': document.getElementById('firstName').value,
               'lastName' : document.getElementById('lastName').value,
                'email' : document.getElementById('email').value,
                'userName' : document.getElementById('userName').value,
                'password' : document.getElementById('password').value,
                'birthday' : document.getElementById('birthDate').value,
                'country' : document.getElementById('country').value,},
        type:'post',
        success : function(data) {
            $("#user-form").empty();
            $('#user-form').html(data);
        }
    });
};

