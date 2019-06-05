<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                        <li role="presentation"><a href="patient.jsp">Patients</a></li>
                        <li role="presentation"><a href="doctor.jsp">Doctors</a></li>
                        <li role="presentation"><a href="nurse.html">Staff</a></li>
                        <li role="presentation"><a href="department.html">Department</a></li>
                        <li role="presentation"><a href="department.html">Food Department</a></li>
                        <li role="presentation"><a href="department.html">Accountant</a></li>
                        <li role="presentation"><a href="department.html">Pharmacist</a></li>
                        <li role="presentation"><a href="department.html">Laboratorist</a></li>
                        <li role="presentation"><a href="profile.html">Profile</a></li>
                    </ul>
                </div>
                <!---- Menu Ares Ends  -------->
                <!---- Content Ares Start  -------->
                <div class="col-md-10 maincontent" >
                    <!----------------   Menu Tab   --------------->

                    <div class="panel panel-default contentinside">
                        <div class="panel-heading">Manage Patient&nbsp; &nbsp; &nbsp;<a href="all">All Patient</a></div>

                        <!----------------   Panel body Start   --------------->
                        <div class="panel-body">
                            <ul class="nav nav-tabs doctor">
                                <li role="presentation"><a href="#doctorlist">Patient List</a></li>
                                <li role="presentation"><a href="#adddoctor">Add Patient</a></li>
                            </ul>



                            <!----------------   Display Patients Data List Start  --------------->
                            <div id="doctorlist" class="switchgroup">

                                <table class="table table-bordered table-hover">
                                    <tr class="active">
                                        <td>Patient id</td>
                                        <td>Patient Name</td>
                                        <td>Age</td>
                                        <td>Phone</td>
                                        <td>Email</td>
                                        <td>Weight</td>
                                        <td>Entry Date</td>
                                        <td>Disease </td>
                                        <td>Options</td>
                                    </tr>
                                    <c:forEach var="list" items="${list}">
                                        <tr>    
                                            <td><c:out value="${list.p_id}"/></td>
                                            <td><c:out value="${list.p_name}"/></td>
                                            <td><c:out value="${list.p_age}"/></td>
                                            <td><c:out value="${list.p_phone}"/></td>
                                            <td><c:out value="${list.p_email}"/></td>
                                            <td><c:out value="${list.p_weight}"/></td>
                                            <td><c:out value="${list.p_date}"/></td>
                                            <td><c:out value="${list.p_disease}"/></td>
                                            <td>
                                                <a href="edit?p_id=<c:out value="${list.p_id}"/>"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></button></a>
                                                <a  href="delete?p_id=<c:out value="${list.p_id}"/>" class="btn btn-danger" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>                                        
                                            </td>                                        
                                        </tr>
                                    </c:forEach>
                                </table>

                            </div>
                            <!----------------   Display Patient Data List Ends  --------------->

                            <!----------------   Add Patient Start   --------------->
                            <div id="adddoctor" class="switchgroup">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <form class="form-horizontal" action="dp_insert" method="post">
                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Id:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="patientid" placeholder="Patient_id" value="" readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Doctor Name</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="doctorname" placeholder="DoctorName">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Patient ID</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="patientid" placeholder="PatientId">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Patient Name</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="patientname" placeholder="PatientName">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Charge</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="charge" placeholder="Charge">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Disease</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="disease" placeholder="Disease">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-primary">Add Patient</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!----------------   Add Patients Ends   --------------->
                            <!----------------   Panel body Ends   --------------->
                        </div>
                    </div>
                </div>
            </div>

            <script src="js/bootstrap.min.js"></script>
    </body>
</html>