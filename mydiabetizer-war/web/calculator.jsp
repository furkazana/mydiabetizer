<%-- 
    Document   : calculator
    Created on : Feb 6, 2016, 1:37:31 PM
    Author     : Tsvetelin
--%>

<%@page import="java.util.List"%>
<%@page import="ent.Fruits"%>
<%@page import="beans.FoodHandlerBeanLocal"%>
<%@page import="javax.ejb.EJB"%>
<jsp:include page="header.jsp" />
<jsp:useBean id="foodHandlerBean" class="beans.FoodHandlerBean"/>

<% 
  List <Fruits> fruitsList; fruitsList= foodHandlerBean.getAllFruits();
   
%>
<div class="list-group margin-top-100 col-xs-12 col-sm-12 col-md-3">
    <h4 class="main-text-color">Choose a category</h4>
    <button type="button" class="category-list list-group-item">Fats and sweets</button>
    <button type="button" class="category-list list-group-item" data-type="milk">Milk</button>
    <button type="button" class="category-list list-group-item">Meat</button>
    <button type="button" class="category-list list-group-item" data-type="vegetables">Vegetables</button>
    <button type="button" class="category-list list-group-item">Fruits</button>
    <button type="button" class="category-list list-group-item">Starches</button>
</div>
<div class="options list-group margin-top-100 col-xs-12 col-sm-12 col-md-4">
    <div class="list-group col-xs-12 col-sm-12 col-md-12 hide" data-sub-type="vegetables">
        <h4 class="main-text-color">Vegetables</h4>
        <div class="list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" />grams
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <button type="button" class="category-sub-list-button">Artichoke(120g approx 1 medium) 
                <span class="add-grams">+</span>
            </button>
        
        <button type="button" class="category-sub-list-button">Asparagus (60g approx. 4 spears) <span class="add-grams">+</span></button>
        <button type="button" class="category-sub-list-button">Avocado   (60g approx. 4 spears)   <span class="add-grams">+</span></button>
        </div>
        </div>
</div>

<div class="options list-group margin-top-100 col-xs-12 col-sm-12 col-md-4">
    <div class="list-group col-xs-12 col-sm-12 col-md-12 hide" data-sub-type="milk">
        <h4 class="main-text-color">Milk</h4>
        <div class="list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" />grams
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <button type="button" class="category-sub-list-button">Milk, chocolate (250g approx. 1 cup) 
                <span class="add-grams">+</span>
            </button>
     
        <button type="button" class="category-sub-list-button">Milk, white (244g approx. 1 cup) <span class="add-grams">+</span></button>
        <button type="button" class="category-sub-list-button">Milkshake, thick <span class="add-grams">+</span></button>
      </div>
        </div>
</div>

<div class="meal-list-div margin-top-100 col-xs-12 col-sm-12 col-md-4 hide">
    <div class="list-group col-xs-12 col-sm-12 col-md-12">
        <h4 class="main-text-color">Meal</h4>
        <ul class="meal-list">
            
        </ul>
    </div>
</div>
<button class="clickMe">Click me</button>
<jsp:include page="calculator-footer.jsp" />
