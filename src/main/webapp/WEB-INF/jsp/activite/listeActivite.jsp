

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%@ page import="project.projetmmebaovola.Model.entity.Activite" %>
<%--
  Created by IntelliJ IDEA.
  User: falyarivelo
  Date: 10/12/2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Activite> activites= (List<Activite>) request.getAttribute("activite");

%>

<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title">liste des bouquets </h4>
      <div class="table-responsive">
        <table border="1" class="table">
          <tr>
            <th>_</th>
            <th>Nom de l'activité</th>
            <th>description </th>
            <th> tarif </th>
            <th>catégories d'activité</th>

          </tr>
          <tbody>

          <% for (Activite activite1: activites) { %>
          <tr>
            <td><%=activite1.getId()%></td>
            <td><%=activite1.getNomActivite()%></td>
            <td><%=activite1.getDescription()%></td>
            <td><%=activite1.getTarif()%></td>
            <td>
              <ul>
                <%
                  for (int i = 0; i < activite1.getListeCategorieActivite().size(); i++) {%>
                <li><%=activite1.getListeCategorieActivite().get(i).getNomCAtegorie()%></li>
                <%}%>
              </ul>
            </td>

          </tr>
          <% } %>
          </tbody>

        </table>

      </div>
    </div>
  </div>
</div>

<%--<div class="col-lg-12 grid-margin stretch-card">--%>
<%--  <div class="card">--%>
<%--    <div class="card-body">--%>
<%--      <h4 class="card-title">Liste des bouquets</h4>--%>
<%--      <div class="card-list">--%>
<%--        <% for (Activite activite1: activites) { %>--%>
<%--        <div class="card-item">--%>
<%--          <div class="card-header">--%>
<%--            <h5><%=activite1.getNomActivite()%></h5>--%>
<%--            <p><%=activite1.getDescription()%></p>--%>
<%--          </div>--%>
<%--          <div class="card-content">--%>
<%--            <p><strong>Nom de l'activité:</strong> <%=activite1.getNomActivite()%></p>--%>
<%--            <p><strong>Description:</strong> <%=activite1.getDescription()%></p>--%>
<%--            <p><strong>Catégories d'activité:</strong></p>--%>
<%--            <ul>--%>
<%--              <% for (int i = 0; i < activite1.getListeCategorieActivite().size(); i++) {%>--%>
<%--              <li><%=activite1.getListeCategorieActivite().get(i).getNomCAtegorie()%></li>--%>
<%--              <%}%>--%>
<%--            </ul>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--        <% } %>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--</div>--%>
<jsp:include page="../template/footer.jsp" />

