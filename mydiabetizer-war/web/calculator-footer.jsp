</div>
</div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        var postArr = [];
        $(".list-group-item").on("click", function() {
            var dataType = $(this).attr("data-type");
            $('[data-sub-type="' + dataType + '"]').removeClass("hide");
            var mealListDiv = $(".meal-list-div");
            if(mealListDiv.hasClass("hide")) {
                mealListDiv.removeClass("hide");
            }
        });
        $(".clickMe").on("click", function(){
            makeTest();
        });
        
        $(".add-grams").on("click", function() {
            $(this).parent().prev().removeClass("hide");
            var input = $(this).parent();
                input.addClass("hide");
                input.focus();
        });
        
        $(".add-to-meal-list").on("click", function() {
            var splitChar = "-",
                text = $(this).parent().next().text(),
                result = text.split(splitChar),
                output = result[0] + $(this).prev().val();
                postArr;
                $(".meal-list").append("<li>" + output + " grams</li>");
                
        });
    });
    function makeTest() {
        var JsonObj = {
            name:"Yavor"
        };
        $.ajax({
            type: "POST",
            url: "/mydiabetizer-war/calculator",
            data: JsonObj,
            contentType:"application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                $(".result").html(data);
            }
        });
    }
</script>
</body>
</html>