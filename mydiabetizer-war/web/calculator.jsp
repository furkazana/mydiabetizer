<%-- 
    Document   : calculator
    Created on : Feb 6, 2016, 1:37:31 PM
    Author     : Tsvetelin
--%>
<%@page import="ent.ChartEntity"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
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
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    
    List<Fruits> fruitsList = (List<Fruits>) request.getAttribute("fruitsList");
    List<Starches> starchesList = (List<Starches>) request.getAttribute("starchesList");
    List<Meats> meatsList = (List<Meats>) request.getAttribute("meatsList");
    List<Vegetables> vegList = (List<Vegetables>) request.getAttribute("vegList");
    List<Beverages> BeveragesList = (List<Beverages>) request.getAttribute("BeveragesList");
    List<Fatsandsweets> FatsandsweetsList = (List<Fatsandsweets>) request.getAttribute("FatsandsweetsList");
    HashMap<String, HashMap<String, String>> mealsList = ( HashMap<String, HashMap<String, String>>) request.getAttribute("MealsList");
    
%>

<div class="col-xs-12 col-sm-12 col-md-12 margin-top-100 white-background padding-10">
    <h4>Please help us to make more precise calculation by filling out the fields below. Thank you!</h4>
    <div class="margin-top-20">
        <label class="margin-right-10">Ill :</label>
        <span class="margin-right-10">No</span><input class="ill margin-right-10" type="radio" name="ill" checked="true" value="no"/>
        <span class="margin-right-10">Yes</span><input class="ill margin-right-10" type="radio" name="ill" value="yes"/>
    </div>
    <div>
        <label class="margin-right-10">Next 2 hours activities :</label>
        <span class="margin-right-10">low </label><input class="activity margin-right-10" type="radio" name="activity" value="low" checked="true"/>
        <span class="margin-right-10">Medium</label><input class="activity margin-right-10" type="radio" name="activity" value="medium"/>
        <span class="margin-right-10">High</label><input class="activity margin-right-10" type="radio" name="activity" value="high"/>
    </div>
    <div>
        <label class="margin-right-10">Choose meal type :</label>
        <span class="margin-right-10">Breakfast </span><input class="meal-type margin-right-10" type="radio" name="mealType" value="breakfast" checked="true"/>
        <span class="margin-right-10">Lunch</span><input class="meal-type margin-right-10" type="radio" name="mealType" value="lunch"/>
        <span class="margin-right-10">Dinner</span><input class="meal-type margin-right-10" type="radio" name="mealType" value="dinner"/>
        <span class="margin-right-10">Snack</span><input class="meal-type margin-right-10" type="radio" name="mealType" value="high"/>
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
    <button type="button" class="category-list-item list-group-item" data-type="myMeals">My meals</button>
</div>

<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="fatsAndSweets">
        <h4 class="cat-name main-text-color">FatsAndSweets</h4>
        <%
            for (Fatsandsweets fatsandsweets : FatsandsweetsList) {
        %>
        <div class="category-list list-group-item">
            <div class="hide">
                <input type="text" class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list  btn btn-custom  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list   btn btn btn-custom-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span class="qty">grams</span>
                <button type="button" class="add-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span  class="qty">grams</span>
                <button type="button" class="add-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
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
                <input type="text" class="category-sub-list-input" /> <span class="qty">carbs</span>
                <button type="button" class="add-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
            </div>
            <div>
                Other
                <span class="add-grams glyphicon glyphicon-plus pull-right"></span>
            </div>
        </div>
    </div>
</div>

<div class="list-group list-sub-group margin-top-20 col-xs-12 col-sm-12 col-md-4  hide">
    <div data-sub-type="myMeals">
        <h4 class="cat-name main-text-color">My meals</h4>
        <% for(Map.Entry<String, HashMap<String, String>> entry : mealsList.entrySet()) { %>
        <div class="category-list list-group-item">
            <div>
                <%= entry.getKey() %><button type="button" class="add-meal-to-meal-list  btn btn-custom btn-primary btn-transparent pull-right">Add to meal</button>
                <ul class="hide">
                    <% 
                        HashMap<String, String> category = entry.getValue();
                        for(Map.Entry<String, String> entry2 : category.entrySet()) { 
                    %>
                        <li class="meal-list-item" data-category="<%= entry2.getKey().replaceAll("[0-9]","") %>">
                            <%= entry2.getValue() %> grams
                            <span class="pull-right remove-meal-list-item">x</span>
                        </li>
                    <% } %>
                </ul>
            </div>
        </div>
        <% } %>
    </div>
</div>
    
<div class="meal-list-div margin-top-20 col-xs-12 col-sm-12 col-md-4 hide padding-left-0">
    <div class="list-group col-xs-12 col-sm-12 col-md-12">
        <h4 class="main-text-color">Meal</h4>
        <ul class="meal-list">  
        </ul>
        <button class="calculate btn btn-primary btn-transparent pull-right">Calculate</button>    
        <button class="btn btn-primary btn-transparent pull-right margin-right-10" data-toggle="modal" data-target="#mealModal">Save meal</button>    
        <!-- Modal -->
        <div class="modal fade" id="mealModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Meal name</h4>
                    </div>
                    <div class="modal-body">
                        <input type="text" class="mealName" placeholder="Type meal name here"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="save-meal btn btn-primary btn-transparent pull-right">Save changes</button>
                        <button type="button" class="btn btn-primary btn-transparent pull-right margin-right-10" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="insulinAjaxResult margin-top-100 col-xs-12 col-sm-12 col-md-offset-2 col-md-4 hide padding-left-0 white-background">
        <h4 class="text-center">Suggested units of insulin: <span class="insulin main-text-color"></span></h4>
    </div>
<!--    <div class="mealAjaxResult margin-top-100 col-xs-12 col-sm-12 col-md-offset-2 col-md-4 hide padding-left-0 white-background">
        <h4 class="text-center">Meal was successfully added.</h4>
    </div>-->
<button class="clickMe">Click me</button>
<jsp:include page="calculator-footer.jsp" />
