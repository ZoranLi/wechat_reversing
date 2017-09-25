package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.d;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.e;
import com.tencent.mm.x.n;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import junit.framework.Assert;

public class FriendPreference extends Preference implements a {
    public MMActivity fCi;
    private int fRf;
    private TextView ioX;
    public x jiL;
    private boolean lib;
    private TextView ouW;
    private ImageView ouX;
    private ImageView ouY;
    public b ouZ;
    private String ova;
    private long ovb;
    private long ovc;
    private String ovd;

    class AnonymousClass2 implements e.b {
        final /* synthetic */ e hqH;
        final /* synthetic */ String hqR;
        final /* synthetic */ String otR;
        final /* synthetic */ FriendPreference ovf;

        AnonymousClass2(FriendPreference friendPreference, e eVar, String str, String str2) {
            this.ovf = friendPreference;
            this.hqH = eVar;
            this.hqR = str;
            this.otR = str2;
        }

        public final int aM(int i, int i2) {
            this.hqH.Bp();
            w.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 0 && i2 == 0) {
                n.Bl();
                if (this.ovf.p(this.otR, d.hl(this.hqR))) {
                    Toast.makeText(this.ovf.mContext, this.ovf.mContext.getString(R.l.dZv), 0).show();
                    return 0;
                }
            }
            Toast.makeText(this.ovf.mContext, this.ovf.mContext.getString(R.l.dZt), 0).show();
            return 0;
        }
    }

    public final /* synthetic */ CharSequence getSummary() {
        return this.ouW.getText().toString();
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        init();
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.diC);
        setWidgetLayoutResource(R.i.djm);
        init();
    }

    private void init() {
        this.lib = false;
        this.jiL = null;
        this.ouZ = null;
        this.ova = "";
        this.ovb = 0;
        this.ovc = 0;
        this.fRf = 0;
        this.ovd = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.diI, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ioX = (TextView) view.findViewById(R.h.title);
        this.ouW = (TextView) view.findViewById(R.h.summary);
        this.ouX = (ImageView) view.findViewById(R.h.bWV);
        this.ouY = (ImageView) view.findViewById(R.h.ckI);
        this.lib = true;
        KC();
        super.onBindView(view);
    }

    private void KC() {
        if (this.jiL == null || !this.lib) {
            w.d("MicroMsg.FriendPreference", "initView : contact = " + this.jiL + " bindView = " + this.lib);
        } else if (this.ovb != -1 && new o(this.ovb).longValue() > 0) {
            setWidgetLayoutResource(R.i.djn);
            if (this.jiL == null || !this.lib) {
                w.d("MicroMsg.FriendPreference", "initView : contact = " + this.jiL + " bindView = " + this.lib);
                return;
            }
            this.fRf = 2;
            this.ioX.setText(this.mContext.getString(R.l.dYq));
            this.ouW.setText(bg.mz(this.ova) + " " + new o(this.ovb).longValue());
            r0 = com.tencent.mm.x.b.Q(this.ovb);
            if (r0 == null) {
                r0 = com.tencent.mm.compatible.f.a.decodeStream(this.mContext.getResources().openRawResource(R.k.dwu));
            }
            if (r0 != null) {
                r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                if (r1 != r0) {
                    r0.recycle();
                }
                this.ouX.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
            }
            ap.yY();
            if (!c.isSDCardAvailable()) {
                this.ouX.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.bes));
            }
        } else if (this.ouZ != null) {
            setWidgetLayoutResource(R.i.djg);
            if (this.jiL == null || !this.lib) {
                w.d("MicroMsg.FriendPreference", "initView : contact = " + this.jiL + " bindView = " + this.lib);
            } else if (this.ouZ != null) {
                this.fRf = 1;
                this.ioX.setText(this.mContext.getString(R.l.dYp));
                final Object obj = bg.mz(this.ouZ.ER()) + " " + bg.mz(this.ouZ.EX()).replace(" ", "");
                this.ouW.setText(obj);
                r1 = m.a(this.ouZ.EQ(), this.mContext);
                if (r1 == null) {
                    this.ouX.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.dwt));
                } else {
                    this.ouX.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(r1, 48, 48, false), true, 0.0f));
                }
                ap.yY();
                if (c.wR().QY(this.ouZ.getUsername())) {
                    this.ouY.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ FriendPreference ovf;

                        public final void onClick(View view) {
                            String[] stringArray;
                            if (this.ovf.ouZ == null || bg.mA(this.ovf.ouZ.hrv)) {
                                stringArray = this.ovf.fCi.getResources().getStringArray(R.c.aSn);
                            } else {
                                stringArray = this.ovf.fCi.getResources().getStringArray(R.c.aSm);
                            }
                            if (com.tencent.mm.plugin.profile.a.imw.oz()) {
                                List f = bg.f(stringArray);
                                f.add(this.ovf.fCi.getResources().getString(R.l.dUX));
                                stringArray = (String[]) f.toArray(new String[f.size()]);
                                g.oUh.i(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                            }
                            com.tencent.mm.ui.base.g.a(this.ovf.fCi, null, stringArray, null, new com.tencent.mm.ui.base.g.c(this) {
                                final /* synthetic */ AnonymousClass1 ovg;

                                public final void hq(int i) {
                                    String substring;
                                    switch (i) {
                                        case 0:
                                            if (obj != null && obj.length() != 0) {
                                                int lastIndexOf = obj.lastIndexOf(32) + 1;
                                                if (lastIndexOf > 0) {
                                                    FriendPreference friendPreference = this.ovg.ovf;
                                                    substring = obj.substring(lastIndexOf);
                                                    Intent intent = new Intent("android.intent.action.DIAL");
                                                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(substring).toString()));
                                                    friendPreference.fCi.startActivity(intent);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 1:
                                            if (obj != null && obj.length() != 0) {
                                                substring = obj.substring(0, obj.lastIndexOf(32));
                                                if (substring != null && substring.length() != 0) {
                                                    com.tencent.mm.u.o.b(this.ovg.ovf.jiL, substring.trim());
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (stringArray != null && stringArray.length > 2 && this.ovg.ovf.ouZ != null && this.ovg.ovf.jiL != null) {
                                                if (!(this.ovg.ovf.ouZ == null || bg.mA(this.ovg.ovf.ouZ.hrv))) {
                                                    Preference preference = this.ovg.ovf;
                                                    String str = this.ovg.ovf.jiL.field_username;
                                                    String str2 = this.ovg.ovf.ouZ.hrv;
                                                    if (bg.mA(str) || bg.mA(str2)) {
                                                        Toast.makeText(preference.mContext, preference.mContext.getString(R.l.dZt), 0).show();
                                                        return;
                                                    }
                                                    n.Bl();
                                                    Bitmap hl = d.hl(str);
                                                    if (hl == null) {
                                                        Toast.makeText(preference.mContext, preference.mContext.getString(R.l.dZu), 0).show();
                                                        e eVar = new e();
                                                        eVar.a(str, new AnonymousClass2(preference, eVar, str, str2));
                                                        return;
                                                    } else if (preference.p(str2, hl)) {
                                                        Toast.makeText(preference.mContext, preference.mContext.getString(R.l.dZv), 0).show();
                                                        return;
                                                    } else {
                                                        Toast.makeText(preference.mContext, preference.mContext.getString(R.l.dZt), 0).show();
                                                        return;
                                                    }
                                                }
                                            }
                                            return;
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            return;
                                    }
                                    Intent intent2 = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("fromScene", 2);
                                    intent2.putExtra("reportArgs", bundle);
                                    com.tencent.mm.plugin.profile.a.imv.k(intent2, this.ovg.ovf.fCi);
                                }
                            });
                        }
                    });
                } else {
                    this.ouY.setVisibility(4);
                }
            }
        } else if (this.ovc > 0) {
            if (this.jiL == null || !this.lib) {
                w.d("MicroMsg.FriendPreference", "initView : contact = " + this.jiL + " bindView = " + this.lib);
                return;
            }
            this.fRf = 3;
            this.ioX.setText(this.mContext.getString(R.l.erf));
            this.ouW.setText(bg.mz(this.jiL.gks));
            r0 = com.tencent.mm.x.b.gZ(this.ovc);
            if (r0 == null) {
                r0 = com.tencent.mm.compatible.f.a.decodeStream(this.mContext.getResources().openRawResource(R.k.dwu));
            }
            if (r0 != null) {
                r1 = Bitmap.createScaledBitmap(r0, 48, 48, false);
                if (r1 != r0) {
                    r0.recycle();
                }
                this.ouX.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(r1, true, 0.0f));
            }
            ap.yY();
            if (!c.isSDCardAvailable()) {
                this.ouX.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.bes));
            }
        } else if (TextUtils.isEmpty(this.ovd)) {
            Assert.assertTrue(false);
        } else if (this.jiL == null || !this.lib) {
            w.d("MicroMsg.FriendPreference", "initView : contact = " + this.jiL + " bindView = " + this.lib);
        } else {
            this.fRf = 3;
            this.ioX.setText(this.mContext.getString(R.l.eJd));
            this.ouW.setText(bg.mz(this.ovd));
            this.ouX.setVisibility(8);
        }
    }

    public final boolean p(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return m.a(str, this.mContext, byteArrayOutputStream.toByteArray());
    }

    public final boolean adI() {
        n.Bl().e(this);
        return true;
    }

    public final void ho(String str) {
        long hb = com.tencent.mm.x.b.hb(str);
        if (hb > 0 && this.ovb == hb && com.tencent.mm.x.b.a(str, false, -1) != null) {
            KC();
        }
        if (com.tencent.mm.x.b.ha(str) == this.ovc && com.tencent.mm.x.b.a(str, false, -1) != null) {
            KC();
        }
    }
}
