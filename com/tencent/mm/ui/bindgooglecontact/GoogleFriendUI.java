package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleFriendUI extends MMActivity implements OnItemClickListener, a, com.tencent.mm.x.d.a, e {
    private boolean RE = false;
    private HashMap<String, o> hEq = new HashMap();
    private String hEr;
    private int jis;
    private ProgressDialog kIa;
    private TextView mDo;
    private String mZT;
    private String vsI;
    private ListView vsQ;
    private a vsR;
    private com.tencent.mm.ag.c vsS;
    private ArrayList<o> vsT = new ArrayList();
    private boolean vso = false;
    private String vsq;

    public enum a {
        SUCCESS,
        NO_CONTACT,
        ACCESS_DEDY,
        OTHER
    }

    class b extends AsyncTask<Void, Void, Void> {
        private String hEr;
        private Context mContext;
        final /* synthetic */ GoogleFriendUI vsU;
        private a vtc;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCW();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPostExecute");
            if (this.vtc != a.SUCCESS) {
                GoogleFriendUI.a(this.vsU, this.vtc, null);
            } else if (this.vsU.vsT == null || this.vsU.vsT.size() <= 0) {
                GoogleFriendUI.a(this.vsU, a.NO_CONTACT, null);
            } else {
                GoogleFriendUI.a(this.vsU, a.SUCCESS, this.vsU.vsT);
            }
        }

        private b(GoogleFriendUI googleFriendUI, Context context, String str) {
            this.vsU = googleFriendUI;
            this.vtc = a.OTHER;
            this.mContext = context;
            this.hEr = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "onPreExecute");
            this.vsU.vsT.clear();
            this.vsU.hEq.clear();
        }

        private Void aCW() {
            w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "doInBackground");
            int i = 0;
            int i2 = 1;
            while (true) {
                try {
                    String m;
                    Object obj;
                    w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "startInde:%d, totalCount:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                    w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "requestURL:%s", new Object[]{new URL("https://www.google.com/m8/feeds/contacts/default/property-email?alt=" + "json" + "&max-results=100&start-index=" + i2 + "&access_token=" + this.hEr).toString()});
                    HttpURLConnection httpURLConnection = (HttpURLConnection) r6.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(20000);
                    int responseCode = httpURLConnection.getResponseCode();
                    w.i("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                    if (responseCode == m.CTRL_INDEX) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        m = m(inputStream);
                        inputStream.close();
                    } else {
                        if (responseCode == 401) {
                            w.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Server OAuth Error,Please Try Again.");
                        } else {
                            w.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "Unknow Error.");
                        }
                        httpURLConnection.disconnect();
                        m = null;
                    }
                    responseCode = new JSONObject(m).getJSONObject("feed").getJSONObject("openSearch$totalResults").getInt("$t");
                    if (responseCode > 0) {
                        Tg(m);
                    }
                    if (responseCode - i2 > 100) {
                        i2 += 100;
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj == null || this.vsU.RE) {
                        this.vtc = a.SUCCESS;
                    } else {
                        i = responseCode;
                    }
                } catch (IOException e) {
                    this.vtc = a.ACCESS_DEDY;
                    w.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "IOException" + e.getMessage());
                } catch (JSONException e2) {
                    this.vtc = a.OTHER;
                    w.e("MicroMsg.GoogleContact.GoogleAPIAsyncTask", "JSONException" + e2.getMessage());
                }
            }
            this.vtc = a.SUCCESS;
            return null;
        }

        private static String m(InputStream inputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[20480];
            while (true) {
                int read = inputStream.read(bArr, 0, 20480);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }

        private void Tg(String str) {
            JSONArray jSONArray = new JSONObject(str).getJSONObject("feed").getJSONArray("entry");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string;
                    int lastIndexOf;
                    int i2;
                    String string2;
                    CharSequence substring;
                    int i3;
                    o oVar;
                    String str2 = "";
                    String str3 = "";
                    String str4 = "";
                    JSONObject optJSONObject = jSONArray.getJSONObject(i).optJSONObject(SlookAirButtonFrequentContactAdapter.ID);
                    JSONObject optJSONObject2 = jSONArray.getJSONObject(i).optJSONObject("title");
                    JSONArray optJSONArray = jSONArray.getJSONObject(i).optJSONArray("gd$email");
                    JSONArray optJSONArray2 = jSONArray.getJSONObject(i).optJSONArray("link");
                    if (optJSONObject != null) {
                        string = optJSONObject.getString("$t");
                        lastIndexOf = string.lastIndexOf("/");
                        if (lastIndexOf > 0) {
                            string = string.substring(lastIndexOf + 1);
                            if (optJSONObject2 == null) {
                                str2 = optJSONObject2.getString("$t");
                            } else {
                                str2 = str3;
                            }
                            if (optJSONArray2 != null) {
                                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                                    lastIndexOf = string2.lastIndexOf("#");
                                    if (lastIndexOf > 0) {
                                        substring = string2.substring(lastIndexOf + 1);
                                        if (!TextUtils.isEmpty(substring) && SlookAirButtonFrequentContactAdapter.PHOTO.equals(substring)) {
                                            str4 = optJSONArray2.getJSONObject(i2).getString("href");
                                        }
                                    }
                                }
                            }
                            str3 = str4;
                            if (optJSONArray != null) {
                                for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    string2 = optJSONArray.getJSONObject(i3).getString("address");
                                    if (!(TextUtils.isEmpty(string2) || !bg.PK(string2) || string2.equals(this.vsU.vsq))) {
                                        oVar = new o();
                                        oVar.field_googleid = string;
                                        oVar.field_googleitemid = string + string2;
                                        oVar.field_googlename = str2;
                                        oVar.field_googlephotourl = str3;
                                        oVar.field_googlegmail = string2;
                                        if (!this.vsU.hEq.containsKey(string2)) {
                                            this.vsU.vsT.add(oVar);
                                            this.vsU.hEq.put(string2, oVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    string = str2;
                    if (optJSONObject2 == null) {
                        str2 = str3;
                    } else {
                        str2 = optJSONObject2.getString("$t");
                    }
                    if (optJSONArray2 != null) {
                        for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            string2 = optJSONArray2.getJSONObject(i2).getString("rel");
                            lastIndexOf = string2.lastIndexOf("#");
                            if (lastIndexOf > 0) {
                                substring = string2.substring(lastIndexOf + 1);
                                str4 = optJSONArray2.getJSONObject(i2).getString("href");
                            }
                        }
                    }
                    str3 = str4;
                    if (optJSONArray != null) {
                        for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                            string2 = optJSONArray.getJSONObject(i3).getString("address");
                            oVar = new o();
                            oVar.field_googleid = string;
                            oVar.field_googleitemid = string + string2;
                            oVar.field_googlename = str2;
                            oVar.field_googlephotourl = str3;
                            oVar.field_googlegmail = string2;
                            if (!this.vsU.hEq.containsKey(string2)) {
                                this.vsU.vsT.add(oVar);
                                this.vsU.hEq.put(string2, oVar);
                            }
                        }
                    }
                }
            }
        }
    }

    class c extends AsyncTask<Void, Void, Void> {
        private String vsE;
        private boolean vsG;
        private String vsI;
        final /* synthetic */ GoogleFriendUI vsU;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return aCW();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPostExecute");
            GoogleFriendUI.a(this.vsU, this.vsG, this.vsE);
        }

        public c(GoogleFriendUI googleFriendUI, String str) {
            this.vsU = googleFriendUI;
            this.vsI = str;
        }

        protected final void onPreExecute() {
            super.onPreExecute();
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "onPreExecute");
            this.vsG = false;
        }

        private Void aCW() {
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "doInBackground");
            try {
                String str = "";
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("refresh_token", this.vsI));
                arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
                arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
                arrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
                String F = n.F(arrayList);
                w.i("MicroMsg.GoogleContact.GoogleFriendUI", "QueryString:%s" + F);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(F);
                bufferedWriter.flush();
                bufferedWriter.close();
                int responseCode = httpURLConnection.getResponseCode();
                w.e("MicroMsg.GoogleContact.GoogleFriendUI", "responseCode:" + responseCode);
                if (m.CTRL_INDEX == responseCode) {
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    bufferedReader.close();
                    str = stringBuffer.toString();
                    w.i("MicroMsg.GoogleContact.GoogleFriendUI", "exchange token respone:%s" + str);
                }
                httpURLConnection.disconnect();
                w.i("MicroMsg.GoogleContact.GoogleFriendUI", "refresh response:%s", new Object[]{str});
                this.vsE = new JSONObject(str).optString("access_token");
                this.vsG = true;
            } catch (ProtocolException e) {
                w.e("MicroMsg.GoogleContact.GoogleFriendUI", "ProtocolException:%s", new Object[]{e.getMessage()});
            } catch (MalformedURLException e2) {
                w.e("MicroMsg.GoogleContact.GoogleFriendUI", "MalformedURLException:%s", new Object[]{e2.getMessage()});
            } catch (IOException e3) {
                w.e("MicroMsg.GoogleContact.GoogleFriendUI", "IOException:%s", new Object[]{e3.getMessage()});
            } catch (JSONException e4) {
                w.e("MicroMsg.GoogleContact.GoogleFriendUI", "JSONException:%s", new Object[]{e4.getMessage()});
            }
            return null;
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, a aVar, ArrayList arrayList) {
        w.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] success:%s", new Object[]{aVar});
        if (aVar == a.SUCCESS && !googleFriendUI.RE) {
            googleFriendUI.vsS = new com.tencent.mm.ag.c(arrayList, googleFriendUI.jis, googleFriendUI.hEq, googleFriendUI.hEr);
            ap.vd().a(googleFriendUI.vsS, 0);
        } else if (aVar == a.NO_CONTACT) {
            googleFriendUI.Xs();
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "Google Contact is Empty.");
            googleFriendUI.la(true);
        } else if (aVar == a.ACCESS_DEDY) {
            googleFriendUI.Xs();
            if (am.isConnected(googleFriendUI)) {
                w.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI No Login or network unavaile.");
                googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
                googleFriendUI.finish();
                return;
            }
            googleFriendUI.la(false);
        } else if (!googleFriendUI.RE) {
            w.i("MicroMsg.GoogleContact.GoogleFriendUI", "[handleGetGoogleContactListTaskReturn] start bindGoogleContactUI unknow error");
            googleFriendUI.Xs();
            googleFriendUI.startActivity(new Intent(googleFriendUI, BindGoogleContactUI.class));
            googleFriendUI.finish();
        }
    }

    static /* synthetic */ void a(GoogleFriendUI googleFriendUI, boolean z, String str) {
        if (!z || TextUtils.isEmpty(str)) {
            googleFriendUI.Xs();
            googleFriendUI.la(false);
            return;
        }
        googleFriendUI.hEr = str;
        ap.yY();
        com.tencent.mm.u.c.vr().set(208902, str);
        googleFriendUI.bTf();
    }

    protected final int getLayoutId() {
        return R.i.dfv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        this.vsq = (String) com.tencent.mm.u.c.vr().get(208903, null);
        if (TextUtils.isEmpty(this.vsq)) {
            finish();
        }
        this.jis = getIntent().getIntExtra("enter_scene", 0);
        this.vsR = new a(this, this.vsq);
        this.vsR.vsJ = this;
        KC();
        this.vso = n.aV(this);
        if (this.vso) {
            w.d("MicroMsg.GoogleContact.GoogleFriendUI", "startActivityCheckGooglePlayServices");
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 2005);
        } else {
            bTe();
        }
        af.Gg().clear();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(488, this);
        ap.vd().a(489, this);
        com.tencent.mm.x.n.Bl().d(this);
        if (this.vsR != null) {
            this.vsR.OK();
        }
    }

    protected void onStop() {
        super.onStop();
        ap.vd().b(488, this);
        ap.vd().b(489, this);
        com.tencent.mm.x.n.Bl().e(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        af.Gg().clear();
    }

    protected final void KC() {
        zi(R.l.epN);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GoogleFriendUI vsU;

            {
                this.vsU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vsU.finish();
                return true;
            }
        });
        this.mDo = (TextView) findViewById(R.h.empty);
        this.vsQ = (ListView) findViewById(R.h.bVg);
        this.vsQ.setAdapter(this.vsR);
        this.vsQ.setOnItemClickListener(this);
        p pVar = new p(true, true);
        pVar.woe = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ GoogleFriendUI vsU;

            {
                this.vsU = r1;
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                this.vsU.mZT = bg.my(str);
                if (this.vsU.vsR != null) {
                    this.vsU.vsR.yD(this.vsU.mZT);
                }
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final void OF() {
            }

            public final void OG() {
            }
        };
        a(pVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        w.d("MicroMsg.GoogleContact.GoogleFriendUI", "onItemClick position:%d,", new Object[]{Integer.valueOf(i)});
        if (this.vsR != null) {
            o oVar = (o) this.vsR.getItem(i - this.vsQ.getHeaderViewsCount());
            if (oVar != null) {
                String str = oVar.field_username;
                w.d("MicroMsg.GoogleContact.GoogleFriendUI", "jumpToProfile email:%s, username:%s", new Object[]{oVar.field_googlegmail, str});
                ap.yY();
                com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
                Intent intent;
                if ((Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) && TextUtils.isEmpty(oVar.field_nickname)) {
                    intent = new Intent(this, InviteFriendUI.class);
                    intent.putExtra("friend_type", 2);
                    intent.putExtra("friend_user_name", str);
                    intent.putExtra("friend_num", oVar.field_googlegmail);
                    intent.putExtra("friend_nick", oVar.field_googlename);
                    intent.putExtra("friend_weixin_nick", oVar.field_nickname);
                    intent.putExtra("friend_googleID", oVar.field_googleid);
                    intent.putExtra("friend_googleItemID", oVar.field_googleitemid);
                    intent.putExtra("friend_scene", 58);
                    intent.putExtra("Contact_Scene", 58);
                    startActivity(intent);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Nick", oVar.field_nickname);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("verify_gmail", oVar.field_googlegmail);
                intent.putExtra("profileName", oVar.field_googlename);
                intent.putExtra("Contact_Source_FMessage", 58);
                intent.putExtra("Contact_Scene", 58);
                if (str != null && str.length() > 0) {
                    com.tencent.mm.plugin.c.a.imv.d(intent, this.uSU.uTo);
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.GoogleContact.GoogleFriendUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 2005) {
            return;
        }
        if (i2 == -1) {
            this.vso = intent.getBooleanExtra("gpservices", false);
            bTe();
            return;
        }
        this.vso = intent.getBooleanExtra("gpservices", false);
        finish();
    }

    private void bTe() {
        w.d("MicroMsg.GoogleContact.GoogleFriendUI", "updateToken");
        if (this.vso) {
            ap.yY();
            this.hEr = (String) com.tencent.mm.u.c.vr().get(208901, null);
        } else {
            ap.yY();
            this.hEr = (String) com.tencent.mm.u.c.vr().get(208902, null);
            ap.yY();
            this.vsI = (String) com.tencent.mm.u.c.vr().get(208904, null);
        }
        if (TextUtils.isEmpty(this.hEr) || (!this.vso && TextUtils.isEmpty(this.vsI))) {
            v(BindGoogleContactUI.class);
            finish();
        } else if (this.vso) {
            bTf();
        } else {
            amU();
            new c(this, this.vsI).execute(new Void[0]);
        }
    }

    public final void AE(int i) {
        if (this.vsR != null) {
            o oVar = (o) this.vsR.getItem(i);
            if (oVar != null) {
                switch (oVar.field_status) {
                    case 0:
                        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                            final /* synthetic */ GoogleFriendUI vsU;

                            {
                                this.vsU = r1;
                            }

                            public final void a(boolean z, boolean z2, String str, String str2) {
                                w.d("MicroMsg.GoogleContact.GoogleFriendUI", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                                if (z || z2) {
                                    w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{str2});
                                    af.Gg().x(str2, 1);
                                } else {
                                    af.Gg().x(str2, 2);
                                }
                                this.vsU.vsR.OK();
                            }
                        });
                        String str = oVar.field_googleitemid;
                        aVar.sLV = false;
                        aVar.sLU = true;
                        aVar.sLW = str;
                        aVar.sLV = false;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(Integer.valueOf(58));
                        aVar.b(oVar.field_username, linkedList, true);
                        oVar.field_googlecgistatus = 0;
                        af.Gg().b(oVar);
                        this.vsR.OK();
                        return;
                    case 1:
                        Cursor ji = af.Gg().ji(oVar.field_googleid);
                        if (ji == null || ji.getCount() <= 1) {
                            a(oVar, null);
                        } else {
                            a(ji, oVar);
                        }
                        if (ji != null) {
                            ji.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = TextUtils.isEmpty(str) ? "" : str;
        w.i(str2, str3, objArr);
        int type = kVar.getType();
        if (i != 0 || i2 != 0) {
            switch (type) {
                case 30:
                case 137:
                    if (i2 == -87) {
                        g.b(this, getString(R.l.dXI), "", true);
                    } else if ((i2 == -24 || i2 == -101) && !bg.mA(str)) {
                        Toast.makeText(this, str, 1).show();
                    }
                    if (this.vsR != null) {
                        w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{((com.tencent.mm.pluginsdk.model.n) kVar).hEk});
                        af.Gg().x(r0, 2);
                        this.vsR.OK();
                        break;
                    }
                    break;
                case 488:
                    la(false);
                    break;
                case 489:
                    if (this.vsR != null) {
                        w.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[]{Integer.valueOf(((com.tencent.mm.ag.b) kVar).Gu().jNd)});
                        w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{r11.hEk});
                        af.Gg().x(r0, 1);
                        this.vsR.OK();
                        break;
                    }
                    break;
                default:
                    w.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                    break;
            }
        }
        switch (type) {
            case 30:
            case 137:
                if (this.vsR != null) {
                    w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{((com.tencent.mm.pluginsdk.model.n) kVar).hEk});
                    af.Gg().x(r0, 1);
                    this.vsR.OK();
                    break;
                }
                break;
            case 488:
                a(((com.tencent.mm.ag.c) kVar).Gv());
                break;
            case 489:
                if (this.vsR != null) {
                    w.i("MicroMsg.GoogleContact.GoogleFriendUI", "count:%d", new Object[]{Integer.valueOf(((com.tencent.mm.ag.b) kVar).Gu().jNd)});
                    w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{r11.hEk});
                    af.Gg().x(r0, 1);
                    this.vsR.OK();
                    break;
                }
                break;
            default:
                w.w("MicroMsg.GoogleContact.GoogleFriendUI", "Unknow scene type.");
                break;
        }
        Xs();
    }

    public final void ho(String str) {
        if (this.vsR != null) {
            this.vsR.notifyDataSetChanged();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void a(Cursor cursor, final o oVar) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar2 = new o();
                oVar2.b(cursor);
                arrayList.add(oVar2.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar2);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.uSU.uTo;
        String string = getResources().getString(R.l.epU);
        getResources().getString(R.l.dGs);
        g.a(context, string, arrayList, arrayList2, new d(this) {
            final /* synthetic */ GoogleFriendUI vsU;

            public final void bN(int i, int i2) {
                if (i2 != -1) {
                    this.vsU.a((o) arrayList3.get(i2), oVar);
                }
            }
        });
    }

    private void a(o oVar, o oVar2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(oVar.field_googlegmail);
        k bVar = new com.tencent.mm.ag.b(arrayList);
        w.d("MicroMsg.GoogleContact.GoogleFriendUI", "gmailItem:%s", new Object[]{oVar.field_googleitemid});
        ap.vd().a(bVar, 0);
        if (oVar2 == null) {
            bVar.hEk = oVar.field_googleitemid;
            oVar.field_googlecgistatus = 0;
            af.Gg().b(oVar);
        } else {
            bVar.hEk = oVar2.field_googleitemid;
            oVar2.field_googlecgistatus = 0;
            af.Gg().b(oVar2);
        }
        this.vsR.OK();
    }

    private void bTf() {
        this.RE = false;
        amU();
        new b(this, this.hEr).execute(new Void[0]);
    }

    private synchronized void a(ajl com_tencent_mm_protocal_c_ajl) {
        w.i("MicroMsg.GoogleContact.GoogleFriendUI", "handleListGoogleContactCGIResponse Count:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ajl.jNd)});
        if (this.vsR != null) {
            this.vsR.OK();
        }
    }

    private void la(boolean z) {
        CharSequence string;
        this.mDo.setVisibility(0);
        if (!am.isConnected(this)) {
            string = getString(R.l.epT);
        } else if (z) {
            string = getString(R.l.epM);
        } else {
            string = getString(R.l.epL);
        }
        this.mDo.setText(string);
    }

    private void amU() {
        if (this.kIa == null || !this.kIa.isShowing()) {
            getString(R.l.dIO);
            this.kIa = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ GoogleFriendUI vsU;

                {
                    this.vsU = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.vsU.RE = true;
                    ap.vd().c(this.vsU.vsS);
                }
            });
        }
    }

    private void Xs() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }
}
