package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.aw.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Set;

public abstract class VoiceInputLayout extends LinearLayout {
    private final aj jYU = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ VoiceInputLayout sLe;

        {
            this.sLe = r1;
        }

        public final boolean oQ() {
            if (this.sLe.sKX != null) {
                f b = this.sLe.sKX;
                int i = b.icU;
                b.icU = 0;
                if (i > f.fBC) {
                    f.fBC = i;
                }
                int i2 = (i * 100) / f.fBC;
                if (this.sLe.sKB == 2) {
                    this.sLe.xm(i2);
                }
            }
            return true;
        }
    }, true);
    private ae kir = new ae(this) {
        final /* synthetic */ VoiceInputLayout sLe;

        {
            this.sLe = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what != 0) {
                if (message.what == 1) {
                    w.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(this.sLe.sKB));
                } else {
                    return;
                }
            }
            w.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(this.sLe.sKB));
            if (this.sLe.sKB == 3) {
                this.sLe.kir.removeMessages(0);
                this.sLe.kir.removeMessages(1);
                if (this.sLe.sKX != null) {
                    this.sLe.sKX.bx(true);
                }
                this.sLe.reset(true);
            }
        }
    };
    protected int sKB = 1;
    public b sKW = null;
    private f sKX;
    protected boolean sKY = false;
    private int sKZ = 3000;
    private int sLa = 10000;
    protected a sLb;
    private ae sLd = new ae(this) {
        final /* synthetic */ VoiceInputLayout sLe;

        {
            this.sLe = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.sLe.bEC();
                    return;
                case 1:
                    Bundle data = message.getData();
                    this.sLe.S(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    return;
                default:
                    return;
            }
        }
    };

    public interface a {
        void bEF();
    }

    public interface b {
        void T(int i, int i2, int i3);

        void b(String[] strArr, Set<String> set);

        void bEG();

        void bEH();

        void bEI();

        void bEJ();

        void bEK();
    }

    protected abstract void jq(boolean z);

    protected abstract void jr(boolean z);

    protected abstract void onReset();

    protected abstract void xm(int i);

    public final void a(a aVar) {
        this.sLb = aVar;
    }

    public final void jp(boolean z) {
        this.sKY = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void bEA() {
        if (com.tencent.mm.n.a.aJ(getContext()) || com.tencent.mm.n.a.aH(getContext())) {
            w.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        w.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.aT(getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.i.a.aT(getContext(), "android.permission.RECORD_AUDIO")) {
            w.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.sKB));
            if (this.sKB == 1) {
                this.sKB = 2;
                if (this.sKW != null) {
                    this.sKW.bEG();
                }
                this.jYU.v(50, 50);
                jq(true);
                this.sKX = new f(new com.tencent.mm.aw.f.b(this) {
                    final /* synthetic */ VoiceInputLayout sLe;

                    {
                        this.sLe = r1;
                    }

                    public final void LP() {
                        w.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(this.sLe.sKB));
                        if (this.sLe.jYU != null) {
                            this.sLe.jYU.KH();
                        }
                        this.sLe.sLd.sendEmptyMessage(0);
                    }

                    public final void LU() {
                        w.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
                        this.sLe.kir.removeMessages(0);
                        this.sLe.kir.removeMessages(1);
                        this.sLe.sKW.bEK();
                        this.sLe.reset(false);
                    }

                    public final void a(String[] strArr, Set<String> set) {
                        this.sLe.sKW.b(strArr, set);
                        this.sLe.kir.removeMessages(0);
                        this.sLe.kir.sendEmptyMessageDelayed(0, (long) this.sLe.sKZ);
                    }

                    public final void u(int i, int i2, int i3) {
                        this.sLe.kir.removeMessages(0);
                        this.sLe.kir.removeMessages(1);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putInt("localCode", i);
                        bundle.putInt("errType", i2);
                        bundle.putInt("errCode", i3);
                        message.setData(bundle);
                        message.what = 1;
                        this.sLe.sLd.sendMessage(message);
                    }
                });
                f fVar = this.sKX;
                w.i("MicroMsg.SceneVoiceInputAddr", "start record");
                e.b(new a(fVar), "SceneVoiceInputAddr_record", 10);
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.i.a.d((Activity) getContext(), "android.permission.RECORD_AUDIO");
        }
    }

    public final void bEB() {
        w.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.sKB));
        if (this.sKB != 1) {
            this.sKB = 1;
            if (this.sKW != null) {
                this.sKW.bEI();
            }
            if (this.sKX != null) {
                this.sKX.bx(true);
            }
            onReset();
        }
    }

    public final void be() {
        w.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.sKB));
        if (this.sKB != 1 && this.sKB == 2) {
            this.sKB = 3;
            if (this.sKW != null) {
                this.sKW.bEH();
            }
            if (this.jYU != null) {
                this.jYU.KH();
            }
            this.kir.removeMessages(0);
            this.kir.sendEmptyMessageDelayed(0, (long) this.sKZ);
            this.kir.sendEmptyMessageDelayed(1, (long) this.sLa);
            jr(true);
            if (this.sKX != null) {
                this.sKX.ap(true);
            }
        }
    }

    public final void bEC() {
        w.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.sKB));
        if (this.sKB == 2) {
            this.sKB = 3;
            this.kir.removeMessages(0);
            this.kir.sendEmptyMessageDelayed(0, (long) this.sKZ);
            this.kir.sendEmptyMessageDelayed(1, (long) this.sLa);
            jr(false);
        }
    }

    public final void bED() {
        S(12, -1, -1);
    }

    public final void S(int i, int i2, int i3) {
        w.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.sKB = 1;
        onReset();
        if (this.sKW != null) {
            this.sKW.T(i, i2, i3);
        }
    }

    protected final void reset(boolean z) {
        w.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.sKB));
        if (this.sKB != 1) {
            this.sKB = 1;
            onReset();
            if (z && this.sKW != null) {
                this.sKW.bEJ();
            }
        }
    }

    public final int bEE() {
        return this.sKB;
    }
}
