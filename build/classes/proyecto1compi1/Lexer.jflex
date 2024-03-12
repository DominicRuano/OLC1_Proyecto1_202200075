package proyecto1compi1;

import java.io.*;
import java.util.ArrayList;

%%
%public
%class lexEx1
%function next_token
%unicode
%ignorecase


WHITESPACE = [ \t\r\f]*

digito = [0-9]+
letra = [a-zA-Z]
punto = "."


inicio = "PROGRAM"
fin = "END PROGRAM"
comentario = "!"[^\r\n]*
comentarios = [<][!][^!]*[!]+([^/*][^*]*[*]+)*[>]
string = \"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)\"

%type token
%eofval{
	return new token(constantes.EOF,null, -1,-1, null);
%eofval}
%%



<YYINITIAL> {string} {yycolumn += yylength();   
    return new token(constantes.STR, yytext(), yyline + 1, yycolumn - yylength() + 1, "STR");
}
<YYINITIAL> {inicio} {yycolumn += yylength();   
    return new token (constantes.STAPR, yytext(), yyline + 1, yycolumn - yylength() + 1, "START PROGRAM");
}
<YYINITIAL> {fin} {yycolumn += yylength();  
    return new token (constantes.ENDPR, yytext(), yyline + 1, yycolumn - yylength() + 1, "END PROGRAM");
}
<YYINITIAL> {digito}{punto}{digito} {yycolumn += yylength();    
    return new token (constantes.DOUBLE, yytext(), yyline + 1, yycolumn - yylength() + 1, "dd*");
}
<YYINITIAL> "<-" {yycolumn += yylength();   
    return new token (constantes.ASIG, yytext(), yyline + 1, yycolumn - yylength() + 1, "<-");
}
<YYINITIAL> "->" {yycolumn += yylength();   
    return new token (constantes.POINTER, yytext(), yyline + 1, yycolumn - yylength() + 1, "->");
}
<YYINITIAL> "=" {yycolumn += yylength();    
    return new token (constantes.IG, yytext(), yyline + 1, yycolumn - yylength() + 1, "=");
}
<YYINITIAL> ":" {yycolumn += yylength();    
    return new token (constantes.DP, yytext(), yyline + 1, yycolumn - yylength() + 1, ":");
}
<YYINITIAL> ";" {yycolumn += yylength();    
    return new token (constantes.PYC, yytext(), yyline + 1, yycolumn - yylength() + 1, ";");
}
<YYINITIAL> "(" {yycolumn += yylength();    
    return new token (constantes.PA, yytext(), yyline + 1, yycolumn - yylength() + 1, "(");
}
<YYINITIAL> ")" {yycolumn += yylength();    
    return new token (constantes.PC, yytext(), yyline + 1, yycolumn - yylength() + 1, ")");
}
<YYINITIAL> "," {yycolumn += yylength();    
    return new token (constantes.COMA, yytext(), yyline + 1, yycolumn - yylength() + 1, ",");
}
<YYINITIAL> "@" {yycolumn += yylength();    
    return new token (constantes.ARROBA, yytext(), yyline + 1, yycolumn - yylength() + 1, "@");
}
<YYINITIAL> "[" {yycolumn += yylength();    
    return new token (constantes.CA, yytext(), yyline + 1, yycolumn - yylength() + 1, "[");
}
<YYINITIAL> "]" {yycolumn += yylength();    
    return new token (constantes.CC, yytext(), yyline + 1, yycolumn - yylength() + 1, "]");
}
<YYINITIAL> "char[]" {yycolumn += yylength();    
    return new token (constantes.CHAR, yytext(), yyline + 1, yycolumn - yylength() + 1, "char");
}
<YYINITIAL> "var" {yycolumn += yylength();    
    return new token (constantes.VAR, yytext(), yyline + 1, yycolumn - yylength() + 1, "var");
}
<YYINITIAL> "double" {yycolumn += yylength();    
    return new token (constantes.DOUBLE, yytext(), yyline + 1, yycolumn - yylength() + 1, "double");
}
<YYINITIAL> "arr" {yycolumn += yylength();    
    return new token (constantes.ARR, yytext(), yyline + 1, yycolumn - yylength() + 1, "arr");
}
<YYINITIAL> "end" {yycolumn += yylength();    
    return new token (constantes.END, yytext(), yyline + 1, yycolumn - yylength() + 1, "end");
}
<YYINITIAL> "sum" {yycolumn += yylength();    
    return new token (constantes.SUM, yytext(), yyline + 1, yycolumn - yylength() + 1, "suma");
}
<YYINITIAL> "res" {yycolumn += yylength();    
    return new token (constantes.RES, yytext(), yyline + 1, yycolumn - yylength() + 1, "resta");
}
<YYINITIAL> "mul" {yycolumn += yylength();    
    return new token (constantes.MULTI, yytext(), yyline + 1, yycolumn - yylength() + 1, "multiplicacion");
}
<YYINITIAL> "div" {yycolumn += yylength();    
    return new token (constantes.DIV, yytext(), yyline + 1, yycolumn - yylength() + 1, "divicion");
}
<YYINITIAL> "mod" {yycolumn += yylength();    
    return new token (constantes.MOD, yytext(), yyline + 1, yycolumn - yylength() + 1, "modulo");
}
<YYINITIAL> "media" {yycolumn += yylength();    
    return new token (constantes.MEDIA, yytext(), yyline + 1, yycolumn - yylength() + 1, "media");
}
<YYINITIAL> "mediana" {yycolumn += yylength();    
    return new token (constantes.MEDIANA, yytext(), yyline + 1, yycolumn - yylength() + 1, "mediana");
}
<YYINITIAL> "moda" {yycolumn += yylength();    
    return new token (constantes.MODA, yytext(), yyline + 1, yycolumn - yylength() + 1, "moda");
}
<YYINITIAL> "varianza" {yycolumn += yylength();    
    return new token (constantes.VARIANZA, yytext(), yyline + 1, yycolumn - yylength() + 1, "varianza");
}
<YYINITIAL> "max" {yycolumn += yylength();    
    return new token (constantes.MAX, yytext(), yyline + 1, yycolumn - yylength() + 1, "maximo");
}
<YYINITIAL> "min" {yycolumn += yylength();    
    return new token (constantes.MIN, yytext(), yyline + 1, yycolumn - yylength() + 1, "minimi");
}
<YYINITIAL> "console" {yycolumn += yylength();    
    return new token (constantes.CONSOLE, yytext(), yyline + 1, yycolumn - yylength() + 1, "console");
}
<YYINITIAL> "print" {yycolumn += yylength();    
    return new token (constantes.PRINT, yytext(), yyline + 1, yycolumn - yylength() + 1, "print");
}
<YYINITIAL> "column" {yycolumn += yylength();    
    return new token (constantes.COLUMN, yytext(), yyline + 1, yycolumn - yylength() + 1, "column");
}
<YYINITIAL> "exec" {yycolumn += yylength();    
    return new token (constantes.EXEC, yytext(), yyline + 1, yycolumn - yylength() + 1, "exec");
}
<YYINITIAL> "graphBar" {yycolumn += yylength();    
    return new token (constantes.GRAPHBAR, yytext(), yyline + 1, yycolumn - yylength() + 1, "graphBar");
}
<YYINITIAL> "titulo" {yycolumn += yylength();    
    return new token (constantes.TITULO, yytext(), yyline + 1, yycolumn - yylength() + 1, "titulo");
}
<YYINITIAL> "ejeX" {yycolumn += yylength();    
    return new token (constantes.EJEX, yytext(), yyline + 1, yycolumn - yylength() + 1, "ejeX");
}
<YYINITIAL> "ejeY" {yycolumn += yylength();    
    return new token (constantes.EJEY, yytext(), yyline + 1, yycolumn - yylength() + 1, "ejeY");
}
<YYINITIAL> "tituloX" {yycolumn += yylength();    
    return new token (constantes.TITULOX, yytext(), yyline + 1, yycolumn - yylength() + 1, "tituloX");
}
<YYINITIAL> "tituloY" {yycolumn += yylength();    
    return new token (constantes.TITULOY, yytext(), yyline + 1, yycolumn - yylength() + 1, "tituloY");
}
<YYINITIAL> "label" {yycolumn += yylength();    
    return new token (constantes.LABEL, yytext(), yyline + 1, yycolumn - yylength() + 1, "label");
}
<YYINITIAL> "values" {yycolumn += yylength();    
    return new token (constantes.VALUES, yytext(), yyline + 1, yycolumn - yylength() + 1, "values");
}
<YYINITIAL> "graphPie" {yycolumn += yylength();    
    return new token (constantes.GRAPHPIE, yytext(), yyline + 1, yycolumn - yylength() + 1, "graphPie");
}
<YYINITIAL> "graphLine" {yycolumn += yylength();    
    return new token (constantes.GRAPHLINE, yytext(), yyline + 1, yycolumn - yylength() + 1, "graphLine");
}
<YYINITIAL> "Histogram" {yycolumn += yylength();    
    return new token (constantes.HISTOGRAM, yytext(), yyline + 1, yycolumn - yylength() + 1, "Histogram");
}
<YYINITIAL> {letra}({letra}|{digito})* {yycolumn += yylength(); 
    return new token (constantes.ID, yytext(), yyline + 1, yycolumn - yylength() + 1, "l(l|d)*");
}

\n {
    yyline++;      // Incrementar la línea
    yycolumn = 1;  // Reiniciar la columna
    yychar = 1;    // Establecer yychar en 1
}

{WHITESPACE}  {yycolumn ++;}
{comentario}  {}
{comentarios} {
        for (int i = 0; i < yytext().length(); i++) {
            if (yytext().charAt(i) == '\n') {
                yyline++;
            }
        }
}

. {yycolumn += yylength();  
    return new token(constantes.UKN, yytext(), yyline, yycolumn, "ERROR LEXICO");
}
