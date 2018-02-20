<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Selector de rutas</title>
</head>
<body>
	<h2>Selector de rutas</h2>
	<form action="LlamadaTabla" method="post">
		<p>Elija el origen y destino de la ruta del pedido que quiere
			llevar</p>
		</br> </br> Origen: <input name="origen" id="origen"  type="text" placeholder=""></br>
		</br> Destino:  <input name="destino" id="destino" type="text" placeholder=""></br> </br> 
        <input type="submit" value="Buscar">
  
    <div id="map"></div>

    <script>
   
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          mapTypeControl: false,
          center: {lat: 40.8688, lng: -1.2195},
          zoom: 10
        });

        new AutocompleteDirectionsHandler(map);
      }

       /**
        * @constructor
       */
      function AutocompleteDirectionsHandler(map) {
        this.map = map;
        this.originPlaceId = null;
        this.destinationPlaceId = null;
        
        var originInput = document.getElementById('origen');
        var destinationInput = document.getElementById('destino');
        this.directionsService = new google.maps.DirectionsService;
        this.directionsDisplay = new google.maps.DirectionsRenderer;
        this.directionsDisplay.setMap(map);

        var originAutocomplete = new google.maps.places.Autocomplete(
            originInput, {placeIdOnly: true});
        var destinationAutocomplete = new google.maps.places.Autocomplete(
            destinationInput, {placeIdOnly: true});

        
        this.setupPlaceChangedListener(originAutocomplete, 'ORIG');
        this.setupPlaceChangedListener(destinationAutocomplete, 'DEST');

        this.map.controls[google.maps.ControlPosition.TOP_LEFT].push(originInput);
        this.map.controls[google.maps.ControlPosition.TOP_LEFT].push(destinationInput);
        this.map.controls[google.maps.ControlPosition.TOP_LEFT].push(modeSelector);
      }

      // Sets a listener on a radio button to change the filter type on Places
      // Autocomplete.
      
      AutocompleteDirectionsHandler.prototype.setupPlaceChangedListener = function(autocomplete, mode) {
        var me = this;
        autocomplete.bindTo('bounds', this.map);
        autocomplete.addListener('place_changed', function() {
          var place = autocomplete.getPlace();
          if (!place.place_id) {
            window.alert("Por favor, seleccione una opción de la lista desplegable.");
            return;
          }
         
        });

      };

      AutocompleteDirectionsHandler.prototype.route = function() {
        if (!this.originPlaceId || !this.destinationPlaceId) {
          return;
        }
      

        this.directionsService.route({
          origin: {'placeId': this.originPlaceId},
          destination: {'placeId': this.destinationPlaceId}
        
        });
      };

    </script> <!-- Recordad que lo que se escribe aquí abajo va con la KEY del proyecto propio de google -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0sSBpWehnnsYjdr8F4gBZsOOROk9gxYo&libraries=places&callback=initMap"
        async defer></script>
		
		</form>
<body>
</html>


