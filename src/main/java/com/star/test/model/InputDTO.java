package com.star.test.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class InputDTO {

    @NotBlank(message = "name不能为空")
    private String name;
    @NotNull(message = "id不能为空")
    private long id;
    @NotBlank(message = "pwd不能为空")
    private String pwd;
}
