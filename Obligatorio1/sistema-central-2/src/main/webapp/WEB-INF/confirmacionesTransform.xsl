<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output omit-xml-declaration="yes" method="xml" indent="yes"/>
	<xsl:strip-space elements="*" />
	<xsl:template match="/">
		<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
			<S:Body>
				<ns2:recepcionPagosResponse xmlns:ns2="http://services.middleware.fing.org/">
					<return>
						<xsl:for-each select="root/confirmacion">
							<confirmacion>
								<descripcion><xsl:value-of select="descripcion"/></descripcion>
								<identificadorPago><xsl:value-of select="identificadorPago"/></identificadorPago>
								<resultado><xsl:value-of select="resultado"/></resultado>
							</confirmacion>
						</xsl:for-each>
					</return>
				</ns2:recepcionPagosResponse>
			</S:Body>
		</S:Envelope>
	</xsl:template>
</xsl:stylesheet>