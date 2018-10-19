# Start guide

### Initialization map
Create div with the right id
```html
<div id="map"></div>
```
In ```.js``` file write:
```javascript
ymaps.ready(init); // run if yandex maps api is ready

function init () {
    // creating map.    
    var map = new ymaps.Map('map', {
        // coordinates of the center of the map.ss
        // default order: latitude, longitude.
        // To not manually determine the coordinates of the center of the map,
        // use the Coordinate Definition tool (as:    
        // https://dimik.github.io/ymaps/examples/location-tool/ ).
        center: [39.31508397, 48.56852714],
        // Scaling level:
        // from 0 (all world) to 19.
        zoom: 13,
        // Optional:
        // control elements
        controls: ['zoomControl', 'geolocationControl', 'typeSelector'],
        // map behavior
        behaviors: ['drag']         
    },{
        // Optional
        // disabled default balloon and hint geo-object
        yandexMapDisablePoiInteractivity: true 
    }),
}
```

### Add geo-objects

* #### with use **ObjectManager** :
    Create **ObjectManager** using constructor, as:
    ```javascript
    objectManagerPoint = new ymaps.ObjectManager({
            // To make the tags begin to cluster, we set the option.
            // Only if all geo object are points!
            clusterize: true,
           // geoObjectOpenBalloonOnClick: false,
            clusterOpenBalloonOnClick: false
    });
    ```
    Add geo object in **ObjectManager** use **AJAX**:
    ```javascript
    // Load the GeoJSON file with a description of the objects.
    $.getJSON('data.json')
        .done(function (geoJson) {
            // Add the description of objects in the JSON format to the object manager.
            objectManager.add(geoJson);
            // Add objects to the map.
            map.geoObjects.add(objectManager);
    });
    ```
    If you want change default icon in point, then add in ```$.getJSON``` function:
    ```javascript
        objectManager.add(geoJson);
        objectManagerPoint.objects.each(function (object) {
            object.options = { 
                iconLayout: 'default#image', // type 
                iconImageHref: 'images/icon-map.png', // source path 
                iconImageSize: [30, 60], // size: width, height
                iconImageOffset: [-15, -60] // offset icon (recomended [-(width / 2); -height])
            };
        });
        map.geoObjects.add(objectManager);
    ```  

* #### with use adding to *map object* :
    1. Create object use constructor, as:
        ```javascript
        var myPlacemark = new ymaps.Placemark([55.661574, 37.573856], {
                hintContent: 'Some hint',
                balloonContent: 'Some text'
            }, {
                //  Optional
                // type layout.
                iconLayout: 'default#imageWithContent',
                // href to icon.
                iconImageHref: 'images/ball.png',
                // size icon.
                iconImageSize: [48, 48],
                // offset icon (recomended [-(width / 2); -height])
                iconImageOffset: [-24, -24]
            });
        ```
    2. Then add it to map:
        ```javascript
        map.geoObjects.add(myPlacemark)
        ```

* #### with use cluster:
    1. Create several objects use constructor, as in example above
    2. Create cluster use constructor, as:
        ```javascript
        var clusterer = new ymaps.Clusterer();
        ``` 
    3. Add geo object from step 1 to cluster:
        ```javascript
        clusterer.add(myPlacemark1).add(myPlacemark2)...
        ```
    4. Add cluster in map:
        ```javascript
        map.geoObjects.add(clusterer)
        ```    

#### Layout ```.json``` file with geo objecs:
```json
{
    "type": "FeatureCollection",
    "features": [
        {
            "type": "Feature", 
            "id": idObject,  
            "geometry": 
                {
                    "type": typeObject, 
                    "coordinates": [
                        latitude, longitude
                        ]
                }, 
                "properties": {
                    "balloonContent": balloobContent, 
                    "clusterCaption": clusterCaption, 
                    "hintContent": hintContent
                }
        },
        ...
    ]
}
```
* ```id``` - id geo object, must be unique
* ```type``` - type geo object, can be get value:
    * ```"Circle"``` 
        > ```"coordinates"``` is a circle center 
        > ```"radius"``` is a circle radius  in kilometers

    * ```"Point"``` 
        > ```"coordinates"``` is a point coordinates 
        
    * ```"LineString"``` 
        > ```"coordinates"``` is a dots array to build line 
        
    * ```"Polygon"``` 
        > ```"coordinates"``` is a dots array to build polygon 
      
    * ```"Rectangle"``` 
        > ```"coordinates"``` is a coordinates array to build rectangle 
         
* ```balloonHeader``` - is a header window shows at click on geo object
* ```balloonContent``` - is a content window shows at click on geo object
* ```hintContent``` - is a message shows at hover on geo object

Example ```.json``` file with geo objecs:
[link](#)