package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class y extends a {
    private Runnable ibT;
    public TextView itE;

    public y(Context context, r rVar, ViewGroup viewGroup) {
        super(context, rVar, viewGroup);
    }

    public final r bgF() {
        return (r) this.qib;
    }

    protected final int aTQ() {
        return g.pHf;
    }

    public final void bfO() {
        super.bfO();
        if (!e.remove(this.ibT)) {
            e.O(this.ibT);
        }
    }

    protected final void bgl() {
        if (((r) this.qib).fEC != 1) {
            this.itE.setText(((r) this.qib).qgb);
        } else if (!bg.mA(((r) this.qib).qgb)) {
            final String replace = ((r) this.qib).qgb.replace("<icon", "<img");
            e.remove(this.ibT);
            this.ibT = new Runnable(this) {
                final /* synthetic */ y qkj;

                public final void run() {
                    final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter(this) {
                        final /* synthetic */ AnonymousClass1 qkk;

                        {
                            this.qkk = r1;
                        }

                        public final Drawable getDrawable(String str) {
                            String dA = d.dA("adId", str);
                            if (bg.mA(dA) || !FileOp.aO(dA)) {
                                d.a("adId", str, false, 0, 0, new a(this) {
                                    final /* synthetic */ AnonymousClass1 qkl;

                                    {
                                        this.qkl = r1;
                                    }

                                    public final void bgn() {
                                    }

                                    public final void bgo() {
                                    }

                                    public final void FW(String str) {
                                        try {
                                            final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter(this) {
                                                final /* synthetic */ AnonymousClass1 qkm;

                                                {
                                                    this.qkm = r1;
                                                }

                                                public final Drawable getDrawable(String str) {
                                                    String dA = d.dA("adId", str);
                                                    if (bg.mA(dA) || !FileOp.aO(dA)) {
                                                        return null;
                                                    }
                                                    Drawable createFromPath = Drawable.createFromPath(dA);
                                                    createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) this.qkm.qkl.qkk.qkj.bgF().hbf)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) this.qkm.qkl.qkk.qkj.bgF().hbf : createFromPath.getIntrinsicHeight());
                                                    return createFromPath;
                                                }
                                            }, null);
                                            af.v(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 qkm;

                                                public final void run() {
                                                    this.qkm.qkl.qkk.qkj.itE.setText(fromHtml);
                                                }
                                            });
                                        } catch (Exception e) {
                                            w.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                                        }
                                    }
                                });
                                return null;
                            }
                            Drawable createFromPath = Drawable.createFromPath(dA);
                            if (createFromPath == null) {
                                return createFromPath;
                            }
                            int intrinsicWidth;
                            int i;
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) this.qkk.qkj.bgF().hbf)) / createFromPath.getIntrinsicHeight();
                            } else {
                                intrinsicWidth = createFromPath.getIntrinsicWidth();
                            }
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                i = (int) this.qkk.qkj.bgF().hbf;
                            } else {
                                i = createFromPath.getIntrinsicHeight();
                            }
                            createFromPath.setBounds(0, 0, intrinsicWidth, i);
                            return createFromPath;
                        }
                    }, null);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 qkk;

                        public final void run() {
                            this.qkk.qkj.itE.setText(fromHtml);
                        }
                    });
                }
            };
            e.post(this.ibT, "");
        }
        if (((r) this.qib).textAlignment == 0) {
            this.itE.setGravity(3);
        } else if (((r) this.qib).textAlignment == 1) {
            this.itE.setGravity(17);
        } else if (((r) this.qib).textAlignment == 2) {
            this.itE.setGravity(5);
        }
        if (((r) this.qib).qgc == null || ((r) this.qib).qgc.length() <= 0) {
            this.itE.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.itE.setTextColor(Color.parseColor(((r) this.qib).qgc));
            } catch (Exception e) {
                w.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((r) this.qib).qgc);
            }
        }
        if (((r) this.qib).hbf > 0.0f) {
            this.itE.setTextSize(0, ((r) this.qib).hbf);
        }
        TextPaint paint = this.itE.getPaint();
        if (((r) this.qib).qgd) {
            paint.setFakeBoldText(true);
        }
        if (((r) this.qib).qge) {
            paint.setTextSkewX(-0.25f);
        }
        if (((r) this.qib).qgf) {
            paint.setUnderlineText(true);
        }
        if (((r) this.qib).maxLines > 0) {
            this.itE.setMaxLines(((r) this.qib).maxLines);
        }
    }

    @TargetApi(17)
    public final View bgf() {
        View view = this.ipu;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(f.pDV).setBackgroundColor(this.backgroundColor);
        view.findViewById(f.pDW).setBackgroundColor(this.backgroundColor);
        this.itE = (TextView) view.findViewById(f.pDW);
        return view;
    }

    public final void bfP() {
        super.bfP();
    }

    public final void bfQ() {
        super.bfQ();
    }
}
