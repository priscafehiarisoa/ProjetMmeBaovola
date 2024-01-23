<%@ page import="project.projetmmebaovola.Model.entity.bouquet.Bouquets" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.TypeLieu" %>
<%@ page import="project.projetmmebaovola.Model.entity.activite.Activite" %>
<%@ page import="project.projetmmebaovola.Model.entity.voyage.Voyage" %>
<%@ page import="java.util.Objects" %>
<%@ page import="org.springframework.http.converter.json.GsonBuilderUtils" %>
<jsp:include page="../template/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  List<Bouquets> listBouquet= new ArrayList<>();
  List<TypeLieu> listTypeLieu= new ArrayList<>();
  Voyage modifVoyage=new Voyage();
  if(request.getAttribute("modifVoyage")!=null){
    modifVoyage= (Voyage) request.getAttribute("modifVoyage");
  }

  if(request.getAttribute("bouquet")!=null){
    listBouquet= (List<Bouquets>) request.getAttribute("bouquet");
  }
  if(request.getAttribute("typeLieu")!=null){
    listTypeLieu= (List<TypeLieu>) request.getAttribute("typeLieu");
  }
  List<Activite> listActivite= new ArrayList<>();

  if(request.getAttribute("activite")!=null){
    listActivite= (List<Activite>) request.getAttribute("activite");
  }
%>

<div class="col-md-12 grid-margin stretch-card">
  <div class="card">
    <div class="card-body">
      <h4 class="card-title"><%if(request.getAttribute("modifVoyage")!=null){%>Modifier un voyage <%} else {%> Ajouter un voyage <%}%></h4>
      <form  class="forms-sample" method="post"  action="${pageContext.request.contextPath}/updateVoyagePost" >
        <% if((request.getAttribute("modifVoyage")!=null)) {%>
        <input type="hidden" name="id" value=<%=modifVoyage.getId()%>>
        <%}%>
        <%--                date debut --%>
        <div class="form-group">
          <label for="idEtudiant">date debut du voyage </label>
          <input type="date" id="idEtudiant" class="form-control" name="dateDebutvoyage" required
            <% if((request.getAttribute("modifVoyage")!=null)) {%>
                 value=<%=modifVoyage.getDateDebutvoyage()%>
                   <%}%>
          ><br>
        </div>
        <%--    date fin --%>
        <div class="form-group">
          <label for="idEtudiant">date Fin du voyage </label>
          <input type="date" id="q" class="form-control" name="dateFinVoyage" required
            <% if((request.getAttribute("modifVoyage")!=null)) {%>
                 value=<%=modifVoyage.getDateFinVoyage()%>
                   <%}%>
          ><br>
        </div>

        <%--    prix Unitaire --%>
        <div class="form-group">
          <label for="idEtudiant">prix unitaire voyage </label>
          <input type="number" id="3" class="form-control" name="prixUnitaireVoyage" required
            <% if((request.getAttribute("modifVoyage")!=null)) {%>
                 value=<%=modifVoyage.getPrixUnitaireVoyage()%>
                   <%}%>
          ><br>
        </div>

        <%--    type lieu list --%>
        <div class="form-group">
          <label for="idEtudiant">types des lieux </label>
          <select
                  name="type"
                  class="form-control"
                  id=""
                  <% if((request.getAttribute("modifVoyage")!=null)) {%>
                  value=<%=modifVoyage.getTypeLieu().getId()%>
                    <%}%>

          >
            <%for(int i = 0; i < listTypeLieu.size(); i++) {%>
            <option value="<%=listTypeLieu.get(i).getId()%>"><%=listTypeLieu.get(i).getDescriptionLieu()%></option>
            <%}%>
          </select>    </div>

        <%-- &lt;%&ndash;    nom lieu &ndash;%&gt;--%>
        <%--    <div class="form-group">--%>
        <%--        <label for="idEtudiant">Lieu </label>--%>
        <%--        <input type="text" id="wq2" class="form-control" name="lieu" required><br>--%>
        <%--    </div>--%>

        <%--    type de durrée d'activité --%>
        <div class="form-group ">
          <label >choisir le type de durée  </label>
          <div class="form-check">
            <label class="" ></label>
            <select name="typedure" id="" class="form-control"
                    <% if((request.getAttribute("modifVoyage")!=null)){%>
                    value=<%=modifVoyage.getTypedure()%>
                      <%}%>
            >
              <option value="court">court</option>
              <option value="long">long</option>
            </select>
          </div>
        </div>
        <%--    bouquets liste --%>
        <div class="form-group ">
          <label >Bouquets </label>
          <div class="m-5 row d-inline-flex mx-5">

            <select name="bouquets" id=""
                    <% if((request.getAttribute("modifVoyage")!=null)) {%>
                    value=<%=modifVoyage.getBouquets().getId()%>
                      <%}%>
            >
              <% for(int i = 0; i < listBouquet.size(); i++) { %>
              <option value="<%= listBouquet.get(i).getId() %>"><%= listBouquet.get(i).getNomBouquet() %></option>
              <% } %>

            </select>
            <%--            <div class="form-check col-5">--%>
            <%--                <input type="checkbox" class="form-check-input d-inline-flex " id="bouquet<%= i %>" name="bouquets" value="<%= listBouquet.get(i).getId() %>">--%>
            <%--                <label class="form-check-label" for="bouquet<%= i %>"></label>--%>
            <%--            </div>--%>

          </div>
        </div>
        <%--    liste des activités  --%>
        <div class="form-group ">
          <label >choisir des activités  </label>
          <div class="m-5 row d-inline-flex mx-5">
            <% for(int i = 0; i < listActivite.size(); i++) { %>
            <div>
            </div>
            <div class="form-check col-3">
              <label class="" for="activite<%= i %>"><%= listActivite.get(i).getNomActivite() %></label>
              <%--                <%modifVoyage.getListeActivite().forEach(System.out::println);%>--%>

              <input
                      type="checkbox"
                      class="form-check-input d-inline-flex "
                      id="activite<%= i %>"
                      name="activites"
                      value="<%= listActivite.get(i).getId()%>"
                <% if((request.getAttribute("modifVoyage")!=null)) {
                                    for(int j = 0; j < modifVoyage.getListeActivite().size(); j++) {
                                      if(listActivite.get(i).getId()==modifVoyage.getListeActivite().get(j).getActivite().getId()){
                                          out.print("checked");
                                          System.out.println("mety");
                                          break;
                                      }
                                    }
                                }%>
              >
            </div>
            <div class="form-check col-8">
              <input type="number" placeholder="quantite" class=" form-control d-inline-flex "  name="Quantite_activites"
                <% if((request.getAttribute("modifVoyage")!=null)) {
                                    for(int j = 0; j < modifVoyage.getListeActivite().size(); j++) {
                                      if(Objects.equals(listActivite.get(i).getId(), modifVoyage.getListeActivite().get(j).getActivite().getId())){%>
                     value=<%=(int)modifVoyage.getListeActivite().get(j).getQuantite()%>
                       <%  break;
                                      }
                                    }
                                }%>
              >
            </div>
            <% } %>
          </div>
        </div>


        <button type="submit" class="btn btn-primary me-2">Valider</button>
      </form>
    </div>
  </div>
</div>

<jsp:include page="../template/footer.jsp" />

