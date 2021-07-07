package cn.jtruan.mallssm.controller;

import cn.jtruan.mallssm.common.api.CommonPage;
import cn.jtruan.mallssm.common.api.CommonResult;
import cn.jtruan.mallssm.mbg.model.PmsBrand;
import cn.jtruan.mallssm.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController{
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrand.class);

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsBrand> createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult<PmsBrand> commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand:{}:", pmsBrand);
        }
        else{
            commonResult = CommonResult.failed();
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int count = brandService.deleteBrand(id);
        if (count == 1){
            commonResult = CommonResult.success(id);
            LOGGER.debug("deleteBrand:{}:", id);
        }
        else{
            commonResult = CommonResult.failed();
            LOGGER.debug("deleteBrand failed:{}", id);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id的品牌")
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed();
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("获取所有的品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }


    @ApiOperation("获取分页品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "3") @ApiParam("每页的数量") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }


}