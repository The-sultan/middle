<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
	<xsl:output omit-xml-declaration="yes" method="xml" indent="yes"/>
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<confirmacion>
			<xsl:for-each select="//pagos">
				<descripcion>Pago confirmado</descripcion>
				<identificadorPago><xsl:value-of select="identificadorPago"/></identificadorPago>
				<resultado>OK</resultado>
			</xsl:for-each>
		</confirmacion>
	</xsl:template>
</xsl:stylesheet>