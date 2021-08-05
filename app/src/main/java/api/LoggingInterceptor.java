package api;

import android.app.DownloadManager;
import android.util.Log;
import android.view.textclassifier.TextLinks;

import androidx.constraintlayout.solver.widgets.Chain;

import com.google.android.gms.common.api.Response;

import java.io.IOException;

public class LoggingInterceptor implements  {
    @Override
    public Response intercept(Chain chain) throws IOException{
        TextLinks.Request request = chain.request();
        long t1 = System.nanoTime();
        String requestLog = String.format("Sending request % on %s%n%s",
                request.url(), chain.connection(), request.headers());
        if (request.method().compareToIgnoreCase("post")==0) {
            requestLog = "\n" + requestLog + "\n" + bodyToString(request);

        }
        Log.d("TAG", "request" + "\n" + requestLog);

        Response response =  chain.proceed(request);
        long t2 = System.nanoTime();
        String responLog = String.format("Received response for %s in %.lfms%n%s" ,
                response.request().url(), (t2-t1) / 1e6d, response.headers());

        String bodyString = response.body().string();
        Log.d("TAG", "response" + "\n" + responLog + "\n" + bodyString);
        return response.newBuilder()
                .body(ResponseBody.create(response.body().contentType(), bodyString))
                .build();
    }

    public static String bodyToString (final Request request) {
        try{
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        }catch (final IOException e){
            return "did not work";
        }
    }
}

