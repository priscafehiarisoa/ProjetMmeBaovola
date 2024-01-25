<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.*" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
<%@ page import="project.projetmmebaovola.Model.entity.client.Client" %>

<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%  List<Client>clients=new ArrayList<>();
    if (request.getAttribute("client")!= null){
        clients=(List<Client>) request.getAttribute("client");
    }
    List<Voyage> voyageList=new ArrayList<>();
    if(request.getAttribute("voyage")!=null){
        voyageList= (List<Voyage>) request.getAttribute("voyage");
    }

%>


<div class="col-md-12 grid-margin stretch-card">

    <div class="card">
        <div class="card-body">
            <h4 class="card-title">réservation de voyage</h4>
            <%--alert --%>
            <% if (request.getAttribute("error")!=null){%>
                  <div class="alert alert-danger" role="alert">
                      <%= request.getAttribute("error")%>
                  </div>
            <%}%>
            <% if (request.getAttribute("errors")!=null){
            List<String> errors= (List<String>) request.getAttribute("errors");
                for (int i = 0; i < errors.size(); i++) {
            %>
                  <div class="alert alert-danger" role="alert">
                      <%=errors.get(i)%>
                  </div>
            <%
                }
            }%>

            <%--  end alert --%>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/submitReservationClient" method="post" >
                <%--                nom de l'activite  --%>
                <div class="form-group ">
                    <label >choisir un voyage </label>
                    <div class="form-check">
                        <label class="form-check-label" ></label>
                        <select name="idVoyage" id="" class="form-control" >
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
                        <label>client</label>
                         <select name="nomClient">
                             <%for (int i = 0; i <clients .size(); i++) {%>
                             <option value=<%=clients.get(i).getId() %>><%=clients.get(i).getNomClient()%></option>
                             <%}%>
                         </select>

                    </div>


                    <button type="submit" class="btn btn-primary me-2">Valider</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../template/footer.jsp" />

