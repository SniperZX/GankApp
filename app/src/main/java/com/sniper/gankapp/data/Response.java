package com.sniper.gankapp.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30 0030.
 */

public class Response {

    /**
     * error : false
     */

    @SerializedName("error")
    private boolean error;


    @SerializedName("results")
    private List<Result> results;

    public static Response objectFromData(String str) {

        return new Gson().fromJson(str, Response.class);
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }


}
