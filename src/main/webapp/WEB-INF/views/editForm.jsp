<div class="container-fluid">

    <div class="container">
        <div id = "edit-form" >${result}</div>
        <div class="form-horizontal" id = "edit-form-id" role="form">
            <h2>Registration Form</h2>
            <div class="form-group">
                <label for="firstName" class="col-sm-3 control-label">Full Name</label>
                <div class="col-sm-9">
                    <input type="text" value = "${firstName}" id="firstName" name="firstName" placeholder="Name" class="form-control" autofocus>
                    <input type="text" value = "${lastName}" id="lastName" name="lastName" placeholder="Surname" class="form-control" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-9">
                    <input type="email" value = "${email}" id="email" name="email" placeholder="Email" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="userName" class="col-sm-3 control-label">User name</label>
                <div class="col-sm-9">
                    <input type="text" value = "${userName}" id="userName" name="userName" placeholder="Username" class="form-control" disabled>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">Password</label>
                <div class="col-sm-9">
                    <input type="password" value = "${password}" id="password" name="password" placeholder="Password" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="birthDate" class="col-sm-3 control-label">Date of Birth</label>
                <div class="col-sm-9">
                    <input type="date" value = "${birthDate}" id="birthDate" name="birthDate" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="country" class="col-sm-3 control-label">Country</label>
                <div class="col-sm-9">
                    <select id="country" value = "${country}" name="country" class="form-control">
                        <option>Belarus</option>
                        <option>Russia</option>
                        <option>USA</option>
                        <option>Poland</option>
                        <option>Lithuania</option>
                        <option>Latvia</option>
                        <option>Germany</option>
                        <option>Italy</option>
                    </select>
                </div>
            </div> <!-- /.form-group -->

            <div class="form-group">
                <div class="col-sm-9 col-sm-offset-3">
                    <button id = "edit-user-form" onClick="saveChanges();" class="btn btn-primary btn-block">Save changes</button>
                </div>
            </div>
        </div> <!-- /form -->
    </div> <!-- ./container -->
</div>