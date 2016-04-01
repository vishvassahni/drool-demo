<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Petrol Breakup Information</title>
</head>
<body>
	<form:form method="POST" action="showInfo">
		<table>
			<tr bgcolor="yellow">
				<td colspan="2">Fuel Information</td>
			</tr>
			<tr>
				<td><form:label path="purchaseState">State</form:label></td>
				<td><form:select path="purchaseState">
						<form:option value="DELHI">DELHI</form:option>
						<form:option value="UP">UP</form:option>
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="typeofItem">Fuel Type</form:label></td>
				<td><form:select path="typeofItem">
						<form:option value="PETROL">PETROL</form:option>
						<form:option value="DIESEL">DIESEL</form:option>
					</form:select></td>
			</tr>

			<tr>
				<td><form:label path="fuelAmount">Amount</form:label></td>
				<td><form:input path="fuelAmount"
						value="${itemState.fuelAmount}"></form:input></td>
			</tr>
			
			<tr>
				<td><form:label path="unitPrice">Unit Price</form:label></td>
				<td><form:input path="unitPrice"
						value="${itemState.unitPrice}"></form:input></td>
			</tr>

			<tr bgcolor="yellow">
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>

			<c:if test="${!empty itemState}">
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr bgcolor="yellow">
					<td colspan="2">Breakup Summary</td>
				</tr>
				<tr>
					<td><form:label path="unitPrice">Price per Ltr.</form:label></td>
					<td>${itemState.unitPrice}</td>
				</tr>
				
				<tr>
					<td><form:label path="fuelAmount">Amount paid for fuel</form:label></td>
					<td>${itemState.fuelAmount}</td>
				</tr>
				<tr>
					<td><form:label path="unit">Total fuel units</form:label></td>
					<td>${itemState.unit}</td>
				</tr>
				<tr>
					<td><form:label path="taxType1">Raw Crude Oil Cost</form:label></td>
					<td>${itemState.taxType1}</td>
				</tr>
				<tr>
					<td><form:label path="taxType2">Refining Cost, Transportation, Freight, Dealer Commission</form:label></td>
					<td>${itemState.taxType2}</td>
				</tr>
				<tr>
					<td><form:label path="taxType3">Taxes - Excise, VAT, Cess</form:label></td>
					<td>${itemState.taxType3}</td>
				</tr>
				
			</c:if>

		</table>
	</form:form>
</body>
</html>
