package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.h;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;

public final class j {
    private static j suo = null;
    public long duration;
    private b ict = new b(ab.getContext());
    public long jYB = -1;
    public Toast jYC;
    public boolean jYO;
    public boolean jYP;
    public final aj jYV = new aj(new a(this) {
        final /* synthetic */ j sus;

        {
            this.sus = r1;
        }

        public final boolean oQ() {
            if (this.sus.jYB == -1) {
                this.sus.jYB = bg.NA();
            }
            long aB = bg.aB(this.sus.jYB);
            if (aB >= 3590000 && aB <= 3600000) {
                if (this.sus.jYC == null) {
                    this.sus.jYC = Toast.makeText(ab.getContext(), ab.getContext().getString(R.l.dsh, new Object[]{Integer.valueOf((int) ((3600000 - aB) / 1000))}), 0);
                } else {
                    this.sus.jYC.setText(ab.getContext().getString(R.l.dsh, new Object[]{Integer.valueOf((int) ((3600000 - aB) / 1000))}));
                }
                this.sus.jYC.show();
            }
            if (aB < 3600000) {
                return true;
            }
            w.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
            this.sus.jYP = true;
            this.sus.auK();
            if (this.sus.suq != null) {
                this.sus.suq.bBm();
            }
            return false;
        }
    }, true);
    private final ae jYX = new ae(this) {
        final /* synthetic */ j sus;

        {
            this.sus = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.sus.jYO = false;
        }
    };
    public TextView lKE;
    private long lNF;
    private com.tencent.mm.c.b.j lNM;
    private String path = "";
    private k sum;
    private String sun = "";
    public int sup = 0;
    public com.tencent.mm.plugin.wenote.model.b.b suq;
    private final ae sur = new ae(this) {
        final /* synthetic */ j sus;

        {
            this.sus = r1;
        }

        public final void handleMessage(Message message) {
            this.sus.lKE.setText(com.tencent.mm.ay.b.s(ab.getContext(), (int) com.tencent.mm.ay.b.aw(this.sus.getDuration())).toString());
            sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 100);
        }
    };

    private j() {
    }

    public static j bBf() {
        if (suo == null) {
            suo = new j();
        }
        return suo;
    }

    public final int a(int i, TextView textView, com.tencent.mm.plugin.wenote.model.b.b bVar, String str, String str2) {
        if (!this.jYO) {
            String Mk;
            this.jYO = true;
            this.lKE = textView;
            this.sup = i;
            this.suq = bVar;
            this.sun = str;
            this.path = str2;
            if (this.ict != null) {
                this.ict.requestFocus();
            }
            this.jYP = false;
            if (bg.mA(this.path)) {
                String str3;
                Mk = com.tencent.mm.ay.a.Mk();
                File file = new File(Mk);
                if (!file.exists()) {
                    file.mkdirs();
                }
                do {
                    str3 = Mk + "/" + System.currentTimeMillis();
                } while (new File(str3).exists());
                this.path = str3;
            }
            if (bg.mA(str)) {
                Mk = "amr";
            } else {
                Mk = str;
            }
            if (Mk.equals("speex")) {
                this.sum = new k();
                AnonymousClass1 anonymousClass1 = new h.a(this) {
                    final /* synthetic */ j sus;

                    {
                        this.sus = r1;
                    }

                    public final void onError() {
                        w.e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
                        this.sus.jYV.KH();
                    }
                };
            } else {
                com.tencent.mm.compatible.b.b.a aVar = com.tencent.mm.compatible.b.b.a.gNj;
                this.lNM = new com.tencent.mm.c.b.j();
                this.lNM.fBB = new com.tencent.mm.c.b.j.a(this) {
                    final /* synthetic */ j sus;

                    {
                        this.sus = r1;
                    }

                    public final void onError() {
                        w.e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
                        this.sus.jYV.KH();
                    }
                };
            }
            this.jYB = -1;
            Boolean.valueOf(false);
            if ((str.equals("speex") ? Boolean.valueOf(this.sum.bw(this.path)) : Boolean.valueOf(this.lNM.by(this.path))).booleanValue()) {
                this.lNF = bg.NA();
                this.jYV.v(200, 200);
            } else {
                this.lNF = 0;
            }
            if (this.lNF == 0) {
                return -1;
            }
            this.sur.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        }
        return 0;
    }

    public final void bBg() {
        if (this.jYO && !this.jYP) {
            auK();
        }
    }

    public final String bBh() {
        if (e.aO(this.path)) {
            return this.path;
        }
        return "";
    }

    public final void auK() {
        if (this.jYO) {
            boolean z;
            this.sur.removeMessages(Downloads.RECV_BUFFER_SIZE);
            if (this.sun.equals("speex")) {
                this.sum.oX();
            } else {
                this.lNM.oX();
            }
            if (this.ict != null) {
                this.ict.rY();
            }
            this.duration = getDuration();
            if (this.duration < 800) {
                z = true;
            } else {
                z = false;
            }
            this.jYV.KH();
            if (z) {
                File file = new File(this.path);
                if (file.exists()) {
                    file.delete();
                }
                this.jYX.sendEmptyMessageDelayed(0, 500);
            }
            this.jYO = false;
        }
    }

    public final long getDuration() {
        if (this.lNF == 0) {
            return 0;
        }
        return bg.aB(this.lNF);
    }

    public static void destroy() {
        suo = null;
    }

    public static j bBi() {
        return suo;
    }
}
