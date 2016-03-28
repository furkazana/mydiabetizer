<%-- 
<%-- 
    Document   : footer
    Created on : Jun 22, 2015, 11:20:19 PM
    Author     : Tsvetelin
--%>
</div>
</div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(".accountForm").on("submit", function (event) {
            event.preventDefault();
            var postData = {}, errors = false, dateOfBirthRegex = /^(\d{2})-(\d{2})-(\d{4})$/;
            
            if (!dateOfBirthRegex.test($(".dateOfBirth").val())) {
                errors = true;
                if ($(".dateOfBirth").val() === "") {
                    errors = true;
                    $(".dateOfBirthError").text("This field is required.");
                } else {
                    $(".dateOfBirthError").text("Invalid date of birth: eg. DD-MM-YYYY");
                }
            } else {
                $(".dateOfBirthError").text("");
            }
            
            if ($(".kg").val() === "") {
                errors = true;
                $(".kgError").text("This field is required.");
            } else {
                $(".kgError").text("");
            }
            
            if($(".generalRatio").val() != "") {
                $(".ratio:not(:last-child)").val("");
            }
            if (!errors) {
                postData.kg = $(".kg").val();
                postData.bodyType = $('[name="bodyType"]').filter(":checked").val();
                postData.rapidDoses = $('[name="rapidDoses"]').val();
                postData.dateOfBirth = $(".dateOfBirth").val();
                postData.breakfastRatio = $('[name="breakfastRatio"]').val();
                postData.lunchRatio = $('[name="lunchRatio"]').val();
                postData.dinnerRatio = $('[name="dinnerRatio"]').val();
                postData.generalRatio = $('[name="generalRatio"]').val();
                $.ajax({
                    type: "POST",
                    url: "/mydiabetizer-war/AccountHandler",
                    dataType: "json",
                    data: JSON.stringify({"postData": postData}),
                    success: function (data) {
                        // TODO
                        console.log(data);
                    }
                });
            }
        });
    });
</script>
</body>
</html>
