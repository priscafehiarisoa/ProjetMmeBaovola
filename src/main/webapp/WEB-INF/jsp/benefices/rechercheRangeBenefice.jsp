<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %><%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 16/01/2024
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp" />
<%
    List<HashMap<String,Object>> hashMaps=new ArrayList<>();
    if(request.getAttribute("benefices")!=null){
        hashMaps= (List<HashMap<String,Object>>) request.getAttribute("benefices");
    }
%>

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">liste des voyages </h4>
            <div class="form-group">
                <form action="getListBenefices"  method="post">
                    <label >debut </label>
                    <input type="number"  class="form-control " name="prix1" required>
                    <br>
                    <label> fin</label>
                    <input type="number" class="form-control"  name="prix2" required>
                    <button type="submit" class="btn btn-primary me-2">Valider</button>

                </form>
            </div>
            <div>
                <% if (request.getAttribute("erreur")!=null){%>
                <h5 style="color: #f54141"><%=request.getAttribute("erreur")%></h5>
                <%}%>
            </div>


            <div class="table-responsive">
                <% if (request.getAttribute("range_text")!=null){%>
                <h3><%=request.getAttribute("range_text")%></h3>
                <%}%>
                <table border="1" class="table">
                    <tr>
                        <th>_</th>
                        <th>dates</th>
                        <th>bouquet</th>
                        <th>type de voyage</th>
                        <th>activités</th>
                        <th> benefices</th>
                        <th> taux Journalier ouvriers</th>
                        <th> prix Activite</th>
                        <th> prix unitaire Voyage</th>
                    </tr>

                    <%
                        if(request.getAttribute("benefices")!=null){
                            for (HashMap<String,Object> voyage:hashMaps) { %>
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
                            <%=voyage.get("benefices")%>
                        </td>
                        <td>
                            <%=voyage.get("tauxJournalierOuvriers")%>
                        </td>
                        <td>
                            <%=voyage.get("prixActivite")%>
                        </td>
                        <td>
                            <%=voyage.get("prixUnitaireVoyage")%>
                        </td>
                    </tr>
                    <% }
                    } %>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
