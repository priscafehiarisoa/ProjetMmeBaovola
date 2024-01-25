<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.personnel.TypeMainOeuvre" %><%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 23/01/2024
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% List<TypeMainOeuvre> typeMainOeuvres=new ArrayList<>();
   if(request.getAttribute("TypeMainOeuvre")!=null){
       typeMainOeuvres=(List<TypeMainOeuvre>) request.getAttribute("TypeMainOeuvre");
   }
%>
<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajout personnel </h4>
            <form action="${pageContext.request.contextPath}/newPersonnel" method="post">
                <div class="form-group">
                    <label for="">nom personnel </label>
                <input type="text" name="Nom" class="form-control ">
                    <br>
                </div>

                <div class="form-group">
                    <label for="">date d'embauche </label>
                <input type="date" name="dateEmbauche" class="form-control ">
                </div>

                <div class="form-group">
                    <label for="">Type de poste </label>
                <select name="typeMainOeuvre" id="" class="form-control" >
                    <%for (int i = 0; i <typeMainOeuvres .size(); i++) {%>
                    <option value=<%=typeMainOeuvres.get(i).getId()%>><%= typeMainOeuvres.get(i).getHeureDeTravail() %> <%=typeMainOeuvres.get(i).getTauxHoraire()%> <%=typeMainOeuvres.get(i).getNomMainD_oeuvre()%>></option>
                    <%}%>
                </select>
                </div>
                <button type="submit" class="btn btn-primary me-2">Valider</button>

            </form>
        </div>
    </div>
</div>