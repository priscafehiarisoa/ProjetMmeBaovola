<%@ page import="project.projetmmebaovola.Model.entity.bouquet.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.CateorieActivite" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Activite> activiteList=new ArrayList<>();
  if(request.getAttribute("activite")!=null){
    activiteList= (List<Activite>) request.getAttribute("activite");
  }

%>


<div class="col-md-12 grid-margin stretch-card">

  <div class="card">
    <div class="card-body">
      <h4 class="card-title">Ajouter un stock d'activité </h4>
      <%= request.getAttribute("error")%>
      <%--alert --%>
      <%--      <div class="alert alert-danger" role="alert">--%>
      <%--        <%=error%>--%>
      <%--      </div>--%>

      <%--  end alert --%>
      <form  class="forms-sample" action="${pageContext.request.contextPath}/submitStockActivite" method="post" >
        <%--                nom du activite  --%>
          <div class="form-group ">
            <label >choisir une activité </label>
            <div class="form-check">
              <label class="form-check-label" ></label>
              <select name="activite" id="" class="form-control" >
                <%for (int i = 0; i < activiteList.size(); i++) {%>
                    <option value=<%=activiteList.get(i).getId()%>><%=activiteList.get(i).getNomActivite()%></option>
                  <%}%>
              </select>
            </div>

          <%--                description de l'activité --%>
        <div class="form-group">
          <label for="idEtudiant2">description de l'activité  </label>
          <textarea id="idEtudiant2" class="form-control " name="nombreStock" required> </textarea>
          <br>
        </div>


        <button type="submit" class="btn btn-primary me-2">Valider</button>
      </form>
    </div>
  </div>
</div>

<jsp:include page="../template/footer.jsp" />

