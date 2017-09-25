package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.NumberKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.e;

public final class a {
    public static String TAG = "MicroMsg.CommonHintViewConfig";

    private static class b implements com.tencent.mm.wallet_core.ui.formview.a.a {
        public final void bsk() {
        }

        public boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
            return false;
        }
    }

    private static class c implements com.tencent.mm.wallet_core.ui.formview.a.b {
        public boolean h(WalletFormView walletFormView) {
            return true;
        }

        public boolean c(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean d(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean aWt() {
            return false;
        }

        public String e(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    public static class a extends c {
        private int wFL;
        private WalletFormView wFM;

        public final /* bridge */ /* synthetic */ boolean aWt() {
            return super.aWt();
        }

        public final /* bridge */ /* synthetic */ boolean c(WalletFormView walletFormView, String str) {
            return super.c(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ boolean d(WalletFormView walletFormView, String str) {
            return super.d(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ String e(WalletFormView walletFormView, String str) {
            return super.e(walletFormView, str);
        }

        public a(WalletFormView walletFormView) {
            this(1, walletFormView);
        }

        public a(int i, WalletFormView walletFormView) {
            this.wFL = 1;
            this.wFM = walletFormView;
            this.wFL = 1;
            ccK();
        }

        public final void CN(int i) {
            this.wFL = i;
            ccK();
        }

        private void ccK() {
            if (this.wFL == 1) {
                if (this.wFM != null) {
                    this.wFM.setKeyListener(new NumberKeyListener(this) {
                        final /* synthetic */ a wFN;

                        {
                            this.wFN = r1;
                        }

                        public final int getInputType() {
                            return 1;
                        }

                        protected final char[] getAcceptedChars() {
                            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                        }
                    });
                }
            } else if (this.wFM != null) {
                this.wFM.setInputType(1);
            }
        }

        public final boolean h(WalletFormView walletFormView) {
            return walletFormView.wFX == null ? false : walletFormView.wFX.isAreaIDCardNum(this.wFL);
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView) {
        if (editHintPasswdView != null) {
            editHintPasswdView.wFS = 1;
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        if (editHintPasswdView != null) {
            editHintPasswdView.wFS = z ? -10 : 20;
        }
    }

    public static void a(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.wGa = new c() {
                public final boolean c(WalletFormView walletFormView, String str) {
                    if (bg.mA(str) || str.length() > 5) {
                        return false;
                    }
                    walletFormView.setSelection(0);
                    if (walletFormView.wFX != null) {
                        walletFormView.wFX.setBankcardTailNum(str);
                    }
                    walletFormView.oNN = 24 - str.length();
                    walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.oNN)});
                    return true;
                }

                public final boolean d(WalletFormView walletFormView, String str) {
                    if (bg.mA(str) || str.length() > 5) {
                        return false;
                    }
                    walletFormView.setSelection(0);
                    if (walletFormView.wFX != null) {
                        walletFormView.wFX.set3DesEncrptData(str);
                    }
                    walletFormView.oNN = 24 - str.length();
                    walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.oNN)});
                    return true;
                }

                public final boolean h(WalletFormView walletFormView) {
                    return walletFormView.wFX == null ? false : walletFormView.wFX.isBankcardNum();
                }
            };
        }
    }

    public static void a(final MMActivity mMActivity, final WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
            return;
        }
        walletFormView.wGa = new c() {
            public final boolean aWt() {
                return true;
            }

            public final String e(WalletFormView walletFormView, String str) {
                return bg.ap((String) walletFormView.getTag(), "").replace("/", "");
            }
        };
        b.f(mMActivity, walletFormView);
        walletFormView.j(new OnClickListener() {
            public final void onClick(View view) {
                walletFormView.getContext();
                int cco = s.cco();
                walletFormView.getContext();
                b.a(mMActivity, cco, s.ccp());
            }
        });
    }

    public static void b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.j(new OnClickListener() {
                public final void onClick(View view) {
                    walletFormView.getContext();
                    b.a(mMActivity, s.ccq(), R.l.ebh);
                }
            });
        }
    }

    public static void b(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.wGa = new a(1, walletFormView);
        }
    }

    public static void c(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
            return;
        }
        walletFormView.wGa = new a(walletFormView);
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void d(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.wGa = new c() {
                public final boolean h(WalletFormView walletFormView) {
                    return bg.PK(walletFormView.getText());
                }
            };
        }
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
            return;
        }
        walletFormView.j(new OnClickListener() {
            public final void onClick(View view) {
                b.a(mMActivity, R.i.dri, R.l.feJ);
            }
        });
        walletFormView.wGa = new c() {
            public final boolean h(WalletFormView walletFormView) {
                return walletFormView.wFX == null ? false : walletFormView.wFX.isPhoneNum();
            }
        };
    }

    public static void d(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
            return;
        }
        walletFormView.j(new OnClickListener() {
            public final void onClick(View view) {
                g.a(mMActivity, mMActivity.getString(R.l.feG), mMActivity.getString(R.l.feE), mMActivity.getString(R.l.feF), mMActivity.getString(R.l.feH), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 wFK;

                    {
                        this.wFK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.m(mMActivity, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
                        com.tencent.mm.sdk.b.a.urY.m(new rt());
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 wFK;

                    {
                        this.wFK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }
        });
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void e(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
            return;
        }
        walletFormView.j(new OnClickListener() {
            public final void onClick(View view) {
                b.a(mMActivity, R.i.dqN, R.l.feE);
            }
        });
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void e(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.wGa = new c() {
                public final boolean h(WalletFormView walletFormView) {
                    return walletFormView.wFX == null ? false : walletFormView.wFX.isMoneyAmount();
                }
            };
        }
    }

    public static void f(WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else if (walletFormView.wFX != null) {
            walletFormView.wFX.setIsSecurityAnswerFormat(true);
        }
    }

    public static void g(final WalletFormView walletFormView) {
        if (walletFormView == null) {
            w.e(TAG, "hy: param error");
        } else {
            walletFormView.wFZ = new b() {
                public final boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
                    if (!walletFormView.b(walletFormView.oNt, motionEvent) || motionEvent.getAction() != 1) {
                        return super.a(walletFormView, motionEvent);
                    }
                    w.d(a.TAG, "hy: click on info iv");
                    walletFormView.performClick();
                    return true;
                }
            };
        }
    }
}
