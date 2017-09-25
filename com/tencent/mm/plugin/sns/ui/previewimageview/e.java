package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class e implements v {
    private Context context;
    private ImageView qEp;
    private boolean qOo;
    public c qOp;
    DynamicGridView qOq;
    public a qOr;
    public float qOs;
    public View qOt;
    ImageView qOu;
    private View qOv;
    Rect qOw;
    TextView qtP;

    public e(final View view, View view2, View view3, final Context context, List<String> list, final DynamicGridView dynamicGridView, a aVar, c.a aVar2, boolean z) {
        this.qOo = z;
        this.context = context;
        this.qOr = aVar;
        this.qOt = view2;
        this.qOv = view3;
        this.qOq = dynamicGridView;
        this.qOu = (ImageView) view2.findViewById(f.pCh);
        this.qtP = (TextView) view2.findViewById(f.pCj);
        dynamicGridView.setColumnWidth(context.getResources().getDimensionPixelSize(d.pzq) + (context.getResources().getDimensionPixelSize(d.pzp) * 2));
        dynamicGridView.setNumColumns(4);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.qOp = new c(context, list, 9, z, aVar2);
        blu();
        dynamicGridView.setAdapter(this.qOp);
        dynamicGridView.qOX = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e(this) {
            final /* synthetic */ e qOy;

            public final void ul(int i) {
                w.i("DynamicGrid", "drag started at position " + i);
                if (VERSION.SDK_INT >= 21) {
                    this.qOy.qOs = dynamicGridView.getElevation();
                    dynamicGridView.setElevation(100.0f);
                } else {
                    dynamicGridView.bringToFront();
                }
                e eVar = this.qOy;
                eVar.qOt.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.qOt, "translationY", new float[]{(float) eVar.qOt.getHeight(), 0.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                this.qOy.blv();
            }

            public final void um(int i) {
                w.i("DynamicGrid", "drag to del " + i);
                a aVar = this.qOy.qOp;
                Object item = aVar.getItem(i);
                aVar.eh.remove(item);
                aVar.qOh.remove(item);
                aVar.notifyDataSetChanged();
                if (aVar.qOm != null) {
                    aVar.qOm.removeItem(i - aVar.qOi);
                }
            }

            public final void l(Rect rect) {
                if (m(rect)) {
                    e eVar = this.qOy;
                    eVar.qOt.setBackgroundColor(Color.parseColor("#ce3c39"));
                    eVar.qOu.setImageResource(i.pJm);
                    eVar.qtP.setText("松手即可删除");
                    return;
                }
                this.qOy.blw();
            }

            public final void blx() {
                e eVar = this.qOy;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.qOt, "translationY", new float[]{0.0f, (float) eVar.qOt.getHeight()});
                ofFloat.setDuration(200);
                ofFloat.addListener(new AnimatorListener(eVar) {
                    final /* synthetic */ e qOy;

                    {
                        this.qOy = r1;
                    }

                    public final void onAnimationStart(Animator animator) {
                        this.qOy.blw();
                    }

                    public final void onAnimationEnd(Animator animator) {
                        this.qOy.qOt.setVisibility(4);
                        this.qOy.qOt.setTranslationY(0.0f);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        this.qOy.qOt.setVisibility(4);
                        this.qOy.qOt.setTranslationY(0.0f);
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofFloat.start();
                this.qOy.qOp.bls();
            }

            public final boolean m(Rect rect) {
                e eVar = this.qOy;
                if (rect == null) {
                    return false;
                }
                if (eVar.qOw == null) {
                    eVar.qOw = new Rect(eVar.qOt.getLeft(), eVar.qOt.getTop(), eVar.qOt.getRight(), eVar.qOt.getBottom());
                }
                w.d("DynamicGrid", "del area " + eVar.qOw + ", test rect " + rect);
                return eVar.qOw.intersects(rect.left, rect.top, rect.right, rect.bottom);
            }
        };
        dynamicGridView.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ e qOy;

            {
                this.qOy = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                return true;
            }
        });
        dynamicGridView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ e qOy;

            {
                this.qOy = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.qOy.qOr != null && view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    w.i("DynamicGrid", "click " + intValue);
                    if (intValue != Integer.MAX_VALUE) {
                        this.qOy.qOr.tL(intValue);
                    }
                }
            }
        });
        dynamicGridView.qOW = new DynamicGridView.f(this) {
            final /* synthetic */ e qOy;

            public final void bly() {
                DynamicGridView dynamicGridView = dynamicGridView;
                dynamicGridView.llp = false;
                dynamicGridView.requestDisallowInterceptTouchEvent(false);
                if (DynamicGridView.blD() && dynamicGridView.qOT) {
                    dynamicGridView.hP(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    dynamicGridView.setElevation(this.qOy.qOs);
                } else {
                    view.bringToFront();
                }
            }
        };
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ e qOy;

            public final boolean onPreDraw() {
                dynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) dynamicGridView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, view.getHeight() - (context.getResources().getDimensionPixelSize(d.pzo) + (context.getResources().getDimensionPixelSize(d.pzp) * 2)), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                dynamicGridView.setLayoutParams(marginLayoutParams);
                return true;
            }
        });
    }

    private void blu() {
        if (!ab.bIY().getBoolean("key_show_tips", true) || this.qOp.blt() <= 1) {
            this.qOv.setVisibility(8);
            return;
        }
        this.qOv.setVisibility(0);
        this.qEp = (ImageView) this.qOv.findViewById(f.pEQ);
        this.qEp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e qOy;

            {
                this.qOy = r1;
            }

            public final void onClick(View view) {
                this.qOy.blv();
            }
        });
    }

    public final void blv() {
        this.qOv.setVisibility(8);
        ab.bIY().edit().putBoolean("key_show_tips", false).commit();
    }

    public final void biV() {
        this.qOo = false;
    }

    public final void a(a aVar) {
        this.qOr = aVar;
    }

    public final View getView() {
        return this.qOq;
    }

    public final void bz(List<String> list) {
        if (this.qOp != null) {
            this.qOp.bE(list);
            blu();
        }
    }

    public final void clean() {
        if (this.qOq != null && this.qOq.getAdapter() == null) {
            ((c) this.qOq.getAdapter()).qwE = true;
        }
    }

    public final void blw() {
        this.qOt.setBackgroundColor(Color.parseColor("#e64340"));
        this.qOu.setImageResource(i.pJl);
        this.qtP.setText("拖动到此处删除");
    }
}
