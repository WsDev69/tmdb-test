package com.spintech.tmdb.dto.controller.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

    @Builder.Default
    private Long timestamp = System.currentTimeMillis();
    private String path;
    private String message;
    private String error;
    private Integer status;
}
