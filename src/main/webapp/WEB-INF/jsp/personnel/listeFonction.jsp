<%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 23/01/2024
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Liste perso</title>


  <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
  <%@ page import="project.projetmmebaovola.Model.entity.personnel.Personnel" %>
  <%@ page import="project.projetmmebaovola.Model.entity.personnel.Fonctions" %>

  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
    List<Fonctions> personnelList= (List<Fonctions>) request.getAttribute("fonctions");

%>

  <jsp:include page="../template/header.jsp" />

  <div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">liste personnel </h4>
        <p class="card-description">
          Add class <code>.table</code>
        </p>
        <%--                description de l'activité --%>
        <div class="table-responsive">
          <table border="1" class="table">
            <tr>
              <th>_</th>
              <th>fonction</th>
              <th>debut</th>
              <th>multiplicateur salaire</th>
            </tr>
            <tbody>

            <% for (Fonctions personnel:personnelList) { %>
            <tr>
              <td><%=personnel.getId()%></td>
              <td><%=personnel.getNomFonction()%></td>
              <td><%=personnel.getDebutIntervalleAnnee()%></td>
              <td><a href="/updateFormFonction/<%=personnel.getId()%>">modifier</a></td>
            </tr>
            <% } %>
            </tbody>

          </table>

        </div>
      </div>
    </div>
  </div>
  <jsp:include page="../template/footer.jsp" />


