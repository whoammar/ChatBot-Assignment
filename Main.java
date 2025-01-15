import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        String apiKey = "sk-projjhshshshshslcT3BlbkFJUm4f19sm_7z8-JHw69CP_hz5z6NZ9zRgxjU8D8VRN6ckT2TJjHTSu9tQn5QPeh9aOAs1w86AYA"; // Replace with your OpenAI API key.
        String message = "Hello, how are you?";
        String response = chatGPT(apiKey, message);
        System.out.println(response); // Prints the ChatGPT response.
    }

    public static String chatGPT(String apiKey, String message) {
        String url = "https://api.openai.com/v1/chat/completions";
        String model = "gpt-4o-mini"; // Use the latest model.

        try {
            // Create the HTTP POST request
            URL endpoint = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Build the JSON request body
            String requestBody = "{"
                    + "\"model\": \"" + model + "\","
                    + "\"messages\": ["
                    + "    {\"role\": \"user\", \"content\": \"" + message + "\"}"
                    + "]"
                    + "}";

            // Send the request
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(requestBody);
            writer.flush();
            writer.close();

            // Get the response
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    responseCode == 200 ? connection.getInputStream() : connection.getErrorStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Handle errors or return the extracted response
            if (responseCode != 200) {
                return "Error: " + response;
            }
            return extractContentFromResponse(response.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to connect to the API.";
        }
    }

    public static String extractContentFromResponse(String response) {
        try {
            int startIndex = response.indexOf("\"content\":\"") + 10; // Locate the content start.
            int endIndex = response.indexOf("\"", startIndex); // Locate the content end.
            return response.substring(startIndex, endIndex).replace("\\n", "\n").replace("\\\"", "\"");
        } catch (Exception e) {
            return "Error: Unable to parse the response.";
        }
    }
}
