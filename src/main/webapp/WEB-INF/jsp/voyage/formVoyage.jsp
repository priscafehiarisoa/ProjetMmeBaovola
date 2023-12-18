<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.TypeLieu" %>
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

 <%--    nom lieu --%>
    <div class="form-group">
        <label for="idEtudiant">Lieu </label>
        <input type="text" id="wq2" class="form-control" name="lieu" required><br>
    </div>


    <%--    bouquets liste --%>
    <div class="form-group ">
        <label >Bouquets </label>
        <div class="m-5 row d-inline-flex mx-5">
            <% for(int i = 0; i < listBouquet.size(); i++) { %>
            <div class="form-check col-5">
                <input type="checkbox" class="form-check-input d-inline-flex " id="bouquet<%= i %>" name="bouquets" value="<%= listBouquet.get(i).getId() %>">
                <label class="form-check-label" for="bouquet<%= i %>"><%= listBouquet.get(i).getNomBouquet() %></label>
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

