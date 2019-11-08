<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl ="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes"/>

  <xsl:param name="tipoRuta" select ="'tipo'" />
  
  <xsl:template match="/">
    <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
    <html lang="es">
      <head>
        <title>Guía de rutas turísticas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <link rel="stylesheet" type="text/css" href="tarea1.css"></link>
      </head>
      <body>
        <h1>Lista de rutas turísticas</h1>
        <xsl:for-each select ="rutas/ruta">
          <section>
			  <h2> <xsl:value-of select="nombre"/> </h2>
			  <table>
				<tr>
				  <th>Tipo</th>
				  <th>Medio</th>
				  <th>Duración</th>
				  <th>Agencia</th>
				  <th>Adecuado para</th>
				  <th>Recomendación</th>
				</tr>
				<tr>
				  <td>  <xsl:value-of select="@tipo"/> </td>
				  <td>  <xsl:value-of select="@medio"/> </td>
				  <td>  <xsl:value-of select="@duracion"/> </td>
				  <td>  <xsl:value-of select="@agencia"/> </td>
				  <td>  <xsl:value-of select="@adecuadoPara"/> </td>
				  <td>  <xsl:value-of select="@recomendacion"/> </td>
				</tr>
			  </table>

			  <p>
				Inicio en:  <xsl:value-of select="inicio/lugar"/> ( <xsl:value-of select="inicio/@direccion"/>). <br/>
				
				x,y,z:<xsl:text> </xsl:text><xsl:value-of select="inicio/coordenadas/@latitud"/> 
				<xsl:text>, </xsl:text><xsl:value-of select="inicio/coordenadas/@longitud"/>
				<xsl:text>, </xsl:text><xsl:value-of select="inicio/coordenadas/@altitud"/> <xsl:text>m.</xsl:text> <br/>

				<xsl:if test="fechaInicio">
				  <xsl:value-of select="fechaInicio"/>
				</xsl:if>
				<xsl:if test="horaInicio">
				  <xsl:if test="fechaInicio">
					<xsl:text>, </xsl:text>
				  </xsl:if>
				  <xsl:value-of select="horaInicio"/>
				</xsl:if>
			  </p>

			  <xsl:for-each select="hitos/hito">
				<h3>
				  <xsl:value-of select="nombreHito"/>
				</h3>
				<p>
				  x,y,z: <xsl:text> </xsl:text><xsl:value-of select="coordenadas/@latitud"/>
				  <xsl:text>, </xsl:text><xsl:value-of select="coordenadas/@longitud"/>
				  <xsl:text>, </xsl:text><xsl:value-of select="coordenadas/@altitud"/>  <xsl:text>m </xsl:text>
				  (<xsl:value-of select="@distancia"/><xsl:value-of select="@unidades"/>)
				</p>
				<p>
				  <xsl:value-of select="descripcionHito"/>
				</p>
				
				<h4>Imágenes</h4>
				<xsl:for-each select="imagenes/imagen">
				  <img alt="No se puede mostrar la imagen">
					<xsl:attribute name="src">
					  <xsl:value-of select="."/>
					</xsl:attribute>
				  </img>
				</xsl:for-each>
				
				<xsl:if test="videos/video">
				  <h4>Vídeos</h4>
				  <xsl:for-each select="videos/video">
					<video width="320" height="240" controls="">
					  <source  type="video/mp4">
						<xsl:attribute name="src">
						  <xsl:value-of select="."/>
						</xsl:attribute>
					  </source>
					  <xsl:if test="contains(., '.mp4')">
						<source  type="video/mp4">
						  <xsl:attribute name="src">
							<xsl:value-of select="."/>
						  </xsl:attribute>
						</source>
					  </xsl:if>
					  <xsl:if test="contains(., '.ogg')">
						<source  type="video/ogg">
						  <xsl:attribute name="src">
							<xsl:value-of select="."/>
						  </xsl:attribute>
						</source>
					  </xsl:if>
					  Your browser does not support the video tag.
					</video>
				  </xsl:for-each>
				</xsl:if> 
			  </xsl:for-each>

			  <ul>
			  <xsl:for-each select="bibliografia/ref">
				<li>
				  <xsl:value-of select="."/>
				</li>
			  </xsl:for-each>
			  </ul>
          </section>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
  
</xsl:stylesheet>