package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.widget.MMTextView;

final class es extends com.tencent.mm.ui.chatting.ah.a {
    TextView suV;
    TextView vOQ;
    TextView vOR;
    TextView vOS;
    AnimImageView vOT;
    AnimImageView vOU;
    LinearLayout vOV;
    LinearLayout vOW;
    MMTextView vOX;
    ProgressBar vOY;
    FrameLayout vOZ;
    FrameLayout vPa;
    FrameLayout vPb;
    ImageView vPc;
    AnimImageView vPd;
    ProgressBar vPe;
    TextView vPf;
    Animation vPg;
    TextView vyE;
    ImageView vyy;

    public enum a {
        NoTransform,
        PreTransform,
        Transforming,
        Transformed
    }

    public es(int i) {
        super(i);
    }

    public final com.tencent.mm.ui.chatting.ah.a s(View view, boolean z) {
        super.dn(view);
        this.kxi = (TextView) view.findViewById(R.h.bBA);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vOR = (TextView) view.findViewById(R.h.bBO);
        this.vOS = (TextView) view.findViewById(R.h.bBP);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.vyK = (ImageView) view.findViewById(R.h.bBw);
        this.suV = (TextView) view.findViewById(R.h.bAi);
        this.vOZ = (FrameLayout) view.findViewById(R.h.bBQ);
        this.vPa = (FrameLayout) view.findViewById(R.h.bBR);
        this.vOV = (LinearLayout) view.findViewById(R.h.bBS);
        this.vOW = (LinearLayout) view.findViewById(R.h.bBT);
        this.vOX = (MMTextView) view.findViewById(R.h.bBU);
        this.vOY = (ProgressBar) view.findViewById(R.h.bBV);
        this.vOQ = (TextView) view.findViewById(R.h.bBM);
        this.vOT = (AnimImageView) view.findViewById(R.h.bBK);
        this.vOU = (AnimImageView) view.findViewById(R.h.bBL);
        this.vOT.setType(1);
        this.vOU.setType(2);
        if (z) {
            this.type = 6;
            this.vOT.vgp = true;
            this.vOU.vgp = true;
            this.vyE = (TextView) view.findViewById(R.h.bzy);
            this.vPd = (AnimImageView) view.findViewById(R.h.bBN);
            this.vPd.vgp = true;
            this.vPd.setType(0);
        } else {
            this.vPb = (FrameLayout) view.findViewById(R.h.bBW);
            this.vPc = (ImageView) view.findViewById(R.h.bBX);
            this.vPe = (ProgressBar) view.findViewById(R.h.bBY);
            this.oDJ = (ProgressBar) view.findViewById(R.h.cKX);
            this.vPf = (TextView) view.findViewById(R.h.bBZ);
            this.vOT.vgp = false;
            this.vOU.vgp = false;
            this.type = 7;
            this.vyy = (ImageView) view.findViewById(R.h.bBy);
        }
        return this;
    }

    public static void a(es esVar, au auVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, boolean z) {
        if (esVar != null) {
            float f;
            dt dtVar;
            String str;
            com.tencent.mm.ui.a.a aVar2;
            View view;
            int i2;
            n nVar = new n(auVar.field_content);
            float aw = q.aw(nVar.time);
            if (aVar.vBD.vES == null || auVar.field_msgId != aVar.vBD.vES.vzC) {
                esVar.vOU.setVisibility(8);
                esVar.vOT.setVisibility(8);
                esVar.vOT.aWX();
                esVar.vOU.aWX();
            } else {
                esVar.vOT.setVisibility(0);
                esVar.vOU.setVisibility(0);
                esVar.vOT.bRB();
                esVar.vOU.bRB();
            }
            if (auVar.field_isSend == 0) {
                if (nVar.time == 0) {
                    a(esVar, 8, 0, true, auVar.bMA());
                    esVar.vPd.aWX();
                    esVar.vPd.setVisibility(8);
                    esVar.vyK.setVisibility(8);
                    aw = 0.0f;
                    esVar.vOR.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ(0)));
                    esVar.suV.setText(aVar.getString(R.l.ema, Integer.valueOf(0)));
                    esVar.vOT.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ(0)));
                } else if (nVar.time == -1) {
                    a(esVar, 8, 0, true, auVar.bMA());
                    esVar.vPd.aWX();
                    esVar.vPd.setVisibility(8);
                    esVar.vOR.setWidth(80);
                    esVar.suV.setVisibility(8);
                    esVar.vOT.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                } else {
                    a(esVar, 8, 0, true, auVar.bMA());
                    esVar.vPd.aWX();
                    esVar.vPd.setVisibility(8);
                    esVar.suV.setVisibility(0);
                    esVar.vOR.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                    esVar.suV.setText(aVar.getString(R.l.ema, Integer.valueOf((int) aw)));
                    esVar.vOT.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                }
            }
            if (1 == auVar.field_isSend) {
                if (auVar.field_status == 1) {
                    a(esVar, 0, 8, false, auVar.bMA());
                    esVar.vPb.setVisibility(8);
                    esVar.bWr();
                    f = aw;
                } else if (nVar.time == -1) {
                    a(esVar, 8, 0, false, auVar.bMA());
                    esVar.vOR.setWidth(80);
                    esVar.suV.setVisibility(8);
                    esVar.vPb.setVisibility(8);
                    esVar.vOT.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                    esVar.bWr();
                    f = aw;
                } else if (auVar.field_status == 7) {
                    a(esVar, 8, 8, false, auVar.bMA());
                    esVar.suV.setVisibility(8);
                    esVar.vPb.setVisibility(0);
                    esVar.bWr();
                    if (esVar.vPc != null) {
                        esVar.vPg = AnimationUtils.loadAnimation(esVar.mil.getContext(), R.a.aRV);
                        esVar.vPc.startAnimation(esVar.vPg);
                    }
                    f = aw;
                } else {
                    a(esVar, 8, 0, false, auVar.bMA());
                    esVar.vPb.setVisibility(8);
                    esVar.suV.setVisibility(0);
                    esVar.bWr();
                    if (nVar.time == 0) {
                        aw = 0.0f;
                    }
                    esVar.vOR.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                    esVar.suV.setText(aVar.getString(R.l.ema, Integer.valueOf((int) aw)));
                    esVar.vOT.setWidth(com.tencent.mm.bg.a.fromDPToPix(aVar.uSU.uTo, jZ((int) aw)));
                }
                if (aVar.vBD.oKg != null) {
                    esVar.suV.setTextColor(aVar.vBD.oKg.sIu);
                    if (aVar.vBD.oKg.sIv) {
                        esVar.suV.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    } else {
                        esVar.suV.setShadowLayer(2.0f, 1.2f, 1.2f, aVar.vBD.oKg.sIw);
                    }
                    if (aVar.vBD.oKg.sIx) {
                        esVar.suV.setBackgroundColor(0);
                    } else {
                        esVar.suV.setBackgroundResource(R.g.bei);
                    }
                }
                dtVar = new dt(auVar, aVar.vxp, i, null, 0, (byte) 0);
                esVar.vOR.setTag(dtVar);
                esVar.vOS.setTag(dtVar);
                esVar.vOR.setOnClickListener(aVar.vBD.vEW);
                esVar.vOS.setOnClickListener(aVar.vBD.vEW);
                esVar.vOR.setOnLongClickListener(aVar.vBD.vEY);
                esVar.vOR.setOnTouchListener(aVar.vBD.vFa);
                esVar.vOS.setOnLongClickListener(aVar.vBD.vEY);
                esVar.vOS.setOnTouchListener(aVar.vBD.vFa);
                esVar.vOX.setTag(dtVar);
                esVar.vOX.setOnClickListener(null);
                esVar.vOX.wwK = aVar.vBD.vFc;
                esVar.vOX.setOnLongClickListener(aVar.vBD.vEY);
                esVar.vOX.setOnTouchListener(aVar.vBD.vFa);
                if ((auVar.gxE & 1) != 1) {
                    esVar.vOQ.setVisibility(0);
                    if (auVar.field_isSend != 0) {
                        esVar.vOT.setBackgroundResource(R.g.bdZ);
                        esVar.vOU.setBackgroundResource(R.g.bdZ);
                    } else {
                        esVar.vPf.setBackgroundResource(R.g.bel);
                        esVar.vOT.setBackgroundResource(R.g.bel);
                        esVar.vOU.setBackgroundResource(R.g.bel);
                    }
                } else {
                    esVar.vOQ.setVisibility(8);
                    if (auVar.field_isSend != 0) {
                        esVar.vOT.setBackgroundResource(R.g.bdT);
                    } else {
                        esVar.vPf.setBackgroundResource(R.g.bej);
                        esVar.vOT.setBackgroundResource(R.g.bej);
                    }
                }
                if (z) {
                    str = aVar.vBD.hrM;
                } else {
                    str = aVar.vBD.fJL;
                }
                aVar2 = a.uWW;
                view = esVar.vOR;
                i2 = (int) f;
                aVar.eK(str);
                aVar2.F(view, i2);
                aVar2 = a.uWW;
                view = esVar.vOS;
                i2 = (int) f;
                aVar.eK(str);
                aVar2.F(view, i2);
                esVar.suV.setContentDescription(" ");
            }
            f = aw;
            if (aVar.vBD.oKg != null) {
                esVar.suV.setTextColor(aVar.vBD.oKg.sIu);
                if (aVar.vBD.oKg.sIv) {
                    esVar.suV.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                } else {
                    esVar.suV.setShadowLayer(2.0f, 1.2f, 1.2f, aVar.vBD.oKg.sIw);
                }
                if (aVar.vBD.oKg.sIx) {
                    esVar.suV.setBackgroundColor(0);
                } else {
                    esVar.suV.setBackgroundResource(R.g.bei);
                }
            }
            dtVar = new dt(auVar, aVar.vxp, i, null, 0, (byte) 0);
            esVar.vOR.setTag(dtVar);
            esVar.vOS.setTag(dtVar);
            esVar.vOR.setOnClickListener(aVar.vBD.vEW);
            esVar.vOS.setOnClickListener(aVar.vBD.vEW);
            esVar.vOR.setOnLongClickListener(aVar.vBD.vEY);
            esVar.vOR.setOnTouchListener(aVar.vBD.vFa);
            esVar.vOS.setOnLongClickListener(aVar.vBD.vEY);
            esVar.vOS.setOnTouchListener(aVar.vBD.vFa);
            esVar.vOX.setTag(dtVar);
            esVar.vOX.setOnClickListener(null);
            esVar.vOX.wwK = aVar.vBD.vFc;
            esVar.vOX.setOnLongClickListener(aVar.vBD.vEY);
            esVar.vOX.setOnTouchListener(aVar.vBD.vFa);
            if ((auVar.gxE & 1) != 1) {
                esVar.vOQ.setVisibility(8);
                if (auVar.field_isSend != 0) {
                    esVar.vPf.setBackgroundResource(R.g.bej);
                    esVar.vOT.setBackgroundResource(R.g.bej);
                } else {
                    esVar.vOT.setBackgroundResource(R.g.bdT);
                }
            } else {
                esVar.vOQ.setVisibility(0);
                if (auVar.field_isSend != 0) {
                    esVar.vPf.setBackgroundResource(R.g.bel);
                    esVar.vOT.setBackgroundResource(R.g.bel);
                    esVar.vOU.setBackgroundResource(R.g.bel);
                } else {
                    esVar.vOT.setBackgroundResource(R.g.bdZ);
                    esVar.vOU.setBackgroundResource(R.g.bdZ);
                }
            }
            if (z) {
                str = aVar.vBD.hrM;
            } else {
                str = aVar.vBD.fJL;
            }
            aVar2 = a.uWW;
            view = esVar.vOR;
            i2 = (int) f;
            aVar.eK(str);
            aVar2.F(view, i2);
            aVar2 = a.uWW;
            view = esVar.vOS;
            i2 = (int) f;
            aVar.eK(str);
            aVar2.F(view, i2);
            esVar.suV.setContentDescription(" ");
        }
    }

    private void bWr() {
        if (this.vPg != null) {
            this.vPg.cancel();
            this.vPg = null;
        }
    }

    private static void a(es esVar, int i, int i2, boolean z, boolean z2) {
        esVar.vyK.setVisibility(i2);
        esVar.suV.setVisibility(i2);
        if (z) {
            esVar.vPd.setVisibility(i);
            esVar.vyE.setVisibility(i2);
        } else {
            esVar.vPf.setVisibility(i);
        }
        if (i2 != 0) {
            esVar.vOZ.setVisibility(8);
            esVar.vOV.setVisibility(8);
            esVar.vOY.setVisibility(8);
        } else if (z2) {
            esVar.vOZ.setVisibility(8);
            esVar.vOV.setVisibility(0);
            esVar.vOY.setVisibility(0);
        } else {
            esVar.vOZ.setVisibility(0);
            esVar.vOV.setVisibility(8);
            esVar.vOY.setVisibility(8);
        }
    }

    private static int jZ(int i) {
        if (i <= 2) {
            return 80;
        }
        if (i < 10) {
            return ((i - 2) * 9) + 80;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 9) + 80;
        }
        return ao.CTRL_INDEX;
    }
}
