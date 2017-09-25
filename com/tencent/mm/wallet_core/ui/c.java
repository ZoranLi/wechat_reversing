package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c {
    public o iuS;
    private ImageView iuT;
    private View iuU;
    private OnClickListener iuW;
    private MMActivity kdb;
    public boolean kkR;
    private Bitmap koI;
    private View koL;
    private ImageView koM;
    private MMVerticalTextView koN;
    private ArrayList<Bitmap> koP;
    private String obT;
    public Bitmap odN;
    public Bitmap odO;
    private String oeg;
    public ViewGroup wFn;
    private boolean wFo;

    public c(MMActivity mMActivity, boolean z) {
        this.odN = null;
        this.odO = null;
        this.koI = null;
        this.oeg = "";
        this.obT = "";
        this.kkR = true;
        this.koP = new ArrayList();
        this.iuS = null;
        this.wFo = false;
        this.iuW = new OnClickListener(this) {
            final /* synthetic */ c wFp;

            {
                this.wFp = r1;
            }

            public final void onClick(View view) {
                if ((view.getId() == R.h.csg || view.getId() == R.h.csc) && this.wFp.iuS != null && this.wFp.iuS.isShowing()) {
                    this.wFp.iuS.dismiss();
                }
            }
        };
        this.kdb = mMActivity;
        this.wFo = z;
    }

    public c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    public final void eZ(String str, String str2) {
        this.oeg = str;
        this.obT = str2;
    }

    public final void init() {
        if (this.iuS == null) {
            View view;
            if (this.wFo) {
                View inflate = View.inflate(this.kdb, R.i.dqT, null);
                MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(R.h.ciR);
                this.wFn = (ViewGroup) inflate.findViewById(R.h.csf);
                mMVerticalTextView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c wFp;

                    {
                        this.wFp = r1;
                    }

                    public final void onClick(View view) {
                        w.d("MicroMsg.OfflinePopupWindow", "on click know");
                        this.wFp.wFn.setVisibility(8);
                        b ccVar = new cc();
                        ccVar.fFK.fFL = 1;
                        a.urY.m(ccVar);
                    }
                });
                inflate.findViewById(R.h.cse).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c wFp;

                    {
                        this.wFp = r1;
                    }

                    public final void onClick(View view) {
                        w.d("MicroMsg.OfflinePopupWindow", "root on click");
                        if (this.wFp.iuS != null && this.wFp.iuS.isShowing()) {
                            this.wFp.iuS.dismiss();
                        }
                    }
                });
                view = inflate;
            } else {
                View inflate2 = View.inflate(this.kdb, R.i.dqW, null);
                inflate2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ c wFp;

                    {
                        this.wFp = r1;
                    }

                    public final void onClick(View view) {
                        if (this.wFp.iuS != null && this.wFp.iuS.isShowing()) {
                            this.wFp.iuS.dismiss();
                        }
                    }
                });
                view = inflate2;
            }
            this.iuU = view.findViewById(R.h.csh);
            this.iuT = (ImageView) view.findViewById(R.h.csg);
            this.koL = view.findViewById(R.h.csd);
            this.koM = (ImageView) view.findViewById(R.h.csc);
            this.koN = (MMVerticalTextView) view.findViewById(R.h.cLB);
            this.iuS = new o(view, -1, -1, true);
            this.iuS.setClippingEnabled(false);
            this.iuS.update();
            this.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
            this.iuS.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ c wFp;

                {
                    this.wFp = r1;
                }

                public final void onDismiss() {
                }
            });
        }
    }

    public final void release() {
        if (this.iuS != null && this.iuS.isShowing()) {
            this.iuS.dismiss();
        }
        e.p(this.koI);
        e.am(this.koP);
        this.koP.clear();
        this.kdb = null;
    }

    public final void t(View view, boolean z) {
        this.kkR = z;
        if (this.iuS != null && !this.iuS.isShowing()) {
            this.iuS.showAtLocation(view.getRootView(), 17, 0, 0);
            this.iuS.setFocusable(true);
            this.iuS.setTouchable(true);
            this.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
            this.iuS.setOutsideTouchable(true);
            if (this.kkR) {
                ccy();
            }
            ccz();
        }
    }

    public final void ccx() {
        if (this.iuS != null && this.iuS.isShowing()) {
            ccz();
        }
    }

    public final void ccy() {
        if (this.wFn != null) {
            this.wFn.setVisibility(0);
        }
    }

    private void ccz() {
        if (this.kkR) {
            this.koM.setOnClickListener(this.iuW);
            Bitmap bitmap = this.koI;
            if (this.odO != null) {
                this.koI = e.o(this.odO);
                w.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.koI = null;
                w.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.koM.setImageBitmap(this.koI);
            this.koP.add(0, bitmap);
            if (this.koP.size() >= 2) {
                for (int size = this.koP.size() - 1; size > 1; size--) {
                    e.p((Bitmap) this.koP.remove(size));
                }
            }
            this.iuU.setVisibility(8);
            this.koL.setVisibility(0);
            this.koN.setText(e.UO(this.obT));
        } else {
            this.iuT.setOnClickListener(this.iuW);
            this.iuT.setImageBitmap(this.odN);
            if (this.odN != null) {
                w.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                w.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.iuU.setVisibility(0);
            this.koL.setVisibility(8);
        }
        this.iuS.update();
    }

    public final void dismiss() {
        if (this.iuS != null && this.iuS.isShowing()) {
            this.iuS.dismiss();
        }
    }
}
