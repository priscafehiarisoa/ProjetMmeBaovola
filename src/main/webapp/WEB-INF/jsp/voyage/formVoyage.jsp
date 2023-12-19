<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.Activite" %>
<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Bouquets> listBouquet= new ArrayList<>();
    List<TypeLieu> listTypeLieu= new ArrayList<>();

    if(request.getAttribute("bouquet")!=null){
        listBouquet= (List<Bouquets>) request.getAttribute("bouquet");
    }
    if(request.getAttribute("typeLieu")!=null){
        listTypeLieu= (List<TypeLieu>) request.getAttribute("typeLieu");
    }
    List<Activite> listActivite= new ArrayList<>();

    if(request.getAttribute("activite")!=null){
        listActivite= (List<Activite>) request.getAttribute("activite");
    }
%>

<div class="col-md-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajouter un voyage </h4>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/newVoyage" method="post" >
<%--                date debut --%>
                <div class="form-group">
                    <label for="idEtudiant">date debut du voyage </label>
                    <input type="date" id="idEtudiant" class="form-control" name="dateDebutvoyage" required><br>
                </div>
<%--    date fin --%>
    <div class="form-group">
        <label for="idEtudiant">date Fin du voyage </label>
        <input type="date" id="q" class="form-control" name="dateFinVoyage" required><br>
    </div>

<%--    type lieu list --%>
    <div class="form-group">
        <label for="idEtudiant">types des lieux </label>
        <select name="type" class="form-control" id="">
            <%for(int i = 0; i < listTypeLieu.size(); i++) {%>
            <option value="<%=listTypeLieu.get(i).getId()%>"><%=listTypeLieu.get(i).getDescriptionLieu()%></option>
            <%}%>
        </select>    </div>

<%-- &lt;%&ndash;    nom lieu &ndash;%&gt;--%>
<%--    <div class="form-group">--%>
<%--        <label for="idEtudiant">Lieu </label>--%>
<%--        <input type="text" id="wq2" class="form-control" name="lieu" required><br>--%>
<%--    </div>--%>

    <%--    type de durrée d'activité --%>
    <div class="form-group ">
        <label >choisir le type de durée  </label>
        <div class="form-check">
            <label class="" ></label>
            <select name="typedure" id="" class="form-control" >
                <option value="court">court</option>
                <option value="long">long</option>
            </select>
        </div>
    </div>
    <%--    bouquets liste --%>
    <div class="form-group ">
        <label >Bouquets </label>
        <div class="m-5 row d-inline-flex mx-5">

            <select name="bouquets" id="">
                <% for(int i = 0; i < listBouquet.size(); i++) { %>
                <option value="<%= listBouquet.get(i).getId() %>"><%= listBouquet.get(i).getNomBouquet() %></option>
                <% } %>

            </select>
<%--            <div class="form-check col-5">--%>
<%--                <input type="checkbox" class="form-check-input d-inline-flex " id="bouquet<%= i %>" name="bouquets" value="<%= listBouquet.get(i).getId() %>">--%>
<%--                <label class="form-check-label" for="bouquet<%= i %>"></label>--%>
<%--            </div>--%>

        </div>
    </div>
    <%--    liste des activités  --%>
    <div class="form-group ">
        <label >choisir des activités  </label>
        <div class="m-5 row d-inline-flex mx-5">
            <% for(int i = 0; i < listActivite.size(); i++) { %>
            <div>
            </div>
            <div class="form-check col-3">
                <label class="" for="activite<%= i %>"><%= listActivite.get(i).getNomActivite() %></label>

                <input type="checkbox" class="form-check-input d-inline-flex " id="activite<%= i %>" name="activites" value="<%= listActivite.get(i).getId() %>">
            </div>
            <div class="form-check col-8">
                <input type="number" placeholder="quantite" class=" form-control d-inline-flex "  name="Quantite_activites" >
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

