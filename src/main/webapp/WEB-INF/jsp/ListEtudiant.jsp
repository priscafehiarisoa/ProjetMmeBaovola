<%@ page import="project.projetmmebaovola.Model.Etudiant" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 08/12/2023
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Etudiant> liste= new ArrayList<>();
          liste=  (List<Etudiant>) request.getAttribute("etudiant");

//    Etudiant etudiant= (Etudiant) request.getAttribute("singleEtudiant");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
      <tr>
        <th>nom</th>
        <th>prenom</th>
      </tr>
      <% for (int i = 0; i < liste.size(); i++) {
      %>
      <tr>
        <td><%=liste.get(i).getNom()%></td>
        <td><%=liste.get(i).getPrenom()%></td>
      </tr>
        <%}%>
    </table>

<%--<p><%= etudiant.getNom()%></p>--%>
<%--<p><%= etudiant.getPrenom()%></p>--%>

</body>
</html>
