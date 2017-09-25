package com.tencent.mm.plugin.gms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.auth.b;
import com.google.android.gms.auth.c;
import com.google.android.gms.auth.d;
import com.google.android.gms.common.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.io.IOException;

public class MMGoogleAuthUtil extends Activity {
    private String hEr;
    private String iRe;
    private String mKf;
    public int mKg = 0;

    class a extends AsyncTask<Void, Void, Void> {
        private String iMT;
        private String iRe;
        private int jUO;
        private Context mContext;
        private boolean mKh = false;
        private boolean mKi;
        private String mKj;
        final /* synthetic */ MMGoogleAuthUtil mKk;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCW();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (!this.mKh) {
                Intent intent;
                if (this.mKi) {
                    intent = new Intent();
                    intent.putExtra("error_code", 0);
                    intent.putExtra("token", this.mKk.hEr);
                    this.mKk.setResult(-1, intent);
                    this.mKk.finish();
                    return;
                }
                intent = new Intent();
                intent.putExtra("error_code", -1);
                intent.putExtra("error_msg", this.iMT);
                this.mKk.setResult(-1, intent);
                this.mKk.finish();
            }
        }

        public a(MMGoogleAuthUtil mMGoogleAuthUtil, Context context, String str, String str2) {
            this.mKk = mMGoogleAuthUtil;
            this.mContext = context;
            this.mKj = str;
            this.iRe = str2;
            this.mKh = false;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            this.mKi = false;
        }

        private Void aCW() {
            try {
                this.mKk.hEr = b.c(this.mContext, this.mKj, this.iRe);
                this.mKi = true;
                this.jUO = 0;
            } catch (c e) {
                this.iMT = e.getMessage();
                this.jUO = -2;
            } catch (d e2) {
                d dVar = e2;
                this.iMT = dVar.getMessage();
                this.jUO = -3;
                if (this.mKk.mKg < 4) {
                    MMGoogleAuthUtil mMGoogleAuthUtil = this.mKk;
                    mMGoogleAuthUtil.mKg++;
                    this.mKh = true;
                    this.mKk.startActivityForResult(dVar.PC == null ? null : new Intent(dVar.PC), MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
                }
            } catch (IOException e3) {
                this.iMT = e3.getMessage();
                this.jUO = -4;
            } catch (com.google.android.gms.auth.a e4) {
                this.iMT = e4.getMessage();
                this.jUO = -5;
            } catch (Exception e5) {
                this.iMT = e5.getMessage();
                this.jUO = -1;
            }
            return null;
        }
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        Intent intent = getIntent();
        Intent intent2 = new Intent();
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                if (action.equals("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT")) {
                    String[] strArr = new String[]{"com.google"};
                    intent = new Intent();
                    intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
                    intent.setPackage("com.google.android.gms");
                    intent.putExtra("allowableAccounts", null);
                    intent.putExtra("allowableAccountTypes", strArr);
                    intent.putExtra("addAccountOptions", null);
                    intent.putExtra("selectedAccount", null);
                    intent.putExtra("alwaysPromptForAccount", false);
                    intent.putExtra("descriptionTextOverride", null);
                    intent.putExtra("authTokenType", null);
                    intent.putExtra("addAccountRequiredFeatures", null);
                    intent.putExtra("setGmsCoreAccount", false);
                    intent.putExtra("overrideTheme", 0);
                    intent.putExtra("overrideCustomTheme", 0);
                    startActivityForResult(intent, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
                    return;
                } else if (action.equals("com.tencent.mm.gms.ACTION_GET_TOKEN")) {
                    this.mKf = intent.getStringExtra("gmail");
                    this.iRe = intent.getStringExtra("scope");
                    cu(this.mKf, this.iRe);
                    return;
                } else if (action.equals("com.tencent.mm.gms.CHECK_GP_SERVICES")) {
                    int w = e.w(this);
                    new StringBuilder().append(w);
                    action = "gpservices";
                    if (w != 0) {
                        z = false;
                    }
                    intent2.putExtra(action, z);
                    setResult(-1, intent2);
                    finish();
                }
            }
        }
        intent2.putExtra("error_msg", "null intent or action.");
        setResult(-1, intent2);
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    String stringExtra = intent.getStringExtra("authAccount");
                    Intent intent2 = new Intent();
                    intent2.putExtra("error_code", 0);
                    intent2.putExtra("account", stringExtra);
                    setResult(-1, intent2);
                    finish();
                    return;
                case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                    cu(this.mKf, this.iRe);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
            case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                Intent intent3 = new Intent();
                intent3.putExtra("error_code", -1);
                intent3.putExtra("error_msg", "User Cancel.");
                setResult(i2, intent3);
                finish();
                return;
            default:
                return;
        }
    }

    private void cu(String str, String str2) {
        new a(this, this, str, str2).execute(new Void[0]);
    }
}
