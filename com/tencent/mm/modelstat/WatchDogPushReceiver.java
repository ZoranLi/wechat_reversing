package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            return;
        }
        int intExtra = intent.getIntExtra(Columns.TYPE, 0);
        w.d("MicroMsg.WatchDogPushReceiver", "onReceive type:" + intExtra);
        if (intExtra == 1) {
            a aVar = new a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                aVar.ifZ = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.iga = intent.getLongExtra("dataLen", 0);
            }
            aVar.hWj = intent.getLongExtra("cost", 0);
            aVar.igb = intent.getLongExtra("doSceneCount", 0);
            w.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.ifZ + " rx:" + aVar.iga + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.igb == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                w.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.igb + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            }
        } else if (intExtra != 2 && intExtra != 3 && intExtra != 4) {
            if (intExtra == 5 && b.bIu()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                } else {
                    MMProtocalJni.setClientPackVersion(-1);
                }
            } else if (intExtra == 6) {
                w.bIP();
            }
        }
    }

    private static String getClassName() {
        if (bg.mA(className)) {
            className = ab.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        return className;
    }

    public static void a(g gVar) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 1);
        intent.putExtra("rtType", gVar.rtType);
        intent.putExtra("beginTime", gVar.beginTime);
        intent.putExtra("endTime", gVar.endTime);
        intent.putExtra("rtType", gVar.rtType);
        intent.putExtra("dataLen", gVar.hWh);
        intent.putExtra("isSend", gVar.fZK);
        intent.putExtra("cost", gVar.hWj);
        intent.putExtra("doSceneCount", gVar.hWi);
        ab.getContext().sendBroadcast(intent);
    }

    public static void Ki() {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
        intent.putExtra(Columns.TYPE, 3);
        ab.getContext().sendBroadcast(intent);
    }

    public static void gJ(int i) {
        if (b.bIu()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
            intent.putExtra(Columns.TYPE, 5);
            intent.putExtra("jni", i);
            ab.getContext().sendBroadcast(intent);
        }
    }

    public static void Kj() {
        if (b.bIu()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ab.getPackageName(), getClassName()));
            intent.putExtra(Columns.TYPE, 7);
            ab.getContext().sendBroadcast(intent);
        }
    }
}
