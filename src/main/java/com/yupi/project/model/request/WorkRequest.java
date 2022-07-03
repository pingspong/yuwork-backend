package com.yupi.project.model.request;

import com.yupi.project.common.PageRequest;
import com.yupi.project.model.entity.Work;
import lombok.Data;

import java.io.Serializable;

@Data
public class WorkRequest implements Serializable {

    private static final long serialVersionUID = 604678205224377007L;

    private Work work;

    private PageRequest pageRequest;

}
