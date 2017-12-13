<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.billboard.model.*"%>

<%
	BillboardService billboardSvc = new BillboardService();
	List<BillboardVO> list = billboardSvc.getAll();
	pageContext.setAttribute("list",list);
	
%>


<html>
<head>
<title>瀏覽公布事項</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/listAllBillboard.css">
</head>
<body>
	<c:if test="${empty list}">
		<font color="red">無資料</font><br>
	</c:if>	



<table>
	<tr>
		<th class="col1">標題</th>
		<th class="col2">發布日期</th>
		<th class="col3">截止日期</th>
		<th class="col4">修改</th>
		<th class="col5">刪除</th> 
	</tr>
	<%@ include file="/pages/page1.file" %>  
	
	<c:forEach var="billboardVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td class="col1">${billboardVO.bill_title}</td>
			<td class="col2">${billboardVO.bill_start}</td>
			<td class="col3">${billboardVO.bill_end}</td>
	
			<td class="col4">
			<s:form action="getOne_For_UpdateBillboard" namespace="/billboard"  method="getOne_For_Update">
			       <s:submit value="修改" />
			       <input type="hidden" name="bill_id" value="${billboardVO.bill_id}">
			</s:form>
			</td>
			<td class="col5">
			<s:form action="deleteBillboard" namespace="/billboard"  method="delete">
			    <s:submit value="刪除" />
			    <input type="hidden" name="bill_id" value="${billboardVO.bill_id}">
			</s:form>
			</td>
		</tr>
	</c:forEach>	
</table>
<br>
<div class="button">	
			<a href="addBillboard.jsp">新增</a>
</div>

		
<%@ include file="/pages/page2.file" %>

</body>
</html>
