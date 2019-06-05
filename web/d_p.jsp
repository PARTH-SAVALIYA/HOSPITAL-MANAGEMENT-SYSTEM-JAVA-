<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ page autoFlush="true" buffer="1094kb"%>

<%--<c:when test="${session.getAttribute('email') == null}">
    <jsp:forward page="index.jsp"/>
</c:when>--%>

<c:if  test="${sessionScope.email == null}"  >
    <jsp:forward page="index.jsp"/>
    ${session.getAttribute('email')}
</c:if>

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

            window.history.forward();
            function noBack()
            {
                window.history.forward();
            }



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
    <body  onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
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
                                <li><a href="dp_logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <!--- Header Ends --------->

            <div class="row"  >

                <!----- Menu Area Start ------>
                <div class="col-md-2 menucontent">

                    <a href="#"><h1>Dashboard</h1></a>

                    <ul class="nav nav-pills nav-stacked">
                        <li role="presentation"><a href="dp_list">Home</a></li>
                        <li role="presentation"><a href="doctor.jsp">Doctors</a></li>
                        <li role="presentation"><a href="patient.jsp">Patients</a></li>
                        <li role="presentation"><a href="report.jsp">Reports</a></li>
                        <li role="presentation"><a href="profile.html">Profile</a></li>
                    </ul>
                </div>
                <!---- Menu Ares Ends  -------->
                <!---- Content Ares Start  -------->
                <div class="col-md-10 maincontent" >
                    <!----------------   Menu Tab   --------------->
                    <div class="panel panel-default contentinside">
                        <div class="panel-heading">Doctor Patient&nbsp; &nbsp; &nbsp;<a href="c_all">All Data</a>
                            <form class="navbar-form navbar-right" action="dp_f_p">
                                <div class="input-group">
                                    <input type="text" name="id" class="form-control" placeholder="Search">
                                    <div class="input-group-btn">
                                        <button class="btn btn-default" type="submit">
                                            <i class="glyphicon glyphicon-search"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div> 
                        <!----------------   Panel body Start   --------------->
                        <div class="panel-body">
                            <ul class="nav nav-tabs doctor">
                                <li role="presentation"><a href="#doctorlist">List</a></li>
                                <li role="presentation"><a href="#adddoctor">Add Entry</a></li>
                            </ul>

                            <!----------------   Display Doctor Data List Start  --------------->

                            <div id="doctorlist" class="switchgroup">
                                <table class="table table-bordered table-hover">
                                    <tr class="active">
                                        <td>Patient Id</td>
                                        <td>Doctor Id</td>
                                        <td>Options</td>
                                    </tr>
                                    <c:forEach var="list" items="${list}">
                                        <tr>
                                            <td>${list.p_id}</td> 
                                            <td>${list.d_id}</td>
                                            <td>
                                                <a href="dp_edit?p_id=${list.p_id}&d_id=${list.d_id}"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" ><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span></button></a>
                                                <a href="dp_delete?p_id=${list.p_id}&d_id=${list.d_id}" class="btn btn-danger" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                            </td>
                                        </tr>                                        
                                    </c:forEach>                                                                    
                                </table>                                                 
                            </div>

                            <!----------------   Display Doctor Data List Ends  --------------->

                            <!----------------   Add Doctor Start   --------------->
                            <div id="adddoctor" class="switchgroup">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="emailwrong" ><p >* Duplicate Entry Not Allowed</p></div>
                                        <form class="form-horizontal" action="dp_insert" method="post">

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Patient Id:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="patientid" placeholder="Patient Id"  required="required">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label  class="col-sm-2 control-label">Doctor Id:</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="doctorid" placeholder="Doctor Id" required="required">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-primary">Add Case</button>
                                                </div>
                                            </div>


                                        </form>

                                    </div>
                                </div>
                            </div>
                            <!----------------   Add Doctor Ends   --------------->
                        </div>
                        <!----------------   Panel body Ends   --------------->
                    </div>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>