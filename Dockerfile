# Use an official lightweight Python image
FROM python:3.12-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Python script into the container at /app
COPY API_CALL.py .

# Install the necessary 'requests' library
RUN pip install requests

# Specify the command to run the application when the container starts
CMD ["python", "weather_api_client.py"]