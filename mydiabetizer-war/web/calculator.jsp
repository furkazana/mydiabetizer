<%-- 
    Document   : calculator
    Created on : Feb 6, 2016, 1:37:31 PM
    Author     : Tsvetelin
--%>
<%@page import="ent.Fatsandsweets"%>
<%@page import="ent.Beverages"%>
<%@page import="ent.Vegetables"%>
<%@page import="ent.Meats"%>
<%@page import="ent.Starches"%>
<jsp:include page="header.jsp" />
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ent.Fruits"%>
<%--<%@page import="beans.FoodHandlerBeanLocal"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="beans.FoodHandlerBean"%>--%>

<%
    List<Fruits> fruitsList = (List<Fruits>) request.getAttribute("fruitsList");
    List<Starches> starchesList = (List<Starches>) request.getAttribute("starchesList");
    List<Meats> meatsList = (List<Meats>) request.getAttribute("meatsList");
    List<Vegetables> vegList = (List<Vegetables>) request.getAttribute("vegList");
    List<Beverages> BeveragesList = (List<Beverages>) request.getAttribute("BeveragesList");
    List<Fatsandsweets> FatsandsweetsList = (List<Fatsandsweets>) request.getAttribute("FatsandsweetsList");
%>
<div class="col-xs-12 col-sm-12 col-md-12 margin-top-100 white-background padding-10">
    <h4>Please help us to make more precise calculation by filling out the fields below. Thank you!</h4>
    <div class="margin-top-20">
        <label class="margin-right-10">Ill :</label>
        <span class="margin-right-10">No</span><input class="ill" type="radio" name="ill" checked="true" value="no"/>
        <span class="margin-right-10">Yes</span><input class="ill" type="radio" name="ill" value="yes"/>
    </div>
    <div>
        <label class="margin-right-10">Next 2 hours activities :</label>
        <span class="margin-right-10">low </label><input class="activity" type="radio" name="activity" value="low" checked="true"/>
        <span class="margin-right-10">Medium</label><input class="activity" type="radio" name="activity" value="medium"/>
        <span class="margin-right-10">High</label><input class="activity" type="radio" name="activity" value="high"/>
    </div>
    <div>
        <label class="margin-right-10">Choose meal type :</label>
        <span class="margin-right-10">Breakfast </span><input class="meal-type" type="radio" name="mealType" value="breakfast"/>
        <span class="margin-right-10">Lunch</span><input class="meal-type" type="radio" name="mealType" value="lunch"/>
        <span class="margin-right-10">Dinner</span><input class="meal-type" type="radio" name="mealType" value="dinner"/>
        <span class="margin-right-10">Snack</span><input class="meal-type" type="radio" name="mealType" value="high"/>
    </div>
    <div style="position: relative">
        <label class="margin-right-10">Blood sugar </label><input class="blood-sugar" type="text" name="bloodSugar" />
    </div>
</div>
<div class="list-group margin-top-20 col-xs-12 col-sm-12 col-md-3">
    <h4 class="main-text-color">Choose a category</h4>
    <button type="button" class="category-list-item list-group-item" data-type="fatsAndSweets">FatsAndSweets</button>
    <button type="button" class="category-list-item list-group-item" data-type="beverages">Beverages</button>
    <button type="button" class="category-list-item list-group-item" data-type="meats">Meats</button>
    <button type="button" class="category-list-item list-group-item" data-type="vegetables">Vegetables</button>
    <button type="button" class="category-list-item list-group-item" data-type="fruits">Fruits</button>
    <button type="button" class="category-list-item list-group-item" data-type="starches">Starches</button>
    <button type="button" class="category-list-item list-group-item" data-type="other">Other</button>
</div>

<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="fatsAndSweets">
        <h4 class="cat-name main-text-color">FatsAndSweets</h4>
        <%
            for (Fatsandsweets fatsandsweets : FatsandsweetsList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= fatsandsweets.getFnsTitle() + " - " + fatsandsweets.getFnsGrams() + "g approx. " + fatsandsweets.getFnsMeasurements()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>


<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4 hide">
    <div data-sub-type="fruits">
        <h4 class="cat-name main-text-color">Fruits</h4>
        <%
            for (Fruits fruit : fruitsList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= fruit.getFruitTitle() + " - " + fruit.getFruitGrams() + "g approx. " + fruit.getFruitMeasurement()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>
<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="starches">
        <h4 class="cat-name main-text-color">Starches</h4>
        <%
            for (Starches starch : starchesList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= starch.getStarchTitle() + " - " + starch.getStarchGrams() + "g approx. " + starch.getStarchMeasurements()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>
<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="meats">
        <h4 class="cat-name main-text-color">Meats</h4>
        <%
            for (Meats meat : meatsList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= meat.getMeatTitle() + " - " + meat.getMeatGrams() + "g approx. " + meat.getMeatMeasurements()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>
<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="vegetables">
        <h4 class="cat-name main-text-color">Vegetables</h4>
        <%
            for (Vegetables vegetable : vegList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= vegetable.getVegTitle() + " - " + vegetable.getVegGrams() + "g approx. " + vegetable.getVegMeasurements()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>
<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="beverages">
        <h4 class="cat-name main-text-color">Beverages</h4>
        <%
            for (Beverages beverage : BeveragesList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span  class="qty">grams</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                <%= beverage.getBevTitle() + " - " + beverage.getBevGrams() + "g approx. " + beverage.getBevMeasurement()%>
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
        <%    }
        %>
    </div>
</div>
<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="other">
        <h4 class="cat-name main-text-color">Other</h4>
        <div class="category-list list-group-item">
            <div class="hide">
                <input class="category-sub-list-input" /> <span class="qty">carbs</span>
                <button type="button" class="add-to-meal-list btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                Other
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
    </div>
</div>

<div class="meal-list-div margin-top-20 col-xs-12 col-sm-12 col-md-4 hide padding-left-0">
    <div class="list-group col-xs-12 col-sm-12 col-md-12">
        <h4 class="main-text-color">Meal</h4>
        <ul class="meal-list">  
        </ul>
        <button class="save-meal btn btn-primary btn-transparent pull-right">Save</button>    
    </div>
</div>
<button class="clickMe">Click me</button>
<jsp:include page="calculator-footer.jsp" />
