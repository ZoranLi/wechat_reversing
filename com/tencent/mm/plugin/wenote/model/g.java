package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.a;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class g {
    public static String stV = (a.Mf() + "/fav_fileicon_video.png");
    public static String stW = (a.Mf() + "/fav_fileicon_music.png");
    public static String stX = (a.Mf() + "/fav_list_img_default.png");
    public static String stY = (a.Mf() + "/fav_fileicon_zip.png");
    public static String stZ = (a.Mf() + "/fav_fileicon_word.png");
    public static String sua = (a.Mf() + "/fav_fileicon_ppt.png");
    public static String sub = (a.Mf() + "/fav_fileicon_xls.png");
    public static String suc = (a.Mf() + "/fav_fileicon_txt.png");
    public static String sud = (a.Mf() + "/fav_fileicon_pdf.png");
    public static String sue = (a.Mf() + "/fav_fileicon_unknow.png");
    private static Map<String, String> suf;
    private static String[] sug = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] suh = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};

    private static void S(JSONObject jSONObject) {
        b kbVar = new kb();
        kbVar.fQz.type = 6;
        kbVar.fQz.fQC = jSONObject.toString();
        kbVar.fQz.fQq = "";
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    public static void i(Context context, String str, int i) {
        if (!bg.mA(str) && new File(str).exists()) {
            JSONObject jSONObject = new JSONObject();
            try {
                int aw = (int) e.aw((long) i);
                jSONObject.put(Columns.TYPE, 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", aw);
                jSONObject.put("lengthStr", e.J(context, aw));
                jSONObject.put("iconPath", a.Mf() + "/fav_fileicon_recording.png");
                S(jSONObject);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void Lk(String str) {
        if (!bg.mA(str)) {
            File file = new File(str);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Columns.TYPE, 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put("title", file.getName());
                    jSONObject.put("content", e.U((float) e.aN(str)));
                    jSONObject.put("iconPath", Lm(e.aQ(str)));
                    jSONObject.put("localPath", str);
                    S(jSONObject);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void Ll(String str) {
        w.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        w.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = a.Mh() + "/" + com.tencent.mm.a.g.n((new com.tencent.mm.pluginsdk.location.b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        w.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", new Object[]{obj});
        if (FileOp.aO(obj)) {
            w.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (e.aO(obj)) {
            w.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            w.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", new Object[]{obj});
            obj = b.stL;
        }
        jSONObject.put("localPath", obj);
        S(jSONObject);
    }

    public static void aa(ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put(Columns.TYPE, 2);
                jSONObject.put("downloaded", true);
                String ef = com.tencent.mm.plugin.wenote.b.b.ef(str, "");
                str = com.tencent.mm.plugin.wenote.b.b.eg(str, "");
                if (!bg.mA(ef) && !bg.mA(str)) {
                    jSONObject.put("bigImagePath", ef);
                    jSONObject.put("localPath", str);
                    S(jSONObject);
                } else {
                    return;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void aL(Context context, String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (!bg.mA(str)) {
            i = (int) j.bBf().duration;
            int aw = (int) e.aw((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", e.J(context, aw));
                jSONObject.put("iconPath", a.Mf() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put(Columns.TYPE, 4);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = j.bBf().sup;
        b kbVar = new kb();
        kbVar.fQz.type = 6;
        kbVar.fQz.fQC = jSONObject.toString();
        kbVar.fQz.fQq = Integer.toString(i);
        com.tencent.mm.sdk.b.a.urY.m(kbVar);
    }

    static {
        suf = new HashMap();
        Map hashMap = new HashMap();
        suf = hashMap;
        hashMap.put("avi", stV);
        suf.put("m4v", stV);
        suf.put("vob", stV);
        suf.put("mpeg", stV);
        suf.put("mpe", stV);
        suf.put("asx", stV);
        suf.put("asf", stV);
        suf.put("f4v", stV);
        suf.put("flv", stV);
        suf.put("mkv", stV);
        suf.put("wmv", stV);
        suf.put("wm", stV);
        suf.put("3gp", stV);
        suf.put("mp4", stV);
        suf.put("rmvb", stV);
        suf.put("rm", stV);
        suf.put("ra", stV);
        suf.put("ram", stV);
        suf.put("mp3pro", stW);
        suf.put("vqf", stW);
        suf.put("cd", stW);
        suf.put("md", stW);
        suf.put("mod", stW);
        suf.put("vorbis", stW);
        suf.put("au", stW);
        suf.put("amr", stW);
        suf.put("silk", stW);
        suf.put("wma", stW);
        suf.put("mmf", stW);
        suf.put("mid", stW);
        suf.put("midi", stW);
        suf.put("mp3", stW);
        suf.put("aac", stW);
        suf.put("ape", stW);
        suf.put("aiff", stW);
        suf.put("aif", stW);
        suf.put("jfif", stX);
        suf.put("tiff", stX);
        suf.put("tif", stX);
        suf.put("jpe", stX);
        suf.put("dib", stX);
        suf.put("jpeg", stX);
        suf.put("jpg", stX);
        suf.put("png", stX);
        suf.put("bmp", stX);
        suf.put("gif", stX);
        suf.put("rar", stY);
        suf.put("zip", stY);
        suf.put("7z", stY);
        suf.put("iso", stY);
        suf.put("cab", stY);
        suf.put("doc", stZ);
        suf.put("docx", stZ);
        suf.put("ppt", sua);
        suf.put("pptx", sua);
        suf.put("xls", sub);
        suf.put("xlsx", sub);
        suf.put("txt", suc);
        suf.put("rtf", suc);
        suf.put("pdf", sud);
        suf.put("unknown", sue);
    }

    public static String Lm(String str) {
        String str2 = (String) suf.get(str);
        if (str2 == null) {
            return (String) suf.get("unknown");
        }
        return str2;
    }

    public static String bP(List<rm> list) {
        String str = "";
        for (rm rmVar : list) {
            if (!rmVar.tyk.equals("-1")) {
                str = str.compareTo(rmVar.tyk) > 0 ? str : rmVar.tyk;
            }
        }
        return str;
    }

    public static String Ln(String str) {
        if (bg.mA(str) || str.length() == 0) {
            return str;
        }
        return Pattern.compile("\n", 2).matcher(str).replaceAll("").trim();
    }

    public static String Lo(String str) {
        if (!bg.mA(str)) {
            int i;
            String replaceAll = str.replaceAll("javascript", "ｊａｖａｓｃｒｉｐｔ");
            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(replaceAll);
            while (matcher.find()) {
                String replace = matcher.group().replace(" ", "");
                if (!replace.contains("data-type=") || !replace.contains("id=\"WeNote_") || !replace.contains("name=\"WeNote_") || !replace.contains("class=\"itemitem-") || replace.length() > 70) {
                    replaceAll = replaceAll.replace(matcher.group(), matcher.group().replace("<", "&lt;"));
                }
            }
            int length = sug.length;
            String str2 = replaceAll;
            for (i = 0; i < length; i++) {
                str2 = str2.replaceAll(sug[i], suh[i]);
            }
            str = str2.replaceAll("<", "＜");
            for (i = 0; i < length; i++) {
                str = str.replaceAll(suh[i], sug[i]);
            }
        }
        return str;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.a> a(Object obj, List<String> list, boolean z) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.size() == 0) {
            return null;
        }
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.a aVar = (com.tencent.mm.plugin.wenote.model.a.a) it.next();
            if (aVar.getType() != 1) {
                arrayList2.add(aVar);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (!((String) list.get(i)).trim().equals("[ThisisNoteNodeObj]")) {
                com.tencent.mm.plugin.wenote.model.a.e eVar = new com.tencent.mm.plugin.wenote.model.a.e();
                eVar.content = (String) list.get(i);
                eVar.sut = false;
                eVar.suz = false;
                eVar.lKv = e.Lj(eVar.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, eVar);
                } else {
                    arrayList2.add(eVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList2;
    }
}
