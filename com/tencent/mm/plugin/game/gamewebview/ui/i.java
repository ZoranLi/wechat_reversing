package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.d.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.QBarLogicTask;
import com.tencent.mm.plugin.webview.d.g;
import com.tencent.mm.plugin.webview.d.g.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageData;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView.HitTestResult;

public final class i implements OnCreateContextMenuListener {
    public l iYI;
    String iYJ;
    public int iYK;
    public int iYL;
    public g iYM;
    HitTestResult iYN;
    IX5WebViewBase.HitTestResult iYO;
    private c iYR = new c(this) {
        final /* synthetic */ i mnN;

        {
            this.mnN = r1;
        }

        public final void pF(String str) {
            GWMainProcessTask qBarLogicTask = new QBarLogicTask();
            qBarLogicTask.type = 1;
            qBarLogicTask.fOa = str;
            GameWebViewMainProcessService.a(qBarLogicTask);
        }
    };
    public MMActivity iwk;
    private e mmH;
    public b mmy;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String iYT;
        final /* synthetic */ i mnN;

        public AnonymousClass3(i iVar, String str) {
            this.mnN = iVar;
            this.iYT = str;
        }

        public final void run() {
            if (this.mnN.mmy != null) {
                this.mnN.iYJ = this.iYT;
                this.mnN.iYI.b(this.mnN.mmy, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ AnonymousClass3 mnO;

                    {
                        this.mnO = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        if (this.mnO.mnN.iYN != null) {
                            w.d("MicroMsg.GameWebViewMenuListHelper", "show webkit menu");
                            this.mnO.mnN.a(contextMenu, this.mnO.mnN.iYN);
                            this.mnO.mnN.iYN = null;
                        } else if (this.mnO.mnN.iYO != null) {
                            w.d("MicroMsg.GameWebViewMenuListHelper", "show IX5 menu");
                            this.mnO.mnN.a(contextMenu, this.mnO.mnN.iYO);
                            this.mnO.mnN.iYO = null;
                        }
                    }
                }, null);
                this.mnN.iYI.blb();
            }
        }
    }

    public i(MMActivity mMActivity, b bVar, e eVar) {
        this.iwk = mMActivity;
        this.mmy = bVar;
        this.mmH = eVar;
        this.iYI = new l(mMActivity);
        this.iYI.a(this.mmy, this, null);
        this.iYI.e(new OnCancelListener(this) {
            final /* synthetic */ i mnN;

            {
                this.mnN = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.mnN.iYM != null) {
                    GWMainProcessTask qBarLogicTask = new QBarLogicTask();
                    qBarLogicTask.type = 1;
                    qBarLogicTask.fOa = this.mnN.iYM.rZF;
                    GameWebViewMainProcessService.a(qBarLogicTask);
                    this.mnN.iYM.bxd();
                }
            }
        });
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        w.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        if (view instanceof WebView) {
            HitTestResult hitTestResult = this.mmy.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    a(contextMenu, hitTestResult);
                    return;
                }
                return;
            }
            return;
        }
        IX5WebViewBase.HitTestResult hitTestResult2 = ((IX5WebViewBase) view).getHitTestResult();
        if (hitTestResult2 == null) {
            return;
        }
        if (hitTestResult2.getType() == 5 || hitTestResult2.getType() == 8) {
            a(contextMenu, hitTestResult2);
        }
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        if (f.rZ()) {
            boolean azg = d.azg();
            contextMenu.setHeaderTitle(R.l.fnH);
            w.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", new Object[]{Boolean.valueOf(azg)});
            if (azg) {
                contextMenu.add(0, 0, 0, this.iwk.getString(R.l.eHR)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ i mnN;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        s.a(this.mnN.iwk, str, CookieManager.getInstance().getCookie(str), f.rZ(), new s.b(this) {
                            final /* synthetic */ AnonymousClass4 mnP;

                            {
                                this.mnP = r1;
                            }

                            public final void pG(String str) {
                                if (bg.mA(str)) {
                                    w.w("MicroMsg.GameWebViewMenuListHelper", "share image to friend fail, imgPath is null");
                                    return;
                                }
                                CommonActivityTask commonActivityTask = new CommonActivityTask(this.mnP.mnN.iwk);
                                commonActivityTask.type = 2;
                                commonActivityTask.lHw.putString("img_path", str);
                                commonActivityTask.avz();
                            }
                        });
                        return true;
                    }
                });
            }
            contextMenu.add(0, 0, 0, this.iwk.getString(R.l.eOm)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ i mnN;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(this.mnN.iwk, str, CookieManager.getInstance().getCookie(str), f.rZ());
                    } catch (Exception e) {
                        w.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", new Object[]{e.getMessage()});
                    }
                    return true;
                }
            });
            if (azg) {
                contextMenu.add(0, 0, 0, this.iwk.getString(R.l.eGa)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ i mnN;

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(this.mnN.iwk, replaceAll, CookieManager.getInstance().getCookie(replaceAll), f.rZ(), new s.b(this) {
                            final /* synthetic */ AnonymousClass6 mnQ;

                            {
                                this.mnQ = r1;
                            }

                            public final void pG(String str) {
                                i iVar = this.mnQ.mnN;
                                GWMainProcessTask commonLogicTask = new CommonLogicTask();
                                commonLogicTask.type = 7;
                                commonLogicTask.lHw.putString("image_path", str);
                                GameWebViewMainProcessService.b(commonLogicTask);
                                com.tencent.mm.pluginsdk.model.c.a(commonLogicTask.lHw.getInt("fav_simple_img_result"), 34, iVar.iwk, j.mnV);
                            }
                        });
                        return true;
                    }
                });
            }
            if (this.iYJ == null) {
                return false;
            }
            CharSequence string;
            final String str2 = this.iYJ;
            if (this.iYK == 22) {
                string = this.iwk.getString(R.l.eIB);
            } else {
                string = this.iwk.getString(R.l.eIA);
            }
            contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ i mnN;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    w.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
                    CommonActivityTask commonActivityTask = new CommonActivityTask(this.mnN.iwk);
                    commonActivityTask.type = 1;
                    commonActivityTask.lHw.putString("result", str2);
                    Bundle bundle = commonActivityTask.lHw;
                    String str = SlookSmartClipMetaTag.TAG_TYPE_URL;
                    i iVar = this.mnN;
                    bundle.putString(str, iVar.mmy != null ? iVar.mmy.getUrl() : "");
                    commonActivityTask.lHw.putInt("codeType", this.mnN.iYK);
                    commonActivityTask.lHw.putInt("codeVersion", this.mnN.iYL);
                    commonActivityTask.avz();
                    return false;
                }
            });
            this.iYJ = null;
            return true;
        }
        w.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        return true;
    }

    public final void a(ContextMenu contextMenu, IX5WebViewBase.HitTestResult hitTestResult) {
        if (!a(contextMenu, ((ImageData) hitTestResult.getData()).mPicUrl) && this.mmH.bxR().bHi() && aAf()) {
            this.iYO = hitTestResult;
            this.iYM = new g();
            this.iYM.a(this.mmy, this.iYR);
        }
    }

    public final void a(ContextMenu contextMenu, HitTestResult hitTestResult) {
        if (!a(contextMenu, hitTestResult.getExtra()) && this.mmH.bxR().bHi() && aAf()) {
            this.iYN = hitTestResult;
            this.iYM = new g();
            this.iYM.a(this.mmy, this.iYR);
        }
    }

    private static boolean aAf() {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 5;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.lHw.getBoolean("allow_webview_scan", false);
    }
}
