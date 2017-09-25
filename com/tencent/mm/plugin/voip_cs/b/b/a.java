package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

public final class a {
    public v2protocal mOV = new v2protocal(this.mOW);
    private ae mOW = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ a rtc;

        public final void handleMessage(Message message) {
            if (message == null) {
                super.handleMessage(message);
                return;
            }
            w.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
            a aVar;
            switch (message.arg1) {
                case 1:
                case 4:
                    return;
                case 3:
                    w.d("MicroMsg.VoipCSEngine", "start dev!");
                    return;
                case 5:
                    w.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        w.i("MicroMsg.VoipCSEngine", "channel broken...");
                        b.brP().rrN = 1;
                    } else if (message.arg2 == 5) {
                        w.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        b.brP().rrN = 6;
                    } else {
                        w.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        b.brP().rrN = 5;
                    }
                    aVar = this.rtc;
                    w.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    b.brP().aMw = 1;
                    if (aVar.rtb != null) {
                        aVar.rtb.bsd();
                        return;
                    }
                    return;
                case 6:
                    w.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    c brP = b.brP();
                    w.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    brP.rrQ = 1;
                    aVar = this.rtc;
                    w.i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (aVar.mOY) {
                        w.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        return;
                    }
                    aVar.mOY = true;
                    w.i("MicroMsg.VoipCSEngine", "start engine");
                    aVar.mOV.setInactive();
                    w.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!aVar.mOY) {
                        w.d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    aVar.mOV.setActive();
                    int startEngine = aVar.mOV.startEngine();
                    if (startEngine == 0) {
                        w.i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = new int[]{b.brN().mOV.rkR, b.brN().mOV.rkS};
                        ByteBuffer allocate = ByteBuffer.allocate(8);
                        allocate.asIntBuffer().put(iArr);
                        if (b.brN().mOV.setAppCmd(34, allocate.array(), 2) < 0) {
                            w.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                        }
                        b.brP().rrO = 1;
                    } else {
                        w.i("MicroMsg.VoipCSEngine", "start engine fail!");
                        b.brP().rrO = 0;
                    }
                    if (aVar.rtb != null && b.brO().rst != 2) {
                        aVar.rtb.aDE();
                        b.brO().rst = 2;
                        return;
                    }
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    a aVar2 = this.rtc;
                    try {
                        bis com_tencent_mm_protocal_c_bis = (bis) new bis().aD(bArr);
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_bis.uiw);
                        switch (com_tencent_mm_protocal_c_bis.uiw) {
                            case 3:
                                if (com_tencent_mm_protocal_c_bis.uix != null) {
                                    Object obj = com_tencent_mm_protocal_c_bis.uix.sYA;
                                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "steve: remote new network type:" + obj);
                                    int appCmd = aVar2.mOV.setAppCmd(302, obj, 4);
                                    if (appCmd < 0) {
                                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + appCmd + ", [roomid=" + aVar2.mOV.rjL + ", roomkey=" + aVar2.mOV.mNM + "]");
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.dJ("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                    return;
                case 100:
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    return;
                case 101:
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    return;
                default:
                    return;
            }
        }
    };
    public boolean mOX = false;
    public boolean mOY = false;
    public a rtb = null;

    public interface a {
        void aDE();

        void bsd();
    }

    public static int HL(String str) {
        String[] split = str.split("\\.");
        return bg.getInt(split[3], 0) + (((bg.getInt(split[0], 0) << 24) + (bg.getInt(split[1], 0) << 16)) + (bg.getInt(split[2], 0) << 8));
    }
}
