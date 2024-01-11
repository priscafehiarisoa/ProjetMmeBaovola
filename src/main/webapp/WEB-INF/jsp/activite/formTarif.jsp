<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.Voyage" %><%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 09/01/2024
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<HashMap<String,Object>> listVoyage=new ArrayList<>();
if (request.getAttribute("tarifVoyage")!=null){
    listVoyage= (List<HashMap<String, Object>>) request.getAttribute("tarifVoyage");
}%>


<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">liste des voyages </h4>
            <div class="form-group">
                <form action="VoyageTarif"  method="post">
                 <label >debut </label>
                 <input type="numer"  class="form-control " name="debut" required>
                <br>
                 <label> fin</label>
                <input type="number" class="form-control"  name="fin" required>
                    <button type="submit" class="btn btn-primary me-2">Valider</button>

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
                        <th> Tarif</th>
                    </tr>

                    <%
                        if(request.getAttribute("tarifVoyage")!=null){
                        for (HashMap<String,Object> voyage:listVoyage) { %>
                    <tr>
                        <td><%=((Voyage)voyage.get("voyage")).getId()%></td>
                        <td><%=((Voyage)voyage.get("voyage")).getDateDebutvoyage()%></td>
                        <td><%=((Voyage)voyage.get("voyage")).getDateFinVoyage()%></td>
                        <td>
                            <ul>
                                <li><%=((Voyage)voyage.get("voyage")).getBouquets().getNomBouquet()%></li>
                            </ul>
                        </td>
                        <td><%=((Voyage)voyage.get("voyage")).getTypeLieu().getDescriptionLieu()%></td>
                        <td>
                            <ul>
                                <%
                                    for (int i = 0; i < ((Voyage)voyage.get("voyage")).getListeActivite().size(); i++) {%>
                                <li><%=((Voyage)voyage.get("voyage")).getListeActivite().get(i).getActivite().getNomActivite()%>(<%=(int)((Voyage)voyage.get("voyage")).getListeActivite().get(i).getQuantite()%>)(prix: <%=((Voyage)voyage.get("voyage")).getListeActivite().get(i).getActivite().getTarif()%> ar)</li>
                                <%}%>
                            </ul>
                        </td>
                        <td>
                            <%=voyage.get("tarif")%>
                        </td>
                    </tr>
                    <% }
                        } %>
                    </tbody>

                </table>
        </div>
    </div>
</div>


