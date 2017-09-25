package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String fDC = "";
    public int jOc = 0;
    public String mQT = "";
    public String mQU = "";
    public String msk = "";

    public static a yr(String str) {
        w.d(TAG, "getIPCallActivityMsgInfoFromXML:" + str);
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            w.e(TAG, "msgContent not start with <ActivityInfo");
            return aVar;
        }
        Map q = bh.q(str.substring(indexOf), "ActivityInfo");
        if (q == null) {
            w.e(TAG, "XmlParser values is null, xml %s", new Object[]{str});
            return null;
        }
        if (q.containsKey(".ActivityInfo.Title")) {
            aVar.fDC = (String) q.get(".ActivityInfo.Title");
        }
        if (q.containsKey(".ActivityInfo.Desc")) {
            aVar.msk = (String) q.get(".ActivityInfo.Desc");
        }
        if (q.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.mQT = (String) q.get(".ActivityInfo.ImgUrl");
        }
        if (q.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.mQU = (String) q.get(".ActivityInfo.StartBtnText");
        }
        if (q.containsKey(".ActivityInfo.ActivityType")) {
            aVar.jOc = bg.getInt((String) q.get(".ActivityInfo.ActivityType"), 0);
        }
        w.d(TAG, "msgInfo:", new Object[]{aVar.toString()});
        return aVar;
    }
}
