package cn.yy.online_project.service.Impl;

import cn.yy.online_project.config.CacheKeyManager;
import cn.yy.online_project.model.entity.Video;
import cn.yy.online_project.model.entity.VideoBanner;
import cn.yy.online_project.mapper.VideoMapper;
import cn.yy.online_project.model.entity.VideoOrder;
import cn.yy.online_project.service.VideoService;
import cn.yy.online_project.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VideoServiceImpl implements VideoService {

  @Autowired private VideoMapper videoMapper;

  @Autowired private BaseCache baseCache;

  @Override
  public List<Video> ListVideo() {

    try {
      Object cacheObj =
          baseCache
              .getTenMinuteCache()
              .get(
                  CacheKeyManager.INDEX_VIDEO_LIST,
                  () -> {
                    List<Video> videoList = videoMapper.ListVideo();

                    System.out.println("从数据库里面找到视频列表");

                    return videoList;
                  });

      if (cacheObj instanceof List) {
        List<Video> videoList = (List<Video>) cacheObj;
        return videoList;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    // 可以返回兜底数据，业务系统降级
    return null;
  }

  @Override
  public List<VideoBanner> listBanner() {

    try {
      Object cacheObj =
          baseCache
              .getTenMinuteCache()
              .get(
                  CacheKeyManager.INDEX_BANNER_KEY,
                  () -> {
                    List<VideoBanner> bannerList = videoMapper.ListVideoBanner();

                    System.out.println("从数据库里面找轮播图列表");

                    return bannerList;
                  });

      if (cacheObj instanceof List) {

        List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;

        return bannerList;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public Video findDetailById(int videoId) {

    //单独构建一个缓存key,每个视频的key是不一样的
    String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);

    try {
      Object cacheObject =
          baseCache
              .getOneHourCache()
              .get(
                  videoCacheKey,
                  () -> {
                    // 需要使用mybaits关联复杂查询
                    Video video = videoMapper.findDetailById(videoId);

                    return video;
                  });

      if (cacheObject instanceof Video) {
        Video video = (Video) cacheObject;
        return video;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
