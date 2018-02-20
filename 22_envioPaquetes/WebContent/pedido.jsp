<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>

<!-- Estilos de calendario cogidos de la pagina https://desarrolloweb.com/articulos/implementar-plugin-calendario-jquery.html -->
<link href="calendario_dw/calendario_dw-estilos.css" type="text/css" rel="STYLESHEET">
<style type="text/css">
   body{
      font-family: tahoma, verdana, sans-serif;
   }
    </style>
 <script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>

<script type="text/javascript">
$(document).ready(function(){
   $(".campofecha").calendarioDW();
}) 
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elección de pedido</title>
</head>
<body>
<h2>Rellene los campos para realizar un pedido</h2>
</br>
<form action="Alta" method="post">
Origen: <input type="text" name="origen" id="origen"></br></br>
Destino: <input type="text" name="destino" id="destino"></br></br>
Tamaño del paquete: <select name="tamano">
<option value="null"></option>
<option value="grande">Grande</option>
<option value="mediano">Mediano</option>
<option value="pequeno">Pequeño</option>

</select></br></br>

Fecha de llegada: <input type="text" name="fecha" class="campofecha" size="12"></br></br>


  

<input type="submit" value="Alta">

<div id="map"></div>

    <script>
   
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          mapTypeControl: false,
          center: {lat: 33.8688, lng: 51.2195},
          zoom: 13
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
</body>
</html>