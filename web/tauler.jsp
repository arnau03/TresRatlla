<%@page import="javax.swing.text.Document"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : tauler
    Created on : 14-feb-2013, 15:48:25
    Author     : trivium
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body align='center'>
        <%
            String txt = "";
            int n =Integer.parseInt(request.getSession().getAttribute("jugador").toString());
            int numTauler =0;
            int nJug = 0;
            txt = request.getSession().getAttribute("nick")+" VS ";
            String txt2 = "";
            
            switch(n){
                case 1: txt2 += getServletContext().getAttribute("jugador2");
                    numTauler =1;
                    nJug=1;
                break;   
                case 2: txt2 += getServletContext().getAttribute("jugador1");
                    numTauler =1;
                    nJug=2;
                break;     
                case 3: txt2 += getServletContext().getAttribute("jugador4");
                    numTauler =2;
                    nJug=1;
                break;   
                case 4: txt2 += getServletContext().getAttribute("jugador3");
                    numTauler =2;
                    nJug=2;
                break;  
                case 5: txt2 += getServletContext().getAttribute("jugador6");
                    numTauler =3;
                    nJug=1;
                break;   
                case 6: txt2 += getServletContext().getAttribute("jugador5");
                    numTauler =3;
                    nJug=2;
                break; 
                case 7: txt2 += getServletContext().getAttribute("jugador8");
                    numTauler =4;
                    nJug=1;
                break;   
                case 8: txt2 += getServletContext().getAttribute("jugador7");
                    numTauler =4;
                    nJug=2;
                break;
                case 9: txt2 += getServletContext().getAttribute("jugador10");
                    numTauler =5;
                    nJug=1;
                break;   
                case 10: txt2 += getServletContext().getAttribute("jugador9");
                    numTauler =5;
                    nJug=2;
                break;                                                                                                                                                                                                        
            }
            request.setAttribute("jug2", txt2);
            out.print("<h2>Tauler "+numTauler+"</h2>");
            if("null".equals(txt2)){
                txt2 = "esperant...";
                
            }
            out.print("</br>"+txt+""+txt2+"</br>");
            out.print("<table   align='center' >");
            for(int i = 0; i<=3;i++){
                out.print("<tr >");
                for(int j=0;j<=3;j++){
                    if(i == 0){
                        if(j==1)out.print("<td width='100' height='50' background='img\\x1.png' style='background-repeat: no-repeat;'></td>");
                        else if(j==2)out.print("<td width='100' height='50' background='img\\x2.png' style='  background-repeat: no-repeat;'></td>");
                        else if(j==3)out.print("<td width='100' height='50' background='img\\x3.png' style='  background-repeat: no-repeat;'></td>");
                        else out.print("<td width='100' height='50' background='img\\xy.png' style='  background-repeat: no-repeat;'></td>");
                    }
                    else if(j==0){
                        if(i==1)out.print("<td width='100' height='100' background='img\\y1.png' style='background-repeat: no-repeat;'></td>");
                        else if(i==2)out.print("<td width='100' height='100' background='img\\y2.png' style='background-repeat: no-repeat;'></td>");
                        else if(i==3) out.print("<td width='100' height='100' background='img\\y3.png' style='background-repeat: no-repeat;'></td>");
                    }
                    else{
                        int casella = Integer.parseInt(getServletContext().getAttribute("pos"+numTauler+""+i+""+j).toString());
                        if(casella==0)out.print("<td width='100' height='100' background='img\\img0.png' style='background-repeat: no-repeat;'></td>");
                        else if(casella==1)out.print("<td width='100' height='100' background='img\\img1.png' style='background-repeat: no-repeat;'></td>");
                        else out.print("<td width='100' height='100' background='img\\img2.png' style='background-repeat: no-repeat;'></td>");
                    }
                    
                }
                out.print("<td width='100' height='50'></td>");
                out.print("</tr>");
            }
           
            out.print("</table>");
            %>
            <form action='tirada' method='POST'>
                X=<input type='text' id='txtx' onChange='comprovar("x")'  maxlength="1" style='width: 20px;height: 20px;'name='x'>
                Y=<input type='text' id='txty' onChange='comprovar("y")' maxlength="1" style='width: 20px;height: 20px;'name='y'></br>
                <input name='jugl' style="visibility: hidden;" value='<%out.print(request.getSession().getAttribute("nick").toString());%>'>
                <input name='jug2' style="visibility: hidden;" hide='true' value='<%out.print(request.getAttribute("jug2").toString());%>'>
                <input name='numTauler' style="visibility: hidden;" value='<% out.print(numTauler); %>'>
                <input name='nJug' style="visibility: hidden;" value='<% out.print(nJug); %>'>
                </br><input type='submit' onClick="" value='enviar'>
            </form>
            </br><input type='button' value='recargar' onClick="window.location='tauler.jsp';"></br>
            <%
                if(getServletContext().getAttribute("guanyador"+numTauler) != null){
                    if(Integer.parseInt(getServletContext().getAttribute("guanyador"+numTauler).toString())==1){
                        out.print("Ha guanyat el jugador 1");
                    }
                    else if(Integer.parseInt(getServletContext().getAttribute("guanyador"+numTauler).toString())==2){
                        out.print("Ha guanyat el jugador 2");
                    }
                }   
            %>
            ${miss1}
    </body>
    <script type='text/javascript'>
        function comprovar(casella){
            var txt;
            if(casella =="x"){
                txt = document.getElementById("txtx");
            }
            else{
                txt = document.getElementById("txty");
            }
            var num = txt.value;
            if(num != 1 && num != 3 && num != 2){
                txt.value = "";
            }
        }
    </script>
</html>