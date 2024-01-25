<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.*" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>
<%@ page import="project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre" %>
<%@ page import="project.projetmmebaovola.Model.entity.personnel.Personnel" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  List<Voyage> voyageList=new ArrayList<>();
  if(request.getAttribute("voyage")!=null){
    voyageList= (List<Voyage>) request.getAttribute("voyage");
  }
  List<Personnel> typeMainOeuvres=new ArrayList<>();
  if(request.getAttribute("personnel")!=null){
    typeMainOeuvres= (List<Personnel>) request.getAttribute("personnel");
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

          <%--                choix du personnel  --%>
        <div class="form-group ">
          <label >choisir le personnel de votre choix </label>
          <div class="form-check">
            <label class="form-check-label" ></label>
            <select name="idPersonnel" id="" class="form-control" >
              <%for (int i = 0; i < typeMainOeuvres.size(); i++) {%>
              <option value=<%=typeMainOeuvres.get(i).getId()%>><%=typeMainOeuvres.get(i).getNomPersonnel()%></option>
              <%}%>
            </select>
          </div>

          <%--                nombre de jours de travail --%>
          <div class="form-group">
            <label for="idEtudiant2">nombre de jours de travail de la main d'oeuvre  </label>
            <input type="number" id="idEtudiant2" class="form-control " name="nombreJourTravail" required>
            <br>
          </div>



          <button type="submit" class="btn btn-primary me-2">Valider</button>
      </form>
    </div>
  </div>
</div>

<jsp:include page="../template/footer.jsp" />

