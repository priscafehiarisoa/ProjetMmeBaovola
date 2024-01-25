<%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 16/01/2024
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp" />

<div class="col-md-12 grid-margin stretch-card">

    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Ajouter un type de maind oeuvre </h4>
            <%--alert --%>
            <%if(request.getAttribute("error")!=null){%>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("error")%>
            </div>
            <%}%>

            <%--  end alert --%>
            <form  class="forms-sample" action="${pageContext.request.contextPath}/newTypeMO" method="post" >
                <%--                nom du activite  --%>
                <div class="form-group ">

                    <%--                nomMainD_oeuvre --%>
                    <div class="form-group">
                        <label for="idEtudiant2">nomMainD_oeuvre </label>
                        <input type="text" id="idEtudiant2" class="form-control " name="nomMainD_oeuvre" required>
                        <br>
                    </div>
                        <%--                tauxHoraire --%>
                    <div class="form-group">
                        <label for="idEtudiant2">tauxHoraire </label>
                        <input type="number" id="tauxHoraire" class="form-control " name="tauxHoraire" required>
                        <br>
                    </div>
                    <%--                heurede travail--%>
                    <div class="form-group">
                        <label>heureDeTravail</label>
                        <input type="number" id="heuredetravail" class="form-control " name="heureDeTravail" required>
                    </div>


                    <button type="submit" class="btn btn-primary me-2">Valider</button>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../template/footer.jsp" />