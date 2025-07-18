
package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixReportPaths {
    public static void main(String[] args) throws Exception {
        String basePath = "D:/Github repositories folder for Eclipse/AFP/MMT_V1/Reports/SparkReport/";
        File dir = new File(basePath);
        Pattern pattern = Pattern.compile("src=\"\\.\\./(Screenshotsembedded\\d+\\.png)\"");
        for (File file : dir.listFiles((d, name) -> name.matches("Sparkreport_\\d{8}_\\d{6}\\.html"))) {
            String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            Matcher matcher = pattern.matcher(content);
            StringBuffer sb = new StringBuffer();
            String timestamp = file.getName().replace("Sparkreport_", "").replace(".html", "");
            while (matcher.find()) {
                String placeholder = matcher.group(1);
                // Construct the actual screenshot filename based on the pattern from output.log
                String scenarioName = "User_login_with_valid_email_id_&_valid_password"; // Adjust based on your scenario
                String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timestamp.replaceAll("_", "") + ".png";
                String newPath = "src=\"" + basePath + "Screenshots/" + timestamp + "/" + screenshotName + "\"";
                matcher.appendReplacement(sb, newPath);
            }
            matcher.appendTail(sb);
            Files.write(Paths.get(file.getAbsolutePath()), sb.toString().getBytes());
        }
    }
}