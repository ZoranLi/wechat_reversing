package com.tencent.mm.ui;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;

public final class y {
    public static List<String> bQG() {
        int xP = m.xP();
        List<String> arrayList = new ArrayList();
        if ((xP & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            arrayList.add("floatbottle");
            w.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        ap.yY();
        if (!c.vr().c(a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            w.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        ap.yY();
        if (!c.vr().c(a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            w.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        w.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
