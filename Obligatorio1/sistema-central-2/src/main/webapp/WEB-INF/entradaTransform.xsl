<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
	<xsl:output omit-xml-declaration="yes" method="xml" indent="yes"/>
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://spring.io/guides/gs-producing-web-service">
			<soapenv:Header/>
			<soapenv:Body>
				<gs:ventaEntradas>
					<arg0>
						<xsl:for-each select="pagos">
							<cantEntradas>
								<xsl:value-of select="datoAdicional"/>
							</cantEntradas>
							<xsl:choose>
								<xsl:when test="codigoMoneda = 'UYU'">
									<monedaID>854</monedaID>
								</xsl:when>
								<xsl:when test="codigoMoneda = 'USD'">
									<monedaID>840</monedaID>
								</xsl:when>
							</xsl:choose>
							<monto>
								<xsl:value-of select="monto"/>
							</monto>
							<fecha>
								<xsl:value-of select="fecha"/>
							</fecha>
						</xsl:for-each>
					</arg0>
				</gs:ventaEntradas>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
</xsl:stylesheet>