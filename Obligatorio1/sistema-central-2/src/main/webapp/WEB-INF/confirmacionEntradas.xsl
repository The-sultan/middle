<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns2="http://spring.io/guides/gs-producing-web-service">
	<xsl:output omit-xml-declaration="yes" method="xml" indent="yes"/>
	<xsl:strip-space elements="*" />
	<xsl:param name="pago"/>
	<xsl:template match="/">
		<confirmacion>
			<xsl:for-each select="S:Envelope/S:Body/ns2:ventaEntradasResponse/return">
				<descripcion><xsl:call-template name="join">
						<xsl:with-param name="list" select="codigosEntradas" />
						<xsl:with-param name="separator" select="','" />
					</xsl:call-template></descripcion>
				<identificadorPago>
					<xsl:value-of select="$pago"/>
				</identificadorPago>
				<resultado>OK</resultado>
			</xsl:for-each>
		</confirmacion>
	</xsl:template>
	
	<xsl:template name="join">
		<xsl:param name="list" />
		<xsl:param name="separator"/>
		[<xsl:for-each select="$list">
			<xsl:value-of select="." />
			<xsl:if test="position() != last()">
				<xsl:value-of select="$separator" />
			</xsl:if>
		</xsl:for-each>]
	</xsl:template>
</xsl:stylesheet>