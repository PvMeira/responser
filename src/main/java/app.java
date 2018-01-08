import com.batata.responser.exception.model.Error;
import com.batata.responser.model.ResponseJson;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args){

        List<Error> meee = new ArrayList<Error>();
        meee.add(new Error("some error"));
        meee.add( new Error("another error"));
        ResponseJson meh;

        System.out.println("init");

        meh = ResponseJson.build().withBody("").withMeta("").create();
        System.out.println("Teste1:" + meh);

        meh = ResponseJson.build()
                           .withErrors(meee.toArray(new Error[meee.size()]))
                           .withMeta(new Error("meeeeeeeeeeeeeeeeh"))
                           .create();
        System.out.println("\n\nTeste2:" + meh);


        meh = ResponseJson.build()
                           .withoutContent()
                           .create();
        System.out.println("\n\nTeste3:" +meh);


        meh = ResponseJson.build()
                           .withErrors(new Error("another error"))
                           .create();
        System.out.println("\n\nTeste4:" +meh);


    }

}
