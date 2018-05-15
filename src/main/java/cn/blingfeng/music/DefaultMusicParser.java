package cn.blingfeng.music;

import cn.blingfeng.music.core.CloudMusicApi;
import cn.blingfeng.music.core.SongDetailCloudMusicApi;
import cn.blingfeng.music.enums.CloudMusicParam;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public class DefaultMusicParser implements MusicParser {
    private final String systemPath;
    private final String songId;
    private static final String PREURL = "http://music.163.com/song/media/outer/url?id=";
    private static final String POSTURL = ".mp3";
    private final String URL;

    public DefaultMusicParser(String songId, String systemPath) {
        this.songId = songId;
        this.systemPath = systemPath;
        this.URL = PREURL + songId + POSTURL;
    }

    @Override
    public int parse() throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        Map params = new HashMap();
        Map result = null;
        params.put(CloudMusicParam.PARAM_SONG_ID.getName(), songId);
        CloudMusicApi api = new SongDetailCloudMusicApi();
        result = api.invoke(params);
        String songName = (String) result.get(CloudMusicParam.RERSULT_SONG_NAME.getName());
        double songSize = Double.parseDouble((String) result.get(CloudMusicParam.RESULT_SONG_SIZE.getName()));
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(URL);
            HttpResponse response = client.execute(request);
            if (response == null) {
                return -1;
            }
            DecimalFormat df = new DecimalFormat("#0.00");
            fos = new FileOutputStream(new File(systemPath + songName + ".mp3"));
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            byte arr[] = new byte[1024];
            int len = 0;
            System.out.print("【下载中】:" + "歌曲名:" + songName + " ,歌曲大小" + df.format(songSize / (1024 * 1024)) + "M");
            while ((len = is.read(arr)) != -1) {
                fos.write(arr, 0, len);
            }
            fos.flush();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (is != null) {
                is.close();
            }

        }
        return -1;

    }
}
