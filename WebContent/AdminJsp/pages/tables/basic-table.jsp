<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script src="../../js/edit.js" type="text/javascript"></script>
<script type="text/javascript">
function changeInput()
{
	var button = document.getElementById("button").value;
	document.getElementById("button").value ="save"; 
	var item0 = document.getElementById("LibrarianName");
	var itemA = item0.innerHTML;
	item0.innerHTML = "<input  type='text' value='" + itemA + "'/>";
	var item1 = document.getElementById("Email");
	var itemB = item1.innerHTML;
	item1.innerHTML = "<input  type='text' value='" + itemB + "'/>"
	var item2 = document.getElementById("Password");
	var itemC = item2.innerHTML;
	item2.innerHTML = "<input  type='text' value='" + itemC + "'/>"
	document.getElementById("button").removeAttr("onclick");
	document.getElementById("button").type="submit";
	
}
</script>
<script type="text/javascript">
function save()
{
	document.form[0].action="editLibrarian"
	document.form[0].submit();
}
</script>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Mandarin-Linbrary</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="../../vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../../css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../../images/favicon.png" />
</head>

<body>
<s:if test="Librarians==null"><s:action  name="displayLibrarians" namespace="/" executeResult="true"></s:action></s:if>
<s:if test="Librarians!=null">
<div class="container-scroller">
  <!-- partial:partials/_navbar.html -->
  <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
      <a class="navbar-brand brand-logo mr-5" href="../../index.jsp"><img src="../../images/gen.svg" class="mr-2" alt="logo"/></a>
    </div>
    <div class="navbar-menu-wrapper d-flex align-items-center justify-content-end">
      <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
        <span class="ti-view-list"></span>
      </button>
      <ul class="navbar-nav mr-lg-2">
        <li class="nav-item nav-search d-none d-lg-block">
          <div class="input-group">
            <div class="input-group-prepend hover-cursor" id="navbar-search-icon">
                <span class="input-group-text" id="search">
                  <i class="ti-search"></i>
                </span>
            </div>
            <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search">
          </div>
        </li>
      </ul>
      <ul class="navbar-nav navbar-nav-right">
        <li class="nav-item dropdown mr-1">
          <a class="nav-link count-indicator dropdown-toggle d-flex justify-content-center align-items-center" id="messageDropdown" href="#" data-toggle="dropdown">
            <i class="ti-email mx-0"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="messageDropdown">
            <p class="mb-0 font-weight-normal float-left dropdown-header">Messages</p>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <img src="images/faces/face4.jpg" alt="image" class="profile-pic">
              </div>
              <div class="item-content flex-grow">
                <h6 class="ellipsis font-weight-normal">David Grey
                </h6>
                <p class="font-weight-light small-text text-muted mb-0">
                  The meeting is cancelled
                </p>
              </div>
            </a>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <img src="images/faces/face2.jpg" alt="image" class="profile-pic">
              </div>
              <div class="item-content flex-grow">
                <h6 class="ellipsis font-weight-normal">Tim Cook
                </h6>
                <p class="font-weight-light small-text text-muted mb-0">
                  New product launch
                </p>
              </div>
            </a>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <img src="images/faces/face3.jpg" alt="image" class="profile-pic">
              </div>
              <div class="item-content flex-grow">
                <h6 class="ellipsis font-weight-normal"> Johnson
             </h6>
                <p class="font-weight-light small-text text-muted mb-0">
                  Upcoming board meeting
                </p>
              </div>
            </a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
            <i class="ti-bell mx-0"></i>
            <span class="count"></span>
          </a>
          <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="notificationDropdown">
            <p class="mb-0 font-weight-normal float-left dropdown-header">Notifications</p>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <div class="item-icon bg-success">
                  <i class="ti-info-alt mx-0"></i>
                </div>
              </div>
              <div class="item-content">
                <h6 class="font-weight-normal">Application Error</h6>
                <p class="font-weight-light small-text mb-0 text-muted">
                  Just now
                </p>
              </div>
            </a>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <div class="item-icon bg-warning">
                  <i class="ti-settings mx-0"></i>
                </div>
              </div>
              <div class="item-content">
                <h6 class="font-weight-normal">Settings</h6>
                <p class="font-weight-light small-text mb-0 text-muted">
                  Private message
                </p>
              </div>
            </a>
            <a class="dropdown-item">
              <div class="item-thumbnail">
                <div class="item-icon bg-info">
                  <i class="ti-user mx-0"></i>
                </div>
              </div>
              <div class="item-content">
                <h6 class="font-weight-normal">New user registration</h6>
                <p class="font-weight-light small-text mb-0 text-muted">
                  2 days ago
                </p>
              </div>
            </a>
          </div>
        </li>
        <li class="nav-item nav-profile dropdown">
          <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="profileDropdown">
            <img src="../../images/faces/face28.jpg" alt="profile"/>
          </a>
          <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
            <a class="dropdown-item">
              <i class="ti-settings text-primary"></i>
              Settings
            </a>
            <a class="dropdown-item">
              <i class="ti-power-off text-primary"></i>
              Logout
            </a>
          </div>
        </li>
      </ul>
      <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
        <span class="ti-view-list"></span>
      </button>
    </div>
  </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:../../partials/_sidebar.html -->
      
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
            <a class="nav-link" href="../../index.jsp">
              <i class="ti-shield menu-icon"></i>
              <span class="menu-title">HomePage</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../../pages/forms/basic_elements.jsp">
              <i class="ti-layout-list-post menu-icon"></i>
              <span class="menu-title">Librarian_Register</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../../pages/tables/basic-table.jsp">
              <i class="ti-view-list-alt menu-icon"></i>
              <span class="menu-title">Tables</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../../documentation/documentation.jsp">
              <i class="ti-write menu-icon"></i>
              <span class="menu-title">Documentation</span>
            </a>
          </li>
        </ul>
      </nav>
      
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Bordered table</h4>
                  <p class="card-description">
                    Add class <code>.table-bordered</code>
                  </p>
                  <div class="table-responsive pt-3">
                   <form action="editLibrarian" method="post"  enctype="multipart/form-data">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>
                            LibrarianID
                          </th>
                          <th>
                            LibrarianName
                          </th>
                          <th>
                           Email
                          </th>
                          <th>
                            Password
                          </th>
                          <th>
                            Operation
                          </th>
                        </tr>
                      </thead>                   
                      <tbody>
                        <s:iterator value="Librarians">
                        <tr>
                          <td>                           
                           <input name="LibrarianID" id="LibrarianID" placeholder=<s:property value="LibrarianID"/> >
                          </td>
                          <td>                           
                           <input name="LibrarianName" id="LibrarianName" placeholder="<s:property value="LibrarianName"/>" disabled="disabled">
                          </td>
                          <td>
                            <input name="Email" id="Email" placeholder="<s:property value="Email"/>" disabled="disabled">
                          </td>
                          <td >                            
                            <input name="Password" id="Password" placeholder="<s:property value="Password"/>" disabled="disabled">
                          </td>
                          <td>
                            <!-- <a href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete/</a> -->
                            <input id="edit" type="button" value="edit" class="caname">
                            <div id="save" style="display:none;">
                            	<!--<a href="editLibrarian?librarian.LibrarianID=<s:property value='LibrarianID'/>
                            	&librarian.LibrarianName=
                            	&librarian.Email=Email
                            	&librarian.Password=Password
                            	">Edit</a>-->
                            	<button type="submit" >save</button>
                            	
                            </div>                            
                          </td>
                        </tr>
						</s:iterator>
                      </tbody>
                    </table>
               		</form>
                  </div>
                </div>
              </div>
            </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a href="https://www.templatewatch.com/" target="_blank">Templatewatch</a>. All rights reserved.</span>
            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="ti-heart text-danger ml-1"></i></span>
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="../../vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../../js/off-canvas.js"></script>
  <script src="../../js/hoverable-collapse.js"></script>
  <script src="../../js/template.js"></script>
  <script src="../../js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
  </form>
  </s:if>
</body>

</html>