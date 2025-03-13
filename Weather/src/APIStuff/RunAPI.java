package APIStuff;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RunAPI {
    boolean running = true;
    public boolean second = false;
	HttpResponse<String> response;
    public String finalRes = "";

    public String LosAngeles = "https://api.open-meteo.com/v1/forecast?latitude=34.0522&longitude=-118.2437&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";
	public String NewYork = "https://api.open-meteo.com/v1/forecast?latitude=40.7143&longitude=-74.006&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";
	public String Zurich = "https://api.open-meteo.com/v1/forecast?latitude=47.3667&longitude=8.55&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";
	public String Paris = "https://api.open-meteo.com/v1/forecast?latitude=48.8534&longitude=2.3488&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";
	public String Miami = "https://api.open-meteo.com/v1/forecast?latitude=25.7743&longitude=-80.1937&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";
	public String Dallas = "https://api.open-meteo.com/v1/forecast?latitude=32.7831&longitude=-96.8067&current=temperature_2m&hourly=temperature_2m&temperature_unit=fahrenheit&wind_speed_unit=mph&precipitation_unit=inch";

    public RunAPI() {
    }

    public void setAPI(String apiString) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiString)).method("GET", HttpRequest.BodyPublishers.noBody()).build();
        response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			System.out.println("failed to call");
		} catch (InterruptedException e) {
			System.out.println("failed to call");
		}
    }

    public void call() {
		String to;
		String too;
			to = response.body().toString();
			too = to.substring(to.indexOf("\"current\""), to.indexOf("\"hourly_units\""));
        	finalRes = too.substring(too.indexOf("2m\"")+4, too.indexOf("2m\"")+8);
	}
}
