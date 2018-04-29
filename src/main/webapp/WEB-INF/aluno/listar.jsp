<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>

<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<style type="text/css">
@import url("${path}/assets/bootstrap/css/bootstrap.min.css");

@import url("${path}/assets/bootstrap/css/bootstrap-theme.min.css");
</style>
</head>

<body>

	<c:if test="${not empty mensagensErro}">

		<div class="container">

			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>Ops, ocorrem os seguintes erros:</h3>

				<c:forEach items="${mensagensErro}" var="mensagem">

					<p>
						<strong>${mensagem.getField()}</strong>
						${mensagem.getDefaultMessage()}
					</p>

				</c:forEach>

			</div>

		</div>

	</c:if>

	<c:if test="${not empty mensagemSucesso}">

		<div class="container">

			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3>${mensagemSucesso}</h3>

			</div>

		</div>

	</c:if>

	<section class="container">
	
		<jsp:include page="../table-listar.jsp"></jsp:include>
	
	</section>

	<script type="text/javascript"
		src="${path}/assets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${path}/assets/bootstrap/js/bootstrap.min.js"></script>
		
	<jsp:include page="../modal-add-edit.jsp"></jsp:include>

</body>
</html>