<div class="container-fluid">

    <div class="container">
        <div id = "project-form" >${result}</div>
        <div class="form-horizontal" id = "project-form-id" role="form">
            <h2>Create Project</h2>
            <div class="form-group">
                <label for="projectName" class="col-sm-3 control-label">Project name</label>
                <div class="col-sm-9">
                    <input type="text" id="projectName" placeholder="Project name" class="form-control" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-3 control-label">Description</label>
                <div class="col-sm-9">
                    <textarea type="text" id="description" placeholder="Project Description" class="form-control"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-9 col-sm-offset-3">
                    <button id = "submit-project-form" onclick="addProject()" class="btn btn-primary btn-block">Register</button>
                </div>
            </div>
        </div> <!-- /form -->
    </div> <!-- ./container -->
</div>