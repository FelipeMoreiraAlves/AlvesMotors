<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<jsp:include page="snippets/cabecalho.jsp"></jsp:include>
<title>AlvesMotors | Administração de Veículos</title>
</head>
<body>
	<jsp:include page="snippets/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<c:if test="${sessaoEncerrada == null}">
					<div class="jumbotron">
						<h1>Bem vindo!</h1>
						<p>Com o sistema AlvesMotors, você pode Cadastrar, Listar
							e Atualizar veículos, além de conseguir gerar uma planilha com os
							veículos fabricados no ano de 2017.</p>
						<p>
							<a class="btn btn-primary btn-lg"
								href="sistema?acao=ListaVeiculos" role="button">Listar
								Veículos</a> <a class="btn btn-primary btn-lg" href="cadastra.jsp"
								role="button">Cadastrar Veículo</a>
						</p>
					</div>
				</c:if>
				<c:if test="${sessaoEncerrada == true}">
					<h2>Sessão Expirada!</h2>
					<p class="lead">Por favor, siga as seguintes instruções para
						que o acesso volte ao normal.</p>
					<ul>
						<li>Feche todas as janelas do seu navegador</li>
						<li>Reinicie o servidor</li>
						<li>Caso ainda esteja vendo essa tela, limpe o histórico do
							navegador e repita os passos anteriores</li>
					</ul>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>