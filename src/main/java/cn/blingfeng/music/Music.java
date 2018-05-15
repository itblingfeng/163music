package cn.blingfeng.music;

import java.io.IOException;

public class Music {
    private static String systemPath = "/usr/local/jar/";

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("= _ =");
            return;
        }
        MusicParser parser = null;
        if (args.length == 2) {
            systemPath = args[1];
        }
        parser = new DefaultMusicParser(args[0], systemPath);
        try {
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
