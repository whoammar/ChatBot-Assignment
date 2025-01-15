# ReadMe File for Chatbot Assignment

## Assignment Details
- **Name**: Muhammad Ammar
- **Roll Number**: F21BSEEN1E2074
- **Subject**: Intelligent Software Engineering 
- **University**: Islamia University of Bahawalpur

## Project Title
**Chatbot Using OpenAI API**

## Project Description
This Java program demonstrates the implementation of a chatbot using the OpenAI API. The chatbot takes user input and provides responses generated by the OpenAI GPT model. It uses HTTP requests to communicate with the API endpoint and processes JSON data to extract responses.

## Features
- Sends user messages to the OpenAI API.
- Receives and displays responses from the GPT model.
- Implements error handling for API connection and response parsing.

## Setup Instructions
### Prerequisites
1. Java Development Kit (JDK) installed.
2. An API key from OpenAI. Replace `apiKey` in the code with your actual API key.
3. Internet connection.

### Steps to Run the Code
1. Open your Java IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
2. Copy and paste the provided code into a Java class file named `Main.java`.
3. Replace the placeholder `apiKey` value with your valid OpenAI API key.
4. Compile and run the `Main.java` file.
5. View the chatbot response printed in the console.

## Code Overview
### Main Components
1. **`chatGPT` Method**:
   - Handles the communication with the OpenAI API.
   - Constructs an HTTP POST request with the necessary headers and body.
   - Parses the response and returns the chatbot's reply.

2. **`extractContentFromResponse` Method**:
   - Extracts the actual content of the response from the JSON data.
   - Handles parsing errors gracefully.

3. **Main Method**:
   - Initializes the program by setting up the API key and user message.
   - Calls the `chatGPT` method and displays the response.

### Key Libraries Used
- `java.io.BufferedReader`
- `java.io.InputStreamReader`
- `java.io.OutputStreamWriter`
- `java.net.HttpURLConnection`
- `java.net.URL`

## Example Execution
### Input
```
Hello, how are you?
```
### Output
```
I am just a program, but I’m here to help. How can I assist you today?
```

## Notes
- Ensure your OpenAI API key has sufficient usage limits to make requests.
- The program is set to use the `gpt-4o-mini` model by default. Update this if necessary based on available models.
- Handle your API key securely and avoid sharing it publicly.

## Limitations
- The chatbot requires a working internet connection.
- API key misuse or exceeding usage limits may lead to errors.

## License
This project is for educational purposes only. All rights to the OpenAI API and the GPT model are reserved by OpenAI.

## Contact Information
For any queries or issues, please contact:
- **Name**:Muhammad Ammar
- **University**: Islamia University of Bahawalpur
- **Phone Number**: 0304-8861616
