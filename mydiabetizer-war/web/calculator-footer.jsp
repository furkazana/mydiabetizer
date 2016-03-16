</div>
</div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $(".category-list-item").on("click", function () {
            var dataType = $(this).attr("data-type");
            $(".list-sub-group").addClass("hide");
            $('[data-sub-type="' + dataType + '"]').parent().removeClass("hide");
            var mealListDiv = $(".meal-list-div");
            if (mealListDiv.hasClass("hide")) {
                mealListDiv.removeClass("hide");
            }
        });
        $(".clickMe").on("click", function () {
            makeTest();
        });

        $(".add-grams").on("click", function () {
            var parent = $(this).parent();
            parent.prev().removeClass("hide");
            parent.prev().children(".category-sub-list-input").focus();
            parent.addClass("hide");
        });
        
        var postData = "";
        $(".add-to-meal-list").on("click", function () {
            var _this = $(this),
                    regex = /^\d+$/,
                    input = $(this).prev(),
                    inputValue = input.val(),
                    categoryName = _this.parent().parent().parent().children(".cat-name").text();
            if (regex.test(inputValue)) {
                var splitChar = "-",
                        text = _this.parent().next().text(),
                        result = text.split(splitChar),
                        output = result[0] + " - " + inputValue;
                postData += categoryName + ":" + result[0] + ":" + inputValue + ";";
                console.log(categoryName + ":" + result[0] + ":" + inputValue + ";");
                $(".meal-list").append("<li>" + output + " grams</li>");
                input.val("");
                _this.parent().addClass("hide");
                _this.parent().next().removeClass("hide");
            } else {
                var errorSpan = "<span class=\"errorTooltip\">Only numbers allowed</span>";
                _this.parent().append(errorSpan);
            }
        });
        $(".save-meal").on("click", function () {
            $.ajax({
                type: "POST",
                url: "/mydiabetizer-war/calculator",
                data:{postData:postData},
                success: function (data) {
                    // TODO
                    $(".result").html(data);
                    console.log(data);
                }
            });
        });
    });
    function makeTest() {
        var JsonObj = {
            name: "Yavor"
        };
        $.ajax({
            type: "POST",
            url: "/mydiabetizer-war/calculator",
            data: JsonObj,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $(".result").html(data);
            }
        });
    }
</script>
</body>
</html>