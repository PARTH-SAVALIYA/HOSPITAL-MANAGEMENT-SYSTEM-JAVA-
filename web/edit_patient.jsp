<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="images/logo.png" rel="icon"/>
        <title>Online Hospital Management System</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function ()
            {

                $('#doctorlist').show();
                $('.doctor li:first-child a').addClass('active');
                $('.doctor li a').click(function (e) {

                    var tabDiv = this.hash;
                    $('.doctor li a').removeClass('active');
                    $(this).addClass('.active');
                    $('.switchgroup').hide();
                    $(tabDiv).fadeIn();
                    e.preventDefault();

                });


            });
        </script>
    </head>
    <body>
        <div class="container-fluid">

            <!--- Header Start -------->
            <div class="row header">

                <div class="col-md-10">
                    <h2 >Hospital Mangement System</h3>
                </div>

                <div class="col-md-2 ">
                    <ul class="nav nav-pills ">
                        <li class="dropdown dmenu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                            <ul class="dropdown-menu ">
                                <li><a href="profile.html">Change Profile</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="index.jsp">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!--- Header Ends --------->

            <div class="row">

                <!----- Menu Area Start ------>
                <div class="col-md-2 menucontent">

                    <a href="#"><h1>Dashboard</h1></a>

                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation"><a href="department.html">Department</a></li>
                        <li role="presentation"><a href="doctor.html">Doctors</a></li>
                        <li role="presentation"><a href="patients.html">Patients</a></li>
                        <li role="presentation"><a href="nurse.html">Nurse</a></li>
                        <li role="presentation"><a href="profile.html">Profile</a></li>
                    </ul>
                </div>
                <!---- Menu Ares Ends  -------->
                <!---- Content Ares Start  -------->
                <div class="col-md-10 maincontent" >
                    <!----------------   Menu Tab   --------------->

                    <div class="panel panel-default contentinside">
                        <!----------------   Panel body Start   --------------->
                        <div class="panel-body">
                            <c:set var="ps" value="${ps}"/>
                            <form class="form-horizontal" action="update" method="">
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Patient Id:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="patientid" value="${ps.p_id}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="patientname" value="${ps.p_name}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Age</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="age" value="${ps.p_age}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Phone</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="phone" value="${ps.p_phone}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Email</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="email" value="${ps.p_email}">
                                    </div>
                                </div>    

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Weight</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="weight" value="${ps.p_weight}">
                                    </div>
                                </div>    

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Entry Date</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="date" value="${ps.p_date}">
                                    </div>
                                </div>    

                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">Disease</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="disease" value="${ps.p_disease}">
                                    </div>
                                </div>    

                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-primary">Update</button>
                                    </div>
                                </div>

                            </form>

                            <!------ Doctor Edit Info Modal Start Here ---------->



                            <!----------------   Panel body Ends   --------------->
                        </div>
                    </div>
                </div>
            </div>

            <script src="js/bootstrap.min.js"></script>
    </body>
</html>