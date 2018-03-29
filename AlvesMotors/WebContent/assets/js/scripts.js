(function() {
	"use strict";
	
	$(document).ready(function() {
		$("#ano").mask("0000");
		$("#placa").mask("SSS-0000");
		$("#motor").priceFormat({
			 prefix: "",
			 limit: 2,
			 centsLimit: 1
		});
	});
})();