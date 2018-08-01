var points = [];
var markers = [];
var divParent;
var map;
var currentPos;
var initScale;
var markerCluster;
var dataSourceCallback;
var isClustering = true;
var isCurrentLocation = true;
var loaderTemplate = '<div style="width:100px;max-height: 100px;">' +
    '<img  style="max-width:30px; margin-left:45px; margin-top: 25px; margin-bottom: 20px"'+
    'src="img/loader.gif"/>'+
    '</div>';

var infoWindowTemplate = '<br><div style="width:300px;max-height: 300px;">' +
    '<div style="display:flex;justify-content: space-between;">'+
    '<div >'+
    '<h6>%title%</h6>'+
    '</div>'+
    '<div >'+
    '<img  style="max-width:100px"'+
    'src="%image%"/>'+
    '</div>'+
    '</div><br>'+
    '<div>'+
    '%description%'+
    '</div>'+
    '<br>'+
    '<a href="'+'%href%'+'" onclick='+"'"+'%onClick%'+"'"+'>%link%</a>'+
    '</div>';


var InfoWindowContent = function(arg) {
    this.title = arg.title;
    this.img = arg.img;
    this.text = arg.text;
    this.href = arg.href;
    this.onClick = arg.onClick;
    this.link2show = arg.link2show;
}

var setInfoWindowContent = function(arg) {
    var rValue = infoWindowTemplate;
    if (arg.title) rValue = rValue.replace("%title%",arg.title);
    if (arg.img) rValue = rValue.replace("%image%",arg.img);
    if (arg.text) rValue = rValue.replace("%description%",arg.text);
    if (arg.href) rValue = rValue.replace("%href%",arg.href); 
    else rValue = rValue.replace("%href%","#")
    if (arg.onClick) rValue = rValue.replace("%onClick%",arg.onClick); 
    else rValue = rValue.replace("%onClick%","");
    if (arg.link2show) rValue = rValue.replace("%link%",arg.link2show); 
    else rValue = rValue.replace("%link%","");

    return rValue;
}


var addMarker = function(arg) {

    var markerDescription = {id: markers.length, position: arg.position, map: map};
    
    if (arg.title) markerDescription.title=arg.title;

    if (arg.icon) markerDescription.icon= {
        url: arg.icon,
        size: new google.maps.Size(30, 40),
        origin: new google.maps.Point(0, 0),
        anchor: new google.maps.Point(16, 40)
    };

    if (arg.infoWindowContent) markerDescription.infoWindowContent = setInfoWindowContent(arg.infoWindowContent);
    else markerDescription.infoWindowContent = loaderTemplate;
    markerDescription.infoWindow = new google.maps.InfoWindow({
    });

    markerDescription.infoWindow.setContent(markerDescription.infoWindowContent);
    markerDescription.isGotData = arg.isLoaded ? arg.isLoaded : false;

    const marker = new google.maps.Marker(markerDescription);
    markers.push(marker);

    if (markerCluster) markerCluster.addMarker(marker,false);

    google.maps.event.addListener(marker, 'click', function() {
        for (idx in markers) {
            if (markers[idx] && markers[idx].id!=marker.id) markers[idx].infoWindow.close();
        }
        marker.infoWindow.open(map,this)
        google.maps.event.addListener(map, 'click', function() {
            if (marker.infoWindow)
            marker.infoWindow.close();  
        }); 
        if (!markers[marker.id].isGotData) {
            dataSourceCallback(markerDescription.id, 
                function(content) {
                    marker.infoWindow.setContent(setInfoWindowContent(content)), markers[markerDescription.id].infoWindowContent = content; 
                });        
            markers[markerDescription.id].isGotData = true;
        } 
    })
    return markers.length-1;

}

function CustomMap(divName, callBack) {
    dataSourceCallback = callBack;
    divParent = divName;

    window.onload = function() {

        var scriptJQuery = document.createElement("script");
        scriptJQuery.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js";
        document.head.appendChild(scriptJQuery);

        scriptJQuery.onload = function() {
            var scriptClusterer = document.createElement("script");
            scriptClusterer.src = "https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js";
            document.body.appendChild(scriptClusterer);

            scriptClusterer.onload = function() {
                var scriptGoogle = document.createElement("script");
                scriptGoogle.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDEpLIkIDjGMAELPSuov74JobrW2xDwVP0&callback=initMap";
                scriptGoogle.async = true;
                scriptGoogle.defer = true;
                document.body.appendChild(scriptGoogle);
            }
        }
    };

    this.addMarkers = function(args) {
        var ids = [];
        for (idx in args) {
            points.push(args[idx])
            ids.push(points.length-1)
            if (map) {
                addMarker(args[idx]);
            }
        }
        return ids;
    }

    this.setCenter = function(arg, scale) {
        currentPos = arg;
        initScale = scale;
        return this;
    }

    this.availableData = function(id) {
        markers[id].isGotData = false;
        markers[id].infoWindow.setContent(loaderTemplate);
        var iMap = markers[id].infoWindow.getMap()
        if (iMap !=null && typeof map !== "undefined") {
            dataSourceCallback(id, 
                function(content) {
                    markers[id].infoWindow.setContent(setInfoWindowContent(content)), markers[id].infoWindowContent = content; 
                });        
            markers[id].isGotData = true;
        }
    }

    this.removeMarker = function(arg) {
        if (arg>(points.length-1) || arg<0) return -1;
        if (points[arg]) {
            if (isClustering) markerCluster.removeMarker(markers[arg]);
            markers[arg].setMap(null);
            markers[arg] = null;
            points[arg] = null;
            return arg;
        } else return -1
        
    }

    this.enableClustering = function() {
        isClustering = true;
        return this;
    }

    this.enableCurrentPosition = function() {
        isCurrentLocation = true;
        return this;
    }

    this.disableClustering = function() {
        isClustering = false;
        return this;
    }

    this.disableCurrentPosition = function() {
        isCurrentLocation = false;
        return this;
    }

}

function initMap() {

    var iconUrl = 'img/group.png'
    if (points.length>0) {
        var latMin = points[0].position.lat, lngMin = points[0].position.lat, 
            latMax = points[0].position.lng, lngMax = points[0].position.lng; 
        if (!currentPos) {
        for (let idx in points) {
            latMin = points[idx].position.lat<latMin ? points[idx].position.lat : latMin;
            lngMin = points[idx].position.lng<lngMin ? points[idx].position.lng : lngMin;
            latMax = points[idx].position.lat>latMax ? points[idx].position.lat : latMax;
            lngMax = points[idx].position.lng>lngMax ? points[idx].position.lng : lngMax;
        }

        currentPos = {lat: (latMin+latMax)/2, lng: (lngMin+lngMax)/2};
        initScale = 4;
        } 
    } else {
        currentPos = {lat: 0, lng: 0};
        initScale = 4;
    } 
    
    map = new google.maps.Map(document.getElementById(divParent), {zoom: initScale, center: currentPos});

    for (let idx in points)  addMarker(points[idx])
    
    if (isClustering) {
     markerCluster = new MarkerClusterer(map, markers,
         {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
     markerCluster.setGridSize(10);
    }

    if (isCurrentLocation) addLocationButton(map);

}

function addLocationButton(map)
{
    var controlDiv = document.createElement('div');

    var firstChild = document.createElement('button');
    firstChild.style.backgroundColor = '#fff';
    firstChild.style.border = 'none';
    firstChild.style.outline = 'none';
    firstChild.style.width = '28px';
    firstChild.style.height = '28px';
    firstChild.style.borderRadius = '2px';
    firstChild.style.boxShadow = '0 1px 4px rgba(0,0,0,0.3)';
    firstChild.style.cursor = 'pointer';
    firstChild.style.marginRight = '10px';
    firstChild.style.padding = '0px';
    firstChild.title = 'Your Location';
    controlDiv.appendChild(firstChild);

    var secondChild = document.createElement('div');
    secondChild.style.margin = '5px';
    secondChild.style.width = '18px';
    secondChild.style.height = '18px';
    secondChild.style.backgroundImage = 'url(https://maps.gstatic.com/tactile/mylocation/mylocation-sprite-1x.png)';
    secondChild.style.backgroundSize = '180px 18px';
    secondChild.style.backgroundPosition = '0px 0px';
    secondChild.style.backgroundRepeat = 'no-repeat';
    secondChild.id = 'youLocationImg';
    firstChild.appendChild(secondChild);

    controlDiv.index = 1;
    map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(controlDiv);
    var marker;

    firstChild.addEventListener('click', function() {
        var imgX = '0';
        var iIcon = {
            url: 'img/youAreHere.png',
            scaledSize: new google.maps.Size(40, 40),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(16, 40)
        };
        if (marker) {
            marker.setMap(null);
        };
        marker = new google.maps.Marker({map: map, title: "You are here",
            animation: google.maps.Animation.DROP, icon: iIcon});

        $('#youLocationImg').css('background-position', '0px 0px');
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition( function(position) {
                var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                map.panTo(latlng);
                marker.setPosition(latlng);
                marker.setVisible(true);
                $('#youLocationImg').css('background-position', '-144px 0px');
            });
        }
    });
}
