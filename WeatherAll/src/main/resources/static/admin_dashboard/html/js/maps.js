
// Wait for the DOM to be fully loaded
document.addEventListener('DOMContentLoaded', function () {
    // Initialize and display the map
    var map = new GMaps({
        div: '#gmaps-simple',
        lat: -12.043333,
        lng: -77.028333,
        zoom: 15
    });

    // Add a marker to the map
    map.addMarker({
        lat: -12.043333,
        lng: -77.028333,
        title: 'Marker Title',
        infoWindow: {
            content: '<p>Marker Content</p>'
        }
    });
});
    