package com.yupi.project.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

@Data
public class WorkDeleteRequest implements Serializable {

    private static final long serialVersionUID = 604678205224377007L;

    /**
     * id
     */
    private int id;

}
