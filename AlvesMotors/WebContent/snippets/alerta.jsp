<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${mensagem != null}">
	<div class="alert ${mansagemStatus eq 'ERRO' ? 'alert-danger' : 'alert-success'} alert-dismissible fade in">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		${mensagem}
	</div>
</c:if>