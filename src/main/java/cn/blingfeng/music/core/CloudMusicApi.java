package cn.blingfeng.music.core;

import java.util.Map;

/**
 * @author blingfeng
 * @date 2018.05.15
 * 云音乐api接口
 */
public interface CloudMusicApi {
    /**
     * 接口调用
     * @param params
     * @return
     */
    Map<String,Object> invoke(Map<String, String> params);
}
