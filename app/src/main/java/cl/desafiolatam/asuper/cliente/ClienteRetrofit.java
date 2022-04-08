package cl.desafiolatam.asuper.cliente;

import cl.desafiolatam.asuper.servicio.HeroeServicio;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClienteRetrofit {
    //Hacemos Singleton

        private static Retrofit instance;

        //hacemos un constructor
        private ClienteRetrofit(){}

        public static HeroeServicio getInstance()
        {
            if(instance== null){
                instance= new Retrofit.Builder()
                        .baseUrl("https://akabab.github.io/superhero-api/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

            }
            return instance.create(HeroeServicio.class);
    }


}
