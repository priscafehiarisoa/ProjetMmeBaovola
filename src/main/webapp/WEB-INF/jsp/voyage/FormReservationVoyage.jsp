<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.*" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Voyage> voyageList=new ArrayList<>();
    if(request.getAttribute("voyage")!=null){
        voyageList= (List<Voyage>) request.getAttribute("voyage");
    }

%>


<div class="col-md-12 grid-margin stretch-card">

    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajouter un stock d'activité </h4>
            <%--alert --%>
                  <div class="alert alert-danger" role="alert">
                      <%= request.getAttribute("error")%>
                  </div>

            <%--  end alert --%>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/submitFormReservationVoyage" method="post" >
                <%--                nom du activite  --%>
                <div class="form-group ">
                    <label >choisir voyage </label>
                    <div class="form-check">
                        <label class="form-check-label" ></label>
                        <select name="idReservation" id="" class="form-control" >
                            <%for (int i = 0; i < voyageList.size(); i++) {%>
                            <option value=<%=voyageList.get(i).getId()%>><%=voyageList.get(i).getId()%>|debut: <%=voyageList.get(i).getDateDebutvoyage()%> fin: <%=voyageList.get(i).getDateFinVoyage()%> | <%=voyageList.get(i).getBouquets().getNomBouquet()%></option>
                            <%}%>
                        </select>
                    </div>

                    <%--                description de l'activité --%>
                    <div class="form-group">
                        <label for="idEtudiant2">nombre de reservation  </label>
                        <input type="number" id="idEtudiant2" class="form-control " name="nombreReservation" required>
                        <br>
                    </div>
                    <%--                description de l'activité --%>
                    <div class="form-group">
                        <label for="idEtudiant3">nom du client</label>
                        <input type="text" id="idEtudiant3" class="form-control " name="nomClient" required>
                    </div>


                    <button type="submit" class="btn btn-primary me-2">Valider</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../template/footer.jsp" />

