<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.personnel.Fonctions" %><%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 23/01/2024
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Fonctions fonctions= (Fonctions) request.getAttribute("modifFonction");
%>
<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajout personnel </h4>
            <form action="${pageContext.request.contextPath}/updateFonction" method="post">
                <div class="form-group">
                    <label for="">nom Fonction </label>
                    <input type="text" name="Nom" class="form-control " value=<%=fonctions.getNomFonction()%>>
                    <input type="hidden" name="id" class="form-control " value=<%=fonctions.getId()%>>
                    <br>
                </div>

                <div class="form-group">
                    <label for="">DEBUT INTERVALLE</label>
                    <input type="number" name="debutIntervalle" placeholder="debutIntervalle" class="form-control " value=<%=fonctions.getDebutIntervalleAnnee()%>>
                    <input type="number" name="finIntervalle" placeholder="finIntervalle" class="form-control " value=<%=fonctions.getFinIntervalleAnnee()%>>
                </div>

                <div class="form-group">
                    <label for="">multiplicateur</label>
                    <input type="number" name="multiplicateur" placeholder="multiplicateur" class="form-control " value=<%=fonctions.getMultiplicateur()%>>
                </div>


                <button type="submit" class="btn btn-primary me-2">Valider</button>

            </form>
        </div>
    </div>
</div>