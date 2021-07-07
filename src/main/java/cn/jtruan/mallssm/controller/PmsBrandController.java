package cn.jtruan.mallssm.controller;

import cn.jtruan.mallssm.common.api.CommonPage;
import cn.jtruan.mallssm.common.api.CommonResult;
import cn.jtruan.mallssm.mbg.model.PmsBrand;
import cn.jtruan.mallssm.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/brand")
public class PmsBrandController{
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrand.class);

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

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize) {
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }


}