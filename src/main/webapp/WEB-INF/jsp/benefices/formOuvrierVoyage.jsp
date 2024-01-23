<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.*" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.TypeMainOeuvre" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  List<Voyage> voyageList=new ArrayList<>();
  if(request.getAttribute("voyage")!=null){
    voyageList= (List<Voyage>) request.getAttribute("voyage");
  }
  List<TypeMainOeuvre> typeMainOeuvres=new ArrayList<>();
  if(request.getAttribute("typeMO")!=null){
    typeMainOeuvres= (List<TypeMainOeuvre>) request.getAttribute("typeMO");
  }

%>


<div class="col-md-12 grid-margin stretch-card">

  <div class="card">
    <div class="card-body">
      <h4 class="card-title"><%if (request.getAttribute("modifActivite")!=null){ %>Ajouter un stock d'activité<%} else {%>Modifier une activite<%}%> </h4>
      <%--alert --%>
      <% if(request.getAttribute("error")!=null){%>
      <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("error")%>
      </div>
      <%}%>

      <%--  end alert --%>
      <form  class="forms-sample" action="${pageContext.request.contextPath}/newOuvrierVoyage" method="post" >

        <%--                nom du activite  --%>
        <div class="form-group ">
          <label >choisir un voyage </label>
          <div class="form-check">
            <label class="form-check-label" ></label>
            <select name="idVoyage" id="" class="form-control"  >
              <%for (int i = 0; i < voyageList.size(); i++) {%>
              <option value=<%=voyageList.get(i).getId()%>><%=voyageList.get(i).getId()%>|debut: <%=voyageList.get(i).getDateDebutvoyage()%> fin: <%=voyageList.get(i).getDateFinVoyage()%> | <%=voyageList.get(i).getBouquets().getNomBouquet()%></option>
              <%}%>
            </select>
          </div>

          <%--                nom du activite  --%>
        <div class="form-group ">
          <label >choisir un type d'ouvrier </label>
          <div class="form-check">
            <label class="form-check-label" ></label>
            <select name="idTypeMO" id="" class="form-control" >
              <%for (int i = 0; i < typeMainOeuvres.size(); i++) {%>
              <option value=<%=typeMainOeuvres.get(i).getId()%>><%=typeMainOeuvres.get(i).getNomMainD_oeuvre()%></option>
              <%}%>
            </select>
          </div>

          <%--                nombreMainOeuvre --%>
          <div class="form-group">
            <label for="idEtudiant2">nombre de main d'oeuvre  </label>
            <input type="number" id="idEtudiant2" class="form-control " name="nombreMainOeuvre" required>
            <br>
          </div>



          <button type="submit" class="btn btn-primary me-2">Valider</button>
      </form>
    </div>
  </div>
</div>

<jsp:include page="../template/footer.jsp" />

