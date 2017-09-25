package com.tencent.mm.an;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class b extends a {
    public String fGV = null;
    public String hNe;
    public LinkedList<String> hNf = new LinkedList();
    public String hNg = null;
    public String text = null;

    public b(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean HU() {
        if (this.values == null) {
            w.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        w.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", bg.mz(this.TYPE), Integer.valueOf(this.values.size()));
        if (bg.mA(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            w.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", bg.mz(this.TYPE));
            return false;
        }
        this.hNe = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket";
        if (this.values.containsKey(hMW)) {
            this.text = bg.mz((String) this.values.get(hMW));
        }
        if (this.values.containsKey(str)) {
            this.hNg = bg.mz((String) this.values.get(str));
        }
        if (this.values.containsKey(str2)) {
            this.fGV = bg.mz((String) this.values.get(str2));
        }
        this.hMY = this.text;
        if (this.fTk.bMz()) {
            this.hMY += " " + ab.getContext().getString(a.ksr);
        } else {
            this.hNa.add(this.hNg);
            this.hNb.add(Integer.valueOf(this.hMY.length()));
            this.hMY += this.hNg;
            this.hNc.add(Integer.valueOf(this.hMY.length()));
        }
        for (String str3 : this.values.keySet()) {
            if (str3.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
                this.hNf.add(this.values.get(str3));
            }
        }
        return true;
    }
}
