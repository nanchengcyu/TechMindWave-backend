package com.nanchengyu.nanchengyubi.model.dto.Essay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: GenEssayMessage
 * Package: com.nanchengyu.nanchengyubi.model.dto.Essay
 * Description:
 *
 * @Author 南城余
 * @Create 2024/7/1 23:19
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenEssayMessage implements Serializable {
    private String essayName;
    private String essayType;
    private Long userId;
    private static final long serialVersionUID = 1L;
}
