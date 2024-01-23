<%@ page import="project.projetmmebaovola.Model.entity.bouquet.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.CateorieActivite" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Activite activite= new Activite();
    if (request.getAttribute("modifActivite")!=null){
        activite= (Activite) request.getAttribute("modifActivite");
    }
    List<CateorieActivite> listActivite= new ArrayList<>();

    if(request.getAttribute("activite")!=null){
        listActivite= (List<CateorieActivite>) request.getAttribute("activite");
    }
    String error="";
    if (request.getAttribute("error")!=null)
    {
        error = (String) request.getAttribute("error");
    }

%>


<div class="col-md-12 grid-margin stretch-card">

    <div class="card">
        <div class="card-body">
            <h4 class="card-title"><%if (request.getAttribute("modifActivite")!=null){ %>Modifier une activite<%} else {%> Ajouter une activité<%}%>  </h4>
            <%--alert --%>
            <% if(request.getAttribute("error")!=null){%>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("error")%>
            </div>
            <%}%>

            <%--  end alert --%>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/updateActivite" method="post" >
<%--               id hidden --%>
                    <%if (request.getAttribute("modifActivite")!=null){ %>
                    <input type="hidden" name="id" value=<%=activite.getId()%>>
                    <%}%>
                <%--                nom du activite  --%>
                <div class="form-group">
                    <label for="idEtudiant">Nom de l'activité </label>
                    <input type="text" id="idEtudiant" class="form-control" name="nomActivite" required
                        <% if((request.getAttribute("modifActivite")!=null)) {%>
                            value=<%=activite.getNomActivite()%>
                        <%}%>>
                </div>

                <%--                description de l'activité --%>
                <div class="form-group">
                    <label for="idEtudiant2">description de l'activité  </label>
                    <input id="idEtudiant2" class="form-control " name="description" required
                            <% if((request.getAttribute("modifActivite")!=null)) {%>
                                value=<%=activite.getDescription()%>
                            <%}%>>
                    <br>
                </div>

                <%--                description de l'activité --%>
                <div class="form-group">
                    <label for="idEtudiant3">durée de l'activité </label>
                    <input type="text" id="idEtudiant3" class="form-control " name="duree" required
                            <% if((request.getAttribute("modifActivite")!=null)) { %>
                                value=<%=activite.getDuree()%>
                            <%}%>> </input>
                    <br>
                </div>
                <%-- tarif --%>
                <div class="form-group">
                    <label>Tarif </label>
                    <input type="number"  class="form-control " name="tarif" required
                            <% if((request.getAttribute("modifActivite")!=null)) {%>
                            value=<%=activite.getTarif()%>
                            <%}%>>
                    <br>
                </div>

                <%--    type de durrée d'activité --%>
                <div class="form-group ">
                    <label >choisir le type de durée  </label>
                    <div class="form-check">
                        <label class="form-check-label" ></label>
                        <select name="typedure" id="" class="form-control"
                                <% if((request.getAttribute("modifActivite")!=null)) { %>
                                        value=<%=activite.getTypedure()%>
                                    <%}%> >
                            <option value="heures">heures</option>
                            <option value="jours">jours</option>
                        </select>
                    </div>

                </div>

                <%--    liste des activités  --%>
                <div class="form-group ">
                    <label >choisir une catégorie d'activité  </label>
                    <div class="m-5 row d-inline-flex mx-5">
                        <% for(int i = 0; i < listActivite.size(); i++) { %>
                        <div class="form-check col-5">
                            <input type="checkbox" class="form-check-input d-inline-flex " id="activite<%= i %>" name="categories" value="<%= listActivite.get(i).getId() %>"
                                <% if((request.getAttribute("modifActivite")!=null)) {
                                    for(int j = 0; j < activite.getListeCategorieActivite().size(); j++) {
                                      if(listActivite.get(i)==activite.getListeCategorieActivite().get(j)){
                                          out.print("checked");
                                          break;
                                      }
                                    }
                                }%>>
                            <label class="form-check-label" for="bouquet<%= i %>"><%= listActivite.get(i).getNomCAtegorie() %></label>
                        </div>
                        <% } %>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary me-2">Valider</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../template/footer.jsp" />

