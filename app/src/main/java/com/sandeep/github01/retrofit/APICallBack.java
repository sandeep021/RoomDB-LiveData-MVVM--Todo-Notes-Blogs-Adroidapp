package com.sandeep.github01.retrofit;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.sandeep.github01.activity.MainActivity;


public class APICallBack extends AsyncTask<Void, Void, Object> {


    private Context context;
    private CallBackInterface callBack;
    private BaseDataModel baseData;

    public APICallBack(Context context, CallBackInterface callBack, BaseDataModel baseData) {
        this.context = context;
        this.callBack = callBack;
        this.baseData = baseData;
    }

    @Override
    protected Object doInBackground(Void... voids) {
        if (baseData.getObject() != null) {
            Log.d("!!!!!!!!!!!!!", "TAG INPUT " + baseData.getTag() + " " + new Gson().toJson(baseData.getObject()));
        }
        try {
            switch (baseData.getTag()) {
//                case Constants.CITIES:
//                    return BackgroundTaskUtility.callCitiesAPI(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object object) {
        super.onPostExecute(object);
        if (object == null) return;

        if (object instanceof APIErrorResponse) {
            if (((APIErrorResponse) object).getCode() == 403) {
                if (context instanceof MainActivity) {
//                    ((MainActivity)context).logout();
                }
            } else
                callBack.onErrorResponse(object, baseData.getTag());
        } else {
            Log.d("!!!!!!!!!!!!!", "TAG OUTPUT " + baseData.getTag() + " " + new Gson().toJson(object));
            callBack.onSuccessResponse(object, baseData.getTag());
        }
    }
}