<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <!-- Background -->

    <xsl:template name="background_gradient_element">
        <xsl:param name="type"/>
        <xsl:param name="color1"/>
        <xsl:param name="color2"/>
        <xsl:param name="offset"/>
        <xsl:element name="Canvas.Background">
            <xsl:element name="LinearGradientBrush">
                <xsl:element name="GradientStop">
                    <xsl:attribute name="Color">
                        <xsl:value-of select="$color1"/>
                    </xsl:attribute>
                    <xsl:attribute name="Offset">0</xsl:attribute>
                </xsl:element>
                <xsl:element name="GradientStop">
                    <xsl:attribute name="Color">
                        <xsl:value-of select="$color2"/>
                    </xsl:attribute>
                    <xsl:attribute name="Offset">
                        <xsl:value-of select="0 + $offset"/>
                    </xsl:attribute>
                </xsl:element>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <!-- End Background -->

    <!-- Border -->

    <xsl:template name="border_element">
        <xsl:param name="thickness"/>
        <xsl:element name="Border">
            <xsl:attribute name="BorderThickness">
                <xsl:value-of select="$thickness"/>
            </xsl:attribute>
        </xsl:element>
    </xsl:template>

    <!-- End Border -->

    <!-- TextBlock -->

    <xsl:template name="textblock_element">
        <xsl:param name="value"/>
        <xsl:param name="foreground_color"/>
        <xsl:element name="TextBlock">
            <xsl:attribute name="Foreground" select="$foreground_color"/>
            <xsl:value-of select="$value"/>
        </xsl:element>
    </xsl:template>

    <!-- End TextBlock -->

    <!-- Button -->

    <xsl:template name="button_element">
        <xsl:param name="border_brush"/>
        <xsl:param name="button_value"/>
        <xsl:element name="Border">
            <xsl:attribute name="BorderBrush" select="$border_brush"/>
            <xsl:call-template name="textblock_element">
                <xsl:with-param name="value" select="$button_value"/>
                <xsl:with-param name="foreground_color" select="'White'"/>
            </xsl:call-template>
        </xsl:element>
    </xsl:template>

    <!-- End Button -->

    <!-- Canvas -->

    <xsl:template name="canvas_element">

    </xsl:template>

    <!-- End Canvas -->

    <xsl:template match="/">

        <xsl:call-template name="background_gradient_element">
            <xsl:with-param name="type" select="'Canvas'"/>
            <xsl:with-param name="color1" select="'White'"/>
            <xsl:with-param name="color2" select="'Black'"/>
            <xsl:with-param name="offset" select="1"/>
        </xsl:call-template>

        <xsl:call-template name="border_element">
            <xsl:with-param name="thickness" select="1.5"/>
        </xsl:call-template>

        <xsl:call-template name="button_element">
            <xsl:with-param name="border_brush" select="'White'"/>
            <xsl:with-param name="button_value" select="'Button'"/>
        </xsl:call-template>


    </xsl:template>


</xsl:stylesheet>
