package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.protocal.c.dj;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.a;
import java.util.LinkedList;

public final class b extends a<dk> {
    public b(String str, String str2, String str3, LinkedList<String> linkedList) {
        w.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s", new Object[]{str, str2, bg.Qj(str3), linkedList});
        com.tencent.mm.bd.a djVar = new dj();
        djVar.hNk = str;
        djVar.tgQ = str2;
        djVar.fGV = str3;
        djVar.tgR = linkedList;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = djVar;
        aVar.hsn = new dk();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        aVar.hsl = 774;
        this.gUA = aVar.BE();
    }
}
