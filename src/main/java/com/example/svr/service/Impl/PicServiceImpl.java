package com.example.svr.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.svr.mapper.PicMapper;
import com.example.svr.pojo.Pic;
import com.example.svr.service.IPicService;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl extends ServiceImpl<PicMapper, Pic> implements IPicService {
}
