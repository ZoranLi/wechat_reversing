package com.tencent.mm.plugin.game.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.game.model.q.d;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class aj {
    private static String N(LinkedList<h> linkedList) {
        if (bg.bV(linkedList)) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            newSerializer.startTag(null, "userinfo");
            newSerializer.attribute(null, "jump_id", hVar.mqQ);
            newSerializer.startTag(null, "username");
            try {
                newSerializer.text(bg.ap(hVar.userName, ""));
            } catch (Exception e) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "username");
            newSerializer.startTag(null, "nickname");
            try {
                newSerializer.text(bg.ap(hVar.aIO, ""));
            } catch (Exception e2) {
                newSerializer.text("");
            }
            newSerializer.endTag(null, "nickname");
            newSerializer.startTag(null, "usericon");
            try {
                newSerializer.text(bg.ap(hVar.mqN, ""));
            } catch (Exception e3) {
                newSerializer.text("");
            }
            try {
                newSerializer.endTag(null, "usericon");
                newSerializer.startTag(null, "profile");
                try {
                    newSerializer.text(bg.ap(hVar.mqO, ""));
                } catch (Exception e4) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "profile");
                newSerializer.startTag(null, "badge_icon");
                try {
                    newSerializer.text(bg.ap(hVar.mqP, ""));
                } catch (Exception e5) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "badge_icon");
                newSerializer.endTag(null, "userinfo");
            } catch (Exception e6) {
                w.e("MicroMsg.GameXmlProcess", e6.getMessage());
                return "";
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    private static String a(LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bg.bV(linkedList) || hashMap.isEmpty()) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
        newSerializer.setOutput(stringWriter);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            d dVar = (d) hashMap.get(hVar.mqQ);
            if (dVar != null) {
                newSerializer.startTag(null, "jump");
                newSerializer.attribute(null, SlookAirButtonFrequentContactAdapter.ID, hVar.mqQ);
                newSerializer.startTag(null, "jump_type");
                try {
                    newSerializer.text(String.valueOf(dVar.mqH));
                } catch (Exception e) {
                    try {
                        newSerializer.text("");
                    } catch (Exception e2) {
                        w.e("MicroMsg.GameXmlProcess", e2.getMessage());
                        return "";
                    }
                }
                newSerializer.endTag(null, "jump_type");
                newSerializer.startTag(null, "jump_url");
                try {
                    newSerializer.text(bg.ap(dVar.lkK, ""));
                } catch (Exception e3) {
                    newSerializer.text("");
                }
                newSerializer.endTag(null, "jump_url");
                newSerializer.endTag(null, "jump");
            }
        }
        newSerializer.endDocument();
        stringWriter.flush();
        stringWriter.close();
        return stringWriter.getBuffer().toString();
    }

    public static String a(String str, LinkedList<h> linkedList, HashMap<String, d> hashMap) {
        if (bg.mA(str) || bg.bV(linkedList)) {
            return str;
        }
        String N = N(linkedList);
        if (bg.mA(N)) {
            return str;
        }
        String a = a(linkedList, hashMap);
        StringBuilder stringBuilder = new StringBuilder(str);
        try {
            if (stringBuilder.indexOf("<userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.indexOf("<userinfo>"), "<usercount>" + linkedList.size() + 1 + "</usercount>");
            }
            if (stringBuilder.lastIndexOf("</userinfo>") != -1) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</userinfo>") + 11, N);
            }
            if (!(stringBuilder.lastIndexOf("</jump>") == -1 || bg.mA(a))) {
                stringBuilder.insert(stringBuilder.lastIndexOf("</jump>") + 7, a);
            }
        } catch (Exception e) {
            w.e("MicroMsg.GameXmlProcess", e.getMessage());
            w.e("MicroMsg.GameXmlProcess", "xml is invalid : " + str);
        }
        return stringBuilder.toString();
    }
}
