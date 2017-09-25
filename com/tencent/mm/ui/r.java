package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bh.e;
import com.tencent.mm.sdk.platformtools.w;

public final class r {
    public static final int[] uVa = new int[]{16843087, 16843088, 16843379};
    public static final int[] uVb = new int[]{16843379};

    private static final class a implements Factory {
        LayoutInflater uVc;

        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            View view = null;
            try {
                if (str.indexOf(".") == -1) {
                    View createView;
                    if (str.equals("WebView")) {
                        createView = createView(str, "android.webkit.", attributeSet);
                    } else {
                        createView = null;
                    }
                    if (createView == null) {
                        createView = createView(str, "android.widget.", attributeSet);
                    }
                    view = createView == null ? createView(str, "android.view.", attributeSet) : createView;
                } else {
                    view = this.uVc.createView(str, null, attributeSet);
                }
                if ((view instanceof ViewStub) && VERSION.SDK_INT >= 21) {
                    ((ViewStub) view).setLayoutInflater(this.uVc);
                }
                if (view == null) {
                    w.w("MicroMsg.MMLayoutInflater", "Inflate view, ClassNotFound " + str);
                } else if (str.equals("TextView") || str.equals("Button") || str.equals("EditText") || str.equals("CheckBox") || str.equals("ImageView") || str.equals("CheckedTextView") || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.base.PasterEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.ui.tools.MMTruncTextView") || str.equals("com.tencent.mm.plugin.brandservice.ui.base.CatalogView") || str.equals("com.tencent.mm.ui.tools.CustomFitTextView") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView") || str.equals("com.tencent.mm.plugin.game.ui.GameDropdownView") || str.equals("com.tencent.mm.ui.ScrollAlwaysTextView") || str.equals("com.tencent.mm.ui.base.MMAutoSizeTextView") || str.equals("com.tencent.mm.ui.widget.MMAutoAdjustTextView") || str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") || str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText") || str.equals("com.tencent.mm.kiss.widget.textview.PLSysTextView")) {
                    float f;
                    float dI = com.tencent.mm.bg.a.dI(context);
                    if ((dI != 1.875f && dI != 2.025f) || str.equals("com.tencent.mm.ui.widget.MMTextView") || str.equals("com.tencent.mm.plugin.sns.ui.AsyncTextView") || str.equals("com.tencent.mm.plugin.sns.ui.SnsTextView") || str.equals("com.tencent.mm.plugin.sns.ui.MaskTextView")) {
                        f = dI;
                    } else {
                        f = 1.625f;
                    }
                    TextView textView;
                    TypedArray obtainStyledAttributes;
                    int i;
                    int resourceId;
                    if (str.equals("TextView") || str.equals("com.tencent.mm.ui.widget.MMTextView")) {
                        textView = (TextView) view;
                        textView.setTextSize(1, (f * textView.getTextSize()) / com.tencent.mm.bg.a.getDensity(textView.getContext()));
                        context.getAssets();
                        e.bHG();
                        if (e.bHH()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.uVa);
                            for (i = 0; i < r.uVa.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (r.uVa[i] == 16843379) {
                                        textView.setContentDescription(context.getString(resourceId));
                                    } else if (r.uVa[i] == 16843088) {
                                        textView.setHint(context.getString(resourceId));
                                    } else {
                                        textView.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("Button")) {
                        Button button = (Button) view;
                        button.setTextSize(1, (f * button.getTextSize()) / com.tencent.mm.bg.a.getDensity(button.getContext()));
                        context.getAssets();
                        e.bHG();
                        if (e.bHH()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.uVa);
                            for (i = 0; i < r.uVa.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (r.uVa[i] == 16843379) {
                                        button.setContentDescription(context.getString(resourceId));
                                    } else if (r.uVa[i] == 16843088) {
                                        button.setHint(context.getString(resourceId));
                                    } else {
                                        button.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("EditText") || str.equals("com.tencent.mm.ui.widget.MMEditText") || str.equals("com.tencent.mm.ui.base.MMClearEditText") || str.equals("com.tencent.mm.ui.base.PasterEditText") || str.equals("com.tencent.mm.ui.tools.ActionBarSearchView$ActionBarEditText") || str.equals("com.tenpay.android.wechat.TenpaySecureEditText") || str.equals("com.tencent.mm.ui.base.MMVisiblePasswordEditText") || str.equals("com.tencent.mm.plugin.sns.ui.SnsEditText")) {
                        EditText editText = (EditText) view;
                        editText.setTextSize(1, (f * editText.getTextSize()) / com.tencent.mm.bg.a.getDensity(editText.getContext()));
                        context.getAssets();
                        e.bHG();
                        if (e.bHH()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.uVa);
                            for (i = 0; i < r.uVa.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (r.uVa[i] == 16843379) {
                                        editText.setContentDescription(context.getString(resourceId));
                                    } else if (r.uVa[i] == 16843088) {
                                        editText.setHint(context.getString(resourceId));
                                    } else {
                                        editText.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("CheckBox")) {
                        CheckBox checkBox = (CheckBox) view;
                        checkBox.setTextSize(1, (f * checkBox.getTextSize()) / com.tencent.mm.bg.a.getDensity(checkBox.getContext()));
                        context.getAssets();
                        e.bHG();
                        if (e.bHH()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.uVa);
                            for (i = 0; i < r.uVa.length; i++) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0) {
                                    if (r.uVa[i] == 16843379) {
                                        checkBox.setContentDescription(context.getString(resourceId));
                                    } else if (r.uVa[i] == 16843088) {
                                        checkBox.setHint(context.getString(resourceId));
                                    } else {
                                        checkBox.setText(context.getString(resourceId));
                                    }
                                }
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else if (str.equals("ImageView")) {
                        ImageView imageView = (ImageView) view;
                        context.getAssets();
                        e.bHG();
                        if (e.bHH()) {
                            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.uVb);
                            i = 0;
                            while (i < r.uVb.length) {
                                resourceId = obtainStyledAttributes.getResourceId(i, 0);
                                if (resourceId != 0 && r.uVb[i] == 16843379) {
                                    imageView.setContentDescription(context.getString(resourceId));
                                }
                                i++;
                            }
                            obtainStyledAttributes.recycle();
                        }
                    } else {
                        textView = (TextView) view;
                        textView.setTextSize(1, (f * textView.getTextSize()) / com.tencent.mm.bg.a.getDensity(textView.getContext()));
                    }
                }
            } catch (ClassNotFoundException e) {
                w.w("MicroMsg.MMLayoutInflater", "[cpan] class not found. name:%s. Use default Inflate.", str);
            } catch (InflateException e2) {
                w.w("MicroMsg.MMLayoutInflater", "[cpan] Inflate failed. name:%s. Use default Inflate.", str);
            }
            return view;
        }

        private View createView(String str, String str2, AttributeSet attributeSet) {
            View view = null;
            try {
                view = this.uVc.createView(str, str2, attributeSet);
            } catch (InflateException e) {
            } catch (ClassNotFoundException e2) {
            }
            return view;
        }
    }

    public static LayoutInflater b(LayoutInflater layoutInflater) {
        com.tencent.mm.bg.a.dI(layoutInflater.getContext());
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(layoutInflater.getContext());
        Factory aVar = new a();
        aVar.uVc = cloneInContext;
        cloneInContext.setFactory(aVar);
        return cloneInContext;
    }

    public static LayoutInflater eC(Context context) {
        com.tencent.mm.bg.a.dI(context);
        LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
        Factory aVar = new a();
        aVar.uVc = cloneInContext;
        cloneInContext.setFactory(aVar);
        return cloneInContext;
    }
}
