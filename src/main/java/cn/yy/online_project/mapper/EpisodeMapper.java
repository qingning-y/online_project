package cn.yy.online_project.mapper;

import cn.yy.online_project.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {

  Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
