package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class a {
    public v2protocal mOV = new v2protocal(this.mOW);
    private ae mOW = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ a mPb;

        public final void handleMessage(Message message) {
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                return;
            }
            w.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
            a aVar;
            switch (message.arg1) {
                case 3:
                    w.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    return;
                case 4:
                    w.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    aVar = this.mPb;
                    w.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (aVar.mPa != null) {
                        aVar.mPa.aDD();
                        return;
                    }
                    return;
                case 5:
                    w.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        w.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        this.mPb.ok(34);
                        return;
                    } else if (message.arg2 == 1) {
                        w.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        this.mPb.ok(20);
                        return;
                    } else if (message.arg2 == 5) {
                        w.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        this.mPb.ok(30);
                        return;
                    } else {
                        return;
                    }
                case 6:
                    aVar = this.mPb;
                    w.d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (aVar.mOY) {
                        w.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        return;
                    }
                    w.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[]{Integer.valueOf(aVar.mOV.startEngine())});
                    if (aVar.mOV.startEngine() == 0) {
                        aVar.mOV.rkl = 0;
                    } else {
                        aVar.mOV.rkl = 1;
                    }
                    aVar.mOV.setInactive();
                    aVar.mOY = true;
                    if (aVar.mPa != null) {
                        aVar.mPa.aDE();
                        return;
                    }
                    return;
                case 9:
                    w.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    return;
                case 10:
                    w.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    w.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    g aEh = i.aEh();
                    w.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (aEh.fSy) {
                        w.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                        return;
                    }
                    aEh.mNf = true;
                    if (aEh.mNd != null) {
                        aEh.mNd.mNV = 2;
                        ap.vd().a(new o(aEh.mNd.mNL, aEh.mNd.mNM, aEh.mNd.aEx(), aEh.mNd.mNN, true), 0);
                    }
                    aEh.oj(2);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean mOX = false;
    public boolean mOY = false;
    public boolean mOZ = false;
    public a mPa = null;

    public interface a {
        void aDD();

        void aDE();

        void of(int i);
    }

    public final void aEB() {
        w.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.mOY) {
            w.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.mOV.setActive();
    }

    public final void ok(int i) {
        w.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (this.mPa != null) {
            this.mPa.of(i);
        }
    }

    public final void aEC() {
        if (this.mOX) {
            w.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            return;
        }
        w.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.aEh().mNd;
        if (cVar != null) {
            if (cVar.jEB != null) {
                bjy X = com.tencent.mm.plugin.ipcall.b.c.X(cVar.jEB);
                this.mOV.b(X, X, com.tencent.mm.plugin.ipcall.b.c.X(cVar.mOk));
            }
            w.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.mOV.rjP = cVar.mOf;
            this.mOV.rkH = cVar.mOi;
            if (cVar.mOj != null) {
                this.mOV.rkI = cVar.mOj.toByteArray();
            }
            if (cVar.mOg != null) {
                this.mOV.rjQ = cVar.mOg.toByteArray();
            }
            this.mOV.mNL = cVar.mNL;
            this.mOV.mNM = cVar.mNM;
            this.mOV.mNT = cVar.mNT;
            this.mOV.rjS = cVar.mOd;
            this.mOV.rjR = cVar.mOe;
            this.mOV.rjT = cVar.mOl;
            w.d("MicroMsg.IPCallEngineManager", "setConfigConnect, ret: %d", new Object[]{Integer.valueOf(this.mOV.setConfigConnect(this.mOV.rjK, (long) this.mOV.mNL, this.mOV.mNT, this.mOV.mNM, this.mOV.field_peerId, 1, this.mOV.rjR, this.mOV.rjS, this.mOV.rjP, this.mOV.rjQ == null ? 0 : this.mOV.rjQ.length, this.mOV.rjQ, this.mOV.rjT, 0, 0, this.mOV.rkH, this.mOV.rkI, 255, 0))});
            if (this.mOV.setConfigConnect(this.mOV.rjK, (long) this.mOV.mNL, this.mOV.mNT, this.mOV.mNM, this.mOV.field_peerId, 1, this.mOV.rjR, this.mOV.rjS, this.mOV.rjP, this.mOV.rjQ == null ? 0 : this.mOV.rjQ.length, this.mOV.rjQ, this.mOV.rjT, 0, 0, this.mOV.rkH, this.mOV.rkI, 255, 0) < 0) {
                w.e("MicroMsg.IPCallEngineManager", "setConfigConnect failed, ret: %d", new Object[]{Integer.valueOf(r2)});
                if (this.mPa != null) {
                    this.mPa.of(21);
                }
            }
            this.mOX = true;
        }
    }

    public final void ol(int i) {
        if (this.mOY) {
            w.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[]{Integer.valueOf(i)});
            if (this.mOV.SetDTMFPayload(i) < 0) {
                w.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[]{Integer.valueOf(this.mOV.SetDTMFPayload(i))});
            }
        }
    }

    public final void aED() {
        this.mOY = false;
        this.mOX = false;
        this.mOZ = false;
    }
}
