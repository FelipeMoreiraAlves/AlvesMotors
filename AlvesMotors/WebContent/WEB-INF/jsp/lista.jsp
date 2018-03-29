<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../snippets/cabecalho.jsp"></jsp:include>
<title>AlvesMotors | Listar Veículos</title>
</head>
<body>
	<jsp:include page="../../snippets/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<jsp:include page="../../snippets/alerta.jsp"></jsp:include>
				<div class="panel panel-default">
					<div class="panel-heading panel-heading-btn clearfix">
						<h3 class="panel-title pull-left">Veículos</h3>
						<a href="sistema?acao=ExportaVeiculos"
							class="btn btn-success pull-right">Exportar <i class="fa fa-download"></i></a>
					</div>
						<table
							class="table table-striped table-bordered table-hover no-margin">
							<thead>
								<tr>
									<th>#</th>
									<th>Placa</th>
									<th>Modelo/Ano</th>
									<th>Motor</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="veiculo" items="${veiculos}">
									<tr>
										<td>${veiculo.id}</td>
										<td>${veiculo.placa}</td>
										<td>${veiculo.modelo} / ${veiculo.ano}</td>
										<td>${veiculo.motor}</td>
										<td class="actions"><a
											href="sistema?acao=EditaVeiculo&id=${veiculo.id}"
											class="btn btn-info btn-sm" title="Editar"><i
												class="fa fa-pencil"></i></a> <a
											href="sistema?acao=RemoveVeiculo&id=${veiculo.id}"
											class="btn btn-danger btn-sm" title="Remover"><i
												class="fa fa-trash"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../../snippets/rodape.html"></jsp:include>
</body>
</html>