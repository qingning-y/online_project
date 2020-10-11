package cn.yy.online_project.service;

import cn.yy.online_project.model.entity.Video;
import cn.yy.online_project.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> ListVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
