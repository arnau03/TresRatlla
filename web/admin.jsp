<%-- 
    Document   : admin
    Created on : 19-feb-2013, 19:17:33
    Author     : trivium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <% 
        if(null==getServletContext().getAttribute("cont")){
            out.print("No hi ha cap jugador </br>");
            
            
        }
        else{
            out.print("Num de jugadors = "+getServletContext().getAttribute("cont")+"</br>");
            out.print(mostrarJugadors());
        }
    %>
    <form action='reset' method='POST'>
        <input type='submit' value='Reset' onClick='reset()'>
    </form>
    <%!
        public String mostrarJugadors(){
            int n = Integer.parseInt(getServletContext().getAttribute("cont").toString());
            String txt="";
            int j = 1;
            for (int i =1 ;i<=n;i++){
                if((i%2)==0){
                    txt += getServletContext().getAttribute("jugador"+i).toString();
                    txt +="</br>";
                    j++;
                }
                else    {
                    txt+="Tauler"+j+": "+getServletContext().getAttribute("jugador"+i).toString();
                    txt+=" VS ";
                }
            }
            return txt;
        }
    %>
    
    </body>
</html>
