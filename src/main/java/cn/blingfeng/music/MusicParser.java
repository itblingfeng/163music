package cn.blingfeng.music;

import java.io.IOException;

public interface MusicParser {
    /**
     * 音乐解析接口
     * @return
     * @throws IOException
     */
    int parse() throws IOException;
}
