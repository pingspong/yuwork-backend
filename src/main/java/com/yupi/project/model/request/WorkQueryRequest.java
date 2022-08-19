package com.yupi.project.model.request;

import com.yupi.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 604678205224377007L;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

}
