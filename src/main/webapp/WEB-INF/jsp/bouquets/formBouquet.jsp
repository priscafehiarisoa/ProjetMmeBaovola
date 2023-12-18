<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.Activite" %>
<jsp:include page="../template/header.jsp" />

<%
    List<Activite> listActivite= new ArrayList<>();

    if(request.getAttribute("activite")!=null){
        listActivite= (List<Activite>) request.getAttribute("activite");
    }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajouter un Bouquet </h4>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/newBouquet" method="post" >
<%--                nom du bouquet  --%>
                <div class="form-group">
                    <label for="idEtudiant">nom bouquet </label>
                    <input type="text" id="idEtudiant" class="form-control" name="nomBouquet" required>
                </div>

    <%--                description du bouquet --%>
                <div class="form-group">
                    <label for="idEtudiant2">description du bouquet  </label>
                    <textarea id="idEtudiant2" class="form-control h-50" name="descriptionBouquet" required> </textarea>
                    <br>
                </div>

    <%--    liste des activités  --%>
    <div class="form-group ">
        <label >choisir des activités  </label>
        <div class="m-5 row d-inline-flex mx-5">
            <% for(int i = 0; i < listActivite.size(); i++) { %>
            <div class="form-check col-5">
                <input type="checkbox" class="form-check-input d-inline-flex " id="activite<%= i %>" name="activites" value="<%= listActivite.get(i).getId() %>">
                <label class="form-check-label" for="bouquet<%= i %>"><%= listActivite.get(i).getNomActivite() %></label>
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

