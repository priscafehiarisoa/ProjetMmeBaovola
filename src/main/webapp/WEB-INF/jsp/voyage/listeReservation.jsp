<%--
  Created by IntelliJ IDEA.
  User: Valisoa
  Date: 11/01/2024
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.ReservationVoyage" %>
Created by IntelliJ IDEA.
  User: Valisoa
  Date: 11/01/2024
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ReservationVoyage> reservationVoyages= (List<ReservationVoyage>) request.getAttribute("reservation");

%>
<jsp:include page="../template/header.jsp" />

<div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Reservation </h4>
            <div class="form-group">
                <form action="${pageContext.request.contextPath}/rechercheReservation" method="post">
                    <label">rechercheReservation </label>
                    <input type="text" class="form-control " name="rechercheReservation" required>
                    <br>
                </form>
                <input type="submit" name="recherche">

                <div class="table-responsive">
                    <table border="1" class="table">
                        <tr>

                            <th>id</th>
                            <th>idVoyage</th>
                            <th>DateDebut</th>
                            <th>DateFin</th>
                            <th>Nombre Reservation</th>
                            <th>Date Reservation</th>
                            <th>client</th>
                        </tr>
                        <tbody>

                        <% for (ReservationVoyage reservationVoyage:reservationVoyages) { %>
                        <tr>
                            <td><%=reservationVoyage.getId()%></td>
                            <th><%=reservationVoyage.getVoyage().getId() %></th>
                            <th><%=reservationVoyage.getVoyage().getDateDebutvoyage() %></th>
                            <th><%=reservationVoyage.getVoyage().getDateFinVoyage() %></th>
                            <td><%=reservationVoyage.getNombreRervation()%></td>
                            <td><%=reservationVoyage.getDateReservation()%></td>
<%--                            <td><%=reservationVoyage.getClient()%></td>--%>
                            <td><a href="getPagePayerReservation/<%=reservationVoyage.getId()%>" >Payer</a></td>

                        </tr>
                        <% } %>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../template/footer.jsp" />
