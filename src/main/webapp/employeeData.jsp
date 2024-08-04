<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<table>
		<tr>
			<th style="padding:0 15px;"> ID </th>
			<th style="padding:0 15px;"> Name </th>
			<th style="padding:0 15px;"> Status </th>
			<th style="padding:0 15px;"> Hourly Pay Rate </th>
			<th style="padding:0 15px;"> Hours Worked </th>
			<th style="padding:0 15px;"> Salary </th>
		</tr>
		<tr> 
			<td style="padding:0 15px;"> <% String id = request.getAttribute("idFromIndexJspFile").toString();  
					out.println(id);%> 
			</td>
			<td style="padding:0 15px;"> <% String empName = request.getAttribute("nameFromIndexJspFile").toString();  
					out.println(empName);%> 
			</td>
			<td style="padding:0 15px;"> <% String empStatus = request.getAttribute("statusFromIndexJspFile").toString();  
					out.println(empStatus);%> 
			</td>
			<td style="padding:0 15px;"> <% String hourlyRate = request.getAttribute("payRateFromIndexJspFile").toString();  
					out.println(hourlyRate);%>
			</td>
			<td style="padding:0 15px;"> <% String hoursWorked = request.getAttribute("totalHoursFromIndexJspFile").toString();  
					out.println(hoursWorked);%>
			</td>
			<td style="padding:0 15px;"> <% String salary = request.getAttribute("calculatedSalary").toString();  
					out.println(salary);%> 
			</td>
		</tr>
	</table>

</body>
</html>