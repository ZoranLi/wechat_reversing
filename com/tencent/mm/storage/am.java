package com.tencent.mm.storage;

import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.b;
import junit.framework.Assert;

public final class am extends e {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS bottlemessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  bmessageSvrIdIndex ON bottlemessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bmessageTalkerIndex ON bottlemessage ( talker )", "CREATE INDEX IF NOT EXISTS  bmessageTalerStatusIndex ON bottlemessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bmessageCreateTimeIndex ON bottlemessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bmessageCreateTaklerTimeIndex ON bottlemessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bmessageSendCreateTimeIndex ON bottlemessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bottlemessageTalkerTypeIndex ON bottlemessage ( talker,type )", "CREATE TABLE IF NOT EXISTS qmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  qmessageSvrIdIndex ON qmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  qmessageTalkerIndex ON qmessage ( talker )", "CREATE INDEX IF NOT EXISTS  qmessageTalerStatusIndex ON qmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  qmessageCreateTimeIndex ON qmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  qmessageCreateTaklerTimeIndex ON qmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  qmessageSendCreateTimeIndex ON qmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  qmessageTalkerSvrIdIndex ON qmessage ( talker,msgSvrId )", "CREATE INDEX IF NOT EXISTS  qmessageTalkerTypeIndex ON qmessage ( talker,type )", "CREATE TABLE IF NOT EXISTS tmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  tmessageSvrIdIndex ON tmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  tmessageTalkerIndex ON tmessage ( talker )", "CREATE INDEX IF NOT EXISTS  tmessageTalerStatusIndex ON tmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  tmessageCreateTimeIndex ON tmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  tmessageCreateTaklerTimeIndex ON tmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  tmessageSendCreateTimeIndex ON tmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  tmessageTalkerTypeIndex ON tmessage ( talker,type )"};

    public am(c cVar) {
        super(cVar);
        a(aJZ(), "bottlemessage");
        a(aJZ(), "qmessage");
        a(aJZ(), "tmessage");
        a(new b(8, "bottlemessage", b.a(2000001, 2500000, 96000001, 99000000)));
        a(new b(2, "qmessage", b.a(1000001, 1500000, 90000001, 93000000)));
        a(new b(4, "tmessage", b.a(1500001, 2000000, 93000001, 96000000)));
    }

    public final String QE(String str) {
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (str.endsWith("@t.qq.com")) {
            return "tmessage";
        }
        if (str.endsWith("@qqim")) {
            return "qmessage";
        }
        if (x.eO(str)) {
            return "bottlemessage";
        }
        return null;
    }
}
