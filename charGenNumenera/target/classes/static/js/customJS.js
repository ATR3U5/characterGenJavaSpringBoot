var focusbutton = false;
var classbutton = false;
var descriptorbutton = false;

var descTab = false;
var classTab = false;
var focusTab = false;

$(document).ready(function(){

    $("#descCollapse").click(function () {

        if(descTab){
            descTab = false;
            $.post("/descTab", {tab: descTab});
        }

        else{
            descTab = true;
            $.post("/descTab", {tab: descTab});
        }
    });

    $("#classCollapse").click(function () {

        if(classTab){
            classTab = false;
            $.post("/classTab", {tab: classTab});
        }

        else{
            classTab = true;
            $.post("/classTab", {tab: classTab});
        }
    });

    $("#focusCollapse").click(function () {

        if(focusTab){
            focusTab = false;
            $.post("/focusTab", {tab: focusTab});
        }

        else{
            focusTab = true;
            $.post("/focusTab", {tab: focusTab});
        }
    });




});

$(document).ready(function() {

        $.post("/focusSetStart", function (data) {
            focusbutton = data;
            if(focusbutton){
                $("#focusbtn").html("LOCKED");
                document.getElementById("focusbtn").classList.add('btnLocked');
                document.getElementById("focuscard").classList.add('card-locked');
            }
            else{
                $("#focusbtn").html("CLICK TO LOCK");
                document.getElementById("focusbtn").classList.remove('btnLocked');
                document.getElementById("focuscard").classList.remove('card-locked');
            }
        });

        $.post("/classSetStart", function (data) {
            classbutton = data;
            if(classbutton){
                $("#classbtn").html("LOCKED");
                document.getElementById("classbtn").classList.add('btnLocked');
                document.getElementById("classcard").classList.add('card-locked');
            }
            else{
                $("#classbtn").html("CLICK TO LOCK");
                document.getElementById("classbtn").classList.remove('btnLocked');
                document.getElementById("classcard").classList.remove('card-locked');
            }
        });

        $.post("/descSetStart", function (data) {
            descriptorbutton = data;
            if(descriptorbutton){
                $("#descriptorbtn").html("LOCKED");
                document.getElementById("descriptorbtn").classList.add('btnLocked');
                document.getElementById("desccard").classList.add('card-locked');
            }
            else{
                $("#descriptorbtn").html("CLICK TO LOCK");
                document.getElementById("descriptorbtn").classList.remove('btnLocked');
                document.getElementById("desccard").classList.remove('card-locked');
            }
        });

        $.post("/descCollapse", function(data){

            if(data){

                $("#collapseDesc").collapse('show');
                descTab = true;

            }
            else{

                $("#collapseDesc").collapse('hide');
                descTab = false;
            }
        });

    $.post("/classCollapse", function(data){

        if(data){

            $("#collapseClass").collapse('show');
            classTab= true;

        }
        else{

            $("#collapseClass").collapse('hide');
            classTab = false;
        }
    });

    $.post("/focusCollapse", function(data){

        if(data){

            $("#collapseFocus").collapse('show');
            focusTab = true;

        }
        else{

            $("#collapseFocus").collapse('hide');
            focusTab = false;
        }
    });

    }
);

$(document).ready(function () {

    $("#focusbtn").click(function () {

        if (focusbutton) {

           $("#focusbtn").html("CLICK TO LOCK");
            document.getElementById("focusbtn").classList.remove('btnLocked');
            document.getElementById("focuscard").classList.remove('card-locked');
            focusbutton = false;
            $.post("/focusButton", {focus: focusbutton});
        }

        else {
            $("#focusbtn").html("LOCKED");
            document.getElementById("focusbtn").classList.add('btnLocked');
            document.getElementById("focuscard").classList.add('card-locked');
            focusbutton = true;
            $.post("/focusButton", {focus: focusbutton});
        }
    });
});

$(document).ready(function () {

    $("#descriptorbtn").click(function () {

        if (descriptorbutton) {

            $("#descriptorbtn").html("CLICK TO LOCK");
            document.getElementById("descriptorbtn").classList.remove('btnLocked');
            document.getElementById("desccard").classList.remove('card-locked');
            descriptorbutton = false;
            $.post("/descButton", {descriptor: descriptorbutton});
        }

        else {
            $("#descriptorbtn").html("LOCKED");
            document.getElementById("descriptorbtn").classList.add('btnLocked');
            document.getElementById("desccard").classList.add('card-locked');
            descriptorbutton = true;
            $.post("/descButton", {descriptor: descriptorbutton});
        }
    });
});

$(document).ready(function () {

    $("#classbtn").click(function () {

        if (classbutton) {

            $("#classbtn").html("CLICK TO LOCK");
            document.getElementById("classbtn").classList.remove('btnLocked');
            document.getElementById("classcard").classList.remove('card-locked');
            classbutton = false;
            $.post("/classButton", {character: classbutton});
        }

        else {
            $("#classbtn").html("LOCKED");
            document.getElementById("classbtn").classList.add('btnLocked');
            document.getElementById("classcard").classList.add('card-locked');
            classbutton = true;
            $.post("/classButton", {character: classbutton});
        }
    });
});
