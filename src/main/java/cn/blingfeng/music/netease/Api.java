package cn.blingfeng.music.netease;


public class Api {
    private final static String BaseURL = "http://music.163.com/";

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static UrlParamPair getPlaylistOfUser(String uid) {
        UrlParamPair upp = new UrlParamPair();
        upp.setUrl(BaseURL + "weapi/user/playlist?csrf_token=");
        upp.addPara("offset", 0);
        upp.addPara("uid", uid);
        upp.addPara("limit", 20);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    /**
     * 获取歌单详情
     *
     * @param playlist_id
     * @return
     */
    public static UrlParamPair getDetailOfPlaylist(String playlist_id) {
        UrlParamPair upp = new UrlParamPair();
        //upp.setUrl(BaseURL + "weapi/v3/playlist/detail?csrf_token=");
        upp.addPara("id", playlist_id);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 100);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }
    //todo:analyse more api

    /**
     * 搜索歌曲
     *
     * @param s;
     * @return
     */
    public static UrlParamPair SearchMusicList(String s, String type) {
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("s", s);
        upp.addPara("type", type);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 20);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    public static UrlParamPair getCommentOfSong(String songId) {
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("id", songId);
        upp.addPara("lv", -1);
        upp.addPara("tv", -1);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }


    public static UrlParamPair getDetailOfSong(String songId) {
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("id", songId);
        upp.addPara("ids", "[" + songId + "]");
        upp.addPara("limit", 10000);
        upp.addPara("offset", 0);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

}
