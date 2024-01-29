package org.chris.myfirstapirest.api.payload;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
public class ApiResponse {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String url;

    public ApiResponse(String message,HttpStatus status, String url){
        this.message = message;
        this.status = status;
        this.url = url.replace("uri=","");
        this.timestamp = LocalDateTime.now();
    }

}
