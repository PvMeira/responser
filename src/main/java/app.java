import com.batata.responser.model.ResponseJson2;

import java.util.ArrayList;

public class app {
    public static void main(String[] args){

        System.out.println("init");
        ResponseJson2<String, String> meh;
        meh = new ResponseJson2.ResponseBuilder()
                               .withBody(new ArrayList())
                               .withMeta("meh")
                               .create();



    }

}
