<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="">
	<head>
		<title>新增公布訊息</title>
		<sx:head debug="false" cache="false" parseContent="false"	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
		<script src="<%= request.getContextPath()%>/ckeditor/ckeditor.js"></script>
	
	</head>
	<body>
		<h3>新增公布欄訊息:</h3>
		<s:form action="addBillboard" enctype="multipart/form-data" namespace="/billboard">
			<s:textfield name="billboardVO.bill_title" label="標題" />
			<sx:datetimepicker name="billboardVO.bill_start" label="開始日期"	type="date" displayFormat="yyyy-MM-dd " id="picker1" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" />
			<sx:datetimepicker name="billboardVO.bill_end" label="結束日期"	type="date" displayFormat="yyyy-MM-dd " id="picker2" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" />
			<s:textfield name="billboardVO.bill_name"   label="公佈者" value="Administrator"  readonly="true"/>
			<s:textarea name="billboardVO.bill_content"  id="editor1" class="ckeditor" label="公佈欄內容" />
			
		    <s:submit value="送出新增" method="add" />
		</s:form>

		<ckeditor:replace replace="editor1" basePath="/billboard/ckeditor/" />
		           
	</body>
</html>