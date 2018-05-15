package cn.blingfeng.music.enums;

/**
 * @author blingfeng
 * @date 2018.05.15
 * 接口参数ENUM
 */
public enum CloudMusicParam {
    PARAM_SONG_ID("歌曲ID", "SONG_ID", null),
    PARAM_USER_ID("用户ID", "UID", null),
    PARAM_MUSIC_NAME("歌曲NAME", "MUSIC_NAME", null),
    TYPE_SINGLE_SONG("单曲", "SINGLE_SONG", "1"),
    PARAM_TYPE("查询类型", "TYPE", null),
    RERSULT_SONG_NAME("歌曲名字", "SONG_NAME", null),
    RESULT_SONG_SIZE("歌曲大小", "SONG_SIZE", null);
    private String desc;

    private String name;

    private String value;

    private CloudMusicParam(String desc, String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
