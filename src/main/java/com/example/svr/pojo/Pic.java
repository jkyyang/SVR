package com.example.svr.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("pic_table")
@Data
public class Pic {
    private Integer id;
    // 在数据库中，是用下划线方法进行命名，在数据库的back-end中，用驼峰
    private String picUrl;
    private Integer pioId;

}
