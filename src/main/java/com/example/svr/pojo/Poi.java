/*
* vo 从数据库获得的数据发给前端
*
* */

package com.example.svr.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("poi_table")
@Data

public class Poi {
    private Integer id;
    private String name;
    private String description;
    private Float Ing;
    private Float Lat;
    private String coverUrl;



}
