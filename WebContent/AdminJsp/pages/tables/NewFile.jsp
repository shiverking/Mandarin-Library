<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
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
                    <form action="editLibrarian" method="post">
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
                           <s:property value="LibrarianID"/>
                          </td>
                          <td>
                           <s:property value="LibrarianName"/>
                          </td>
                          <td>
                            <s:property value="Email"/>
                          </td>
                          <td>
                            <s:property value="Password"/>
                          </td>
                          <td >
                            <!-- <a href='deleteBook?book.BookID=<s:property value="BookID"/>'>Delete/</a> -->
                            <input id="edit" type="button" >
                            <a id="save" style="display:none" href='editLibrarian?librarian.LibrarianID=<s:property value="LibrarianID"/>
                            '>save/</a>
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
</body>
</html>