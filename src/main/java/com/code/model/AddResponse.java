package com.code.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddResponse {
    private String msg;
    private int id;
}
