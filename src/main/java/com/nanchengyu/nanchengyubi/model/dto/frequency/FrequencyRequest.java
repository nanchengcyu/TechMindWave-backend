package com.nanchengyu.nanchengyubi.model.dto.frequency;

import lombok.Data;

import java.io.Serializable;

/**
 * @author nanchengyu
 * 使用次数
 */
@Data
public class FrequencyRequest implements Serializable {
    private int frequency;
}
