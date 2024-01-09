<%@ page import="project.projetmmebaovola.Model.entity.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.Activite" %>
<%@ page import="project.projetmmebaovola.Model.entity.CateorieActivite" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
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
      <h4 class="card-title">Ajouter une Activité </h4>
        <%= request.getAttribute("error")%>
      <%--alert --%>
<%--      <div class="alert alert-danger" role="alert">--%>
<%--        <%=error%>--%>
<%--      </div>--%>

      <%--  end alert --%>
      <form  class="forms-sample" action="${pageContext.request.contextPath}/addNewActivite" method="post" >
        <%--                nom du activite  --%>
        <div class="form-group">
          <label for="idEtudiant">Nom de l'activité </label>
          <input type="text" id="idEtudiant" class="form-control" name="nomActivite" required>
        </div>

        <%--                description de l'activité --%>
        <div class="form-group">
          <label for="idEtudiant2">description de l'activité  </label>
          <textarea id="idEtudiant2" class="form-control " name="description" required> </textarea>
          <br>
        </div>

          <%--                description de l'activité --%>
        <div class="form-group">
          <label for="idEtudiant3">durée de l'activité </label>
          <input type="text" id="idEtudiant3" class="form-control " name="duree" required> </input>
          <br>
        </div>

        <%--    type de durrée d'activité --%>
        <div class="form-group ">
          <label >choisir le type de durée  </label>
            <div class="form-check">
              <label class="form-check-label" ></label>
              <select name="typedure" id="" class="form-control" >
                <option value="heures">heures</option>
                <option value="jours">jours</option>
              </select>
            </div>
        </div>

          <%--    liste des activités  --%>
        <div class="form-group ">
          <label >choisir une catégorie d'activité  </label>
          <div class="m-5 row d-inline-flex mx-5">
<%--            <div class="form-check col-5">--%>
<%--              <input type="checkbox" class="form-check-input d-inline-flex " name="categories" value="1234">--%>
<%--              <label class="form-check-label" >test exeption</label>--%>
<%--            </div>--%>

            <% for(int i = 0; i < listActivite.size(); i++) { %>
            <div class="form-check col-5">
              <input type="checkbox" class="form-check-input d-inline-flex " id="activite<%= i %>" name="categories" value="<%= listActivite.get(i).getId() %>">
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

