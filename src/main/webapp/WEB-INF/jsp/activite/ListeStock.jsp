

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.bouquet.Bouquets" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>
<%@ page import="project.projetmmebaovola.Model.view.VRestestockactivite" %>
<%@ page import="project.projetmmebaovola.Model.util.ResteStock" %>
<%--
  Created by IntelliJ IDEA.
  User: falyarivelo
  Date: 10/12/2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<ResteStock> activites= (List<ResteStock>) request.getAttribute("reste");

%>

<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">stocks Activite</h4>
      <div class="table-responsive">
        <table border="1" class="table">
          <tr>
            <th>idActivite</th>
            <th>resteStock </th>


          </tr>
          <tbody>

          <% for (ResteStock activite1: activites) { %>
          <tr>
            <td><%=activite1.getActivite().getNomActivite()%></td>
            <td><%=activite1.getNbstock() %></td>

          </tr>
          <% } %>
          </tbody>

        </table>

      </div>
    </div>
  </div>
</div>

<jsp:include page="../template/footer.jsp" />

