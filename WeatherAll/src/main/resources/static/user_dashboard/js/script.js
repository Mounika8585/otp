function updateSearchBar() {
    let dropdown = document.getElementById("searchDropdown");
    let searchBox = document.getElementById("searchBox");
   
    searchBox.style.display = "none";
    searchBox.firstChild.value = dropdown.value;
   }
   
   function handleKeyPress(event) {
    if (event.key === "Enter") {
       showWeatherData();
    }
   }
 
var searchBox = document.getElementById('searchBox');

var searchInputState = document.querySelector('.form-control1');
var searchInput = document.querySelector('.form-control');
var weatherContainer = document.getElementById('weatherContainer');

function updateSearchBar() {
    var selectedCity = document.getElementById('searchDropdown').value;
    searchInput.value = selectedCity;
    
    
}

function redirectToLogin() {
    window.location.href = "";
}

function redirectToSignUp() {
    window.location.href = "";
}

function fetchApiConfig() {
	
        return fetch('/api/config')
          .then(response => response.json())
          .then(config => {
    return {
        apiKey: config.apiKey,
        apiUrl: config.apiUrl
    };
});

}
 
function showWeatherData() {
     var selectedCity = searchInput.value || document.getElementById('searchDropdown').value;

    if (selectedCity) {
// Fetch API key and URL from the Spring Boot REST controller

fetchApiConfig()
    .then(config => {
        // Use the fetched API key and URL
        var apiKey = config.apiKey;
        var apiUrl = `${config.apiUrl}?q=${selectedCity}&appid=${apiKey}&units=metric`;

        // Fetch weather data from OpenWeatherMap API
        fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
				
				 if (data.cod === '404') {
				
				document.getElementById('weatherContainer').style.display = 'none'	 
                document.getElementById('weather-info').innerText = 'City not found. Please try again.';
            } 
            
            else {
				
				var simpleDescription = data.weather[0].main;
				var fullDescription = data.weather[0].description;
				var weatherInfo = 'Weather in ' + selectedCity + ' - ' + fullDescription;
                var temperature = (data.main.temp).toFixed(0);
                var humidity = data.main.humidity;
                var windSpeed = (data.wind.speed).toFixed(1);
                var cloudiness = data.clouds.all;
                
                // Update weather information in respective boxes
                
                document.getElementById('weather-info').innerText = weatherInfo;
                document.getElementById('temperature-value').textContent = temperature + '°C';
                document.getElementById('humidity-value').textContent = humidity + '%';
                document.getElementById('wind-value').textContent = windSpeed + ' m/s';
                document.getElementById('cloudiness-value').textContent = cloudiness + '%';

                // Display weather data only if a city is selected or entered
                weatherContainer.style.display = 'flex';
                weatherContainer.classList.add('pop-in');
                
                //recommendation card , on clicking search 
                weatherContainer1.style.display = 'flex';
                weatherContainer2.style.display = 'flex';
                weatherContainer3.style.display = 'flex';
                weatherContainer4.style.display = 'flex';
                
                fetch("/getfoods/"+encodeURIComponent(searchInputState.value)+"/"+encodeURIComponent(temperature))
            .then(response => response.json())
            .then(data => {
				
				document.getElementById('veg').innerText = data[0].foodName;
                document.getElementById('nonveg').textContent = data[1].foodName;
                document.getElementById('liquid').textContent =data[2].foodName;
				
				})
                
                 fetch("/clothing/"+encodeURIComponent(simpleDescription))
            .then(response => response.json())
            .then(data => {
				
				document.getElementById('tops').innerText = data[0].itemName;
                document.getElementById('bottom').textContent = data[1].itemName;
                document.getElementById('accessories').textContent =data[2].itemName;
                document.getElementById('footwear').textContent = data[3].itemName;
                document.getElementById('pullovers').textContent = data[4].itemName;
				
				})
				
				fetch("/outdoor/"+encodeURIComponent(simpleDescription))
            .then(response => response.json())
            .then(data => {
				
				document.getElementById('out_h.reco').innerText = data[0].activityname;
                document.getElementById('out_reco').textContent = data[1].activityname;
                document.getElementById('out_limit').textContent =data[2].activityname;
                document.getElementById('out_notreco').textContent = data[3].activityname;
				
				})
				
				fetch("/travel/"+encodeURIComponent(simpleDescription))
            .then(response => response.json())
            .then(data => {
				
				document.getElementById('travel_h.reco').innerText = data[0].travelname;
                document.getElementById('travel_reco').textContent = data[1].travelname;
                document.getElementById('travel_limit').textContent =data[2].travelname;
                document.getElementById('travel_notreco').textContent = data[3].travelname;
				
				})
                }
            })
            
    })
    
}
else {
// Optionally show an alert or handle the case where no city is selected or entered
alert('Please select or enter a city.');
}
}

function handleKeyPress(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        
        showWeatherData();
    }
}