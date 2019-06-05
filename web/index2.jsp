

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Online Hospital Management System</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!--<link href="css/style.css" rel="stylesheet">-->
        <link href="css/style2.css" rel="stylesheet">
        <script src="js/jquery.js"></script>        

    </head>
    <body>

        <div class="container-fluid">
            <!--- Header --------------------------->
            <div class="row navbar-fixed-top">
                <nav class="navbar navbar-default header">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand logo" href="#">
                                <img alt="Brand" src="images/logo.png">
                            </a>
                            <div class="navbar-text title"><p>Hospital Management System<p></div>
                        </div>
                    </div>
                </nav>
            </div> <br>
            <!--- Header Ends Here --------------------------->

            <div class="row ">
                <div class="col-md-12">
                    <div class="panel panel-default login">
                        <div class="panel-heading logintitle">Login</div>

                        <div class="panel-body">
                            
                            
                            <form class="form-horizontal center-block" role="form" action="session">

                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
                                    <select name="select1" class="form-control" >
                                        <option selected="selected" name="userrole">Select User</option>
                                        <option value="admin" name="Admin">Admin</option>
                                        <option value="doctor" >Doctor</option>
                                        <option value="Laboratorist" name="Laboratorist">Laboratorist</option>
                                        <option value="Accountant" name="Accountant">Accountant</option>
                                        <option value="Pharmacist" name="Pharmacist">Pharmacist</option>
                                    </select>
                                </div>
                                <br/>                                           
                                <div class="emailwrong">  Incorrect email or password!!! </div>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span></span>

                                    <input type="email" class="form-control" name="email" placeholder="example@gmail.com" required aria-describedby="sizing-addon1">
                                </div>

                                <br/>
                                <div class="input-group input-group-lg">
                                    <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
                                    <input type="password" name="password" class="form-control" placeholder="Password" required aria-describedby="sizing-addon1">
                                </div>
                                <br/>
                                <div class="col-sm-7 col-sm-offset-2">
                                    <button type="submit" class="btn btn-primary btn-block btn-lg">Login</button>
                                </div>
                            </form>
                          <%
                               
                           String email = request.getParameter("email");
                           String password = request.getParameter("password");
                           
                           if (email == null || password == null) {
                                   request.getRequestDispatcher("index.jsp").forward(request, response);
                               }
                           %>
                           
                        </div>

                    </div>
                </div>				
            </div>


            <div class="row footer navbar-fixed-bottom">

            </div>

        </div>

        <script src="js/bootstrap.min.js"></script>

    </body>
</html>
