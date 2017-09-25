package com.tencent.tmassistantsdk.downloadservice;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.DBManager;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

public class DownloadInfo {
    public static final String CONTENTTYPE = "contentType";
    public static final String DOWNLOADFAILEDERRCODE = "downloadFailedErrCode";
    public static final String DOWNLOADFAILEDTIME = "downloadFailedTime";
    public static final String FILENAME = "fileName";
    public static final String FINALURL = "finalUrl";
    public static final String HEADERPARAMS = "headerParams";
    public static final String NETTYPE = "netType";
    public static final String PRIORITY = "priority";
    public static final String RECEIVEDBYTES = "receivedBytes";
    public static final String REDIRECTCNT = "redirectCnt";
    public static final String REQUESTFILESIZE = "requestFileSize";
    public static final String RETRYCNT = "retryCnt";
    public static final String SECONDARYURL = "secondaryUrl";
    public static final String STATUS = "status";
    public static final String TAG = "_DownloadInfo";
    public static final String TASKID = "taskId";
    public static final String TASKURL = "taskUrl";
    public static final String TOTALBYTES = "totalBytes";
    public static final String UID = "uId";
    private boolean mAutoRetry;
    public String mContentType;
    public int mDownloadFailedErrCode;
    public long mDownloadFailedTime;
    public int mDownloadTaskId;
    public String mFileName;
    private String mHeaderParamString;
    private HashMap<String, String> mHeaderParams;
    public String mNetType;
    public int mPriority;
    public long mReceivedBytes;
    public int mRedirectCnt;
    public Long mRequestFileSize;
    public String mRequestURL;
    public int mRetryCnt;
    public String mSecondaryUrl;
    public int mStatus;
    boolean mTaskIsRunning;
    protected String mTempFileName;
    protected long mTotalBytes;
    public String mURL;
    public String mUUID;

    public void dump(String str) {
        TMLog.i(str, "--------dump DownloadInfo-----------");
        TMLog.i(str, "mContentType: " + this.mContentType);
        TMLog.i(str, "mURL: " + this.mURL);
        TMLog.i(str, "mRequestURL: " + this.mRequestURL);
        TMLog.i(str, "mSecondaryUrl: " + this.mSecondaryUrl);
        TMLog.i(str, "mRequestFileSize: " + this.mRequestFileSize);
        TMLog.i(str, "mRetryCnt: " + this.mRetryCnt);
        TMLog.i(str, "mRedirectCnt: " + this.mRedirectCnt);
        TMLog.i(str, "mTotalBytes: " + this.mTotalBytes);
        TMLog.i(str, "mUUID: " + this.mUUID);
        TMLog.i(str, "mStatus: " + this.mStatus);
        TMLog.i(str, "mReceivedBytes: " + this.mReceivedBytes);
        TMLog.i(str, "mFileName: " + this.mFileName);
        TMLog.i(str, "mDownloadFailedErrCode: " + this.mDownloadFailedErrCode);
        TMLog.i(str, "mNetType:" + this.mNetType);
        TMLog.i(str, "mDownloadFailedTime:" + this.mDownloadFailedTime);
        TMLog.i(str, "mHeaderParamString:" + this.mHeaderParamString);
    }

    public DownloadInfo() {
        this.mAutoRetry = false;
        this.mTaskIsRunning = false;
    }

    public void setHeaderParams(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            this.mHeaderParams = hashMap;
            this.mHeaderParamString = new JSONObject(hashMap).toString();
        }
    }

    public HashMap<String, String> getHeaderParams() {
        return this.mHeaderParams;
    }

    public void setTotalSize(long j) {
        if (0 == j) {
            this.mReceivedBytes = 0;
        }
        this.mTotalBytes = j;
        DBManager.getInstance().addDownloadInfo(this);
    }

    public long getTotalSize() {
        return this.mTotalBytes;
    }

    public DownloadInfo(String str, String str2, long j, int i, String str3) {
        this.mAutoRetry = false;
        this.mURL = str;
        this.mSecondaryUrl = str2;
        this.mRequestURL = DownloadHelper.correctURL(str);
        this.mRequestFileSize = Long.valueOf(j);
        this.mUUID = UUID.randomUUID().toString();
        this.mPriority = i;
        this.mStatus = 0;
        this.mDownloadFailedErrCode = 0;
        this.mTaskIsRunning = false;
        this.mContentType = str3;
        this.mNetType = DownloadHelper.getNetStatus();
        this.mDownloadFailedTime = 0;
    }

    boolean hasReceivedAllDataBytes() {
        TMLog.i(TAG, "mTotalBytes = " + this.mTotalBytes + ", mReceivedBytes = " + this.mReceivedBytes);
        return this.mTotalBytes != 0 && this.mReceivedBytes == this.mTotalBytes;
    }

    boolean hasRetryChance() {
        return this.mRetryCnt <= 5;
    }

    boolean hasFinished() {
        return this.mStatus > 3;
    }

    public int startDownloadIfReady() {
        return startDownloadIfReady(false);
    }

    public int startDownloadIfReady(boolean z) {
        TMLog.i(TAG, "DownloadInfo::startDownloadIfReady url: " + this.mURL);
        if (!TextUtils.isEmpty(this.mHeaderParamString) && (this.mHeaderParams == null || this.mHeaderParams.size() <= 0)) {
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(this.mHeaderParamString);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject.getString(str));
                }
                if (hashMap.size() > 0) {
                    this.mHeaderParams = hashMap;
                }
            } catch (Throwable e) {
                w.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        if (this.mTaskIsRunning) {
            return 5;
        }
        this.mAutoRetry = z;
        TMLog.i(TAG, "autoRetry = " + this.mAutoRetry);
        if (this.mFileName == null) {
            this.mFileName = DownloadHelper.generateFileNameFromURL(this.mURL, this.mContentType);
        }
        if (this.mTempFileName == null) {
            this.mTempFileName = DownloadHelper.generateFileNameFromURL(this.mURL, this.mContentType);
        }
        if (this.mTotalBytes == 0) {
            new TMAssistantFile(this.mTempFileName, this.mFileName).deleteTempFile();
        }
        TMLog.i(TAG, "mFileName = " + this.mFileName);
        TMLog.i(TAG, "mTempFileName = " + this.mTempFileName);
        TMLog.i(TAG, "mTotalBytes = " + this.mTotalBytes + ", mStatus = " + this.mStatus);
        if (this.mStatus == 5) {
            this.mRequestURL = this.mURL;
        }
        if (!TextUtils.isEmpty(this.mFileName)) {
            TMAssistantFile tMAssistantFile = new TMAssistantFile(this.mTempFileName, this.mFileName);
            long length = tMAssistantFile.length();
            TMLog.i(TAG, "FileLen: " + length + " filename: " + this.mFileName);
            if (length > this.mTotalBytes) {
                tMAssistantFile.deleteTempFile();
                this.mReceivedBytes = 0;
            } else {
                this.mReceivedBytes = length;
            }
            if (hasReceivedAllDataBytes()) {
                tMAssistantFile.moveFileToSavaPath();
                updateStatus(4, false);
                return 4;
            }
        }
        if (this.mStatus == 5) {
            this.mRedirectCnt = 0;
            this.mRetryCnt = 0;
            this.mStatus = 0;
            this.mDownloadFailedErrCode = 0;
        }
        TMLog.i(TAG, "startDownloadIfReady...");
        dump(TAG);
        if (DownloadThreadPool.getInstance().getDownloadTask(this.mURL) == null) {
            TMLog.i(TAG, "dt is null");
            DownloadTask downloadTask = new DownloadTask(this);
            updateStatus(1, false);
            this.mDownloadTaskId = DownloadThreadPool.getInstance().addDownloadTask(downloadTask);
        }
        return 0;
    }

    public void pauseDownload() {
        TMLog.i(TAG, "DownloadInfo::pauseDownload url: " + this.mURL);
        DownloadThreadPool.getInstance().cancelDownloadTask(this.mDownloadTaskId);
        updateStatus(3, false);
    }

    public void stopDownload() {
        TMLog.i(TAG, "DownloadInfo::stopDownload url: " + this.mURL);
        DownloadThreadPool.getInstance().cancelDownloadTask(this.mDownloadTaskId);
        updateStatus(6, false);
    }

    public synchronized void updateStatus(int i, boolean z) {
        if (!hasFinished()) {
            this.mStatus = i;
            if (this.mStatus != 6) {
                if (this.mStatus == 5) {
                    this.mDownloadFailedTime = System.currentTimeMillis();
                }
                DBManager.getInstance().addDownloadInfo(this);
                DownloadListenerManager.getInstance().OnDownloadStateChanged(this.mURL, this.mStatus, this.mDownloadFailedErrCode, "", z, this.mAutoRetry);
            } else {
                DBManager.getInstance().deleteDownloadInfo(this.mURL);
            }
        }
    }

    public void updateReceivedSize(long j) {
        this.mReceivedBytes += j;
        DownloadListenerManager.getInstance().OnDownloadProgressChanged(this.mURL, this.mReceivedBytes, this.mTotalBytes);
    }

    public static DownloadInfo readFromCursor(Cursor cursor) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.mDownloadTaskId = cursor.getInt(cursor.getColumnIndex("taskId"));
        downloadInfo.mUUID = cursor.getString(cursor.getColumnIndex(UID));
        downloadInfo.mRequestURL = cursor.getString(cursor.getColumnIndex(FINALURL));
        downloadInfo.mURL = cursor.getString(cursor.getColumnIndex("taskUrl"));
        downloadInfo.mSecondaryUrl = cursor.getString(cursor.getColumnIndex(SECONDARYURL));
        downloadInfo.mRequestFileSize = Long.valueOf(cursor.getLong(cursor.getColumnIndex(REQUESTFILESIZE)));
        downloadInfo.mFileName = cursor.getString(cursor.getColumnIndex(FILENAME));
        downloadInfo.mContentType = cursor.getString(cursor.getColumnIndex(CONTENTTYPE));
        downloadInfo.mRedirectCnt = cursor.getInt(cursor.getColumnIndex(REDIRECTCNT));
        downloadInfo.mRetryCnt = cursor.getInt(cursor.getColumnIndex(RETRYCNT));
        downloadInfo.mTotalBytes = cursor.getLong(cursor.getColumnIndex(TOTALBYTES));
        downloadInfo.mStatus = cursor.getInt(cursor.getColumnIndex(STATUS));
        downloadInfo.mReceivedBytes = cursor.getLong(cursor.getColumnIndex(RECEIVEDBYTES));
        downloadInfo.mPriority = cursor.getInt(cursor.getColumnIndex(PRIORITY));
        downloadInfo.mNetType = cursor.getString(cursor.getColumnIndex(NETTYPE));
        downloadInfo.mDownloadFailedErrCode = cursor.getInt(cursor.getColumnIndex(DOWNLOADFAILEDERRCODE));
        downloadInfo.mDownloadFailedTime = cursor.getLong(cursor.getColumnIndex(DOWNLOADFAILEDTIME));
        downloadInfo.mHeaderParamString = cursor.getString(cursor.getColumnIndex(HEADERPARAMS));
        return downloadInfo;
    }

    public static DownloadInfo readFromSimpleCursor(Cursor cursor) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.mDownloadTaskId = cursor.getInt(cursor.getColumnIndex("taskId"));
        downloadInfo.mUUID = cursor.getString(cursor.getColumnIndex(UID));
        downloadInfo.mRequestURL = cursor.getString(cursor.getColumnIndex(FINALURL));
        downloadInfo.mURL = cursor.getString(cursor.getColumnIndex("taskUrl"));
        downloadInfo.mSecondaryUrl = cursor.getString(cursor.getColumnIndex(SECONDARYURL));
        downloadInfo.mRequestFileSize = Long.valueOf(cursor.getLong(cursor.getColumnIndex(REQUESTFILESIZE)));
        downloadInfo.mFileName = cursor.getString(cursor.getColumnIndex(FILENAME));
        downloadInfo.mContentType = cursor.getString(cursor.getColumnIndex(CONTENTTYPE));
        downloadInfo.mRedirectCnt = cursor.getInt(cursor.getColumnIndex(REDIRECTCNT));
        downloadInfo.mRetryCnt = cursor.getInt(cursor.getColumnIndex(RETRYCNT));
        downloadInfo.mTotalBytes = cursor.getLong(cursor.getColumnIndex(TOTALBYTES));
        downloadInfo.mStatus = cursor.getInt(cursor.getColumnIndex(STATUS));
        downloadInfo.mReceivedBytes = cursor.getLong(cursor.getColumnIndex(RECEIVEDBYTES));
        downloadInfo.mPriority = cursor.getInt(cursor.getColumnIndex(PRIORITY));
        downloadInfo.mNetType = null;
        downloadInfo.mDownloadFailedErrCode = 0;
        downloadInfo.mDownloadFailedTime = 0;
        downloadInfo.mHeaderParamString = null;
        return downloadInfo;
    }

    public static void writeToContentValues(ContentValues contentValues, DownloadInfo downloadInfo) {
        if (downloadInfo != null && contentValues != null) {
            contentValues.put("taskId", Integer.valueOf(downloadInfo.mDownloadTaskId));
            contentValues.put(UID, downloadInfo.mUUID);
            contentValues.put(FINALURL, downloadInfo.mRequestURL);
            contentValues.put("taskUrl", downloadInfo.mURL);
            contentValues.put(SECONDARYURL, downloadInfo.mSecondaryUrl);
            contentValues.put(REQUESTFILESIZE, downloadInfo.mRequestFileSize);
            contentValues.put(FILENAME, downloadInfo.mFileName);
            contentValues.put(CONTENTTYPE, downloadInfo.mContentType);
            contentValues.put(REDIRECTCNT, Integer.valueOf(downloadInfo.mRedirectCnt));
            contentValues.put(RETRYCNT, Integer.valueOf(downloadInfo.mRetryCnt));
            contentValues.put(TOTALBYTES, Long.valueOf(downloadInfo.mTotalBytes));
            contentValues.put(STATUS, Integer.valueOf(downloadInfo.mStatus));
            contentValues.put(RECEIVEDBYTES, Long.valueOf(downloadInfo.mReceivedBytes));
            contentValues.put(PRIORITY, Integer.valueOf(downloadInfo.mPriority));
            contentValues.put(NETTYPE, downloadInfo.mNetType);
            contentValues.put(DOWNLOADFAILEDERRCODE, Integer.valueOf(downloadInfo.mDownloadFailedErrCode));
            contentValues.put(DOWNLOADFAILEDTIME, Long.valueOf(downloadInfo.mDownloadFailedTime));
            contentValues.put(HEADERPARAMS, downloadInfo.mHeaderParamString);
        }
    }
}
