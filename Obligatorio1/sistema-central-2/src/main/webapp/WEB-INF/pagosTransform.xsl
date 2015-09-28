<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service" xmlns:ser="http://services.middleware.fing.org/">
	<xsl:template match="/">
		<payload>
			<xsl:for-each select="soapenv:Envelope/soapenv:Body/ser:recepcionPagos/arg0/pagos">
			
				<pagos>
					<codigoMoneda>
						<xsl:value-of select="codigoMoneda"/>
					</codigoMoneda>
					<datoAdicional>
						<xsl:value-of select="datoAdicional"/>
					</datoAdicional>
					<identificadorPago>
						<xsl:value-of select="identificadorPago"/>
					</identificadorPago>
					<monto>
						<xsl:value-of select="monto"/>
					</monto>
					<nombreGestion>
						<xsl:value-of select="nombreGestion"/>
					</nombreGestion>
					<fecha>
						<xsl:value-of select="/soapenv:Envelope/soapenv:Body/ser:recepcionPagos/arg0/fechaCobro"/>
					</fecha>
				</pagos>
			
			</xsl:for-each>
		</payload>
	</xsl:template>
</xsl:stylesheet>