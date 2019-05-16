package ru.java.courses.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpPost {

    public static class ResponseData { //класс куда кладутся данные, полученные в ответе

        public String url, body;
        public int status;
        Map<String, List<String>> headers;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder()
                    .append("URL= ").append(url).append('\n')
                    .append("STATUS= ").append(status).append('\n')
                    .append("BODY=\n").append(body).append('\n')
                    .append("HEADERS=\n");

            headers.entrySet().stream()
                    .filter(entry -> entry.getKey() != null)
                    .forEach(entry -> {
                        builder.append(entry.getKey()).append(": ");
                        List<String> headerValues = entry.getValue();
                        for (String headerValue : headerValues) {
                            builder.append(headerValue).append(", ");
                        }
                        builder.append("\n");
                    });

            return builder.toString();
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(HttpPost.class);

    public static void main(String[] args) {
        ResponseData responseData = doRequest("https://www.reksoft.ru", null, null, "test body");
        LOG.info(responseData.toString());
    }

    // метод, в котором выполняется HTTP запрос
    private static ResponseData doRequest(String url, Map<String, String> parameters, Map<String, String> headers, String data) {
        HttpURLConnection connection = null;
        byte[] postData = data.getBytes();
        try {
            URL requestUrl = new URL(url); //конструктор из всего url как строки
            connection = (HttpURLConnection) requestUrl.openConnection(); //подключаемся к серверу
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Java client");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            //прицепляем параметры и body к url
            if (parameters != null) {
                connection.setDoOutput(true);
                try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
                    out.writeBytes(getParamsString(parameters));
                    out.write(postData);
                    out.flush();
                }
            }

            if (headers != null) {
                for (Entry<String, String> header : parameters.entrySet()) {
                    connection.setRequestProperty(header.getKey(), header.getValue()); // метод добавляет заголовки в запрос
                }
            }

            //технические параметры запроса
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode(); //выполнение запроса

            ResponseData response = new ResponseData();
            response.status = status;
            response.url = url;
            response.headers = connection.getHeaderFields();

            try (
                    InputStreamReader streamReader = status >= 300 ?
                            new InputStreamReader(connection.getErrorStream()) : //метод для получения данных об ошибке
                            new InputStreamReader(connection.getInputStream());
                    BufferedReader responseReader = new BufferedReader(streamReader);
            ) {
                String inputLine;
                StringBuilder body = new StringBuilder(); //собираем строки по одной
                while ((inputLine = responseReader.readLine()) != null) {
                    body.append(inputLine);
                }
                response.body = body.toString();
            }
            return response;
        } catch (Exception e) {
            LOG.error("Error while HTTP request. URL: " + url, e);
        } finally {
            if (connection != null) {
                connection.disconnect(); // закрываем connection
            }
        }
        return null;
    }

    private static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8")); //класс URLEncoder кодирует передаваемые параметры
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.isEmpty() ? resultString : resultString.substring(0, resultString.length() - 1); //удаление ненужного & в конце
    }

}
