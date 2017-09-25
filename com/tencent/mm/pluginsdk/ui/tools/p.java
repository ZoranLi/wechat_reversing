package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.p.b;

public final class p extends com.tencent.mm.ui.tools.p {
    private VoiceSearchLayout pfs;
    public boolean sXA = true;
    public int sXB;
    public int sXC;
    public a sXD;
    private com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a sXE = new com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a(this) {
        final /* synthetic */ p sXF;

        {
            this.sXF = r1;
        }

        public final void bER() {
            if (!com.tencent.mm.n.a.aJ(ab.getContext()) && !com.tencent.mm.n.a.aH(ab.getContext())) {
                w.d("MicroMsg.VoiceSearchViewHelper", "on voice search start");
                g.oUh.i(10453, Integer.valueOf(this.sXF.sXB), Integer.valueOf(3));
                if (this.sXF.sXD != null) {
                    this.sXF.sXD.aej();
                }
            }
        }

        public final void bES() {
            w.d("MicroMsg.VoiceSearchViewHelper", "on voice search cancel");
            g.oUh.i(10453, Integer.valueOf(this.sXF.sXB), Integer.valueOf(4));
            if (this.sXF.wod != null) {
                this.sXF.wod.lF(true);
                this.sXF.wod.lG(true);
            }
            if (this.sXF.sXD != null) {
                this.sXF.sXD.aek();
            }
        }

        public final void a(boolean z, String[] strArr, long j) {
            w.d("MicroMsg.VoiceSearchViewHelper", "on voice search return, success %B, voice id %d", Boolean.valueOf(z), Long.valueOf(j));
            if (this.sXF.sXD != null) {
                this.sXF.sXD.a(z, strArr, j, this.sXF.sXC);
            }
        }
    };

    public interface a extends b {
        void a(boolean z, String[] strArr, long j, int i);

        void aej();

        void aek();
    }

    public p(byte b) {
        super(true, true);
    }

    public final void a(a aVar) {
        this.sXD = aVar;
        this.woe = aVar;
    }

    public final void o(VoiceSearchLayout voiceSearchLayout) {
        this.pfs = voiceSearchLayout;
        this.sXC = 1;
        if (1 == this.sXC) {
            this.sXB = 2;
        } else {
            this.sXB = 1;
        }
    }

    public final void cancel() {
        w.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.pfs != null) {
            this.pfs.bEB();
        }
        if (this.wod != null) {
            this.wod.lF(true);
            this.wod.lG(true);
        }
    }

    protected final boolean bGI() {
        boolean z = false;
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.sXA);
        if (this.pfs == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        return this.sXA;
    }

    protected final void bGJ() {
        w.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.wod != null) {
            this.wod.lF(false);
            this.wod.lG(false);
        }
        if (this.pfs != null && this.pfs.getVisibility() == 8) {
            w.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
            VoiceSearchLayout voiceSearchLayout = this.pfs;
            int i = this.sXC;
            w.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.aT(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
            if (com.tencent.mm.pluginsdk.i.a.aT(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
                boolean z;
                w.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.fOV);
                voiceSearchLayout.sLA = i;
                voiceSearchLayout.fOV = true;
                voiceSearchLayout.sLz = false;
                if (voiceSearchLayout.sLx != null) {
                    voiceSearchLayout.sLx.bER();
                }
                voiceSearchLayout.setVisibility(0);
                voiceSearchLayout.jYU.v(50, 50);
                voiceSearchLayout.a(true, null);
                voiceSearchLayout.sLK = 0;
                voiceSearchLayout.sLE = new e(new e.b(voiceSearchLayout) {
                    final /* synthetic */ VoiceSearchLayout sLL;

                    {
                        this.sLL = r1;
                    }

                    public final void LP() {
                        VoiceSearchLayout.k(this.sLL);
                        this.sLL.a(false, null);
                        if (this.sLL.jYU != null) {
                            this.sLL.jYU.KH();
                        }
                    }

                    public final void a(String[] strArr, long j) {
                        try {
                            w.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
                            if (strArr != null) {
                                w.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                                for (String str : strArr) {
                                    w.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
                                }
                            }
                            this.sLL.reset();
                            this.sLL.sLx.a(true, strArr, j);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
                        }
                    }

                    public final void LO() {
                        this.sLL.reset();
                        this.sLL.sLx.a(false, null, -1);
                    }
                }, i);
                e eVar = voiceSearchLayout.sLE;
                w.i("MicroMsg.SceneVoiceAddr", "start record");
                if (eVar.icN == 0 && am.is2G(ab.getContext())) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.icY = z;
                w.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", Boolean.valueOf(eVar.icY));
                com.tencent.mm.sdk.f.e.post(new a(eVar), "SceneVoiceAddr_record");
            } else if (voiceSearchLayout.getContext() instanceof Activity) {
                com.tencent.mm.pluginsdk.i.a.d((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
            }
        }
    }

    public final void a(Activity activity, Menu menu) {
        super.a(activity, menu);
        if (this.pfs != null) {
            this.pfs.sLx = this.sXE;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            boolean z = this.pfs != null && this.pfs.getVisibility() == 0;
            w.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                return true;
            }
        }
        w.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void bGK() {
        cancel();
    }
}
