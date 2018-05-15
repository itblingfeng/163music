package cn.blingfeng.music.core;

import cn.blingfeng.music.enums.CloudMusicParam;
import cn.blingfeng.music.netease.Api;
import cn.blingfeng.music.netease.UrlParamPair;
import cn.blingfeng.music.secret.JSSecret;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.HashMap;
import java.util.Map;

/**
 * @author blingfeng
 * @date 2018.05.15
 * 歌曲详情查询接口
 */
public class SongDetailCloudMusicApi implements CloudMusicApi {
    @Override
    public Map<String, Object> invoke(Map<String, String> params) {

        try {
            String songId = params.get(CloudMusicParam.PARAM_SONG_ID.getName());
            if (songId == null) {
                return null;
            }
            UrlParamPair upp = Api.getDetailOfSong(songId);
            String req_str = upp.getParas().toJSONString();
            Connection.Response
                    response = Jsoup.connect("http://music.163.com/weapi/song/detail")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .data(JSSecret.getDatas(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            String list = response.body();
            String songName = list.substring(19, list.indexOf("\"", 19));
            String songSize = list.substring(list.lastIndexOf("\"size\":") + 7, list.indexOf(",", list.lastIndexOf("\"size\":")));
            Map<String,Object> result = new HashMap<>();
            result.put(CloudMusicParam.RERSULT_SONG_NAME.getName(),songName);
            result.put(CloudMusicParam.RESULT_SONG_SIZE.getName(),songSize);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
