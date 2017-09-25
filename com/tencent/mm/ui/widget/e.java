package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.bm.a.f;
import com.tencent.mm.bm.a.g;
import com.tencent.mm.bm.a.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.wcdb.FileUtils;

public final class e implements OnGlobalLayoutListener {
    public static int wuO = 0;
    public static int wuP = 1;
    public static int wuQ = 2;
    private ViewTreeObserver Rn;
    public RecyclerView aak;
    private View hz;
    private View kQt;
    public Context mContext;
    public boolean oNl = false;
    public View pwq;
    public c qJf;
    public d qJg;
    public l qJh;
    private boolean sjk = false;
    private boolean sjl;
    public boolean sjm;
    public boolean sjn = false;
    public com.tencent.mm.ui.base.n.a wnf;
    public com.tencent.mm.ui.base.n.b wng;
    public android.support.design.widget.c wuD;
    public d wuE;
    public l wuF;
    private LinearLayout wuG;
    private LinearLayout wuH;
    public b wuI;
    public boolean wuJ = false;
    public boolean wuK = false;
    public boolean wuL = false;
    private int wuM;
    private BottomSheetBehavior wuN;
    private int wuR = 4;
    private int wuS = (this.wuR * 3);
    private int wuT = 6;
    public int wuU;
    public boolean wuV;
    public boolean wuW = false;
    public boolean wuX = false;
    public boolean wuY = false;
    public int wuZ = 0;
    public a wva;

    public interface a {
        void onDismiss();
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        OnItemClickListener Yi;
        final /* synthetic */ e wvb;

        public class a extends t implements OnClickListener {
            TextView iUO;
            ImageView jki;
            TextView qhN;
            RadioButton wvc;
            ImageView wvd;
            LinearLayout wve;
            final /* synthetic */ b wvf;

            public a(b bVar, View view) {
                this.wvf = bVar;
                super(view);
                view.setOnClickListener(this);
                this.iUO = (TextView) view.findViewById(com.tencent.mm.bm.a.e.title);
                this.jki = (ImageView) view.findViewById(com.tencent.mm.bm.a.e.icon);
                this.wve = (LinearLayout) view.findViewById(com.tencent.mm.bm.a.e.czn);
                if (bVar.wvb.wuK || bVar.wvb.wuL) {
                    this.qhN = (TextView) view.findViewById(com.tencent.mm.bm.a.e.bHZ);
                    this.wvc = (RadioButton) view.findViewById(com.tencent.mm.bm.a.e.cvd);
                    this.wvd = (ImageView) view.findViewById(com.tencent.mm.bm.a.e.divider);
                }
            }

            public final void onClick(View view) {
                if (this.wvf.Yi != null) {
                    this.wvf.Yi.onItemClick(null, view, getPosition(), (long) getPosition());
                }
            }
        }

        public b(e eVar) {
            this.wvb = eVar;
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View inflate = this.wvb.wuU == e.wuO ? LayoutInflater.from(this.wvb.mContext).inflate(f.wAl, viewGroup, false) : this.wvb.wuU == e.wuQ ? LayoutInflater.from(this.wvb.mContext).inflate(f.wAm, viewGroup, false) : LayoutInflater.from(this.wvb.mContext).inflate(f.wAn, viewGroup, false);
            return new a(this, inflate);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            m mVar;
            if (i < this.wvb.qJh.size()) {
                if (this.wvb.wuZ >= this.wvb.qJh.size()) {
                    this.wvb.wuZ = 0;
                }
                mVar = (m) this.wvb.qJh.vla.get(i);
                aVar.iUO.setText(mVar.getTitle());
                if (mVar.getIcon() != null) {
                    aVar.jki.setVisibility(0);
                    aVar.jki.setImageDrawable(mVar.getIcon());
                } else if (this.wvb.wnf != null) {
                    aVar.jki.setVisibility(0);
                    this.wvb.wnf.a(aVar.jki, mVar);
                } else if (this.wvb.wuX) {
                    aVar.jki.setVisibility(4);
                } else {
                    aVar.jki.setVisibility(8);
                }
                if (this.wvb.wng != null) {
                    this.wvb.wng.a(aVar.iUO, mVar);
                }
                if (mVar.uff) {
                    aVar.iUO.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzL));
                    aVar.wve.setBackgroundResource(com.tencent.mm.bm.a.b.white);
                } else {
                    aVar.iUO.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.aSY));
                    aVar.wve.setBackgroundResource(com.tencent.mm.bm.a.d.wAa);
                }
                if (aVar.qhN != null) {
                    if (bg.J(mVar.pgM)) {
                        aVar.qhN.setVisibility(8);
                    } else {
                        aVar.qhN.setVisibility(0);
                        aVar.qhN.setText(mVar.pgM);
                        aVar.qhN.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
                if (this.wvb.wuK) {
                    if (mVar.uff) {
                        aVar.wvc.setVisibility(8);
                        aVar.qhN.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzL));
                    } else {
                        aVar.qhN.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzM));
                        aVar.wvc.setVisibility(0);
                        if (this.wvb.wuZ == i) {
                            aVar.wvc.setChecked(true);
                        } else {
                            aVar.wvc.setChecked(false);
                        }
                    }
                    aVar.wvd.setVisibility(0);
                }
            } else if (this.wvb.wuF.size() > 0 && i < this.wvb.qJh.size() + this.wvb.wuF.size()) {
                mVar = (m) this.wvb.wuF.vla.get(i - this.wvb.qJh.size());
                aVar.iUO.setText(mVar.getTitle());
                if (this.wvb.wuZ >= this.wvb.qJh.size() + this.wvb.wuF.size()) {
                    this.wvb.wuZ = 0;
                }
                if (mVar.getIcon() != null) {
                    aVar.jki.setVisibility(0);
                    aVar.jki.setImageDrawable(mVar.getIcon());
                } else {
                    aVar.jki.setVisibility(8);
                }
                if (mVar.uff) {
                    aVar.iUO.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzL));
                    aVar.wve.setBackgroundResource(com.tencent.mm.bm.a.b.white);
                } else {
                    aVar.iUO.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.aSY));
                    aVar.wve.setBackgroundResource(com.tencent.mm.bm.a.d.wAa);
                }
                if (aVar.qhN != null) {
                    if (bg.J(mVar.pgM)) {
                        aVar.qhN.setVisibility(8);
                    } else {
                        aVar.qhN.setVisibility(0);
                        aVar.qhN.setText(mVar.pgM);
                    }
                }
                if (this.wvb.wuK) {
                    if (mVar.uff) {
                        aVar.wvc.setVisibility(8);
                        aVar.qhN.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzL));
                    } else {
                        aVar.qhN.setTextColor(this.wvb.mContext.getResources().getColor(com.tencent.mm.bm.a.b.wzM));
                        aVar.wvc.setVisibility(0);
                        if (this.wvb.wuZ == i) {
                            aVar.wvc.setChecked(true);
                        } else {
                            aVar.wvc.setChecked(false);
                        }
                    }
                    aVar.wvd.setVisibility(0);
                }
            } else if (this.wvb.wuJ) {
                aVar.iUO.setText(h.dPH);
                aVar.jki.setImageResource(g.wAq);
            }
        }

        public final int getItemCount() {
            if (this.wvb.wuJ) {
                return (this.wvb.qJh.size() + this.wvb.wuF.size()) + 1;
            }
            return this.wvb.qJh.size() + this.wvb.wuF.size();
        }
    }

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hz;
            if (view == null || !view.isShown()) {
                bzi();
            } else if (isShowing() && this.sjk != aKK()) {
                bzi();
            }
        }
    }

    public e(Context context, int i, boolean z) {
        int U;
        this.wuU = i;
        this.mContext = context;
        this.wuV = z;
        this.wuY = false;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hz = viewGroup.getChildAt(0);
            } else {
                this.hz = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.qJh = new l();
        this.wuF = new l();
        this.wuD = new android.support.design.widget.c(context2);
        this.kQt = View.inflate(context2, f.wAk, null);
        this.wuG = (LinearLayout) this.kQt.findViewById(com.tencent.mm.bm.a.e.wAd);
        this.wuH = (LinearLayout) this.kQt.findViewById(com.tencent.mm.bm.a.e.wAb);
        this.pwq = this.kQt.findViewById(com.tencent.mm.bm.a.e.wAf);
        this.aak = (RecyclerView) this.kQt.findViewById(com.tencent.mm.bm.a.e.wAc);
        this.aak.Zl = true;
        this.sjk = aKK();
        if (this.wuU == wuO) {
            if (this.sjk) {
                this.wuR = 7;
                this.wuS = this.wuR * 2;
                this.wuM = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzQ) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bad);
            } else {
                this.wuM = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzP) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bad);
            }
            if (this.wuV) {
                this.wuM += com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bad);
            }
        } else if (this.wuU == wuQ) {
            this.wuK = true;
            U = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzV);
            if (this.sjk) {
                this.wuT = 2;
                this.wuM = ((int) (((double) U) * 2.5d)) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzU);
            } else {
                this.wuT = 3;
                this.wuM = ((int) (((double) U) * 3.5d)) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzU);
            }
            if (this.wuV) {
                this.wuM += com.tencent.mm.bg.a.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.wuL = true;
            U = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzW);
            if (this.sjk) {
                this.wuT = 4;
                this.wuM = ((int) (((double) U) * 4.5d)) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzU);
            } else {
                this.wuT = 6;
                this.wuM = ((int) (((double) U) * 6.5d)) + com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.wzU);
            }
            if (this.wuV) {
                this.wuM += com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bad);
            }
        }
        if (this.wuV && this.pwq != null && this.wuY) {
            this.pwq.setVisibility(0);
        }
        if (this.wuU == wuO) {
            this.aak.a(new GridLayoutManager(this.mContext, this.wuR));
            int U2 = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bac);
            U = com.tencent.mm.bg.a.U(this.mContext, com.tencent.mm.bm.a.c.bad);
            if (this.wuV) {
                U = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 0);
            }
            this.aak.setPadding(U2, U, U2, 0);
        } else {
            this.aak.a(new LinearLayoutManager());
        }
        this.wuI = new b(this);
        this.wuI.Yi = new OnItemClickListener(this) {
            final /* synthetic */ e wvb;

            {
                this.wvb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m mVar = (m) this.wvb.qJh.vla.get(i);
                if (mVar == null || !mVar.uff) {
                    if (i < this.wvb.qJh.size()) {
                        if (this.wvb.qJg != null) {
                            this.wvb.qJg.c(this.wvb.qJh.getItem(i), i);
                        }
                    } else if (this.wvb.wuF.size() > 0 && i < this.wvb.qJh.size() + this.wvb.wuF.size() && this.wvb.wuE != null) {
                        this.wvb.wuE.c(this.wvb.wuF.getItem(i - this.wvb.qJh.size()), i);
                    }
                    if (!this.wvb.oNl) {
                        this.wvb.bzi();
                    }
                    this.wvb.wuW = true;
                    this.wvb.wuZ = i;
                    this.wvb.wuI.aab.notifyChanged();
                }
            }
        };
        this.aak.a(this.wuI);
        this.aak.setOverScrollMode(1);
        this.wuD.setContentView(this.kQt);
        this.wuN = BottomSheetBehavior.i((View) this.kQt.getParent());
        this.wuN.g(this.wuM);
        this.wuN.fj = new android.support.design.widget.BottomSheetBehavior.a(this) {
            final /* synthetic */ e wvb;

            {
                this.wvb = r1;
            }

            public final void k(int i) {
            }

            public final void d(float f) {
                if (this.wvb.pwq != null && !this.wvb.wuY) {
                    if (!this.wvb.aak.canScrollVertically(-1)) {
                        this.wvb.pwq.setVisibility(4);
                    } else if (!this.wvb.wuV || f == 0.0f) {
                        this.wvb.pwq.setVisibility(4);
                    } else {
                        this.wvb.pwq.setVisibility(0);
                    }
                }
            }
        };
        this.wuD.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ e wvb;

            {
                this.wvb = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.wvb.wuD = null;
            }
        });
    }

    public final void dE(View view) {
        if (this.wuG != null && this.wuV) {
            this.wuG.setVisibility(0);
            this.wuG.removeAllViews();
            this.wuG.setGravity(17);
            this.wuG.addView(view, -1, -2);
        }
    }

    public final void d(CharSequence charSequence, int i) {
        if (this.wuG != null && this.wuV) {
            this.wuG.setVisibility(0);
            this.wuG.removeAllViews();
            this.wuG.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(f.wAo, null);
            TextView textView = (TextView) inflate.findViewById(com.tencent.mm.bm.a.e.hdD);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.wuG.addView(inflate, -1, -2);
        }
    }

    public final void bzh() {
        this.sjk = aKK();
        if (this.qJf != null) {
            this.qJf.a(this.qJh);
        }
        if (this.wuD != null) {
            LayoutParams layoutParams = (LayoutParams) this.kQt.getLayoutParams();
            int size = this.qJh.size();
            if (this.wuJ) {
                size++;
            } else if (this.wuF.size() > 0) {
                size += this.wuF.size();
            }
            if (this.wuU == wuO) {
                if (this.wuI.getItemCount() > this.wuS) {
                    layoutParams.height = this.wuM;
                }
            } else if (size > this.wuT) {
                layoutParams.height = this.wuM;
            }
            if (this.sjk && this.hz != null) {
                Rect rect = new Rect();
                this.hz.getWindowVisibleDisplayFrame(rect);
                layoutParams.width = rect.right;
            }
            this.kQt.setLayoutParams(layoutParams);
            if (!(this.wuF == null || this.wuI == null)) {
                this.wuI.aab.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.wuD.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.sjl && VERSION.SDK_INT >= 23 && this.wuD != null) {
                this.wuD.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.wuD.getWindow().setStatusBarColor(0);
            }
            if (this.sjm) {
                this.wuD.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.sjn) {
                this.wuD.getWindow().setFlags(8, 8);
                this.wuD.getWindow().addFlags(131200);
                this.wuD.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.wuD.getWindow().clearFlags(8);
                this.wuD.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.wuD.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.wuD.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.wuN != null) {
                this.wuN.fb = false;
            }
            if (this.wva != null) {
                this.wuD.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ e wvb;

                    {
                        this.wvb = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (!this.wvb.wuW) {
                            this.wvb.wva.onDismiss();
                        }
                    }
                });
            }
            if (this.hz != null) {
                boolean z = this.Rn == null;
                this.Rn = this.hz.getViewTreeObserver();
                if (z) {
                    this.Rn.addOnGlobalLayoutListener(this);
                }
            }
            this.wuD.show();
        }
    }

    public final void bzi() {
        if (this.Rn != null) {
            if (!this.Rn.isAlive()) {
                this.Rn = this.hz.getViewTreeObserver();
            }
            this.Rn.removeGlobalOnLayoutListener(this);
            this.Rn = null;
        }
        if (this.wuD != null) {
            if (this.wuN != null) {
                this.wuN.fb = true;
            }
            this.wuD.dismiss();
        }
    }

    public final boolean isShowing() {
        if (this.wuD == null || !this.wuD.isShowing()) {
            return false;
        }
        return true;
    }

    private boolean aKK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
