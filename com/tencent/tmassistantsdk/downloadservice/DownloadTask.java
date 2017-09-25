package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.l.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.logreport.DownloadReportManager;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DownloadTask {
    public static final String TAG = "_DownloadTask";
    protected DownloadInfo mDownloadInfo = null;
    HttpClient mHttpClient = null;
    HttpGet mHttpGet = null;
    protected final byte[] mRecvBuf = new byte[Downloads.RECV_BUFFER_SIZE];
    TMAssistantFile mSaveFile;
    protected boolean mStopTask = false;
    protected final int mTaskId = GlobalUtil.getMemUUID();

    public DownloadTask(DownloadInfo downloadInfo) {
        this.mDownloadInfo = downloadInfo;
    }

    public int getTaskId() {
        return this.mTaskId;
    }

    public void cancel() {
        TMLog.i(TAG, "DownloadTask::cancel url: " + this.mDownloadInfo.mURL);
        this.mStopTask = true;
        if (this.mHttpGet != null && !this.mHttpGet.isAborted()) {
            this.mHttpGet.abort();
        }
    }

    public String getDownloadURI() {
        return this.mDownloadInfo.mURL;
    }

    public int getPriority() {
        return this.mDownloadInfo.mPriority;
    }

    public void exec(String str) {
        boolean z;
        this.mDownloadInfo.mTaskIsRunning = true;
        this.mDownloadInfo.updateStatus(2, false);
        boolean z2 = false;
        boolean z3 = true;
        while (z3) {
            DownloadChunkLogInfo createNewChunkLogInfo = DownloadReportManager.getInstance().createNewChunkLogInfo((byte) 0);
            createNewChunkLogInfo.UUID = this.mDownloadInfo.mUUID;
            createNewChunkLogInfo.currentRetryCnt = (byte) this.mDownloadInfo.mRetryCnt;
            createNewChunkLogInfo.requestUrl = getDownloadURI();
            if (this.mStopTask) {
                break;
            }
            String str2;
            if (z2) {
                try {
                    str2 = this.mDownloadInfo.mSecondaryUrl;
                } catch (Throwable e) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "ConnectTimeoutException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 601;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e2) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "SocketTimeoutException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e2, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 602;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e22) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "UnknownHostException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e22, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 603;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e222) {
                    if (!this.mStopTask) {
                        TMLog.i(TAG, "InterruptedException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z3 = false;
                    }
                    z3 = false;
                } catch (Throwable e2222) {
                    if (!this.mStopTask) {
                        TMLog.i(TAG, "SSLHandshakeException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e2222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = Downloads.DOWNLOAD_ERR_SSL_HANDSHAKE_EXCEPTION;
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z3 = false;
                    }
                    z3 = false;
                } catch (Throwable e22222) {
                    if (this.mStopTask) {
                        z3 = false;
                    } else {
                        TMLog.i(TAG, "IOException " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e22222, "", new Object[0]);
                        z3 = shouldRetryConnect();
                        if (!z3) {
                            this.mDownloadInfo.mDownloadFailedErrCode = 606;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                } catch (Throwable e222222) {
                    if (this.mStopTask) {
                        z3 = z2;
                        z2 = false;
                    } else {
                        TMLog.i(TAG, "StopRequestException, errCode = " + e222222.mFinalErrCode + " " + Thread.currentThread().getName());
                        w.printErrStackTrace(TAG, e222222, "", new Object[0]);
                        this.mDownloadInfo.mDownloadFailedErrCode = e222222.mFinalErrCode;
                        if (e222222.mFinalErrCode == 703 || e222222.mFinalErrCode == 710 || e222222.mFinalErrCode == 711) {
                            z3 = z2;
                            z2 = false;
                        } else if (704 == e222222.mFinalErrCode) {
                            this.mDownloadInfo.setTotalSize(0);
                            new TMAssistantFile(this.mDownloadInfo.mTempFileName, this.mDownloadInfo.mFileName).deleteTempFile();
                            z3 = z2;
                            z2 = false;
                        } else if (705 != e222222.mFinalErrCode) {
                            z = z2;
                            z2 = shouldRetryConnect();
                            z3 = z;
                        } else if (z2 || !this.mDownloadInfo.hasRetryChance() || TextUtils.isEmpty(this.mDownloadInfo.mSecondaryUrl)) {
                            z3 = z2;
                            z2 = false;
                        } else {
                            z3 = true;
                            z2 = true;
                        }
                    }
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                        z = z3;
                        z3 = z2;
                        z2 = z;
                    } else {
                        z = z3;
                        z3 = z2;
                        z2 = z;
                    }
                } catch (Throwable th) {
                    if (this.mHttpGet != null) {
                        if (!this.mHttpGet.isAborted()) {
                            this.mHttpGet.abort();
                        }
                        this.mHttpGet = null;
                    }
                    if (this.mHttpClient != null) {
                        this.mHttpClient.getConnectionManager().shutdown();
                        this.mHttpClient = null;
                    }
                    if (this.mSaveFile != null) {
                        this.mSaveFile.close();
                        this.mSaveFile = null;
                    }
                }
            } else {
                str2 = this.mDownloadInfo.mRequestURL;
            }
            TMLog.i(TAG, "changeUrl = " + z2);
            TMLog.i(TAG, "url = " + str2);
            this.mHttpClient = HttpClientUtil.createHttpClient();
            HttpClientUtil.setProxy(this.mHttpClient);
            this.mHttpGet = new HttpGet();
            URI uri = new URI(str2);
            this.mHttpGet.setURI(uri);
            setExtraHeaderParam(this.mHttpGet, this.mDownloadInfo.getHeaderParams());
            setRangeHeader(this.mHttpGet, createNewChunkLogInfo);
            if (uri.getScheme().equals("https")) {
                SocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
                this.mHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", socketFactory, 443));
            }
            TMLog.i(TAG, "start httpGet " + Thread.currentThread().getName());
            HttpResponse execute = this.mHttpClient.execute(this.mHttpGet);
            if (execute == null) {
                throw new StopRequestException(701, "response is null! " + Thread.currentThread().getName());
            }
            handleResponseCode(execute, createNewChunkLogInfo);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (this.mHttpGet != null) {
                if (!this.mHttpGet.isAborted()) {
                    this.mHttpGet.abort();
                }
                this.mHttpGet = null;
            }
            if (this.mHttpClient != null) {
                this.mHttpClient.getConnectionManager().shutdown();
                this.mHttpClient = null;
            }
            if (this.mSaveFile != null) {
                this.mSaveFile.close();
                this.mSaveFile = null;
            }
        }
        TMLog.i(TAG, "mStopTask = " + this.mStopTask + " " + Thread.currentThread().getName());
        if (this.mStopTask) {
            this.mDownloadInfo.mDownloadFailedErrCode = 0;
        } else {
            TMLog.i(TAG, "download finished, " + Thread.currentThread().getName() + ",finalstatus: " + this.mDownloadInfo.mStatus + " errCode: " + this.mDownloadInfo.mDownloadFailedErrCode);
            if (this.mDownloadInfo.hasReceivedAllDataBytes()) {
                this.mDownloadInfo.updateStatus(4, z2);
            } else {
                this.mDownloadInfo.updateStatus(5, z2);
            }
        }
        this.mDownloadInfo.mTaskIsRunning = false;
    }

    private boolean shouldRetryConnect() {
        boolean z = false;
        if (this.mStopTask) {
            TMLog.i(TAG, "mStopTask = " + this.mStopTask);
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            if (!DownloadHelper.isNetworkConncted()) {
                int i = 0;
                while (!DownloadHelper.isNetworkConncted() && i < 5) {
                    i++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e2) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
            }
            if (DownloadHelper.isNetworkConncted()) {
                if (this.mDownloadInfo.hasRetryChance()) {
                    DownloadInfo downloadInfo = this.mDownloadInfo;
                    downloadInfo.mRetryCnt++;
                    this.mDownloadInfo.mRedirectCnt = 0;
                    try {
                        Thread.sleep(5000);
                        z = true;
                    } catch (InterruptedException e3) {
                        this.mDownloadInfo.mDownloadFailedErrCode = 600;
                    }
                }
                TMLog.i(TAG, "shouldRetryConnect(" + z + "), retryCnt = " + this.mDownloadInfo.mRetryCnt);
            } else {
                TMLog.i(TAG, "network unconnected");
            }
        }
        return z;
    }

    private void onDownloadError(Throwable th) {
        if (th != null) {
            w.printErrStackTrace(TAG, th, "", new Object[0]);
        }
    }

    private void handleResponseCode(HttpResponse httpResponse, DownloadChunkLogInfo downloadChunkLogInfo) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        TMLog.i(TAG, "httpResponseCode = " + statusCode + " " + Thread.currentThread().getName());
        downloadChunkLogInfo.readHeaderTime = System.currentTimeMillis();
        downloadChunkLogInfo.responseHttpCode = statusCode;
        if (statusCode == m.CTRL_INDEX || statusCode == v.CTRL_INDEX) {
            this.mDownloadInfo.mRetryCnt = 0;
        }
        switch (statusCode) {
            case m.CTRL_INDEX /*200*/:
                Header[] headers = httpResponse.getHeaders("Content-Type");
                if (headers != null && headers.length > 0) {
                    if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                        this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                    } else {
                        Object value = headers[0].getValue();
                        if (TextUtils.isEmpty(value) || !value.startsWith("text")) {
                            renameApkFileName(httpResponse);
                        } else {
                            throw new StopRequestException(708, "Return contenttype = text " + Thread.currentThread().getName());
                        }
                    }
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case v.CTRL_INDEX /*206*/:
                if (this.mDownloadInfo.mContentType.equals("resource/tm.android.unknown")) {
                    this.mDownloadInfo.mFileName = DownloadHelper.renameAPKFileName(this.mDownloadInfo.mFileName);
                } else {
                    renameApkFileName(httpResponse);
                }
                onReceivedResponseData(httpResponse, downloadChunkLogInfo);
                return;
            case b.CTRL_INDEX /*301*/:
            case 302:
            case 303:
            case 307:
                if (this.mDownloadInfo.mRedirectCnt > 5) {
                    TMLog.i(TAG, "mRedirectCnt = " + this.mDownloadInfo.mRedirectCnt + ",MAX_REDIRESTS = 5");
                    throw new StopRequestException(709, "Redirect cnt many times.");
                }
                Header firstHeader = httpResponse.getFirstHeader("location");
                if (firstHeader != null) {
                    String value2 = firstHeader.getValue();
                    TMLog.i(TAG, "jumpURL = " + value2);
                    if (DownloadHelper.isValidURL(value2)) {
                        this.mDownloadInfo.mRequestURL = DownloadHelper.correctURL(value2);
                        DownloadInfo downloadInfo = this.mDownloadInfo;
                        downloadInfo.mRedirectCnt++;
                        return;
                    }
                    throw new StopRequestException(700, "Jump url is not valid. httpResponseCode = " + statusCode + " url: " + value2);
                }
                TMLog.e(TAG, "location header is null. httpResponseCode = " + statusCode);
                throw new StopRequestException(702, "location header is null. httpResponseCode = " + statusCode);
            case 416:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 500:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            case 503:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
            default:
                throw new StopRequestException(statusCode, "HTTP response code error, code = " + statusCode);
        }
    }

    private boolean verifyTotalLen(HttpResponse httpResponse, HttpEntity httpEntity) {
        long contentLength;
        if (httpResponse.getStatusLine().getStatusCode() == m.CTRL_INDEX) {
            contentLength = httpEntity.getContentLength();
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1) {
                return false;
            }
            if (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue()) {
                return false;
            }
        } else if (httpResponse.getStatusLine().getStatusCode() == v.CTRL_INDEX) {
            contentLength = ByteRange.getTotalSize(httpResponse.getFirstHeader("content-range").getValue());
            TMLog.i(TAG, "verifyTotalLen,totalLen = " + contentLength + "mRequestFileSize = " + this.mDownloadInfo.mRequestFileSize);
            if (contentLength == -1) {
                return false;
            }
            if (this.mDownloadInfo.mRequestFileSize.longValue() > 0 && contentLength != this.mDownloadInfo.mRequestFileSize.longValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onReceivedResponseData(org.apache.http.HttpResponse r14, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo r15) {
        /*
        r13 = this;
        r2 = 705; // 0x2c1 float:9.88E-43 double:3.483E-321;
        r6 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r7 = 0;
        r12 = 0;
        r0 = r14.getEntity();
        r1 = r13.verifyTotalLen(r14, r0);
        if (r1 != 0) goto L_0x0022;
    L_0x0010:
        r0 = "_DownloadTask";
        r1 = "verifyTotalLen false";
        com.tencent.tmassistantsdk.util.TMLog.i(r0, r1);
        r0 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;
        r1 = "totalLen is not match the requestSize";
        r0.<init>(r2, r1);
        throw r0;
    L_0x0022:
        r1 = r13.mDownloadInfo;
        r2 = r1.getTotalSize();
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x015c;
    L_0x002e:
        r1 = r14.getStatusLine();
        r1 = r1.getStatusCode();
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x00f9;
    L_0x003a:
        r1 = r13.mDownloadInfo;
        r2 = r0.getContentLength();
        r1.setTotalSize(r2);
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPCode 200, totalBytes:";
        r2.<init>(r3);
        r3 = r13.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.i(r1, r2);
    L_0x005f:
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "first start downloadinfoTotalSize = ";
        r2.<init>(r3);
        r3 = r13.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);
        r1 = "content-range";
        r1 = r14.getFirstHeader(r1);
        if (r1 == 0) goto L_0x00a0;
    L_0x0084:
        r1 = r1.getValue();
        r1 = com.tencent.tmassistantsdk.downloadservice.ByteRange.parseContentRange(r1);
        r2 = r1.getStart();
        r15.responseRangePosition = r2;
        r2 = r1.getEnd();
        r4 = r1.getStart();
        r2 = r2 - r4;
        r4 = 1;
        r2 = r2 + r4;
        r15.responseRangeLength = r2;
    L_0x00a0:
        r1 = r13.mDownloadInfo;
        r2 = r1.getTotalSize();
        r15.responseContentLength = r2;
    L_0x00a8:
        r1 = r13.mSaveFile;
        if (r1 != 0) goto L_0x00bb;
    L_0x00ac:
        r1 = new com.tencent.tmassistantsdk.storage.TMAssistantFile;
        r2 = r13.mDownloadInfo;
        r2 = r2.mTempFileName;
        r3 = r13.mDownloadInfo;
        r3 = r3.mFileName;
        r1.<init>(r2, r3);
        r13.mSaveFile = r1;
    L_0x00bb:
        r2 = 0;
        r10 = r0.getContent();	 Catch:{ SocketException -> 0x0406 }
        r0 = "_DownloadTask";
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0406 }
        r4 = "start write file, fileName: ";
        r1.<init>(r4);	 Catch:{ SocketException -> 0x0406 }
        r4 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x0406 }
        r4 = r4.mFileName;	 Catch:{ SocketException -> 0x0406 }
        r1 = r1.append(r4);	 Catch:{ SocketException -> 0x0406 }
        r1 = r1.toString();	 Catch:{ SocketException -> 0x0406 }
        com.tencent.tmassistantsdk.util.TMLog.i(r0, r1);	 Catch:{ SocketException -> 0x0406 }
        r8 = r2;
    L_0x00dc:
        r0 = r13.mRecvBuf;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = r10.read(r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        if (r3 <= 0) goto L_0x00eb;
    L_0x00e4:
        r0 = r13.mStopTask;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        if (r0 == 0) goto L_0x0262;
    L_0x00e8:
        r10.close();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
    L_0x00eb:
        r0 = r13.mSaveFile;
        if (r0 == 0) goto L_0x00f6;
    L_0x00ef:
        r0 = r13.mSaveFile;
        r0.close();
        r13.mSaveFile = r12;
    L_0x00f6:
        r15.receiveDataSize = r8;
        return;
    L_0x00f9:
        r1 = r14.getStatusLine();
        r1 = r1.getStatusCode();
        if (r1 != r6) goto L_0x0135;
    L_0x0103:
        r1 = "content-range";
        r1 = r14.getFirstHeader(r1);
        r2 = r13.mDownloadInfo;
        r1 = r1.getValue();
        r4 = com.tencent.tmassistantsdk.downloadservice.ByteRange.getTotalSize(r1);
        r2.setTotalSize(r4);
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "HTTPCode 206, totalBytes:";
        r2.<init>(r3);
        r3 = r13.mDownloadInfo;
        r4 = r3.getTotalSize();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.i(r1, r2);
        goto L_0x005f;
    L_0x0135:
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;
        r3 = "statusCode=";
        r2.<init>(r3);
        r3 = r14.getStatusLine();
        r3 = r3.getStatusCode();
        r2 = r2.append(r3);
        r3 = " onReceivedResponseData error.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);
        goto L_0x005f;
    L_0x015c:
        r1 = r14.getStatusLine();
        r1 = r1.getStatusCode();
        if (r1 != r6) goto L_0x00a8;
    L_0x0166:
        r1 = "content-range";
        r1 = r14.getFirstHeader(r1);	 Catch:{ Throwable -> 0x0214 }
        r2 = r1.getValue();	 Catch:{ Throwable -> 0x0214 }
        r2 = com.tencent.tmassistantsdk.downloadservice.ByteRange.parseContentRange(r2);	 Catch:{ Throwable -> 0x0214 }
        r3 = r1.getValue();	 Catch:{ Throwable -> 0x0214 }
        r4 = com.tencent.tmassistantsdk.downloadservice.ByteRange.getTotalSize(r3);	 Catch:{ Throwable -> 0x0214 }
        r8 = r2.getStart();	 Catch:{ Throwable -> 0x0214 }
        r15.responseRangePosition = r8;	 Catch:{ Throwable -> 0x0214 }
        r8 = r2.getEnd();	 Catch:{ Throwable -> 0x0214 }
        r10 = r2.getStart();	 Catch:{ Throwable -> 0x0214 }
        r8 = r8 - r10;
        r10 = 1;
        r8 = r8 + r10;
        r15.responseRangeLength = r8;	 Catch:{ Throwable -> 0x0214 }
        r15.responseContentLength = r4;	 Catch:{ Throwable -> 0x0214 }
        r3 = "_DownloadTask";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0214 }
        r8 = "totalSize = ";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x0214 }
        r8 = "  downloadinfoTotalSize = ";
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r8 = r13.mDownloadInfo;	 Catch:{ Throwable -> 0x0214 }
        r8 = r8.getTotalSize();	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0214 }
        com.tencent.tmassistantsdk.util.TMLog.w(r3, r6);	 Catch:{ Throwable -> 0x0214 }
        r3 = "_DownloadTask";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0214 }
        r8 = "mReceivedBytes = ";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0214 }
        r8 = r13.mDownloadInfo;	 Catch:{ Throwable -> 0x0214 }
        r8 = r8.mReceivedBytes;	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0214 }
        com.tencent.tmassistantsdk.util.TMLog.i(r3, r6);	 Catch:{ Throwable -> 0x0214 }
        r3 = "_DownloadTask";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0214 }
        r8 = "start = ";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0214 }
        r8 = r2.getStart();	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r8 = ", end = ";
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r8 = r2.getEnd();	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.append(r8);	 Catch:{ Throwable -> 0x0214 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0214 }
        com.tencent.tmassistantsdk.util.TMLog.i(r3, r6);	 Catch:{ Throwable -> 0x0214 }
        r2 = r2.getStart();	 Catch:{ Throwable -> 0x0214 }
        r6 = r13.mDownloadInfo;	 Catch:{ Throwable -> 0x0214 }
        r8 = r6.mReceivedBytes;	 Catch:{ Throwable -> 0x0214 }
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 == 0) goto L_0x022a;
    L_0x0209:
        r0 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ Throwable -> 0x0214 }
        r1 = 706; // 0x2c2 float:9.9E-43 double:3.49E-321;
        r2 = "The received size is not equal with ByteRange.";
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0214 }
        throw r0;	 Catch:{ Throwable -> 0x0214 }
    L_0x0214:
        r0 = move-exception;
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ all -> 0x021d }
        r2 = 704; // 0x2c0 float:9.87E-43 double:3.48E-321;
        r1.<init>(r2, r0);	 Catch:{ all -> 0x021d }
        throw r1;	 Catch:{ all -> 0x021d }
    L_0x021d:
        r0 = move-exception;
        r1 = r13.mSaveFile;
        if (r1 == 0) goto L_0x0229;
    L_0x0222:
        r1 = r13.mSaveFile;
        r1.close();
        r13.mSaveFile = r12;
    L_0x0229:
        throw r0;
    L_0x022a:
        r2 = r13.mDownloadInfo;	 Catch:{ Throwable -> 0x0214 }
        r2 = r2.getTotalSize();	 Catch:{ Throwable -> 0x0214 }
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x023f;
    L_0x0234:
        r0 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ Throwable -> 0x0214 }
        r1 = 705; // 0x2c1 float:9.88E-43 double:3.483E-321;
        r2 = "The total size is not equal with ByteRange.";
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0214 }
        throw r0;	 Catch:{ Throwable -> 0x0214 }
    L_0x023f:
        r2 = "_DownloadTask";
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0214 }
        r4 = "response ByteRange: ";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0214 }
        r1 = r3.append(r1);	 Catch:{ Throwable -> 0x0214 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0214 }
        com.tencent.tmassistantsdk.util.TMLog.d(r2, r1);	 Catch:{ Throwable -> 0x0214 }
        r1 = r13.mSaveFile;
        if (r1 == 0) goto L_0x00a8;
    L_0x0259:
        r1 = r13.mSaveFile;
        r1.close();
        r13.mSaveFile = r12;
        goto L_0x00a8;
    L_0x0262:
        r0 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = (long) r3;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0 + r4;
        r2 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r2.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x03be;
    L_0x0272:
        r2 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r2.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0315;
    L_0x027c:
        r6 = 1;
    L_0x027d:
        r0 = r13.mSaveFile;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mRecvBuf;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = 0;
        r4 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r4.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.write(r1, r2, r3, r4, r6);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        if (r0 != 0) goto L_0x03b4;
    L_0x028c:
        r0 = com.tencent.tmassistantsdk.storage.TMAssistantFile.getSavePathRootDir();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r1.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = com.tencent.tmassistantsdk.downloadservice.DownloadHelper.isSpaceEnough(r0, r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        if (r0 == 0) goto L_0x0367;
    L_0x029c:
        r0 = com.tencent.tmassistantsdk.storage.TMAssistantFile.isSDCardExistAndCanWrite();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        if (r0 == 0) goto L_0x0318;
    L_0x02a2:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "write file failed, fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = 703; // 0x2bf float:9.85E-43 double:3.473E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        throw r1;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
    L_0x02ef:
        r0 = move-exception;
        r2 = r8;
    L_0x02f1:
        r1 = "_DownloadTask";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0305 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r4, r5);	 Catch:{ all -> 0x0305 }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ all -> 0x0305 }
        r4 = 605; // 0x25d float:8.48E-43 double:2.99E-321;
        r1.<init>(r4, r0);	 Catch:{ all -> 0x0305 }
        throw r1;	 Catch:{ all -> 0x0305 }
    L_0x0305:
        r0 = move-exception;
        r8 = r2;
    L_0x0307:
        r1 = r13.mSaveFile;
        if (r1 == 0) goto L_0x0312;
    L_0x030b:
        r1 = r13.mSaveFile;
        r1.close();
        r13.mSaveFile = r12;
    L_0x0312:
        r15.receiveDataSize = r8;
        throw r0;
    L_0x0315:
        r6 = r7;
        goto L_0x027d;
    L_0x0318:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "write file failed, no sdCard! fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = 711; // 0x2c7 float:9.96E-43 double:3.513E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        throw r1;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
    L_0x0365:
        r0 = move-exception;
        goto L_0x0307;
    L_0x0367:
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "write file failed, no enough space! fileName: ";
        r0.<init>(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r1.mFileName;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " receivedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r1.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " readedSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = " totalSize: ";
        r0 = r0.append(r1);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r1.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.append(r2);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = "_DownloadTask";
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = 710; // 0x2c6 float:9.95E-43 double:3.51E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        throw r1;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
    L_0x03b4:
        r0 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = (long) r3;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0.updateReceivedSize(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r0 = (long) r3;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r8 = r8 + r0;
        goto L_0x00dc;
    L_0x03be:
        r0 = "write file size too long.";
        r1 = "_DownloadTask";
        r2 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = "write file size too long.\r\nreadedLen: ";
        r2.<init>(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = "\r\nreceivedSize: ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r3.mReceivedBytes;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r2.append(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = "\r\ntotalSize: ";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = r13.mDownloadInfo;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r4 = r3.getTotalSize();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r2.append(r4);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r3 = "\r\nisTheEndData: false";
        r2 = r2.append(r3);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = r2.toString();	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        com.tencent.tmassistantsdk.util.TMLog.w(r1, r2);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r1 = new com.tencent.tmassistantsdk.downloadservice.StopRequestException;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        r2 = 703; // 0x2bf float:9.85E-43 double:3.473E-321;
        r1.<init>(r2, r0);	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
        throw r1;	 Catch:{ SocketException -> 0x02ef, all -> 0x0365 }
    L_0x0406:
        r0 = move-exception;
        goto L_0x02f1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.downloadservice.DownloadTask.onReceivedResponseData(org.apache.http.HttpResponse, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo):void");
    }

    private void setRangeHeader(HttpGet httpGet, DownloadChunkLogInfo downloadChunkLogInfo) {
        String netStatus = DownloadHelper.getNetStatus();
        this.mDownloadInfo.mNetType = netStatus;
        if (TextUtils.isEmpty(netStatus) || (!netStatus.contains("wap") && (!netStatus.contains("net") || this.mDownloadInfo.mRetryCnt <= 0))) {
            netStatus = "bytes=" + this.mDownloadInfo.mReceivedBytes + "-";
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = this.mDownloadInfo.mReceivedBytes;
            downloadChunkLogInfo.requestRanageSize = 0;
            return;
        }
        try {
            long j;
            int splitSizeInBytes = DownloadSetting.getSplitSizeInBytes(netStatus);
            long j2 = this.mDownloadInfo.mReceivedBytes;
            if (this.mDownloadInfo.getTotalSize() > 0) {
                j = (this.mDownloadInfo.mReceivedBytes + ((long) splitSizeInBytes)) - 1;
                if (j >= this.mDownloadInfo.getTotalSize()) {
                    j = this.mDownloadInfo.getTotalSize() - 1;
                }
            } else {
                j = (long) (splitSizeInBytes - 1);
            }
            netStatus = "bytes=" + j2 + "-" + j;
            httpGet.addHeader("range", netStatus);
            TMLog.d(TAG, "set range header: " + netStatus);
            downloadChunkLogInfo.responseContentLength = this.mDownloadInfo.getTotalSize();
            downloadChunkLogInfo.requestRanagePosition = j2;
            downloadChunkLogInfo.requestRanageSize = (long) splitSizeInBytes;
        } catch (Throwable e) {
            w.printErrStackTrace(TAG, e, "", new Object[0]);
        }
    }

    private void renameApkFileName(HttpResponse httpResponse) {
        if (httpResponse != null && this.mDownloadInfo.mContentType.equals("application/vnd.android.package-archive")) {
            Object obj = null;
            Header[] headers = httpResponse.getHeaders("Content-Disposition");
            if (headers == null || headers.length <= 0) {
                obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
            } else {
                String value = headers[0].getValue();
                TMLog.i(TAG, "headerFileName = " + value);
                if (TextUtils.isEmpty(value) || !value.contains("filename=\"")) {
                    obj = DownloadHelper.genAPKFileName(this.mDownloadInfo.mRequestURL);
                } else {
                    value = value.substring(value.indexOf("filename=\"") + 10);
                    if (!TextUtils.isEmpty(value)) {
                        obj = value.substring(0, value.indexOf("\""));
                        TMLog.i(TAG, "header file Name =" + obj);
                    }
                }
            }
            if (!TextUtils.isEmpty(obj)) {
                this.mDownloadInfo.mFileName = DownloadHelper.correctFileName(DownloadHelper.decodeFileName(obj));
            }
        }
    }

    private void setExtraHeaderParam(HttpGet httpGet, Map<String, String> map) {
        if (httpGet != null && map != null && map.size() > 0) {
            for (Entry entry : map.entrySet()) {
                httpGet.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
