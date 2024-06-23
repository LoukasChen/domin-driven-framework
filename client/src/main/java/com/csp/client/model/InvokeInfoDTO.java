package com.csp.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvokeInfoDTO {

    private String appName;

}
