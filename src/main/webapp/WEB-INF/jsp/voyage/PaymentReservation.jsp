<%@ page import="project.projetmmebaovola.Model.entity.voyage.ReservationVoyage" %><%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 25/01/2024
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp" />
<%
    ReservationVoyage reservationVoyage= (ReservationVoyage) request.getAttribute("reservation");
    double montantAPayer= (double) request.getAttribute("prixApayer");
%>

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Reservation n* <%=reservationVoyage.getId()%> </h4>
            <p>client : <%=reservationVoyage.getNomClient()%></p>
            <div class="form-group">
                <form >
                    <label>payement Reservation </label>
                    <input type="hidden" class="form-control " name="id" required value="<%=reservationVoyage.getId()%>">
                    <input type="text" class="form-control " name="payementReservation" required value="<%=montantAPayer%>">
                    <br>
                </form>
                <input type="submit" name="valider">
               
            </div>
        </div>
    </div>

<jsp:include page="../template/footer.jsp" />