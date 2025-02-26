import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;

public class IPLDataCensorship {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        CsvMapper csvMapper = new CsvMapper();

        JsonNode jsonData = jsonMapper.readTree(new File("input.json"));
        JsonNode csvData = csvMapper.readerFor(JsonNode.class)
                .with(CsvSchema.emptySchema().withHeader())
                .readTree(Paths.get("input.csv").toFile());

        JsonNode censoredJson = applyCensorship(jsonData);
        JsonNode censoredCsv = applyCensorship(csvData);

        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File("censored_output.json"), censoredJson);
        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("match_id")
                .addColumn("team1")
                .addColumn("team2")
                .addColumn("score_team1")
                .addColumn("score_team2")
                .addColumn("winner")
                .addColumn("player_of_match")
                .build();
        csvMapper.writer(schema).writeValue(new File("censored_output.csv"), censoredCsv);

        System.out.println("Censorship applied and files generated.");
    }

    private static JsonNode applyCensorship(JsonNode data) {
        data.forEach(match -> {
            match.put("team1", censorTeamName(match.get("team1").asText()));
            match.put("team2", censorTeamName(match.get("team2").asText()));
            match.put("winner", censorTeamName(match.get("winner").asText()));
            match.put("player_of_match", "REDACTED");
        });
        return data;
    }

    private static String censorTeamName(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return teamName;
    }
}
