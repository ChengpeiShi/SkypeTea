<%-- 
    Document   : employeeView
    Created on : 21-Oct-2013, 3:23:29 PM
    Author     : wanfeiliu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<html>
<head>
	<title>Web-Based Enterprise Asset Management System</title>
	<link href="CSS/main.css" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>


<body>
    <!--WRAPPER START-->
    <div id="outerWrapper">
        <div id="wrapper">
            <!--HEADER START--><!--HEADER START-->
<div id="head">
    <!--LOGO START-->
    <div id="logo">
        <div id="logocenter">
            <img src="img/CBSE.jpg" alt="CBSE/"></img> &nbsp;&nbsp;&nbsp;<font size="5">Web-Based Enterprise Asset Management System</font>
        </div>
    </div>
    <!--LOGO END-->
    <!--MENU (TOP) START-->
    <div id="menutab">
    </div>
    <!--MENU (TOP) END-->
</div>
<!--HEADER END-->


            <!--HEADER END-->

            <!--Center Div Start-->
            <div id="centerbody">
                <!-- MAIN CONTENT CONTAINER START--> 
                <div id="outerColumnContainer">
                    <!--LEFT COLUMN OUTTER START--><!--LEFT COLUMN OUTTER START-->
<div id="leftColumn">
    <!--LEFT (MENU) START-->
    <div class='nav'>
        
        <ul>
            <li><a href='/ECE658-project/index.html'><b>Home</b></a></li>
            <li><b>Employees</b></li>
            <ul>
                <li><a href='/ECE658-project/employeeAdd.jsp'>Add an employee</a></li>
                <li><a href='/ECE658-project/showEmployee'>Show all employees</a></li>

                <li><a href='/ECE658-project/showEmployee?type=sick'>Show sick employees</a></li>

                <li><a href='/ECE658-project/showEmployee?type=offsite'>show off-site employees</a></li>

                <li><a href='/ECE658-project/showEmployee?type=onsite'>show in-office employees</a></li>
                <li><FORM ACTION="/ECE658-project/showEmployee" METHOD="POST"> 
                        Employee Name: <INPUT TYPE="TEXT" NAME="employeename"><BR>
                        
                        <CENTER>
                        <INPUT TYPE="SUBMIT" VALUE="Search">
                        </CENTER>
                     </FORM>
            
                </li>
                <li><FORM ACTION="/ECE658-project/deleteEmployee" METHOD="POST"> 
                        Employee ID: <INPUT TYPE="number" NAME="id"><BR>
                        
                        <CENTER>
                        <INPUT TYPE="SUBMIT" VALUE="Delete">
                        </CENTER>
                     </FORM>
            
                </li>

            </ul>
           <!-- <li><b>Equipment</b></li>
            <ul>
                <li><a href='/ECE658-project/showEquipment?type=all'>Show all Equipment</a></li>

                <li><a href='/ECE658-project/showEquipment?type=windows'>Show Windows System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=ubuntu'>show ubuntu System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=mac'>show Mac System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=on'>show Power-on System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=off'>show Power-off System</a></li>
                <li><FORM ACTION="/ECE658-project/showEquipment" METHOD="POST"> 
                        Equipment ID: <INPUT TYPE="TEXT" NAME="equipmentid"><BR>
                        <CENTER>
                        <INPUT TYPE="SUBMIT" VALUE="Search">
                        </CENTER>
                     </FORM>
            
                </li>

            </ul>-->
            
        </ul> 
    </div>
</div>
<!--LEFT (MENU) END-->


                    <!--LEFT (MENU) END-->

                    <!--RIGHT COLUMN START--> <!--RIGHT COLUMN START--> 
<div id="rightColumn">
    <!--RIGHT MENU START -->
    <div class="rightcolumninner" id="rightcolumnin
         ner">
        <h1 >References</h1>
        <p><a href='http://stargroup.uwaterloo.ca/~ece658/'> [ECE658 Course Website]</a></p>
        <h1 >Coming Next</h1>
        <h2>Security enhancement</h2>
    </div>
    <!--RIGHT MENU END-->      
</div>
<!--RIGHT COLUMN end--> 


                    <!--RIGHT COLUMN end--> 

                    <!--OUTER CENTER CONTAINER START--><!--OUTER CENTER CONTAINER START-->
<div id="contentcolumn">
    <!--CENTER CONTENT START-->
    <div class="contentcolumninner" id="contentcolumninner">
    <h1>Report Results</h1>
        <table border="2" width=50% height=50%>
  <%--         
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
                   
            </tr>
           
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                 
                    <c:forEach var="column" items="${row}" varStatus = "rowCounter">
                        <c:choose>
                        
                        <c:when test="${rowCounter.count < 8}">
                        <td><c:out value="${column}"/></td>
                        <c:if test="${rowCounter.count ==6 }">
                            <c:set  var="phone" value = "${column}"/>
                        </c:if>
                        
                        </c:when>                  
                        
                        <c:otherwise>
                        <c:set var="name" scope="page" value="${column}"/>
                        <script type="text/javascript" src="http://www.skypeassets.com/i/scom/js/skype-uri.js"></script>
                        <td>
                            <a href="skype:+${phone}?call">&nbsp&nbsp&nbsp&nbsp;Call me</a>
                            <div id="SkypeButton_Dropdown_${name}_1">
                            <script type="text/javascript">
                            Skype.ui({
                                 "name": "dropdown",
                                  "element": "SkypeButton_Dropdown_${name}_1",
                                  "participants": ["${name}"],
                                 "imageSize": 45
                                     });
                            </script>
                            </div>
                        </td>
                        </c:otherwise>
                    </c:choose>
                    </c:forEach>
                       
                </tr>
                
            
            </c:forEach> --%>
  <tr>
               <th>Employee ID</th>
               <th>Name</th>
               <th>Department</th>
               <th>Age</th>
               <th>Email</th>
               <th>Phone</th>
               <th>Status</th>
               <th>Skype</th>
           </tr>
           <c:forEach var = "col" items="${result}">
                <tr>
                    <td><c:out value ="${col.getId()}"/></td>
                    <td><c:out value ="${col.getName()}"/></td>
                    <td><c:out value ="${col.getDept()}"/></td>
                    <td><c:out value ="${col.getAge()}"/></td>
                    <td><c:out value ="${col.getEmail()}"/></td>
                    <td><c:out value ="${col.getPhone()}"/></td>
                    
                    <td><c:out value ="${col.getStatus()}"/></td>
                    <script type="text/javascript" src="http://www.skypeassets.com/i/scom/js/skype-uri.js"></script>
                    <td><a href="skype:+${col.getPhone()}?call">&nbsp&nbsp&nbsp&nbsp;Call me</a>
                            <div id="SkypeButton_Dropdown_${col.getSkype()}_1">
                            <script type="text/javascript">
                            Skype.ui({
                                 "name": "dropdown",
                                  "element": "SkypeButton_Dropdown_${col.getSkype()}_1",
                                  "participants": ["${col.getSkype()}"],
                                 "imageSize": 45
                                     });
                            </script>
                            </div></td>
                </tr>
           </c:forEach>
         

  
  
  
  
        </table>                
    </div>
    <!--CENTER CONTENT END-->

    <div style="clear: both;"></div>

</div>


	            </div>
                <!-- MAIN CONTENT CONTAINER END-->     
	        </div>
            <!-- MAIN CONTENT CONTAINER END--> 
        </div>
        <!--Body Center End-->
    </div>
    <!--WRAPPER END-->    <div id="footer">  
        <!--FOOTER CONTENT START-->
        <div class="footertext" id="footerleft">This website is copyright (C) 2013 ECE658-G8. All rights reserved.
        </div>
        <!--FOOTER CONTENT END -->
    </div>


    <!-- OUTER WRAPPER END -->
</body>    
</html>
