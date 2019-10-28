<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script src="<%=request.getContextPath()%>/AdminJsp/js/LibrarianName.js" type="text/javascript"></script>
<script src="../js/edit.js" type="text/javascript"></script>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Mandarin-Linbrary</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="../vendors/ti-icons/css/themify-icons.css">
  <link rel="stylesheet" href="../vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="../css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="../images/favicon.png" />
</head>

<body>
<s:if test="books==null"><s:action  name="adminDisplayBooks" namespace="/" executeResult="true"></s:action></s:if>
<s:if test="books!=null">
<div class="container-scroller">
  <!-- partial:partials/_navbar.html -->
  <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
    <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
      <a class="navbar-brand brand-logo mr-5" href="../index.jsp"><img src="../images/gen.svg" class="mr-2" alt="logo"/></a>
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
                   <a id="a1" href="" onclick="doTest()">
                  <i class="ti-search"></i>
                  </a>
                </span>
                
              </div>
              <input type="text" class="form-control" id="navbar-search-input" placeholder="Search now" aria-label="search" aria-describedby="search" name="LibrarianName" onclick="doTest()">
            </div>
          </li>
        </ul>
      <ul class="navbar-nav navbar-nav-right">

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
            <a class="nav-link" href="../index.jsp">
              <i class="ti-shield menu-icon"></i>
              <span class="menu-title">HomePage</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../pages/Register.jsp">
              <i class="ti-layout-list-post menu-icon"></i>
              <span class="menu-title">Librarian_Register</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../pages/EditLibrarian.jsp">
              <i class="ti-view-list-alt menu-icon"></i>
              <span class="menu-title">Librarians</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="../pages/Modify_Deposit.jsp">
              <i class="ti-settings menu-icon"></i>
              <span class="menu-title">Modify Deposit</span>
            </a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="../pages/Edit.jsp">
              <i class="ti-settings menu-icon"></i>
              <span class="menu-title">Edit fines and return period</span>
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
                  <h4 class="card-title">Librarian table</h4>
                  <p class="card-description">
                  </p>
                  <div class="table-responsive pt-3">
                   
                    <table class="table">
                      <thead>
                        <tr>
                          <th>
                            BookName
                          </th>
                          <th>
                            ISBN
                          </th>
                          <th>
                           Return Period
                          </th>
                          <th>
                            FineValue
                          </th>
                          <th>
                            Operation
                          </th>
                        </tr>
                      </thead>                   
                      <tbody>
                        <s:iterator value="books">
                        <script>
                        $(function() { 
                        		$(".caname${ISBN}").click(function() {                       				
                        				$('#ReturnPeriod${ISBN}').removeAttr("readonly")
                        				$('#ReturnPeriod${ISBN}').removeAttr("style")
                        				$('#FineValue${ISBN}').removeAttr("readonly")
                        				$('#FineValue${ISBN}').removeAttr("style")
                        				$("#edit${ISBN}").hide();
                        				$("#save${ISBN}").show();
                        		}); 
                        	}); 
                        </script>
                         <form action="adminEditBook" method="post">
                        <tr>
                          <td>                           
                           <input name="BookName" id="BookName" value=<s:property value="BookName"/> style="border:none;" readonly="readonly" >
                          </td>
                          <td>                           
                           <input name="ISBN" id="ISBN" value="<s:property value="ISBN"/>"  style="border:none;" readonly="readonly">
                          </td>
                          <td>
                            <input name="ReturnPeriod" id="ReturnPeriod${ISBN}" value="<s:property value="ReturnPeriod"/>" style="border:none;" readonly="readonly">
                          </td>
                          <td >                            
                            <input name="FineValue" id="FineValue${ISBN}" value="<s:property value="FineValue"/>" style="border:none;" readonly="readonly">
                          </td>
                          <td>
                            <div>
                            <button id="edit${ISBN}" type="button" value="edit" class="caname${ISBN} btn btn-outline-success btn-icon-text btn-rounded btn-sm">edit  </button>
                            	<div id="save${ISBN}" style="display:none;">
                            	<button type="submit"  class="btn btn-outline-primary btn-icon-text btn-rounded btn-sm">save</button>
                            	</div>  
                            </div>                          
                          </td>
                        </tr>
                    	</form>
						</s:iterator>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
           </div>
           </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2018 <a href="https://www.templatewatch.com/" target="_blank">TTT</a>. All rights reserved.</span>
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
  <script src="../vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="../js/off-canvas.js"></script>
  <script src="../js/hoverable-collapse.js"></script>
  <script src="../js/template.js"></script>
  <script src="../js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
  </div>
  </s:if>
</body>

</html>