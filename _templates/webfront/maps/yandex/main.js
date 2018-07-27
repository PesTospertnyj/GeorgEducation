// call function init when the yandex map is ready 
ymaps.ready(init);

// array geo-objects
function init () {
    // creating map.    
    var map = new ymaps.Map('map', {
        // coordinates of the center of the map.ss
        // default order: latitude, longitude.
        // To not manually determine the coordinates of the center of the map,
        // use the Coordinate Definition tool (like this: https://dimik.github.io/ymaps/examples/location-tool/ ).
        center: [39.31508397, 48.56852714],
        // Scaling level:
        // from 0 (all world) to 19.
        zoom: 13,
        // optional:
        // control elements
        controls: ['zoomControl', 'geolocationControl', 'typeSelector'],
        // map behavior
        behaviors: ['drag']         
    },{
        // disabled default balloon and hint geo-object
        yandexMapDisablePoiInteractivity: true 
    }),
    // create simple object manager for get geo object
    objectManager = new ymaps.ObjectManager();

    // Load the GeoJSON file with a description of the objects.
    $.getJSON('data.json')
        .done(function (geoJson) {
            // Add the description of objects in the JSON format to the object manager.
            objectManager.add(geoJson);
            // Add objects to the map.
            map.geoObjects.add(objectManager);
    });

    objectManagerPoint = new ymaps.ObjectManager({
            // To make the tags begin to cluster, we set the option.
            // Only if all geo object are points!
            clusterize: true,
           // geoObjectOpenBalloonOnClick: false,
            clusterOpenBalloonOnClick: false
    });

    $.getJSON('data_point.json')
        .done(function (geoJson) {
            objectManagerPoint.add(geoJson);
            objectManagerPoint.objects.each(function (object) {
                object.options = { 
                    iconLayout: 'default#image', // type 
                    iconImageHref: 'images/icon-map.png', // source path 
                    iconImageSize: [30, 60], // size: width, height
                    iconImageOffset: [-15, -60] // offset icon (recomended [-(width / 2); -height])
                };
            });
            map.geoObjects.add(objectManagerPoint);
    });



    objectManagerPoint.objects.events.add(['mouseenter', 'mouseleave'], function (e) {
        var object = objectManagerPoint.objects.getById(e.get('objectId'));
        if (e.get('type') == "mouseleave") {
            objectManagerPoint.objects.setObjectOptions(object.id, {
                iconImageHref:'images/icon-map.png'
            });
        } else {
            objectManagerPoint.objects.setObjectOptions(object.id, {
                iconImageHref:'images/icon-map-white.png'
            });
        }
    });


    objectManagerPoint.clusters.events.add(['add', 'mouseenter', 'mouseleave'], function (e) {
        var cluster = objectManagerPoint.clusters.getById(e.get('objectId'));
        if (e.get('type') == "add" || e.get('type') == "mouseleave") {
            objectManagerPoint.clusters.setClusterOptions(cluster.id, {
                iconLayout: "default#image",
                iconImageHref:'images/icon-cluster-big.png', 
                iconImageSize: [50, 80], 
                iconImageOffset: [-25, -80]
            });
        } else {
            objectManagerPoint.clusters.setClusterOptions(cluster.id, {
                iconImageHref:'images/icon-cluster-big-white.png'
            });
        }
    });

}