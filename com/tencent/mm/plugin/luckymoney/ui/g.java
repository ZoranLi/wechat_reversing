package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g {

    public static final class c {
        public boolean ntV = false;
        public int ntW = 0;
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
    }

    interface d {
        void a(Context context, ViewGroup viewGroup, ag agVar);
    }

    static class a implements d {
        public c ntQ;

        a() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (bg.mA(agVar.name)) {
                w.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                return;
            }
            View imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.FIT_XY);
            n.f(imageView, agVar.name);
            if (!bg.mA(agVar.content)) {
                imageView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a ntS;

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.nnX)});
                        if (this.ntS.ntQ != null) {
                            f.dJ(this.ntS.ntQ.ntW, 1);
                        }
                        com.tencent.mm.wallet_core.ui.e.m(context, agVar.content, true);
                    }
                });
            }
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.nnX)});
            if (this.ntQ != null) {
                f.dJ(this.ntQ.ntW, 0);
            }
        }
    }

    static class b implements d {
        c ntQ;

        b() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (!bg.mA(agVar.name)) {
                View textView = new TextView(context);
                if (this.ntQ == null || this.ntQ.textColor == Integer.MIN_VALUE) {
                    textView.setTextColor(context.getResources().getColor(R.e.aWj));
                } else {
                    textView.setTextColor(this.ntQ.textColor);
                }
                if (this.ntQ == null || this.ntQ.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.f.aXs));
                } else {
                    textView.setTextSize(0, (float) this.ntQ.textSize);
                }
                textView.setGravity(17);
                textView.setText(agVar.name);
                if (!bg.mA(agVar.content)) {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ b ntT;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.nnX)});
                            if (agVar.nnY != 1) {
                                new com.tencent.mm.pluginsdk.ui.applet.b(context, agVar.content, new com.tencent.mm.pluginsdk.ui.applet.b.a(this) {
                                    final /* synthetic */ AnonymousClass1 ntU;

                                    {
                                        this.ntU = r1;
                                    }

                                    public final void pb(int i) {
                                        switch (i) {
                                            case -2:
                                            case 1:
                                                com.tencent.mm.wallet_core.ui.e.bo(context, agVar.content);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                }).show();
                            } else {
                                com.tencent.mm.wallet_core.ui.e.P(context, agVar.content);
                            }
                        }
                    });
                }
                viewGroup.addView(textView, new LayoutParams(-2, -2));
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.nnX)});
            }
        }
    }

    static class e implements d {
        public c ntQ;

        e() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (!bg.mA(agVar.name)) {
                View inflate = LayoutInflater.from(context).inflate(R.i.dhx, viewGroup, true);
                TextView textView = (TextView) inflate.findViewById(R.h.cgv);
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cgu);
                if (bg.mA(agVar.iconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    n.f(imageView, agVar.iconUrl);
                    imageView.setVisibility(0);
                }
                if (!(this.ntQ == null || this.ntQ.textColor == Integer.MIN_VALUE)) {
                    textView.setTextColor(this.ntQ.textColor);
                }
                if (this.ntQ == null || this.ntQ.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.f.aXs));
                } else {
                    textView.setTextSize(0, (float) this.ntQ.textSize);
                }
                textView.setGravity(17);
                textView.setText(agVar.name);
                if (!bg.mA(agVar.content)) {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ e ntX;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.nnX)});
                            if (this.ntX.ntQ != null) {
                                f.dJ(this.ntX.ntQ.ntW, 1);
                            }
                            if (this.ntX.ntQ != null && this.ntX.ntQ.ntV) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13051, new Object[]{Integer.valueOf(this.ntX.ntQ.ntW), Integer.valueOf(2), "", "", "", agVar.content, agVar.type, "", "", Integer.valueOf(this.ntX.ntQ.resourceId)});
                            }
                            if (agVar.type.equals("Native")) {
                                w.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + agVar.content);
                                if ("weixin://festival/gotoshake".equalsIgnoreCase(agVar.content)) {
                                    w.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                                    return;
                                }
                                return;
                            }
                            com.tencent.mm.wallet_core.ui.e.m(context, agVar.content, true);
                        }
                    });
                }
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.nnX)});
                if (this.ntQ != null) {
                    f.dJ(this.ntQ.ntW, 0);
                }
            }
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ag agVar, c cVar) {
        if (agVar != null) {
            a(context, viewGroup, agVar, cVar, agVar.type);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ag agVar, c cVar, String str) {
        if (viewGroup != null && agVar != null) {
            if (agVar.gPD == 0) {
                w.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + agVar.gPD);
                viewGroup.setVisibility(8);
            } else if (!agVar.type.equalsIgnoreCase(str)) {
                w.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + agVar.type + ", " + str);
                viewGroup.setVisibility(8);
            } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
                r0 = new e();
                r0.ntQ = cVar;
                r0.a(context, viewGroup, agVar);
            } else if (str.equalsIgnoreCase("Pic")) {
                r0 = new a();
                r0.ntQ = cVar;
                r0.a(context, viewGroup, agVar);
            } else if (str.equalsIgnoreCase("Appid")) {
                r0 = new b();
                r0.ntQ = cVar;
                r0.a(context, viewGroup, agVar);
            }
        }
    }
}
