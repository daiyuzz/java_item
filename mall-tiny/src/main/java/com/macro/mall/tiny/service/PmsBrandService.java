package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {
    /**
     * 列出所有品牌
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     * @param pmsBrand
     * @return
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 修改品牌
     * @param id
     * @param pmsBrandDto
     * @return
     */
    int updateBrand(Long id, PmsBrand pmsBrandDto);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 分页展示品牌
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    /**
     * 获取品牌详情
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);
}
