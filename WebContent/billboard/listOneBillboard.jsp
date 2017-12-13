<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="">
	<head>
		<title>修改公布欄資料</title>
		<s:head theme="xhtml"  /><!-- 預設 -->
		<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/listAllBillboard.css">
	</head>
	<body >	
		<h3>公佈欄資料:</h3>
		<s:form>
		    <s:hidden name="billboardVO.bill_id" label="編號" value="%{#request.billboardVO.bill_id}"  readonly="true" cssStyle="background:gray" />
			<s:label for="billboardVO.bill_title"   label="標題者" value="%{#request.billboardVO.bill_title}"/>				
			<sx:datetimepicker name="billboardVO.bill_start"  label="開始日期"  type="date" displayFormat="yyyy-MM-dd"  id="picker1" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" value="%{#request.billboardVO.bill_start}" />
			<sx:datetimepicker name="billboardVO.bill_end"  label="結束日期"  type="date" displayFormat="yyyy-MM-dd"  id="picker2" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" value="%{#request.billboardVO.bill_end}" />
			<s:label for="billboardVO.bill_name"   label="公佈者" value="%{#request.billboardVO.bill_name}" readonly="true" />
			<s:textarea  cols="80" rows="10" id="editor1" name="billboardVO.bill_content"  label="公佈欄內容" value="%{#request.billboardVO.bill_content}" readonly="true"/>
			<s:property value="#request.news.content" escape="false"/>		
		</s:form>
		<div class="backlist">
			<a href="<s:url value="/billboard/listAllBillboard.jsp"  />" target="_blank">回公佈欄清單</a>
		</div>
			
		
				
		
		<ckeditor:replace replace="editor1" basePath="/billboard/ckeditor/" />
	</body>
</html>