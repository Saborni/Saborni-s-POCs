<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="cargo"><xsl:text>&#10;</xsl:text>
        <xsl:value-of select="carriercode"/><xsl:value-of select="aircraftcode"/>/<xsl:text>&#10;</xsl:text>
        <xsl:value-of select="origin"/><xsl:value-of select="destination"/>/<xsl:text>&#10;</xsl:text>
        <xsl:value-of select="departure/ddate"/><xsl:value-of select="departure/dtime"/>/<xsl:text>&#10;</xsl:text>
        <xsl:value-of select="arrival/adate"/><xsl:value-of select="arrival/atime"/>/
    </xsl:template>
</xsl:stylesheet>