package com.yupi.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.PageRequest;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.entity.Work;
import com.yupi.project.model.request.WorkRequest;
import com.yupi.project.service.WorkService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 任务接口
 *
 * @author yupi
 */
@RestController
@RequestMapping("/work")
@CrossOrigin
public class WorkController {

    @Resource
    private WorkService workService;

    @PostMapping("/create")
    public BaseResponse<Long> createWork(@RequestBody Work work) {
        if (work == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        if (StringUtils.isAnyBlank(work.getName(), work.getDescription())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = workService.save(work);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return ResultUtils.success(work.getId());
    }


    @PostMapping("/list")
    public BaseResponse<Page<Work>> listWork(@RequestBody WorkRequest workRequest) {
        if (workRequest == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        Work work = workRequest.getWork();
        PageRequest pageRequest = workRequest.getPageRequest();
        QueryWrapper<Work> queryWrapper = new QueryWrapper<>(work);
        Page<Work> pageData = workService.page(new Page<>(pageRequest.getCurrent(), pageRequest.getSize()), queryWrapper);
        return ResultUtils.success(pageData);
    }
}
