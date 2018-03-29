<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-collapse"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">AlvesMotors</a>
		</div>
		<c:if test="${sessaoEncerrada == null}">
			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="sistema?acao=ListaVeiculos">Listar</a></li>
					<li><a href="cadastra.jsp">Cadastrar</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="sistema?acao=Sair">Sair <i
							class="fa fa-sign-out"></i></a></li>
				</ul>
			</div>
		</c:if>
	</div>
</nav>