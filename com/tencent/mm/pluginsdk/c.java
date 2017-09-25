package com.tencent.mm.pluginsdk;

import com.tencent.mm.plugin.k.a.a;
import com.tencent.mm.plugin.k.a.b;
import java.util.HashMap;

public final class c {
    private static HashMap<String, Integer> sBj = null;

    public static int LC(String str) {
        if (sBj == null) {
            HashMap hashMap = new HashMap();
            sBj = hashMap;
            hashMap.put("avi", Integer.valueOf(b.dtr));
            sBj.put("m4v", Integer.valueOf(b.dtr));
            sBj.put("vob", Integer.valueOf(b.dtr));
            sBj.put("mpeg", Integer.valueOf(b.dtr));
            sBj.put("mpe", Integer.valueOf(b.dtr));
            sBj.put("asx", Integer.valueOf(b.dtr));
            sBj.put("asf", Integer.valueOf(b.dtr));
            sBj.put("f4v", Integer.valueOf(b.dtr));
            sBj.put("flv", Integer.valueOf(b.dtr));
            sBj.put("mkv", Integer.valueOf(b.dtr));
            sBj.put("wmv", Integer.valueOf(b.dtr));
            sBj.put("wm", Integer.valueOf(b.dtr));
            sBj.put("3gp", Integer.valueOf(b.dtr));
            sBj.put("mp4", Integer.valueOf(b.dtr));
            sBj.put("rmvb", Integer.valueOf(b.dtr));
            sBj.put("rm", Integer.valueOf(b.dtr));
            sBj.put("ra", Integer.valueOf(b.dtr));
            sBj.put("ram", Integer.valueOf(b.dtr));
            sBj.put("mp3pro", Integer.valueOf(b.dtg));
            sBj.put("vqf", Integer.valueOf(b.dtg));
            sBj.put("cd", Integer.valueOf(b.dtg));
            sBj.put("md", Integer.valueOf(b.dtg));
            sBj.put("mod", Integer.valueOf(b.dtg));
            sBj.put("vorbis", Integer.valueOf(b.dtg));
            sBj.put("au", Integer.valueOf(b.dtg));
            sBj.put("amr", Integer.valueOf(b.dtg));
            sBj.put("silk", Integer.valueOf(b.dtg));
            sBj.put("wma", Integer.valueOf(b.dtg));
            sBj.put("mmf", Integer.valueOf(b.dtg));
            sBj.put("mid", Integer.valueOf(b.dtg));
            sBj.put("midi", Integer.valueOf(b.dtg));
            sBj.put("mp3", Integer.valueOf(b.dtg));
            sBj.put("aac", Integer.valueOf(b.dtg));
            sBj.put("ape", Integer.valueOf(b.dtg));
            sBj.put("aiff", Integer.valueOf(b.dtg));
            sBj.put("aif", Integer.valueOf(b.dtg));
            sBj.put("jfif", Integer.valueOf(a.bbY));
            sBj.put("tiff", Integer.valueOf(a.bbY));
            sBj.put("tif", Integer.valueOf(a.bbY));
            sBj.put("jpe", Integer.valueOf(a.bbY));
            sBj.put("dib", Integer.valueOf(a.bbY));
            sBj.put("jpeg", Integer.valueOf(a.bbY));
            sBj.put("jpg", Integer.valueOf(a.bbY));
            sBj.put("png", Integer.valueOf(a.bbY));
            sBj.put("bmp", Integer.valueOf(a.bbY));
            sBj.put("gif", Integer.valueOf(a.bbY));
            sBj.put("rar", Integer.valueOf(b.dtm));
            sBj.put("zip", Integer.valueOf(b.dtm));
            sBj.put("7z", Integer.valueOf(b.dtm));
            sBj.put("iso", Integer.valueOf(b.dtm));
            sBj.put("cab", Integer.valueOf(b.dtm));
            sBj.put("doc", Integer.valueOf(b.dtv));
            sBj.put("docx", Integer.valueOf(b.dtv));
            sBj.put("ppt", Integer.valueOf(b.dtk));
            sBj.put("pptx", Integer.valueOf(b.dtk));
            sBj.put("xls", Integer.valueOf(b.dtc));
            sBj.put("xlsx", Integer.valueOf(b.dtc));
            sBj.put("txt", Integer.valueOf(b.dtn));
            sBj.put("rtf", Integer.valueOf(b.dtn));
            sBj.put("pdf", Integer.valueOf(b.dti));
        }
        Integer num = (Integer) sBj.get(str);
        if (num == null) {
            return b.dto;
        }
        return num.intValue();
    }

    public static int bCm() {
        return b.dto;
    }
}
