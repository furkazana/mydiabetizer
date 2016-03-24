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

        var numericalRegex = /^\d+$/;
        var numericalErrorSpan = "<span class=\"errorTooltip\">Only numbers allowed</span>";

        $(".blood-sugar").on("focusout", function () {
            if (!numericalRegex.test($(this).val()) && $(this).val() !== "") {
                $(this).parent().append(numericalErrorSpan);
                $(this).parent().children(".errorTooltip").css({
                    "left": "90px",
                    "top": "-110%"
                });
            }
        });

        $(".blood-sugar").on("focus", function () {
            $(this).parent().children(".errorTooltip").remove();
        });

        $(".add-to-meal-list").on("click", function () {
            var _this = $(this),
                    input = $(this).prev().prev(),
                    inputValue = input.val(),
                    categoryName = _this.parent().parent().parent().children(".cat-name").text();
            if (numericalRegex.test(inputValue)) {
                var splitChar = "-",
                        text = _this.parent().next().text(),
                        result = text.split(splitChar),
                        output = result[0] + " - " + inputValue;
                $(".meal-list").append("<li class=\"meal-list-item\" data-category=\"" + categoryName + "\">" +
                        output + " " + _this.parent().children(".qty").text() + " <span class=\"pull-right remove-meal-list-item\">x<span></li>");
                input.val("");
                _this.parent().addClass("hide");
                _this.parent().next().removeClass("hide");
            } else {
                _this.parent().append(numericalErrorSpan);
            }
        });

        $(".meal-list").on("click", ".remove-meal-list-item", function () {
            $(this).parent().remove();
            console.log("executed");
        });

        $(".save-meal").on("click", function () {
            if ($(".meal-list").children().length > 0) {
                var postData = {}, mealData = "", ill = "", activity = "", mealType, bloodSugar = "", splitChar = "-";
                $(".meal-list-item").each(function () {
                    var result = $(this).text().split(splitChar);
                    mealData += $(this).attr("data-category") + ":" + result[0] + ":" + result[1].match(/[0-9]+/)[0] + ";";
                });

                ill = $(".ill").filter(":checked").val(),
                activity = $(".activity").filter(":checked").val();
                mealType = $(".meal-type").filter(":checked").val();
                bloodSugar = $(".blood-sugar").val();
                if(mealType === undefined) {
                    mealType = "";
                }

                postData.mealData = mealData;
                postData.ill = ill;
                postData.activity = activity;
                postData.mealType = mealType;
                postData.bloodSugar = bloodSugar;
                console.log(postData);
                $.ajax({
                    type: "POST",
                    url: "/mydiabetizer-war/calculator",
                    dataType: "json",
                    data: JSON.stringify(postData),
                    success: function (data) {
                        // TODO
                        $(".result").html(data);
                        console.log(data);
                    }
                });
            }
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