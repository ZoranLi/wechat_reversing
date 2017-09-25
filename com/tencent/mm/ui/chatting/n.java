package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.ArrayList;
import java.util.Iterator;

final class n extends a {
    public static int[] lMZ = new int[]{R.h.bBe, R.h.bBf, R.h.bBg, R.h.bBh, R.h.bBi};
    protected TextView ipw;
    protected TextView ipx;
    protected TextView lMU;
    protected TextView mys;
    private ArrayList<MMImageView> qwg = new ArrayList();
    protected ImageView sva;
    protected TextView vyE;
    protected ImageView vyL;
    protected ImageView vyM;
    protected TextView vyN;
    protected LinearLayout vyO;
    protected ImageView vyP;
    protected MMPinProgressBtn vyQ;
    protected ImageView vyR;
    protected ImageView vyS;
    protected ImageView vyT;
    protected ChattingItemFooter vyU;
    protected ImageView vyV;
    protected LinearLayout vyW;
    protected ViewGroup vyX;
    protected TextView vyY;
    protected LinearLayout vyZ;
    public int vym = 0;
    protected MMImageView vyp;
    ImageView vyy;
    protected RelativeLayout vza;
    protected FrameLayout vzb;
    protected LinearLayout vzc;
    protected LinearLayout vzd;
    protected ViewStub vze;
    protected ImageView vzf;
    protected LinearLayout vzg;
    protected ImageView vzh;
    protected TextView vzi;
    protected TextView vzj;
    protected ImageView vzk;
    protected TextView vzl;
    protected TextView vzm;
    protected LinearLayout vzn;
    protected ImageView vzo;
    protected ImageView vzp;
    protected TextView vzq;
    private int vzr = Integer.MAX_VALUE;

    public n(int i) {
        super(i);
    }

    public final n q(View view, boolean z) {
        super.dn(view);
        this.vyp = (MMImageView) view.findViewById(R.h.bzN);
        this.ipw = (TextView) view.findViewById(R.h.bzP);
        this.mys = (TextView) view.findViewById(R.h.bzQ);
        this.ipx = (TextView) view.findViewById(R.h.bzB);
        this.lMU = (TextView) view.findViewById(R.h.bzK);
        this.vyL = (ImageView) view.findViewById(R.h.bzH);
        this.vyN = (TextView) view.findViewById(R.h.bzJ);
        this.vyM = (ImageView) view.findViewById(R.h.bzI);
        this.vyO = (LinearLayout) view.findViewById(R.h.bzG);
        this.vyP = (ImageView) view.findViewById(R.h.bzL);
        this.vyQ = (MMPinProgressBtn) view.findViewById(R.h.bAu);
        this.vyR = (ImageView) this.mil.findViewById(R.h.bAn);
        this.vyS = (ImageView) this.mil.findViewById(R.h.bBz);
        this.vyT = (ImageView) view.findViewById(R.h.bzC);
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.vyV = (ImageView) view.findViewById(R.h.bzF);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vyU = (ChattingItemFooter) view.findViewById(R.h.aTR);
        this.vyW = (LinearLayout) view.findViewById(R.h.bpI);
        this.vyX = (ViewGroup) view.findViewById(R.h.cco);
        this.vyY = (TextView) view.findViewById(R.h.ccm);
        this.vyZ = (LinearLayout) view.findViewById(R.h.bzR);
        this.vzb = (FrameLayout) view.findViewById(R.h.bAe);
        this.vzc = (LinearLayout) view.findViewById(R.h.bzz);
        this.sva = (ImageView) view.findViewById(R.h.bAl);
        this.vza = (RelativeLayout) view.findViewById(R.h.bzM);
        this.vze = (ViewStub) view.findViewById(R.h.coH);
        this.vzf = (ImageView) view.findViewById(R.h.bAq);
        if (!z) {
            this.vyy = (ImageView) this.mil.findViewById(R.h.bBy);
            this.oDJ = (ProgressBar) this.mil.findViewById(R.h.cKX);
        }
        this.vzn = (LinearLayout) view.findViewById(R.h.bzr);
        this.vzo = (ImageView) view.findViewById(R.h.bzs);
        this.vzp = (ImageView) view.findViewById(R.h.bMt);
        this.vzq = (TextView) view.findViewById(R.h.bzu);
        this.vzg = (LinearLayout) view.findViewById(R.h.bzq);
        this.vzh = (ImageView) view.findViewById(R.h.bzo);
        this.vzi = (TextView) view.findViewById(R.h.bzp);
        this.vzj = (TextView) view.findViewById(R.h.bzt);
        this.vzk = (ImageView) view.findViewById(R.h.bzv);
        this.vzl = (TextView) view.findViewById(R.h.bzx);
        this.vzm = (TextView) view.findViewById(R.h.bzw);
        if (this.mys != null && VERSION.SDK_INT >= 16) {
            this.vzr = this.mys.getMaxLines();
        }
        this.vym = ah.eT(ab.getContext());
        return this;
    }

    public final void reset() {
        if (this.mys != null) {
            this.mys.setMaxLines(this.vzr);
        }
    }

    public static void a(n nVar, String str, int i) {
        int Mg = l.Mg(str);
        if (Mg == -1 || Mg >= 100 || i <= 0) {
            nVar.vyQ.setVisibility(8);
            return;
        }
        nVar.vyQ.setVisibility(0);
        nVar.vyQ.setProgress(Mg);
    }

    public static void a(n nVar, final Boolean bool, au auVar, String str, final String str2) {
        final long j = auVar.field_msgId;
        b eb = an.abL().eb(j);
        if (eb == null) {
            w.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j), str2);
            return;
        }
        if (bool.booleanValue()) {
            if (eb.field_status == 101) {
                nVar.vyS.setVisibility(0);
                nVar.vyQ.setVisibility(0);
            } else if (eb.field_status == 102) {
                nVar.vyS.setVisibility(8);
                nVar.vyQ.setVisibility(8);
            } else {
                nVar.vyS.setVisibility(8);
                nVar.vyQ.setVisibility(8);
            }
        } else if (eb.field_status == 101) {
            nVar.vyS.setVisibility(0);
            nVar.vyR.setVisibility(8);
        } else if (eb.field_status == 105) {
            nVar.vyS.setVisibility(8);
            nVar.vyR.setVisibility(0);
        } else {
            nVar.vyS.setVisibility(8);
            nVar.vyR.setVisibility(8);
        }
        if (auVar.field_status == 5) {
            nVar.vyS.setVisibility(8);
            nVar.vyR.setVisibility(8);
        }
        final Boolean bool2 = bool;
        final String str3 = str;
        final String str4 = str2;
        nVar.vyS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String str;
                c eb;
                if (bool2.booleanValue()) {
                    long j = j;
                    str = str4;
                    eb = an.abL().eb(j);
                    if (eb == null) {
                        w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + str);
                        return;
                    } else if (eb.field_status != 101) {
                        w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + str + " status:" + eb.field_status);
                        return;
                    } else {
                        eb.field_status = 102;
                        eb.field_lastModifyTime = bg.Ny();
                        an.abL().c(eb, new String[0]);
                        return;
                    }
                }
                j = j;
                str = str4;
                eb = an.abL().eb(j);
                if (eb == null) {
                    w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + str);
                } else if (eb.field_status != 101) {
                    w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + str + " status:" + eb.field_status);
                } else {
                    if (!bg.mA(eb.field_clientAppDataId) || bg.mA(eb.field_mediaSvrId)) {
                        eb.field_status = 105;
                    } else {
                        eb.field_status = 102;
                    }
                    eb.field_lastModifyTime = bg.Ny();
                    an.abL().c(eb, new String[0]);
                }
            }
        });
        nVar.vyR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!bool.booleanValue()) {
                    long j = j;
                    String str = str2;
                    c eb = an.abL().eb(j);
                    if (eb == null) {
                        w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " getinfo failed: " + str);
                    } else if (eb.field_status != 105) {
                        w.e("MicroMsg.AppMsgLogic", "ERR:" + g.sd() + " get status failed: " + str + " status:" + eb.field_status);
                    } else {
                        eb.field_status = 101;
                        eb.field_lastModifyTime = bg.Ny();
                        an.abL().c(eb, new String[0]);
                        an.bDm().run();
                    }
                }
            }
        });
    }

    static void a(En_5b8fbb1e.a aVar, n nVar, f.a aVar2, boolean z) {
        String str;
        nVar.ipw.setVisibility(8);
        if (aVar2.title == null || aVar2.title.trim().length() <= 0) {
            nVar.mys.setVisibility(8);
            str = null;
        } else {
            str = aVar2.title;
            nVar.mys.setVisibility(0);
            nVar.mys.setMaxLines(2);
        }
        nVar.ipx.setMaxLines(4);
        nVar.vyT.setVisibility(8);
        nVar.vyP.setVisibility(4);
        if (z) {
            nVar.vyp.setVisibility(8);
        }
        com.tencent.mm.sdk.b.b lzVar = new lz();
        lzVar.fTf.type = 0;
        lzVar.fTf.fTh = aVar2.hhQ;
        com.tencent.mm.sdk.b.a.urY.m(lzVar);
        com.tencent.mm.protocal.b.a.c cVar = lzVar.fTg.fTp;
        if (cVar != null) {
            nVar.mys.setText(h.b(nVar.mys.getContext(), bg.ap(cVar.title, aVar2.title), nVar.mys.getTextSize()));
            String str2 = cVar.desc;
            if (str2 == null) {
                w.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", aVar2.hhQ);
            } else {
                str2 = str2.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            if (str2 != null && str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
            nVar.ipx.setText(h.b(nVar.ipx.getContext(), bg.ap(str2, aVar2.description), nVar.ipx.getTextSize()));
            Iterator it = cVar.hkm.iterator();
            str2 = null;
            String str3 = null;
            CharSequence charSequence = str;
            int i = 0;
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                if (bg.mA(rmVar.txx) || !rmVar.txx.equals(".htm") || bg.mA(rmVar.tyk) || !rmVar.tyk.equals("WeNoteHtmlFile")) {
                    if (rmVar.tyc.tyu.tyQ != null) {
                        charSequence = aVar.uSU.uTo.getString(R.l.eIF);
                        i = 1;
                    } else if (rmVar.tyc.tyu.fOu != null) {
                        if (str3 == null) {
                            str3 = rmVar.tye;
                        } else if (str3 != rmVar.tye) {
                            str2 = rmVar.tye;
                        }
                    }
                    switch (rmVar.aMw) {
                        case 1:
                            break;
                        case 2:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.g.bbY);
                            break;
                        case 3:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.k.dtt);
                            break;
                        case 4:
                            if (z) {
                                nVar.vyp.setVisibility(0);
                                nVar.vyp.setImageResource(R.k.dtr);
                            }
                            nVar.vyT.setVisibility(0);
                            nVar.vyT.setImageResource(R.g.bkW);
                            break;
                        case 5:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.k.dtu);
                            break;
                        case 6:
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.k.dtf);
                            break;
                        case 7:
                            if (z) {
                                nVar.vyp.setVisibility(0);
                                nVar.vyp.setImageResource(R.k.dtg);
                            }
                            nVar.vyT.setVisibility(0);
                            nVar.vyT.setImageResource(R.g.bhp);
                            break;
                        case 8:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(com.tencent.mm.pluginsdk.c.LC(rmVar.txx));
                            break;
                        case 10:
                        case 11:
                        case 14:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.k.dto);
                            break;
                        case 16:
                            if (!z) {
                                break;
                            }
                            nVar.vyp.setVisibility(0);
                            nVar.vyp.setImageResource(R.g.bes);
                            break;
                        default:
                            break;
                    }
                }
            }
            if (str3 != null && str2 == null && r1 == 0) {
                charSequence = aVar.uSU.uTo.getString(R.l.ejc, new Object[]{str3});
            } else if (!(str3 == null || str2 == null || str3 == str2 || r1 != 0)) {
                charSequence = aVar.uSU.uTo.getString(R.l.ejb, new Object[]{str3, str2});
            }
        } else {
            Object obj = str;
        }
        if (!bg.mA(charSequence)) {
            nVar.mys.setText(charSequence);
        }
        nVar.vyp.setVisibility(8);
        nVar.vza.setVisibility(8);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(com.tencent.mm.ui.chatting.En_5b8fbb1e.a r22, com.tencent.mm.ui.chatting.n r23, com.tencent.mm.t.f.a r24, com.tencent.mm.storage.au r25, boolean r26) {
        /*
        r2 = new com.tencent.mm.e.a.lz;
        r2.<init>();
        r3 = r2.fTf;
        r4 = 0;
        r3.type = r4;
        r3 = r2.fTf;
        r0 = r24;
        r4 = r0.hhQ;
        r3.fTh = r4;
        r3 = com.tencent.mm.sdk.b.a.urY;
        r3.m(r2);
        r2 = r2.fTg;
        r15 = r2.fTp;
        r0 = r23;
        r2 = r0.vza;
        r3 = 8;
        r2.setVisibility(r3);
        r2 = 4;
        r7 = new java.lang.String[r2];
        r2 = 4;
        r6 = new java.lang.String[r2];
        r2 = 4;
        r8 = new int[r2];
        r2 = 4;
        r10 = new java.lang.String[r2];
        r2 = 4;
        r9 = new java.lang.String[r2];
        r2 = 4;
        r11 = new int[r2];
        r2 = 4;
        r5 = new java.lang.String[r2];
        if (r15 == 0) goto L_0x02d7;
    L_0x003b:
        r12 = 0;
        r2 = r15.desc;
        r0 = r24;
        r3 = r0.description;
        r4 = com.tencent.mm.sdk.platformtools.bg.ap(r2, r3);
        r3 = 0;
        r2 = 0;
        r13 = r15.hkm;
        r14 = r13.iterator();
        r13 = r2;
        r21 = r3;
        r3 = r12;
        r12 = r4;
        r4 = r21;
    L_0x0055:
        r2 = r14.hasNext();
        if (r2 == 0) goto L_0x0160;
    L_0x005b:
        r2 = r14.next();
        r2 = (com.tencent.mm.protocal.c.rm) r2;
        r0 = r2.txx;
        r16 = r0;
        r16 = com.tencent.mm.sdk.platformtools.bg.mA(r16);
        if (r16 != 0) goto L_0x008f;
    L_0x006b:
        r0 = r2.txx;
        r16 = r0;
        r17 = ".htm";
        r16 = r16.equals(r17);
        if (r16 == 0) goto L_0x008f;
    L_0x0078:
        r0 = r2.tyk;
        r16 = r0;
        r16 = com.tencent.mm.sdk.platformtools.bg.mA(r16);
        if (r16 != 0) goto L_0x008f;
    L_0x0082:
        r0 = r2.tyk;
        r16 = r0;
        r17 = "WeNoteHtmlFile";
        r16 = r16.equals(r17);
        if (r16 != 0) goto L_0x0055;
    L_0x008f:
        r0 = r2.aMw;
        r16 = r0;
        switch(r16) {
            case 1: goto L_0x0099;
            case 2: goto L_0x00d8;
            case 3: goto L_0x0055;
            case 4: goto L_0x0096;
            case 5: goto L_0x0096;
            case 6: goto L_0x0055;
            case 7: goto L_0x0096;
            case 8: goto L_0x0138;
            default: goto L_0x0096;
        };
    L_0x0096:
        r2 = r12;
    L_0x0097:
        r12 = r2;
        goto L_0x0055;
    L_0x0099:
        if (r4 != 0) goto L_0x0096;
    L_0x009b:
        r0 = r2.desc;
        r16 = r0;
        r17 = com.tencent.mm.sdk.platformtools.bg.mA(r16);
        if (r17 != 0) goto L_0x0096;
    L_0x00a5:
        r4 = "\n";
        r17 = "";
        r0 = r16;
        r1 = r17;
        r4 = r0.replaceAll(r4, r1);
        r4 = r4.trim();
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r4 != 0) goto L_0x0390;
    L_0x00bd:
        r2 = r2.desc;
        r3 = "&lt;";
        r4 = "<";
        r2 = r2.replaceAll(r3, r4);
        r3 = "&gt;";
        r4 = ">";
        r2 = r2.replaceAll(r3, r4);
    L_0x00d3:
        r3 = 1;
        r4 = r3;
        r3 = r2;
        goto L_0x0055;
    L_0x00d8:
        if (r26 == 0) goto L_0x00fb;
    L_0x00da:
        r0 = r23;
        r0 = r0.vza;
        r16 = r0;
        r17 = 0;
        r16.setVisibility(r17);
        r0 = r23;
        r0 = r0.vyp;
        r16 = r0;
        r17 = 0;
        r16.setVisibility(r17);
        r0 = r23;
        r0 = r0.vyp;
        r16 = r0;
        r17 = com.tencent.mm.R.g.bbY;
        r16.setImageResource(r17);
    L_0x00fb:
        r16 = 4;
        r0 = r16;
        if (r13 >= r0) goto L_0x0133;
    L_0x0101:
        r0 = r2.hhy;
        r16 = r0;
        r7[r13] = r16;
        r0 = r2.txe;
        r16 = r0;
        r6[r13] = r16;
        r0 = r2.txO;
        r16 = r0;
        r0 = r16;
        r0 = (int) r0;
        r16 = r0;
        r8[r13] = r16;
        r0 = r2.txi;
        r16 = r0;
        r10[r13] = r16;
        r0 = r2.txk;
        r16 = r0;
        r9[r13] = r16;
        r0 = r2.txD;
        r16 = r0;
        r0 = r16;
        r0 = (int) r0;
        r16 = r0;
        r11[r13] = r16;
        r2 = r2.lKv;
        r5[r13] = r2;
    L_0x0133:
        r2 = r13 + 1;
        r13 = r2;
        goto L_0x0055;
    L_0x0138:
        r16 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
        if (r16 == 0) goto L_0x0096;
    L_0x013e:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r16 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r17 = com.tencent.mm.R.l.dHn;
        r16 = r16.getString(r17);
        r0 = r16;
        r12 = r12.append(r0);
        r2 = r2.title;
        r2 = r12.append(r2);
        r12 = r2.toString();
        r2 = r12;
        goto L_0x0097;
    L_0x0160:
        r2 = 0;
        if (r3 == 0) goto L_0x0340;
    L_0x0163:
        r14 = "\n";
        r16 = 2;
        r0 = r16;
        r16 = r3.split(r14, r0);
        r17 = new java.util.ArrayList;
        r17.<init>();
        r0 = r16;
        r14 = r0.length;
        if (r14 <= 0) goto L_0x0194;
    L_0x0178:
        r0 = r16;
        r0 = r0.length;
        r18 = r0;
        r14 = 0;
    L_0x017e:
        r0 = r18;
        if (r14 >= r0) goto L_0x0194;
    L_0x0182:
        r19 = r16[r14];
        r20 = r19.length();
        if (r20 <= 0) goto L_0x0191;
    L_0x018a:
        r0 = r17;
        r1 = r19;
        r0.add(r1);
    L_0x0191:
        r14 = r14 + 1;
        goto L_0x017e;
    L_0x0194:
        r14 = r17.size();
        r16 = 1;
        r0 = r16;
        if (r14 != r0) goto L_0x038d;
    L_0x019e:
        r2 = 1;
        r14 = r2;
    L_0x01a0:
        r2 = r17.size();
        r16 = 1;
        r0 = r16;
        if (r2 != r0) goto L_0x02d8;
    L_0x01aa:
        r2 = r15.hkm;
        r2 = r2.size();
        r15 = 2;
        if (r2 != r15) goto L_0x02d8;
    L_0x01b3:
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r12 = com.tencent.mm.R.l.ejP;
        r2 = r2.getString(r12);
    L_0x01bd:
        r2 = r2.trim();
    L_0x01c1:
        if (r2 == 0) goto L_0x01d7;
    L_0x01c3:
        r12 = "&lt;";
        r15 = "<";
        r2 = r2.replaceAll(r12, r15);
        r12 = "&gt;";
        r15 = ">";
        r2 = r2.replaceAll(r12, r15);
    L_0x01d7:
        r0 = r23;
        r12 = r0.mys;
        r12 = r12.getContext();
        r0 = r23;
        r15 = r0.mys;
        r15 = r15.getTextSize();
        r15 = (int) r15;
        r2 = com.tencent.mm.pluginsdk.ui.d.h.c(r12, r2, r15);
        r0 = r23;
        r12 = r0.mys;
        r12.setText(r2);
        if (r3 == 0) goto L_0x038a;
    L_0x01f5:
        r2 = r3.length();
        r12 = 100;
        if (r2 <= r12) goto L_0x038a;
    L_0x01fd:
        r2 = 0;
        r12 = 100;
        r2 = r3.substring(r2, r12);
        r3 = "&lt;";
        r12 = "<";
        r2 = r2.replaceAll(r3, r12);
        r3 = "&gt;";
        r12 = ">";
        r2 = r2.replaceAll(r3, r12);
    L_0x0218:
        r0 = r23;
        r3 = r0.ipx;
        r3 = r3.getContext();
        r0 = r23;
        r12 = r0.ipx;
        r12 = r12.getTextSize();
        r12 = (int) r12;
        r2 = com.tencent.mm.pluginsdk.ui.d.h.c(r3, r2, r12);
        r0 = r23;
        r3 = r0.ipx;
        r3.setText(r2);
        if (r13 <= 0) goto L_0x0377;
    L_0x0236:
        r0 = r23;
        r2 = r0.vza;
        r3 = 8;
        r2.setVisibility(r3);
        if (r14 != 0) goto L_0x0243;
    L_0x0241:
        if (r4 != 0) goto L_0x034f;
    L_0x0243:
        r0 = r23;
        r2 = r0.ipx;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.mys;
        r3 = 2;
        r2.setMaxLines(r3);
    L_0x0254:
        r0 = r23;
        r2 = r0.vzf;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.vze;
        r3 = com.tencent.mm.R.i.cYe;
        r2.setLayoutResource(r3);
        r0 = r23;
        r2 = r0.vze;	 Catch:{ Exception -> 0x0369 }
        r2 = r2.inflate();	 Catch:{ Exception -> 0x0369 }
        r2 = (android.widget.LinearLayout) r2;	 Catch:{ Exception -> 0x0369 }
        r0 = r23;
        r0.vzd = r2;	 Catch:{ Exception -> 0x0369 }
    L_0x0274:
        r2 = 4;
        if (r13 <= r2) goto L_0x0374;
    L_0x0277:
        r4 = 4;
    L_0x0278:
        r0 = r25;
        r12 = r0.field_talker;
        r2 = r22;
        r3 = r23;
        a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        r0 = r23;
        r2 = r0.vzd;
        r3 = com.tencent.mm.R.h.bBj;
        r2 = r2.findViewById(r3);
        r2 = (android.widget.ImageView) r2;
        r0 = r23;
        r3 = r0.vzd;
        r4 = com.tencent.mm.R.h.bBd;
        r3 = r3.findViewById(r4);
        r3 = (android.widget.TextView) r3;
        r4 = 0;
        r5 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = r5.getResources();
        r6 = com.tencent.mm.R.f.aXI;
        r5 = r5.getDimensionPixelSize(r6);
        r5 = (float) r5;
        r3.setTextSize(r4, r5);
        r4 = 4;
        if (r13 <= r4) goto L_0x02d7;
    L_0x02b1:
        if (r2 == 0) goto L_0x02b7;
    L_0x02b3:
        r4 = 0;
        r2.setVisibility(r4);
    L_0x02b7:
        if (r3 == 0) goto L_0x02d7;
    L_0x02b9:
        r2 = new java.lang.StringBuilder;
        r4 = "(";
        r2.<init>(r4);
        r2 = r2.append(r13);
        r4 = ")";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.setText(r2);
        r2 = 0;
        r3.setVisibility(r2);
    L_0x02d7:
        return;
    L_0x02d8:
        if (r13 <= 0) goto L_0x02f8;
    L_0x02da:
        r2 = 0;
        r0 = r17;
        r2 = r0.get(r2);
        r2 = (java.lang.String) r2;
        r3 = r17.size();
        r12 = 1;
        if (r3 <= r12) goto L_0x02f5;
    L_0x02ea:
        r3 = 1;
        r0 = r17;
        r3 = r0.get(r3);
        r3 = (java.lang.String) r3;
        goto L_0x01bd;
    L_0x02f5:
        r3 = 0;
        goto L_0x01bd;
    L_0x02f8:
        r2 = 0;
        r0 = r17;
        r2 = r0.get(r2);
        r2 = (java.lang.String) r2;
        r3 = java.util.regex.Pattern.quote(r2);
        r15 = 2;
        r12 = r12.split(r3, r15);
        r3 = 0;
        r3 = r12[r3];
        r3 = r3.trim();
        r15 = r12.length;
        r16 = 1;
        r0 = r16;
        if (r15 <= r0) goto L_0x01bd;
    L_0x0318:
        r3 = new java.lang.StringBuilder;
        r15 = 0;
        r15 = r12[r15];
        r15 = r15.trim();
        r3.<init>(r15);
        r15 = "\n";
        r3 = r3.append(r15);
        r15 = 1;
        r12 = r12[r15];
        r12 = r12.trim();
        r3 = r3.append(r12);
        r3 = r3.toString();
        r3 = r3.trim();
        goto L_0x01bd;
    L_0x0340:
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r14 = com.tencent.mm.R.l.ejP;
        r3 = r3.getString(r14);
        r14 = r2;
        r2 = r3;
        r3 = r12;
        goto L_0x01c1;
    L_0x034f:
        r0 = r23;
        r2 = r0.ipx;
        r3 = 1;
        r2.setMaxLines(r3);
        r0 = r23;
        r2 = r0.ipx;
        r3 = 0;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.mys;
        r3 = 1;
        r2.setMaxLines(r3);
        goto L_0x0254;
    L_0x0369:
        r2 = move-exception;
        r0 = r23;
        r2 = r0.vze;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x0274;
    L_0x0374:
        r4 = r13;
        goto L_0x0278;
    L_0x0377:
        r0 = r23;
        r2 = r0.vze;
        r3 = 8;
        r2.setVisibility(r3);
        r0 = r23;
        r2 = r0.vzf;
        r3 = 0;
        r2.setVisibility(r3);
        goto L_0x02d7;
    L_0x038a:
        r2 = r3;
        goto L_0x0218;
    L_0x038d:
        r14 = r2;
        goto L_0x01a0;
    L_0x0390:
        r2 = r3;
        goto L_0x00d3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.n.a(com.tencent.mm.ui.chatting.En_5b8fbb1e$a, com.tencent.mm.ui.chatting.n, com.tencent.mm.t.f$a, com.tencent.mm.storage.au, boolean):void");
    }

    private static void a(En_5b8fbb1e.a aVar, n nVar, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
        for (int i2 = 0; i2 <= 4; i2++) {
            MMImageView mMImageView = (MMImageView) nVar.vzd.findViewById(lMZ[i2]);
            if (mMImageView != null) {
                mMImageView.setImageDrawable(null);
                mMImageView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) nVar.vzd.findViewById(R.h.bBj);
        TextView textView = (TextView) nVar.vzd.findViewById(R.h.bBd);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i == 1) {
                mMImageView = (MMImageView) nVar.vzd.findViewById(lMZ[i3]);
                mMImageView.setImageResource(R.k.dvI);
            } else {
                mMImageView = (MMImageView) nVar.vzd.findViewById(lMZ[i3 + 1]);
                mMImageView.setImageResource(R.k.dvH);
            }
            mMImageView.setVisibility(0);
            an.bDj().a(aVar.vBD, strArr[i3], bg.Nz(), strArr2[i3], strArr3[i3], iArr[i3], str);
            String m = com.tencent.mm.ah.n.GS().m("Note_" + strArr[i3], "", "");
            Bitmap a;
            if (FileOp.aO(m)) {
                a = com.tencent.mm.ah.n.GS().a(m, com.tencent.mm.bg.a.getDensity(ab.getContext()));
                if (a == null || a.isRecycled()) {
                    mMImageView.setImageResource(R.k.dvH);
                } else {
                    mMImageView.setImageBitmap(a);
                }
            } else {
                an.bDj().a(aVar.vBD, strArr[i3], bg.Nz(), strArr4[i3], strArr5[i3], iArr2[i3], str);
                com.tencent.mm.ah.n.GS().m("Note_" + strArr[i3], "", "");
                com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, 45);
                if (FileOp.aO(m)) {
                    a = com.tencent.mm.ah.n.GS().a(m, com.tencent.mm.bg.a.getDensity(ab.getContext()));
                    if (a == null || a.isRecycled()) {
                        mMImageView.setImageResource(R.k.dvH);
                    } else {
                        mMImageView.setImageBitmap(a);
                    }
                } else {
                    w.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                }
            }
        }
    }
}
