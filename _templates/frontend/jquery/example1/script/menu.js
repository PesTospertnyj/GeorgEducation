var menuObj = [];
function createMenu(wrapper, menues) {
    var wWidth = wrapper.width();
    var wHeight = wrapper.height();
    var itemWidth = wWidth/menues.length;
    var itemHeight = wHeight;
    var itemColor = wrapper.css('backgroundColor');
    menuObj = [];
        for (var i=0; i<menues.length; i++) {
            $( "<div style='width: "+itemWidth+"px; height: "+itemHeight+"px; text-align: center;' id='menu"+i+"'><p>"+menues[i]+"</p></div>" )
            .appendTo( wrapper );
            menuObj[i] = $('#menu'+i);
            menuObj[i].mouseover(function(){
                $(this).css("background-color", "grey");
                $(this).css( 'cursor', 'pointer' );
            });
            menuObj[i].mouseout(function(){
                $(this).css("background-color", itemColor);
                $(this).css( 'cursor', 'auto' );
            });
        }


        //  wrapper.html("hello "+wrapper.width()+" "+wrapper.height());
    }