<?xml version="1.0" encoding="UTF-8"?>
<!--
 * Copyright (C) 2000 Sebastian Schaffert
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
-->

<!-- This template is part of the German translation -->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="html" encoding="UTF-8"/>
  
    <xsl:variable name="imgbase" select="/USERMODEL/STATEDATA/VAR[@name='img base uri']/@value"/>
    <xsl:variable name="base" select="/USERMODEL/STATEDATA/VAR[@name='base uri']/@value"/>
    <xsl:variable name="session-id" select="/USERMODEL/STATEDATA/VAR[@name='session id']/@value"/>

    <xsl:template match="/">
    
    <HTML>
      <HEAD>
        <TITLE>WebMail Mailbox für <xsl:value-of select="/USERMODEL/USERDATA/FULL_NAME"/>: Ordnereinstellungen</TITLE>
	<META CONTENT="AUTHOR" VALUE="Sebastian Schaffert"/>
	<META CONTENT="GENERATOR" VALUE="JWebMail 0.7 XSL"/>
      </HEAD>
      
      <BODY bgcolor="#ffffff">		  
	<TABLE BGCOLOR="#dddddd" CELLSPACING="0" BORDER="0" WIDTH="100%">
	  <TR>
	    <TD VALIGN="CENTER">
	      <IMG SRC="{$imgbase}/images/btn-folders.png"/>
	    </TD>
	    <TD VALIGN="CENTER" COLSPAN="2">
	      <FONT SIZE="+2"><STRONG>JWebMail Ordnereinstellungen für <xsl:value-of select="/USERMODEL/USERDATA/FULL_NAME"/></STRONG></FONT> (<A HREF="{$base}/help?session-id={$session-id}&amp;helptopic=folder-setup-folders">Hilfe</A>)<BR/>
	      <EM>Benutzer <xsl:value-of select="normalize-space(/USERMODEL/USERDATA/LOGIN)"/></EM><BR/>
	      <EM>Kennung existiert seit <xsl:apply-templates select="/USERMODEL/STATEDATA/VAR[@name='first login']"/></EM>
	    </TD>
	  </TR>
	</TABLE>
	 
	<TABLE WIDTH="100%">
	  <xsl:for-each select="/USERMODEL/MAILHOST_MODEL">
	    <xsl:apply-templates select="."/>
	  </xsl:for-each>
	</TABLE>
     
	<P>
	 <STRONG>Fettgedruckte</STRONG> Ordner können Unterordner enthalten, Ordner, die normal angezeigt werden können keine Unterordner enthalten. <EM>Schräggedruckte</EM> Ordner sind versteckt (in der Briefkastenübersicht nicht angezeigt), nicht schräggedruckte nicht.
	</P>
	<P>
	  <FONT color="red"><STRONG>Achtung!</STRONG></FONT> Wenn Du einen Ordner löschst, werden alle darin enthaltenen Nachrichten und Ordner <FONT color="red">gelöscht</FONT>, und zwar nicht nur aus WebMail, sondern <FONT color="red">physisch auf dem Mailserver</FONT>! Das ist gefährlich und kann nicht rückgängig gemacht werden!
	</P>
	
      </BODY>


    </HTML>
  </xsl:template>
  
  <xsl:template match="/USERMODEL/USERDATA/INTVAR">
    <xsl:value-of select="@value"/>
  </xsl:template>		    
  
  <xsl:template match="/USERMODEL/STATEDATA/VAR">
    <xsl:value-of select="@value"/>
  </xsl:template>		    

  <xsl:template match="/USERMODEL/MAILHOST_MODEL">
    <TR BGCOLOR="#dddddd">
      <TD COLSPAN="{/USERMODEL/STATEDATA/VAR[@name='max folder depth']/@value}" WIDTH="50%">
	<STRONG><FONT COLOR="green"><xsl:value-of select="@name"/></FONT></STRONG>
      </TD>
      <TD WIDTH="50%">
	<STRONG>Host</STRONG>: <xsl:value-of select="@url"/>
      </TD>
    </TR>
    <xsl:for-each select="FOLDER">
      <xsl:apply-templates select="."/>
    </xsl:for-each>
  </xsl:template>

  <xsl:template match="FOLDER">
    <xsl:variable name="level" select="count(ancestor::FOLDER)"/>
    <TR>
      <xsl:call-template name="recurse-folder">
         <xsl:with-param name="level" select="$level"/>
      </xsl:call-template>
      <TD><IMG SRC="{$imgbase}/images/icon-folder.png"/></TD>
      <xsl:choose>
	<xsl:when test="@holds_folders = 'true'">
	  <TD COLSPAN="{/USERMODEL/STATEDATA/VAR[@name='max folder depth']/@value - $level - 1}">
	    <xsl:choose>
	      <xsl:when test="@subscribed = 'true'">
		<STRONG><xsl:value-of select="@name"/></STRONG>
	      </xsl:when>
	      <xsl:otherwise>
		<EM><STRONG><xsl:value-of select="@name"/></STRONG></EM>
	      </xsl:otherwise>
	    </xsl:choose>
	  </TD>
	  <TD>
	    <A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folderadd&amp;addto={@id}">Unterordner hinzufügen</A> - <A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;remove={@id}&amp;recurse=1">Ordner (und Unterordner) löschen</A> - 
	    <xsl:choose>
	      <xsl:when test="@subscribed = 'true'">
		<A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;hide={@id}&amp;">Verstecken</A>
	      </xsl:when>
	      <xsl:otherwise>
		<A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;unhide={@id}&amp;">Anzeigen</A>
	      </xsl:otherwise>
	    </xsl:choose>
	  </TD>
	</xsl:when>
	<xsl:otherwise>
	  <TD COLSPAN="{/USERMODEL/STATEDATA/VAR[@name='max folder depth']/@value - $level - 1}">
	    <xsl:choose>
	      <xsl:when test="@subscribed = 'true'">
		<xsl:value-of select="@name"/>
	      </xsl:when>
	      <xsl:otherwise>
		<EM><xsl:value-of select="@name"/></EM>
	      </xsl:otherwise>
	    </xsl:choose>
	  </TD>
	  <TD>
	    <A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;remove={@id}">Ordner löschen</A>> - 
	    <xsl:choose>
	      <xsl:when test="@subscribed = 'true'">
		<A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;hide={@id}&amp;">Anzeigen</A>
	      </xsl:when>
	      <xsl:otherwise>
		<A HREF="{$base}/folder/setup?session-id={$session-id}&amp;method=folder&amp;unhide={@id}&amp;">Sichtbar machen</A>
	      </xsl:otherwise>
	    </xsl:choose>
	  </TD>
	</xsl:otherwise>
      </xsl:choose>
    </TR>
    

    <xsl:for-each select="FOLDER">
      <xsl:apply-templates select="."/>
    </xsl:for-each>    
  </xsl:template>


  <!-- Create an appropriate number of <TD></TD> before a folder, depending on the level -->
  <xsl:template name="recurse-folder">
    <xsl:param name="level"/>
    <xsl:if test="$level>0">
      <TD></TD>
      <xsl:variable name="levelneu" select="$level - 1"/>
      <xsl:call-template name="recurse-folder">
	<xsl:with-param name="level" select="$levelneu"/>
      </xsl:call-template>
    </xsl:if>
  </xsl:template>

</xsl:stylesheet>
