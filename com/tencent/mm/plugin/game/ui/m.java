package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.k;
import java.util.LinkedList;

public final class m extends k<q> {
    private static w mCH;
    private int fCK = 0;
    int hOI = 0;
    int kor = 15;
    private OnClickListener mCI;
    private OnClickListener mCJ;
    private v mCK;
    private v mCL;
    private long mCM = 0;
    private int mCN = 0;
    private r mCO;
    private f<String, Bitmap> mCP;
    private Context mContext;
    private int mqT = 0;

    static class a {
        public TextView jWd;
        public TextView jbV;
        public LinearLayout mCR;
        public ImageView mCS;
        public LinearLayout mCT;
        public ImageView mCU;
        public TextView mCV;
        public LinearLayout mCW;
        public TextView mCX;
        public ImageView mCY;
        public ImageView mCZ;
        public TextView mDa;
        public TextView mDc;
        public LinearLayout mDd;
        public GameMessageListContainerView mDe;

        a() {
        }
    }

    protected final /* bridge */ /* synthetic */ Object aBW() {
        return (q) this.uSL;
    }

    public final /* synthetic */ Object getItem(int i) {
        return nK(i);
    }

    public m(Context context, q qVar, int i) {
        int i2 = 0;
        super(context, qVar);
        this.mContext = context;
        this.mqT = i;
        Cursor rawQuery = SubCoreGameCenter.aBB().rawQuery("select count(*) from GameRawMessage where " + u.l(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        this.hOI = i2;
        this.fCK = SubCoreGameCenter.aBB().aAY();
        mCH = new w();
        this.mCI = new n(context, i);
        this.mCJ = new o(context, i);
        this.mCK = new v(context);
        this.mCK.cg(i, 1);
        this.mCL = new v(context);
        this.mCL.cg(i, 2);
        this.mCO = new r(context, this.mqT);
        i2 = c.getScreenWidth(this.mContext);
        this.mCN = com.tencent.mm.bg.a.W(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(R.f.aWG) * 2)) - this.mContext.getResources().getDimensionPixelSize(R.f.aXm)) - this.mContext.getResources().getDimensionPixelSize(R.f.aXz)) / 34;
        this.mCP = new f(30);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.context, R.i.dfa, null);
            aVar.mCS = (ImageView) view.findViewById(R.h.bWx);
            aVar.mCR = (LinearLayout) view.findViewById(R.h.clo);
            aVar.mCT = (LinearLayout) view.findViewById(R.h.clr);
            aVar.jWd = (TextView) view.findViewById(R.h.cof);
            aVar.mCU = (ImageView) view.findViewById(R.h.brn);
            aVar.jbV = (TextView) view.findViewById(R.h.cIS);
            aVar.mCV = (TextView) view.findViewById(R.h.clt);
            aVar.mCW = (LinearLayout) view.findViewById(R.h.clw);
            aVar.mCX = (TextView) view.findViewById(R.h.cly);
            aVar.mCY = (ImageView) view.findViewById(R.h.clx);
            aVar.mCZ = (ImageView) view.findViewById(R.h.clu);
            aVar.mDa = (TextView) view.findViewById(R.h.clA);
            aVar.mDc = (TextView) view.findViewById(R.h.clz);
            aVar.mDe = (GameMessageListContainerView) view.findViewById(R.h.clC);
            aVar.mDd = (LinearLayout) view.findViewById(R.h.cls);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        q nK = nK(i);
        if (nK == null || !nK.mqC) {
            if (nK != null) {
                nK.aAN();
                aVar.mCR.setVisibility(0);
                aVar.mDd.setVisibility(8);
                aVar.mDa.setText(b.f(this.context, nK.field_createTime * 1000));
                CharSequence charSequence;
                h hVar;
                if (nK.field_msgType != 100) {
                    Object obj;
                    int size;
                    String str;
                    aVar.jbV.setVisibility(8);
                    aVar.mCV.setVisibility(8);
                    aVar.mCW.setVisibility(8);
                    aVar.mCY.setVisibility(8);
                    aVar.mCZ.setVisibility(8);
                    aVar.mDc.setVisibility(8);
                    aVar.mDc.setEnabled(false);
                    aVar.mCZ.setEnabled(false);
                    aVar.mCS.setEnabled(false);
                    aVar.jWd.setEnabled(false);
                    aVar.mDe.setVisibility(8);
                    aVar.mCU.setVisibility(8);
                    charSequence = null;
                    if (!bg.bV(nK.mpP)) {
                        hVar = (h) nK.mpP.get(0);
                        ap.yY();
                        x Rc = com.tencent.mm.u.c.wR().Rc(hVar.userName);
                        if (Rc != null) {
                            charSequence = Rc.tL();
                        }
                        if (bg.mA(charSequence)) {
                            charSequence = hVar.aIO;
                        }
                        if (!bg.mA(hVar.mqO)) {
                            obj = 1;
                            size = nK.mpP.size();
                            if (!bg.mA(nK.mpN) && (nK.mqd & 1) == 0) {
                                aVar.mDc.setText(nK.mpN);
                                aVar.mDc.setVisibility(0);
                                if ((nK.mqd & 2) <= 0) {
                                    aVar.mDc.setTextColor(this.context.getResources().getColor(R.e.aTW));
                                    aVar.mDc.setBackgroundResource(R.g.bfq);
                                    aVar.mDc.setOnClickListener(this.mCI);
                                    aVar.mDc.setTag(nK);
                                    aVar.mDc.setEnabled(true);
                                } else {
                                    aVar.mDc.setTextColor(this.context.getResources().getColor(R.e.aTU));
                                    aVar.mDc.setBackgroundResource(0);
                                    aVar.mDc.setOnClickListener(null);
                                    aVar.mDc.setEnabled(false);
                                }
                            }
                            if (nK.field_msgType != 10 || nK.field_msgType == 11) {
                                if (!bg.mA(nK.iQO)) {
                                    aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.iQO, aVar.jWd.getTextSize()), BufferType.SPANNABLE);
                                    aVar.jWd.setVisibility(0);
                                } else if (bg.mA(charSequence)) {
                                    aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, charSequence, aVar.jWd.getTextSize()));
                                    aVar.jWd.setVisibility(0);
                                } else {
                                    aVar.jWd.setVisibility(8);
                                }
                            } else if (bg.mA(charSequence)) {
                                aVar.jWd.setVisibility(8);
                            } else {
                                aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, charSequence, aVar.jWd.getTextSize()));
                                aVar.jWd.setVisibility(0);
                                if (obj != null) {
                                    aVar.jWd.setOnClickListener(this.mCK);
                                    aVar.jWd.setTag(nK);
                                    aVar.jWd.setEnabled(true);
                                }
                            }
                            switch (nK.field_msgType) {
                                case 2:
                                    d(aVar.mCS, nK.mpJ);
                                    str = "礼物";
                                    if (nK.mqa.contains("爱心")) {
                                        str = "爱心";
                                    } else if (nK.mqa.contains("体力")) {
                                        str = "体力";
                                    }
                                    if (size <= 1) {
                                        aVar.jbV.setText(this.context.getResources().getString(R.l.epl, new Object[]{String.valueOf(size), str}));
                                    } else {
                                        aVar.jbV.setText(this.context.getResources().getString(R.l.epm, new Object[]{str}));
                                    }
                                    aVar.jbV.setVisibility(0);
                                    a(nK, aVar);
                                    break;
                                case 5:
                                    if (bg.bV(nK.mpP)) {
                                        aVar.mCS.setVisibility(0);
                                        if (bg.mA(((h) nK.mpP.get(0)).mqN)) {
                                            d(aVar.mCS, ((h) nK.mpP.get(0)).mqN);
                                        } else {
                                            b(aVar.mCS, ((h) nK.mpP.get(0)).userName);
                                        }
                                        if (!bg.mA(((h) nK.mpP.get(0)).mqO)) {
                                            aVar.mCS.setOnClickListener(this.mCL);
                                            aVar.mCS.setTag(nK);
                                            aVar.mCS.setEnabled(true);
                                        }
                                    } else {
                                        aVar.mCS.setVisibility(8);
                                    }
                                    if (size <= 1) {
                                        aVar.jbV.setText(this.context.getResources().getString(R.l.epj, new Object[]{String.valueOf(size)}));
                                        a(nK, aVar);
                                    } else {
                                        aVar.jbV.setText(this.context.getResources().getString(R.l.epk));
                                    }
                                    aVar.mCW.setVisibility(0);
                                    aVar.jbV.setVisibility(0);
                                    aVar.mCX.setText(nK.mql);
                                    aVar.mCW.setOnClickListener(this.mCJ);
                                    aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                                    if (!bg.mA(nK.mqn)) {
                                        aVar.mCY.setVisibility(0);
                                        d(aVar.mCY, nK.mqn);
                                        break;
                                    }
                                    break;
                                case 6:
                                    if (bg.bV(nK.mpP)) {
                                        aVar.mCS.setVisibility(0);
                                        if (bg.mA(((h) nK.mpP.get(0)).mqN)) {
                                            d(aVar.mCS, ((h) nK.mpP.get(0)).mqN);
                                        } else {
                                            b(aVar.mCS, ((h) nK.mpP.get(0)).userName);
                                        }
                                        if (!bg.mA(((h) nK.mpP.get(0)).mqO)) {
                                            aVar.mCS.setOnClickListener(this.mCL);
                                            aVar.mCS.setTag(nK);
                                            aVar.mCS.setEnabled(true);
                                        }
                                    } else {
                                        aVar.mCS.setVisibility(8);
                                    }
                                    aVar.mCW.setVisibility(0);
                                    aVar.mCW.setOnClickListener(this.mCJ);
                                    aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                                    if (nK.mqx == 1) {
                                        if (nK.mqx == 2) {
                                            if (nK.mqx == 3) {
                                                aVar.jbV.setVisibility(0);
                                                if (size <= 1) {
                                                    aVar.jbV.setText(this.context.getResources().getString(R.l.eph, new Object[]{String.valueOf(size)}));
                                                    a(nK, aVar);
                                                } else {
                                                    aVar.jbV.setText(this.context.getResources().getString(R.l.epi));
                                                }
                                                aVar.mCX.setText(nK.mqk);
                                                break;
                                            }
                                        }
                                        aVar.mCV.setVisibility(0);
                                        aVar.mCV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqh, aVar.mCV.getTextSize()));
                                        aVar.mCX.setText(nK.mqi);
                                        break;
                                    }
                                    aVar.mCV.setVisibility(0);
                                    aVar.mCV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqh, aVar.mCV.getTextSize()));
                                    aVar.mCX.setText(nK.mqk);
                                    break;
                                    break;
                                case 10:
                                case 11:
                                    if (bg.mA(nK.mpJ)) {
                                        d(aVar.mCS, nK.mpJ);
                                        aVar.mCS.setVisibility(0);
                                    } else {
                                        w.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                        aVar.mCS.setVisibility(8);
                                    }
                                    if (!bg.mA(nK.kPs)) {
                                        if (bg.mA(nK.mpV)) {
                                            aVar.mCV.setText(nK.kPs);
                                            aVar.mCV.setVisibility(0);
                                        } else {
                                            aVar.mCW.setVisibility(0);
                                            aVar.mCX.setText(nK.kPs);
                                            aVar.mCW.setOnClickListener(this.mCJ);
                                            aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                                        }
                                    }
                                    if (!bg.mA(nK.mpV)) {
                                        d(aVar.mCZ, nK.mpV);
                                        aVar.mCZ.setTag(Long.valueOf(nK.field_msgId));
                                        aVar.mCZ.setOnTouchListener(mCH);
                                        aVar.mCZ.setOnClickListener(this.mCJ);
                                        aVar.mCZ.setVisibility(0);
                                        aVar.mCZ.setEnabled(true);
                                        break;
                                    }
                                    break;
                                default:
                                    w.e("MicroMsg.GameMessageAdapter", "error msgtype: " + nK.field_msgType);
                                    break;
                            }
                        }
                    }
                    obj = null;
                    size = nK.mpP.size();
                    aVar.mDc.setText(nK.mpN);
                    aVar.mDc.setVisibility(0);
                    if ((nK.mqd & 2) <= 0) {
                        aVar.mDc.setTextColor(this.context.getResources().getColor(R.e.aTU));
                        aVar.mDc.setBackgroundResource(0);
                        aVar.mDc.setOnClickListener(null);
                        aVar.mDc.setEnabled(false);
                    } else {
                        aVar.mDc.setTextColor(this.context.getResources().getColor(R.e.aTW));
                        aVar.mDc.setBackgroundResource(R.g.bfq);
                        aVar.mDc.setOnClickListener(this.mCI);
                        aVar.mDc.setTag(nK);
                        aVar.mDc.setEnabled(true);
                    }
                    if (nK.field_msgType != 10) {
                    }
                    if (!bg.mA(nK.iQO)) {
                        aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.iQO, aVar.jWd.getTextSize()), BufferType.SPANNABLE);
                        aVar.jWd.setVisibility(0);
                    } else if (bg.mA(charSequence)) {
                        aVar.jWd.setVisibility(8);
                    } else {
                        aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, charSequence, aVar.jWd.getTextSize()));
                        aVar.jWd.setVisibility(0);
                    }
                    switch (nK.field_msgType) {
                        case 2:
                            d(aVar.mCS, nK.mpJ);
                            str = "礼物";
                            if (nK.mqa.contains("爱心")) {
                                str = "爱心";
                            } else if (nK.mqa.contains("体力")) {
                                str = "体力";
                            }
                            if (size <= 1) {
                                aVar.jbV.setText(this.context.getResources().getString(R.l.epm, new Object[]{str}));
                            } else {
                                aVar.jbV.setText(this.context.getResources().getString(R.l.epl, new Object[]{String.valueOf(size), str}));
                            }
                            aVar.jbV.setVisibility(0);
                            a(nK, aVar);
                            break;
                        case 5:
                            if (bg.bV(nK.mpP)) {
                                aVar.mCS.setVisibility(8);
                            } else {
                                aVar.mCS.setVisibility(0);
                                if (bg.mA(((h) nK.mpP.get(0)).mqN)) {
                                    b(aVar.mCS, ((h) nK.mpP.get(0)).userName);
                                } else {
                                    d(aVar.mCS, ((h) nK.mpP.get(0)).mqN);
                                }
                                if (bg.mA(((h) nK.mpP.get(0)).mqO)) {
                                    aVar.mCS.setOnClickListener(this.mCL);
                                    aVar.mCS.setTag(nK);
                                    aVar.mCS.setEnabled(true);
                                }
                            }
                            if (size <= 1) {
                                aVar.jbV.setText(this.context.getResources().getString(R.l.epk));
                            } else {
                                aVar.jbV.setText(this.context.getResources().getString(R.l.epj, new Object[]{String.valueOf(size)}));
                                a(nK, aVar);
                            }
                            aVar.mCW.setVisibility(0);
                            aVar.jbV.setVisibility(0);
                            aVar.mCX.setText(nK.mql);
                            aVar.mCW.setOnClickListener(this.mCJ);
                            aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                            if (bg.mA(nK.mqn)) {
                                aVar.mCY.setVisibility(0);
                                d(aVar.mCY, nK.mqn);
                                break;
                            }
                            break;
                        case 6:
                            if (bg.bV(nK.mpP)) {
                                aVar.mCS.setVisibility(8);
                            } else {
                                aVar.mCS.setVisibility(0);
                                if (bg.mA(((h) nK.mpP.get(0)).mqN)) {
                                    b(aVar.mCS, ((h) nK.mpP.get(0)).userName);
                                } else {
                                    d(aVar.mCS, ((h) nK.mpP.get(0)).mqN);
                                }
                                if (bg.mA(((h) nK.mpP.get(0)).mqO)) {
                                    aVar.mCS.setOnClickListener(this.mCL);
                                    aVar.mCS.setTag(nK);
                                    aVar.mCS.setEnabled(true);
                                }
                            }
                            aVar.mCW.setVisibility(0);
                            aVar.mCW.setOnClickListener(this.mCJ);
                            aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                            if (nK.mqx == 1) {
                                if (nK.mqx == 2) {
                                    if (nK.mqx == 3) {
                                        aVar.jbV.setVisibility(0);
                                        if (size <= 1) {
                                            aVar.jbV.setText(this.context.getResources().getString(R.l.epi));
                                        } else {
                                            aVar.jbV.setText(this.context.getResources().getString(R.l.eph, new Object[]{String.valueOf(size)}));
                                            a(nK, aVar);
                                        }
                                        aVar.mCX.setText(nK.mqk);
                                        break;
                                    }
                                }
                                aVar.mCV.setVisibility(0);
                                aVar.mCV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqh, aVar.mCV.getTextSize()));
                                aVar.mCX.setText(nK.mqi);
                                break;
                            }
                            aVar.mCV.setVisibility(0);
                            aVar.mCV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqh, aVar.mCV.getTextSize()));
                            aVar.mCX.setText(nK.mqk);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (bg.mA(nK.mpJ)) {
                                w.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.mCS.setVisibility(8);
                            } else {
                                d(aVar.mCS, nK.mpJ);
                                aVar.mCS.setVisibility(0);
                            }
                            if (bg.mA(nK.kPs)) {
                                if (bg.mA(nK.mpV)) {
                                    aVar.mCW.setVisibility(0);
                                    aVar.mCX.setText(nK.kPs);
                                    aVar.mCW.setOnClickListener(this.mCJ);
                                    aVar.mCW.setTag(Long.valueOf(nK.field_msgId));
                                } else {
                                    aVar.mCV.setText(nK.kPs);
                                    aVar.mCV.setVisibility(0);
                                }
                            }
                            if (bg.mA(nK.mpV)) {
                                d(aVar.mCZ, nK.mpV);
                                aVar.mCZ.setTag(Long.valueOf(nK.field_msgId));
                                aVar.mCZ.setOnTouchListener(mCH);
                                aVar.mCZ.setOnClickListener(this.mCJ);
                                aVar.mCZ.setVisibility(0);
                                aVar.mCZ.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            w.e("MicroMsg.GameMessageAdapter", "error msgtype: " + nK.field_msgType);
                            break;
                    }
                }
                if (nK.mqt != null) {
                    d(aVar.mCS, nK.mqt.mqK);
                    aVar.mCS.setVisibility(0);
                    if (bg.mA(nK.mqt.mqJ)) {
                        aVar.jWd.setVisibility(8);
                    } else {
                        aVar.jWd.setText(nK.mqt.mqJ);
                        aVar.jWd.setVisibility(0);
                    }
                    if (bg.mA(nK.mqt.mqL)) {
                        aVar.mCU.setVisibility(8);
                    } else {
                        d(aVar.mCU, nK.mqt.mqL);
                        aVar.mCU.setVisibility(0);
                    }
                    if (bg.mA(nK.mqt.mqF)) {
                        aVar.jWd.setEnabled(false);
                        aVar.mCS.setEnabled(false);
                    } else {
                        aVar.jWd.setEnabled(true);
                        aVar.mCS.setEnabled(true);
                        com.tencent.mm.plugin.game.model.r.a aVar2 = new com.tencent.mm.plugin.game.model.r.a(nK, nK.mqt.mqF, 1);
                        com.tencent.mm.plugin.game.model.r.a aVar3 = new com.tencent.mm.plugin.game.model.r.a(nK, nK.mqt.mqF, 2);
                        aVar.jWd.setTag(aVar2);
                        aVar.jWd.setOnClickListener(this.mCO);
                        aVar.mCS.setTag(aVar3);
                        aVar.mCS.setOnClickListener(this.mCO);
                    }
                } else if (bg.bV(nK.mpP)) {
                    aVar.mCS.setVisibility(8);
                    aVar.jWd.setVisibility(8);
                    aVar.mCU.setVisibility(8);
                } else {
                    hVar = (h) nK.mpP.get(0);
                    if (bg.mA(hVar.aIO)) {
                        ap.yY();
                        x Rc2 = com.tencent.mm.u.c.wR().Rc(hVar.userName);
                        charSequence = (Rc2 == null || bg.mA(Rc2.tL())) ? hVar.userName : Rc2.tL();
                    } else {
                        charSequence = hVar.aIO;
                    }
                    if (bg.mA(hVar.mqQ)) {
                        aVar.jWd.setEnabled(false);
                        aVar.mCS.setEnabled(false);
                    } else {
                        aVar.jWd.setEnabled(true);
                        aVar.mCS.setEnabled(true);
                        com.tencent.mm.plugin.game.model.r.a aVar4 = new com.tencent.mm.plugin.game.model.r.a(nK, hVar.mqQ, 1);
                        com.tencent.mm.plugin.game.model.r.a aVar5 = new com.tencent.mm.plugin.game.model.r.a(nK, hVar.mqQ, 2);
                        aVar.jWd.setTag(aVar4);
                        aVar.jWd.setOnClickListener(this.mCO);
                        aVar.mCS.setTag(aVar5);
                        aVar.mCS.setOnClickListener(this.mCO);
                    }
                    if (bg.mA(charSequence)) {
                        aVar.jWd.setVisibility(8);
                    } else {
                        aVar.jWd.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, charSequence, aVar.jWd.getTextSize()), BufferType.SPANNABLE);
                        aVar.jWd.setVisibility(0);
                    }
                    aVar.mCS.setVisibility(0);
                    if (bg.mA(hVar.mqN)) {
                        b(aVar.mCS, hVar.userName);
                    } else {
                        d(aVar.mCS, hVar.mqN);
                    }
                    if (bg.mA(hVar.mqP)) {
                        aVar.mCU.setVisibility(8);
                    } else {
                        d(aVar.mCU, hVar.mqP);
                        aVar.mCU.setVisibility(0);
                    }
                }
                if (bg.mA(nK.mqp)) {
                    aVar.jbV.setVisibility(8);
                } else {
                    if (nK.mpP.size() > 1) {
                        aVar.jbV.setText(this.context.getResources().getString(R.l.epn, new Object[]{Integer.valueOf(nK.mpP.size())}) + nK.mqp);
                    } else {
                        aVar.jbV.setText(nK.mqp);
                    }
                    aVar.jbV.setVisibility(0);
                }
                if (bg.mA(nK.mqq)) {
                    aVar.mCV.setVisibility(8);
                } else {
                    aVar.mCV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqq, aVar.mCV.getTextSize()));
                    aVar.mCV.setVisibility(0);
                }
                a(nK, aVar);
                if (bg.mA(nK.mqu.mqI)) {
                    aVar.mCW.setVisibility(8);
                } else {
                    aVar.mCW.setVisibility(0);
                    if (bg.mA(nK.mqu.mqF)) {
                        aVar.mCW.setEnabled(false);
                    } else {
                        aVar.mCW.setTag(new com.tencent.mm.plugin.game.model.r.a(nK, nK.mqu.mqF, 3));
                        aVar.mCW.setOnClickListener(this.mCO);
                        aVar.mCW.setEnabled(true);
                    }
                    aVar.mCX.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, nK.mqu.mqI, aVar.mCX.getTextSize()));
                    if (bg.mA(nK.mqu.mqE)) {
                        aVar.mCY.setVisibility(8);
                    } else {
                        d(aVar.mCY, nK.mqu.mqE);
                        aVar.mCY.setVisibility(0);
                    }
                }
                if (bg.mA(nK.mqr)) {
                    aVar.mCZ.setVisibility(8);
                } else {
                    d(aVar.mCZ, nK.mqr);
                    aVar.mCZ.setVisibility(0);
                    if (bg.mA(nK.mqs)) {
                        aVar.mCZ.setEnabled(false);
                    } else {
                        aVar.mCZ.setTag(new com.tencent.mm.plugin.game.model.r.a(nK, nK.mqs, 3));
                        aVar.mCZ.setOnClickListener(this.mCO);
                        aVar.mCZ.setEnabled(true);
                    }
                }
                if (bg.mA(nK.mqv.mName)) {
                    aVar.mDc.setVisibility(8);
                } else {
                    aVar.mDc.setText(nK.mqv.mName);
                    aVar.mDc.setVisibility(0);
                    if (bg.mA(nK.mqv.mqF)) {
                        aVar.mDc.setEnabled(false);
                    } else {
                        aVar.mDc.setTag(new com.tencent.mm.plugin.game.model.r.a(nK, nK.mqv.mqF, 5));
                        aVar.mDc.setOnClickListener(this.mCO);
                        aVar.mDc.setEnabled(true);
                    }
                }
            }
        } else {
            aVar.mCR.setVisibility(8);
            aVar.mDd.setVisibility(0);
        }
        return view;
    }

    private void a(q qVar, a aVar) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < qVar.mpP.size(); i++) {
            linkedList.add(qVar.mpP.get(i));
        }
        aVar.mDe.a(qVar, linkedList, this.mCN, this.mqT, this.mCP);
    }

    private void b(ImageView imageView, String str) {
        if (bg.mA(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        } else if (this.mCP.aV(str)) {
            Bitmap bitmap = (Bitmap) this.mCP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                c(imageView, str);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            c(imageView, str);
        }
    }

    private void c(ImageView imageView, String str) {
        Bitmap g = e.aCi().g(imageView, str);
        if (g != null) {
            this.mCP.put(str, g);
        }
    }

    private void d(ImageView imageView, String str) {
        if (this.mCP.aV(str)) {
            Bitmap bitmap = (Bitmap) this.mCP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                e(imageView, str);
                return;
            } else {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        e(imageView, str);
    }

    private void e(ImageView imageView, final String str) {
        com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
        aVar.hIJ = false;
        e.aCi().a(imageView, str, aVar.aCj(), new e.b(this) {
            final /* synthetic */ m mCQ;

            public final void s(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.mCQ.mCP.put(str, bitmap);
                }
            }
        });
    }

    public final void OK() {
        setCursor(SubCoreGameCenter.aBB().rawQuery("select * from GameRawMessage where " + u.l(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0" + " order by isRead, createTime desc limit " + this.kor, new String[0]));
        this.kor = getCount();
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    protected final void OL() {
        aEW();
        OK();
    }

    private static q a(q qVar, Cursor cursor) {
        if (qVar == null) {
            qVar = new q();
        }
        qVar.b(cursor);
        return qVar;
    }

    public final boolean ahI() {
        return this.kor >= this.hOI;
    }

    public final int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            return 0;
        }
        return this.count + aBV();
    }

    public final boolean nJ(int i) {
        return this.hOI > this.fCK && this.fCK > 0 && i == this.fCK;
    }

    protected final int aBV() {
        return (this.hOI <= this.fCK || this.fCK <= 0) ? 0 : 1;
    }

    private q nK(int i) {
        if (nJ(i)) {
            return (q) this.uSL;
        }
        q qVar;
        if (this.uSM != null) {
            qVar = (q) this.uSM.get(Integer.valueOf(i));
            if (qVar != null) {
                return qVar;
            }
        }
        Object obj = (this.hOI <= this.fCK || this.fCK <= 0 || i <= this.fCK) ? null : 1;
        int i2;
        if (obj != null) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(r0)) {
            return null;
        }
        if (this.uSM == null) {
            return a((q) this.uSL, getCursor());
        }
        qVar = a(null, getCursor());
        this.uSM.put(Integer.valueOf(i), qVar);
        return qVar;
    }
}
