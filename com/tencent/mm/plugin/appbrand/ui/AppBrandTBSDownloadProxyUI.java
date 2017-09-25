package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.d;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.q;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.t;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean jkq = false;
    p irJ;
    private a jko = null;
    private Runnable jkp;
    private Handler mHandler;

    private final class a implements q {
        final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

        public a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
            this.jkr = appBrandTBSDownloadProxyUI;
        }

        public final void iu(int i) {
            w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", new Object[]{Integer.valueOf(i)});
            j.dJ(5, i);
            if (i == 100 || i == 120 || i == 122) {
                g.oUh.a(366, 4, 1, false);
            } else {
                g.oUh.a(366, 5, 1, false);
            }
            SharedPreferences sharedPreferences;
            if (i != MMGIFException.D_GIF_ERR_CLOSE_FAILED) {
                if (i == 100 || i == 120 || i == 122) {
                    g.oUh.n(64, 64, 4, 3);
                } else {
                    this.jkr.jko = null;
                    QbSdk.setTbsListener(this.jkr.jko);
                    g.oUh.a(64, 3, 1, false);
                    this.jkr.setResult(0, new Intent());
                    this.jkr.finish();
                }
                sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    Editor edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                    return;
                }
                return;
            }
            sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            this.jkr.jko = null;
            QbSdk.setTbsListener(this.jkr.jko);
            this.jkr.setResult(0, new Intent());
            this.jkr.finish();
        }

        public final void iv(int i) {
            w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", new Object[]{Integer.valueOf(i)});
            if (this.jkr.irJ != null) {
                this.jkr.irJ.dismiss();
                this.jkr.irJ = null;
            }
            j.dJ(6, i);
            if (i == m.CTRL_INDEX || i == 220) {
                g.oUh.n(64, 64, 7, 6);
                g.oUh.a(366, 6, 1, false);
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                this.jkr.sendBroadcast(intent);
                this.jkr.jko = null;
                QbSdk.setTbsListener(this.jkr.jko);
                this.jkr.setResult(-1, new Intent());
                this.jkr.finish();
                return;
            }
            g.oUh.a(64, 6, 1, false);
            g.oUh.a(366, 7, 1, false);
            this.jkr.jko = null;
            QbSdk.setTbsListener(this.jkr.jko);
            this.jkr.setResult(0, new Intent());
            this.jkr.finish();
        }

        public final void iw(final int i) {
            w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", new Object[]{Integer.valueOf(i)});
            if (this.jkr.irJ != null) {
                af.v(new Runnable(this) {
                    final /* synthetic */ a jku;

                    public final void run() {
                        this.jku.jkr.irJ.setMessage(this.jku.jkr.uSU.uTo.getString(R.l.dGr, new Object[]{String.valueOf(i)}));
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (!appBrandTBSDownloadProxyUI.isFinishing() && !appBrandTBSDownloadProxyUI.uSW) {
            OnClickListener anonymousClass6 = new OnClickListener(appBrandTBSDownloadProxyUI) {
                final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

                {
                    this.jkr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.oUh.a(366, 2, 1, false);
                    com.tencent.mm.pluginsdk.model.w.a.jj(false);
                    j.mN(2);
                    if (!this.jkr.isFinishing() && !this.jkr.uSW) {
                        AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = this.jkr;
                        Context context = this.jkr.uSU.uTo;
                        this.jkr.uSU.uTo.getString(R.l.dIO);
                        appBrandTBSDownloadProxyUI.irJ = com.tencent.mm.ui.base.g.a(context, this.jkr.uSU.uTo.getString(R.l.dGq), true, null);
                        this.jkr.irJ.setOnCancelListener(new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass6 jkt;

                            {
                                this.jkt = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                                this.jkt.jkr.setResult(2, new Intent());
                                this.jkt.jkr.finish();
                            }
                        });
                        AppBrandTBSDownloadProxyUI.b(this.jkr);
                        this.jkr.WZ();
                    }
                }
            };
            OnClickListener anonymousClass7 = new OnClickListener(appBrandTBSDownloadProxyUI) {
                final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

                {
                    this.jkr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.oUh.a(366, 3, 1, false);
                    w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
                    com.tencent.mm.pluginsdk.model.w.a.jj(false);
                    this.jkr.setResult(2, new Intent());
                    this.jkr.finish();
                }
            };
            com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(appBrandTBSDownloadProxyUI.uSU.uTo);
            aVar.SX(appBrandTBSDownloadProxyUI.uSU.uTo.getString(R.l.dGp));
            aVar.kK(false);
            aVar.zZ(R.l.dGo).a(anonymousClass6);
            aVar.Aa(R.l.dGn).b(anonymousClass7);
            aVar.WJ().show();
            com.tencent.mm.pluginsdk.model.w.a.jj(true);
            g.oUh.a(366, 1, 1, false);
        }
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (appBrandTBSDownloadProxyUI.jko == null) {
            appBrandTBSDownloadProxyUI.jko = new a(appBrandTBSDownloadProxyUI);
        }
        QbSdk.setTbsListener(appBrandTBSDownloadProxyUI.jko);
        j.mN(3);
        l.r(ab.getContext(), true);
    }

    static {
        TbsLog.setTbsLogClient(new t(ab.getContext()) {
            public final void qQ(String str) {
                w.i("AppBrandTBSDownloadProxyUI.TBSDownloadMgr.TbsLogClient", "TbsLogClient: " + str);
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.irJ = com.tencent.mm.ui.base.g.a(this.uSU.uTo, null, true, null);
        this.irJ.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

            {
                this.jkr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                this.jkr.setResult(2, new Intent());
                this.jkr.finish();
            }
        });
        g.a(getWindow());
        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        sendBroadcast(intent);
        boolean atk = l.atk();
        boolean tBSInstalling = QbSdk.getTBSInstalling();
        boolean cep = l.cep();
        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", new Object[]{Boolean.valueOf(atk), Boolean.valueOf(tBSInstalling)});
        if (atk || tBSInstalling) {
            if (cep) {
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (jkq) {
                    setResult(0, new Intent());
                    finish();
                    return;
                }
                if (this.jko == null) {
                    this.jko = new a(this);
                }
                QbSdk.setTbsListener(this.jko);
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                Context context = this.uSU.uTo;
                this.uSU.uTo.getString(R.l.dIO);
                this.irJ = com.tencent.mm.ui.base.g.a(context, this.uSU.uTo.getString(R.l.dGq), true, null);
                if (this.irJ.getWindow() != null) {
                    LayoutParams attributes = this.irJ.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.irJ.getWindow().setAttributes(attributes);
                }
                this.irJ.setOnCancelListener(new OnCancelListener(this) {
                    final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

                    {
                        this.jkr = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                        this.jkr.setResult(2, new Intent());
                        this.jkr.finish();
                    }
                });
                WZ();
                return;
            }
            w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            l.stopDownload();
        }
        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        l.a(this.uSU.uTo, false, true, new com.tencent.smtt.sdk.l.a(this) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

            {
                this.jkr = r1;
            }

            public final void e(boolean z, int i) {
                if (!z || i < 36824) {
                    w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
                    this.jkr.setResult(0, new Intent());
                    this.jkr.finish();
                    return;
                }
                w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 jks;

                    {
                        this.jks = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                        AppBrandTBSDownloadProxyUI.a(this.jks.jkr);
                    }
                });
            }
        });
    }

    private void WZ() {
        this.mHandler = new Handler();
        this.jkp = new Runnable(this) {
            final /* synthetic */ AppBrandTBSDownloadProxyUI jkr;

            {
                this.jkr = r1;
            }

            public final void run() {
                AppBrandTBSDownloadProxyUI.jkq = true;
                this.jkr.setResult(0, new Intent());
                this.jkr.finish();
            }
        };
        this.mHandler.postDelayed(this.jkp, 20000);
    }

    protected final void onDestroy() {
        w.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.jkp == null)) {
            this.mHandler.removeCallbacks(this.jkp);
        }
        super.onDestroy();
    }
}
