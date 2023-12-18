

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%--
  Created by IntelliJ IDEA.
  User: falyarivelo
  Date: 10/12/2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Bouquets> bouquets= (List<Bouquets>) request.getAttribute("bouquet");

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
                    <th>Nom Bouquet</th>
                    <th>description des bouquets </th>
                    <th>liste des activités</th>

                </tr>
                <tbody>

                <% for (Bouquets bouquets1: bouquets) { %>
                <tr>
                    <td><%=bouquets1.getId()%></td>
                    <td><%=bouquets1.getNomBouquet()%></td>
                    <td><%=bouquets1.getDescriptionBouquet()%></td>
                    <td>
                        <ul>
                            <%
                                for (int i = 0; i < bouquets1.getListBouquetActivite().size(); i++) {%>
                            <li><%=bouquets1.getListBouquetActivite().get(i).getActivite().getNomActivite()%></li>
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
<jsp:include page="../template/footer.jsp" />

