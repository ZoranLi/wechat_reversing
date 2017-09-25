package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    public static void a(Context context, pn pnVar, int i, int i2, int i3, String str, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (pnVar != null) {
            intent.putExtra("extra_id", pnVar.tgW);
            intent.putExtra("extra_name", pnVar.tuV);
            intent.putExtra("extra_copyright", pnVar.tvf);
            intent.putExtra("extra_coverurl", pnVar.tvd);
            intent.putExtra("extra_description", pnVar.tuW);
            intent.putExtra("extra_price", pnVar.tuY);
            intent.putExtra("extra_type", pnVar.tuZ);
            intent.putExtra("extra_flag", pnVar.tva);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!bg.mA(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            w.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
    }

    private static void a(Context context, pe peVar, int i, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", peVar.tgW);
        intent.putExtra("extra_name", peVar.fDC);
        intent.putExtra("extra_description", peVar.msk);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
    }

    public static void a(Context context, pe peVar, boolean z) {
        if (peVar == null) {
            w.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            return;
        }
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Intent intent;
        switch (peVar.tuO) {
            case 0:
                w.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                g.oUh.i(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(peVar.fxo), peVar.fDC, Integer.valueOf(0), Integer.valueOf(0)});
                return;
            case 1:
                if (z) {
                    a(context, peVar, 15, 8);
                } else {
                    a(context, peVar, 3, 5);
                }
                g.oUh.i(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(peVar.fxo), peVar.fDC, Integer.valueOf(0), Integer.valueOf(4)});
                return;
            case 2:
                String str5 = peVar.tuM;
                str = peVar.fDC;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str5);
                intent2.putExtra("title", str);
                b.imv.j(intent2, context);
                g.oUh.i(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(peVar.fxo), peVar.fDC, Integer.valueOf(0), Integer.valueOf(3)});
                return;
            case 3:
                i = peVar.fxo;
                str = peVar.fDC;
                str2 = peVar.msk;
                str3 = peVar.muU;
                str4 = peVar.tuN;
                intent = new Intent();
                intent.setClass(context, EmojiStoreTopicUI.class);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_desc", str2);
                if (z) {
                    intent.putExtra("extra_scence", 15);
                } else {
                    intent.putExtra("extra_scence", 3);
                }
                context.startActivity(intent);
                g.oUh.i(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(peVar.fxo), peVar.fDC, Integer.valueOf(0), Integer.valueOf(2)});
                return;
            case 4:
                i = peVar.fxo;
                str = peVar.fDC;
                str2 = peVar.msk;
                str3 = peVar.muU;
                str4 = peVar.tuN;
                intent = new Intent();
                intent.putExtra("set_id", i);
                intent.putExtra("headurl", str4);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.setClass(context, EmojiStoreV2SingleProductUI.class);
                context.startActivity(intent);
                g.oUh.i(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(peVar.fxo), peVar.fDC, Integer.valueOf(0), Integer.valueOf(1)});
                return;
            default:
                w.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[]{Integer.valueOf(peVar.tuO)});
                return;
        }
    }
}
