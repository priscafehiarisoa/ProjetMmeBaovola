

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
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
            <%--                description de l'activité --%>
            <div class="form-group">
                <form action="${pageContext.request.contextPath}/searchvoyage" method="post">
                    <label for="idEtudiant3">recherche </label>
                    <input type="text" id="idEtudiant3" class="form-control " name="recherche" required> </input>
                    <br>
                </form>

            </div>


            <div class="table-responsive">
            <table border="1" class="table">
                <tr>
                    <th>_</th>
                    <th>date debut de voyage</th>
                    <th>date fin de voyage</th>
                    <th>bouquet</th>
                    <th>type de voyage</th>
                    <th>activités</th>
                    <th>prix Voyage</th>
                    <th>-</th>
                    <th>-</th>
                </tr>
                <tbody>

                <% for (Voyage voyage: voyages) { %>
                <tr>
                    <td><%=voyage.getId()%></td>
                    <td><%=voyage.getDateDebutvoyage()%></td>
                    <td><%=voyage.getDateFinVoyage()%></td>
                    <td>
                        <ul>
                            <li><%=voyage.getBouquets().getNomBouquet()%></li>
                        </ul>
                    </td>
                    <td><%=voyage.getTypeLieu().getDescriptionLieu()%></td>
                    <td>
                        <ul>
                            <%
                                for (int i = 0; i < voyage.getListeActivite().size(); i++) {%>
                            <li><%=voyage.getListeActivite().get(i).getActivite().getNomActivite()%> (<%=(int)voyage.getListeActivite().get(i).getQuantite()%>)</li>
                            <%}%>
                        </ul>
                    </td>
                    <td><%=voyage.getPrixUnitaireVoyage()%></td>
                    <td><a href="/updateVoyage/<%=voyage.getId()%>">modifier</a></td>
                    <td><a href="/updateVoyage/<%=voyage.getId()%>">supprimer</a></td>
                </tr>
                <% } %>
                </tbody>

            </table>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../template/footer.jsp" />

