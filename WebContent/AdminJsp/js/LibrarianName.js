/**
 * 
 */
function doTest(){
var value = $("#navbar-search-input").val();//获得选中项的值
$('#a1').attr('href','pages/searchResult.jsp?librarian.LibrarianName='+value+'');
}