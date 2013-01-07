<%@ page import="com.alworoud.Owner" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
                <g:set var="entityName" value="${message(code: 'owner.label', default: 'Owner')}" />
		<title><g:message code="default.grid.label" args="[entityName]" /></title>
                <r:script>
                    function linkId(cellvalue, options, rowObject) {
                        return "<a href='/pmpweb/unit/show/" + cellvalue + "'>" + cellvalue + "</a> ";
                    }
                </r:script>
                <r:require modules="easygrid-jqgrid-dev"/>
        </head>
	<body>
		<div class="row-fluid">
			
			<div class="span3">
				<div class="well">
					<ul class="nav nav-list">
                                                <li class="nav-header">${entityName}</li>
						<li>
							<g:link class="list" action="list">
								<i class="icon-list"></i>
								<g:message code="default.list.label" args="[entityName]" />
							</g:link>
						</li>
						<li>
							<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
						</li>
                                                <li class="active">
							<g:link class="grid" action="grid">
								<i class="icon-th"></i>
								<g:message code="default.grid.label" args="[entityName]" />
							</g:link>
						</li>
					</ul>
				</div>
			</div>
                        <div class="span9">
                          
                                <div class="page-header">
					<h1><g:message code="default.grid.label" args="[entityName]" /></h1>
				</div>
				
				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>

                                <grid:exportButton name='unitGrid'/>
                                <grid:grid  name="unitGrid"/>
                        </div>
                </div>
	</body>
</html>
