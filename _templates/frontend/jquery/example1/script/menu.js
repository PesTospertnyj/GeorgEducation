
function createMenu(wrapper, menues) {
    var wWidth = wrapper.width();
    var wHeight = wrapper.height();
    var itemWidth = wWidth/menues.length;
    var itemHeight = wHeight;
    var itemColor = wrapper.css('backgroundColor');
    wrapper.css('display', 'table');
    var menuObj = [];
    var baseLeft = 0;
        for (let i=0; i<menues.length; i++) {
            
            $( "<div style='width: "+itemWidth+"px; height: "+itemHeight+"px; vertical-align: middle; display: table-cell; text-align: center;' id='menu"+i+"'>"+menues[i].menu+"</div>" )
            .appendTo( wrapper );
            var itemId = $('#menu'+i);
            if (i==0) {
                baseLeft=itemId.position().left;
            }
            // menuObj[i] = {id: itemId, x: baseLeft+i*itemWidth, y: itemId.position().top+itemId.height()};
            menuObj[i] = {id: itemId, subMenu: menues[i].submenu};
            menuObj[i].id.attr({index: i, x: baseLeft+i*itemWidth-6, y: itemId.position().top+itemId.height()+5});
            
            menuObj[i].id.mouseover(function(event){
                $(this).css({
                    "background-color": "rgb(221, 221, 221)",
                    // "box-shadow": "5px 10px #888888",    
                    "cursor": "pointer",
                    // "border" : "1px grey solid",
                    // "border-radius" : "3px", 
                });
                $(this).attr('unselectable', 'on')
                 .css('user-select', 'none');
                
                 
                customDiv.css({"display":"table"});
                 var newY = $(this).attr('y');
                 customDiv.offset({top:newY, left:$(this).attr('x')});
                 customDiv.empty();
                 var maxWidth = 0;
                 for (let j=0; j<menuObj[$(this).attr('index')].subMenu.length; j++) {
                    var subMenuDiv = $('<div>'+menuObj[$(this).attr('index')].subMenu[j]+'</div>');
                    subMenuDiv.attr({"index":$(this).attr('index'), "subindex":j});
                    subMenuDiv.css({
                        "vertical-align": "middle", 
                        "display": "flex",
                        "height" : itemHeight+"px",
                        "padding-left": "15px",
                        "padding-right": "15px",
                        "line-height": itemHeight+"px",
                        "white-space": "nowrap",
                        "margin" : "5px",
                        // "background-color": "rgb(235, 235, 235)"
                        "background-color": itemColor
                    })
                    customDiv.append(subMenuDiv);
                    if (subMenuDiv.width()>maxWidth) maxWidth=subMenuDiv.width();
                 }

                 customDiv.css({"width": (maxWidth<itemWidth+12? itemWidth+12 :maxWidth)+"px"});
                 customDiv.show();
            });
            
            menuObj[i].id.mouseout(function(idx){
                $(this).css("background-color", itemColor);
                $(this).css( 'cursor', 'auto' );
                $(this).attr('unselectable', 'off').css('user-select', 'auto');
                customDiv.css({"width":"0px", "height":"0px"});
                customDiv.hide();
            });
        }
        var customDiv = $("<div></div>");
        customDiv.css({
            // "width" : "300px",
            // "height" : "300px",
            "position" : "fixed",
            "border" : "1px grey solid",
            "border-radius" : "3px", 
            "z-index" : "2  ",
            "opacity" : "1",
            "display" : "table",
            "background-color": "rgb(250, 250, 250)",
            "box-shadow": "5px 10px rgb(180, 180, 180)"
        });
        customDiv.hide();
        wrapper.append(customDiv);
    }
