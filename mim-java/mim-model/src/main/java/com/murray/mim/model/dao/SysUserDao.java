package com.murray.mim.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@TableName("sys_user")
public class SysUserDao implements Serializable {

    private static final long serialVersionUID = -6597411129113617036L;

    @ApiModelProperty(value="ID",name="id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    @ApiModelProperty(value="用户编号",name="userNo")
    private String userNo;
    
    @ApiModelProperty(value="用户昵称",name="nickName")
    private String nickName;
    
    @ApiModelProperty(value="头像",name="image")
    private String image;
    
    @ApiModelProperty(value="手机号码",name="phone")
    private String phone;
    
    @ApiModelProperty(value="密码",name="password")
    @JsonIgnore
    private String password;
    
    @ApiModelProperty(value="类型",name="systemUserType")
    private Integer sysUserType;
    
    @ApiModelProperty(value="岗位",name="position")
    private String position;
    
    @ApiModelProperty(value="加密盐",name="passwordSalt")
    private String passwordSalt;
    
    @ApiModelProperty(value="备注",name="remark")
    private String remark;

    @ApiModelProperty(value="版本号",name="version")
    private Long version;
    
    @ApiModelProperty(value="状态",name="isEnable")
    private Integer isEnable;
    
    @ApiModelProperty(value="创建人",name="createBy")
    private String createBy;
    
    @ApiModelProperty(value="创建时间",name="createTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    
    @ApiModelProperty(value="修改人",name="updateBy")
    private String updateBy;
    
    @ApiModelProperty(value="修改时间",name="updateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty(value="角色列表",name="roles")
    @TableField(exist = false)
    private List<String> roles;

}

      