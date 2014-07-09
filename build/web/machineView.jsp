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
            <!--<li><b>Employees</b></li>
            <ul>
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
            </ul>-->
            <li><b>Equipment</b></li>
            <ul>
                <li><a href='/ECE658-project/machineAdd.jsp'>Add a Machine</a></li>
                <li><a href='/ECE658-project/showEquipment?type=all'>Show all Equipment</a></li>

                <li><a href='/ECE658-project/showEquipment?type=windows'>Show Windows System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=ubuntu'>show ubuntu System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=mac'>show Mac System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=on'>show Power-on System</a></li>

                <li><a href='/ECE658-project/showEquipment?type=off'>show Power-off System</a></li>
                <li><FORM ACTION="/ECE658-project/showEquipment" METHOD="POST"> 
                        Equipment ID: <INPUT TYPE="number" NAME="equipmentid"><BR>
                        <CENTER>
                        <INPUT TYPE="SUBMIT" VALUE="Search">
                        </CENTER>
                     </FORM>
            
                </li>
                <li><FORM ACTION="/ECE658-project/deleteEquipment" METHOD="POST"> 
                        Equipment ID: <INPUT TYPE="number" NAME="id"><BR>
                        <CENTER>
                        <INPUT TYPE="SUBMIT" VALUE="Delete">
                        </CENTER>
                     </FORM>
            
                </li>

            </ul>
            
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
            <!-- column headers -->
            <%--     <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}" varStatus = "rowCounter">
                        <c:choose>
                        
                        <c:when test="${rowCounter.count < 4}">
                        <td><c:out value="${column}"/></td>
                        
                        </c:when>                  
                        <c:otherwise>
                            <c:set var="name" scope="page" value="${column}"/>
                            <td><a href="skype:${name}?chat">&nbsp&nbsp&nbsp&nbsp;Chat Owner: ${name}</a></td>
                        </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </c:forEach>
            --%>
            <tr>
               <th>Machine ID</th>
               <th>Platform</th>
               <th>Powerstate</th>
               <th>Owner</th>
               
           </tr>
           <c:forEach var = "col" items="${result}">
                <tr>
                    <td><c:out value ="${col.getId()}"/></td>
                    <td><c:out value ="${col.getPlatform()}"/></td>
                    <td><c:out value ="${col.getPowerstate()}"/></td>
                    <td align="left" width="100%"><a href="skype:${col.getOwner()}?chat">&nbsp&nbsp&nbsp&nbsp;Chat Owner: ${col.getOwner()}</a></td>
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
