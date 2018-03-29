<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../snippets/cabecalho.jsp"></jsp:include>
<title>AlvesMotors | Editar Veículo</title>
</head>
<body>
	<jsp:include page="../../snippets/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<jsp:include page="../../snippets/alerta.jsp"></jsp:include>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Editar Veículo</h3>
					</div>
					<div class="panel-body">
						<form method="post" action="sistema?acao=AlteraVeiculo">
							<input type="hidden" name="id_veiculo"
								value="${veiculo.id_veiculo}">
							<div class="row">
								<div class="col-xs-12 col-md-12 col-lg-6">
									<div class="form-group">
										<label for="modelo">Modelo</label> <input type="text"
											name="modelo" id="modelo" class="form-control" maxlength="50"
											value="${veiculo.modelo}" readonly="readonly">
									</div>
								</div>
								<div class="col-xs-12 col-md-6 col-lg-3">
									<div class="form-group">
										<label for="placa">Placa</label> <input type="text"
											name="placa_old" id="placa_old" class="form-control"
											maxlength="8" value="${veiculo.placa}" readonly="readonly">
									</div>
								</div>
								<div class="col-xs-12 col-md-6 col-lg-3">
									<div class="form-group">
										<label for="placa">Placa Nova</label> <input type="text"
											name="placa" id="placa" class="form-control" maxlength="8">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-md-6 col-lg-3">
									<div class="form-group">
										<label for="ano">Ano</label> <input type="text" name="ano"
											id="ano" class="form-control" placeholder="2000"
											maxlength="4" value="${veiculo.ano}" readonly="readonly">
									</div>
								</div>
								<div class="col-xs-12 col-md-6 col-lg-3">
									<div class="form-group">
										<label for="motor">Motor</label> <input type="text"
											name="motor" id="motor" class="form-control"
											placeholder="1.0" value="${veiculo.motor}"
											readonly="readonly">
									</div>
								</div>
							</div>
							<div class="text-right">
								<a href="sistema?acao=ListaVeiculos" class="btn btn-default"
									title="Cancelar">Cancelar</a> <input class="btn btn-primary" type="submit"
									value="Alterar">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../../snippets/rodape.html"></jsp:include>
</body>
</html>