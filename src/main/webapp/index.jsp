<html>
<body bgcolor="cyan">
	<h2>Payroll System</h2>
	<form action="employees" method="post">
		<label for="id"> Id:</label>
		<input type="text" id="id" name="EmpID" placeholder="Create an Id" />
		<br>
		<label for="employeeName"> Name:</label>
		<input type="text" id="employeeName" name="EmpName" placeholder="Enter employee name" />
		<br>
		
		<label for="status"> Status:</label>
		<!--  <input type="text" id="status" name="EmpStatus" placeholder="Full time or part time" /> -->
		<select name="EmpStatus" id="status">
			<option value="seelct one">Select One </option>
			<option value="fullTime">Full Time</option>
			<option value="partTime">Part Time </option>
			
		</select>
		<div style="color:green;"><medium>Status = <b>full time:</b> skip to salary part</medium><br>
							<medium>Status = <b>part time:</b> leave salary field empty</medium>
		</div>
		<br>
		<label for="hurlyRate"> Hourly pay rate:</label>
		<input type="text" id="hourlyRate" name="EmpRate" placeholder="Enter hourly pay rate" />
		<br>
		<label for="totalHours"> Total hours worked:</label>
		<input type="text" id="totalHours" name="EmpTotalHours" placeholder="Enter total hours worked" />
		<br>
	<label for="salary"> Salary:</label>
		<input type="text" id="salary" name="EmpSalary" placeholder="Enter salary" />
		<br>
		<button>Submit</button>
	</form>
</body>
</html>
