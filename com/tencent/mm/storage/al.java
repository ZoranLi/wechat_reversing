package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class al {
    public String aeskey;
    public String fFW;
    public String fGa;
    public String fJL;
    public String fJY;
    public long fTQ;
    public int gxE;
    public String gxF = "";
    public int hJR;
    public int height;
    public String iah;
    public long iam;
    public String id;
    public String mLO;
    public String thumbUrl;
    public String uJA = "";
    public String uJB;
    public boolean uJC = true;
    public String uJD;
    public int uJw;
    public int uJx;
    public int uJy;
    public int uJz;
    public int width;

    public static al a(Map<String, String> map, String str, String str2, String str3) {
        if (map == null) {
            return null;
        }
        al alVar = new al();
        alVar.uJA = str2;
        alVar.fJL = str;
        alVar.id = (String) map.get(".msg.emoji.$idbuffer");
        alVar.iah = (String) map.get(".msg.emoji.$fromusername");
        String str4 = (String) map.get(".msg.emoji.$androidmd5");
        alVar.fFW = str4;
        if (str4 == null) {
            alVar.fFW = (String) map.get(".msg.emoji.$md5");
        }
        if (!bg.mA(alVar.fFW)) {
            alVar.fFW = alVar.fFW.toLowerCase();
        }
        try {
            alVar.uJw = Integer.valueOf((String) map.get(".msg.emoji.$type")).intValue();
            if (map.get(".msg.emoji.$androidlen") != null) {
                alVar.uJx = Integer.valueOf((String) map.get(".msg.emoji.$androidlen")).intValue();
            } else if (map.get(".msg.emoji.$len") != null) {
                alVar.uJx = Integer.valueOf((String) map.get(".msg.emoji.$len")).intValue();
            }
            if (map.get(".msg.gameext.$type") != null) {
                alVar.uJy = Integer.valueOf((String) map.get(".msg.gameext.$type")).intValue();
            }
            if (map.get(".msg.gameext.$content") != null) {
                alVar.uJz = Integer.valueOf((String) map.get(".msg.gameext.$content")).intValue();
            }
            if (map.get(".msg.emoji.$productid") != null) {
                alVar.fGa = (String) map.get(".msg.emoji.$productid");
            }
            if (map.get(".msg.emoji.$cdnurl") != null) {
                alVar.mLO = (String) map.get(".msg.emoji.$cdnurl");
            }
            if (map.get(".msg.emoji.$designerid") != null) {
                alVar.uJB = (String) map.get(".msg.emoji.$designerid");
            }
            if (map.get(".msg.emoji.$thumburl") != null) {
                alVar.thumbUrl = (String) map.get(".msg.emoji.$thumburl");
            }
            if (map.get(".msg.emoji.$encrypturl") != null) {
                alVar.fJY = (String) map.get(".msg.emoji.$encrypturl");
            }
            if (map.get(".msg.emoji.$aeskey") != null) {
                alVar.aeskey = (String) map.get(".msg.emoji.$aeskey");
            }
            if (map.get(".msg.emoji.$width") != null) {
                alVar.width = Integer.valueOf((String) map.get(".msg.emoji.$width")).intValue();
            }
            if (map.get(".msg.emoji.$height") != null) {
                alVar.height = Integer.valueOf((String) map.get(".msg.emoji.$height")).intValue();
            }
            if (map.get(".msg.emoji.$activityid") != null) {
                alVar.uJD = (String) map.get(".msg.emoji.$activityid");
            }
            if (!bg.mA(str3)) {
                alVar.gxF = str3;
            }
            w.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d activityID:%s", alVar.id, alVar.fFW, Integer.valueOf(alVar.uJw), Integer.valueOf(alVar.uJx), Integer.valueOf(alVar.uJy), Integer.valueOf(alVar.uJz), alVar.fGa, alVar.mLO, alVar.uJB, alVar.thumbUrl, alVar.fJY, Integer.valueOf(alVar.width), Integer.valueOf(alVar.height), alVar.uJD);
            return alVar;
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", bg.g(e));
            return null;
        }
    }
}
