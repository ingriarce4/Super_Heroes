package cl.desafiolatam.asuper.servicio;

import java.util.List;

import cl.desafiolatam.asuper.modelo.HeroesItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HeroeServicio {

    @GET("all.json")
    //Call Api
    public Call<List<HeroesItem>> getHeores();


}
