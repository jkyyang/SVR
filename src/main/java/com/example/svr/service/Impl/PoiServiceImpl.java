package com.example.svr.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.svr.mapper.PoiMapper;
import com.example.svr.pojo.Poi;
import com.example.svr.service.IPoiService;
import org.springframework.stereotype.Service;

@Service
public class PoiServiceImpl extends ServiceImpl<PoiMapper, Poi> implements IPoiService {

}
