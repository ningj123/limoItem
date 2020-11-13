//package com.woniuxy.controller;
//
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.woniu.bh.beautysalon.model.dto.*;
//import com.woniu.bh.beautysalon.model.params.*;
//import com.woniu.bh.beautysalon.web.config.ValidationUtil;
//import com.woniu.bh.beautysalon.web.service.IBeautysalonService;
//import com.woniu.bh.common.core.domain.beautysalon.Beautysalon;
//import com.woniu.bh.common.core.dto.ResultDto;
//import com.woniu.bh.common.core.exception.ProjectException;
//import com.woniu.bh.common.core.exception.ProjectExceptionResult;
//import com.woniu.bh.common.core.util.Constants;
//import com.woniu.bh.common.core.util.JwtUtil;
//import com.woniu.bh.common.core.util.MessageHandler;
//import com.woniu.bh.common.core.util.UploadHandler;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Daniel
// * @version 1.0.0
// * @ClassName BeautysalonController
// * @createTime 2020年10月13日 14:26:00
// */
//@RestController
//@RequestMapping("/user")
//@Slf4j
//@Api(value = "美容馆接口", tags = "美容馆管理")
//public class BeautysalonController {
//
//    @Autowired
//    //阿里云短信模板
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private IBeautysalonService beautysalonService;
//
//    /**
//     * @description: 密码登录
//     * @param: loginByPassParam
//     * @return: ResultDto
//     */
//    @PostMapping("/loginByPass")
//    @ApiOperation("密码登录")
//    public ResultDto bsLoginByPass(@RequestBody @Valid LoginByPassParam loginByPassParam, BindingResult result) {
//        log.info("接收参数为{}", loginByPassParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.PARAMETER_ILLEGAL.getCode())
//                    .message(ProjectExceptionResult.PARAMETER_ILLEGAL.getMessage() + extract).build();
//        }
//
//        int beautysalonId = beautysalonService.login(loginByPassParam);
//
//        try {
//            if (beautysalonId < 0) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_OR_PWD_ERROR.getCode())
//                        .message(ProjectExceptionResult.USER_OR_PWD_ERROR.getMessage()).build();
//            }
//            //创建token 返回token
//            Map<String, Object> map = new HashMap<>();
//            map.put("phone", loginByPassParam.getPhone());
//            map.put("beautysalonId", beautysalonId);
//            String token = JwtUtil.createToken(map, 7 * 24 * 60 * 60);
//
//            return ResultDto.builder().success(true).code(1).message("登陆成功").object(token).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().code(ProjectExceptionResult.MESSAGE_SEND_FAILED.getCode())
//                    .message(ProjectExceptionResult.MESSAGE_SEND_FAILED.getMessage()).object(null).build();
//        }
//    }
//
//    /**
//     * @description: 获取验证码
//     * @param: phone 电话号码
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;

//@PostMapping("/getCode")
//    @ApiOperation("获取验证码")
//    public ResultDto bsGetCode(String phone) {
//        System.out.println("--------------进入controller");
//        log.info("传入参数:{}", phone);
//        MessageHandler messageHandler = new MessageHandler();
//        //生成动态验证码并存入redis中
//        String code = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("code", code);
//        //发送短信    "SMS_204297678"是已经自定义的项目短信模板，写死
//        boolean isSend = messageHandler.send(phone, "SMS_204297678", param);
//        if (isSend) {
//            //存入redis（可以用redis暂存，校验
//            redisTemplate.opsForValue().set(phone, code, 60, TimeUnit.SECONDS);
//            return ResultDto.builder().success(true).code(1).message("执行成功").object(code).build();
//        } else {
//            return ResultDto.builder().code(ProjectExceptionResult.MESSAGE_SEND_FAILED.getCode())
//                    .message(ProjectExceptionResult.MESSAGE_SEND_FAILED.getMessage()).object(null).build();
//        }
//    }
//
//    /**
//     * @description: 短信登录
//     * @param: loginByMsgParam
//     * @return: ResultDto
//     */
//    @PostMapping("/loginByMsg")
//    @ApiOperation("短信登录")
//    public ResultDto bsLoginByMsg(@RequestBody @Valid LoginByMsgParam loginByMsgParam, BindingResult result) {
//        log.info("传入参数:{}", loginByMsgParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.PARAMETER_ILLEGAL.getCode())
//                    .message(ProjectExceptionResult.PARAMETER_ILLEGAL.getMessage() + extract).build();
//        }
//        try {
//            int beautysalonId = beautysalonService.beforeRegister(loginByMsgParam.getPhone());
//            if (beautysalonId > 0) {
//                String code = redisTemplate.opsForValue().get(loginByMsgParam.getPhone());
//                assert code != null;
//                if (code.equals(loginByMsgParam.getCode())) {
//                    //创建token 返回token
//                    Map<String, Object> map = new HashMap<>();
//                    map.put("phone", loginByMsgParam.getPhone());
//                    map.put("beautysalonId", beautysalonId);
//                    String token = JwtUtil.createToken(map, 7 * 24 * 60 * 60);
//                    return ResultDto.builder().success(true).code(1).message("登陆成功").object(token).build();
//                }
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getCode())
//                        .message(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getMessage()).build();
//
//            }
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_NOT_EXSIT.getCode())
//                    .message(ProjectExceptionResult.USER_NOT_EXSIT.getMessage()).build();
//
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 注册
//     * @param: registerParam
//     * @param: result
//     * @return: ResultDto
//     */
//    @PostMapping("/register")
//    @ApiOperation("注册")
//    public ResultDto bsRegister(@RequestBody @Valid RegisterParam registerParam, BindingResult result) {
//        log.info("传入参数:{}", registerParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.PARAMETER_ILLEGAL.getCode())
//                    .message(ProjectExceptionResult.PARAMETER_ILLEGAL.getMessage() + extract).build();
//        }
//        try {
//            int results = beautysalonService.beforeRegister(registerParam.getPhone());
//            if (results < 0) {
//                String code = redisTemplate.opsForValue().get(registerParam.getPhone());
//                assert code != null;
//                if (code.equals(registerParam.getCode())) {
//                    if (registerParam.getPass().equals(registerParam.getConfirmPass())) {
//                        beautysalonService.register(registerParam.getPhone(), registerParam.getPass());
//                        return ResultDto.builder().success(true).code(1).message("注册成功").build();
//                    }
//                    return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_REPEAT_PASSWORD_NOT_SAME.getCode())
//                            .message(ProjectExceptionResult.USER_REPEAT_PASSWORD_NOT_SAME.getMessage()).build();
//                }
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getCode())
//                        .message(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getMessage()).build();
//            }
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_IS_EXSITS.getCode())
//                    .message(ProjectExceptionResult.USER_IS_EXSITS.getMessage()).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 找回密码
//     * @param: registerParam
//     * @param: result
//     * @return: ResultDto
//     */
//    @PostMapping("/restPass")
//    @ApiOperation("找回密码")
//    public ResultDto bsRestPass(@RequestBody @Valid RegisterParam registerParam, BindingResult result) {
//        log.info("传入参数:{}", registerParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.PARAMETER_ILLEGAL.getCode())
//                    .message(ProjectExceptionResult.PARAMETER_ILLEGAL.getMessage() + extract).build();
//        }
//        try {
//            //用户是否存在
//            int beautysalonId = beautysalonService.beforeRegister(registerParam.getPhone());
//            if (beautysalonId > 0) {
//                String code = redisTemplate.opsForValue().get(registerParam.getPhone());
//                //验证码是否正确
//                assert code != null;
//                if (code.equals(registerParam.getCode())) {
//                    //两次密码是否相同
//                    if (registerParam.getPass().equals(registerParam.getConfirmPass())) {
//                        beautysalonService.restPass(beautysalonId, registerParam.getPass());
//                        return ResultDto.builder().success(true).code(1).message("重置成功").build();
//                    }
//                    return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_REPEAT_PASSWORD_NOT_SAME.getCode())
//                            .message(ProjectExceptionResult.USER_REPEAT_PASSWORD_NOT_SAME.getMessage()).build();
//                }
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getCode())
//                        .message(ProjectExceptionResult.MESSAGE_VERIFY_FAILED.getMessage()).build();
//            }
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.USER_NOT_EXSIT.getCode())
//                    .message(ProjectExceptionResult.USER_NOT_EXSIT.getMessage()).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//
//    }
//
//    /**
//     * @description: 查询美容馆信息
//     * @param:
//     * @return: ResultDto
//     */
//    @GetMapping("/getInfo")
//    @ApiOperation("查询美容馆信息")
//    public ResultDto bsGetInfo(HttpServletRequest request) {
//        try {
//            //解析token获取id
//            String token = request.getHeader("X-Token");
//            Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//
//            BeautysalonDto info = beautysalonService.getInfo(beautysalonId);
//            if (info == null) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.ACCESS_NOT_PERMISSION.getCode())
//                        .message(ProjectExceptionResult.ACCESS_NOT_PERMISSION.getMessage()).build();
//            }
//            return ResultDto.builder().success(true).code(1).message("查询成功").object(info).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//
//    }
//
//    /**
//     * @description: 美容馆申请
//     * @param: beautysalonParam
//     * @return: ResultDto
//     */
//    @PostMapping("/application")
//    @ApiOperation("美容馆提交申请")
//    public ResultDto bsApplication(@RequestBody @Valid BeautysalonParam beautysalonParam, BindingResult result, HttpServletRequest request) {
//        log.info("接收参数为{}", beautysalonParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(10001).message("参数异常" + extract).build();
//        }
//        try {
//            //解析token获取id
//            String token = request.getHeader("X-Token");
//            Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//
//            Beautysalon beautysalon = new Beautysalon();
//            BeanUtils.copyProperties(beautysalonParam, beautysalon);
//            beautysalon.setBeautysalonId(beautysalonId);
//            beautysalon.setBeautysalonStatus("1");
//            beautysalon.setBeautysalonUpdateTime(System.currentTimeMillis());
//            beautysalon.setBeautysalonApplicationTime(System.currentTimeMillis());
//            beautysalon.setBeautysalonDeleteStatus(0);
//            int results = beautysalonService.application(beautysalon);
//            if (results != 0) {
//                return ResultDto.builder().success(true).code(1).message("申请成功").object(results).build();
//            }
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 上传美容馆图片
//     * @param: file
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PostMapping("/uploadPics")
//    @ApiOperation("美容馆上传图片")
//    public ResultDto bsUploadPic(@RequestParam("file1") MultipartFile[] file, HttpServletRequest request) {
//
//        //解析token获取id
//        String token = request.getHeader("X-Token");
//        Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//        //上传文件
//        UploadHandler uploadHandler = new UploadHandler();
//        try {
//            for (MultipartFile multipartFile : file) {
//                String fileUrl = uploadHandler.upload(Constants.BEAUTYSALON_HOUSE_PIC, multipartFile, beautysalonId + "");
//                beautysalonService.uploadPics(fileUrl, beautysalonId);
//            }
//            return ResultDto.builder().success(true).code(1).message("上传成功").build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 上传美容馆资质图片
//     * @param: file
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PostMapping("/uploadQualificationsPics")
//    @ApiOperation("上传美容馆执照")
//    public ResultDto bsUploadQualificationsPic(@RequestParam("file2") MultipartFile[] file, HttpServletRequest request) {
//        //解析token获取id
//        String token = request.getHeader("X-Token");
//        Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//        //上传文件
//        UploadHandler uploadHandler = new UploadHandler();
//        try {
//            for (MultipartFile multipartFile : file) {
//                String fileUrl = uploadHandler.upload(Constants.BEAUTYSALON_LICENSE, multipartFile, beautysalonId + "");
//                System.out.println(fileUrl);
//                beautysalonService.qualificationsPics(fileUrl, beautysalonId);
//            }
//            return ResultDto.builder().success(true).code(1).message("上传成功").build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 查询我的消息
//     * @param:
//     * @return: ResultDto
//     */
//    @GetMapping("/getMessage")
//    @ApiOperation("查询我的消息")
//    public ResultDto bsGetMessage(HttpServletRequest request) {
//        try {
//            //解析token获取id
//            String token = request.getHeader("X-Token");
//            Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//            List<MessageDto> message = beautysalonService.getMessage(beautysalonId);
//            return ResultDto.builder().success(true).code(1).message("查询成功").object(message).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//
//    }
//
//    /**
//     * @description: 分页条件查询所有消费用户
//     * @param: customerParam
//     * @return: ResultDto
//     */
//
//    @GetMapping("/getAllCustomer")
//    @ApiOperation("分页条件查询所有消费用户")
//    public ResultDto bsGetAllCustomer(CustomerParam customerParam, HttpServletRequest request) {
//        log.info("传入参数{}", customerParam);
//        try {
//            //解析token获取id
////            String token = request.getHeader("X-Token");
////            Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//            IPage<CustomerDto> customerDtoiPage = beautysalonService.pageQuery(customerParam.getPageIndex(), customerParam.getPageSize(), customerParam.getSex(), 1, customerParam.getBeforeAge(), customerParam.getAfterAge());
//            return ResultDto.builder().success(true).message("查询成功").code(1).object(customerDtoiPage.getRecords()).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 广告申请
//     * @param: advertisementParam
//     * @param: request
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PostMapping("/advertisement")
//    @ApiOperation("提交广告申请")
//    public ResultDto addNewAdvertisement(@Valid AdvertisementParam advertisementParam, HttpServletRequest request, BindingResult result) {
//        log.info("传入参数:{}", advertisementParam);
//        String extract = ValidationUtil.extract(result);
//        if (extract != null) {
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.PARAMETER_ILLEGAL.getCode())
//                    .message(ProjectExceptionResult.PARAMETER_ILLEGAL.getMessage()).build();
//        }
//        long dTime = advertisementParam.getAdvertisementRentEndTime().getTime() - advertisementParam.getAdvertisementRentStartTime().getTime();
//        if ((advertisementParam.getAdvertisementDuration() * 1000 * 24 * 60 * 60) != dTime) {
//            return ResultDto.builder().success(false).code(12001).message("时间周期不一致").build();
//        }
//        try {
//            //解析token获取id
//            String token = request.getHeader("X-Token");
//            Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//            beautysalonService.addNewAd(advertisementParam, beautysalonId);
//            return ResultDto.builder().success(true).code(1)
//                    .message("申请成功").build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 广告图片上传
//     * @param: file
//     * @param: request
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PostMapping("/advertisementPics")
//    @ApiOperation("广告图片上传")
//    public ResultDto advertisementPics(@RequestParam("file3") MultipartFile[] file, HttpServletRequest request) {
//        //解析token获取id
//        String token = request.getHeader("X-Token");
//        Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//        //上传文件
//        UploadHandler uploadHandler = new UploadHandler();
//        try {
//            for (int i = 0; i < file.length; i++) {
//                String fileUrl = uploadHandler.upload(Constants.BEAUTYSALON_ADVERTISEMENT, file[i], beautysalonId + "");
//                Boolean advertisementPic = stringRedisTemplate.opsForHash().hasKey("advertisementPic", "pic" + i);
//                if (advertisementPic) {
//                    stringRedisTemplate.opsForHash().delete("advertisementPic", "pic" + i);
//                }
//                stringRedisTemplate.opsForHash().put("advertisementPic", "pic" + i, fileUrl);
//            }
//            return ResultDto.builder().success(true).code(1).message("上传成功").build();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 查询我提交的广告
//     * @param: request
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @GetMapping("/getAllAd")
//    @ApiOperation("查询我的广告")
//    public ResultDto getAllAd(MyAdParam myAdParam, HttpServletRequest request) {
//        log.info("传入参数:{}", myAdParam);
//        //解析token获取id
//        String token = request.getHeader("X-Token");
//        Integer beautysalonId = Integer.parseInt(JwtUtil.parseToken(token).get("beautysalonId").toString());
//        try {
//            IPage<MyAdDto> allAd = beautysalonService.getAllAd(myAdParam, beautysalonId);
//            return ResultDto.builder().success(true).code(1).message("查询成功").object(allAd).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 条件分页查询场馆
//     * @param: conditionedQueryParam
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PostMapping("/conditionedquery")
//    @ApiOperation("分页条件查询所有场馆")
//    public ResultDto conditionedQuery(@RequestBody ConditionedQueryParam conditionedQueryParam) {
//        log.info("传入参数:{}", conditionedQueryParam);
//        try {
//            IPage<BeautysalonBaseInfoDto> info = beautysalonService.getBaseInfo(conditionedQueryParam);
//            return ResultDto.builder().success(true).code(1).message("查询成功").object(info).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 查看美容馆详情
//     * @param: beautysalonId
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @GetMapping("/querybs")
//    @ApiOperation("查看美容馆详情")
//    public ResultDto queryBeautysalon(@RequestParam Integer beautysalonId) {
//        log.info("传入参数:{}", beautysalonId);
//        try {
//            BeautysalonDto info = beautysalonService.getInfo(beautysalonId);
//            if (info == null) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.ACCESS_NOT_PERMISSION.getCode())
//                        .message(ProjectExceptionResult.ACCESS_NOT_PERMISSION.getMessage()).build();
//            }
//            return ResultDto.builder().success(true).code(1).message("查询成功").object(info).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 删除场馆
//     * @param: beautysalonId
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @DeleteMapping("/del")
//    @ApiOperation("删除场馆")
//    public ResultDto beautysalonDel(@RequestParam Integer beautysalonId) {
//        log.info("传入参数:{}", beautysalonId);
//        try {
//            int result = beautysalonService.beautysalonDel(beautysalonId);
//            if (result < 0) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                        .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//            }
//            return ResultDto.builder().success(true).code(1).message("删除成功").build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 美容馆审核通过
//     * @param: beautysalonId
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PutMapping("/auditpass")
//    @ApiOperation("美容馆审核通过")
//    public ResultDto auditPass(@RequestParam Integer beautysalonId) {
//        log.info("传入参数:{}", beautysalonId);
//        try {
//            int result = beautysalonService.auditPass(beautysalonId);
//            if (result <= 0) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                        .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//            }
//            return ResultDto.builder().success(true).code(1).message("通过成功").build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//
//    /**
//     * @description: 审核未通过
//     * @param: beautysalonCheckResultParam
//     * @return: com.woniu.bh.common.core.dto.ResultDto
//     */
//    @PutMapping("/auditrejected")
//    @ApiOperation("美容馆审核未通过")
//    public ResultDto auditRejected(@RequestBody BeautysalonCheckResultParam beautysalonCheckResultParam) {
//        log.info("传入参数:{}", beautysalonCheckResultParam);
//        try {
//            int result = beautysalonService.auditRejected(beautysalonCheckResultParam);
//            if (result <= 0) {
//                return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                        .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//            }
//            return ResultDto.builder().success(true).code(1).message("操作成功").object(result).build();
//        } catch (ProjectException p) {
//            p.printStackTrace();
//            return ResultDto.builder().success(false).code(ProjectExceptionResult.SYSTEM_ERROR.getCode())
//                    .message(ProjectExceptionResult.SYSTEM_ERROR.getMessage()).build();
//        }
//    }
//}
