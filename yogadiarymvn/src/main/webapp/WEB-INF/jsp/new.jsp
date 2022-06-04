<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@ page import ="model.Account,model.Diary,model.Teacher,model.Login,java.util.List" %>
    <% 
    Teacher teachers=(Teacher)request.getAttribute("teachers");
    Account loginAc=(Account)session.getAttribute("loginAc");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

<title>New day</title>
</head>
<body>
<div class="mx-auto" style="width:300px">
	<h1 class = "mb-3" style="text-align:center">YOGA DIARY</h1>
	<form action="/yogadiarymvn/NewServlet" method="post">

	<div class="mb-3">
		<label for="myName" class="form-label">your name</label>
		<select id="myName" name="myName" class="form-control">
			<option name="name" value="<%=loginAc.getUserName() %>"><%=loginAc.getUserName() %></option>
		</select> 
	</div>


	<div class="mb-3">
		<label for="date" class="form-label">date</label>
		<input type="date" class="form-control" id="date" name="date">
	</div>
	
	<div class="mb-3">
		<label for="weather" class="form-label">weather</label>
		<select id="weather" name="weather" class="form-control">
				<option name="sunny" value="☀">sunny️</option>
				<option name="rainy" value="🌂">rainy</option>
				<option name="cloudy" value="☁">cloudy️</option>
				<option name="snow" value="❄">snow️</option>
				<option name="stolm" value="🌀">stolm</option>
		</select>
	</div>
	
	<div class="mb-3">
		<label for="covid19" class="form-label">COVID-19</label>
		<select id="covid19" name="covid19" class="form-control">
				<option value="0">0</option>	
				<option value="10">10</option>	
				<option value="50">50</option>	
				<option value="100">100</option>	
				<option value="200">200</option>	
				<option value="300">300</option>	
				<option value="400">400</option>	
				<option value="500">500</option>	
				<option value="600">600</option>	
				<option value="700">700</option>	
				<option value="800">800</option>	
				<option value="900">900</option>	
				<option value="1000">1000</option>	
				<option value="1500">1500</option>	
				<option value="2000">2000</option>	
				<option value="2500">2500</option>	
				<option value="3000">3000</option>	
				<option value="3500">3500</option>	
				<option value="4000">4000</option>	
				<option value="4500">4500</option>	
				<option value="5000">5000</option>	
				<option value="5500">5500</option>	
				<option value="6000">6000</option>	
				<option value="6500">6500</option>	
				<option value="7000">7000</option>	
				<option value="7500">7500</option>	
				<option value="8000">8000</option>	
				<option value="8500">8500</option>	
				<option value="9000">9000</option>	
				<option value="9500">9500</option>	
				<option value="10000">10000</option>	
				<option value="15000">15000</option>	
				<option value="20000">20000</option>	
				<option value="25000">25000</option>	
				<option value="30000">30000</option>	
				<option value="45000">45000</option>	
				<option value="50000">50000</option>	
		</select>
	</div>
	
	<div class="mb-3">
		<label for="BBT" class="form-label">BBT</label>
		<select id="BBT" name="BBT" class="form-control">
				<option value="35.0">35.0</option>
				<option value="35.1">35.1</option>
				<option value="35.2">35.2</option>
				<option value="35.3">35.3</option>
				<option value="35.4">35.4</option>
				<option value="35.5">35.5</option>
				<option value="35.6">35.6</option>
				<option value="35.7">35.7</option>
				<option value="35.8">35.8</option>
				<option value="35.9">35.9</option>
				<option value="36.0">36.0</option>
				<option value="36.1">36.1</option>
				<option value="36.2">36.2</option>
				<option value="36.3">36.3</option>
				<option value="36.4">36.4</option>
				<option value="36.5">36.5</option>
				<option value="36.6">36.6</option>
				<option value="36.7">36.7</option>
				<option value="36.8">36.8</option>
				<option value="36.9">36.9</option>
				<option value="37.0">37.0</option>
				<option value="37.5">37.5</option>
				<option value="38.0">38.0</option>
			</select>
		</div>
	
	<div class="mb-3">
			<label for="time" class="form-label">start time
			<input type="time" id="time" name="time"></label>	
		</div>
		</div>
		
		<div style="text-align:center;style="width:300px">
			<input type="radio" id="series" name="series" value="rest">rest
			<input type="radio" id="series" name="series"  value="sunsultation">sun
			<input type="radio" id="series" name="series" value="half">half
			<input type="radio" id="series" name="series"  value="full"checked>full
			<input type="radio" id="series" name="series" value="second">second
			<input type="radio" id="series" name="series"  value="half-class">half-class
			<input type="radio" id="series" name="series"  value="red-class">red-class
		
	
		<div class="mx-auto" style="width:300px">
		<div class="mb-3">
		<label for="teacher" class="form-label">teacher</label>
		
		<select name="teacher" class="form-control">
		<option value="self">self</option>
		<option value="<%=teachers.getTeacher1()%>"><%=teachers.getTeacher1()%></option>
		<option value="<%=teachers.getTeacher2()%>"><%=teachers.getTeacher2()%></option>
		<option value="<%=teachers.getTeacher3()%>"><%=teachers.getTeacher3()%></option>
		<option value="<%=teachers.getTeacher4()%>"><%=teachers.getTeacher4()%></option>
		<option value="<%=teachers.getTeacher5()%>"><%=teachers.getTeacher5()%></option>
		</select></div>
		
		<div class="mb-3">
		<label for="condition" class="form-label">condition</label>
		<input type="text" class="form-control" id="condition" name="condition">
		</div>
		
		<div class="mb-3">
			<input type="checkbox" name="breath" value="★"> breath
			<input type="checkbox" name="vanda" value="★"> vanda
			<input type="checkbox" name="dristi" value="★︎"> dristi
		
		</div>
		
		<div class="mb-3">
		<label for="lunch" class="form-label">yesterday's lunch</label>
		<input type="text" class="form-control" id="lunch" name="lunch">
		</div>
		<div class="mb-3">
		<label for="dinner" class="form-label">yesterday's dinner</label>
		<input type="text" class="form-control" id="dinner" name="dinner">
		</div>
		<div class="mb-3">
		<label for="morning" class="form-label">today's morning</label>
		<input type="text" class="form-control" id="morning" name="morning">
		</div>
	<button type="submit" class="btn new-btn new-btn:hover" >GO </button>
	</form>
	<div style="text-align:center;">
	</div>
		<br><a class="btn btn--yellow btn--cubic" href="/yogadiarymvn/ListServlet"/>DIARY</a>
	</div></div>
	
</body>
</html>
