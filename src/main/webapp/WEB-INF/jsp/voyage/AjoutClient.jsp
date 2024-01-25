<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.client.Client" %><%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 25/01/2024
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Client> Client=new ArrayList<>();
    if(request.getAttribute("Client")!=null){
        Client=(List<Client>) request.getAttribute("client");
    }
%>
<jsp:include page="../template/header.jsp" />
<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Reservation </h4>
            <div class="form-group">
                <form >
                    <label>Nom</label>
                    <input type="text" class="form-control " name="nomClient" required>
                    <label>date de Naissance</label>
                    <input type="date" class="form-control " name="dateDeNaissance" required>
                    <br>
                    <label>Sexe</label>
                    <select>
                        <option>homme</option>
                        <option>femme</option>
                    </select>
                </form>
                <input type="submit" name="valider">

            </div>
        </div>
    </div>

    <jsp:include page="../template/footer.jsp" />
