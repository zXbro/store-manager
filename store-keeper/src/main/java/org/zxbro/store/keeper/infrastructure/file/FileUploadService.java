package org.zxbro.store.keeper.infrastructure.file;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class FileUploadService {
    @Value("${imgurl.url")
    private String url;
    @Value("${imgurl.uid")
    private String uid;
    @Value("imgurl.token")
    private String token;

    public void postImage(String name, File file) {
        OkHttpClient client = new OkHttpClient();

        MultipartBody mBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                /* 上传一个普通的String参数 , key 叫 "p" */
                .addFormDataPart("uid", uid)
                .addFormDataPart("token", token)
                /* 底下是上传了两个文件 */
                .addFormDataPart("file", name, RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();

        /* 下边的就和post同样了 */
        Request request = new Request.Builder().url(url).post(mBody).build();
        client.newCall(request).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                final String bodyStr = response.body().string();
                log.info("success");
            }

            public void onFailure(Call call, final IOException e) {
                log.error("failure");
            }
        });
    }

}
