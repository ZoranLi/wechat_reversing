package com.tencent.mm.an;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String fPT;
    public LinkedList<String> hNn = new LinkedList();
    public String url;

    public d(Map<String, String> map) {
        super(map);
    }

    protected final boolean HU() {
        if (this.values == null) {
            w.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        w.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", bg.mz(this.TYPE), Integer.valueOf(this.values.size()));
        if (bg.mA(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            w.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", bg.mz(this.TYPE));
            return false;
        }
        this.url = bg.mz((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.fPT = bg.mz((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.hNn.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.hNn.add(this.values.get(str));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(hMW)) {
                int length;
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str2));
                    this.hNa.add(this.values.get(str2));
                    length = ((String) this.values.get(str2)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.hNb.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.hNc.add(Integer.valueOf(stringBuilder.length()));
        this.hMY = stringBuilder.toString();
        w.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.fPT, Integer.valueOf(this.hNn.size()));
        return true;
    }
}
