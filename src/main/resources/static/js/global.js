(function ($) {
    'use strict';
    /*==================================================================
        [ Daterangepicker ]*/
    try {
        $('.js-datepicker').daterangepicker({
            "singleDatePicker": true,
            "showDropdowns": true,
            "autoUpdateInput": false,
            locale: {
                format: 'DD/MM/YYYY'
            },
        });
    
        var myCalendar = $('.js-datepicker');
        var isClick = 0;
    
        $(window).on('click',function(){
            isClick = 0;
        });
    
        $(myCalendar).on('apply.daterangepicker',function(ev, picker){
            isClick = 0;
            $(this).val(picker.startDate.format('DD/MM/YYYY'));
    
        });
    
        $('.js-btn-calendar').on('click',function(e){
            e.stopPropagation();
    
            if(isClick === 1) isClick = 0;
            else if(isClick === 0) isClick = 1;
    
            if (isClick === 1) {
                myCalendar.focus();
            }
        });
    
        $(myCalendar).on('click',function(e){
            e.stopPropagation();
            isClick = 1;
        });
    
        $('.daterangepicker').on('click',function(e){
            e.stopPropagation();
        });
    
    
    } catch(er) {console.log(er);}
    /*[ Select 2 Config ]
        ===========================================================*/
    
    try {
        var selectSimple = $('.js-select-simple');
    
        selectSimple.each(function () {
            var that = $(this);
            var selectBox = that.find('select');
            var selectDropdown = that.find('.select-dropdown');
            selectBox.select2({
                dropdownParent: selectDropdown
            });
        });
    
    } catch (err) {
        console.log(err);
    }

     // Show password
        document.getElementById("showPasswordButton").addEventListener("click", function(){
            let passwordInput = document.getElementById("passwordInput");
            if (passwordInput.type === "password") {
              passwordInput.type = "text";
            } else {
              passwordInput.type = "password";
            }
          });

        // show error if user enter phone number above 10
        const input = document.getElementById("phoneNumber");
        const errorMessage = document.getElementById("errorMessage");
        input.addEventListener("input", function () {
        const phoneNumber = input.value;

        if (phoneNumber.length > 10) {
            errorMessage.innerText = "Phone number must not exceed 10 digits";
        } else {
            errorMessage.innerText = "";
        }
        });

        // Disabled submit button if user enter phone number above 10
        document.getElementById("phoneNumber").oninput = function() {
            if (this.value.length > 10) {
              document.getElementById("submitBtn").disabled = true;
            } else {
              document.getElementById("submitBtn").disabled = false;
            }
          };

    

})(jQuery);