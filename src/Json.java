import org.json.JSONException;
import org.json.JSONObject;

public class Json {

    public static void main(String[] args) {


        try {

            String result = "{\"coord\":{\"lon\":2.3488,\"lat\":48.8534},\"weather\":[{\"id\":803,\"main\":\"Haze\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\n" +
                    "\"base\":\"stations\",\"main\":{\"temp\":286.48,\"feels_like\":285.3,\"temp_min\":285.54,\"temp_max\":288.07,\"pressure\":1017,\"humidity\":55},\n" +
                    "\"visibility\":10000,\"wind\":{\"speed\":4.63,\"deg\":20},\"clouds\":{\"all\":75},\"dt\":1653816109,\n" +
                    "\"sys\":{\"type\":2,\"id\":2041230,\"country\":\"FR\",\"sunrise\":1653796452,\"sunset\":1653853328},\"timezone\":7200,\"id\":2988507,\"name\":\"Paris\",\"cod\":200} ";
            JSONObject jsonObject = new JSONObject(result);
            String weather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            switch (weather) {
                case "Clouds":
                    weather = "Облачно";
                    break;
                case "Clear":
                    weather = "Ясно";
                    break;
                case "Rain":
                    weather = "Дождь";
                    break;
                case "Snow":
                    weather = "Снег";
                    break;
                case "Fog":
                    weather = "Туман";
                    break;


            }


            String temp = "Температура: " + jsonObject.getJSONObject("main").getDouble("temp") + "°C" + "\n";
            String wind = "Ветер " + jsonObject.getJSONObject("wind").getDouble("speed") + "м/с" + "\n";
            String humidity = "Влажность " + jsonObject.getJSONObject("main").getDouble("humidity") + "%";

            String tw = weather + "\n" + temp + wind + humidity;
            System.out.println(tw);
            // result_info.setText(tw);

        } catch (
                JSONException e) {
            e.printStackTrace();
        }
    }
}