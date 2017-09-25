package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.a;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.y.e;
import java.io.FileOutputStream;

public class ShowQRCodeStep1UI extends MMActivity implements e {
    private ProgressDialog isv = null;
    private int pip = 1;
    private ImageView piu = null;
    byte[] piv = null;

    protected final int getLayoutId() {
        return R.i.doB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vd().a(bw.CTRL_INDEX, this);
    }

    public void onDestroy() {
        ap.vd().b(bw.CTRL_INDEX, this);
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eRg);
        this.piu = (ImageView) findViewById(R.h.cCo);
        this.pip = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(R.h.cFi);
        if (this.pip == 3) {
            textView.setText(getString(R.l.eQK, new Object[]{getString(R.l.eQO)}));
        } else if (this.pip == 4) {
            textView.setText(getString(R.l.eQK, new Object[]{getString(R.l.eQL)}));
        } else if (this.pip == 2) {
            textView.setText(getString(R.l.eQK, new Object[]{getString(R.l.eQN)}));
        } else {
            textView.setText(getString(R.l.eQK, new Object[]{getString(R.l.eQM)}));
        }
        aZO();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI piw;

            {
                this.piw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.piw.aHf();
                this.piw.finish();
                return true;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI piw;

            {
                this.piw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Context context = this.piw;
                g.a(context, "", new String[]{context.getString(R.l.eQF), context.getString(R.l.eQJ)}, "", false, new c(context) {
                    final /* synthetic */ ShowQRCodeStep1UI piw;

                    {
                        this.piw = r1;
                    }

                    public final void hq(int i) {
                        FileOutputStream fileOutputStream;
                        Throwable e;
                        switch (i) {
                            case 0:
                                this.piw.aZO();
                                return;
                            case 1:
                                Context context = this.piw;
                                byte[] bArr = context.piv;
                                if (bArr != null && bArr.length > 0) {
                                    String str = k.bGD() + "mmqrcode" + System.currentTimeMillis() + ".png";
                                    try {
                                        fileOutputStream = new FileOutputStream(str);
                                        try {
                                            fileOutputStream.write(bArr);
                                            Toast.makeText(context, context.getString(R.l.eaX, new Object[]{str}), 1).show();
                                            k.b(str, context);
                                            try {
                                                fileOutputStream.close();
                                                return;
                                            } catch (Exception e2) {
                                                return;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            try {
                                                w.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                        return;
                                                    } catch (Exception e4) {
                                                        return;
                                                    }
                                                }
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Exception e5) {
                                                    }
                                                }
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        fileOutputStream = null;
                                        w.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e, "", new Object[0]);
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        fileOutputStream = null;
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        ((Button) findViewById(R.h.cCp)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI piw;

            {
                this.piw = r1;
            }

            public final void onClick(View view) {
                if (this.piw.pip == 3) {
                    byte[] vc = ap.vc();
                    String xL = m.xL();
                    ap.yY();
                    w.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[]{bg.Qj(bg.bo(vc)), xL, Integer.valueOf(bg.f((Integer) com.tencent.mm.u.c.vr().get(66561, null)))});
                    w.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[]{"http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.n(vc) + "&u=" + xL + "&qr=" + r0 + "&device=" + d.DEVICE_TYPE + "&version=" + d.sYN});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    intent.putExtra("title", this.piw.getString(R.l.eQS));
                    com.tencent.mm.bb.d.b(this.piw, "webview", ".ui.tools.WebViewUI", intent);
                    this.piw.finish();
                } else if (this.piw.pip == 4) {
                    if (m.ym()) {
                        r0 = new Intent(this.piw, ShareToQQUI.class);
                        r0.putExtra("show_to", 4);
                        this.piw.startActivity(r0);
                    } else {
                        this.piw.v(FacebookAuthUI.class);
                    }
                    this.piw.finish();
                } else if (this.piw.pip == 2) {
                    r0 = new Intent(this.piw, ShareToQQUI.class);
                    r0.putExtra("show_to", 2);
                    this.piw.startActivity(r0);
                    this.piw.finish();
                } else {
                    r0 = new Intent(this.piw, ShareToQQUI.class);
                    r0.putExtra("show_to", 1);
                    this.piw.startActivity(r0);
                    this.piw.finish();
                }
            }
        });
    }

    final void aZO() {
        final com.tencent.mm.y.k aVar = new a();
        ap.vd().a(aVar, 0);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.eQI), true, new OnCancelListener(this) {
            final /* synthetic */ ShowQRCodeStep1UI piw;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(aVar);
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!com.tencent.mm.plugin.setting.a.imw.b(this.uSU.uTo, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.piv = ((a) kVar).hOD;
                this.piu.setImageBitmap(com.tencent.mm.sdk.platformtools.d.bd(this.piv));
                return;
            }
            Toast.makeText(this, getString(R.l.elS, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
