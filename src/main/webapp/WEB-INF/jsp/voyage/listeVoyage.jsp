

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.Voyage" %>
<%--
  Created by IntelliJ IDEA.
  User: falyarivelo
  Date: 10/12/2023
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Voyage> voyages= (List<Voyage>) request.getAttribute("voyage");

%>

<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">liste des voyages </h4>
            <p class="card-description">
                Add class <code>.table</code>
            </p>
            <div class="table-responsive">
            <table border="1" class="table">
                <tr>
                    <th>_</th>
                    <th>date debut de voyage</th>
                    <th>date fin de voyage</th>
                    <th>lieu</th>
                    <th>bouquet</th>
                    <th>type de voyage</th>
                </tr>
                <tbody>

                <% for (Voyage voyage: voyages) { %>
                <tr>
                    <td><%=voyage.getId()%></td>
                    <td><%=voyage.getDateDebutvoyage()%></td>
                    <td><%=voyage.getDateFinVoyage()%></td>
                    <td><%=voyage.getLieu()%></td>
                    <td>
                        <ul>
                            <%
                                for (int i = 0; i < voyage.getBouquets().size(); i++) {%>
                            <li><%=voyage.getBouquets().get(i).getNomBouquet()%></li>
                            <%}%>
                        </ul>
                    </td>
                    <td><%=voyage.getTypeLieu().getDescriptionLieu()%></td>
                </tr>
                <% } %>
                </tbody>

            </table>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../template/footer.jsp" />

