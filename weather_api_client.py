import requests

def get_weather(city):
    # API key provided by OpenWeatherMap
    api_key = "e89031034892d94924fbe6081a66e37a"
    
    # Construct the API request URL
    url = f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={api_key}&units=metric"
    
    # Perform the GET request to the OpenWeatherMap API
    response = requests.get(url)
    
    # Log the HTTP response status code to the console for debugging purposes
    print(f"Response status: {response.status_code}")
    
    # Check if the request was successful (HTTP status 200)
    if response.status_code == 200:
        # Parse the JSON response
        data = response.json()
        
        # Extract specific weather information from the JSON object
        temp = data['main']['temp']
        desc = data['weather'][0]['description']
        
        # Output the weather details to the user
        print(f"Weather in {city}: {temp}°C, {desc}")
    else:
        # Handle errors by printing the response text from the server
        print(f"Error in API request. Details: {response.text}")

# Example usage of the function
get_weather("Milano")