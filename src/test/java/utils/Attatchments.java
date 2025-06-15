package utils;

import java.util.HashMap;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class Attatchments {

        public static String convertirAFormatoCSV(List<HashMap<String, Object>> data) {
            StringBuilder csvBuilder = new StringBuilder();
            if (data.isEmpty()) return "";
            HashMap<String, Object> firstRow = data.get(0);
            StringJoiner headerJoiner = new StringJoiner(",");
            for (String key : firstRow.keySet()) {
                headerJoiner.add(key);
            }
            csvBuilder.append(headerJoiner.toString()).append("\n");
            for (HashMap<String, Object> row : data) {
                StringJoiner rowJoiner = new StringJoiner(",");
                for (String key : firstRow.keySet()) {
                    Object value = row.getOrDefault(key, "");
                    rowJoiner.add(value != null ? value.toString() : "");
                }
                csvBuilder.append(rowJoiner.toString()).append("\n");
            }
            return csvBuilder.toString();
        }

        public static String convertirAHTML(List<HashMap<String, Object>> data) {
            if (data.isEmpty()) return "<p>No hay datos.</p>";

            String css = "";
            try {
                css = new String(
                        Attatchments.class.getClassLoader()
                                .getResourceAsStream("Styles/AttatchmentStyle.css")
                                .readAllBytes()
                );
            } catch (IOException | NullPointerException e) {
                css = "table { border: 1px solid black; }"; // fallback
            }

            StringBuilder html = new StringBuilder();
            html.append("<html><head>")
                    .append("<style>").append(css).append("</style>")
                    .append("</head><body><table>");

            html.append("<tr>");
            for (String key : data.get(0).keySet()) {
                html.append("<th>").append(key).append("</th>");
            }
            html.append("</tr>");

            for (HashMap<String, Object> row : data) {
                html.append("<tr>");
                for (String key : data.get(0).keySet()) {
                    Object value = row.getOrDefault(key, "");
                    html.append("<td>").append(value != null ? value.toString() : "").append("</td>");
                }
                html.append("</tr>");
            }

            html.append("</table></body></html>");
            return html.toString();
        }

    }
