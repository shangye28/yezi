package com.example.demo.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum RCode {
    /**
     * 成功
     */
    SUCCESS(true,200, "成功"),

    /**
     * 失败
     */
    FAIL(false,500, "失败");

    /**
     * @属性 statusFlag
     * @作用 判断是否成功
     */
    private Boolean statusFlag;

    /**
     * @属性 statusCode
     * @作用 返回结果状态码
     */
    private Integer statusCode;

    /**
     * @属性 statusMessage
     * @作用 提示信息
     */
    private String statusMessage;
}