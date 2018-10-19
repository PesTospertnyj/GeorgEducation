var data = [
    { value: "java", label: "JAVA", link: "pages/java.html", img: "images/java.png", descr: "some description"},
    { value: "c++",label: "C++",link: "pages/c_plus.html", img: "images/c+.jpg", descr: "some description"},
    { value: "javascript", label: "JAVASCRIPT", link: "pages/js.html", img: "images/js.png", descr: "some description"},
    { value: "private", label: "PRIVATE", link: "pages/private.html", img: "images/java.png", descr: "some description"},
    { value: "haskell", label: "HASKELL", link: "pages/haskell.html", img: "images/haskell.svg", descr: "some description"},
    { value: "ruby", label: "RUBY", link: "pages/ruby.html", img: "images/ruby.png", descr: "some description"},
    { value: "scala", label: "SCALA", link: "pages/scala.html", img: "images/scala.png", descr: "some description"},
    { value: "c#", label: "C#", link: "pages/c_sharp.html", img: "images/csh.svg", descr: "some description"}
];


$('#input').autocomplete({
    minLength: 1,
    source: data,
select: function( event, ui ) {
        // location.href = ui.item.link;
    // $('#cont').css("background-color", "green");
    $("#info").text(event.target);
    $( "#input" ).val(ui.item.label);
    location.href=ui.item.link;
    $(".collapse").collapse("hide");
//     $( "#info" ).text( ui.item.value );
// $( "#project-description" ).html( ui.item.desc );
// $( "#project-icon" ).attr( "src", "images/" + ui.item.icon );

        return false;
    },

    focus: function (event, ui) {
        $(".collapse").collapse("show");
        $("#logo").attr("src", ui.item.img);
        $("#info_header").text(ui.item.value);
        $("#descr").text(ui.item.descr);
    }
});

$("#input").on("blur", function(){
    $(".collapse").collapse("hide");
});