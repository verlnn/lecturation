package io.group.studypro.project.core.config;

import com.google.gson.Gson;
import io.group.studypro.project.domain.user.dto.UserDTO;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
public class TransferJson {

    public UserDTO processedFromJson (HttpServletRequest request) throws IOException {
        String data = jsonProcessedToStr(request);
        UserDTO save = new Gson().fromJson(data, UserDTO.class);
        return save;
    }

    public static String jsonProcessedToStr(HttpServletRequest request) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }

        return builder.toString();
    }
}
