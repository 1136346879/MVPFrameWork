package com.news.sub;

import com.google.gson.reflect.TypeToken;
import com.hexun.base.data.ApiResult;
import com.hexun.base.data.ApiResultBody;
import com.hexun.base.data.ApiResultConverter;
import com.hexun.base.rx.RxComposer;
import com.lzy.okgo.OkGo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hexun on 2017/9/20.
 */
public class SubModuleApi {

    private static SubModuleApi INSTANCE = new SubModuleApi();

    public static SubModuleApi getInstance() {
        return INSTANCE;
    }

    private SubModuleApi() {
    }


    private static final String URL= "http://api.cd.hexun.com/cq/financearticle/recommendarticles/0/0/20";


    public static Observable<List<Article>> getRecommendData(){

        return OkGo.<ApiResult<List<Article>>>get(URL).headers("a","a").params("b","b")
                .converter(new ApiResultConverter<List<Article>>(new TypeToken<List<Article>>() {}.getType()))
                .adapt(new ApiResultBody<List<Article>>())
                .compose(RxComposer.<List<Article>>dealThreadError());
    }



    public static Observable<Article> getRecommendData2(){
        return OkGo.<ApiResult<Article>>get(URL).headers("a","a").params("b","b")
                .converter(new ApiResultConverter<Article>(Article.class))
                .adapt(new ApiResultBody<Article>())
                .compose(RxComposer.<Article>dealThreadError());
    }

}
