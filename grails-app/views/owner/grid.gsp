<%@ page import="com.alworoud.Owner" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
                <g:set var="entityName" value="${message(code: 'owner.label', default: 'Owner')}" />
		<title><g:message code="default.grid.label" args="[entityName]" /></title>
                <r:script>
                    function linkId(cellvalue, options, rowObject) {
                        return "<a href='/pmpweb/owner/show/" + cellvalue + "'>" + cellvalue + "</a> ";
                    }
                </r:script>
                <r:require modules="easygrid-jqgrid-dev"/>
        </head>
	<body>
		<div class="row-fluid">
			<g:render template="/sidemenu" model="[active: 'grid']"/>
                        <div class="span9">
                          
                                <div class="page-header">
					<h1><g:message code="default.grid.label" args="[entityName]" /></h1>
				</div>
				
				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

                                <grid:exportButton name='ownerGrid'/>
                                <grid:grid  name="ownerGrid"/>
                        </div>
                </div>
	</body>
</html>
