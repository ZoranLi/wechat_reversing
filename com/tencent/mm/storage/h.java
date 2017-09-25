package com.tencent.mm.storage;

import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import junit.framework.Assert;

public final class h extends e {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )"};

    public h(c cVar) {
        super(cVar);
        a(aJZ(), "appbrandmessage");
        a(new b(256, "appbrandmessage", b.a(3000001, 3500000, 102000001, 105000000)));
    }

    public final String QE(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (x.em(str)) {
            return "appbrandmessage";
        }
        return null;
    }
}
