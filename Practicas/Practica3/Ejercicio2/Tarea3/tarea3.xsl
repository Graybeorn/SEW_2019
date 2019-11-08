<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl ="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="text" encoding="UTF-8" indent="yes"/>

  <xsl:template match="/">
    <kml xmlns="http://www.opengis.net/kml/2.2">
      <Document>
        <xsl:for-each select="rutas/ruta">
          <Placemark>
            <xsl:value-of select="nombre"/>
            <LineString>
              <extrude>1</extrude>
              <teselate>1</teselate>
              <coordinates>
                <xsl:text>
</xsl:text>
                <xsl:value-of select="inicio/coordenadas/@longitud"/><xsl:text>,</xsl:text>
                <xsl:value-of select="inicio/coordenadas/@latitud"/><xsl:text>,</xsl:text>
                <xsl:value-of select="inicio/coordenadas/@altitud"/>
                <xsl:for-each select="hitos/hito">
                  <xsl:text>
</xsl:text><xsl:value-of select="coordenadas/@longitud"/>
                  <xsl:text>,</xsl:text><xsl:value-of select="coordenadas/@latitud"/>
                  <xsl:text>,</xsl:text><xsl:value-of select="coordenadas/@altitud"/>
                </xsl:for-each>
              </coordinates>
              <altitudMode>absolute</altitudMode>
            </LineString>
            <Style>
              <xsl:attribute name="id">
                <xsl:value-of select="nombre"/>
              </xsl:attribute>
              <LineStyle>
                <color>#ff0000ff</color>
                <width>5</width>
              </LineStyle>
            </Style>
          </Placemark>
        </xsl:for-each>
      </Document>
    </kml>
  </xsl:template>
</xsl:stylesheet>