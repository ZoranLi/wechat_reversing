package com.tencent.mm.an;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public String fGV;
    public String hNe;
    public LinkedList<String> hNf = new LinkedList();
    public int hNh;
    public LinkedList<String> hNi = new LinkedList();
    public LinkedList<String> hNj = new LinkedList();
    public String hNk = null;
    public String hNl = null;
    public String hNm = null;
    public String text = null;

    public c(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean HU() {
        int i = 0;
        if (this.values == null) {
            w.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        w.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", bg.mz(this.TYPE), Integer.valueOf(this.values.size()));
        if (bg.mA(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            w.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", bg.mz(this.TYPE));
            return false;
        }
        this.hNe = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.hNm = bg.mz((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.hNk = bg.mz((String) this.values.get(str3));
        }
        if (this.values.containsKey(str4)) {
            this.hNl = bg.mz((String) this.values.get(str4));
        }
        if (this.values.containsKey(hMW)) {
            this.text = bg.mz((String) this.values.get(hMW));
        }
        if (this.values.containsKey(str2)) {
            this.fGV = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.hNh = bg.getInt((String) this.values.get(str5), 0);
        }
        if (this.fTk.bMz()) {
            this.hNa.clear();
            this.hNb.clear();
            this.hNc.clear();
            this.hMY = this.text + " ";
            this.hNb.add(Integer.valueOf(this.hMY.length()));
            this.hNa.add(ab.getContext().getString(a.esk));
            this.hMY += ab.getContext().getString(a.esk);
            this.hNc.add(Integer.valueOf(this.hMY.length()));
        } else {
            this.hNb.add(Integer.valueOf(this.text.length()));
            this.hNa.add(this.hNm);
            this.hMY = this.text + this.hNm;
            this.hNc.add(Integer.valueOf(this.hMY.length()));
        }
        while (i < this.hNh) {
            if (i == 0) {
                this.hNf.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.hNi.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.hNj.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.hNf.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.hNi.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.hNj.add(bg.mz((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        return true;
    }
}
