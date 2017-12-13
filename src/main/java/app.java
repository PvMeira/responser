import com.batata.responser.exception.model.Error;
import com.batata.responser.model.ResponseJson2;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args){

        System.out.println("init");
        ResponseJson2<String, String> meh;
        meh = new ResponseJson2.ContentBuilder<String, String>()
                               .withBody("Batata")
                               .withMeta("meh")
                               .create();
        System.out.println("Teste1:" + meh);

        List<Error> meee = new ArrayList();
        meee.add(new Error("some error"));
        meee.add( new Error("another error"));


        meh = new ResponseJson2.ContentBuilder<String, String>()
                .withErrors(meee.toArray(new Error[meee.size()]))
                .withMeta(new Error("meeeeeeeeeeeeeeeeh"))
                .create();
        System.out.println("\n\nTeste2:" + meh);



        meh = new ResponseJson2.ContentBuilder<String, String>()
                .withErrors(meee.toArray(new Error[meee.size()]))
                .withBody("somenthing")
                .withMeta(new Error("meeeeeeeeeeeeeeeeh"))
                .create();
        System.out.println("\n\nTeste3:" +meh);
    }

}
